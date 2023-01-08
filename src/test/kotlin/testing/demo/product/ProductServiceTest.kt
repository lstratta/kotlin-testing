package testing.demo.product

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.UUID

class ProductServiceTest{

    private val productService: ProductService = mockk()

    @BeforeEach
    fun setup(){
        clearAllMocks()
        unmockkAll()
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