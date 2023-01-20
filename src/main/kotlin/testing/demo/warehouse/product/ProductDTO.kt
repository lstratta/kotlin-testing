package testing.demo.warehouse.product

import testing.demo.warehouse.order.OrderDTO
import testing.demo.warehouse.order.toDomain
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity(name = "products")
data class ProductDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_key")
    val productKey: Long? = null,

    @Column(name = "product_id")
    val productId: UUID? = UUID.randomUUID(), // SKU Code

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "item_price")
    val itemPrice: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "order_key"), name = "order_key")
    val customerOrder: OrderDTO? = null
)

fun ProductDTO.toDomain(): Product = Product(
    productId = productId,
    name = name,
    description = description,
    itemPrice = itemPrice
)