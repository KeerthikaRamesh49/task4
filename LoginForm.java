import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * LoginForm JFrame - Login interface for the application
 * This form authenticates users against the MySQL database
 */
public class LoginForm extends javax.swing.JFrame {

    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel errorLabel;

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null); // Center the window on screen
    }

    /**
     * Initialize the GUI components
     */
    private void initComponents() {
        // Create components
        titleLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        // Set frame properties
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setTitle("Login - MyApp");
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        // Configure title label
        titleLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        titleLabel.setText("Login");
        titleLabel.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        // Configure labels
        usernameLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        passwordLabel.setText("Password:");

        // Configure text fields
        usernameField.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        usernameField.setPreferredSize(new Dimension(200, 30));

        passwordField.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        passwordField.setPreferredSize(new Dimension(200, 30));

        // Configure buttons
        loginButton.setText("Login");
        loginButton.setPreferredSize(new Dimension(100, 40));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setText("Register");
        registerButton.setPreferredSize(new Dimension(100, 40));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        // Configure error label
        errorLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 11));
        errorLabel.setText("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        // Layout using GroupLayout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50))
                .addGroup(layout.createSequentialGroup()
                    .addGap(50)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50))
                .addGroup(layout.createSequentialGroup()
                    .addGap(100)
                    .addComponent(loginButton)
                    .addGap(40)
                    .addComponent(registerButton)
                    .addGap(100))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50)
        );

        pack();
    }

    /**
     * Handle Login button click - Validate credentials against database
     */
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Validate input
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Username and password cannot be empty!");
            return;
        }

        // Authenticate against database
        if (authenticateUser(username, password)) {
            // Clear fields
            usernameField.setText("");
            passwordField.setText("");
            errorLabel.setText("");

            // Open Homepage
            new Homepage().setVisible(true);
            this.dispose();
        } else {
            errorLabel.setText("Invalid username or password!");
            passwordField.setText("");
        }
    }

    /**
     * Handle Register button click
     */
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Registration feature coming soon!", "Register", JOptionPane.INFORMATION_MESSAGE);
        // TODO: Implement registration form
    }

    /**
     * Authenticate user against the database
     * @param username User's username
     * @param password User's password
     * @return true if credentials are valid, false otherwise
     */
    private boolean authenticateUser(String username, String password) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            errorLabel.setText("Database connection error!");
            return false;
        }

        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password); // In production, use password hashing!

            ResultSet rs = pstmt.executeQuery();
            boolean isValid = rs.next();

            rs.close();
            pstmt.close();
            conn.close();

            return isValid;
        } catch (SQLException e) {
            System.err.println("Database query error: " + e.getMessage());
            errorLabel.setText("Database error occurred!");
            return false;
        }
    }

    /**
     * Main method to run the application
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
