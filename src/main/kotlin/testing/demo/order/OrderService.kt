package testing.demo.order

import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {

    fun addNewOrder(order: Order): Order {
        return orderRepository.save(order.toDto()).toDomain()
    }

    fun getAllOrders(): List<Order> {
        return orderRepository.findAll().map { it.toDomain() }
    }
}