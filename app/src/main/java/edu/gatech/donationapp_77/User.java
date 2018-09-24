package edu.gatech.donationapp_77;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String newPassword) {
        password = newPassword;
    }

    public void setPassword(String newEmail) {
        email = newEmail;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;
        return (this.email.equals(that.email) && this.password.equals(that.password));
    }
}
