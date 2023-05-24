package UserInterfaces;

import Clase.Ruta;
import Clase.Ruta.TipColet;
import Clase.Formular;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FormularFrame {
    private JFrame frame;

    private JTextField numeExpediatorField;
    private JTextField prenumeExpediatorField;
    private JTextField cnpExpediatorField;
    private JComboBox<String> orasExpediereComboBox; //HERE CHANGE TYPE TO ORAS

    private JTextField numeDestinatarField;
    private JTextField prenumeDestinatarField;
    private JTextField cnpDestinatarField;
    private JComboBox<String> orasDestinatieComboBox; //HERE CHANGE TYPE TO ORAS

    private JComboBox<TipColet> tipColetComboBox;
    private JTextField greutateColetField;

    public FormularFrame() {
        frame = new JFrame("User Formular");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(10, 2, 10, 10));

        JLabel numeExpediatorLabel = new JLabel("Nume Expediator:", JLabel.LEFT);
        numeExpediatorField = new JTextField(15);

        JLabel prenumeExpediatorLabel = new JLabel("Prenume Expediator:", JLabel.LEFT);
        prenumeExpediatorField = new JTextField(15);

        JLabel cnpExpediatorLabel = new JLabel("CNP Expediator:", JLabel.LEFT);
        cnpExpediatorField = new JTextField(15);

        JLabel orasExpediereLabel = new JLabel("Oras Expediere:", JLabel.LEFT);
        orasExpediereComboBox = new JComboBox<>();
        for(var o : Ruta.orase){
            orasExpediereComboBox.addItem(o);
        }

        JLabel numeDestinatarLabel = new JLabel("Nume Destinatar:", JLabel.LEFT);
        numeDestinatarField = new JTextField(15);

        JLabel prenumeDestinatarLabel = new JLabel("Prenume Destinatar:", JLabel.LEFT);
        prenumeDestinatarField = new JTextField(15);

        JLabel cnpDestinatarLabel = new JLabel("CNP Destinatar:", JLabel.LEFT);
        cnpDestinatarField = new JTextField(15);

        JLabel orasDestinatieLabel = new JLabel("Oras Destinatie:", JLabel.LEFT);
        orasDestinatieComboBox = new JComboBox<>();
        for(var o : Ruta.orase){
            orasDestinatieComboBox.addItem(o);
        }

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

        submitButton.addActionListener(e -> {
            if (!validateFields()) {
                JOptionPane.showMessageDialog(frame,
                        "Please fill in all the fields or write them correctly.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String numeExpediator = numeExpediatorField.getText();
                String prenumeExpediator = prenumeExpediatorField.getText();
                String cnpExpediator = cnpExpediatorField.getText();
                String orasExpediere = orasExpediereComboBox.getSelectedItem().toString();
                String numeDestinatar = numeDestinatarField.getText();
                String prenumeDestinatar = prenumeDestinatarField.getText();
                String cnpDestinatar = cnpDestinatarField.getText();
                String orasDestinatie = orasDestinatieComboBox.getSelectedItem().toString();
                TipColet tipColet = (TipColet) tipColetComboBox.getSelectedItem();
                double greutateColet = Double.parseDouble(greutateColetField.getText());

                String url = "jdbc:mysql://localhost:3306/curierat";

                Connection connection= null;
                try {
                    connection = DriverManager.getConnection(url, "root", "root");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Statement statement = null;
                try {
                    statement = connection.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                String query = "SELECT MAX(id_client) FROM request;";

                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery(query);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                int lastId=1;
                try {
                    if (resultSet.next()) {
                        lastId = resultSet.getInt(1);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                Formular formular = new Formular(lastId + 1, numeExpediator,
                        prenumeExpediator, cnpExpediator, orasExpediere, numeDestinatar,
                        prenumeDestinatar, cnpDestinatar, orasDestinatie, tipColet, greutateColet);

                new AddRutaToFormular(formular);
                System.out.println(formular);


            }
        });

        panel.add(submitPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private boolean validateFields() {
        String nE = numeExpediatorField.getText();
        String pE = prenumeExpediatorField.getText();
        String cnpE = cnpExpediatorField.getText();
        String oE = orasExpediereComboBox.getSelectedItem().toString();
        String nD = numeDestinatarField.getText();
        String pD = prenumeDestinatarField.getText();
        String cnpD = cnpDestinatarField.getText();
        String oD = orasDestinatieComboBox.getSelectedItem().toString();
        String gC = greutateColetField.getText();

        if(oE.equals(oD)){
            return false;
        }

        // Check if any text field is empty
        if (nE.isEmpty() || pE.isEmpty() || cnpE.isEmpty() ||
                oE.isEmpty() || nD.isEmpty() || pD.isEmpty() ||
                cnpD.isEmpty() || oD.isEmpty() || gC.isEmpty() ||
                !containsOnlyLetters(nE) || !containsOnlyLetters(pE) ||
                !containsOnlyLetters(nD) || !containsOnlyLetters(pD) ||
                !isCNP(cnpE) || !isCNP(cnpD) || !isKG(gC)) {
            return false; // Field validation failed
        }
        return true; // Field validation successful
    }
    private boolean containsOnlyLetters(String input) {
        return input.matches("[a-zA-Z]+");
    }

    private boolean isCNP(String input) {
        if (input.length() != 13) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isKG(String input) {
        try {
            if(Double.parseDouble(input) <= 0){
                return false;
            };
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
