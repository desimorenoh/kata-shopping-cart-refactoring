import java.util.List;
import java.util.Scanner;

public class StoreApplication {
    private boolean quit;

    private final List<Product> catalog = List.of(
            new Product(0, "Call Of Duty Modern Warfare", 19.27, false),
            new Product(1,"Mario Kart 64", 12.30, true),
            new Product(2,"Rust", 0.0, false),
            new Product(3,"Medieval 2 Total War", 30.0, false),
            new Product(4, "Call Of Duty: Black Ops 2", 19.99, false),
            new Product(5, "The Sims", 9.99, false),
            new Product(6, "Sim City 4", 8.30, false)
    );

    private final ShoppingCart shoppingCart;

    public StoreApplication() {
        quit = false;
        shoppingCart = new ShoppingCart();
    }

    public void printInfoMessage() {
        String infoMessage = """
                    LegacyGames Application 13.4.6
                    © TruñoSoft 2022
                    
                    Realice una de las siguientes acciones para continuar
                    
                    (l) Muestra la lista de productos
                    (a) Añade un producto a la compra actual
                    (p) Genera un recibo de compra
                    (q) Salir del programa
                     
                """;
        System.out.println(infoMessage);
    }

    public boolean isQuit() {
        return this.quit;
    }

    public void readCommand() {
        String input = new Scanner(System.in).nextLine();
        if (input.equals("q")) {
            quit = true;
        }

        if (input.equals("l")) {
            showProducts();
        }

        if (input.equals("p")) {
            generateReceipt();
        }

        if (input.startsWith("a")) {
            int id = Integer.parseInt(input.split("a ")[1].trim());
            Product product = catalog.stream().filter(p -> p.getId() == id).findFirst().get();
            System.out.println("Añadiendo " + product.getName() + " al carrito\n\n");
            shoppingCart.add(product);
        }

    }

    private void generateReceipt() {
        List<Product> producs = shoppingCart.getProducts();
        double totalPrecio = 0;

        System.out.println("Articulo   |     Precio");
        System.out.println("-----------------------");

        producs.forEach( p -> System.out.printf("1x (%d) %s - %.2f\n", p.getId(), p.getName(), p.getPrice()));
        for (int i = 0; i < producs.size(); i++) {

            if (producs.get(i).has25PercentDiscount()) {
                totalPrecio += producs.get(i).getPrice()*0.75;
            } else {
                totalPrecio += producs.get(i).getPrice();
            }
        }

        System.out.printf("TOTAL: %.2f\n", totalPrecio);
        quit = true;

    }

    private void showProducts() {
        System.out.println("Juegos disponibles en catálogo:\n");
        catalog.forEach( p -> System.out.printf("(%d) %s - %.2f\n", p.getId(), p.getName(), p.getPrice()));
        System.out.println("\n");
    }
}
