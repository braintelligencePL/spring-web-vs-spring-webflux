package pl.braintelligence.domain

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import java.util.*


@Component
class ProductHandler {

    private val products = Flux.just(Product(UUID.randomUUID().toString(), "name", "123"))

    private val client = WebClient.create("http://localhost:8000")

    var result = client.post()
            .uri("/products").accept(MediaType.APPLICATION_JSON)
            .exchange()
            .flatMap { it.toEntity(Product::class.java) }

    fun createProduct(req: ServerRequest) = ServerResponse.ok()
            .body(result)

}
