package testing.demo.order

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderRepository: CrudRepository<OrderDTO, Long>{

    fun findOrderByOrderId(orderId: UUID): OrderDTO
}