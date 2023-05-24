package UserInterfaces;

import javax.swing.*;

public class RutaFrame {
    private JFrame rutaFrame;

    public RutaFrame() {
        rutaFrame = new JFrame("Ruta Frame");
        rutaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        rutaFrame.setSize(300, 200);
        rutaFrame.setLocationRelativeTo(null);
        rutaFrame.setVisible(true);
    }
}