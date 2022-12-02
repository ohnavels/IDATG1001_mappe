package product;

/**
 * Class of product.
 */
public class Product {
  private final String productNumber;
  private String description;
  private int price;
  private String brand;
  private ProductSpecifications specifications;
  private int stock;
  private ProductCategory category;

  /**
   * Product constructor.
   * Is called whenever a new Product is being made.
   *
   * @param productNumber   product number
   * @param description     description
   * @param price           price
   * @param brand           brand
   * @param specifications  specifications (length height weight color)
   * @param stock           stock
   * @param category        category
   */
  public Product(String productNumber, String description, int price, String brand,
                 ProductSpecifications specifications, int stock, ProductCategory category) {
    this.productNumber = productNumber;
    this.description = description;
    setPrice(price);
    this.brand = brand;
    this.specifications = specifications;
    setStock(stock);
    this.category = category;
  }

  /**
   * Get product number field.
   *
   * @return product number.
   */
  public String getProductNumber() {
    return productNumber;
  }

  /**
   * Get description field.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Changes the description field to be same as the parameter.
   *
   * @param description new description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Set price value of the Product object.
   * If price parameter is less than 0, field will be set to 0.
   *
   * @param price new price
   */
  public void setPrice(int price) {
    this.price = Math.max(price, 0);
  }

  /**
   * Get stock field.
   *
   * @return stock
   */
  public int getStock() {
    return stock;
  }

  /**
   * Set stock field of the Product object.
   *
   * @param stock new stock value
   */
  public void setStock(int stock) {
    this.stock = Math.max(stock, 0);
  }

  /**
   * Returns a string in the correct format to print out.
   *
   * @return string of product details
   */
  public String productDetails() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("productNumber: ").append(productNumber).append("\n")
          .append("description: ").append(description).append("\n")
          .append("price: ").append(price).append("\n")
          .append("brand: ").append(brand).append("\n")
          .append("weight: ").append(specifications.getWeight()).append("\n")
          .append("length: ").append(specifications.getLength()).append("\n")
          .append("height: ").append(specifications.getHeight()).append("\n")
          .append("color: ").append(specifications.getColor()).append("\n")
          .append("stock: ").append(stock).append("\n")
          .append("category: ").append(category).append("\n");
    return String.valueOf(stringBuilder);
  }
}
