class ShoppingCart {
    private var productList: MutableList<Product> = ArrayList()

    fun add(product: Product) {
        productList.add(product)
    }

    val products: List<Product>
        get() = productList
}