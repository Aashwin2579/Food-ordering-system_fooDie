import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuccessPage extends JFrame implements ActionListener {
    JButton backButton;

    public SuccessPage() {
        setTitle("Order Placed - FOODIEweb");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(200, 255, 200)); // Light green success color

        JLabel successLabel = new JLabel("Your Order Was Successful!", JLabel.CENTER);
        successLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        successLabel.setBounds(50, 60, 400, 50);
        successLabel.setForeground(new Color(0, 128, 0));
        add(successLabel);

        JLabel thankYou = new JLabel("Thank you for choosing FOODIEweb!", JLabel.CENTER);
        thankYou.setFont(new Font("Tahoma", Font.PLAIN, 16));
        thankYou.setBounds(50, 110, 400, 30);
        thankYou.setForeground(new Color(34, 139, 34));
        add(thankYou);

        backButton = new JButton("Back to Home");
        backButton.setBounds(170, 180, 150, 40);
        backButton.setBackground(new Color(100, 200, 100));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(this);
        add(backButton);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new WelcomePage().setVisible(true);
        this.dispose();
    }
}
