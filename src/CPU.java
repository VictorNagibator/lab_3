import java.util.Scanner;

public class CPU {
    private String name = "";
    private String socket = "";
    private float frequency;
    private int numOfCores;
    public final float maxFreq = 9.0F; //условная максимальная тактовая частота для процессора
    public final float tryFreq = 0.2F; //условное повышение частоты для разгона

    public CPU() {

    }
    public CPU(String name) {
        this.name = name;
    }
    public CPU(String name, String socket, float frequency, int numOfCores) {
        setArguments(name, socket, frequency, numOfCores);
    }

    public String getName() { return name; }
    public String getSocket() { return socket; }
    public float getFrequency() { return frequency; }
    public int getNumOfCores() { return numOfCores; }

    public void input() {
        String name, socket;
        float frequency;
        int numOfCores;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите название процессора: ");
        name = scan.nextLine();
        System.out.print("Введите сокет: ");
        socket = scan.nextLine();
        System.out.print("Введите его тактовую частоту (в ГГц): ");
        frequency = scan.nextFloat();
        System.out.print("Введите количество ядер: ");
        numOfCores = scan.nextInt();

        setArguments(name, socket, frequency, numOfCores);
    }

    private boolean checkArguments(String name, String socket, float frequency, int numOfCores) {
        return (frequency >= 0) && (frequency < maxFreq) && (numOfCores >= 0);
    }
    private void setArguments(String name, String socket, float frequency, int numOfCores) {
        if (checkArguments(name, socket, frequency, numOfCores)) {
            this.name = name;
            this.socket = socket;
            this.frequency = frequency;
            this.numOfCores = numOfCores;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }

    @Override public String toString()
    {
        return (this.getName() + ", " + this.getSocket() + ", " + this.getFrequency() + " ГГц, " + this.getNumOfCores() + "-ядерный");
    }
}