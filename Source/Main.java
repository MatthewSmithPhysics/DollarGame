public class Main
{
    public static MainWindow mainWindow;
    public static PlayPanel playPanel;

    public static void main(String[] args)
    {
        System.out.println("Hello Dollar");
        mainWindow = new MainWindow();
        playPanel = new PlayPanel();
        mainWindow.init();
        playPanel.init();
    }
}
