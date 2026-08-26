import java.util.HashSet;
import java.util.Set;

public class Product implements Comparable<Product> {

    private String productId;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;
    private double rating;
    private Set<String> tags;

    public Product(
            String productId,
            String name,
            String category,
            double price,
            int stockQuantity,
            double rating
    ) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.rating = rating;
        this.tags = new HashSet<>();
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getRating() {
        return rating;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void increaseStock(int quantity) {
        if (quantity > 0) {
            stockQuantity += quantity;
        }
    }

    public boolean decreaseStock(int quantity) {

        if (quantity <= 0 || quantity > stockQuantity) {
            return false;
        }

        stockQuantity -= quantity;
        return true;
    }

    // Natural ordering: Product name A-Z
    @Override
    public int compareTo(Product other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return productId
                + " | "
                + name
                + " | "
                + category
                + " | ₹"
                + price
                + " | Stock: "
                + stockQuantity
                + " | Rating: "
                + rating
                + " | Tags: "
                + tags;
    }
}