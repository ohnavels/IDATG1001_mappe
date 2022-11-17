package product;

/**
 * Class of product.
 */
public class Product {
  private String productNumber;
  private String description;
  private int price;
  private String brand;
  private double weight;
  private double length;
  private double height;
  private String color;
  private int stock;
  private ProductCategory category;

  /**
   * Product constructor.
   * Is called whenever a new Product is being made.
   *
   * @param productNumber product number
   * @param description   description
   * @param price         price
   * @param brand         brand
   * @param weight        weight
   * @param length        length
   * @param height        height
   * @param color         color
   * @param stock         stock
   * @param category      category
   */
  public Product(String productNumber, String description, int price, String brand, double weight,
                 double length, double height, String color, int stock, ProductCategory category) {
    this.productNumber = productNumber;
    this.description = description;
    setPrice(price);
    this.brand = brand;
    setWeight(weight);
    setLength(length);
    setHeight(height);
    this.color = color;
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

  public void setProductNumber(String productNumber) {
    this.productNumber = productNumber;
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

  public int getPrice() {
    return price;
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

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public double getWeight() {
    return weight;
  }

  /**
   * Set weight value of the Product object.
   * If weight parameter is less than 0, field will be set to 0.
   *
   * @param weight new weight
   */
  public void setWeight(double weight) {
    if (weight >= 0) {
      this.weight = weight;
    } else {
      this.weight = 0;
    }
  }

  public double getLength() {
    return length;
  }

  /**
   * Set length value of the Product object.
   * If length parameter is less than 0, field will be set to 0.
   *
   * @param length new length
   */
  public void setLength(double length) {
    if (length >= 0) {
      this.length = length;
    } else {
      this.length = 0;
    }
  }

  public double getHeight() {
    return height;
  }

  /**
   * Set height value of the Product object.
   * If height parameter is less than 0, field will be set to 0.
   *
   * @param height new height
   */
  public void setHeight(double height) {
    if (height >= 0) {
      this.height = height;
    } else {
      this.height = 0;
    }
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
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

  public ProductCategory getCategory() {
    return category;
  }

  public void setCategory(ProductCategory category) {
    this.category = category;
  }

  //TODO: Spør kiran: hva skal printes ut

  /**
   * Returns a string in the correct format to print out.
   *
   * @return string of product details
   */
  public String productDetails() {
    return getProductNumber() + " in stock: " + getStock();
  }
}
