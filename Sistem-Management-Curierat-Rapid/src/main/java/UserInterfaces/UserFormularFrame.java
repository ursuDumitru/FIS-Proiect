package UserInterfaces;

import MainApp.FormularClient.TipColet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFormularFrame {
    private JFrame frame;

    private JTextField numeExpediatorField;
    private JTextField prenumeExpediatorField;
    private JTextField cnpExpediatorField;
    private JTextField orasExpediereField;

    private JTextField numeDestinatarField;
    private JTextField prenumeDestinatarField;
    private JTextField cnpDestinatarField;
    private JTextField orasDestinatieField;

    private JComboBox<TipColet> tipColetComboBox;
    private JTextField greutateColetField;

    public UserFormularFrame() {
        frame = new JFrame("User Formular");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(10, 2, 10, 10));

        JLabel numeExpediatorLabel = new JLabel("Nume Expediator:", JLabel.LEFT);
        numeExpediatorField = new JTextField(15);

        JLabel prenumeExpediatorLabel = new JLabel("Prenume Expediator:", JLabel.LEFT);
        prenumeExpediatorField = new JTextField(15);

        JLabel cnpExpediatorLabel = new JLabel("CNP Expediator:", JLabel.LEFT);
        cnpExpediatorField = new JTextField(15);

        JLabel orasExpediereLabel = new JLabel("Oras Expediere:", JLabel.LEFT);
        JComboBox<String> orasExpediereComboBox = new JComboBox<>();
        orasExpediereComboBox.addItem("Oras 1");
        orasExpediereComboBox.addItem("Oras 2");

        JLabel numeDestinatarLabel = new JLabel("Nume Destinatar:", JLabel.LEFT);
        numeDestinatarField = new JTextField(15);

        JLabel prenumeDestinatarLabel = new JLabel("Prenume Destinatar:", JLabel.LEFT);
        prenumeDestinatarField = new JTextField(15);

        JLabel cnpDestinatarLabel = new JLabel("CNP Destinatar:", JLabel.LEFT);
        cnpDestinatarField = new JTextField(15);

        JLabel orasDestinatieLabel = new JLabel("Oras Destinatie:", JLabel.LEFT);
        JComboBox<String> orasDestinatieComboBox = new JComboBox<>();
        orasDestinatieComboBox.addItem("Oras 3");
        orasDestinatieComboBox.addItem("Oras 4");

        JLabel tipColetLabel = new JLabel("Tip Colet:", JLabel.LEFT);
        tipColetComboBox = new JComboBox<>(TipColet.values());

        JLabel greutateColetLabel = new JLabel("Greutate Colet:", JLabel.LEFT);
        greutateColetField = new JTextField(15);

        JLabel[] labels = {
                numeExpediatorLabel,
                prenumeExpediatorLabel,
                cnpExpediatorLabel,
                orasExpediereLabel,
                numeDestinatarLabel,
                prenumeDestinatarLabel,
                cnpDestinatarLabel,
                orasDestinatieLabel,
                tipColetLabel,
                greutateColetLabel
        };

        for (JLabel label : labels) {
            setLabelBorder(label);
        }

        formPanel.add(numeExpediatorLabel);
        formPanel.add(numeExpediatorField);
        formPanel.add(prenumeExpediatorLabel);
        formPanel.add(prenumeExpediatorField);
        formPanel.add(cnpExpediatorLabel);
        formPanel.add(cnpExpediatorField);
        formPanel.add(orasExpediereLabel);
        formPanel.add(orasExpediereComboBox);
        formPanel.add(numeDestinatarLabel);
        formPanel.add(numeDestinatarField);
        formPanel.add(prenumeDestinatarLabel);
        formPanel.add(prenumeDestinatarField);
        formPanel.add(cnpDestinatarLabel);
        formPanel.add(cnpDestinatarField);
        formPanel.add(orasDestinatieLabel);
        formPanel.add(orasDestinatieComboBox);
        formPanel.add(tipColetLabel);
        formPanel.add(tipColetComboBox);
        formPanel.add(greutateColetLabel);
        formPanel.add(greutateColetField);

        panel.add(formPanel, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(80, 25));

        JPanel submitPanel = new JPanel();
        submitPanel.add(submitButton);
        submitPanel.setPreferredSize(new Dimension(100, 30));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    JOptionPane.showMessageDialog(frame,
                            "Please fill in all the fields.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Retrieve the input values
                    String numeExpediator = numeExpediatorField.getText();
                    String prenumeExpediator = prenumeExpediatorField.getText();
                    String cnpExpediator = cnpExpediatorField.getText();
                    String orasExpediere = orasExpediereField.getText();
                    String numeDestinatar = numeDestinatarField.getText();
                    String prenumeDestinatar = prenumeDestinatarField.getText();
                    String cnpDestinatar = cnpDestinatarField.getText();
                    String orasDestinatie = orasDestinatieField.getText();
                    TipColet tipColet = (TipColet) tipColetComboBox.getSelectedItem();
                    double greutateColet = Double.parseDouble(greutateColetField.getText());

                    // Perform further actions with the retrieved values
                    // ...

                    // Print the values as an example
                    System.out.println("Nume Expediator: " + numeExpediator);
                    System.out.println("Prenume Expediator: " + prenumeExpediator);
                    System.out.println("CNP Expediator: " + cnpExpediator);
                    System.out.println("Oras Expediere: " + orasExpediere);
                    System.out.println("Nume Destinatar: " + numeDestinatar);
                    System.out.println("Prenume Destinatar: " + prenumeDestinatar);
                    System.out.println("CNP Destinatar: " + cnpDestinatar);
                    System.out.println("Oras Destinatie: " + orasDestinatie);
                    System.out.println("Tip Colet: " + tipColet);
                    System.out.println("Greutate Colet: " + greutateColet);
                }

            }
        });

//        panel.add(submitButton, BorderLayout.SOUTH);
        panel.add(submitPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserFormularFrame();
            }
        });
    }

    private boolean validateFields() {
        // Check if any text field is empty
        if (numeExpediatorField.getText().isEmpty() ||
                prenumeExpediatorField.getText().isEmpty() ||
                cnpExpediatorField.getText().isEmpty() ||
                orasExpediereField.getText().isEmpty() ||
                numeDestinatarField.getText().isEmpty() ||
                prenumeDestinatarField.getText().isEmpty() ||
                cnpDestinatarField.getText().isEmpty() ||
                orasDestinatieField.getText().isEmpty() ||
                greutateColetField.getText().isEmpty()) {
            return false; // Field validation failed
        }
        return true; // Field validation successful
    }

    private void setLabelBorder(JLabel label) {
        // Create an EmptyBorder with left margin
        EmptyBorder labelMargin = new EmptyBorder(0, 50, 0, 0);
        label.setBorder(labelMargin);
    }

    private void addField(JPanel panel, JLabel label, JComponent field) {
        JPanel fieldPanel = new JPanel(new BorderLayout());
        fieldPanel.add(label, BorderLayout.WEST);
        fieldPanel.add(field, BorderLayout.CENTER);
        panel.add(fieldPanel);
    }
}
