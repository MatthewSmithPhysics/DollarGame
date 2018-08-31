import javax.swing.*;

public class MainWindow extends JFrame
{
    public MainWindow()
    {
        setTitle("Dollar Game");
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void init()
    {
        setContentPane(Main.playPanel);
        setVisible(true);
    }
}