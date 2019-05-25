package pl.braintelligence.domain

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.body
import org.springframework.web.reactive.function.server.ServerRequest
import pl.braintelligence.infrastructure.dto.NewProduct
import reactor.core.publisher.Mono

@Component
class ProductHandler {

    private val client = WebClient.create("http://localhost:8000")


    fun createProduct(req: ServerRequest): Mono<Product> {

        val newProduct = req.bodyToMono(NewProduct::class.java)

        return client.post()
                .uri("/products")
                .body(newProduct)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap { it.bodyToMono(Product::class.java) }

    }


}
