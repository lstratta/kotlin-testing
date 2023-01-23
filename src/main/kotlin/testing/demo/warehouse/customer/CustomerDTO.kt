package testing.demo.warehouse.customer

import testing.demo.warehouse.order.CustomerOrderDTO
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "customers")
data class CustomerDTO (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_key")
    val customerKey: Long = 0,

    @Column(name = "customer_id")
    val customerId: UUID = UUID.randomUUID(),

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "last_name")
    val lastName: String,

    // *mappedBy* points to the field (i.e. variable) in the connecting entity that owns
    // the relationship. This tells Hibernate to only track the use
    // of foreign keys on the other side of the relationship.
    // In this case, *mappedBy* points to the productOrder
    // field in the ProductDTO entity

    // If *mappedBy* wasn't present, Hibernate would create an
    // associations/linking table to handle both primary keys of both
    // entities as foreign keys of the association table.
    @OneToMany (mappedBy = "customer")
    val allOrders: List<CustomerOrderDTO> = emptyList()
)

fun CustomerDTO.toDomain(): Customer = Customer(
    customerId = customerId,
    firstName = firstName,
    lastName = lastName,
    allOrders = allOrders.map { it.customerOrderId.toString() }
)
