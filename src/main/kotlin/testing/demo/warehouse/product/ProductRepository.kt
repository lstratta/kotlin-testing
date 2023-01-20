package testing.demo.warehouse.product

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import testing.demo.warehouse.order.OrderDTO

@Repository
interface ProductRepository: CrudRepository<ProductDTO, Long> {

//    fun findProductByOrder(order: OrderDTO): List<ProductDTO>
}