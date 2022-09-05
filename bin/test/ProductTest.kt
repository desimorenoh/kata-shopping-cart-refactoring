import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun productNameTest() {
        val product = Product(0, "Call Of Duty Modern Warfare", 19.27, false)

        assertThat(product.name, equalTo("Call Of Duty Modern Warfare"))
    }
}
