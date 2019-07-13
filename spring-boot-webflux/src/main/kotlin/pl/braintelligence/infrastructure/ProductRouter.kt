package pl.braintelligence.infrastructure

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router
import pl.braintelligence.domain.ProductHandler
import org.springframework.http.MediaType.APPLICATION_JSON


@Configuration
class ProductRouter(
        private val productHandler: ProductHandler
) {

    @Bean
    fun router() = router {
        accept(APPLICATION_JSON).nest {
            POST("/products", productHandler::createProduct)
        }
    }


}
