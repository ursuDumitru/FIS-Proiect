package MainApp;

import javax.swing.*;

public class Formular extends JFrame {

    private JPanel panel2;

    public Formular(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel2);
        this.pack();
    }
}
