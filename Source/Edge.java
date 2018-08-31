import java.awt.*;

public class Edge
{
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    public Node A;
    public Node B;

    public Edge(Node A, Node B)
    {
        x1 = A.x;
        y1 = A.y;
        x2 = B.x;
        y2 = B.y;
        this.A = A;
        this.B = B;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);
    }
}