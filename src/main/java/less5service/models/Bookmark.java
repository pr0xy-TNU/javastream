package less5service.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bookmark implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @ManyToOne
    private Account account;

    private String uri;
    private String description;

    Bookmark() {
        //
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {

        return uri;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {

        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Bookmark(Account account, String uri, String description) {
        this.account = account;
        this.uri = uri;
        this.description = description;
    }
}
