import java.util.List;

public class _10_DAO_Demo {

    public static void main(String[] args) {

        ProductsDAO productsDAO = new ProductsDAO();


        // CREATE
        Products product1 = new Products(
                101,
                "MacBook Air M3",
                "Laptop",
                99999
        );

        Products product2 = new Products(
                102,
                "Logitech MX Master 3S",
                "Accessories",
                8999
        );

        productsDAO.addProducts(product1);
        productsDAO.addProducts(product2);


        // READ - Get all products
        System.out.println("\nAll Products:");

        List<Products> products = productsDAO.getAllProducts();

        for (Products product : products) {
            System.out.println(product);
        }


        // READ - Get product by ID
        System.out.println("\nProduct with ID 101:");

        Products product = productsDAO.getProductsById(101);

        if (product != null) {
            System.out.println(product);
        }


        // UPDATE
        System.out.println("\nUpdating price:");

        productsDAO.updateProductPrice(101, 94999);


        // DELETE
        System.out.println("\nDeleting product with ID 102:");

        productsDAO.deleteProducts(102);
    }
}