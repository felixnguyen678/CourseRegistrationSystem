package POJO;

import DAO.AccountDAO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Account {
    private String username;
    private String password;
    private String accountName;
    private String email;
    private String phoneNumber;

    public Account(){}
    public Account(String username, String password, String accountName, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.accountName = accountName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public Account(Account account) {
        this.username = account.username;
        this.password = account.password;
        this.accountName = account.accountName;
        this.email = account.email;
        this.phoneNumber = account.phoneNumber;
    }

    @Id
    @Column(name = "username", nullable = false, length = 10)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 10)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "account_name", nullable = true, length = 10)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 20)
    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email;}

    @Basic
    @Column(name = "phone_number", nullable = true, length = 20)
    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(accountName, account.accountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, accountName);
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
