import java.util.Scanner;

public class Laptop {
    private String name = "";
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Motherboard motherboard;
    private Display display;

    public Laptop() {
        cpu = new CPU();
        gpu = new GPU();
        ram = new RAM();
        motherboard = new Motherboard();
        display = new Display();
    }
    public Laptop(String name) {
        this.name = name;
        cpu = new CPU();
        gpu = new GPU();
        ram = new RAM();
        motherboard = new Motherboard();
        display = new Display();
    }
    public Laptop(String name, CPU cpu, GPU gpu, RAM ram, Motherboard motherboard, Display display) {
        this.name = name;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.motherboard = motherboard;
        this.display = display;
    }

    public String GetName() { return name; }
    public CPU GetCPU() { return cpu; }
    public GPU GetGPU() { return gpu; }
    public RAM GetRAM() { return ram; }
    public Motherboard GetMotherboard() { return motherboard; }
    public Display GetDisplay() { return display; }

    //вот здесь остановился, нужно сделать set для всех полей

    public void Input() {
        String name;
        RAMType type;
        float frequency;
        int capacity;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите название RAM: ");
        name = scan.nextLine();
        System.out.print("Введите тип памяти (DDR - 0, DDR2 - 1, DDR3 - 2, DDR4 - 3, DDR5 - 4): ");
        type = RAMType.IntToRAMType(scan.nextInt());
        System.out.print("Введите тактовую частоту (в МГц): ");
        frequency = scan.nextFloat();
        System.out.print("Введите объем (в ГБ): ");
        capacity = scan.nextInt();

        SetArguments(name, type, frequency, capacity);
    }

    private boolean CheckArguments(String name, RAMType type, float frequency, int capacity) {
        return (frequency >= 0) && (frequency <= DDRFreqMax[type.ordinal()]) && (capacity >= 0);
    }
    private void SetArguments(String name, RAMType type, float frequency, int capacity) {
        if (CheckArguments(name, type, frequency, capacity)) {
            this.name = name;
            this.type = type;
            this.frequency = frequency;
            this.capacity = capacity;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }

    @Override public String toString()
    {
        return (this.GetName() + ", " + this.GetRAMType() + ", " + this.GetCapacity() + " ГБ, " + this.GetFrequency() + " МГц");
    }
}