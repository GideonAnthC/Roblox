import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Signup extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;

    public Signup() {

        setTitle("Sign Up");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        add(passwordField);

        JButton signupButton = new JButton("Sign Up");
        JButton loginButton = new JButton("Back to Login");

        add(signupButton);
        add(loginButton);

        signupButton.addActionListener(e -> signup());

        loginButton.addActionListener(e -> {
            new Login();
            dispose();
        });

        setVisible(true);
    }

    private void signup() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields."
            );

            return;
        }

        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Account created successfully!"
            );

            new Login();
            dispose();

        } catch (SQLIntegrityConstraintViolationException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Username already exists."
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database error: " + ex.getMessage()
            );
        }
    }
}
