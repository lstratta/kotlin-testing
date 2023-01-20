package testing.demo.warehouse.order

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController (val orderService: OrderService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewOrder(@RequestBody order: CustomerOrder): CustomerOrder {
        return orderService.addNewOrder(order)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllOrders(): List<CustomerOrder> {
        return orderService.getAllOrders()
    }
}