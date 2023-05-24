package UserInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdminFrame {
    private JFrame frame;

    public AdminFrame() {
        frame = new JFrame("Admin Frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Add some vertical spacing

        JButton formularButton = new JButton("Formular");
        JButton rutaButton = new JButton("Ruta");

        // Set preferred size for both buttons
        Dimension buttonSize = new Dimension(150, 40);
        formularButton.setPreferredSize(buttonSize);
        rutaButton.setPreferredSize(buttonSize);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(formularButton, gbc);

        gbc.gridy = 1;
        panel.add(rutaButton, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        formularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormularFrame();
            }
        });

        rutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RutaFrame();
            }
        });
    }
}