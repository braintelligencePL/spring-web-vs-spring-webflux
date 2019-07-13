package pl.braintelligence.domain

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service
import pl.braintelligence.infrastructure.dto.NewProduct

@Service
class ProductService(
        restTemplateBuilder: RestTemplateBuilder,
        @Value("\${product-store.base-url}") private val productStoreBaseUrl: String
) {

    private val restTemplate = restTemplateBuilder.build()

    fun createProduct(newProduct: NewProduct): Product? = restTemplate.postForEntity(
            "$productStoreBaseUrl/products",
            HttpEntity(newProduct),
            Product::class.java
    ).body
}
