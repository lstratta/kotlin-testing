package testing.demo.warehouse.product

import java.util.UUID

data class ProductCTO(
    val productId: UUID? = UUID.randomUUID(),
    val name: String,
    val description: String,
    val itemPrice: Double,
)

fun ProductCTO.toDomain(): Product = Product(
    productId = productId,
    name = name,
    description = description,
    itemPrice = itemPrice,
)