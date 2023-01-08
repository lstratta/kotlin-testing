package testing.demo.product

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
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
)

fun ProductDTO.toDomain(): Product = Product(
    productId = this.productId,
    name = this.name,
    description = this.description,
    itemPrice = this.itemPrice
)