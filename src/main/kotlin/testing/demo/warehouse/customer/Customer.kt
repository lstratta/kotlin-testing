package testing.demo.warehouse.customer

import java.util.UUID

data class Customer (
    val customerId: UUID,
    val firstName: String,
    val lastName: String,
    val allOrders: List<String>
)