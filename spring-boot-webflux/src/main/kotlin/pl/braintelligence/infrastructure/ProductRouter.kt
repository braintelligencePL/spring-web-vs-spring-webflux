package pl.braintelligence.infrastructure

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import pl.braintelligence.domain.Product
import pl.braintelligence.domain.ProductHandler

@Configuration
class ProductRouter(
        private val productHandler: ProductHandler
) {

    @Bean
    fun router() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            POST("/products") {
                val productRouter= productHandler.createProduct(it)
                return@POST ServerResponse.ok().body(productRouter)
            }
        }
    }

}
