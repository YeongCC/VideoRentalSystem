/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorendersystem;

import java.text.DecimalFormat;

/**
 *
 * @author User
 */
public class rent_movie extends movie {

    int quanlity, time, members;
    double price;
    DecimalFormat decimal = new DecimalFormat("0.00");

    public rent_movie(int movie, int time, int quanlity, int members) {
        super(movie, quanlity);
        this.time = time;
        this.members = members;
        this.price = price;
    }

    public rent_movie() {
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public double getMoviePrice() {
        switch (movie) {
            case 0:
                this.price = 1.7;
                break;
            case 1:
                this.price = 1.8;
                break;
            case 2:
                this.price = 3.2;
                break;
            case 3:
                this.price = 2.4;
                break;
            case 4:
                this.price = 3.5;
                break;
            case 5:
                this.price = 1.5;
                break;
            case 6:
                this.price = 2.5;
                break;
            case 7:
                this.price = 2.5;
                break;
            case 8:
                this.price = 3.0;
                break;
            case 9:
                this.price = 3.5;
                break;
            case 10:
                this.price = 1.0;
                break;
            case 11:
                this.price = 2.5;
                break;
            case 12:
                this.price = 4.0;
                break;
            case 13:
                this.price = 2.0;
                break;
            case 14:
                this.price = 1.5;
                break;
            case 15:
                this.price = 2.0;
                break;
            case 16:
                this.price = 2.4;
                break;
            case 17:
                this.price = 1.9;
                break;
            case 18:
                this.price = 3.0;
                break;
            case 19:
                this.price = 1.7;
                break;
            case 20:
                this.price = 2.5;
                break;
            case 21:
                this.price = 2.2;
                break;
            case 22:
                this.price = 2.4;
                break;
            case 23:
                this.price = 1.7;
                break;
            case 24:
                this.price = 1.5;
                break;
        }
        return this.price;
    }

    public int getMembers() {
        return members;
    }

    public double getTotal() {
        double total = 0;
        if (this.members == 1) {
            if (this.getQuanlity() == 2) {
                double total_price = (getMoviePrice() + getQuanlityPrice()) * getTime();
                double discount_price = (total_price * 40) / 100;
                total = total_price - discount_price;
            } else if (this.getQuanlity() == 1) {
                double total_price = this.price * this.time;
                double discount_price = (total_price * 40) / 100;
                total = total_price - discount_price;
            }
        } else if (this.members == 2) {
            if (this.getQuanlity() == 2) {
                total = (getMoviePrice() + getQuanlityPrice()) * getTime();
            } else if (this.getQuanlity() == 1) {
                total = this.price * this.time;
            }
        }
        
        return total;
    }

    public double minus(double money) {
        double total = money - this.getTotal();
        return total;
    }

    @Override
    public String toString() {
        String msg = "";
        if (Movies.people.getMember() == 1) {
            double left = Movies.people.getAmount();
            msg = "Movie Name : " + getMovieName() + "\nMovie Quality : " + getQuanlityName() + "\nPrice : MYR " + decimal.format(getTotal()) + "\nGot 40% discount" + "\nRent Day : " + time + "\nAmount left : MYR" + decimal.format(left) + "\nDate : " + date;
        } else {
            double left = Movies.people.getAmount();
            msg = "Movie Name : " + getMovieName() + "\nMovie Quality : " + getQuanlityName() + "\nPrice : MYR " + decimal.format(getTotal()) + "\nRent Day : " + time + "\nAmount left : MYR" + decimal.format(left) + "\nDate : " + date;
        }

        return msg;
    }
}
