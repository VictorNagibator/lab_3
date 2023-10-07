import java.util.Scanner;

public class GPU {
    private String name = "";
    private float frequency;
    private int vram;

    public GPU() {

    }
    public GPU(String name) {
        this.name = name;
    }
    public GPU(String name, float frequency, int vram) {
        SetArguments(name, frequency, vram);
    }

    public String GetName() { return name; }
    public float GetFrequency() { return frequency; }
    public int GetVRAM() { return vram; }

    public void Input() {
        String name;
        float frequency;
        int vram;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите название видеокарты: ");
        name = scan.nextLine();
        System.out.print("Введите тактовую частоту графического процессора (в МГц): ");
        frequency = scan.nextFloat();
        System.out.print("Введите объем видеопамяти (в ГБ): ");
        vram = scan.nextInt();

        SetArguments(name, frequency, vram);
    }

    private boolean CheckArguments(String name, float frequency, int vram) {
        return (frequency >= 0) && (vram >= 0);
    }
    private void SetArguments(String name, float frequency, int vram) {
        if (CheckArguments(name, frequency, vram)) {
            this.name = name;
            this.frequency = frequency;
            this.vram = vram;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }

    @Override public String toString()
    {
        return (this.GetName() + ", " + this.GetFrequency() + " МГц, " + this.GetVRAM() + " ГБ");
    }
}