import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun productNameTest() {
        val product = Product(0, "Call Of Duty Modern Warfare", 19.27, false)

        assertEquals("Call Of Duty Modern Warfare", product.name)
    }
}
