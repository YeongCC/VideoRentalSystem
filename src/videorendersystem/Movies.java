/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorendersystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Movies extends Application {

    //Class
    public static client people = new client();
    String name = null, email = null, phoneNumber = null;
    double money = 0;
    //Scene
    Scene scene;
    BorderPane root = new BorderPane();
    StackPane register = new StackPane(), login2 = new StackPane();
    //Text
    static TextField LName = new TextField(), RName = new TextField(), REmail = new TextField(), RPhone_Number = new TextField();
    static PasswordField LPassword = new PasswordField(), RPassword = new PasswordField(), RPassword2 = new PasswordField();
    Button loginButton = new Button("Login"), registerButton = new Button("Register"), exitButton = new Button("Exit");
    Text a = new Text("Login"), b = new Text("Register");
    static int page1 = 1;

    @Override
    public void start(Stage primaryStage) {
        Menu();
        loginButton.setOnMouseEntered(a -> {
            loginButton.setStyle("-fx-background-color: #94b447");
            loginButton.setEffect(new DropShadow());

        });
        loginButton.setOnMouseExited(a -> {
            loginButton.setEffect(null);
            loginButton.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");

        });

        exitButton.setOnMouseEntered(a -> {
            exitButton.setStyle("-fx-background-color: #94b447");
            exitButton.setEffect(new DropShadow());
        });

        exitButton.setOnMouseExited(a -> {
            exitButton.setEffect(null);
            exitButton.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        });

        registerButton.setOnMouseEntered(a -> {
            registerButton.setStyle("-fx-background-color: #94b447");
            registerButton.setEffect(new DropShadow());
        });

        registerButton.setOnMouseExited(a -> {
            registerButton.setEffect(null);
            registerButton.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        });

        a.setOnMouseEntered(a -> {
            if (page1 == 1) {
                this.a.setFill(Color.OLIVEDRAB);
            } else if (page1 == 0) {
                this.a.setFill(Color.OLIVE);
            }
        });
        a.setOnMouseExited(a -> {
            if (page1 == 1) {
                this.a.setFill(Color.OLIVE);
            } else if (page1 == 0) {
                this.a.setFill(Color.BLACK);
            }
        });
        b.setOnMouseEntered(a -> {
            if (page1 == 1) {
                this.b.setFill(Color.OLIVE);
            } else if (page1 == 0) {
                this.b.setFill(Color.OLIVEDRAB);
            }
        });
        b.setOnMouseExited(a -> {
            if (page1 == 1) {
                this.b.setFill(Color.BLACK);
            } else if (page1 == 0) {
                this.b.setFill(Color.OLIVE);
            }
        });
        LName.setOnMouseClicked(a -> {
            LName.setStyle("-fx-border-color: #7BE495 ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            LPassword.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");

        });
        LPassword.setOnMouseClicked(a -> {
            LPassword.setStyle("-fx-border-color: #7BE495 ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            LName.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        });
        RName.setOnMouseClicked(a -> {
            RName.setStyle("-fx-border-color: #7BE495 ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            REmail.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPhone_Number.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPassword.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPassword2.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        });
        REmail.setOnMouseClicked(a -> {
            REmail.setStyle("-fx-border-color: #7BE495 ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RName.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPhone_Number.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPassword.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPassword2.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        });
        RPhone_Number.setOnMouseClicked(a -> {
            RPhone_Number.setStyle("-fx-border-color: #7BE495 ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RName.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            REmail.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPassword.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPassword2.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        });
        RPassword.setOnMouseClicked(a -> {
            RPassword.setStyle("-fx-border-color: #7BE495 ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RName.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            REmail.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPhone_Number.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPassword2.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        });
        RPassword2.setOnMouseClicked(a -> {
            RPassword2.setStyle("-fx-border-color: #7BE495 ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RName.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            REmail.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPassword.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
            RPhone_Number.setStyle("-fx-focus-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        });
        register.setOnMouseClicked(a -> {
            Menu2();
            page1 = 0;
            LName.setText(null);
            LPassword.setText(null);
        });
        login2.setOnMouseClicked(a -> {
            Menu();
            page1 = 1;
            RName.setText(null);
            REmail.setText(null);
            RPhone_Number.setText(null);
            RPassword.setText(null);
            RPassword2.setText(null);
        });
        scene = new Scene(root);
        primaryStage.setTitle("Movies");
        primaryStage.getIcons().add(new javafx.scene.image.Image("file:resources/small.png"));
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(800);
        primaryStage.setMaxWidth(1000);
        primaryStage.show();

        exitButton.setOnAction(a -> {
            Exit();
        });
        registerButton.setOnAction(a -> {
            String namefield = RName.getText().trim();
            String emailfield = REmail.getText();
            String numberfield = RPhone_Number.getText();
            String passwordfield = RPassword.getText();
            String passwordfield2 = RPassword2.getText();
            String id = people.getId();
            if (namefield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field Should Not Be Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (emailfield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field Should Not Be Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (numberfield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field Should Not Be Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (passwordfield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field Should Not Be Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (passwordfield2.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field Should Not Be Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!validName(namefield.trim())) {
                JOptionPane.showMessageDialog(null, "Name Should Not Be Number Or Space", "Warning", JOptionPane.WARNING_MESSAGE);
                RName.setText(null);
            } else if (!validEmail(emailfield)) {
                JOptionPane.showMessageDialog(null, "Invalid Email Format", "Warning", JOptionPane.WARNING_MESSAGE);
                REmail.setText(null);
            } else if (!validPhoneNumber(numberfield) && !validPhoneNumber2(numberfield) && !validPhoneNumber3(numberfield) && !validPhoneNumber4(numberfield)) {
                JOptionPane.showMessageDialog(null, "Invalid Phone Number Format", "Warning", JOptionPane.WARNING_MESSAGE);
                RPhone_Number.setText(null);
            } else if (!passwordfield.equals(passwordfield2)) {
                JOptionPane.showMessageDialog(null, "Password Not Match", "Warning", JOptionPane.WARNING_MESSAGE);
                RPassword2.setText(null);
            } else {
                try {
                    String fileName = "database/client/" + namefield + ".txt";
                    File file = new File("database/client/" + namefield + ".txt");
                    if (file.exists()) {
                        JOptionPane.showMessageDialog(null, "This Name Has Be Used ", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        PrintWriter output = new PrintWriter(fileName);
                        output.println(id);
                        output.println(namefield);
                        output.println(emailfield);
                        output.println(numberfield);
                        output.println(2);
                        output.println(0);
                        output.println(passwordfield);
                        output.close();
                        String movie_Filename = "database/movie/" + namefield;
                        File movieFile = new File(movie_Filename);
                        movieFile.mkdir();
                        try {
                            String receip_Filename = "database/receipt/" + namefield + ".txt";
                            File receiptFile = new File(receip_Filename);
                            receiptFile.createNewFile();
                        } catch (Exception y) {
                        }
                        JOptionPane.showMessageDialog(null, "Register Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                        RName.setText(null);
                        REmail.setText(null);
                        RPhone_Number.setText(null);
                        RPassword.setText(null);
                        RPassword2.setText(null);
                        Menu();
                    }
                } catch (FileNotFoundException z) {

                } catch (NumberFormatException y) {
                    JOptionPane.showMessageDialog(null, "Cannot Be Number Or Space", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }

        });
        loginButton.setOnAction(a -> {
            String namefield = LName.getText();
            String passwordfield = LPassword.getText();

            if (namefield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field Should Not Be Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (passwordfield.equals("")) {
                JOptionPane.showMessageDialog(null, "Text Field Should Not Be Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                String fileName = "database/client/" + namefield + ".txt";
                String tempname = "";
                String id = "";
                String phoneNumber = "";
                String email = "";
                String temppassword = "";
                String member = "";
                String money = "";
                try {
                    Scanner check = new Scanner(new File(fileName));
                    while (check.hasNext()) {
                        id = check.next();
                        tempname = check.next();
                        email = check.next();
                        phoneNumber = check.next();
                        member = check.next();
                        money = check.next();
                        temppassword = check.next();

                        if (tempname.trim().equals(namefield.trim()) && temppassword.trim().equals(passwordfield.trim())) {
                            LName.setText(null);
                            LPassword.setText(null);
                            Double amount = new Double(money);
                            int mem = new Integer(member);
                            people = new client(tempname, id, phoneNumber, email, temppassword, mem, amount);
                            JOptionPane.showMessageDialog(null, "Login Sucessful " + people.getName() + " !\nYour Amount Left MYR " + people.getAmount(), "Welcome !", JOptionPane.INFORMATION_MESSAGE);
                            Secondpage page2 = new Secondpage();
                            page2.start(new Stage());
                            ((Node) a.getSource()).getScene().getWindow().hide();
                        } else if (!tempname.trim().equals(namefield.trim())) {
                            JOptionPane.showMessageDialog(null, "Invalid Username", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else if (!temppassword.trim().equals(passwordfield.trim())) {
                            JOptionPane.showMessageDialog(null, "Invalid Password", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    check.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Account Not Exists", "Warning", JOptionPane.WARNING_MESSAGE);
                    LName.setText(null);
                    LPassword.setText(null);
                }
            }
        });

    }

    public void Menu() {
        HBox base = new HBox();
        Image img = new Image("file:resources/main.jpg");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(800);
        pic.setFitWidth(500);
        VBox wordtitle = new VBox();
        Text word = new Text("\n    Movie");
        Text word2 = new Text("              is ");
        Text word3 = new Text("       A Day of the Beginning");
        word.setFont(Font.font("Arial Black", FontWeight.BOLD, 90));
        word.setFill(Color.WHITE);
        word2.setFont(Font.font("Arial Black", FontWeight.NORMAL, 50));
        word2.setFill(Color.WHITE);
        word3.setFont(Font.font("Arial Black", FontWeight.BOLD, 30));
        word3.setFill(Color.WHITE);
        wordtitle.getChildren().addAll(word, word2, word3);
        StackPane left = new StackPane(pic, wordtitle);
        StackPane right = new StackPane();
        VBox space = new VBox();
        HBox line = new HBox();
        StackPane inside = new StackPane();
        a.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 15));
        a.setFill(Color.OLIVE);
        StackPane login = new StackPane();
        login.setStyle("-fx-background-color:#CBE54E");
        login.setPadding(new Insets(10, 20, 10, 20));
        login.getChildren().add(a);

        b.setFont(Font.font("Segoe UI Semibold", 15));
        b.setFill(Color.BLACK);
        register.setStyle("-fx-background-color:#94B447");
        register.setPadding(new Insets(10, 20, 10, 20));
        register.getChildren().add(b);
        line.getChildren().addAll(login, register);

        VBox inside2 = new VBox();
        Text title = new Text("Welcome Login");
        title.setFill(Color.OLIVEDRAB);
        title.setFont(Font.font("Segoe UI Semibold", 40));

        VBox NameLine = new VBox();
        Text nameLogin = new Text("Name : ");
        nameLogin.setFill(Color.OLIVEDRAB);
        nameLogin.setFont(Font.font("Segoe UI Semibold", 15));
        LName.setPromptText("Enter your name");
        LName.setStyle("-fx-border-color: transparent ; -fx-border-width: 2px ;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        NameLine.getChildren().addAll(nameLogin, LName);
        NameLine.setSpacing(20);

        VBox PasswordLine = new VBox();
        Text passwordLogin = new Text("Password :");
        passwordLogin.setFill(Color.OLIVEDRAB);
        passwordLogin.setFont(Font.font("Segoe UI Semibold", 15));
        LPassword.setPromptText("Enter your password");
        LPassword.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        PasswordLine.getChildren().addAll(passwordLogin, LPassword);
        PasswordLine.setSpacing(20);
        HBox ButtonLine = new HBox();
        loginButton.setMinSize(150, 60);
        loginButton.setFont(Font.font("Segoe UI Semibold", 20));
        loginButton.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");

        exitButton.setMinSize(150, 60);
        exitButton.setFont(Font.font("Segoe UI Semibold", 20));
        exitButton.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");

        ButtonLine.getChildren().addAll(loginButton, exitButton);
        ButtonLine.setSpacing(40);
        inside2.getChildren().addAll(title, NameLine, PasswordLine, ButtonLine);
        inside2.setSpacing(50);

        inside.getChildren().addAll(inside2);
        inside.setStyle("-fx-background-color:#CBE54E");
        inside.setPadding(new Insets(50, 30, 30, 30));
        space.getChildren().addAll(line, inside);
        right.getChildren().add(space);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(70, 50, 150, 50));
        right.setAlignment(Pos.TOP_CENTER);
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void Menu2() {
        HBox base = new HBox();
        Image img = new Image("file:resources/main.jpg");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(800);
        pic.setFitWidth(500);
        VBox wordtitle = new VBox();
        Text word = new Text("\n    Movie");
        Text word2 = new Text("              is ");
        Text word3 = new Text("       A Day of the Beginning");
        word.setFont(Font.font("Arial Black", FontWeight.BOLD, 90));
        word.setFill(Color.WHITE);
        word2.setFont(Font.font("Arial Black", FontWeight.NORMAL, 50));
        word2.setFill(Color.WHITE);
        word3.setFont(Font.font("Arial Black", FontWeight.BOLD, 30));
        word3.setFill(Color.WHITE);
        wordtitle.getChildren().addAll(word, word2, word3);
        StackPane left = new StackPane(pic, wordtitle);
        StackPane right = new StackPane();
        VBox space = new VBox();
        HBox line = new HBox();
        StackPane inside = new StackPane();
        a.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 15));
        a.setFill(Color.BLACK);
        login2.setStyle("-fx-background-color:#94B447");
        login2.setPadding(new Insets(10, 20, 10, 20));
        login2.getChildren().add(a);

        b.setFont(Font.font("Segoe UI Semibold", 15));
        b.setFill(Color.OLIVE);
        StackPane register2 = new StackPane();
        register2.setStyle("-fx-background-color:#CBE54E");
        register2.setPadding(new Insets(10, 20, 10, 20));
        register2.getChildren().add(b);
        line.getChildren().addAll(login2, register2);

        VBox inside2 = new VBox();
        Text title = new Text("Welcome Register !");
        title.setFill(Color.OLIVEDRAB);
        title.setFont(Font.font("Segoe UI Semibold", 35));

        VBox NameLine = new VBox();
        Text nameRegister = new Text("Name : ");
        nameRegister.setFill(Color.OLIVEDRAB);
        nameRegister.setFont(Font.font("Segoe UI Semibold", 15));
        RName.setPromptText("Enter your name");
        RName.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        NameLine.getChildren().addAll(nameRegister, RName);
        NameLine.setSpacing(10);

        VBox EmailLine = new VBox();
        Text emailRegister = new Text("Email : ");
        emailRegister.setFill(Color.OLIVEDRAB);
        emailRegister.setFont(Font.font("Segoe UI Semibold", 15));
        REmail.setPromptText("email@example.com");
        REmail.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        EmailLine.getChildren().addAll(emailRegister, REmail);
        EmailLine.setSpacing(10);

        VBox PhoneNumberLine = new VBox();
        Text phoneRegister = new Text("Phone Number : ");
        phoneRegister.setFill(Color.OLIVEDRAB);
        phoneRegister.setFont(Font.font("Segoe UI Semibold", 15));
        RPhone_Number.setPromptText("ex. 000-0000000");
        RPhone_Number.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        PhoneNumberLine.getChildren().addAll(phoneRegister, RPhone_Number);
        PhoneNumberLine.setSpacing(10);

        VBox PasswordLine = new VBox();
        Text passwordRegister = new Text("Password :");
        passwordRegister.setFill(Color.OLIVEDRAB);
        passwordRegister.setFont(Font.font("Segoe UI Semibold", 15));
        RPassword.setPromptText("Enter your password");
        RPassword.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        PasswordLine.getChildren().addAll(passwordRegister, RPassword);
        PasswordLine.setSpacing(10);

        VBox PasswordLine2 = new VBox();
        Text passwordRegister2 = new Text("Password :");
        passwordRegister2.setFill(Color.OLIVEDRAB);
        passwordRegister2.setFont(Font.font("Segoe UI Semibold", 15));
        RPassword2.setPromptText("Reenter your password again");
        RPassword2.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        PasswordLine2.getChildren().addAll(passwordRegister2, RPassword2);
        PasswordLine2.setSpacing(20);

        HBox ButtonLine = new HBox();
        registerButton.setMinSize(150, 60);
        registerButton.setFont(Font.font("Segoe UI Semibold", 20));
        registerButton.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        exitButton.setMinSize(150, 60);
        exitButton.setFont(Font.font("Segoe UI Semibold", 20));
        exitButton.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        ButtonLine.getChildren().addAll(registerButton, exitButton);
        ButtonLine.setSpacing(40);
        inside2.getChildren().addAll(title, NameLine, EmailLine, PhoneNumberLine, PasswordLine, PasswordLine2, ButtonLine);
        inside2.setSpacing(20);
        inside.getChildren().addAll(inside2);
        inside.setStyle("-fx-background-color:#CBE54E");
        inside.setPadding(new Insets(50, 30, 30, 30));
        space.getChildren().addAll(line, inside);
        right.getChildren().add(space);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(70, 50, 30, 50));
        right.setAlignment(Pos.TOP_CENTER);
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void Exit() {
        ImageIcon icon = new ImageIcon(Movies.class.getResource("image/small.png"));
        int bye = JOptionPane.showConfirmDialog(null, "Conform Exit?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (bye == 0) {
            System.exit(0);
        }
    }

    public static boolean validPhoneNumber(String input) {
        Pattern p = Pattern.compile("([0-9]{3}[- .]?[0-9]{7})");
        Matcher m = p.matcher(input);
        return (m.find() && m.group().equals(input));
    }

    public static boolean validPhoneNumber2(String input) {
        Pattern p2 = Pattern.compile("([0-9]{3}[- .]?[0-9]{8})");
        Matcher m2 = p2.matcher(input);
        return (m2.find() && m2.group().equals(input));
    }

    public static boolean validPhoneNumber3(String input) {
        Pattern p3 = Pattern.compile("([0-9]{11})");
        Matcher m3 = p3.matcher(input);
        return (m3.find() && m3.group().equals(input));
    }

    public static boolean validPhoneNumber4(String input) {
        Pattern p4 = Pattern.compile("([0-9]{12})");
        Matcher m4 = p4.matcher(input);
        return (m4.find() && m4.group().equals(input));
    }

    public static boolean validEmail(String input) {
        return input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean validName(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
