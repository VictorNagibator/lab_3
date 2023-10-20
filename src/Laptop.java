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
        setArguments(name, cpu, gpu, ram, motherboard, display);
    }

    public String getName() { return name; }
    public CPU getCPU() { return cpu; }
    public GPU getGPU() { return gpu; }
    public RAM getRAM() { return ram; }
    public Motherboard getMotherboard() { return motherboard; }
    public Display getDisplay() { return display; }

    public void setName(String name) {
        this.name = name;
    }
    public void setCPU(CPU cpu) {
        if (checkArguments(this.name, cpu, this.gpu, this.ram, this.motherboard, this.display)) {
            this.cpu = cpu;
        }
        else throw new IllegalArgumentException("Неподходящий сокет!");
    }
    public void setGPU(GPU gpu) {
        this.gpu = gpu;
    }
    public void setRam(RAM ram) {
        if (checkArguments(this.name, this.cpu, this.gpu, ram, this.motherboard, this.display)) {
            this.ram = ram;
        }
        else throw new IllegalArgumentException("Неподходящий тип памяти!");
    }
    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;

        if (this.cpu.getSocket() != motherboard.getSocket()) { this.cpu = new CPU(); }
        if (this.ram.getRAMType() != motherboard.getSupportedRAMType()) { this.ram = new RAM(motherboard.getSupportedRAMType()); }
    }
    public void setDisplay(Display display) {
        this.display = display;
    }

    public void input() {
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
        cpu.input();
        System.out.println("\tВвод параметров видеокарты");
        gpu.input();
        System.out.println("\tВвод параметров RAM");
        ram.input();
        System.out.println("\tВвод параметров материнской платы");
        motherboard.input();
        System.out.println("\tВвод параметров экрана");
        display.input();

        setArguments(name, cpu, gpu, ram, motherboard, display);
    }

    private boolean checkArguments(String name, CPU cpu, GPU gpu, RAM ram, Motherboard motherboard, Display display) {
        return (cpu.getSocket().equals(motherboard.getSocket())) && (ram.getRAMType() == motherboard.getSupportedRAMType());
    }
    private void setArguments(String name, CPU cpu, GPU gpu, RAM ram, Motherboard motherboard, Display display) {
        if (checkArguments(name, cpu, gpu, ram, motherboard, display)) {
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

    public void boostCPU() {
        if (this.cpu.getFrequency() + this.cpu.tryFreq <= this.cpu.maxFreq) {
            this.cpu = new CPU(this.cpu.getName(), this.cpu.getSocket(), this.cpu.getFrequency() + this.cpu.tryFreq, this.cpu.getNumOfCores());
        }
	    else if (this.cpu.getFrequency() < this.cpu.maxFreq) {
            this.cpu = new CPU(this.cpu.getName(), this.cpu.getSocket(), this.cpu.maxFreq, this.cpu.getNumOfCores());
        }
	    else System.out.println("Разгон CPU больше невозможен!");
    }
    public void boostRAM() {
        float maxFreq = this.ram.DDRFreqMax[this.ram.getRAMType().ordinal()];
        if (this.ram.getFrequency() + this.ram.tryFreq <= maxFreq) {
            ram = new RAM(this.ram.getName(), this.ram.getRAMType(), this.ram.getFrequency() + this.ram.tryFreq, this.ram.getCapacity());
        }
	    else if (this.ram.getFrequency() < maxFreq) {
            ram = new RAM(this.ram.getName(), this.ram.getRAMType(), maxFreq, this.ram.getCapacity());
        }
	    else System.out.println("Разгон RAM больше невозможен!");
    }
}