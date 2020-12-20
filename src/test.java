import javax.swing.*;

public class test {
    private JPanel pan;
    private JCheckBox a1CheckBox;
    private JCheckBox a2CheckBox;
    private JCheckBox a3CheckBox;
    private JCheckBox a4CheckBox;
    private JCheckBox a5CheckBox;
    private JButton button1;

    public static void main(String argv[]){

        JFrame f = new JFrame("aaaa");

        f.setContentPane(new  test().pan);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200,200);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
}
