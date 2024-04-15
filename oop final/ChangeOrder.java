import java.util.*;

public class ChangeOrder {
    Order order = new Order(null, 0, 0);
    private Boolean remove;

    public void remove(Boolean remove){
        this.remove = remove;
    }

    public Boolean orderRemove(){
        return remove;
    }

    public void changeOrder(ArrayList<Order> cOrder){
        Scanner input = new Scanner(System.in);
        
        for (int i = 0; i < cOrder.size(); i++) {
            Order item = cOrder.get(i);
            System.out.printf("%d. %d x %-13s = P%.2f%n",i + 1, item.getQuantity(), item.getchName(), item.getTotal() * item.getQuantity());
        }
        
        System.out.print("\nWhat item will you change? : ");
        int item = input.nextInt();
        System.out.printf("%s %n", cOrder.get(item - 1).getchName());

        System.out.print("\nChange Quantity [1] | Remove Item [2] | Back [3]: ");
        int change = input.nextInt();

        Order itemc = cOrder.get(item-1);

        

        switch (change) {
            case 1:
                System.out.printf("%d %s",itemc.getQuantity(), itemc.getchName());
                System.out.print("\nChange Quantity: ");
                int rem = input.nextInt();
                cOrder.get(item - 1).setQuantity(rem);
                Main.pOrder(cOrder);
                break;
            case 2:
                System.out.printf("%d %s",itemc.getQuantity(), itemc.getchName());
                System.out.print("\nRemove [y/n]: ");
                char yn = input.next().charAt(0);
                if (Character.toLowerCase(yn) == 'y'){
                    cOrder.remove(item-1);
                    if (cOrder.size() == 0) {
                        Main.displayMenu();
                    } else {
                        Main.pOrder(cOrder);
                    }
                } else {
                    Main.pOrder(cOrder);
                }
                break;
            case 3:
                Main.acc();
                break;
            default:
                break;
        }


        input.close();
    }
    // public static void crb(){

    //     Scanner input = new Scanner(System.in);
    //     System.out.print("\nChange Quantity [1] | Remove Item [2] | Back [3]: ");
    //     int change = input.nextInt();

    // }

}
