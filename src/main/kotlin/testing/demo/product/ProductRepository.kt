package testing.demo.product

import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<ProductDTO, Long> {
}