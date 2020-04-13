import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String username;
    private String password;
    private String role;


    //tillfällig database skapa en lista User
    private List<User> users = new ArrayList<>();



    public User(){
        // tillfällig database: anropar en metod populate för att fylla lista users;
        populate();
    };

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //-------------------------------------

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

// kommer att vara kopplat med en riktig database
    public void populate(){
        users.add(new User("11111111","11111111", "customer"));
        users.add(new User("22222222","22222222", "premium"));
        users.add(new User("33333333","33333333", "admin"));
    }

    public String toString(){
        String user = "Name: " + username + " " + "Password: " + password + "Role: " + role;
        return user;
    }

    public User check(String usernameInput, String passwordInput) {
        for (int i = 0; i < users.size(); i++) {
            if (usernameInput.equals(users.get(i).getUsername()) && passwordInput.equals(users.get(i).getPassword()))
                return users.get(i);
        }
        return null;
    }


// ATT TA BORT ANNARS BLIR EYVIND TOKIG

    public static void main(String[] args) {
        User u = new User();
        u.check("33333333", "33333333");
    }


}