package testing.demo.product

import testing.demo.order.Order
import testing.demo.order.toDto
import java.util.UUID

data class Product(

    val productId: UUID, // SKU Code
    val name: String,
    val description: String,
    val itemPrice: Double,
    val order: Order
)

fun Product.toDto(): ProductDTO = ProductDTO(
    productId = productId,
    name = name,
    description = description,
    itemPrice = itemPrice,
    order = order.toDto()
)

fun Product.toCto(): ProductCTO = ProductCTO(
    productId = productId,
    name = name,
    description = description,
    itemPrice = itemPrice,
)