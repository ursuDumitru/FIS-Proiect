package UserInterfaces;

import javax.swing.*;

public class SoferFrame {
    private JFrame soferFrame;

    public SoferFrame() {
        soferFrame = new JFrame("Sofer Frame");
        soferFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        soferFrame.setSize(300, 200);
        soferFrame.setLocationRelativeTo(null);
        soferFrame.setVisible(true);
    }
}