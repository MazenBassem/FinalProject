import javax.swing.*;
import java.util.Date;
import java.util.UUID;

public class User {
    private String userId;
    private String password;
    private String userName;
    private String email;
    private Date dateOfBirth;
    private String status;

    public User(String userId, String password, String userName, String email, Date dateOfBirth, String status) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
