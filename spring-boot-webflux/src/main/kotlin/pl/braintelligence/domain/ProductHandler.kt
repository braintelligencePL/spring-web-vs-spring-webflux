package pl.braintelligence.domain

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import java.util.*


@Component
class ProductHandler {

    private val products = Flux.just(Product(UUID.randomUUID().toString(), "name", "123"))

    fun hello(req: ServerRequest) = ServerResponse.ok()
            .body(products)

}
