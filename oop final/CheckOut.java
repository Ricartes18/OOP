import java.util.*;

public class CheckOut {
    Order order = new Order(null, 0, 0);
    private double cash;

    public void setCash(double cash){
        this.cash = cash;
    }

    public double getCash(){
        return cash;
    }

    public void putCash(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input your Cash: P");
        setCash(input.nextDouble());
        input.close();
    }

    public void makeReceipt(ArrayList<Order> cOrder){
        putCash();
        System.out.println("\n********** RECEIPT **********");
        //ORDER
        for (int i = 0; i < cOrder.size(); i++) {
            Order item = cOrder.get(i);
            System.out.printf("%d x %-13s = P%.2f%n", item.getQuantity(), item.getchName(), item.getTotal());
        }
        //CASH
        
        System.out.printf("%nCASH:  \t\t    P%.2f",getCash());

        //TOTAL
        order.showTotal(cOrder);
        System.out.printf("%nTOTAL: \t\t    P%.2f%n", order.getTotal());
        
        //CHANGE
        System.out.printf("%nCHANGE:\t\t    P%.2f%n", (getCash() - order.getTotal()));
    }
}
