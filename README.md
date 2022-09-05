# Shopping Cart Refactoring Kata

Os acaban de contratar para continuar el desarrollo de la aplicación de caja de Legacy Games. La desarrolladora anterior se
ha ido a las Bahamas y os ha dejado a cargo de su _legacy code_.

### Requisitos técnicos

Esta [aplicación](https://github.com/FactoriaF5Code/bftp2-katas-08-shopping-cart-refactoring) inicialmente está desarrollada con Java 16. Pero la he migrado a Koltin 1.7.10

### Cómo trabajar con Legacy Code

Llamamos "legacy code" (código legado o heredado) a un código que funciona pero que no tiene código de tests. Éste normalmente
ha sido escrito por otras personas (o por nosotras hace tiempo), y tiene la característica de que es difícil de cambiar.

Para poder realizar cambios en una base de código legado, primero tenemos que escribir tests que nos aseguren que no nos cargamos nada.

#### Cómo empezar:

- Antes de ponernos a cambiar cosas, examina las clases que existen y analiza la forma en que está escrito el código
- Escribe tests para las clases más "pequeñas" (`Product`, `ShoppingCart`) que te permitan simplificar el código. Por ejemplo, haz que sea la clase `Product` quien calcule el precio final del producto (tenga descuento o no).


### Funcionalidades que nos piden: 

- Mostrar los descuentos existentes en la lista de productos y en el ticket de compra. Por ejemplo, si un juego tiene descuento, debe visualizarse como:
  ```
    (1) Mario Kart 64 - 9.23e - [25% OFF]
  ```
  En el ejemplo anterior, el precio que se muestra es el precio con descuento y no el precio original (12.30)  

- Añadir cualquier descuento a los juegos, no sólo del 25%
- 2x1: algunos juegos tienen una oferta 2x1, si compras dos, sólo pagas uno
- Al comprar un juego **violento**, debe incluirse una línea de texto en el recibo de compra. Únicamente se debe mostrar
  este texto una vez, aunque se compren varios juegos considerados violentos.
  ``` 
     Algunos de estos juegos pueden incluir contenido violento para mayores de 18 años. Legacy Games no se hace
        cargo de su uso y disfrute por parte de personas pequeñas. 
  ```
  Tendréis que añadir el campo correspondiente a la clase `Product` para clasificar un juego como violento o no
- Tiquet simplificado: si compramos varias unidades del mismo producto, queremos agruparlas. Por ejemplo, en lugar de mostrar el siguiente ticket:
  ```
    Articulo   |     Precio
    -----------------------
    1x (0) Call Of Duty Modern Warfare - 19.27
    1x (0) Call Of Duty Modern Warfare - 19.27
    1x (4) Call Of Duty: Black Ops 2 - 19.99
    TOTAL: 58.53
  ```
  deberíamos agrupar los productos y mostrar las cantidades agregadas
  ```
    Articulo   |     Precio
    -----------------------
    2x (0) Call Of Duty Modern Warfare - 19.27
    1x (4) Call Of Duty: Black Ops 2 - 19.99
    TOTAL: 58.53
  ```
  
  En el caso de existir una oferta 2x1, debe indicarse al final del ticket:
  ```
    Articulo   |     Precio
    -----------------------
    2x (0) Call Of Duty Modern Warfare - 19.27
    1x (4) Call Of Duty: Black Ops 2 - 19.99
    1x Descuento 2x1:  -19.27
    TOTAL: 39.26
  ```