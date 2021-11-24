package Day17;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class BingoGame extends Frame implements MouseMotionListener {

    Button a = new Button("참새");
    Button b = new Button("두루미");
    Button c = new Button("황새");
    Button d = new Button("비둘기");

    String[] birds = {"참새", "두루미", "황새", "비둘기", "까오기", "오리", "타조", "부엉이", "올빼미", "뱁새", "꿩", "닭", "구관조", "잉꼬", "매", "거위", "독수리", "콘돌", "봉황", "공작", "까치", "까마귀", "앵무새", "꾀꼬리", "고니"};

    public static void main(String[] args) {
        new BingoGame("Bingo Game");

    }

    BingoGame(String title){
        super(title);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setBounds(100,100,100,100);
        setLayout(new GridLayout(5,5));
        setVisible(true);

        for(int i = 0; i < birds.length; i++){
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
