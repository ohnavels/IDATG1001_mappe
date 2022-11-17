package product;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Register class for Product.
 */
public class Register {
  private final HashMap<String, Product> productRegister;

  public Register() {
    this.productRegister = new HashMap<>();
  }

  public Map<String, Product> getProductRegister() {
    return this.productRegister;
  }

  private Iterator<String> getIterator() {
    return getProductRegister().keySet().iterator();
  }

  /**
   * Adds a product to the register.
   *
   * @param productNumber product number of product must be unique in the register
   * @param description   description of the product
   * @param price         price of the product
   * @param brand         brand of the product
   * @param weight        weight of the product
   * @param length        length of the product
   * @param height        height of the product
   * @param color         color of the product
   * @param stock         stock of the product
   * @param category      Enum from ProductCategory.java
   * @return true if product was added, false if product was not added
   */
  public boolean addProduct(String productNumber, String description, int price, String brand,
                            double weight, double length, double height, String color,
                            int stock, ProductCategory category) {

    //If check to only add the product to the register if the product number
    // does not exist in the register
    if (isProductNumberInRegister(productNumber)) {
      return false;
    }

    productRegister.put(productNumber, new Product(productNumber, description, price, brand,
        weight, length, height, color, stock, category));
    //Returning 0 to indicate that adding the product to the register went smoothly
    return true;
  }

  /**
   * Searches the product register for products that contain the passed product number.
   * It is assumed that the product numbers are the same length and unique.
   *
   * @param productNumber to search with
   * @return ArrayList of products containing the product number
   */
  public List<Product> searchProductByProductNumber(String productNumber) {
    ArrayList<Product> searchResultList = new ArrayList<>();
    Iterator<String> iterator = getIterator();
    //Iterator loops through the list of product numbers
    //If product number contains the parameter string the product
    //gets added to searchResultList
    while (iterator.hasNext()) {
      String currentKey = iterator.next();
      if (getProductRegister().get(currentKey).getProductNumber()
          .toLowerCase().contains(productNumber.toLowerCase())) {
        searchResultList.add(getProductRegister().get(currentKey));
      }
    }
    return searchResultList;
  }

  /**
   * Searches the product register for products that contains the passed description.
   *
   * @param description to search with
   * @return ArrayList of products containing the description
   */
  public List<Product> searchProductByDescription(String description) {
    ArrayList<Product> searchResultList = new ArrayList<>();
    Iterator<String> iterator = getIterator();
    //Iterator loops through the list of product numbers
    //If description contains the parameter string the product
    //gets added to searchResultList
    while (iterator.hasNext()) {
      String currentKey = iterator.next();
      if (getProductRegister().get(currentKey).getDescription().toLowerCase()
          .contains(description.toLowerCase())) {
        searchResultList.add(getProductRegister().get(currentKey));
      }
    }
    return searchResultList;
  }

  /**
   * Prints out all products in the register to the console.
   */
  public void printRegister() {
    Iterator<String> iterator = getIterator();
    while (iterator.hasNext()) {
      System.out.println(getProductRegister().get(iterator.next()).productDetails());
    }
  }

  /**
   * Removes a product from the register.
   *
   * @param productNumber product number of the product to be removed.
   * @return true/false depending on whether a product has been removed or not.
   */
  public boolean removeProductByProductNumber(String productNumber) {
    if (isProductNumberInRegister(productNumber)) {
      getProductRegister().remove(productNumber);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks to see if the product number exists in the register.
   *
   * @param productNumber product number to search for in the register
   * @return true if in the register or false if not in the register
   */
  public boolean isProductNumberInRegister(String productNumber) {
    return productRegister.containsKey(productNumber);
  }

  /**
   * Gets an ArrayList that contains all the enums from the ProductCategory class.
   *
   * @return ArrayList of enums from ProductCategory
   */
  public List<ProductCategory> getCategoryList() {
    return new ArrayList<>(EnumSet.allOf(ProductCategory.class));
  }

  /**
   * Gets the category from the ArrayList of enums.
   * Searches through the list to find a category with the same name as the parameter.
   *
   * @param categoryToFind category to search for.
   * @return ProductCategory object
   */
  public ProductCategory getCategoryFromList(String categoryToFind) {
    return getCategoryList().stream().filter(category -> category.name()
        .equals(categoryToFind)).findFirst().orElse(null);
  }

  /**
   * Adds products into the register to use for testing.
   */
  public void addTestData() {
    addProduct("LF432893", "Brown floor laminate", 499, "Dunno",
        3, 200, 4.5, "Brown", 5, ProductCategory.LAMINATEFLOOR);
    addProduct("BMDR382", "Yellow door", 7999, "BM",
        25, 80, 240, "Yellow", 5, ProductCategory.DOOR);
    addProduct("BMPL921", "Plank", 123, "BM",
        8.5, 300, 25, "Light Blue", 149, ProductCategory.LUMBER);
    addProduct("OBSWND328", "Window with black frame", 4000, "OBS",
        14.5, 100, 100, "Black", 5, ProductCategory.WINDOW);
  }
}
