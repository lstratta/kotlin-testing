package testing.demo.product

import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun addNewProduct(product: Product): Product {
        val result = productRepository.save(product.toDto())

        return result.toDomain()
    }


    fun getAllProducts(): List<Product> {
        return productRepository.findAll().map { it.toDomain() }
    }

    // Delete product
}