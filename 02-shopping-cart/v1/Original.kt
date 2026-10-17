class Product(
    val name: String,
    var price: Double,
    var quantity: Int
) {
    fun total(): Double {
        return price * quantity
    }
}

// Calculate the total price of all products
fun totalProducts(products: List<Product>): Double{
    var total = 0.0
    for (product in products) {
        total += product.total()
    }
    return total
    
}

// Search for a product by name and print it
fun findProduct(products: List<Product>, name: String){
    var flag = false
    for (items in products){
        if (name == items.name){
            flag = true
            println("\nSuccessful...\n$name\nprice: ${items.price}\nquantity: ${items.quantity}")
            break
        }
         
    }
    
   if (!flag){
       println("\nProduct not found ($name)")
   }
}

// Print products whose price is above the threshold
fun showExpensiveProducts(products: List<Product>, threshold: Double){
    println("\n------- filter (price > $threshold) --------")
    for (item in products){
        if (item.price > threshold){
            println("name - price - quantity")
            println("${item.name} - ${item.price} - ${item.quantity} ")
        }
    }
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
    
    findProduct(products, "Mouse")
    findProduct(products, "Tablet")
    showExpensiveProducts(products, 100.0)
   
}