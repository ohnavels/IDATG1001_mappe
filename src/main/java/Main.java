import register.Register;
import userinterface.ProductRegisterUI;

/**
 * Main class for ProductRegister.
 * Creates an instance of ProductRegisterUI.
 */
public class Main {
  public static void main(String[] args) {
    Register productRegister = new Register();
    new ProductRegisterUI(productRegister);
  }
}