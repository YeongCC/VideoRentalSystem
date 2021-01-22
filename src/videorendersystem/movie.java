/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorendersystem;

import java.util.Date;

public class movie {

    double price;
    int movie, quanlity;
    Date date = new Date();

    public movie(int movie, int quanlity) {
        this.movie = movie;
        this.quanlity = quanlity;
    }

    public movie() {
    }

    public int getMovie() {
        return movie;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public String getMovieName() {
        String name = "";
        switch (movie) {
            case 0:
                name = "The Family";
                break;
            case 1:
                name = "DRIVE ANGRY";
                break;
            case 2:
                name = "THE FOREIGNER";
                break;
            case 3:
                name = "Mulan";
                break;
            case 4:
                name = "IP MAN4";
                break;
            case 5:
                name = "ACE VENTORA";
                break;
            case 6:
                name = "KING OF COMEDY";
                break;
            case 7:
                name = "SHADLIN SOCCER";
                break;
            case 8:
                name = "FIGHT BACK TO SHCOOL";
                break;
            case 9:
                name = "ALL FOR THE WINNER";
                break;
            case 10:
                name = "EPIK";
                break;
            case 11:
                name = "LIFE";
                break;
            case 12:
                name = "RUYI'S ROYAL LOVE IN THE PLACE";
                break;
            case 13:
                name = "LEAVE RAGE";
                break;
            case 14:
                name = "LIKE YOU MORE MORE";
                break;
            case 15:
                name = "THE FISH EATER";
                break;
            case 16:
                name = "ANNABELLE";
                break;
            case 17:
                name = "HAUNTED";
                break;
            case 18:
                name = "PET SEMATARY";
                break;
            case 19:
                name = "HOUSE ON HAUNTED HILL";
                break;
            case 20:
                name = "ISN'T IT ROMATIC";
                break;
            case 21:
                name = "BREAK UP CONTACT";
                break;
            case 22:
                name = "FALL IN LOVE LIKE A STAR";
                break;
            case 23:
                name = "BARCELONA A LOVE UNTOLD";
                break;
            case 24:
                name = "COUPLES RETREAT";
                break;
        }
        return name;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public String getQuanlityName() {
        String qua = "";
        switch (quanlity) {
            case 1:
                qua = "Standard Definition";
                break;
            case 2:
                qua = "High Definition";
                break;
        }
        return qua;
    }

    public double getQuanlityPrice() {
        switch (quanlity) {
            case 1:
                price = 0;
                break;
            case 2:
                price = 5;
                break;
        }
        return price;
    }

    public double getTotal() {
        return price;
    }
}
