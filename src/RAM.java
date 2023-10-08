import java.util.Scanner;

public class RAM {
    private String name = "";
    private RAMType type = RAMType.DDR;
    private float frequency;
    private int capacity;
    public final float tryFreq = 50f; //условное повышение частоты для разгона
    public final int[] DDRFreqMax = { 400, 1066, 2400, 3333, 6400 }; //массив максимально возможных частот для каждого типа памяти

    public RAM() {

    }
    public RAM(String name) {
        this.name = name;
    }
    public RAM(RAMType type) {
        this.type = type;
    }
    public RAM(String name, RAMType type, float frequency, int capacity) {
        SetArguments(name, type, frequency, capacity);
    }

    public String GetName() { return name; }
    public RAMType GetRAMType() { return type; }
    public float GetFrequency() { return frequency; }
    public int GetCapacity() { return capacity; }

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