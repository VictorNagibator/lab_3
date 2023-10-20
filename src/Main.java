public class Main {
    public static void main(String[] args) {
        //пример работы с Laptop
        Laptop[] laptopList = new Laptop[2];

        laptopList[0] = new Laptop();
        laptopList[0].input();
        System.out.println();
        laptopList[1] = new Laptop();
        laptopList[1].input();
        System.out.println();

        System.out.println(laptopList[0] + "\n");
        System.out.println(laptopList[1] + "\n");
        laptopList[0].boostCPU();
        System.out.println(laptopList[0] + "\n");

        //пример работы с Order
        Order orderExample = new Order(laptopList[1]);
        orderExample.setStatus(StatusType.FINISHED);
        System.out.println(orderExample);
    }
}