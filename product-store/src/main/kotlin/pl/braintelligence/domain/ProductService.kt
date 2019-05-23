package pl.braintelligence.domain

import org.springframework.stereotype.Service
import pl.braintelligence.infrastructure.dto.NewProduct
import reactor.core.publisher.Mono

@Service
class ProductService {

    fun createProduct(product: Mono<NewProduct>): Mono<Product> = TODO()

}
