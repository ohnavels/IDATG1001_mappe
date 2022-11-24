package userInterface;

import product.Product;
import product.ProductCategory;
import product.ProductSpecifications;
import product.Register;

import java.util.Scanner;

/**
 * ProductRegisterUI handles all user interface interactions.
 */
public class ProductRegisterUI {
  private final Register register;
  private final Scanner sc;
  private static final String VERSION = "v1.0-SNAPSHOT";

  /**
   * The Menu items.
   */
  String[] menuItems
        = {
          "1. List all products",
          "2. Search for product",
          "3. Add a product to the register",
          "4. Change the stock of a product",
          "5. Delete product by product number",
          "6. Change product price/description"
        };

  // Constants defining the different menu options, to be used in the
  // switch-case.
  private static final int LIST_ALL_PRODUCTS = 1;
  private static final int SEARCH_PRODUCT = 2;
  private static final int ADD_PRODUCT = 3;
  private static final int CHANGE_STOCK = 4;
  private static final int DELETE_PRODUCT_BY_PRODUCT_NUMBER = 5;
  private static final int CHANGE_PRODUCT_INFORMATION = 6;
  private static final int EXIT = 0;

  private static final int PRODUCT_NUMBER = 1;
  private static final int DESCRIPTION = 2;

  private static final int CHANGE_PRODUCT_DESCRIPTION = 1;
  private static final int CHANGE_PRODUCT_PRICE = 2;

  /**
   * Creates an instance of the LongJumpUI User interface.
   */
  public ProductRegisterUI() {
    register = new Register();
    register.addTestData();
    sc = new Scanner(System.in);
    start();
  }

  /**
   * Starts the application by showing the menu and retrieving input from the
   * user. Continues until the user decides to exit the application.
   */
  private void start() {
    boolean quit = false;

    while (!quit) {
      printProgramDetails();
      int menuSelection = this.getMenuChoice(menuItems.length);
      switch (menuSelection) {
        case LIST_ALL_PRODUCTS:
          register.printRegister();
          break;

        case SEARCH_PRODUCT:
          searchProduct();
          break;

        case ADD_PRODUCT:
          addProductFromUser();
          break;

        case CHANGE_STOCK:
          changeStock();
          break;

        case DELETE_PRODUCT_BY_PRODUCT_NUMBER:
          removeProductFromRegister();
          break;

        case CHANGE_PRODUCT_INFORMATION:
          changeProductInformation();
          break;

        case EXIT:
          System.out.println("\n Thank you for using the application.\n");
          quit = true;
          break;

        default:
          System.err.println(
                "\nERROR: Please enter a number between 0 and " + this.menuItems.length + "..\n");
      }
    }
  }

  /**
   * Allows the user to choose between searching for a product by product number or description.
   * Also prints out the products found.
   */
  private void searchProduct() {
    System.out.println("What do you wish to search with? \n"
          + "1. Product number \n"
          + "2. Description \n");
    switch (getMenuChoice(2)) {
      case PRODUCT_NUMBER:
        searchProductNumber();
        break;
      case DESCRIPTION:
        searchDescription();
        break;
      case EXIT:
        break;
      default:
        System.err.println("\n ERROR: Please enter a number between 0 and 2 \n");
    }
  }

  /**
   * Menu to let the user select what he wants to change about a product.
   */
  private void changeProductInformation() {
    System.out.println("Please select what you want to change: \n"
          + "1. Description of a product \n"
          + "2. Price of a product \n");
    switch (getMenuChoice(2)) {
      case CHANGE_PRODUCT_DESCRIPTION:
        changeDescription();
        break;

      case CHANGE_PRODUCT_PRICE:
        changePrice();
        break;

      case EXIT:
        break;

      default:
        System.err.println("\n ERROR: Please enter a number between 0 and 2 \n");
    }
  }

  /**
   * Method which prompts the user to enter a product number
   * used to call searchProductByProductNumber().
   * Prints out all products with product numbers that contain the entered value.
   */
  private void searchProductNumber() {
    String enteredProductNumber;
    do {
      System.out.println("Enter the product number you wish to search for: ");
      enteredProductNumber = sc.nextLine();
    } while (enteredProductNumber.isEmpty());

    //Prints out all the products that contain the entered product number.
    register.searchProductByProductNumber(enteredProductNumber)
          .forEach(product -> System.out.println(product.productDetails()));
  }

  /**
   * Method which prompts the user to enter a description used to call searchProductByDescription().
   * Prints out all products with descriptions that contain the entered value.
   */
  private void searchDescription() {
    String enteredDescription;
    do {
      System.out.println("Enter the description you wish to search for: ");
      enteredDescription = sc.nextLine();
    } while (enteredDescription.isEmpty());

    //Prints out all the products that contain the entered description.
    register.searchProductByDescription(enteredDescription)
          .forEach(product -> System.out.println(product.productDetails()));
  }

  /**
   * Method to let the user add a long jump result to the register.
   * The method also uses other methods to validate the input from the user.
   */
  private void addProductFromUser() {
    boolean alreadyExists;
    String tempProductNumber;
    do {
      System.out.println("Enter the product number: ");
      tempProductNumber = sc.nextLine();
      alreadyExists = register.isProductNumberInRegister(tempProductNumber);
      if (alreadyExists) {
        System.err.println("That product number is already in the register. ");
      }
    } while (tempProductNumber.isEmpty() || alreadyExists);

    String tempDescription;
    do {
      System.out.println("Enter a description for the product: ");
      tempDescription = sc.nextLine();
    } while (tempDescription.isEmpty());

    int tempPrice;
    System.out.println("Enter a price for the product: ");
    tempPrice = intCheckerPositive();
    clearScanner();

    String tempBrand;
    do {
      System.out.println("Enter the brand of the product: ");
      tempBrand = sc.nextLine();
    } while (tempBrand.isEmpty());

    double tempWeight;
    System.out.println("Enter the weight of the product: ");
    tempWeight = doubleCheckerPositive();
    clearScanner();

    double tempLength;
    System.out.println("Enter the length of the product: ");
    tempLength = doubleCheckerPositive();
    clearScanner();

    double tempHeight;
    System.out.println("Enter the height of the product: ");
    tempHeight = doubleCheckerPositive();
    clearScanner();

    String tempColor;
    do {
      System.out.println("Enter the color of the product: ");
      tempColor = sc.nextLine();
    } while (tempColor.isEmpty());

    int tempStock;
    System.out.println("Enter the stock for the product: ");
    tempStock = intCheckerPositive();
    clearScanner();

    ProductCategory tempCategory;
    do {
      System.out.println("Enter a category for the product: ");
      String categoryToSearch = sc.nextLine().toUpperCase();
      tempCategory = register.getCategoryFromList(categoryToSearch);
      if (tempCategory == null) {
        System.err.println("That category is not valid.");
      }
    } while (tempCategory == null);

    if (register.addProduct(new Product(tempProductNumber, tempDescription, tempPrice, tempBrand,
          new ProductSpecifications(tempWeight, tempLength, tempHeight, tempColor), tempStock, tempCategory))) {
      System.out.println("Product with product number " + tempProductNumber + " was added.");
    } else {
      System.err.println("Failed to add product with product number: " + tempProductNumber + ".");
    }
  }

  /**
   * Lets the user change the description of a product.
   */
  private void changeDescription() {
    Product productToChange = selectProduct();
    String tempDescription;
    if (productToChange == null) {
      return;
    }
    do {
      System.out.println("Enter the new description for the product: ");
      tempDescription = sc.nextLine();
    } while (tempDescription.isEmpty());
    productToChange.setDescription(tempDescription);
  }

  /**
   * Lets the user change the price of a product.
   */
  private void changePrice() {
    Product productToChange = selectProduct();
    int tempPrice;
    if (productToChange == null) {
      return;
    }
    System.out.println("Enter the new price for the product: ");
    tempPrice = intCheckerPositive();
    productToChange.setPrice(tempPrice);

    clearScanner();
  }

  /**
   * Lets the user change the stock of the product the user entered.
   */
  private void changeStock() {
    Product productToChange = selectProduct();
    int tempStock;
    if (productToChange == null) {
      return;
    }
    System.out.println("Enter the change in stock for the product: ");
    tempStock = intChecker();
    productToChange.setStock(productToChange.getStock() + tempStock);

    clearScanner();
  }

  /**
   * Function to make sure the user correctly selects a product by typing in a valid product number.
   * Returns null after 3 tries with an invalid product number.
   * Returns the product with the valid product number.
   *
   * @return null or Product
   */
  private Product selectProduct() {
    String tempProductNumber;
    int tries = 0;
    do {
      if (tries > 2) {
        System.err.println("Failed to provide a valid product number \nExiting... ");
        return null;
      }
      System.out.println("Enter the product number you wish to edit: ");
      tempProductNumber = sc.nextLine();
      if (!register.isProductNumberInRegister(tempProductNumber)) {
        System.err.println("That product number does not exist in the register.");
      }
      tries++;
    } while (tempProductNumber.isEmpty() || !register.isProductNumberInRegister(tempProductNumber));
    return register.getProductRegister().get(tempProductNumber);
  }

  /**
   * Method to remove a product from the register by user input.
   */
  private void removeProductFromRegister() {
    String tempProductNumber;
    do {
      System.out.println("Enter the product number: ");
      tempProductNumber = sc.nextLine();
    } while (tempProductNumber.isEmpty());

    if (register.removeProductByProductNumber(tempProductNumber)) {
      System.out.println("Successfully removed product with product number: "
            + tempProductNumber + "\n");
    } else {
      System.err.println("Could not find a product with that product number.");
    }
  }

  /**
   * Goes to the next line in the scanner.
   * This is to avoid an issue where using nextLine() after next() skips a line.
   */
  private void clearScanner() {
    sc.nextLine();
  }

  /**
   * Checks if the user input is an int.
   *
   * @return valid int value
   */
  private int intChecker() {
    while (!sc.hasNextInt()) {
      System.err.println("Please enter an integer value, only whole numbers (no decimals): ");
      sc.next();
    }
    return sc.nextInt();
  }

  /**
   * Checks if the input int is positive.
   *
   * @return positive int
   */
  private int intCheckerPositive() {
    int userInput = intChecker();
    while (userInput < 0) {
      System.err.println("Please enter a positive integer: ");
      userInput = intChecker();
    }
    return userInput;
  }

  /**
   * Checks if the input double is valid.
   *
   * @return valid double value
   */
  private double doubleChecker() {
    while (!sc.hasNextDouble()) {
      System.err.println("Please enter a double value (1 or 1.1): ");
      sc.next();
    }
    return sc.nextDouble();
  }

  /**
   * Checks if the input double is positive.
   *
   * @return positive double
   */
  private double doubleCheckerPositive() {
    double userInput = doubleChecker();
    while (userInput < 0) {
      System.err.println("Please enter a positive double value: ");
      userInput = doubleChecker();
    }
    return userInput;
  }

  /**
   * Displays the menu to the user, and waits for the users input. The user is
   * expected to input an integer between 0 and the max number of menu items.
   * The method returns the input from the user. If the input from the user is
   * invalid, -1 is returned.
   *
   * @return the menu number (between 0 and max menu item number) provided by
   *      the user.
   */
  private int getMenuChoice(int amountOfItems) {
    int menuSelection = -1;

    System.out.println("0. Exit\n");
    System.out.println("Please choose menu item (0-" + amountOfItems + "): ");

    Scanner reader = new Scanner(System.in);
    if (reader.hasNextInt()) {
      menuSelection = reader.nextInt();
    } else {
      System.err.println("You must enter a number, not text");
    }
    return menuSelection;
  }

  /**
   * Prints version of the program and the menu items.
   */
  private void printProgramDetails() {
    System.out.println("\n**** Product Register " + VERSION + " ****\n");
    for (String menuItem : menuItems) {
      System.out.println(menuItem);
    }
  }
}
