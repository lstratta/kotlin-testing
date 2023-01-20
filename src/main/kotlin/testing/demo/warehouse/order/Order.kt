package testing.demo.warehouse.order

import java.util.UUID

data class Order(
    val orderId: UUID,
    val totalValue: Double,
    val lineItems: List<String> = emptyList()
)

fun Order.toDto(): CustomerOrderDTO = CustomerOrderDTO(
    customerOrderId = orderId,
    totalValue = totalValue,
//    products = lineItems.map { it.toDto() }
)
