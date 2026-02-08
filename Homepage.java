import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Homepage JFrame Form
 * This class represents the main homepage after successful login
 */
public class Homepage extends javax.swing.JFrame {

    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JButton viewProfileButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JButton logoutButton;

    /**
     * Creates new form Homepage
     */
    public Homepage() {
        initComponents();
        setLocationRelativeTo(null); // Center the window on screen
    }

    /**
     * Initialize the GUI components
     */
    private void initComponents() {
        // Create components
        titleLabel = new javax.swing.JLabel();
        greetingLabel = new javax.swing.JLabel();
        viewProfileButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        // Set frame properties
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setTitle("Homepage");
        setSize(600, 400);
        setResizable(true);
        setLocationRelativeTo(null);

        // Configure title label
        titleLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        titleLabel.setText("Welcome to the Homepage");
        titleLabel.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        // Configure greeting label
        greetingLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
        greetingLabel.setText("Hello, User!");
        greetingLabel.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        // Configure buttons
        viewProfileButton.setText("View Profile");
        viewProfileButton.setPreferredSize(new Dimension(150, 40));
        viewProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProfileButtonActionPerformed(evt);
            }
        });

        settingsButton.setText("Settings");
        settingsButton.setPreferredSize(new Dimension(150, 40));
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.setPreferredSize(new Dimension(150, 40));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        // Layout using GroupLayout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addComponent(greetingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50)
                    .addComponent(viewProfileButton)
                    .addGap(30)
                    .addComponent(settingsButton)
                    .addGap(30)
                    .addComponent(logoutButton)
                    .addGap(50))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30)
                .addComponent(greetingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100)
        );

        pack();
    }

    /**
     * Handle View Profile button click
     */
    private void viewProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "View Profile feature coming soon!", "Profile", JOptionPane.INFORMATION_MESSAGE);
        // TODO: Implement profile page navigation
    }

    /**
     * Handle Settings button click
     */
    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Settings feature coming soon!", "Settings", JOptionPane.INFORMATION_MESSAGE);
        // TODO: Implement settings page navigation
    }

    /**
     * Handle Logout button click
     */
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            this.dispose(); // Close the homepage
            // TODO: Reopen the login form
            // new LoginForm().setVisible(true);
        }
    }

    /**
     * Main method to run the application
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }
}
