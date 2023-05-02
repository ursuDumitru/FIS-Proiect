package MainApp;

import javax.swing.*;

public class MainGrid extends JFrame { // this extend is necesary
    private JPanel panel1;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        MainGrid h = new MainGrid();
        h.setContentPane(h.panel1);
        h.setTitle("Hello");
        h.setSize(300, 300);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
