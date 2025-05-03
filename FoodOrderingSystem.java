import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FoodOrderingSystem extends JFrame implements ActionListener {
    JPanel itemsPanel;
    JLabel cartLabel;
    JButton checkoutButton;
    int cartCount = 0;
    ArrayList<String> cart = new ArrayList<>();

    public FoodOrderingSystem() {
        setTitle("Menu - FOODIEweb");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 229, 180)); // Light orange

        JLabel menuLabel = new JLabel("Select Your Favorite Food!", JLabel.CENTER);
        menuLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        menuLabel.setBounds(100, 20, 400, 40);
        menuLabel.setForeground(new Color(255, 100, 50));
        add(menuLabel);

        itemsPanel = new JPanel();
        itemsPanel.setBounds(50, 80, 480, 280);
        itemsPanel.setLayout(new GridLayout(0, 1, 10, 10));
        itemsPanel.setOpaque(false);
        add(itemsPanel);

        // Add food items
        addMenuItem("Margherita Pizza", 8.99);
        addMenuItem("Cheeseburger", 6.49);
        addMenuItem("French Fries", 3.99);
        addMenuItem("Chocolate Shake", 4.49);

        cartLabel = new JLabel("Cart: 0 items");
        cartLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cartLabel.setBounds(50, 380, 200, 30);
        add(cartLabel);

        checkoutButton = new JButton("Checkout");
        checkoutButton.setBounds(400, 380, 120, 35);
        styleButton(checkoutButton);
        checkoutButton.addActionListener(this);
        add(checkoutButton);

        setLocationRelativeTo(null); // Center window
    }

    private void addMenuItem(String name, double price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        itemPanel.setBackground(new Color(255, 245, 220)); // Soft card color

        JLabel nameLabel = new JLabel(name + " - $" + price);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameLabel.setPreferredSize(new Dimension(300, 30));

        JButton addButton = new JButton("Add to Cart");
        addButton.setBackground(new Color(255, 140, 80));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setPreferredSize(new Dimension(120, 30));

        // Action listener for each item
        addButton.addActionListener(e -> {
            cart.add(name);
            cartCount++;
            cartLabel.setText("Cart: " + cartCount + " items");
        });

        itemPanel.add(nameLabel);
        itemPanel.add(addButton);
        itemsPanel.add(itemPanel);
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
        if (e.getSource() == checkoutButton) {
            this.dispose();
            new SuccessPage().setVisible(true);
             // Go back to welcome
        }
    }
}
