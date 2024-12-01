import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Window {
    private JPanel mainPanel;
    private JFrame frame;
    private UserService userService;
    public void start(){
        this.userService = userService;
        frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(mainScreen(), "Main");
        mainPanel.add(signupScreen(), "Signup");
        mainPanel.add(loginScreen(), "Login");
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    private JPanel mainScreen(){
        JPanel panel = new JPanel(new GridLayout(4, 1, 50, 50));
        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(e -> {
            switchToScreen("Signup", "Signup");
        });
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            switchToScreen("Login", "Login");
        });
        panel.add(signupButton);
        panel.add(loginButton);
        return panel;
    }
    private JPanel signupScreen(){
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel dobLabel = new JLabel("Date of Birth:");
        JTextField dobField = new JTextField("yyyy-mm-dd");

        JButton signupButton = new JButton("Signup");
        JButton backButton = new JButton("Back");
        signupButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String email = emailField.getText().trim();
            String password = String.valueOf(passwordField.getPassword());
            String dob = dobField.getText().trim();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date date = sdf.parse(dob);
                userService.signUp(email,username,password,date);
            }catch (ParseException ex){JOptionPane.showMessageDialog(null,"Incorrect date format");}

        });
        backButton.addActionListener(e -> {switchToScreen("Main", "Main");});
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(dobLabel);
        panel.add(dobField);
        panel.add(signupButton);
        panel.add(backButton);
        return panel;
    }
    private JPanel loginScreen(){
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");
        loginButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = String.valueOf(passwordField.getPassword());
            userService.login(email,password);
        });
        backButton.addActionListener(e -> {switchToScreen("Main", "Main");});
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(backButton);
        return panel;
    }
    private void switchToScreen(String screen, String title){
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, screen);
        frame.setTitle(title);
    }
    public static void main(String[] args) {new Window().start();}
}
