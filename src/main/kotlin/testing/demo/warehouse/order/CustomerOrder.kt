package testing.demo.warehouse.order

import java.util.UUID

data class CustomerOrder(
    val orderId: UUID,
    val totalValue: Double,
    val lineItems: List<String> = emptyList()
)

fun CustomerOrder.toDto(): CustomerOrderDTO = CustomerOrderDTO(
    customerOrderId = orderId,
    totalValue = totalValue,
)
