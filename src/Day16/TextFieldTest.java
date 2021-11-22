package Day16;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldTest extends Frame {

    Label lid;
    Label lpwd;
    TextField tfId;
    TextField tfPwd;
    Button ok;

    TextFieldTest(String title){
        super(title);

        lid = new Label("ID : ", Label.RIGHT);
        lpwd = new Label("Password : ", Label.RIGHT);

        tfId = new TextField(10);
        tfPwd = new TextField(10);
        tfPwd.setEchoChar('*');

        ok = new Button("OK");
        tfId.addActionListener(new EventHandler());
        tfPwd.addActionListener(new EventHandler());
        ok.addActionListener(new EventHandler());

        setLayout(new FlowLayout());
        add(lid);
        add(tfId);
        add(lpwd);
        add(tfPwd);
        add(ok);
        setSize(450, 65);
        setVisible(true);

    }

    public static void main(String[] args) {
        TextFieldTest f = new TextFieldTest("Login");
    }

    class EventHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = tfId.getText();
            String password = tfPwd.getText();
            if(!id.equals("javachobo")) {
                System.out.println("입력하신 ID가 유효하지 않습니다. 다시 입력해주세요.");
                tfId.requestFocus();
                tfId.selectAll();
            }else if(!password.equals("1234")){
                System.out.println("입력하신 비밀번호가 틀렸습니다. 다시 입력해주세요.");
                tfPwd.requestFocus();
                tfPwd.selectAll();
            }else{
                System.out.println(id + "님, 성공적으로 로그인 되었습니다.");
            }
        }
    }

}


