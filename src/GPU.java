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
        setArguments(name, frequency, vram);
    }

    public String getName() { return name; }
    public float getFrequency() { return frequency; }
    public int getVRAM() { return vram; }

    public void input() {
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

        setArguments(name, frequency, vram);
    }

    private boolean checkArguments(String name, float frequency, int vram) {
        return (frequency >= 0) && (vram >= 0);
    }
    private void setArguments(String name, float frequency, int vram) {
        if (checkArguments(name, frequency, vram)) {
            this.name = name;
            this.frequency = frequency;
            this.vram = vram;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }

    @Override public String toString()
    {
        return (this.getName() + ", " + this.getFrequency() + " МГц, " + this.getVRAM() + " ГБ");
    }
}