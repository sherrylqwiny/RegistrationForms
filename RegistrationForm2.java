/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationform2;

/**
 *
 * @author sherrylochieng
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm2 extends JFrame {
    private JTextField idField, nameField, addressField, contactField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JButton exitButton, registerButton;
    private JTable table;
    private DefaultTableModel tableModel;

    public RegistrationForm2() {
        // Frame settings (increased size to avoid truncation)
        setTitle("Registration Form");
        setSize(700, 400); // Increased size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Labels and input fields (adjusted sizes for readability)
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(20, 20, 80, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(100, 20, 200, 25); // Expanded width
        add(idField);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(20, 60, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 60, 200, 25); // Expanded width
        add(nameField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(20, 100, 80, 25);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(100, 100, 60, 25);
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(160, 100, 80, 25);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        add(maleRadioButton);
        add(femaleRadioButton);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(20, 140, 80, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(100, 140, 200, 25); // Expanded width
        add(addressField);

        JLabel contactLabel = new JLabel("Contact");
        contactLabel.setBounds(20, 180, 80, 25);
        add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(100, 180, 200, 25); // Expanded width
        add(contactField);

        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(20, 220, 120, 30); // Slightly bigger button
        add(registerButton);

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.setBounds(160, 220, 120, 30); // Slightly bigger button
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);

        // Table to display entries (expanded to fit the form)
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Name", "Gender", "Address", "Contact"});
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(320, 20, 350, 230); // Adjusted the table size
        add(tableScrollPane);

        // Register button action listener
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String address = addressField.getText();
                String contact = contactField.getText();

                // Add data to the table
                tableModel.addRow(new Object[]{id, name, gender, address, contact});

                // Clear input fields
                idField.setText("");
                nameField.setText("");
                genderGroup.clearSelection();
                addressField.setText("");
                contactField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationForm2 form = new RegistrationForm2();
            form.setVisible(true);
        });
    }
}


