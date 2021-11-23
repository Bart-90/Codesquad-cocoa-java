package Day17;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsEx4 extends Frame implements MouseMotionListener {
    int x = 0;
    int y = 0;

    Image img = null;
    Graphics gImg = null;

    public static void main(String[] args) {
        new GraphicsEx4("GraphicsEx4");
    }

    public GraphicsEx4(String title){
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

        img = createImage(500,500);
        gImg = img.getGraphics();
        gImg.drawString("왼쪽 버튼을 누른 채로 마우스를 움직여보세요.", 10, 50);
        repaint();
    }

    public void paint(Graphics g){
        if(img != null){
            g.drawImage(img,0,0,this);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK){
            x = e.getX();
            y = e.getY();
            gImg.drawString("*", x, y);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
