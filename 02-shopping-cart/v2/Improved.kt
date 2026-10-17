class Product(
    val name: String,
    val price: Double,
    val quantity: Int
) {
    // Computed property: recalculated every time it is accessed
    val total: Double
        get() = price * quantity
}

// Sum all products' totals using the built-in sumOf
fun calculateTotalPrice(products: List<Product>): Double {
    return products.sumOf { it.total }
}

// Single responsibility: only search, let the caller decide what to do.
// Returns null if no product with the given name is found.
fun findProduct(products: List<Product>, name: String): Product? {
    return products.firstOrNull { it.name == name }
}

// Print products whose price is above the threshold.
// Prints a message when no product matches.
fun showExpensiveProducts(products: List<Product>, threshold: Double) {
    println("\n------- filter (price > $threshold) --------")

    val expensive = products.filter { it.price > threshold }

    if (expensive.isEmpty()) {
        println("No products match the filter")
        return
    }

    // Header is printed once, outside the loop
    println("name - price - quantity")
    for (item in expensive) {
        println("${item.name} - ${item.price} - ${item.quantity}")
    }
}

fun main() {
    val products: List<Product> = listOf(
        Product("Laptop", 800.0, 1),
        Product("Mouse", 25.0, 2),
        Product("Keyboard", 50.0, 1),
        Product("Headphone", 100.0, 1)
    )

    for (item in products) {
        println(item.name)
        println(item.price)
        println(item.quantity)
        println(item.total)   // no parentheses
        println("--------------------")
    }

    val sum = calculateTotalPrice(products)
    println("sum: $sum")

    // findProduct only searches; printing is the caller's job
    val mouse = findProduct(products, "Mouse")
    if (mouse != null) {
        println("\nSuccessful...\n${mouse.name}\nprice: ${mouse.price}\nquantity: ${mouse.quantity}")
    } else {
        println("\nProduct not found (Mouse)")
    }

    val tablet = findProduct(products, "Tablet")
    if (tablet != null) {
        println("\nSuccessful...\n${tablet.name}\nprice: ${tablet.price}\nquantity: ${tablet.quantity}")
    } else {
        println("\nProduct not found (Tablet)")
    }

    showExpensiveProducts(products, 100.0)
}