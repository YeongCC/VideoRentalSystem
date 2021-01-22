/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorendersystem;

/**
 *
 * @author User
 */
public class client {

    String name, id, phone_number, email, password;
    double amount;
    int member;

    public client(String name, String id, String phone_number, String email, String password, int member, double amount) {
        this.name = name;
        this.id = id;
        this.phone_number = phone_number;
        this.email = email;
        this.member = member;
        this.amount = amount;
        this.password = password;
    }

    public client() {
        setId();
    }

    public void setId() {
        int random_id = (int) (10000 + Math.random() * 10000);
        id = String.format("%5s", random_id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getMember() {
        return member;
    }

    public String getMemberName() {
        String name = "";
        switch (member) {
            case 1:
                name = "member";
                break;
            case 2:
                name = "not member";
                break;
        }
        return name;
    }

    public double getAmount() {
        return amount;
    }

}
