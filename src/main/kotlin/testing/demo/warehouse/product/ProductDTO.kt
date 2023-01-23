package testing.demo.warehouse.product

import testing.demo.warehouse.order.CustomerOrderDTO
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

@Entity(name = "products")
data class ProductDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_key")
    val productKey: Long = 0,

    @Column(name = "product_id")
    val productId: UUID? = UUID.randomUUID(), // SKU Code

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "item_price")
    val itemPrice: Double,

    // You do not have to have an @ManyToMany on the side that is *mappedBy*
    // You would have this implemented if you wanted to be able to affect
    // the contents of the relationship from this side. e.g. Adding new products to
    // and order, deleting products from an order.
    // In this situation, it doesn't make sense to allow a product to control whether
    // it is on an order or not; only an order should dictate that.
//    @ManyToMany(mappedBy = "products")
//    val customerOrder: List<CustomerOrderDTO> = emptyList()
)

fun ProductDTO.toDomain(): Product = Product(
    productId = productId,
    name = name,
    description = description,
    itemPrice = itemPrice
)