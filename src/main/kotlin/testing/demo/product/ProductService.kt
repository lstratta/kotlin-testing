package testing.demo.product

class ProductService (private val productRepository: ProductRepository) {

    fun addNewProduct(product: Product): Product {
        val result =  productRepository.save(product.toDto())

        return result.toDomain()
    }

    // Get product

    // Delete product
}