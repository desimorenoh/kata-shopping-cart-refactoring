class Main {

}

fun main() {
    val storeApplication = StoreApplication()
    var quit = false

    while (!quit) {
        storeApplication.printInfoMessage()
        storeApplication.readCommand()
        if (storeApplication.isQuit) {
            quit = true
        }
    }
}
