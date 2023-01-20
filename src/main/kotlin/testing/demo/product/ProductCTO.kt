package testing.demo.product

import testing.demo.order.Order
import java.util.UUID

data class ProductCTO(
    val productId: UUID? = UUID.randomUUID(),
    val name: String,
    val description: String,
    val itemPrice: Double,
    val order: Order,
)

fun ProductCTO.toDomain(): Product = Product(
    productId = productId,
    name = name,
    description = description,
    order = order,
    itemPrice = itemPrice,
)