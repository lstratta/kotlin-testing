package testing.demo.product

import testing.demo.order.OrderDTO
import testing.demo.order.toDomain
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "products")
data class ProductDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_key")
    val productKey: Long? = null,

    @Column(name = "product_id")
    val productId: UUID, // SKU Code

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "item_price")
    val itemPrice: Double,

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "order_key", nullable = false)
    val order: OrderDTO
)

fun ProductDTO.toDomain(): Product = Product(
    productId = productId,
    name = name,
    description = description,
    order = order?.toDomain(),
    itemPrice = itemPrice
)