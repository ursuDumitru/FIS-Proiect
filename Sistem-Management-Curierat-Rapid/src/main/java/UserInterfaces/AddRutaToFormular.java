package UserInterfaces;

import Clase.Formular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddRutaToFormular {
    private JFrame frame;
    private Formular formular;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox1;
    Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/curierat",
                    "root", "root");

    public AddRutaToFormular(Formular f) throws SQLException {
        this.formular = f;
        frame = new JFrame("Add Ruta to Formular");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Select a route:");
        comboBox = new JComboBox<>();
        JLabel label1 = new JLabel("Select the traseu");
        comboBox1 = new JComboBox<>();

        try {
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
                comboBox.addItem("Ruta_ID :'" + id + "', tip_transport :" + formular.getTipColet());
                System.out.println("ID: " + id);

            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);

        // Set the preferred size of the JComboBox
        Dimension comboBoxSize = new Dimension(50, 25);
        comboBox.setPreferredSize(comboBoxSize);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(comboBox);
//        panel.add(Box.createVerticalGlue());
        panel.add(label1);
        comboBox1.setPreferredSize(comboBoxSize);
        panel.add(comboBox1);

        frame.getContentPane().add(panel);

        frame.setVisible(true);

        // Add an ActionListener to the combobox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                String selectedOption = (String) source.getSelectedItem();
//                System.out.println("Selected option: " + selectedOption);
                Pattern pattern = Pattern.compile("'(.*?)'");
                Matcher matcher = pattern.matcher(selectedOption);
                if (matcher.find())
                {
                    System.out.println(matcher.group(1));
                    formular.setIdRuta(Integer.parseInt(matcher.group(1)));

                    String sql = "SELECT id_traseu, distanta, ora_plecare, ora_sosire FROM trasee" +
                            " WHERE id_ruta = ?";

                    PreparedStatement statement1 = null;
                    try {
                        statement1 = connection.prepareStatement(sql);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        statement1.setInt(1, formular.getIdRuta());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    ResultSet resultSet1 = null;
                    try {
                        resultSet1 = statement1.executeQuery();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    while(true) {
                        try {
                            if (!resultSet1.next()) break;

                            int id_traseu = resultSet1.getInt("id_traseu");
                            String ora_plecare = resultSet1.getString("ora_plecare");
                            String ora_sosire = resultSet1.getString("ora_sosire");
                            comboBox1.addItem("ID_Traseu :" + id_traseu +
                                    ", ora plecare :" + ora_plecare +
                                    ", ora sosire :" + ora_sosire);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }
                // HOW TO GET ID_RUTA HERE ?
            }
        });
    }
}