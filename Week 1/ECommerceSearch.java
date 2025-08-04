import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1. Setup: The Product Class
class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product(ID: " + productId + ", Name: '" + productName + "', Category: '" + category + "')";
    }
}

// Main class to contain search algorithms and the main method
public class ECommerceSearch {

    // 2. Implementation: Linear Search
    public static Product linearSearch(List<Product> products, int targetId) {
        System.out.println("\n--- Starting Linear Search for Product ID: " + targetId + " ---");
        int steps = 0;
        for (Product product : products) {
            steps++;
            System.out.println("Step " + steps + ": Comparing with " + product.getProductId());
            if (product.getProductId() == targetId) {
                System.out.println("--- Found product in " + steps + " steps. ---");
                return product;
            }
        }
        System.out.println("--- Product not found after " + steps + " steps. ---");
        return null;
    }

    // 3. Implementation: Binary Search
    public static Product binarySearch(List<Product> sortedProducts, int targetId) {
        System.out.println("\n--- Starting Binary Search for Product ID: " + targetId + " ---");
        int low = 0;
        int high = sortedProducts.size() - 1;
        int steps = 0;

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2; // Avoid potential overflow
            Product midProduct = sortedProducts.get(mid);
            System.out.println("Step " + steps + ": Low=" + low + ", High=" + high + ", Mid=" + mid + ", Checking " + midProduct.getProductId());

            if (midProduct.getProductId() == targetId) {
                System.out.println("--- Found product in " + steps + " steps. ---");
                return midProduct;
            } else if (midProduct.getProductId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("--- Product not found after " + steps + " steps. ---");
        return null;
    }

    public static void main(String[] args) {
        // --- Sample Data ---
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(105, "Laptop", "Electronics"));
        productsList.add(new Product(210, "T-Shirt", "Apparel"));
        productsList.add(new Product(115, "Keyboard", "Electronics"));
        productsList.add(new Product(301, "Coffee Mug", "Home Goods"));
        productsList.add(new Product(450, "Running Shoes", "Footwear"));
        productsList.add(new Product(120, "Mouse", "Electronics"));

        // For binary search, the list MUST be sorted.
        // We create a new sorted list to preserve the original unsorted one.
        List<Product> sortedProductsList = new ArrayList<>(productsList);
        Collections.sort(sortedProductsList, Comparator.comparingInt(Product::getProductId));

        System.out.println("--- Initial Data ---");
        System.out.println("Unsorted List: " + productsList);
        System.out.println("Sorted List: " + sortedProductsList);

        // --- Execution Example ---
        // Example 1: Find an item that exists
        System.out.println("\n\n======= SEARCHING FOR PRODUCT 120 (Exists) =======");
        linearSearch(productsList, 120);
        binarySearch(sortedProductsList, 120);

        // Example 2: Find an item that doesn't exist
        System.out.println("\n\n======= SEARCHING FOR PRODUCT 999 (Doesn't Exist) =======");
        linearSearch(productsList, 999);
        binarySearch(sortedProductsList, 999);

        // Example 3: Worst-case for linear search (last item in original list)
        System.out.println("\n\n======= SEARCHING FOR PRODUCT 120 (Worst Case for Linear) =======");
        linearSearch(productsList, 120);
        
        // Example 4: Best-case for linear search (first item in original list)
        System.out.println("\n\n======= SEARCHING FOR PRODUCT 105 (Best Case for Linear) =======");
        linearSearch(productsList, 105);
    }
}
