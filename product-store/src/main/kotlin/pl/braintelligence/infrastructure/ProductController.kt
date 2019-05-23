package pl.braintelligence.infrastructure

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.domain.Product
import pl.braintelligence.domain.ProductService
import pl.braintelligence.infrastructure.dto.NewProduct
import reactor.core.publisher.Mono

@RestController("products")
class ProductController(
        private val productService: ProductService
) {

    @PostMapping
    fun createProduct(@RequestBody product: Mono<NewProduct>): Mono<Product> =
            productService.createProduct(product)

}

