import java.util.Scanner;

public class Order {
    private int num;
    private Laptop laptop;
    private StatusType status;
    private static int numOfOrders = 1; //количество заказов

    public Order() {
        this.num = numOfOrders;
        this.laptop = new Laptop();
        this.status = StatusType.ONHOLD;

        numOfOrders++;
    }
    public Order(Laptop laptop) {
        this.num = numOfOrders;
        this.laptop = laptop;
        this.status = StatusType.ONHOLD;

        numOfOrders++;
    }
    public Order(Laptop laptop, StatusType status) {
        this.num = numOfOrders;
        this.laptop = laptop;
        this.status = status;

        numOfOrders++;
    }

    public int GetNum() { return num; }
    public Laptop GetLaptop() { return laptop; }
    public StatusType GetStatus() { return status; }
    public void SetLaptop(Laptop laptop) { this.laptop = laptop; }
    public void SetStatus(StatusType status) { this.status = status; }

    public void Input() {
        Laptop laptop = new Laptop();
        StatusType status;

        Scanner scan = new Scanner(System.in);

        System.out.println("\tВвод параметров ноутбука");
        laptop.Input();
        System.out.print("\nВведите статус заказа (0 - в ожидании, 1 - в ремонте, 2 - отремонтирован): ");
        status = StatusType.IntToStatusType(scan.nextInt());

        this.laptop = laptop;
        this.status = status;
    }

    @Override public String toString()
    {
        return num + ". " + laptop.GetName() + "\t" + status;
    }
}