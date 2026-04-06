import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Main Driver Class
 * This is where the app runs
 * (%n - OS aware whereas \n -- basic new line)
 */

public class Lunch {

  public static void main(String[] args) {

    //  Setting up our tools
    Scanner input = new Scanner(System.in);
    SecureRandom random = new SecureRandom();  

    //  This is our stack of order tickets (max 10 for now)
    LunchBox[] orders = new LunchBox[10];

    //  The list of free desserts we can give away
    String[] desserts = {
      "Chocolate Chip Cookie", "Fudge Brownie", "Blueberry Pie", "Velvet Cake", "Ice Cream Blizzard", "Tim Bits", 
      "Apple Crumble", "Peach Cobbler", "Fruit Salad", "Brown Sugar Boba Tea", "Newton Fig Bar",
      "Churro", "Vanilla Gelato"
    };

    //  Trackers for our loop
    int orderCount = 0;
    boolean open24_7 = true;
    // End of setup block

    //---  The MAIN MENU Loop ---//
    //  This keeps the "cafteria open" until we hit Exit
    while (open24_7) {
      System.out.println("\n--- Chef Lamsey's LUNCHBOX ---\n");
      System.out.println("1. Add a NEW order");
      System.out.println("2. Add quantity to an order");
      System.out.println("3. Mark order as delivered");
      System.out.println("4. Calculate total sales");
      System.out.println("5. View all orders");
      System.out.println("6. Exit");
      System.out.print("\nChoice: ");

      int choice = input.nextInt();
      input.nextLine(); // Clear 

      switch (choice) {
        case 1:
         if (orderCount < orders.length) {
            System.out.print("\nEnter Customer Name: ");
            String name = input.nextLine();

            //  --- New Mini Menu ---
            System.out.println("\nMenu: Pizza, Sandwich, Sushi, Pasta, Burger, Beef Pho, Shawarma, Poutine");
            // ----------------------

            System.out.print("\nEnter Main Item: ");
            String item = input.nextLine();
            System.out.print("\nEnter Quanity: ");
            int qty = input.nextInt();
            System.out.print("\nEnter Price: ");
            double prc = input.nextDouble();

            //  Clear 
            input.nextLine();
            //  Create new ticket
            orders[orderCount] = new LunchBox(name, item, qty, prc);
            //  Roll dice for random dessert
           
            int dessertIndex = 
            random.nextInt(desserts.length);
            String freebie =
              desserts[dessertIndex];

              orders[orderCount].setFreeDessert(freebie);

              System.out.println("\nOrder added! Bonus: Free " + freebie);

              //  Move to next slot
              orderCount++;
         } else {
          System.out.println("Kitchen full! No more orders.");
         }
         break;
         // End of case 1 block

         case 2:
          System.out.println("\n--- Add Quantity to Order ---");

          //  Check if kitchen is empty
          if (orderCount == 0) {
            System.out.println("No orders yet, call Chef Ramsey :)");
          
          } else {
              //  Ask for hu-man order number -- so we have to subtract 1
              System.out.print("Enter Order # (1-" + orderCount + "): ");
              int orderNum = input.nextInt();

              //  Convert to computer array 
              int targetIndex = orderNum - 1;

              //  Validate they didn't type a crazy number
              if (targetIndex >= 0 && targetIndex < orderCount) {
                System.out.print("Enter amount to add: ");
                int extraQty = input.nextInt();

                //  Retrieve current, add new, and set it
                int currentQty = orders[targetIndex].getQuantity();

                orders[targetIndex].setQuantity(currentQty + extraQty);

                System.out.println("Invalid Order Number");
              }
          } 
          break;
          //  End Case 2 Block

          case 3:
            System.out.println("\n--- Mark Delivered ---");

            //  Deja Vu -- Check if Kitchen is empty
            if (orderCount == 0) {
              System.out.println("No orders yet :(");
            } else {
              // ask for hu-man order number
              System.out.print("Enter Order # (1-" + orderCount + "):");
              int deliverNum = input.nextInt();

              //  Convert to array index
              int deliverIndex = deliverNum - 1;

              //  Validate they typed a real ticket
              if (deliverIndex >= 0 && deliverIndex < orderCount) {

                //  Trigger blueprint action
                orders[deliverIndex].markDelivered();
                System.out.println("Order marked as delivered!");
              } else {
                System.out.println("Invalid Order Number.");
              }
            }
            break;
            //  End of Case 3 block

         case 4:
          System.out.println("\n--- Grand Total ---");

            if (orderCount == 0) {
              System.out.println("No sales yet today.  Offer free dessert as a promotion");
            
            } else {
              double grandTotal = 0.00;
              for (int i = 0; i < orderCount; i++) {
                // Add this ticket's cost to the total
                grandTotal +=
                orders[i].calculateCost();
              }

              //  Print 
              System.out.printf("Grand Total Sales: $%.2f%n",
                grandTotal);
            }
            break;
            //  End case 4 block

         case 5: 
            System.out.println("\n--- All Current Orders ---");

            //  First, let's check if we actually have any tickets
            if (orderCount == 0) {
              System.out.println("The kitchen has no orders.  The chef is on vacation.");
            } else {
              // We are looping through using orderCount, not orders.length
              for (int i = 0; i < orderCount; i++) {

                // Print order number (adding 1 so the hu-mans see Order #1, not Order #0)
                System.out.println("Order # " + (i + 1));

                //  Call action method from blueprint
                orders[i].displayOrder();
              }
            }
            break;
            //  End of case 5 block

         case 6:
          open24_7 = false;
          System.out.println("Goodbye");
          break;
          //  End of case 6 block

          default:
            System.out.println("Choice no good.");
          
         }  // End of switch block
        }   // End of main menu loop block

        input.close();
      } //  End of main method 
    } //  End of lunch class -- TA DA!


