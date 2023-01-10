package testing.demo.order

import testing.demo.product.Product
import testing.demo.product.toDto
import java.util.UUID

data class Order(
    val orderId: UUID,
    val totalValue: Double,
    val lineItems: List<Product>
)

fun Order.toDto(): OrderDTO = OrderDTO(
    orderId = orderId,
    totalValue = totalValue,
    lineItems = lineItems.map { it.toDto() }
)
