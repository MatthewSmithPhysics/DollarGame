import java.awt.*;

public class Node
{
    Font custom = new Font("Serif", Font.BOLD, 30);
    public int x = 0;
    public int y = 0;
    int r = 20;
    int i = 0;
    public int p = 0;
    public Node(int x, int y, int p, int i)
    {
        this.x = x;
        this.y = y;
        this.p = p;
        this.i = i;
    }
    public void paint(Graphics g)
    {
        g.setFont(custom);
        g.setColor(Color.WHITE);
        g.drawOval(x - r, y - r, 2*r, 2*r);
        g.setColor(Color.GREEN);
        g.drawString("" + p, (int)(x-0.8*r), (int)(y+0.6*r));
        g.setColor(Color.CYAN);
        g.drawString("" + i, x + r, y - r);
    }
}
