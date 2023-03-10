package redoing.imc.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    private String username;
    private String password;
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<IMC> calculosIMC;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
