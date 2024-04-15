import java.util.ArrayList;
import java.util.*;

public class Main {
    public static ArrayList<Menu> menus = new ArrayList<>();
    public static ArrayList<Order> cOrder = new ArrayList<>();
    //Available menu items
    private static void menuItem(){
        menus.add(new Menu("Tapsilog", 90.00));
        menus.add(new Menu("Tocilog", 80.00));  
        menus.add(new Menu("Chicken Katsu", 120.00));
        menus.add(new Menu("Pork Steak", 100.00));
        menus.add(new Menu("Liempo", 150.00));
        menus.add(new Menu("Siomai", 25.00));
    }

    public static void setOrder(String chName, int qty, double total){
        cOrder.add(new Order(chName, qty, total));
    }
    //Show the display of menu
    public static void displayMenu() {
        Scanner input = new Scanner(System.in);
        Order order = new Order(null, 0, 0);
        System.out.println("**********JCRM MENU**********");
        for (int i = 0; i < menus.size(); i++) {
            Menu item = menus.get(i);
            System.out.printf("%d. %-20sP%.2f%n", i + 1, item.getmenu_Name(), item.getmenu_Price());
        }
        System.out.println("------------------------------\n");

        System.out.print("What will you like to order?[1-6]: ");
        int chosen = input.nextInt();
        String chName = menus.get(chosen - 1).getmenu_Name();

        System.out.printf("%nQuantity of %s: ", menus.get(chosen - 1).getmenu_Name());
        int qty = input.nextInt();
        double total = menus.get(chosen - 1).getmenu_Price();
        setOrder(chName, qty, total);
        

        //THIS IS FOR THE CHECK ORDER
        for (int i = 0; i < cOrder.size(); i++) {
            Order item = cOrder.get(i);
            System.out.printf("%n%d. %d x %-10s = P%.2f%n", i + 1, item.getQuantity(), item.getchName(), item.getTotal() * item.getQuantity());
        }

        order.showTotal(cOrder);
        System.out.printf("%nTOTAL: \t\t    P%.2f%n", order.getTotal());

        acc();
        input.close();
    }

    public static void pOrder(ArrayList<Order> cOrder){
        for (int i = 0; i < cOrder.size(); i++) {
            Order item = cOrder.get(i);
            System.out.printf("%n%d. %d x %-10s = P%.2f%n", i + 1, item.getQuantity(), item.getchName(), item.getTotal());
            acc();
        }
    }

    public static void acc(){
        
        int choice = 0;
        Scanner input = new Scanner(System.in);
        
        System.out.print("\nAdd more [1] | Check Order [2] | Change order [3]: ");

        choice = input.nextInt();
        bck(choice);
        input.close();
    }
    public static void bck(int choice){
        CheckOrder co = new CheckOrder();
        ChangeOrder changeorder = new ChangeOrder();
        switch (choice) {
            case 1:
                displayMenu();
                break;
            case 2:
                co.checkOrder(cOrder);
                break;
            case 3:
                changeorder.changeOrder(cOrder);
                break;        
            default:
                break;
        }
        
    }
    public static void main(String[] args) {
        
        menuItem();
        
        displayMenu();
    }
}
