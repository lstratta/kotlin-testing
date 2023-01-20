package testing.demo.warehouse.product

import java.util.UUID

data class Product(

    val productId: UUID? = UUID.randomUUID(), // SKU Code
    val name: String,
    val description: String,
    val itemPrice: Double,
)

fun Product.toDto(): ProductDTO = ProductDTO(
    productId = productId,
    name = name,
    description = description,
    itemPrice = itemPrice,
)

fun Product.toCto(): ProductCTO = ProductCTO(
    productId = productId,
    name = name,
    description = description,
    itemPrice = itemPrice,
)