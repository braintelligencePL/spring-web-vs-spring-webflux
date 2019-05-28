package pl.braintelligence.domain

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.body
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.reactive.function.server.ServerRequest
import pl.braintelligence.infrastructure.dto.NewProduct
import reactor.core.publisher.Mono


@Component
class ProductHandler {

    val webClient: WebClient = WebClient.builder()
            .baseUrl("http://localhost:8000")
            .build()

    fun createProduct(req: ServerRequest): Mono<Product> {
        return webClient.post()
                .uri("/products")
                .body(req.bodyToMono(NewProduct::class.java))
                .accept(MediaType.APPLICATION_JSON)

//                .exchange()
//                .flatMap { it -> it.bodyToMono(Product::class.java) }
                
//                .exchange()
//                .flatMap { it.bodyToMono(Product::class.java) }

//                .retrieve()
//                .bodyToMono(Product::class.java)

//                .retrieve()
//                .bodyToMono<Product>()

                .retrieve()
                .bodyToMono()
    }
}
