package register;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import product.Product;
import product.ProductCategory;

/**
 * Register class for Product.
 */
public class Register {
  private final HashMap<String, Product> productRegister;
  private final ArrayList<ProductCategory> categoryList =
        new ArrayList<>(EnumSet.allOf(ProductCategory.class));

  /**
   * Constructor for register class.
   * Creates a new HashMap upon instantiation.
   */
  public Register() {
    this.productRegister = new HashMap<>();
  }

  /**
   * Getter for the productRegister field.
   *
   * @return Map of the product register
   */
  public Map<String, Product> getProductRegister() {
    return this.productRegister;
  }

  /**
   * Getter for an iterator of String.
   *
   * @return iterator of String
   */
  private Iterator<String> getIterator() {
    return getProductRegister().keySet().iterator();
  }

  /**
   * Adds a product to the register.
   *
   * @param product product to add to the register
   * @return true if product was added, false if product was not added
   */
  public boolean addProduct(Product product) {
    boolean booleanToReturn = false;
    //If check to only add the product to the register if the product number
    // does not exist in the register
    if (!isProductNumberInRegister(product.getProductNumber())) {
      productRegister.put(product.getProductNumber(), product);
      //Setting the boolean to true to indicate adding product to the register went smoothly.
      booleanToReturn = true;
    }
    return booleanToReturn;
  }

  /**
   * Searches the product register for products that contain the passed product number.
   * It is assumed that the product numbers are the same length and unique.
   * Will return a list with only one product in the case of an exact match.
   *
   * @param productNumber to search with
   * @return ArrayList of products containing the product number
   */
  public List<Product> searchProductByProductNumber(String productNumber) {
    ArrayList<Product> searchResultList = new ArrayList<>();
    //First checks if there is an exact match
    if (isProductNumberInRegister(productNumber)) {
      searchResultList.add(getProductRegister().get(productNumber));
    } else {
      //Skips this if there is an exact match
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
   * Removes a product from the register.
   *
   * @param productNumber product number of the product to be removed.
   * @return true/false depending on whether a product has been removed or not.
   */
  public boolean removeProductByProductNumber(String productNumber) {
    boolean booleanToReturn = false;
    if (isProductNumberInRegister(productNumber)) {
      getProductRegister().remove(productNumber);
      booleanToReturn = true;
    }
    return booleanToReturn;
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
    return categoryList;
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
}
