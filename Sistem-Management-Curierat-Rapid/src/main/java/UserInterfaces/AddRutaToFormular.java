package UserInterfaces;

import Clase.Formular;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddRutaToFormular {
    private JFrame frame;
    private Formular formular;
    private JComboBox<String> comboBox;

    public AddRutaToFormular(Formular f) {
        this.formular = f;
        frame = new JFrame("Add Ruta to Formular");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Select a route:");
        comboBox = new JComboBox<>();

        try {
            // Establish the database connection
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/curierat",
                            "root", "root");

            // Create the SQL query
            String sql = "SELECT id_ruta FROM rute" +
                    " WHERE oras_plecare = ? AND" +
                    " oras_destinatie = ? AND" +
                    " tip_transport = ?";

            // Prepare the statement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, formular.getOrasExpediere());
            statement.setString(2, formular.getOrasDestinatie());
            statement.setString(3, formular.getTipColet().name());

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set and retrieve the IDs
            while (resultSet.next()) {
                int id = resultSet.getInt("id_ruta");
                comboBox.addItem("Ruta_ID :" + id + ", duration: ");
                System.out.println("ID: " + id);
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        comboBox.addItem("Ruta 1");
        comboBox.addItem("Ruta 2");
        comboBox.addItem("Ruta 3");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);

        // Set the preferred size of the JComboBox
        Dimension comboBoxSize = new Dimension(50, 25);
        comboBox.setPreferredSize(comboBoxSize);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(comboBox);
        panel.add(Box.createVerticalGlue());

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }
}