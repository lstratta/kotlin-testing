package testing.demo.warehouse.customer

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController (val customerService: CustomerService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllCustomers(): List<Customer> {
        return customerService.getAllCustomers()
    }
}