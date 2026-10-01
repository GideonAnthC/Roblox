import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login() {

        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        // Username
        add(new JLabel("Username:"));
        JTextField usernameField = new JTextField(15);
        add(usernameField);

        // Password
        add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField(15);
        add(passwordField);

        // LOGIN BUTTON
        JButton loginButton = new JButton("Login");
        add(loginButton);

        // SIGN UP BUTTON
        JButton signupButton = new JButton("Sign Up");
        add(signupButton);

        // Sign Up action
        signupButton.addActionListener(e -> {
            new Signup();
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
