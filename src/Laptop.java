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
        SetArguments(name, cpu, gpu, ram, motherboard, display);
    }

    public String GetName() { return name; }
    public CPU GetCPU() { return cpu; }
    public GPU GetGPU() { return gpu; }
    public RAM GetRAM() { return ram; }
    public Motherboard GetMotherboard() { return motherboard; }
    public Display GetDisplay() { return display; }

    public void SetName(String name) {
        this.name = name;
    }
    public void SetCPU(CPU cpu) {
        if (CheckArguments(this.name, cpu, this.gpu, this.ram, this.motherboard, this.display)) {
            this.cpu = cpu;
        }
        else throw new IllegalArgumentException("Неподходящий сокет!");
    }
    public void setGPU(GPU gpu) {
        this.gpu = gpu;
    }
    public void setRam(RAM ram) {
        if (CheckArguments(this.name, this.cpu, this.gpu, ram, this.motherboard, this.display)) {
            this.ram = ram;
        }
        else throw new IllegalArgumentException("Неподходящий тип памяти!");
    }
    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;

        if (this.cpu.GetSocket() != motherboard.GetSocket()) { this.cpu = new CPU(); }
        if (this.ram.GetRAMType() != motherboard.GetSupportedRAMType()) { this.ram = new RAM(motherboard.GetSupportedRAMType()); }
    }
    public void SetDisplay(Display display) {
        this.display = display;
    }

    public void Input() {
        String name;
        CPU cpu = new CPU();
        GPU gpu = new GPU();
        RAM ram = new RAM();
        Motherboard motherboard = new Motherboard();
        Display display = new Display();

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите название ноутбука: ");
        name = scan.nextLine();
        System.out.println("\tВвод параметров процессора");
        cpu.Input();
        System.out.println("\tВвод параметров видеокарты");
        gpu.Input();
        System.out.println("\tВвод параметров RAM");
        ram.Input();
        System.out.println("\tВвод параметров материнской платы");
        motherboard.Input();
        System.out.println("\tВвод параметров экрана");
        display.Input();

        SetArguments(name, cpu, gpu, ram, motherboard, display);
    }

    private boolean CheckArguments(String name, CPU cpu, GPU gpu, RAM ram, Motherboard motherboard, Display display) {
        return (cpu.GetSocket().equals(motherboard.GetSocket())) && (ram.GetRAMType() == motherboard.GetSupportedRAMType());
    }
    private void SetArguments(String name, CPU cpu, GPU gpu, RAM ram, Motherboard motherboard, Display display) {
        if (CheckArguments(name, cpu, gpu, ram, motherboard, display)) {
            this.name = name;
            this.cpu = cpu;
            this.gpu = gpu;
            this.ram = ram;
            this.motherboard = motherboard;
            this.display = display;
        }
        else throw new IllegalArgumentException("Несовместимые комплектующие!");
    }

    @Override public String toString()
    {
        String result = "Название модели: " + this.name + "\n" +
                        "CPU: " + this.cpu + "\n" +
                        "GPU: " + this.gpu + "\n" +
                        "RAM: " + this.ram + "\n" +
                        "Материнская плата: " + this.motherboard + "\n" +
                        "Экран: " + this.display;
        return result;
    }

    public void BoostCPU() {
        if (this.cpu.GetFrequency() + this.cpu.tryFreq <= this.cpu.maxFreq) {
            this.cpu = new CPU(this.cpu.GetName(), this.cpu.GetSocket(), this.cpu.GetFrequency() + this.cpu.tryFreq, this.cpu.GetNumOfCores());
        }
	    else if (this.cpu.GetFrequency() < this.cpu.maxFreq) {
            this.cpu = new CPU(this.cpu.GetName(), this.cpu.GetSocket(), this.cpu.maxFreq, this.cpu.GetNumOfCores());
        }
	    else System.out.println("Разгон CPU больше невозможен!");
    }
    public void BoostRAM() {
        float maxFreq = this.ram.DDRFreqMax[this.ram.GetRAMType().ordinal()];
        if (this.ram.GetFrequency() + this.ram.tryFreq <= maxFreq) {
            ram = new RAM(this.ram.GetName(), this.ram.GetRAMType(), this.ram.GetFrequency() + this.ram.tryFreq, this.ram.GetCapacity());
        }
	    else if (this.ram.GetFrequency() < maxFreq) {
            ram = new RAM(this.ram.GetName(), this.ram.GetRAMType(), maxFreq, this.ram.GetCapacity());
        }
	    else System.out.println("Разгон RAM больше невозможен!");
    }
}