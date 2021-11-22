package Day16;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
class EventHandler implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        e.getWindow().setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}

public class AWTnote {
    public static void main(String[] args) {

        Frame f = new Frame("Login");
        f.setSize(300, 200);

        f.addWindowListener(new EventHandler());


//        MenuBar mb = new MenuBar();
//        Menu mFile = new Menu("File");
//
//        MenuItem miNew = new MenuItem("New");
//        MenuItem miOpen = new MenuItem("Open");
//        Menu mOthers = new Menu("Others");
//        MenuItem miExit = new MenuItem("Exit");
//
//        mFile.add(miNew);
//        mFile.add(miOpen);
//        mFile.add(mOthers);
//        mFile.addSeparator();
//        mFile.add(miExit);
//
//        MenuItem miPrint = new MenuItem("Print...");
//        MenuItem miPreview = new MenuItem("Print Preview");
//        MenuItem miSetup = new MenuItem("Print Setup..");
//        mOthers.add(miPrint);
//        mOthers.add(miPreview);
//        mOthers.add(miSetup);
//
//        Menu mEdit = new Menu("Edit");
//        Menu mView = new Menu("View");
//        Menu mHelp = new Menu("Help");
//        CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar");
//        mView.add(miStatusbar);
//
//        mb.add(mFile);
//        mb.add(mEdit);
//        mb.add(mView);
//        mb.setHelpMenu(mHelp);
//
//        f.setMenuBar(mb);


//        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

//        Label abc1 = new Label(abc);
//        Label abc2 = new Label(abc);
//        Label abc3 = new Label(abc);
//        Label abc4 = new Label(abc);
//        Label abc5 = new Label(abc);
//
//        Font f1 = new Font("Serif", Font.PLAIN, 20);
//        Font f2 = new Font("Serif", Font.ITALIC, 20);
//        Font f3 = new Font("Serif", Font.BOLD, 20);
//        Font f4 = new Font("Serif", Font.BOLD+Font.ITALIC, 20);
//
//        abc1.setFont(f1);
//        abc2.setFont(f2);
//        abc3.setFont(f3);
//        abc4.setFont(f4);
//
//        f.setLayout(new FlowLayout());
//        f.add(abc1);
//        f.add(abc2);
//        f.add(abc3);
//        f.add(abc4);
//        f.add(abc5);
//
//        f.setSize(400, 200);

//        Dialog info = new Dialog(f, "Information", true);
//        info.setSize(140, 90);
//        info.setLocation(50, 50); // parent Frame , . 이 아닌 화면이 위치의 기준이 된다
//        info.setLayout(new FlowLayout());
//        Label msg = new Label("This is modal Dialog", Label.CENTER);
//        Button ok = new Button("OK");
//        info.add(msg);
//        info.add(ok);


//        ScrollPane sp = new ScrollPane();
//        Panel p = new Panel();
//        p.setBackground(Color.GREEN);
//        p.add(new Button("첫번째"));
//        p.add(new Button("두번째"));
//        p.add(new Button("세번째"));
//        p.add(new Button("네번째"));
//
//        sp.add(p);
//        f.add(sp);

//        Panel p = new Panel();
//        p.setBackground(Color.MAGENTA);
//        p.setSize(100,100);
//        p.setLocation(50,50);
//
//        Button ok = new Button("OK");
//
//        p.add(ok);
//        f.add(p);

//        Canvas c = new Canvas();
//        c.setBackground(Color.PINK);
//        c.setBounds(50,50,150,100);
//        f.add(c);

//        TextArea comments = new TextArea("하고 싶은 말을 적으세요.", 10, 50);
//
//        f.add(comments);
//        comments.selectAll();

//        Label lid = new Label("ID : ", Label.RIGHT);
//        Label lpwd = new Label("Password : ", Label.RIGHT);
//
//        TextField id = new TextField(10);
//        TextField pwd = new TextField(10);
//        pwd.setEchoChar('*');
//
//        f.add(lid); f.add(id); f.add(lpwd); f.add(pwd);



//        Label q1 = new Label("당신의 관심 분야는? (여러개 선택 가능)");
//        Checkbox news = new Checkbox("news", true);
//        Checkbox sports = new Checkbox("sports");
//        Checkbox movies = new Checkbox("movies");
//        Checkbox music = new Checkbox("music");
//
//        f.add(q1); f.add(news); f.add(sports); f.add(movies); f.add(music);
//
//        Label q2 = new Label("2. 얼마나 자주 극장에 가십니까?");
//        CheckboxGroup group1 = new CheckboxGroup();
//        Checkbox movie1 = new Checkbox("한 달에 한 번 갑니다.", group1, true);
//        Checkbox movie2 = new Checkbox("일주일에 한 번 갑니다.", group1, false);
//        Checkbox movie3 = new Checkbox("일주일에 두 번 갑니다.", group1, false);
//
//        f.add(q2); f.add(movie1); f.add(movie2); f.add(movie3);
//
//        Label q3 = new Label("3. 하루에 얼마나 컴퓨터를 사용하십니까?");
//        CheckboxGroup group2 = new CheckboxGroup();
//        Checkbox com1 = new Checkbox("5시간 이하 ", group2, true);
//        Checkbox com2 = new Checkbox("10시간 이하 ", group2, false);
//        Checkbox com3 = new Checkbox("15시간 이상 ", group2, false);
//
//        f.add(q3); f.add(com1); f.add(com2); f.add(com3);


//        Label id = new Label("ID : ");
//        id.setBounds(50,50,30,10);
//
//        Label pwd = new Label("Password : ");
//        pwd.setBounds(50,65,100,10);
//
//        f.add(id);
//        f.add(pwd);

//        List selectOne = new List(6);
//        selectOne.setLocation(20,40);
//        selectOne.setSize(100,120);
//        selectOne.setSize(100, 120);
//        selectOne.add("Student");
//        selectOne.add("Teacher");
//        selectOne.add("Driver");
//        selectOne.add("Computer Programmer");
//        selectOne.add("Sales Man");
//        selectOne.add("Musician");
//        selectOne.add("Director");
//
//        List selectMany = new List(6,true);
//        selectMany.setLocation(150,40);
//        selectMany.setSize(100,120);
//        selectOne.setSize(100, 120);
//        selectMany.add("Student");
//        selectMany.add("Teacher");
//        selectMany.add("Driver");
//        selectMany.add("Computer Programmer");
//        selectMany.add("Sales Man");
//        selectMany.add("Musician");
//        selectMany.add("Director");
//
//        f.add(selectOne);
//        f.add(selectMany);

//        Choice day = new Choice();
//        day.add("SUN");
//        day.add("MON");
//        day.add("TUE");
//        day.add("WED");
//        day.add("THU");
//        day.add("FRI");
//        day.add("SAT");
//
//        day.setSize(100,50);
//        day.setLocation(100,70);
//        f.add(day);

//        Button b = new Button("확인");
//        b.setSize(100,50);
//        b.setLocation(100,75);
//        f.add(b);


        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        f.setLocation(screenSize.width/2 - 150, screenSize.height/2 - 100);
        f.setVisible(true);

    }

}
