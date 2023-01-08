package testing.demo.order

import testing.demo.product.Product
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

//@Entity
//@Table(name = "orders")
//data class OrderDTO (
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        @Column(name = "order_key")
//        val orderKey: Long? = null,
//        val orderId: Long,
//        val lineItems: List<Product>,
//        val totalValue: Double
//)
//
//fun OrderDTO.toDomain(): Order = Order(
//        orderId = this.orderId,
//        lineItems = this.lineItems,
//        totalValue = this.totalValue
//)