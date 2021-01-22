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
public class buy_movie extends movie {

    int members;
    double price;
    DecimalFormat decimal = new DecimalFormat("0.00");

    public buy_movie(int movie, int quanlity, int members) {
        super(movie, quanlity);
        this.members = members;
        this.price = price;
    }

    public buy_movie() {
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoviePrice() {
        switch (movie) {
            case 0:
                this.price += 17;
                break;
            case 1:
                this.price += 18;
                break;
            case 2:
                this.price += 32;
                break;
            case 3:
                this.price += 24;
                break;
            case 4:
                this.price += 35;
                break;
            case 5:
                this.price += 15;
                break;
            case 6:
                this.price += 25;
                break;
            case 7:
                this.price += 25;
                break;
            case 8:
                this.price += 30;
                break;
            case 9:
                this.price += 35;
                break;
            case 10:
                this.price += 10;
                break;
            case 11:
                this.price += 25;
                break;
            case 12:
                this.price += 40;
                break;
            case 13:
                this.price += 20;
                break;
            case 14:
                this.price += 15;
                break;
            case 15:
                this.price += 20;
                break;
            case 16:
                this.price += 24;
                break;
            case 17:
                this.price += 19;
                break;
            case 18:
                this.price += 30;
                break;
            case 19:
                this.price += 17;
                break;
            case 20:
                this.price += 25;
                break;
            case 21:
                this.price += 22;
                break;
            case 22:
                this.price += 24;
                break;
            case 23:
                this.price += 17;
                break;
            case 24:
                this.price += 15;
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
                double total_price = super.price + this.price;
                double discount_price = total_price * 30 / 100;
                total = total_price - discount_price;
            } else if (this.getQuanlity() == 1) {
                double total_price = super.price + this.price;
                double discount_price = total_price * 30 / 100;
                total = total_price - discount_price;
            }
        } else if (this.members == 2) {
            if (this.getQuanlity() == 2) {
                total = super.price + this.price;
            } else if (this.getQuanlity() == 1) {
                total = super.price + this.price;
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
            msg = "Movie Name : " + getMovieName() + "\nMovie Quality : " + getQuanlityName() + "\nPrice : MYR " + decimal.format(getTotal()) + "\nGot 30% discount" + "\nAmount left : MYR" + decimal.format(left) + "\nBuy Date : " + date;
        } else {
            double left = Movies.people.getAmount();
            msg = "Movie Name : " + getMovieName() + "\nMovie Quality : " + getQuanlityName() + "\nPrice : MYR " + decimal.format(getTotal()) + "\nAmount left : MYR" + decimal.format(left) + "\nBuy Date : " + date;
        }
        return msg;
    }

}
