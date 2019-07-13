package pl.braintelligence.domain

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.body
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import pl.braintelligence.infrastructure.dto.NewProduct
import reactor.core.publisher.Mono

@Component
class ProductHandler(
        @Value("\${product-store.base-url}") private val productStoreBaseUrl: String
) {

    val webClient: WebClient = WebClient.builder()
            .baseUrl(productStoreBaseUrl)
            .build()

    fun createProduct(req: ServerRequest): Mono<ServerResponse> =
            run {
                webClient.post()
                        .uri("/products")
                        .body(req.bodyToMono(NewProduct::class.java))
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(NewProduct::class.java)
            }.let {
                ServerResponse.ok().body(it)
            }
}
