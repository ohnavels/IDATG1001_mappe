import register.Register;
import register.TestData;
import userinterface.ProductRegisterUI;

/**
 * Main class for ProductRegister.
 * Creates an instance of ProductRegisterUI.
 */
public class Main {

  /**
   * Starts the application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Register productRegister = new Register();
    TestData.generateTestData(productRegister, 43);
    new ProductRegisterUI(productRegister);
  }
}