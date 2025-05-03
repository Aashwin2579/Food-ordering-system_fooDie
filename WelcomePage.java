import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener {
    JButton loginButton, registerButton;

    public WelcomePage() {
        setTitle("FOODIEweb - Grab Your Taste!");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // Custom layout

        // Set background color
        getContentPane().setBackground(new Color(255, 229, 180)); // Light orange

        JLabel titleLabel = new JLabel("FOODIEweb", JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 36));
        titleLabel.setBounds(150, 30, 300, 50);
        titleLabel.setForeground(new Color(255, 100, 50)); // Deep orange
        add(titleLabel);

        JLabel tagline = new JLabel("Grab Your Taste!", JLabel.CENTER);
        tagline.setFont(new Font("Verdana", Font.PLAIN, 18));
        tagline.setBounds(200, 80, 200, 30);
        tagline.setForeground(Color.DARK_GRAY);
        add(tagline);

        loginButton = new JButton("Login");
        loginButton.setBounds(220, 150, 150, 40);
        styleButton(loginButton);
        loginButton.addActionListener(this);
        add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(220, 210, 150, 40);
        styleButton(registerButton);
        registerButton.addActionListener(this);
        add(registerButton);

        JLabel footer = new JLabel("Nothing Brings People Together Like Good Food!", JLabel.CENTER);
        footer.setFont(new Font("Verdana", Font.ITALIC, 12));
        footer.setBounds(100, 320, 400, 30);
        footer.setForeground(Color.DARK_GRAY);
        add(footer);

        setLocationRelativeTo(null); // Center the window
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(255, 140, 80)); // Button color
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            new LoginScreen().setVisible(true); // Open login
        } else if (e.getSource() == registerButton) {
            JOptionPane.showMessageDialog(this, "Registration feature coming soon!");
        }
        this.dispose(); // Close welcome page
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomePage().setVisible(true);
        });
    }
}
