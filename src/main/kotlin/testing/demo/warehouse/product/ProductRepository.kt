package testing.demo.warehouse.product

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: CrudRepository<ProductDTO, Long> {
}