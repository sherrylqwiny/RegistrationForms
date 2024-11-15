/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationform;

/**
 *
 * @author sherrylochieng
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    private JTextField nameField, mobileField, dobField, addressField;
    private JRadioButton maleButton, femaleButton;
    private JCheckBox termsCheckbox;
    private JButton submitButton, resetButton;
    private ButtonGroup genderGroup;
    private JTextArea displayArea;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 5, 5));
        formPanel.setBackground(new Color(245, 245, 245));

        // Add form fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(new Color(0, 128, 128));
        formPanel.add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBackground(new Color(255, 255, 240));
        formPanel.add(nameField);

        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setForeground(new Color(0, 128, 128));
        formPanel.add(mobileLabel);
        
        mobileField = new JTextField();
        mobileField.setBackground(new Color(255, 255, 240));
        formPanel.add(mobileField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(new Color(0, 128, 128));
        formPanel.add(genderLabel);
        
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        maleButton.setBackground(new Color(240, 248, 255));
        femaleButton.setBackground(new Color(240, 248, 255));
        
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(new Color(245, 245, 245));
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        formPanel.add(genderPanel);

        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setForeground(new Color(0, 128, 128));
        formPanel.add(dobLabel);
        
        dobField = new JTextField();
        dobField.setBackground(new Color(255, 255, 240));
        formPanel.add(dobField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(new Color(0, 128, 128));
        formPanel.add(addressLabel);
        
        addressField = new JTextField();
        addressField.setBackground(new Color(255, 255, 240));
        formPanel.add(addressField);

        termsCheckbox = new JCheckBox("Accept Terms and Conditions");
        termsCheckbox.setBackground(new Color(245, 245, 245));
        termsCheckbox.setForeground(new Color(0, 128, 128));
        formPanel.add(termsCheckbox);
        formPanel.add(new JLabel("")); // Empty cell for alignment

        // Buttons Panel
        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(50, 205, 50));
        submitButton.setForeground(Color.BLACK);
        
        resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(255, 69, 0));
        resetButton.setForeground(Color.BLACK);
        
        formPanel.add(submitButton);
        formPanel.add(resetButton);

        // Display Panel for Showing User Data
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Submitted Data"));
        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Serif", Font.PLAIN, 14));
        displayArea.setBackground(new Color(255, 250, 250));
        
        displayPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Add panels to frame
        add(formPanel, BorderLayout.WEST);
        add(displayPanel, BorderLayout.CENTER);

        // Button action listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (termsCheckbox.isSelected()) {
                    saveDataToDatabase();
                    displaySubmittedData();
                } else {
                    JOptionPane.showMessageDialog(null, "Please accept terms and conditions.");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        setVisible(true);
    }

    private void saveDataToDatabase() {
        // Simulate saving data to database, can be implemented as needed
    }

    private void displaySubmittedData() {
        String name = nameField.getText();
        String mobile = mobileField.getText();
        String gender = maleButton.isSelected() ? "Male" : "Female";
        String dob = dobField.getText();
        String address = addressField.getText();

        displayArea.setText("Name: " + name + "\n" +
                            "Mobile: " + mobile + "\n" +
                            "Gender: " + gender + "\n" +
                            "DOB: " + dob + "\n" +
                            "Address: " + address + "\n");
    }

    private void resetForm() {
        nameField.setText("");
        mobileField.setText("");
        dobField.setText("");
        addressField.setText("");
        genderGroup.clearSelection();
        termsCheckbox.setSelected(false);
        displayArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm());
    }
}
