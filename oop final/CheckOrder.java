import java.util.ArrayList;
import java.util.Scanner;

public class CheckOrder {
    Order order = new Order(null, 0, 0);
    private int choice;


   public void checkOrder(ArrayList<Order> cOrder){
    Scanner input = new Scanner(System.in);
    CheckOut checkOut = new CheckOut();
    for (int i = 0; i < cOrder.size(); i++) {
        Order item = cOrder.get(i);
        System.out.printf("%n%d. %d x %-10s = P%.2f%n", i + 1, item.getQuantity(), item.getchName(), item.getTotal() * item.getQuantity());
    }
    order.showTotal(cOrder);
    System.out.printf("%nTOTAL: \t\t    P%.2f%n", order.getTotal());
    
    System.out.print("Check Out [1] | Back [2]: ");
    choice = input.nextInt();
    setchoice(choice);
    switch (choice) {
        case 1:
            checkOut.makeReceipt(cOrder);
            break;
        case 2:
            Main.acc();
            break;
        default:
            break;
    }
    input.close();
    }

    public void setchoice(int choice){
        this.choice = choice;
    }
    public int getchoice(){
        return choice;
    }
}
