package Day16;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseEventTest extends Frame {
    Label location;

    MouseEventTest(String title){
        super(title);
        location = new Label("Mouse Pointer Location : ");
        location.setSize(195, 15);
        location.setLocation(5,30);
        location.setBackground(Color.YELLOW);
        add(location);
        addMouseMotionListener(new EventHandler());

        setSize(300, 200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        MouseEventTest mainWin = new MouseEventTest("MouseEventTest");
    }

    class EventHandler implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {

        }
        @Override
        public void mouseMoved(MouseEvent e) {
            location.setText("마우스 커서 좌표 : (" + e.getX() + ", " + e.getY() + ")");
        }
    }

}
