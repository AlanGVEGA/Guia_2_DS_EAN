/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2
 * Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

/**
 * Tienda que maneja 4 productos.
 */
public class Tienda {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Producto 1 - Tipo: PAPELERIA, Nombre: L�piz, Valor unitario: 550.0, Cantidad en bodega: 18, Cantidad m�nima: 5, Imagen: lapiz.png. <br>
     * Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5, Cantidad en bodega: 25, Cantidad m�nima: 8, Imagen: aspirina.png. <br>
     * Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3, Cantidad en bodega: 30, Cantidad m�nima: 10, Imagen: borrador.png. <br>
     * Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0, Cantidad en bodega: 15, Cantidad m�nima: 20, Imagen: pan.png. <br>
     */
    public Tienda() {
        producto1 = new Producto("papeleria", "Lapiz", 550.0, 18, 5, "lapiz.png");
        producto2 = new Producto("drogueria", "Aspirina", 109.5, 25, 8, "aspirina.png");
        producto3 = new Producto("papeleria", "Borrador", 207.3, 30, 10, "borrador.png");
        producto4 = new Producto("supermercado", "Pan", 150.0, 15, 20, "pan.png");
        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el producto 1.
     *
     * @return Producto 1 de la tienda.
     */
    public Producto darPrimerProducto() {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     *
     * @return Producto 2 de la tienda.
     */
    public Producto darSegundoProducto() {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     *
     * @return Producto 3 de la tienda.
     */
    public Producto darTercerProducto() {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     *
     * @return Producto 4 de la tienda.
     */
    public Producto darCuartoProducto() {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     *
     * @return Dinero en caja.
     */
    public double darDineroEnCaja() {
        return dineroEnCaja;
    }

    /**
     * Retorna el producto con el nombre dado por par�metro.
     *
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre != "".
     * @return Producto con el nombre dado por par�metro, null si no lo encuentra.
     */
    public Producto darProducto(String pNombre) {
        if (producto1.darNombre().equalsIgnoreCase(pNombre)) {
            return producto1;
        }

        if (producto2.darNombre().equalsIgnoreCase(pNombre)) {
            return producto2;
        }

        if (producto3.darNombre().equalsIgnoreCase(pNombre)) {
            return producto3;
        }

        if (producto4.darNombre().equalsIgnoreCase(pNombre)) {
            return producto4;
        }

        // Si no se encuentra el producto, retorna null
        return null;
    }

    /**
     * Retorna el promedio de las ventas.
     *
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas() {
        double totalVentas = 0.0;
        int totalUnidadesVendidas = 0;
        double promedioVentas = 0.0;

        totalVentas += this.producto1.calcularPrecioFinal() * producto1.darCantidadUnidadesVendidas();
        totalUnidadesVendidas += producto1.darCantidadUnidadesVendidas();

        totalVentas += this.producto2.calcularPrecioFinal() * producto2.darCantidadUnidadesVendidas();
        totalUnidadesVendidas += producto2.darCantidadUnidadesVendidas();

        totalVentas += this.producto3.calcularPrecioFinal() * producto3.darCantidadUnidadesVendidas();
        totalUnidadesVendidas += producto3.darCantidadUnidadesVendidas();

        totalVentas += this.producto4.calcularPrecioFinal() * producto4.darCantidadUnidadesVendidas();
        totalUnidadesVendidas += producto4.darCantidadUnidadesVendidas();

        if (totalUnidadesVendidas > 0) {
            promedioVentas = totalVentas / totalUnidadesVendidas;
        }

        return promedioVentas;

    }

    /**
     * Retorna el producto con m�s unidades vendidas.
     *
     * @return Producto con m�s unidades vendidas. Null si ning�n producto tiene unidades vendidas.
     */
    public Producto darProductoMasVendido() {
        Producto masVendido = producto1;

        if (producto2.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
            masVendido = producto2;
        }

        if (producto3.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
            masVendido = producto3;
        }

        if (producto4.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
            masVendido = producto4;
        }

        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     *
     * @return Producto con menos unidades vendidas. Null si ning�n producto tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido() {

        Producto menosVendido = producto1;

        if (producto2.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto2;
        }

        if (producto3.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto3;
        }

        if (producto4.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto4;
        }

        return menosVendido;

    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre por par�metro. <br>
     * <b>post: </b> Disminuy� la cantidad de unidades del producto dado
     * y se actualiz� el dinero de la caja a partir de la cantidad real vendida multiplicada
     * por el precio final (con IVA) del producto vendido..
     *
     * @param pNombreProducto Nombre del producto a vender.
     * @param pCantidad       Cantidad de unidades del producto a vender. pCantidad > 0.
     * @return Cantidad que fue efectivamente vendida.
     */
    public int venderProducto(String pNombreProducto, int pCantidad) {
        int cantidadVendida = 0;

        // Verificar y vender el producto 1
        if (producto1.darNombre().equalsIgnoreCase(pNombreProducto)) {
            cantidadVendida = Math.min(producto1.darCantidadBodega(), pCantidad);
            producto1.vender(cantidadVendida);
            dineroEnCaja += cantidadVendida * producto1.calcularPrecioFinal();
        }

        // Verificar y vender el producto 2
        else if (producto2.darNombre().equalsIgnoreCase(pNombreProducto)) {
            cantidadVendida = Math.min(producto2.darCantidadBodega(), pCantidad);
            producto2.vender(cantidadVendida);
            dineroEnCaja += cantidadVendida * producto2.calcularPrecioFinal();
        }

        // Verificar y vender el producto 3
        else if (producto3.darNombre().equalsIgnoreCase(pNombreProducto)) {
            cantidadVendida = Math.min(producto3.darCantidadBodega(), pCantidad);
            producto3.vender(cantidadVendida);
            dineroEnCaja += cantidadVendida * producto3.calcularPrecioFinal();
        }

        // Verificar y vender el producto 4
        else if (producto4.darNombre().equalsIgnoreCase(pNombreProducto)) {
            cantidadVendida = Math.min(producto4.darCantidadBodega(), pCantidad);
            producto4.vender(cantidadVendida);
            dineroEnCaja += cantidadVendida * producto4.calcularPrecioFinal();
        }


        return cantidadVendida;
    }

    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aument� la cantidad de unidades en bodega del producto dado.
     *
     * @param pNombreProducto Nombre del producto a abastecer.
     * @param pCantidad       La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto(String pNombreProducto, int pCantidad) {
        boolean abastece = false;

        // Verificar y abastecer el producto 1
        if (producto1.darNombre().equalsIgnoreCase(pNombreProducto)) {
            producto1.abastecer(pCantidad);
            abastece = true;
        }

        // Verificar y abastecer el producto 2
        else if (producto2.darNombre().equalsIgnoreCase(pNombreProducto)) {
            producto2.abastecer(pCantidad);
            abastece = true;
        }

        // Verificar y abastecer el producto 3
        else if (producto3.darNombre().equalsIgnoreCase(pNombreProducto)) {
            producto3.abastecer(pCantidad);
            abastece = true;
        }

        // Verificar y abastecer el producto 4
        else if (producto4.darNombre().equalsIgnoreCase(pNombreProducto)) {
            producto4.abastecer(pCantidad);
            abastece = true;
        }

        return abastece;

    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores dados por par�metro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad m�nima fueron cambiados con los valores dados por par�metro.
     *
     * @param pNombreActual   Nombre actual del producto.
     * @param pNombreNuevo    Nuevo nombre del producto.
     * @param pTipo           Tipo del producto.
     * @param pValorUnitario  Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto.
     * @param pCantidadMinima Cantidad m�nima en bodega para hacer un pedido del producto.
     * @param pRutaImagen     Ruta de la imagen del producto.
     * @return Retorna true si cambi� la informaci�n del producto,
     * Retorna false si ya exist�a un producto con el nuevo nombre.
     */
    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, String pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        boolean cambio = false;

        // Validacion: Verificar si el nombre nuevo ya existe
        boolean nombreExistente = false;
        if (producto1.darNombre().equalsIgnoreCase(pNombreNuevo) ||
                producto2.darNombre().equalsIgnoreCase(pNombreNuevo) ||
                producto3.darNombre().equalsIgnoreCase(pNombreNuevo) ||
                producto4.darNombre().equalsIgnoreCase(pNombreNuevo)) {
            nombreExistente = true;
        }

        // Si el nombre existe, cambiar la informaci�n del producto
        if (nombreExistente) {
            // Verificar y cambiar el producto 1
            if (producto1.darNombre().equalsIgnoreCase(pNombreActual)) {
                producto1.cambiarNombre(pNombreNuevo);
                producto1.cambiarTipo(pTipo);
                producto1.cambiarValorUnitario(pValorUnitario);
                producto1.cambiarCantidadBodega(pCantidadBodega);
                producto1.cambiarCantidadMinima(pCantidadMinima);
                producto1.cambiarRutaImagen(pRutaImagen);
                cambio = true;
            }

            // Verificar y cambiar el producto 2
            else if (producto2.darNombre().equalsIgnoreCase(pNombreActual)) {
                producto2.cambiarNombre(pNombreNuevo);
                producto2.cambiarTipo(pTipo);
                producto2.cambiarValorUnitario(pValorUnitario);
                producto2.cambiarCantidadBodega(pCantidadBodega);
                producto2.cambiarCantidadMinima(pCantidadMinima);
                producto2.cambiarRutaImagen(pRutaImagen);
                cambio = true;
            }

            // Verificar y cambiar el producto 3
            else if (producto3.darNombre().equalsIgnoreCase(pNombreActual)) {
                producto3.cambiarNombre(pNombreNuevo);
                producto3.cambiarTipo(pTipo);
                producto3.cambiarValorUnitario(pValorUnitario);
                producto3.cambiarCantidadBodega(pCantidadBodega);
                producto3.cambiarCantidadMinima(pCantidadMinima);
                producto3.cambiarRutaImagen(pRutaImagen);
                cambio = true;
            }

            // Verificar y cambiar el producto 4
            else if (producto4.darNombre().equalsIgnoreCase(pNombreActual)) {
                producto4.cambiarNombre(pNombreNuevo);
                producto4.cambiarTipo(pTipo);
                producto4.cambiarValorUnitario(pValorUnitario);
                producto4.cambiarCantidadBodega(pCantidadBodega);
                producto4.cambiarCantidadMinima(pCantidadMinima);
                producto4.cambiarRutaImagen(pRutaImagen);
                cambio = true;
            }
        }

        return cambio;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Obtiene la cantidad de productos que tienen un precio inferior al promedio de los precios
     */
    public int metodo1() {
        int cantidadProductos = 0;

        double totalPrecios = producto1.calcularPrecioFinal() +
                producto2.calcularPrecioFinal() +
                producto3.calcularPrecioFinal() +
                producto4.calcularPrecioFinal();

        double promedio = totalPrecios / 4; // Promedio de los precios de los 4 productos

        if (producto1.calcularPrecioFinal() < promedio) {
            cantidadProductos = cantidadProductos + 1;
        }

        if (producto2.calcularPrecioFinal() < promedio) {
            cantidadProductos = cantidadProductos + 1;
        }

        if (producto3.calcularPrecioFinal() < promedio) {
            cantidadProductos = cantidadProductos + 1;
        }

        if (producto4.calcularPrecioFinal() < promedio) {
            cantidadProductos = cantidadProductos + 1;
        }

        return cantidadProductos;
    }

    /**
     * Obtiene el nombre del producto m�s barato de la tienda
     */
    public String metodo2() {
        String nombreProductoMasBarato = "";
        double precioMasBarato = Double.MAX_VALUE; // Inicializamos con un valor muy grande

        // Comparar el precio de cada producto y actualizar el nombre del m�s barato
        if (producto1.calcularPrecioFinal() < precioMasBarato) {
            precioMasBarato = producto1.calcularPrecioFinal();
            nombreProductoMasBarato = producto1.darNombre();
        }

        if (producto2.calcularPrecioFinal() < precioMasBarato) {
            precioMasBarato = producto2.calcularPrecioFinal();
            nombreProductoMasBarato = producto2.darNombre();
        }

        if (producto3.calcularPrecioFinal() < precioMasBarato) {
            precioMasBarato = producto3.calcularPrecioFinal();
            nombreProductoMasBarato = producto3.darNombre();
        }

        if (producto4.calcularPrecioFinal() < precioMasBarato) {

            nombreProductoMasBarato = producto4.darNombre();
        }

        return nombreProductoMasBarato;
    }

}

