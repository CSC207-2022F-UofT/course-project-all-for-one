import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jf =new JFrame();
        jf.setBounds(400, 300, 400, 300);

        JLabel jb = new JLabel("a");
        jf.add(jb);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
