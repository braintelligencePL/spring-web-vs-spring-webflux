package pl.braintelligence.domain

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.http.MediaType
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.body
import org.springframework.web.reactive.function.server.ServerRequest
import pl.braintelligence.infrastructure.dto.NewProduct
import reactor.core.publisher.Mono
import reactor.netty.http.client.HttpClient
import reactor.netty.tcp.TcpClient


@Component
class ProductHandler {

    val tcpClient: TcpClient = TcpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30_000)
            .doOnConnected {
                it.addHandlerLast(ReadTimeoutHandler(3000))
                it.addHandlerLast(WriteTimeoutHandler(3000))
            }.doOnConnect { }

    val webClient: WebClient = WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(HttpClient.from(tcpClient)))
            .baseUrl("http://localhost:8000")
            .build()

    private val client = WebClient.create("http://localhost:8000")

    fun createProduct(req: ServerRequest): Mono<Product> {

        val newProduct = req.bodyToMono(NewProduct::class.java)

        return webClient.post()
                .uri("/products")
                .body(newProduct)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap { it.bodyToMono(Product::class.java) }

    }
}
