package testing.demo.product

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import org.json.JSONArray
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.UUID


class ProductControllerTest {

    private lateinit var mvc: MockMvc

    private val objectMapper: ObjectMapper = ObjectMapper()
        .registerModule(JavaTimeModule())
    private val productService: ProductService = mockk()
    private val productController: ProductController = ProductController(productService)

    @BeforeEach
    fun setup() {
        clearAllMocks()
        unmockkAll()
        mvc = MockMvcBuilders
            .standaloneSetup(productController)
            .setControllerAdvice()
            .build()
    }

    @Test
    fun `POST new product returns product`() {
        val productToPOST = product()

        every { productService.addNewProduct(productToPOST.toDomain()) } returns
                productToPOST.toDomain()

        mvc.post("/product"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(productToPOST)
        }.andExpect {
            status { isCreated() }
            jsonPath("productId") { value(productToPOST.productId.toString()) }
            jsonPath("name") { value(productToPOST.name) }
            jsonPath("description") { value(productToPOST.description) }
            jsonPath("itemPrice") { value(productToPOST.itemPrice) }

        }
    }

    @Test
    fun `GET all products returns two products`() {
        val product1 = product()
        val product2 = product(
            name = "Chaplain Grimaldus & Retinue",
            description = "Chaplain Grimaldus & Retinue character models",
            value = 27.50
        )

        every { productService.addNewProduct(product1.toDomain()) } returns product1.toDomain()
        every { productService.addNewProduct(product2.toDomain()) } returns product2
            .toDomain()

        mvc.post("/product") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(product1)
        }

        mvc.post("/product") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(product2)
        }

        every { productService.getAllProducts() } returns listOf(product1.toDomain(),
            product2.toDomain())

        mvc.get("/product"){
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            jsonPath("$[0].productId") { value(product1.productId.toString()) }
            jsonPath("$[0].name") { value(product1.name) }
            jsonPath("$[1].productId") { value(product2.productId.toString()) }
            jsonPath("$[1].name") { value(product2.name) }
            jsonPath("$.length()") { value (2) }
        }
    }

    private fun product(
        productId: UUID = UUID.randomUUID(),
        name: String = "Kruleboy Killaboss on Great Gnashtoof",
        description: String = "Hero model for the Orruk Kruleboyz",
        value: Double = 35.00
    ): ProductCTO = ProductCTO(
        productId = productId,
        name = name,
        description = description,
        itemPrice = value
    )
}