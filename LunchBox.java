/**
 * 
 * Fields Block
 * 
 */



public class LunchBox {
  
  // We keep it private so nobody outside da
  // kitchen messes with them.
  private String customerName;
  private String mainItem;
  private int quantity;
  private double price;
  private boolean isDelivered;
  // End Fields Block

  // Default Constructor
  // Grabbing a completely blank ticket order thingamajig
  public LunchBox() {
    this.customerName = "";
    this.mainItem = "";
    this.quantity = 0;
    this.price = 0.0;
    this.isDelivered = false;
  }   // End of Default Constructor Block

  // Now we pick the Constructor with Arguments
  // I am taking the main details and defaulting 
  // delivery to "true".
  public LunchBox(
    String customerName,
    String mainItem, 
    int quantity,
    double price
  ) {
    this.customerName = customerName;
    this.mainItem = mainItem;
    this.quantity = quantity;
    this.price = price;
    this.isDelivered = false;
  }   // End of Arguments Constructor Block

  private String freeDessert;
  public String getFreeDessert() {
    return freeDessert;
  }
  public void setFreeDessert(
    String freeDessert
  ) {
    this.freeDessert = freeDessert;    
  } 
  //  End of Free Dessert Block


/**
 * 
 * Go GEtters BLock
 * 'ONLY' reads the ticket
 * 
 */
public String getCustomerName() {
  return customerName;
    }
public String getMainItem() {
  return mainItem;
}
public int getQuantity() {
  return quantity;
}
public double getPrice() {
  return price;
}
public boolean getIsDelivered() {
  return isDelivered;
}
// end of Go Getters Blocks


/**
 * 
 * Setters Block
 * Updates the ticket, changes the
 * order's details
 * 
 */

public void setCustomerName(
  String customerName
) {
  this.customerName = customerName;
}
public void setMainItem(
  String mainItem
) {
  this.mainItem = mainItem;
}
public void setQuantity(
  int quantity
) {
  this.quantity = quantity;
}
public void setPrice(
  double price
) {
  this.price = price;
}
public void setIsDelivered(
  boolean isDelivered
) {
  this.isDelivered = isDelivered;
}
// End of Setters Block


/**
 * 
 * ACTION Methods Block -- calculate, mark, display
 * 
 */
public double calculateCost() {
  return quantity * price;
}
public void markDelivered() {
  this.isDelivered = true;
}
public void displayOrder() {
  System.out.println("Customer: " + customerName);
  System.out.println("Item: " + mainItem);
  System.out.println("Quantity: " + quantity);
  System.out.printf("Lunch Price: $%.2f%n", price);
  System.out.printf("Total: $%.2f%n", calculateCost());
  
  if (isDelivered) {
            System.out.println("Delivered: Success!");
        } else {
            System.out.println("Delivery in 30 min or it's free!");
        }

        //  Display Dessert Block
        System.out.println("Promotion: Free Dessert! " + freeDessert);
        // End Display Dessert BLock

  System.out.println("-------------------------");
  } // End of Action Methods BLock
}// End LunchBox Class BLock - TA DA!






