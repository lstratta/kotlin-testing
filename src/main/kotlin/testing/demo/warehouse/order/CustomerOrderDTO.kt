package testing.demo.warehouse.order

import testing.demo.warehouse.customer.CustomerDTO
import testing.demo.warehouse.product.ProductDTO
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ForeignKey
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "customer_orders")
data class CustomerOrderDTO(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_order_key")
        val customerOrderKey: Long = 0,

        @Column(name = "customer_order_id")
        val customerOrderId: UUID,


        @ManyToMany
        // TODO: re-write explanation below
        // *name* tells JPA which table to go to find the ManyToMany relationship
        // *joinColumns* tells JPA which column to go to in the linking table so that it
        // can match it to the entity this side of the relationship is in.
        // *inverseJoinColumns* does the same, but for the *mappedBy* side of the
        // relationship.
        // These columns need to be the correct way around because the foreign key in the
        // linking table (that is, the primary key of one side of the relationship) needs
        // to match up correctly.
        @JoinTable(
                name = "orders_products_link",
                joinColumns = [JoinColumn(name = "customer_order_key")],
                inverseJoinColumns = [JoinColumn(name = "product_key")]
        )
        val products: List<ProductDTO> = emptyList(),

        @Column(name = "total_value")
        val totalValue: Double,

        // The *@ManyToOne* side of the relationship is the owning side of the relationship.
        // The owning side is the side that hold the foreign key to the *@OneToMany* field.
        // todo: Add Fetch type information (issue #5)
        @ManyToOne
        // *@JoinColumn* tells hibernate to make queries using a join that uses this column
        // when connecting to this particular entity.
        // You assign the foreign key of the joining table
        // The second *name* field has to match the name of the column in the database
        // that holds the foreign key. This *name* field replaces
        // *@Column(name = "customer_order")
        @JoinColumn(foreignKey = ForeignKey(name = "customer_key"), name = "customer")
        val customer: CustomerDTO? = null
)

fun CustomerOrderDTO.toDomain(): CustomerOrder = CustomerOrder(
        orderId = customerOrderId,
        lineItems = products.map { it.productId.toString() },
        totalValue = totalValue
)