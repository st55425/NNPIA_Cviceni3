package cz.upce.nnpia;

public class Email {

    private String email;

    public Email(String email) {
        this.email = email;
    }

    public Email() {
        email = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
