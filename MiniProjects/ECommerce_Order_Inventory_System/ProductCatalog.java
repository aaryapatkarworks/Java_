import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ProductCatalog {

    private List<Product> products;

    private Map<String, Product> productsById;

    private Map<String, Product> productsByRegistrationOrder;

    private Map<String, Product> productsSortedById;

    private Set<String> categories;

    public ProductCatalog() {

        products = new ArrayList<>();

        productsById = new HashMap<>();

        productsByRegistrationOrder =
                new LinkedHashMap<>();

        productsSortedById =
                new TreeMap<>();

        categories = new HashSet<>();
    }

    public void addProduct(Product product) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null."
            );
        }

        if (productsById.containsKey(product.getProductId())) {
            throw new IllegalArgumentException(
                    "Product ID already exists: "
                            + product.getProductId()
            );
        }

        products.add(product);

        productsById.put(
                product.getProductId(),
                product
        );

        productsByRegistrationOrder.put(
                product.getProductId(),
                product
        );

        productsSortedById.put(
                product.getProductId(),
                product
        );

        categories.add(product.getCategory());
    }

    public Product findProductById(String productId) {
        return productsById.get(productId);
    }

    public void displayAllProducts() {

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void displayRegistrationOrder() {

        for (Product product :
                productsByRegistrationOrder.values()) {

            System.out.println(product);
        }
    }

    public void displayProductsById() {

        for (Product product :
                productsSortedById.values()) {

            System.out.println(product);
        }
    }

    public Set<String> getCategories() {
        return categories;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> sortByPriceAscending() {

        List<Product> sortedProducts =
                new ArrayList<>(products);

        sortedProducts.sort(
                Comparator.comparingDouble(
                        Product::getPrice
                )
        );

        return sortedProducts;
    }

    public List<Product> sortByPriceDescending() {

        List<Product> sortedProducts =
                new ArrayList<>(products);

        sortedProducts.sort(
                Comparator.comparingDouble(
                        Product::getPrice
                ).reversed()
        );

        return sortedProducts;
    }

    public List<Product> sortByRating() {

        List<Product> sortedProducts =
                new ArrayList<>(products);

        sortedProducts.sort(
                Comparator.comparingDouble(
                        Product::getRating
                ).reversed()
        );

        return sortedProducts;
    }

    public List<Product> sortByName() {

        List<Product> sortedProducts =
                new ArrayList<>(products);

        Collections.sort(sortedProducts);

        return sortedProducts;
    }

    public Product getMostExpensiveProduct() {

        if (products.isEmpty()) {
            return null;
        }

        return Collections.max(
                products,
                Comparator.comparingDouble(
                        Product::getPrice
                )
        );
    }

    public Product getCheapestProduct() {

        if (products.isEmpty()) {
            return null;
        }

        return Collections.min(
                products,
                Comparator.comparingDouble(
                        Product::getPrice
                )
        );
    }

    public boolean removeProduct(String productId) {

        Product product =
                productsById.remove(productId);

        if (product == null) {
            return false;
        }

        products.remove(product);

        productsByRegistrationOrder.remove(
                productId
        );

        productsSortedById.remove(
                productId
        );

        rebuildCategories();

        return true;
    }

    private void rebuildCategories() {

        categories.clear();

        for (Product product : products) {
            categories.add(product.getCategory());
        }
    }

    public int getProductCount() {
        return products.size();
    }
}