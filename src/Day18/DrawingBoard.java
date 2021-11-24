package Day18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingBoard extends Frame{

    Panel guiPanel, paintPanel;
    Label thinknessInfoLabel;
    TextField thinknessControlTf;
    Button pencilBt, eraserBt, colorSelectBt;
    Color selectColor;

    Graphics graphics;
    Graphics2D g;

    int thickness = 10;
    int startX = 0;
    int startY = 0;
    int endX = 0;
    int endY = 0;

    boolean tf = false;


    public DrawingBoard(){
        setLayout(null);
        setTitle("그림판");
        setSize(900,700);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        guiPanel = new Panel();
        guiPanel.setBackground(Color.GRAY);
        guiPanel.setLayout(null);

        pencilBt = new Button("연필");
        pencilBt.setFont(new Font("맑은고딕", Font.BOLD,25));
        pencilBt.setBackground(Color.LIGHT_GRAY);
        eraserBt = new Button("지우개");
        eraserBt.setFont(new Font("함초롬돋움", Font.BOLD,25));
        pencilBt.setBackground(Color.WHITE);
        colorSelectBt = new Button("선 색상");
        colorSelectBt.setBackground(Color.PINK);

        thinknessInfoLabel = new Label("도구 굵기");
        thinknessInfoLabel.setFont(new Font("맑은고딕", Font.BOLD, 20));

        thinknessControlTf = new TextField("10", 5);
        thinknessControlTf.setFont(new Font("맑은고딕", Font.BOLD, 25));

        pencilBt.setBounds(10,10,90,55);
        eraserBt.setBounds(105,10,109,55);
        colorSelectBt.setBounds(785,10,90,55);
        thinknessInfoLabel.setBounds(640,10,100,55);
        thinknessControlTf.setBounds(720, 22,50,35);

        guiPanel.add(pencilBt);
        guiPanel.add(eraserBt);
        guiPanel.add(colorSelectBt);
        guiPanel.add(thinknessInfoLabel);
        guiPanel.add(thinknessControlTf);

        guiPanel.setBounds(0,0,900,75);

        paintPanel = new Panel();
        paintPanel.setBackground(Color.WHITE);
        paintPanel.setLayout(null);

        paintPanel.setBounds(0,90,885,620);

        add(guiPanel);
        add(paintPanel);

        setVisible(true);

        graphics = getGraphics();
        g = (Graphics2D)graphics;
        g.setColor(selectColor);

        paintPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }
        });


        paintPanel.addMouseMotionListener(new PaintDraw());
        pencilBt.addActionListener(new ToolActionListener());
        eraserBt.addActionListener(new ToolActionListener());
        colorSelectBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf = true;
                JColorChooser chooser = new JColorChooser();
                selectColor = chooser.showDialog(null,"Color", Color.ORANGE);
                g.setColor(selectColor);

            }
        });


    }

    public class PaintDraw implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            thickness = Integer.parseInt(thinknessControlTf.getText());

            endX = e.getX();
            endY = e.getY();

            g.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND,0));
            g.drawLine(startX+10, startY+121, endX+10, endY+121);

            startX = endX;
            startY = endY;

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public class ToolActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == pencilBt){
                if(tf == false) g.setColor(Color.BLACK);
                else g.setColor(selectColor);
            }else if(e.getSource() == eraserBt){
                g.setColor(Color.WHITE);
            }
        }
    }

    public static void main(String[] args) {
        new DrawingBoard();
    }

}
