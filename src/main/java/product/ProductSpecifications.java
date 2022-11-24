package product;

/**
 * Class holding product specifications.
 */
public class ProductSpecifications {
  private double weight;
  private double length;
  private double height;
  private String color;

  public ProductSpecifications(double weight, double length, double height, String color) {
    setWeight(weight);
    setLength(length);
    setHeight(height);
    this.color = color;
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

  /**
   * Returns the weight of the ProductSpecifications object.
   *
   * @return weight
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Returns the length of the ProductSpecifications object.
   *
   * @return length
   */
  public double getLength() {
    return length;
  }

  /**
   * Returns the height of the ProductSpecifications object.
   *
   * @return height
   */
  public double getHeight() {
    return height;
  }

  /**
   * Returns the color of the ProductSpecifications object.
   *
   * @return color
   */
  public String getColor() {
    return color;
  }
}
