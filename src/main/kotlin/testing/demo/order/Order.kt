package testing.demo.order

import java.util.UUID

data class Order(
    val orderId: UUID,
    val totalValue: Double,
    val lineItems: List<String> = emptyList()
)

fun Order.toDto(): OrderDTO = OrderDTO(
    orderId = orderId,
    totalValue = totalValue,
//    products = lineItems.map { it.toDto() }
)
