package testing.demo.product

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.UUID
import kotlin.test.assertEquals

@DataJpaTest
class ProductRepositoryTest {

    private val productRepository: ProductRepository = mockk()

    @Test
    fun saveProductDTO_ReturnsProductDTOSaved() {
        val productDTO = productDTO()

        every { productRepository.save(productDTO) } returns productDTO

        val actual = productRepository.save(productDTO)

        with(productDTO) {
            assertEquals(this.productId, actual.productId)
            assertEquals(this.description, actual.description)
            assertEquals(this.itemPrice, actual.itemPrice)
        }

        verify (exactly = 1) { productRepository.save(productDTO) }
    }

    fun productDTO(
        productId: UUID = UUID.randomUUID(),
        name: String = "Kruleboy Killaboss on Great Gnashtoof",
        description: String = "Hero model for the Orruk Kruleboyz",
        value: Double = 35.00
    ): ProductDTO = ProductDTO(
        productId = productId,
        name = name,
        description = description,
        itemPrice = value
    )
}