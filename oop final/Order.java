import java.util.ArrayList;

public class Order{
    private int quantity;
    private String chName;
    private double total;

    public Order(String chName, int quantity, double total){
        this.chName = chName;
        this.quantity = quantity;
        this.total = total;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return quantity;
    }

    public String getchName(){
        return chName;
    }

    //public ArrayList<Order> cOrder = new ArrayList<>();
    
    // public void setOrder(String chName, int qty, double total){
    //     cOrder.add(new Order(chName, qty, total));
    // }
    public void setTotal(double total){
        this.total = total;
    }
    public double getTotal(){
        return total;
    }
    // public static void setOrder(){
    //     cOrder.add(new Order(chosen, qty));
    // }
    
    public void showTotal(ArrayList<Order> cOrder){
        double sumTotal = 0.00;

        for (int i = 0; i < cOrder.size(); i++) {
            Order item = cOrder.get(i);
            double atotal = item.getTotal();
            sumTotal += atotal * item.getQuantity();
        }
        setTotal(sumTotal);
    }
}
