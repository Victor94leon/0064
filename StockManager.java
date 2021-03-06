import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID())==null) {
            stock.add(item);
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product producto = findProduct(id);
        if(producto != null){
            producto.increaseQuantity(amount);
        }
        else{
            System.out.println("El id indicado no pertenece a ningun producto");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product productoBuscado = null;
        boolean productoEncontrado = false;
        int index = 0;
        while (!productoEncontrado && index<stock.size()) {
            if (stock.get(index).getID()==id) {
                productoEncontrado = true;
                productoBuscado = stock.get(index);
            }
            index++;
        }
        return productoBuscado;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int numeroDeProductos = 0;
        Product producto = findProduct(id);
        if (producto != null) {
            numeroDeProductos = producto.getQuantity();
        }
        return numeroDeProductos;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product productoEnLista : stock) {
            System.out.println(productoEnLista);
        }
    }
    
    /**
     * M�todo que imprime los detalles de todos los productos cuyo stock est� por debajo
     * de un determinado n�mero
     */
    public void underGivenNumberInStock(int cantidadStock)
    {
        for (Product productoEnLista : stock) {
            if (productoEnLista.getQuantity()<cantidadStock) {
                System.out.println(productoEnLista);
            }
        }
    }
    
    /**
     * M�todo que busca un producto en el stock mediante el nombre del product.
     * Devuelve un objeto Product si encuentra una coincidencia o null si no la encuentra.
     */
    public Product findProduct(String name)
    {
        Product productoBuscado = null;
        boolean productoEncontrado = false;
        int index = 0;
        while (!productoEncontrado && index<stock.size()) {
            if (stock.get(index).getName()==name) {
                productoEncontrado = true;
                productoBuscado = stock.get(index);
            }
            index++;
        }
        return productoBuscado;
    }
}