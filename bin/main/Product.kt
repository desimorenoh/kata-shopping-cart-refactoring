class Product(val id: Int, val name: String, val price: Double, private val has25PercentDiscount: Boolean) {

    fun has25PercentDiscount(): Boolean {
        return has25PercentDiscount
    }
}