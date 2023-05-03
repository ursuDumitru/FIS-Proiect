package MainApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame{
    private JPanel panel1;
    private JButton formularButton;
    private JButton button2;

    public Application(String title) {
        super(title); //constructor of JFrame

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

        formularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame formular = new Formular("Formular");
                formular.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame app = new Application("Aplicatie de Curierat");
        app.setVisible(true);
    }
}