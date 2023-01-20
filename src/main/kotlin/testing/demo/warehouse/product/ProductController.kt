package testing.demo.warehouse.product

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController(val productService: ProductService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewProduct(@RequestBody product: ProductCTO): ProductCTO {
        return productService.addNewProduct(product.toDomain()).toCto()
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllProducts(): List<ProductCTO> {
        return productService.getAllProducts().map { it.toCto() }
    }

}