package testing.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.testng.annotations.Test

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)


}
//
//data class Dep1(
//        val value: Int
//)
//
//fun Dep1.getValue(): Int {
//    return value
//}
//
//data class Dep2(
//        val value: Int
//)
//
//data class Printer(
//        val valueToPrint: Int
//)
//
//fun Printer.printResult() {
//    println("$valueToPrint")
//}
//
//data class Calculator(
//        val value1: Dep1,
//        val value2: Dep2
//)
//
//fun Calculator.add(): Int {
//    return value1.value + value2.value
//}
//
//
//
