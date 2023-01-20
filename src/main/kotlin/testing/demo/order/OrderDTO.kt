package testing.demo.order

import testing.demo.product.ProductDTO
import testing.demo.product.toDomain
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity(name = "orders")
data class OrderDTO(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "order_key")
        val orderKey: Long? = null,

        @Column(name = "order_id")
        val orderId: UUID,

        // *mappedBy* points to the field in the connecting entity that owns
        // the relationship. This tells Hibernate to only track the use
        // of foreign keys on the other side of the relationship.
        // In this case, *mappedBy* points to the productOrder
        // field in the ProductDTO entity

        // If *mappedBy* wasn't present, Hibernate would create an
        // associations/linking table to handle both primary keys of both
        // entities as foreign keys of the association table.
        @OneToMany(mappedBy = "orderKey")
        val products: List<ProductDTO> = emptyList(),

        @Column(name = "total_value")
        val totalValue: Double
)

fun OrderDTO.toDomain(): Order = Order(
        orderId = orderId,
        lineItems = products.map { it.productId.toString() },
        totalValue = totalValue
)