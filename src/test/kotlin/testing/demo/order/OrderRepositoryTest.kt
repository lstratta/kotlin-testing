package testing.demo.order

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.UUID

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private lateinit var orderRepository: OrderRepository

    @Test
    fun `Save order to database returns order`(){

    }

    fun orderDTO(
        orderId: UUID = UUID.randomUUID(),
        lineItems: MutableList<OrderDTO> = mutableListOf(),
        totalValue: Double = 0.0
    ): OrderDTO = OrderDTO(
        orderId = orderId,
        products = lineItems,
        totalValue = totalValue
    )
}