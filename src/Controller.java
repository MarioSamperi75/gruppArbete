import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "controller")
@SessionScoped

public class Controller implements Serializable {
   private String usernameInput;
   private String passwordInput;
   private String message;
   private User currentUser;

//-----------------------------------------------


    public String getUsernameInput() {
        return usernameInput;
    }

    public void setUsernameInput(String usernameInput) {
        this.usernameInput = usernameInput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(String passwordInput) {
        this.passwordInput = passwordInput;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String submit () {
       User user= new User();
       this.currentUser = user.check(usernameInput,passwordInput);
       if (!(currentUser == null))
            if (currentUser.getRole().equals("admin"))
                return "admin";
            else
                return "customer";
        this.message= "Not Found";
        return "";

    }




    public void reset() {
       usernameInput = "";
       passwordInput = "";
    }
}
