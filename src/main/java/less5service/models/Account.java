package less5service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    public Collection<Bookmark> getBooks() {
        return books;
    }

    @OneToMany(mappedBy = "account")
    private Set<Bookmark> books = new HashSet<>();

    @JsonIgnore
    private String password;
    private String login;

    public Account() {
        //
    }

    public Account(String password, String login) {
        this.password = password;
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {

        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
