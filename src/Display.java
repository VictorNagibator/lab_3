import java.util.Scanner;

public class Display {
    private int width;
    private int height;
    private int refreshRate;

    public Display() { }
    public Display(int width, int height) { setArguments(width, height, this.refreshRate); }
    public Display(int width, int height, int refreshRate) {
        setArguments(width, height, refreshRate);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getRefreshRate() { return refreshRate; }

    public void input() {
        int width, height, refreshRate;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите ширину экрана (в пикселях): ");
        width = scan.nextInt();
        System.out.print("Введите высоту экрана (в пикселях): ");
        height = scan.nextInt();
        System.out.print("Введите частоту обновления экрана (в Гц): ");
        refreshRate = scan.nextInt();

        setArguments(width, height, refreshRate);
    }

    private boolean checkArguments(int width, int height, int refreshRate) {
        return (width >= 0) && (height >= 0) && (refreshRate >= 0);
    }
    private void setArguments(int width, int height, int refreshRate) {
        if (checkArguments(width, height, refreshRate)) {
            this.width = width;
            this.height = height;
            this.refreshRate = refreshRate;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }

    @Override public String toString() {
        return (this.getWidth() + "x" + this.getHeight() + ", "  + this.getRefreshRate() + " Гц");
    }
}
