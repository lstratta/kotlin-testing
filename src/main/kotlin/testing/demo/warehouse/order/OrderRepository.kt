package testing.demo.warehouse.order

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderRepository: CrudRepository<CustomerOrderDTO, Long>{

    fun findOrderByCustomerOrderId(customerOrderId: UUID): CustomerOrderDTO
}