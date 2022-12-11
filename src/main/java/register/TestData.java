package register;

import java.util.Random;
import product.Product;
import product.ProductSpecifications;


/**
 * TestData class generates test data for the application so the program can be used without
 * manually adding individual products.
 */
public class TestData {
  private static final String[] descriptions = {"A very nice product",
      "Cannot be used with any flooring", "Works great with other products of the same brand",
      "A poorly optimized product", "Has three possibilities for extensions",
      "Compatible with other brands"};
  private static final String[] brands = {"Byggmakker", "COOP OBS",
      "Byggmax", "Maxbo", "Jernia", "Jula"};
  private static final  String[] colors = {"Black", "Red", "Grey", "Blue",
      "Light grey", "Green", "Oak"};
  private static final Random random = new Random();

  /**
   * Private constructor to restrict object creation.
   */
  private TestData() {
  }

  /**
   * Generates random Product objects and adds them to the specified register.
   *
   * @param register add random Product objects to this register
   * @param amountToGenerate amount of random Product objects to create
   */
  public static void generateTestData(Register register, int amountToGenerate) {
    for (int i = 0; i < amountToGenerate; i++) {
      //Creates a new product with random values chosen from the lists:
      //descriptions, brands and colors.
      register.addProduct(new Product("" + (i + 1),
            descriptions[random.nextInt(descriptions.length)],
            random.nextInt(1000),
            brands[random.nextInt(brands.length)],
            new ProductSpecifications(Math.random() * 100,
                  Math.random() * 100, Math.random() * 100,
                  colors[random.nextInt(colors.length)]),
            random.nextInt(50), register.getCategoryList()
            .get(random.nextInt(register.getCategoryList().size()))));
    }
  }
}
