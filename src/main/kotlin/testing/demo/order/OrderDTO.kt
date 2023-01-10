package testing.demo.order

import testing.demo.product.ProductDTO
import testing.demo.product.toDomain
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "orders")
data class OrderDTO(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "order_key")
        val orderKey: Long? = null,

        @Column(name = "order_id")
        val orderId: UUID,

        @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        val lineItems: List<ProductDTO>,

        @Column(name = "total_value")
        val totalValue: Double
)

fun OrderDTO.toDomain(): Order = Order(
        orderId = orderId,
        lineItems = lineItems.map { it.toDomain() },
        totalValue = totalValue
)