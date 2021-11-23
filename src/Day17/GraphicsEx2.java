package Day17;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GraphicsEx2 extends Frame implements MouseMotionListener {

    int x = 0;
    int y = 0;

    public static void main(String[] args) {
        new GraphicsEx2("GraphicsEx2");
    }

    public GraphicsEx2(String title){
        super(title);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setBounds(100,100,500,500);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.drawString("마우스를 움직여보세요.",10,50);
        g.drawString("*,", x, y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }


}
