package Day21;

import javax.swing.*;

public class AccountBookGUI extends JFrame {

    JPanel currentPanel, loginPanel, infoPanel, inputPanel, searchPanel;
    JButton loginBtn, infoBtn, inputBtn, searchBtn;
    JTextField idField, dateField, memoField, incomeField, outcomeField, debitOrCashField;
    JPasswordField pwField;


    public static void main(String[] args) {
        new AccountBookGUI();
    }


    public AccountBookGUI(){
        setLayout(null);
        setTitle("가계부");
        setSize(900,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //JOptionPane.showMessageDialog(null,"메시지입니다.");
        setVisible(true);

    }
}
