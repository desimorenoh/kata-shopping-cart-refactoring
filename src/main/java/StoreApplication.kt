import java.util.*

class StoreApplication {
    var isQuit = false
        private set
    private val catalog: List<Product> = listOf(
        Product(0, "Call Of Duty Modern Warfare", 19.27, false),
        Product(1, "Mario Kart 64", 12.30, true),
        Product(2, "Rust", 0.0, false),
        Product(3, "Medieval 2 Total War", 30.0, false),
        Product(4, "Call Of Duty: Black Ops 2", 19.99, false),
        Product(5, "The Sims", 9.99, false),
        Product(6, "Sim City 4", 8.30, false)
    )
    private val shoppingCart: ShoppingCart = ShoppingCart()

    fun printInfoMessage() {
        val infoMessage: String =
            """
                    LegacyGames Application 13.4.6
                    © TruñoSoft 2022
                    
                    Realice una de las siguientes acciones para continuar
                    
                    (l) Muestra la lista de productos
                    (a) Añade un producto a la compra actual
                    (p) Genera un recibo de compra
                    (q) Salir del programa
                     
                """.trimIndent()
        println(infoMessage)
    }

    fun readCommand() {
        val input = Scanner(System.`in`).nextLine()
        if (input == "q") {
            isQuit = true
        }
        if (input == "l") {
            showProducts()
        }
        if (input == "p") {
            generateReceipt()
        }
        if (input.startsWith("a")) {
            val id: Int =
                input.split("a ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].trim { it <= ' ' }
                    .toInt()
            val product = catalog.stream().filter { p: Product -> p.id == id }.findFirst().get()
            println(
                """Añadiendo ${product.name} al carrito

""".trimIndent()
            )
            shoppingCart.add(product)
        }
    }

    private fun generateReceipt() {
        val products: List<Product> = shoppingCart.products
        var totalPrecio = 0.0
        println("Articulo   |     Precio")
        println("-----------------------")
        products.forEach { p: Product ->
            System.out.printf(
                "1x (%d) %s - %.2f\n",
                p.id,
                p.name,
                p.price
            )
        }
        for (i in products.indices) {
            if (products[i].has25PercentDiscount()) {
                totalPrecio += products[i].price * 0.75
            } else {
                totalPrecio += products[i].price
            }
        }
        System.out.printf("TOTAL: %.2f\n", totalPrecio)
        isQuit = true
    }

    private fun showProducts() {
        println("Juegos disponibles en catálogo:\n")
        catalog.forEach { p: Product ->
            System.out.printf(
                "(%d) %s - %.2f\n",
                p.id,
                p.name,
                p.price
            )
        }
        println("\n")
    }
}