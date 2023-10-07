import java.util.Scanner;

public class Motherboard {
    private String name = "";
    private String socket = "";
    private String chipset = "";
    private RAMType supportedRAMType = RAMType.DDR;

    public Motherboard() {

    }
    public Motherboard(String name) {
        this.name = name;
    }
    public Motherboard(String name, String socket, String chipset, RAMType supportedRAMType) {
        this.name = name;
        this.socket = socket;
        this.chipset = chipset;
        this.supportedRAMType = supportedRAMType;
    }

    public String GetName() { return name; }
    public String GetSocket() { return socket; }
    public String GetChipset() { return chipset; }
    public RAMType GetSupportedRAMType() { return supportedRAMType; }

    public void Input() {
        String name, socket, chipset;
        RAMType supportedRAMType;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите название материнской платы: ");
        name = scan.nextLine();
        System.out.print("Введите сокет: ");
        socket = scan.nextLine();
        System.out.print("Введите чипсет: ");
        chipset = scan.nextLine();
        System.out.print("Введите поддерживаемый тип памяти (DDR - 0, DDR2 - 1, DDR3 - 2, DDR4 - 3, DDR5 - 4): ");
        supportedRAMType = RAMType.IntToRAMType(scan.nextInt());

        this.name = name;
        this.socket = socket;
        this.chipset = chipset;
        this.supportedRAMType = supportedRAMType;
    }

    @Override public String toString()
    {
        return (this.GetName() + ", " + this.GetSocket() + ", " + this.GetChipset());
    }
}
