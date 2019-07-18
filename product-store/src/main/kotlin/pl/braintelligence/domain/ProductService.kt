package pl.braintelligence.domain

import org.springframework.stereotype.Service
import pl.braintelligence.infrastructure.dto.NewProduct
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class ProductService {

    fun createProduct(product: Mono<NewProduct>): Mono<Product> =
            product.delayElement(Duration.ofMillis(100)).map {
                Product(
                        name = it.name,
                        unitPrice = it.unitPrice
                )
            }
}
