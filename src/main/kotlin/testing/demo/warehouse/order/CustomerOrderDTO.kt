package testing.demo.warehouse.order

import testing.demo.warehouse.customer.CustomerDTO
import testing.demo.warehouse.product.ProductDTO
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "customer_orders")
data class CustomerOrderDTO(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_order_key")
        val customerOrderKey: Long = 0,

        @Column(name = "customer_order_id")
        val customerOrderId: UUID,

        // *mappedBy* points to the field in the connecting entity that owns
        // the relationship. This tells Hibernate to only track the use
        // of foreign keys on the other side of the relationship.
        // In this case, *mappedBy* points to the productOrder
        // field in the ProductDTO entity

        // If *mappedBy* wasn't present, Hibernate would create an
        // associations/linking table to handle both primary keys of both
        // entities as foreign keys of the association table.
        @OneToMany(mappedBy = "customerOrder")
        val products: List<ProductDTO> = emptyList(),

        @Column(name = "total_value")
        val totalValue: Double,

//        @Column(name = "customer")
//        val customer: CustomerDTO
)

fun CustomerOrderDTO.toDomain(): Order = Order(
        orderId = customerOrderId,
        lineItems = products.map { it.productId.toString() },
        totalValue = totalValue
)