import java.util.Scanner;

public class Display {
    private int width;
    private int height;
    private int refreshRate;

    public Display() {

    }
    public Display(int width, int height) {
        SetArguments(width, height, this.refreshRate);
    }
    public Display(int width, int height, int refreshRate) {
        SetArguments(width, height, refreshRate);
    }

    public int GetWidth() { return width; }
    public int GetHeight() { return height; }
    public int GetRefreshRate() { return refreshRate; }

    public void Input() {
        int width, height, refreshRate;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите ширину экрана (в пикселях): ");
        width = scan.nextInt();
        System.out.print("Введите высоту экрана (в пикселях): ");
        height = scan.nextInt();
        System.out.print("Введите частоту обновления экрана (в Гц): ");
        refreshRate = scan.nextInt();

        SetArguments(width, height, refreshRate);
    }

    private boolean CheckArguments(int width, int height, int refreshRate) {
        return (width >= 0) && (height >= 0) && (refreshRate >= 0);
    }
    private void SetArguments(int width, int height, int refreshRate) {
        if (CheckArguments(width, height, refreshRate)) {
            this.width = width;
            this.height = height;
            this.refreshRate = refreshRate;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }

    @Override public String toString()
    {
        return (this.GetWidth() + "x" + this.GetHeight() + ", "  + this.GetRefreshRate() + " Гц");
    }
}
