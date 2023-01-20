package testing.demo.product

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import testing.demo.warehouse.product.Product
import testing.demo.warehouse.product.ProductService
import java.util.UUID

class ProductServiceTest{

    private val productService: ProductService = mockk()

    @BeforeEach
    fun setup(){
        clearAllMocks()
        unmockkAll()
    }

    @Test
    fun getAllProducts_ReturnsListOfProducts() {
        val product1 = product()
        val product2 = product(name = "Yellow Ducky", description = "The best bath buddies.", itemPrice = 12.99)

        every { productService.addNewProduct(product1) } returns product1
        every { productService.addNewProduct(product2) } returns product2

        productService.addNewProduct(product1)
        productService.addNewProduct(product2)

        every { productService.getAllProducts() } returns listOf(product1, product2)

        val actual = productService.getAllProducts()

        assertEquals(2, actual.size)
        with(product1) {
            assertEquals(this.productId, actual[0].productId)
            assertEquals(this.name, actual[0].name)
            assertEquals(this.description, actual[0].description)
        }

        with(product2) {
            assertEquals(this.productId, actual[1].productId)
            assertEquals(this.name, actual[1].name)
            assertEquals(this.description, actual[1].description)
        }
    }

    @Test
    fun postNewProduct_ReturnsPostedProduct(){
        val product = product()

        every { productService.addNewProduct(product) } returns product

        val result = productService.addNewProduct(product)

        assertEquals(product.productId, result.productId)

        verify (exactly = 1) { productService.addNewProduct(product) }

    }

    private fun product(
        productId: UUID = UUID.randomUUID(),
        name: String = "Adeptus Mechanicus Sicarians",
        description: String = "Box of 5 Adeptus Mechanicus Sicarians. Can be built as Ruststalkers or Infiltrators",
        itemPrice: Double = 25.00
    ): Product = Product(
        productId = productId,
        name = name,
        description = description,
        itemPrice = itemPrice
    )
}