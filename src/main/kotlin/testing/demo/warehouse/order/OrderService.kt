package testing.demo.warehouse.order

import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {

    fun addNewOrder(order: CustomerOrder): CustomerOrder {
        return orderRepository.save(order.toDto()).toDomain()
    }

    fun getAllOrders(): List<CustomerOrder> {
        return orderRepository.findAll().map { it.toDomain() }
    }
}