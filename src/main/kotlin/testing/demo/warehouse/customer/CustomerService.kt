package testing.demo.warehouse.customer

import org.springframework.stereotype.Service

@Service
class CustomerService (val customerRepository: CustomerRepository) {

    fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll().map{it.toDomain()}
    }
}
