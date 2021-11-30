package Day22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelChange extends JFrame implements ActionListener {

    JPanel p1, p2;
    JButton b1, b2, b3, b4;
    JTextArea ta;
    CardLayout cardLayout = new CardLayout();

    public static void main(String[] args) {
        new PanelChange("패널전환");
    }

    public PanelChange(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임이 닫힐때 메모리상에서도 종료
        p1=new JPanel(); //패널1
        p2=new JPanel(); //패널2
        ta=new JTextArea(10,20);
        b1=new JButton("패널2 보이기");
        b2=new JButton("패널2 안보이기");
        b3=new JButton("패널1 보이기");
        b4=new JButton("패널1 안보이기");
        p1.setSize(300,400);
        p1.setSize(300,400);
        setLayout(cardLayout);
        p1.add(b1); p1.add(b2);
        p2.add(b3); p2.add(b4);
        add(p1); //패널을 프레임에 붙힌다.
        add(p2);
        add(ta);
        p1.setBackground(Color.yellow);
        p2.setBackground(Color.green);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        setSize(300,400);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        ta.append(str+"\n");
        if(str.equals("패널2 보이기")) {
            cardLayout.show(getContentPane(),"p2");
            p2.setVisible(true);
        }else if(str.equals("패널2 안보이기")) {
            p2.setVisible(false);
        }else if(str.equals("패널1 보이기")) {
            p1.setVisible(true);
        }else {
            p1.setVisible(false);
        }



    }
}
