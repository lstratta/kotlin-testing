package testing.demo.product

import java.util.UUID

data class Product(

    val productId: UUID, // SKU Code
    val name: String,
    val description: String,
    val itemPrice: Double,
)

fun Product.toDto(): ProductDTO = ProductDTO(
    productId = this.productId,
    name = this.name,
    description = this.description,
    itemPrice = this.itemPrice
)


