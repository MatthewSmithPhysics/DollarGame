import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayPanel extends JPanel implements KeyListener, MouseListener, ActionListener
{
    Node[] node = new Node[100];
    Edge[] edge = new Edge[100];
    String mode = "node";
    int N = 0;
    int M = 0;
    Timer timer = new Timer(200, this);
    public PlayPanel()
    {
        setBackground(Color.BLUE);
        addKeyListener(this);
        addMouseListener(this);
    }
    public void init()
    {
        requestFocusInWindow();
        timer.start();
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_N:
                mode = "node";
                break;
            case KeyEvent.VK_E:
                mode = "edge";
                break;
            case KeyEvent.VK_P:
                mode = "play";
                break;
            case KeyEvent.VK_C:
                erase();
                break;
            default:
                System.out.println("Key not mapped.");
        }
    }

    public void play()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }


    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 15));
        g.drawString("Press Keys to Change Modes:", 550, 20);
        g.drawString("N- Place Nodes", 550, 35);
        g.drawString("E- Place Edges", 550, 50);
        g.drawString("P- Play Game", 550, 65);
        g.drawString("C- Clear Board", 550, 80);
        g.drawString("Click To Make Action in Mode", 550, 95);
        g.drawString("Note: Cyan numbers outside node circles are node labels.", 50, 20);
        for(int i = 0; i < M; i++) edge[i].paint(g);
        for(int i = 0; i < N; i++) node[i].paint(g);
    }

    public void addNode(int x, int y)
    {
        int p = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter the initial value at the node."));
        Node nodek = new Node(x, y, p, N);
        node[N] = nodek;
        N = N + 1;
    }

    public void addEdge()
    {
        int k1 = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter index of node A:"));
        int k2 = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter index of node B:"));
        Edge edgek = new Edge(node[k1], node[k2]);
        edge[M] = edgek;
        M = M + 1;
    }

    public void donate()
    {   
        int k = Integer.parseInt(JOptionPane.showInputDialog("Please enter the index of the donating node."));
        Node A = node[k];
        for(int i = 0; i < M; i++)
        {
            if(edge[i].A == A)
            {
                A.p = A.p - 1;
                edge[i].B.p = edge[i].B.p + 1;
            }else if(edge[i].B == A)
            {
                A.p = A.p - 1;
                edge[i].A.p = edge[i].A.p + 1;
            }
        }
    }

    public void erase()
    {
        N = 0;
        M = 0;
    }
    
    @Override
    public void keyReleased(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void mousePressed(MouseEvent e){}
    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseClicked(MouseEvent e)
    {
        switch(mode)
        {
            case "node":
                addNode(e.getX(), e.getY());
                break;
            case "edge":
                addEdge();
                break;
            case "play":
                donate();
                break;
            default:
                System.out.println("Mode not recognised.");
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}
}
