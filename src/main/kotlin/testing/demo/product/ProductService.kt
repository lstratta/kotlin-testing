package testing.demo.product

class ProductService (private val productRepository: ProductRepository) {

    fun addNewProduct(product: Product): Product {
        val result =  productRepository.save(product.toDto())

        return result.toDomain()
    }

    // Get product
    fun getAllProducts(): List<Product>{
        return productRepository.findAll().map { it.toDomain() }
    }

    // Delete product
}