class Product(
    val name: String,
    var price: Double,
    var quantity: Int
) {
    fun total(): Double {
        return price * quantity
    }
}

fun totalProducts(products: List<Product>): Double{
     var total = 0.0
    for (product in products) {
        total += product.total()
    }
    return total
    
}

fun main() {
   val products: List<Product> = listOf(
    Product("Laptop", 800.0, 1),
    Product("Mouse", 25.0, 2),
    Product("Keyboard", 50.0, 1),
    Product("Headphone", 100.0, 1)
   )
   for (item in products){
       println(item.name)
       println(item.price)
       println(item.quantity)
       println(item.total())
       println("--------------------")
   }
   
   val sum = totalProducts(products)
    println("sum: $sum")
   
}