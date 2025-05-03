import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, backButton;

    public LoginScreen() {
        setTitle("Login - FOODIEweb");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Background color
        getContentPane().setBackground(new Color(255, 229, 180)); // Light orange

        JLabel loginLabel = new JLabel("Login", JLabel.CENTER);
        loginLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        loginLabel.setBounds(150, 30, 200, 40);
        loginLabel.setForeground(new Color(255, 100, 50));
        add(loginLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        usernameLabel.setBounds(100, 100, 100, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(200, 100, 180, 30);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passwordLabel.setBounds(100, 150, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 180, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 200, 80, 35);
        styleButton(loginButton);
        loginButton.addActionListener(this);
        add(loginButton);

        backButton = new JButton("Back");
        backButton.setBounds(300, 200, 80, 35);
        styleButton(backButton);
        backButton.addActionListener(this);
        add(backButton);

        setLocationRelativeTo(null); // Center the window
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(255, 140, 80));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new FoodOrderingSystem().setVisible(true); // Proceed to next screen
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == backButton) {
            new WelcomePage().setVisible(true); // Back to welcome
            this.dispose();
        }
    }
}
