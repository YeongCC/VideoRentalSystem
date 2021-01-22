package videorendersystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Secondpage extends Application {

    //data
    public static buy_movie movie;
    public static rent_movie movie1;
    final Image ApplicationIcon = new Image("file:resources/movieIcon.png");
    final ImageView DIALOG_HEADER_ICON = new ImageView(ApplicationIcon);
    ImageIcon icon = new ImageIcon(Movies.class.getResource("image/small.png"));
    private String imageData[] = {"file:resources/movie_list/A1.jpeg", "file:resources/movie_list/A2.jpeg", "file:resources/movie_list/A3.jpeg", "file:resources/movie_list/A4.jpeg", "file:resources/movie_list/A5.jpeg", "file:resources/movie_list/C1.jpeg", "file:resources/movie_list/C2.jpeg", "file:resources/movie_list/C3.jpeg", "file:resources/movie_list/C4.jpeg", "file:resources/movie_list/C5.jpeg", "file:resources/movie_list/D1.jpeg", "file:resources/movie_list/D2.jpeg", "file:resources/movie_list/D3.jpeg", "file:resources/movie_list/D4.jpeg", "file:resources/movie_list/D5.jpeg", "file:resources/movie_list/H1.jpeg", "file:resources/movie_list/H2.jpeg", "file:resources/movie_list/H3.jpeg", "file:resources/movie_list/H4.jpeg", "file:resources/movie_list/H5.jpeg", "file:resources/movie_list/R1.jpeg", "file:resources/movie_list/R2.jpeg", "file:resources/movie_list/R3.jpeg", "file:resources/movie_list/R4.jpeg", "file:resources/movie_list/R5.jpeg"};
    private String MovieName[] = {"The Family", "DRIVE ANGRY", "THE FOREIGNER", "Mulan", "IP MAN4", "ACE VENTORA", "KING OF COMEDY", "SHADLIN SOCCER", "FIGHT BACK TO SHCOOL", "ALL FOR THE WINNER", "EPIK", "LIFE", "RUYI'S ROYAL LOVE\nIN THE PLACE", "LEAVE RAGE", "LIKE YOU MORE MORE", "THE FISH EATER", "ANNABELLE", "HAUNTED", "PET SEMATARY", "HOUSE ON HAUNTED HILL", "ISN'T IT ROMATIC", "BREAK UP CONTACT", "FALL IN LOVE LIKE A STAR", "BARCELONA A LOVE UNTOLD", "COUPLES RETREAT"};
    private String MovieType[] = {"Action", "Comedy", "Drama", "Horror", "Romatic"};
    private double price[] = {17, 18, 32, 24, 35, 15, 25, 25, 30, 35, 10, 25, 40, 20, 15, 20, 24, 19, 30, 17, 25, 22, 24, 17, 15};
    private double rent_price[] = {1.7, 1.8, 3.2, 2.4, 3.5, 1.5, 2.5, 2.5, 3.0, 3.5, 1.0, 2.5, 4.0, 2.0, 1.5, 2.0, 2.4, 1.9, 3.0, 1.7, 2.5, 2.2, 2.4, 1.7, 1.5};
    private String detail[] = {"The Manzoni family, a notorious mafia clan, is relocated to Normandy, France under the Witness Protection Program, where fitting in soon becomes challenging, as their old habits die hard.",
        "John Milton escapes Hell and steals Satan's gun, the Godkiller, to kill Jonah King. King, a cult leader who killed Milton's daughter and her husband, plans to sacrifice Milton's infant granddaughter, believing it will unleash Hell on Earth.\n"
        + "\n"
        + "After interrogating and murdering some of King's followers in Colorado, Milton discovers that the ritual will take place in Stillwater, an abandoned prison in Louisiana. On his way there he stops by a diner, where he meets Piper, a waitress. Milton abandons his damaged car and sabotages Piper's car, a 1969 Dodge Charger, offering to fix it in exchange for a ride.",
        "Ngoc Minh Quan, a widowed former Vietnam War special operations forces soldier, runs a Chinese restaurant called Happy Peacock in London with his business partner Lam and his teenage daughter Fan. When Fan is killed in a terrorist bombing, he seeks revenge. An Irish republican group calling itself the \"Authentic IRA\" claims responsibility. Quan takes to visiting Scotland Yard daily, asking for names of the bombers, but is told by police chief Commander Bromley that his repeated visits are diverting resources away from the investigation. Bromley advises Quan to be patient and warns him against going after the IRA. Undeterred, Quan takes matters into his own hands and next focuses on the Northern Ireland deputy First Minister and Sinn Féin politician Liam Hennessy, who speaks publicly about his status as a former Provisional IRA leader while condemning the attack. Quan purchases items to make homemade weapons and travels to Belfast, leaving the restaurant under Lam's control.",
        "In Imperial China, Hua Mulan is an adventurous and active girl, to the disappointment of her parents, who hopes that one day she will be wed to a good husband. As a young woman, Mulan is forced to meet with a matchmaker to demonstrate her fitness as a future wife. Mulan, flustered, attempts to pour tea in front of the matchmaker, but a spider causes a panic that destroys the kettle, and the matchmaker calls her a disgrace in front of her family.",
        "In 1964, following the death of his wife, Ip Man discovers he has throat cancer due to smoking. After his rebellious son Ip Ching fights back against a bully and is expelled from school, Ip Man decides to travel to San Francisco in order to look for study opportunities, asking his friend Bob to keep an eye on his son. His student, Bruce Lee, has upset the local martial arts community in San Francisco by opening a Wing Chun school, teaching non-Chinese people martial arts and writing an English-language book on martial arts.[5] He discovers from an associate and his friend Liang Gen that, because he is a foreigner, a referral letter from the Chinese Consolidated Benevolent Association is needed to enroll into a school. Grandmaster Wan Zhong-hua, the Association's president, refuses to write the letter as Ip is unbothered by Lee's actions, whereas the other grandmasters are against him. After a brief confrontation with Wan (resulting in a broken tabletop), he leaves.",
        "A goofy detective specializing in animals goes in search of the missing mascot of the Miami Dolphins.",
        "Wan Tin-sau (Chow) is the head of his village's community centre, where he gives acting lessons and host community plays. On the side, he is an aspiring actor moonlighting as a movie extra, often taking his work too seriously for the roles he receives.",
        "Sing is a master of Shaolin kung fu, whose goal in life is to promote the spiritual and practical benefits of the art to modern society. He experiments with various methods, but none bear positive results. He then meets \"Golden Foot\" Fung, a legendary Hong Kong soccer star in his day, who is now walking with a limp, following the betrayal of a former teammate Hung, now a rich businessman. Sing explains his desires to Fung who offers his services to coach Sing in soccer. Sing is compelled by the idea of promoting kung fu through soccer and agrees to enlist his former Shaolin brothers to form a team under Fung's management. Sing and Fung attempt to put together an unbeatable soccer team. Fung invites a vicious team to play against them and the thugs proceed to give the Shaolin team a brutal beating. When all seems lost, the Shaolin disciples reawaken and utilise their special powers, dismantling the other team's rough play easily. The thugs then give up and ask to join Sing's team.",
        "Chow Sing-Sing (Stephen Chow) is about to be disqualified from the Royal Hong Kong Police's elite Special Duties Unit (SDU) because of his complete disregard for his teammates during a drill. However, a senior officer, who has taken to Sing's youthful demeanor, instead deploys him as an undercover student into Edinburgh College to recover a stolen revolver. Sing, who turned to the Police Academy because of his dislike for schooling, struggles to fit in academically. The undercover operation is made complicated when Star is partnered with Tat—an aging, incompetent police detective (Ng Man-Tat).",
        "Sing (Stephen Chow) is a mainland China country boy who arrives in Hong Kong to visit his Uncle \"Blackie Tat\" (Ng Man-tat). When Sing stays with his uncle and his friends in their apartment, Blackie soon learns of Sing's supernatural ability to see through objects and, later on, his ability to change playing cards by rubbing them. He takes advantage of this and turns Sing into the Dou Seng or the \"Saint of Gamblers\". After getting into a fight with several alleyway gamblers he meets the lovely Yee-mung A.K.A. \"Lady Dream\" (lit. trans: Beautiful Dream, but euphemistically as wet dream), a henchman for the \"King of Gamblers\", and becomes infatuated with her. Sing quickly becomes a rival to the King and must win his way through a world competition to prove his skill.",
        "It’s time to add the thing (main character(s), hero prop, graphic element) you want to use as an attention grabber and find a layout that works.\n"
        + "\n"
        + "Consider the symbolism. The young boy in this fake film is meant to be somewhat of an antihero, so he is placed in the lower half of the poster with the title overhead – implying that he needs to grow up.\n"
        + "\n"
        + "If nothing seems to work, try sideways or upside down. It’s all been done before.",
        "In the near future, the unmanned Pilgrim 7 space probe returns from Mars to Earth orbit with soil samples potentially containing evidence of extraterrestrial life. The probe is intercepted by the International Space Station, whose six-member crew retrieves its samples. Exobiologist Hugh Derry revives a dormant cell from the sample, which quickly grows into a multi-celled organism that American school children name \"Calvin.\" Derry realises that Calvin's cells can change their specialisation, acting as muscle, neuron, and photosensory cells all at once.",
        "This play is adapted from the first year to thirty years of Qianlong in the Qing Dynasty. The story between Qianlong and \"Ulanara Ruyi\", from the love and knowing each other to the disillusionment of marriage, is the same as \"Zhen Huan Biography\" for describing the struggle of the harem but But it is more focused on portraying the glitzy elegy of royal women under the feudal imperial power.",
        "<<Leverage: Scam Operation Group>> (Korean: 레버리지: 사기조작단) is a weekend series broadcast by South Korean TV North Korea on October 13, 2019. It was created by director Nam Ki Hoon of \"Voice3\" and writer Min Ji Hyung. This play is adapted from the American TV series \"Stealing the Sky\". It tells the story of former insurance investigators and thieves working together to defraud the bad guys' property to get justice.",
        "Because of his ability to \"drill\" into the place in the painting, Qi Xun, the \"superior\" (played by Gao Hanyu), has a headache every time he uses this ability. By chance, he meets the \"healer\" he hits. Feng Shuangshuang (Chen Yumi), Qi Xun, who originally only wanted to test Feng Shuangshuang's identity, fell in love with her unknowingly as he approached Feng Shuangshuang again and again. At the same time, it involves a series of family secrets of the people around them and the previous generation, entanglement, love and hatred, what should Qi Xun and Feng Shuangshuang ultimately do.",
        "After a sudden underwater tremor sets free scores of the prehistoric man-eating fish, an unlikely group of strangers must band together to stop themselves from becoming fish food for the area's new razor-toothed residents.",
        "In Santa Monica, California, John Form, a doctor, presents his expectant wife Mia with a rare vintage porcelain doll as a gift for their first child to be placed in a collection of dolls in their daughter's nursery.",
        "Emily's arrives for her first night-shift as a care-giver, to an elderly dementia patient. In an isolated house her night turns into a nightmare as she is tormented by a vengeful spirit, and starts to uncover the house's dark secrets.",
        "Louis Creed, an emergency physician from Boston, Massachusetts, moves to the small town of Ludlow, Maine with his wife, Rachel, their two young children, Ellie and Gage, and Ellie's cat, Church. Exploring the woods, Rachel and Ellie stumble across a funeral procession of children taking a dead dog to a cemetery called \"Pet Sematary.\" At the university hospital, Louis is left shaken after failing to save the life of Victor Pascow, a student who was fatally injured after being struck and dragged by a vehicle. He later experiences a vivid dream in which Victor leads him to the deadfall at the back of the cemetery and warns him not to \"venture beyond.\" Louis awakens to find his feet and sheets caked in mud, suggesting that the events were more than just a nightmare.",
        "Frederick Loren (Vincent Price), an eccentric millionaire, invites five people to a party he is throwing for his fourth wife Annabelle (Carol Ohmart) in an allegedly haunted house he has rented, promising to give each $10,000 with the stipulation that they stay the entire night in the house after the doors are locked at midnight. The guests are test pilot Lance Schroeder (Richard Long), newspaper columnist Ruth Bridges (Julie Mitchum), psychiatrist Dr. David Trent (Alan Marshal) who specializes in hysteria, Nora Manning (Carolyn Craig) who works for one of Loren's companies, and the house's owner Watson Pritchard (Elisha Cook). All are strangers to both the Lorens and each other, with their only commonality a desperate need for money.",
        "Architect Natalie develops a strong hatred for romantic comedies at an early age, which is exacerbated by her low self-esteem and difficulty in finding love. Her assistant Whitney, a fan of romantic comedies, believes their co-worker Josh is in love with Natalie, but Natalie dismisses the notion because Josh appears to spend all his time staring at a billboard model across the street. One day, Natalie is knocked unconscious during an attempted mugging and finds herself trapped in the stereotypical romantic comedies that she despises. Whitney becomes her enemy and her neighbor Donny becomes a flamboyant homosexual friend offering advice, while Blake, a billionaire client of her company, develops a romantic interest in her. Additionally, Josh whose personality is the same but only remembers the new reality enters into a relationship with the billboard model, who identifies herself as a \"yoga ambassador\" named Isabella.",
        "Li Xing and He Qiaoqiao are childhood sweethearts. They are about to graduate from college. Li Xing’s proposal to Qiaoqiao was rejected on the grounds that \"Li Xing could not meet the material conditions quietly proposed.\" However, they did not know that there was another secret. So the two angrily reached a breakup agreement that \"if both parties are still single in 5 years, they will get married\"... After the five-year contract is over, Qiao Qiao thought that Li Xing was still waiting for her, but unexpectedly received Li Xing’s wedding. phone. How could Qiao Qiao give up, she is about to snatch Li Xing back. What is the secret behind the tearing up of the contract? Will Qiao Qiao's love with Li Xing be continued? ...",
        "Su Xingyu, an instrument tuner for a rock band, meets and falls in love with the band's assistant Tian Xin. The two daydream about becoming a famous singer-songwriter and artist manager, respectively. After Xingyu goes overseas to further his studies, Tian Xin decides to break up with him so that he could concentrate on his career.",
        "Ely (Daniel Padilla) can't get over his past love. In Barcelona, he juggles work with his studies as he aims to get his master's degree. He then meets Mia (Kathryn Bernardo), a girl who sees Spain as a fresh start. After a series of mistakes in the past, she abruptly uproots herself from life in the Philippines to move forward and start anew. But the question is how? Together, they will go on a journey to find the answers to their lifelong questions, such as proving their worth, confronting the past, finding their way and allowing self-forgiveness.",
        "Dave, a dealer for Guitar Hero, and Ronnie, a stay-at-home mom, are a typical couple raising two young children in the suburbs of Chicago. They experience various stresses including redecorating their house and raising their kids. Joey and Lucy are high school sweethearts with a smart but naive teenage daughter named Lacey. Their relationship is on the rocks and they are even considering a divorce once Lacey goes off to college. Jason and Cynthia are a neurotic couple who've experienced multiple failed attempts to conceive, and Shane, recently divorced from his wife, has a much younger twenty-year-old girlfriend, Trudy."};
    String years[] = {"2013", "2011", "2017", "2020", "2019", "1994", "1999", "2001", "1991", "1990", "2005", "2010", "2019", "2019", "2020", "2016", "2017", "2018", "2018", "1989", "2019", "2018", "2019", "2002", "1994"};
    Image images[] = new Image[25];
    ImageView pics[] = new ImageView[25];
    public static int passData = 0, search_Data = 0, date1 = 0, date2 = 0;
    public static String emailfield = "", numberfield = "", passwordfield = "", passwordfield2 = "", str_day, hdr_day;
    private static String H = "H", S = "S", Scheck_movie, Hcheck_movie, H_R = "H_R", S_R = "S_R", Scheck_R_movie, Hcheck_R_movie;
    private static boolean check_movie = false, check_movie2 = false, check_movie3 = false, check_movie4 = false, S_show = false, H_show = false, S_R_show = false, H_R_show = false, search_data_check = false;
    DecimalFormat decimal = new DecimalFormat("0.00");
    //scene
    Scene scene;
    BorderPane root = new BorderPane();
    StackPane searchBar = new StackPane(), main = new StackPane();
    StackPane mProfile = new StackPane(), mHistory = new StackPane(), mlogn_out = new StackPane(), mA = new StackPane(), mC = new StackPane(), mD = new StackPane(), mH = new StackPane(), mR = new StackPane();
    StackPane menu1 = new StackPane(), mProfile1 = new StackPane(), mHistory1 = new StackPane(), mlogn_out1 = new StackPane(), mC1 = new StackPane(), mD1 = new StackPane(), mH1 = new StackPane(), mR1 = new StackPane();
    StackPane menu2 = new StackPane(), mProfile2 = new StackPane(), mHistory2 = new StackPane(), mlogn_out2 = new StackPane(), mA2 = new StackPane(), mD2 = new StackPane(), mH2 = new StackPane(), mR2 = new StackPane();
    StackPane menu3 = new StackPane(), mProfile3 = new StackPane(), mHistory3 = new StackPane(), mlogn_out3 = new StackPane(), mA3 = new StackPane(), mC3 = new StackPane(), mH3 = new StackPane(), mR3 = new StackPane();
    StackPane menu4 = new StackPane(), mProfile4 = new StackPane(), mHistory4 = new StackPane(), mlogn_out4 = new StackPane(), mA4 = new StackPane(), mC4 = new StackPane(), mD4 = new StackPane(), mR4 = new StackPane();
    StackPane menu5 = new StackPane(), mProfile5 = new StackPane(), mHistory5 = new StackPane(), mlogn_out5 = new StackPane(), mA5 = new StackPane(), mC5 = new StackPane(), mD5 = new StackPane(), mH5 = new StackPane();
    StackPane menu6 = new StackPane(), mHistory6 = new StackPane(), mlogn_out6 = new StackPane(), mA6 = new StackPane(), mC6 = new StackPane(), mD6 = new StackPane(), mH6 = new StackPane(), mR6 = new StackPane();
    StackPane menu7 = new StackPane(), mProfile7 = new StackPane(), mlogn_out7 = new StackPane(), mA7 = new StackPane(), mC7 = new StackPane(), mD7 = new StackPane(), mH7 = new StackPane(), mR7 = new StackPane();
    StackPane menu8 = new StackPane(), mProfile8 = new StackPane(), mHistory8 = new StackPane(), mlogn_out8 = new StackPane(), mA8 = new StackPane(), mC8 = new StackPane(), mD8 = new StackPane(), mH8 = new StackPane(), mR8 = new StackPane();
    StackPane movie_0 = new StackPane(), movie_1 = new StackPane(), movie_2 = new StackPane(), movie_3 = new StackPane(), movie_4 = new StackPane();
    StackPane movie_5 = new StackPane(), movie_6 = new StackPane(), movie_7 = new StackPane(), movie_8 = new StackPane(), movie_9 = new StackPane();
    StackPane movie_10 = new StackPane(), movie_11 = new StackPane(), movie_12 = new StackPane(), movie_13 = new StackPane(), movie_14 = new StackPane();
    StackPane movie_15 = new StackPane(), movie_16 = new StackPane(), movie_17 = new StackPane(), movie_18 = new StackPane(), movie_19 = new StackPane();
    StackPane movie_20 = new StackPane(), movie_21 = new StackPane(), movie_22 = new StackPane(), movie_23 = new StackPane(), movie_24 = new StackPane();
    HBox sHBox2 = new HBox(), sHBox3 = new HBox(), sHBox = new HBox(), rowSearch = new HBox();
    VBox sVBox2 = new VBox(), sVBox3 = new VBox();
    //text
    Text Logoname = new Text("Movie "), ActionName = new Text("              " + MovieType[0]), ComedyName = new Text("  " + MovieType[1]), DramaName = new Text(MovieType[2]), HorrorName = new Text(MovieType[3]), RomaticName = new Text("               " + MovieType[4] + "\n"), ProfileName = new Text("Profile"), HistoryName = new Text("              History\n"), lognOut = new Text("Logn Out   ->]"), back = new Text("<Back"), line = new Text("━━━━━━━━━━━"), line2 = new Text("━━━━━━━━━━━"), line3 = new Text("━━━━━━━━━━━");
    TextField searchText = new TextField();
    TextArea receipt_area_show = new TextArea();
    //button
    Button standard = new Button(), HD = new Button(), Rentstandard = new Button(), RentHD = new Button(), update = new Button(), reload = new Button(), memberchange = new Button(), play = new Button();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        SecondPage();
        Logoname.setOnMouseEntered(b -> {
            Logoname.setFill(Color.FORESTGREEN);
        });
        Logoname.setOnMouseExited(b -> {
            Logoname.setFill(Color.YELLOWGREEN);
        });

        ActionName.setOnMouseEntered(b -> {
            ActionName.setFill(Color.FORESTGREEN);
        });
        ActionName.setOnMouseExited(b -> {
            ActionName.setFill(Color.YELLOWGREEN);
        });
        ComedyName.setOnMouseEntered(b -> {
            ComedyName.setFill(Color.FORESTGREEN);
        });
        ComedyName.setOnMouseExited(b -> {
            ComedyName.setFill(Color.YELLOWGREEN);
        });
        DramaName.setOnMouseEntered(b -> {
            DramaName.setFill(Color.FORESTGREEN);
        });
        DramaName.setOnMouseExited(b -> {
            DramaName.setFill(Color.YELLOWGREEN);
        });
        HorrorName.setOnMouseEntered(b -> {
            HorrorName.setFill(Color.FORESTGREEN);
        });
        HorrorName.setOnMouseExited(b -> {
            HorrorName.setFill(Color.YELLOWGREEN);
        });
        RomaticName.setOnMouseEntered(b -> {
            RomaticName.setFill(Color.FORESTGREEN);
        });
        RomaticName.setOnMouseExited(b -> {
            RomaticName.setFill(Color.YELLOWGREEN);
        });
        ProfileName.setOnMouseEntered(b -> {
            ProfileName.setFill(Color.FORESTGREEN);
        });
        ProfileName.setOnMouseExited(b -> {
            ProfileName.setFill(Color.YELLOWGREEN);
        });
        HistoryName.setOnMouseEntered(b -> {
            HistoryName.setFill(Color.FORESTGREEN);
        });
        HistoryName.setOnMouseExited(b -> {
            HistoryName.setFill(Color.YELLOWGREEN);
        });
        lognOut.setOnMouseEntered(b -> {
            lognOut.setFill(Color.FORESTGREEN);
        });
        lognOut.setOnMouseExited(b -> {
            lognOut.setFill(Color.YELLOWGREEN);
        });
        mA.setOnMouseClicked(b -> {
            receipt_area_show.setText(null);
            ActionPage();
        });
        mC.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ComedyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ComedyPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mD.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                receipt_area_show.setText(null);
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                DramaPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                DramaPage();
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mH.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                receipt_area_show.setText(null);
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mR.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                receipt_area_show.setText(null);
                RomaticPage();
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;

            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                RomaticPage();
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mProfile.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                receipt_area_show.setText(null);
                profilePage();
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                profilePage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mHistory.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                date1 = 0;
                date2 = 0;
            }
        });

        menu1.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                SecondPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                SecondPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mC1.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ComedyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ComedyPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mD1.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                DramaPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                DramaPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mH1.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                HorrorPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mR1.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                RomaticPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                RomaticPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mProfile1.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                profilePage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                profilePage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mHistory1.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                date1 = 0;
                date2 = 0;
            }
        });
        menu2.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                SecondPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                SecondPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mA2.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ActionPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ActionPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mD2.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                DramaPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                DramaPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mH2.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                HorrorPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mR2.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                RomaticPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                RomaticPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mProfile2.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                profilePage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                profilePage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mHistory2.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                date1 = 0;
                date2 = 0;
            }
        });
        menu3.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                SecondPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                SecondPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mA3.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ActionPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ActionPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mC3.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ComedyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ComedyPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mH3.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                HorrorPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mR3.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                RomaticPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                RomaticPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mProfile3.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                profilePage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                profilePage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mHistory3.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                date1 = 0;
                date2 = 0;
            }
        });
        menu4.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                SecondPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                SecondPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mA4.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ActionPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ActionPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mC4.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ComedyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ComedyPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mD4.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                DramaPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                DramaPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mR4.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                RomaticPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                RomaticPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mProfile4.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                profilePage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                profilePage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mHistory4.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                date1 = 0;
                date2 = 0;
            }
        });
        menu5.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                SecondPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                SecondPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mA5.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ActionPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ActionPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mC5.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ComedyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ComedyPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mD5.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                DramaPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                DramaPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mH5.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                HorrorPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mProfile5.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                profilePage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                profilePage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mHistory5.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                historyPage();
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                date1 = 0;
                date2 = 0;
            }
        });
        menu6.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                SecondPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                SecondPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mA6.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ActionPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ActionPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mC6.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ComedyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ComedyPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mD6.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                DramaPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                DramaPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mH6.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                HorrorPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mR6.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                RomaticPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                RomaticPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mHistory6.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                historyPage();
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                date1 = 0;
                date2 = 0;
            }
        });
        menu7.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                SecondPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                SecondPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mA7.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ActionPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ActionPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mC7.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ComedyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ComedyPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mD7.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                DramaPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                DramaPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mH7.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                HorrorPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mR7.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                RomaticPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                RomaticPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mProfile7.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                profilePage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                profilePage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        menu8.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                SecondPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                SecondPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mA8.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ActionPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ActionPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mC8.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                ComedyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                ComedyPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mD8.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                DramaPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                DramaPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mH8.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                HorrorPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                HorrorPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mR8.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                RomaticPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                RomaticPage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mProfile8.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                receipt_area_show.setText(null);
                profilePage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                profilePage();
                receipt_area_show.setText(null);
                date1 = 0;
                date2 = 0;
            }
        });
        mHistory8.setOnMouseClicked(b -> {
            if (Movies.people.getMember() == 1) {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                memberchange.setVisible(false);
                date1 = 0;
                date2 = 0;
            } else {
                S_show = false;
                H_show = false;
                S_R_show = false;
                H_R_show = false;
                check_movie = false;
                check_movie2 = false;
                check_movie3 = false;
                check_movie4 = false;
                historyPage();
                date1 = 0;
                date2 = 0;
            }
        }
        );
        searchText.setOnKeyPressed(b
                -> {
            String s = searchText.getText();
            System.out.println(s);
            switch (b.getCode()) {
                case ENTER:
                    if (s.equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Some Word !", "Warning !", JOptionPane.WARNING_MESSAGE);
                    } else {
                        String w = s.toUpperCase();
                        for (int n = 0; n < MovieName.length; n++) {
                            if (MovieName[n] != null) {
                                if (w.equals(MovieName[n].toUpperCase())) {
                                    search_data_check = false;
                                    search_Data = n;
                                    searchText.setText(null);
                                    break;
                                } else {
                                    search_data_check = true;
                                    searchText.setText(null);
                                }
                            } else {
                                break;
                            }
                        }
                        if (search_data_check == false) {
                            Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("Movies Found");
                            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                            Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
                            dialogStage.getIcons().add(ApplicationIcon);
                            VBox search_movie_detail = new VBox();
                            search_movie_detail.setSpacing(20);
                            images[search_Data] = new Image(imageData[search_Data]);
                            pics[search_Data] = new ImageView(images[search_Data]);
                            Text aSearch = new Text(MovieName[search_Data]);
                            aSearch.setFont(Font.font("Segoe UI Semibold", 15));
                            search_movie_detail.getChildren().addAll(pics[search_Data], aSearch);
                            pics[search_Data].setFitWidth(400);
                            pics[search_Data].setFitHeight(250);
                            pics[search_Data].setPreserveRatio(true);

                            VBox content = new VBox();
                            content.setAlignment(Pos.CENTER_LEFT);
                            content.setSpacing(10);
                            content.getChildren().addAll(new Label("Found"), search_movie_detail);
                            dialog.getDialogPane().setContent(content);
                            dialog.setResultConverter(dialogButton -> {
                                if (dialogButton == ButtonType.OK) {
                                    return "movie_datail";
                                }
                                return null;
                            });

                            Optional<String> search_movie = dialog.showAndWait();
                            if (search_movie.isPresent()) {
                                String moviename = search_movie.get();
                                if (moviename.equals("movie_datail")) {
                                    passData = search_Data;
                                    Scheck_movie = S + passData;
                                    File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
                                    Hcheck_movie = H + passData;
                                    File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
                                    Scheck_R_movie = S_R + passData;
                                    File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
                                    Hcheck_R_movie = H_R + passData;
                                    File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
                                    Information();
                                    if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                                        check_movie = true;
                                        check_movie2 = true;
                                        check_movie3 = true;
                                        check_movie4 = true;
                                        S_show = true;
                                        H_show = true;
                                        HD.setText("Own");
                                        HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        S_R_show = true;
                                        H_R_show = true;
                                        play.setVisible(true);
                                    } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                                        check_movie = true;
                                        check_movie2 = true;
                                        check_movie3 = true;
                                        S_show = true;
                                        H_show = true;
                                        HD.setText("Own");
                                        HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        S_R_show = true;
                                        play.setVisible(true);
                                    } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                                        check_movie = true;
                                        check_movie2 = true;
                                        check_movie4 = true;
                                        S_show = true;
                                        H_show = true;
                                        HD.setText("Own");
                                        HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        H_R_show = true;
                                        play.setVisible(true);
                                    } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                                        S_R_show = true;
                                        H_R_show = true;
                                        check_movie = true;
                                        check_movie3 = true;
                                        check_movie4 = true;
                                        S_show = true;
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                                        H_R_show = true;
                                        check_movie2 = true;
                                        check_movie3 = true;
                                        check_movie4 = true;
                                        S_show = true;
                                        H_show = true;
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    } else if (Standard.exists() == true && Standard_R.exists()) {
                                        S_R_show = true;
                                        check_movie = true;
                                        check_movie3 = true;
                                        S_show = true;
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    } else if (High.exists() == true && High_R.exists() == true) {
                                        H_R_show = true;
                                        check_movie2 = true;
                                        check_movie4 = true;
                                        H_show = true;
                                        HD.setText("Own");
                                        HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    } else if (Standard.exists() == true && High_R.exists() == true) {
                                        H_R_show = true;
                                        check_movie = true;
                                        check_movie4 = true;
                                        S_show = true;
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    } else if (High.exists() == true && Standard_R.exists() == true) {
                                        S_R_show = true;
                                        check_movie2 = true;
                                        check_movie3 = true;
                                        H_show = true;
                                        HD.setText("Own");
                                        HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    } else if (Standard_R.exists() == true && High_R.exists() == true) {
                                        S_R_show = true;
                                        H_R_show = true;
                                        check_movie3 = true;
                                        check_movie4 = true;
                                        play.setVisible(true);
                                    } else if (Standard.exists() == true && High.exists() == true) {
                                        check_movie = true;
                                        check_movie2 = true;
                                        S_show = true;
                                        H_show = true;
                                        HD.setText("Own");
                                        HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    } else if (Standard_R.exists() == true) {
                                        S_R_show = true;
                                        check_movie3 = true;
                                        play.setVisible(true);
                                    } else if (High_R.exists() == true) {
                                        H_R_show = true;
                                        check_movie4 = true;
                                        play.setVisible(true);
                                    } else if (Standard.exists() == true) {
                                        check_movie = true;
                                        S_show = true;
                                        standard.setText("Own");
                                        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    } else if (High.exists() == true) {
                                        check_movie2 = true;
                                        H_show = true;
                                        HD.setText("Own");
                                        HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                                        play.setVisible(true);
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Not Found", "Information !", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;
            }
        }
        );
        scene = new Scene(root);

        scene.getStylesheets()
                .add("file:resources/scoller.css");
        primaryStage.setTitle(
                "Movies");
        primaryStage.getIcons()
                .add(new javafx.scene.image.Image("file:resources/small.png"));
        primaryStage.setScene(scene);

        primaryStage.setMaxHeight(
                800);
        primaryStage.setMaxWidth(
                1000);
        primaryStage.show();

        lognOut.setOnMouseClicked(b
                -> {
            int out = JOptionPane.showConfirmDialog(null, "Conform Exit?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
            if (out == 0) {
                Movies menu = new Movies();
                menu.start(new Stage());
                ((Node) b.getSource()).getScene().getWindow().hide();
            }
        }
        );
        back.setOnMouseEntered(b
                -> {
            back.setFill(Color.YELLOWGREEN);
        }
        );
        back.setOnMouseExited(b
                -> {
            back.setFill(Color.DARKGREEN);
        }
        );
        standard.setOnMouseEntered(c
                -> {
            standard.setStyle("-fx-background-color: #94b447");
            standard.setEffect(new DropShadow());
        }
        );
        standard.setOnMouseExited(c
                -> {
            standard.setEffect(null);
            standard.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        }
        );
        HD.setOnMouseEntered(c
                -> {
            HD.setStyle("-fx-background-color: #94b447");
            HD.setEffect(new DropShadow());
        }
        );
        HD.setOnMouseExited(c
                -> {
            HD.setEffect(null);
            HD.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        }
        );
        Rentstandard.setOnMouseEntered(c
                -> {
            Rentstandard.setStyle("-fx-background-color: #94b447");
            Rentstandard.setEffect(new DropShadow());
        }
        );
        Rentstandard.setOnMouseExited(c
                -> {
            Rentstandard.setEffect(null);
            Rentstandard.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        }
        );
        RentHD.setOnMouseEntered(c
                -> {
            RentHD.setStyle("-fx-background-color: #94b447");
            RentHD.setEffect(new DropShadow());
        }
        );
        RentHD.setOnMouseExited(c
                -> {
            RentHD.setEffect(null);
            RentHD.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        }
        );
        play.setOnMouseEntered(c
                -> {
            play.setStyle("-fx-background-color: #94b447");
            play.setEffect(new DropShadow());
        }
        );
        play.setOnMouseExited(c
                -> {
            play.setEffect(null);
            play.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        }
        );
        play.setOnAction(c
                -> {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Movies ");
            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
            dialogStage.getIcons().add(ApplicationIcon);
            VBox selction = new VBox();
            try {
                Scheck_R_movie = S_R + passData;
                File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
                Scanner c1 = new Scanner(Standard_R);
                date1 = c1.nextInt();
                c1.close();
            } catch (Exception e) {
            }
            try {
                Hcheck_R_movie = H_R + passData;
                File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
                Scanner c2 = new Scanner(High_R);
                date2 = c2.nextInt();
                c2.close();
            } catch (Exception e) {
            }
            ToggleGroup movieSelect = new ToggleGroup();
            RadioButton S = new RadioButton("Standard Movie -type : Buy");
            RadioButton H = new RadioButton("Hight defination Movie -type : Buy");
            RadioButton S_R = new RadioButton("Standard Movie -type : Rent " + date1 + " Days");
            RadioButton H_R = new RadioButton("Hight defination Movie -type : Rent " + date2 + " Days");

            S.setToggleGroup(movieSelect);
            H.setToggleGroup(movieSelect);
            S_R.setToggleGroup(movieSelect);
            H_R.setToggleGroup(movieSelect);
            S.setVisible(false);
            H.setVisible(false);
            S_R.setVisible(false);
            H_R.setVisible(false);
            if (S_show == true && H_show == true && S_R_show == true && H_R_show == true) {
                H_R.setVisible(true);
                S_R.setVisible(true);
                S.setVisible(true);
                H.setVisible(true);
            } else if (S_show == true && H_R_show == true && S_R_show == true) {
                H_R.setVisible(true);
                S_R.setVisible(true);
                S.setVisible(true);
            } else if (H_show == true && H_R_show == true && S_R_show == true) {
                H.setVisible(true);
                H_R.setVisible(true);
                S_R.setVisible(true);
            } else if (H_show == true && S_show == true && S_R_show == true) {
                S.setVisible(true);
                S_R.setVisible(true);
                H.setVisible(true);
            } else if (H_show == true && S_show == true && H_R_show == true) {
                S.setVisible(true);
                H.setVisible(true);
                H_R.setVisible(true);
            } else if (H_show == true && S_show == true) {
                S.setVisible(true);
                H.setVisible(true);
            } else if (H_show == true && S_R_show == true) {
                H.setVisible(true);
                S_R.setVisible(true);
            } else if (H_show == true && H_R_show == true) {
                H.setVisible(true);
                H_R.setVisible(true);
            } else if (S_show == true && S_R_show == true) {
                S.setVisible(true);
                S_R.setVisible(true);
            } else if (S_show == true && H_R_show == true) {
                S.setVisible(true);
                H_R.setVisible(true);
            } else if (S_R_show == true && H_R_show == true) {
                S_R.setVisible(true);
                H_R.setVisible(true);
            } else if (S_show == true) {
                S.setVisible(true);
            } else if (H_show == true) {
                H.setVisible(true);
            } else if (S_R_show == true) {
                S_R.setVisible(true);
            } else if (H_R_show == true) {
                H_R.setVisible(true);
            }

            selction.getChildren().addAll(S, H, S_R, H_R);
            selction.setSpacing(20);
            Line line = new Line();
            line.setStartX(250);
            VBox content = new VBox();
            content.setAlignment(Pos.CENTER_LEFT);
            content.setSpacing(10);
            content.getChildren().addAll(new Label("Select Your Movie"), line, selction);
            dialog.getDialogPane().setContent(content);
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == ButtonType.CANCEL) {
                    return "cancel";
                } else if (S.isSelected()) {
                    return "movie_Watch";
                } else if (H.isSelected()) {
                    return "movie_Watch";
                } else if (S_R.isSelected()) {
                    return "movie_Watch";
                } else if (H_R.isSelected()) {
                    return "movie_Watch";
                } else if (!S.isSelected()) {
                    return "fail";
                } else if (!H.isSelected()) {
                    return "fail";
                } else if (!S_R.isSelected()) {
                    return "fail";
                } else if (!H_R.isSelected()) {
                    return "fail";
                } else {
                    return null;
                }
            });

            String moviename = "";
            Optional<String> movie = dialog.showAndWait();
            if (movie.isPresent()) {
                moviename = movie.get();
            }
            if (moviename.equals("movie_Watch")) {
                try {
                    Vieo_Player vieo_player = new Vieo_Player();
                    vieo_player.start(new Stage());
                } catch (Exception e) {
                }
            } else if (moviename.equals("cancel")) {
                JOptionPane.showMessageDialog(null, "Cancel Succesful", "Information !", JOptionPane.INFORMATION_MESSAGE);
            } else if (moviename.equals("fail")) {
                JOptionPane.showMessageDialog(null, "Process Fail", "Information !", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        );
        movie_0.setOnMouseClicked(c
                -> {
            passData = 0;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_1.setOnMouseClicked(c
                -> {
            passData = 1;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");

            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_2.setOnMouseClicked(c
                -> {
            passData = 2;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_3.setOnMouseClicked(c
                -> {
            passData = 3;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_4.setOnMouseClicked(c
                -> {
            passData = 4;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_5.setOnMouseClicked(c
                -> {
            passData = 5;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_6.setOnMouseClicked(c
                -> {
            passData = 6;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_7.setOnMouseClicked(c
                -> {
            passData = 7;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_8.setOnMouseClicked(c
                -> {
            passData = 8;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_9.setOnMouseClicked(c
                -> {
            passData = 9;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_10.setOnMouseClicked(c
                -> {
            passData = 10;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_11.setOnMouseClicked(c
                -> {
            passData = 11;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_12.setOnMouseClicked(c
                -> {
            passData = 12;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_13.setOnMouseClicked(c
                -> {
            passData = 13;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_14.setOnMouseClicked(c
                -> {
            passData = 14;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_15.setOnMouseClicked(c
                -> {
            passData = 15;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_16.setOnMouseClicked(c
                -> {
            passData = 16;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_17.setOnMouseClicked(c
                -> {
            passData = 17;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_18.setOnMouseClicked(c
                -> {
            passData = 18;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_19.setOnMouseClicked(c
                -> {
            passData = 19;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_20.setOnMouseClicked(c
                -> {
            passData = 20;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_21.setOnMouseClicked(c
                -> {
            passData = 21;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_22.setOnMouseClicked(c
                -> {
            passData = 22;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_23.setOnMouseClicked(c
                -> {
            passData = 23;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        movie_24.setOnMouseClicked(c
                -> {
            passData = 24;
            Scheck_movie = S + passData;
            File Standard = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_movie + ".txt");
            Hcheck_movie = H + passData;
            File High = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_movie + ".txt");
            Scheck_R_movie = S_R + passData;
            File Standard_R = new File("database/movie/" + Movies.people.getName() + "/" + Scheck_R_movie + ".txt");
            Hcheck_R_movie = H_R + passData;
            File High_R = new File("database/movie/" + Movies.people.getName() + "/" + Hcheck_R_movie + ".txt");
            Information();
            if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && Standard_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie3 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                S_R_show = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true && High_R.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                H_R_show = true;
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && Standard.exists()) {
                S_R_show = true;
                H_R_show = true;
                check_movie = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true && High.exists()) {
                H_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                check_movie4 = true;
                S_show = true;
                H_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && Standard_R.exists()) {
                S_R_show = true;
                check_movie = true;
                check_movie3 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie2 = true;
                check_movie4 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard.exists() == true && High_R.exists() == true) {
                H_R_show = true;
                check_movie = true;
                check_movie4 = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true && Standard_R.exists() == true) {
                S_R_show = true;
                check_movie2 = true;
                check_movie3 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true && High_R.exists() == true) {
                S_R_show = true;
                H_R_show = true;
                check_movie3 = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true && High.exists() == true) {
                check_movie = true;
                check_movie2 = true;
                S_show = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (Standard_R.exists() == true) {
                S_R_show = true;
                check_movie3 = true;
                play.setVisible(true);
            } else if (High_R.exists() == true) {
                H_R_show = true;
                check_movie4 = true;
                play.setVisible(true);
            } else if (Standard.exists() == true) {
                check_movie = true;
                S_show = true;
                standard.setText("Own");
                standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            } else if (High.exists() == true) {
                check_movie2 = true;
                H_show = true;
                HD.setText("Own");
                HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
                play.setVisible(true);
            }
        }
        );
        back.setOnMouseClicked(c
                -> {
            passData = 0;
            SecondPage();
            movie = null;
            date1 = 0;
            date2 = 0;
            check_movie = false;
            check_movie2 = false;
            check_movie3 = false;
            check_movie4 = false;
            S_show = false;
            H_show = false;
            S_R_show = false;
            H_R_show = false;
        }
        );
        standard.setOnAction(d
                -> {
            if (check_movie == true) {
                JOptionPane.showMessageDialog(null, "Go To Play Button To Watch Movie", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else if (check_movie == false) {
                if (Movies.people.getAmount() == 0) {
                    JOptionPane.showMessageDialog(null, "Your Amount Have No Money", "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did You Want To Reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("Movies");
                        dialog.setHeaderText("Secure Authentication");
                        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
                        dialogStage.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd);
                        dialog.getDialogPane().setContent(content);
                        dialog.setResultConverter(dialogButton -> {
                            if (dialogButton == ButtonType.OK) {
                                return pwd.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck = "";
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            passwordcheck = result.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            Dialog<String> dialog2 = new Dialog<>();
                            dialog2.setTitle("Movies Payment");
                            dialog2.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                            Stage dialogStage2 = (Stage) dialog2.getDialogPane().getScene().getWindow();
                            dialogStage2.getIcons().add(ApplicationIcon);

                            TextField cash1 = new TextField();
                            HBox content2 = new HBox();
                            content2.setAlignment(Pos.CENTER_LEFT);
                            content2.setSpacing(10);
                            content2.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash1);
                            dialog2.getDialogPane().setContent(content2);
                            dialog2.setResultConverter(dialogButton2 -> {
                                if (dialogButton2 == ButtonType.OK) {
                                    return cash1.getText();
                                }
                                return null;
                            });
                            String ok = "";
                            double amount = 0;
                            Optional<String> reload_money = dialog2.showAndWait();
                            if (reload_money.isPresent()) {
                                amount = new Double(reload_money.get());
                            } else {
                                ok = "ok";
                            }
                            double first = Movies.people.getAmount();
                            try {
                                if (amount <= -1 || amount <= 0 || amount >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Fail", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(amount);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload successfully", "Congrats !", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, amount);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount + "\nAmount left " + amount + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {

                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {

                    }
                } else if (Movies.people.getAmount() < rent_price[passData]) {
                    JOptionPane.showMessageDialog(null, "Not enough money\nYour amount left " + Movies.people.getAmount(), "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog3 = new Dialog<>();
                        dialog3.setTitle("Movies");
                        dialog3.setHeaderText("Secure Authentication");
                        dialog3.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage3 = (Stage) dialog3.getDialogPane().getScene().getWindow();
                        dialogStage3.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog3.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd3 = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd3);
                        dialog3.getDialogPane().setContent(content);
                        dialog3.setResultConverter(dialogButton3 -> {
                            if (dialogButton3 == ButtonType.OK) {
                                return pwd3.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck3 = "";
                        Optional<String> result3 = dialog3.showAndWait();
                        if (result3.isPresent()) {
                            passwordcheck3 = result3.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            Dialog<String> dialog4 = new Dialog<>();
                            dialog4.setTitle("Movies Payment");
                            dialog4.setHeaderText(" ");
                            dialog4.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                            Stage dialogStage4 = (Stage) dialog4.getDialogPane().getScene().getWindow();
                            dialogStage4.getIcons().add(ApplicationIcon);

                            TextField cash2 = new TextField();
                            HBox content4 = new HBox();
                            content4.setAlignment(Pos.CENTER_LEFT);
                            content4.setSpacing(10);
                            content4.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash2);
                            dialog4.getDialogPane().setContent(content4);
                            dialog4.setResultConverter(dialogButton4 -> {
                                if (dialogButton4 == ButtonType.OK) {
                                    return cash2.getText();
                                }
                                return null;
                            });
                            String ok = "";
                            double amount2 = 0;
                            Optional<String> reload_money2 = dialog4.showAndWait();
                            if (reload_money2.isPresent()) {
                                amount2 = new Double(reload_money2.get());
                            } else {
                                ok = "not ok";
                            }
                            double first = Movies.people.getAmount();
                            Double left_money = new Double(Movies.people.getAmount());
                            Double final_money = amount2 + left_money;
                            try {
                                if (amount2 <= -1 || amount2 <= 0 || amount2 >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("not ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt                                                                                                 
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount2 + "\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                    }
                } else if (Movies.people.getMember() == 2) {
                    JOptionPane.showMessageDialog(null, "You not member yet\nMember have 30% discount", "Inportant Information !", JOptionPane.INFORMATION_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to become member ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog5 = new Dialog<>();
                        dialog5.setTitle("Movies Member");
                        dialog5.setHeaderText("Secure Authentication");
                        dialog5.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage5 = (Stage) dialog5.getDialogPane().getScene().getWindow();
                        dialogStage5.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog5.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd5 = new PasswordField();
                        HBox content5 = new HBox();
                        content5.setAlignment(Pos.CENTER_LEFT);
                        content5.setSpacing(10);
                        content5.getChildren().addAll(new Label("Enter Your Password :"), pwd5);
                        dialog5.getDialogPane().setContent(content5);
                        dialog5.setResultConverter(dialogButton5 -> {
                            if (dialogButton5 == ButtonType.OK) {
                                return pwd5.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck5 = "";
                        Optional<String> result5 = dialog5.showAndWait();
                        if (result5.isPresent()) {
                            passwordcheck5 = result5.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (Movies.people.getAmount() < 15) {
                                JOptionPane.showMessageDialog(null, "Amount Not Enough Money \nPlease Reload First", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int confirm_Member1 = JOptionPane.showConfirmDialog(null, "Did You Want To Become Member?\nYou Be Change MYR15", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                                if (confirm_Member1 == 0) {
                                    double first = Movies.people.getAmount();
                                    double final_money = Movies.people.getAmount() - 15;
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = 1;
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "You Are Member Now", "Congrats", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nMember Fee MYR 15\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else if (!passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        Dialog<String> dialog6 = new Dialog<>();
                        dialog6.setTitle("Movies Payment");
                        dialog6.setHeaderText("Secure Authentication");
                        dialog6.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage6 = (Stage) dialog6.getDialogPane().getScene().getWindow();
                        dialogStage6.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog6.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd6 = new PasswordField();
                        HBox content6 = new HBox();
                        content6.setAlignment(Pos.CENTER_LEFT);
                        content6.setSpacing(10);
                        content6.getChildren().addAll(new Label("Enter Your Password :"), pwd6);
                        dialog6.getDialogPane().setContent(content6);
                        dialog6.setResultConverter(dialogButton6 -> {
                            if (dialogButton6 == ButtonType.OK) {
                                return pwd6.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck6 = "";
                        Optional<String> result6 = dialog6.showAndWait();
                        if (result6.isPresent()) {
                            passwordcheck6 = result6.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {

                            double first_amount = Movies.people.getAmount();
                            int quantity = 1;
                            movie = new buy_movie(passData, quantity, Movies.people.getMember());
                            movie.getMoviePrice();
                            movie.getQuanlityPrice();
                            movie.getMembers();
                            if (Movies.people.getAmount() <= movie.getTotal() || Movies.people.getAmount() == 0) {
                                JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                double final_money = movie.minus(Movies.people.getAmount());
                                try {
                                    String id = Movies.people.getId().trim();
                                    String name = Movies.people.getName().trim();
                                    String email = Movies.people.getEmail().trim();
                                    String phone_number = Movies.people.getPhone_number().trim();
                                    int member = Movies.people.getMember();
                                    String password = Movies.people.getPassword().trim();
                                    String fileName = "database/client/" + name + ".txt";
                                    PrintWriter output = new PrintWriter(fileName);
                                    output.println(id);
                                    output.println(name);
                                    output.println(email);
                                    output.println(phone_number);
                                    output.println(member);
                                    output.println(final_money);
                                    output.println(password);
                                    output.close();
                                    JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                    Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                    try {
                                        String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie.toString() + "\n___________________________________________________________________\n\n";
                                        File secondFile = new File("database/receipt/" + name + ".txt");
                                        FileOutputStream fos = new FileOutputStream(secondFile, true);
                                        fos.write(receipt.getBytes());
                                    } catch (IOException e) {
                                    }
                                    String movie = "database/movie/" + name + "/S" + passData + ".txt";
                                    File moviefile = new File(movie);
                                    moviefile.createNewFile();
                                    historyPage();
                                    check_movie = false;
                                    check_movie2 = false;
                                    S_show = false;
                                    H_show = false;
                                    S_R_show = false;
                                    H_R_show = false;
                                } catch (FileNotFoundException z) {
                                } catch (Exception z) {
                                }
                            }
                        } else if (!passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    }
                } else {
                    Dialog<String> dialog7 = new Dialog<>();
                    dialog7.setTitle("Movies Payment");
                    dialog7.setHeaderText("Secure Authentication");
                    dialog7.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                    Stage dialogStage7 = (Stage) dialog7.getDialogPane().getScene().getWindow();
                    dialogStage7.getIcons().add(ApplicationIcon);

                    DIALOG_HEADER_ICON.setFitHeight(48);
                    DIALOG_HEADER_ICON.setFitWidth(48);
                    dialog7.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                    PasswordField pwd7 = new PasswordField();
                    HBox content7 = new HBox();
                    content7.setAlignment(Pos.CENTER_LEFT);
                    content7.setSpacing(10);
                    content7.getChildren().addAll(new Label("Enter Your Password :"), pwd7);
                    dialog7.getDialogPane().setContent(content7);
                    dialog7.setResultConverter(dialogButton6 -> {
                        if (dialogButton6 == ButtonType.OK) {
                            return pwd7.getText();
                        }
                        return null;
                    });
                    String nothing = "no";
                    String passwordcheck7 = "";
                    Optional<String> result7 = dialog7.showAndWait();
                    if (result7.isPresent()) {
                        passwordcheck7 = result7.get();
                    } else {
                        nothing = "yes";
                    }
                    if (passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                        double first_amount = Movies.people.getAmount();
                        int quantity = 1;
                        movie = new buy_movie(passData, quantity, Movies.people.getMember());
                        movie.getMoviePrice();
                        movie.getQuanlityPrice();
                        movie.getMembers();
                        if (Movies.people.getAmount() > movie.getTotal()) {
                            double final_money = movie.minus(Movies.people.getAmount());
                            try {
                                String id = Movies.people.getId().trim();
                                String name = Movies.people.getName().trim();
                                String email = Movies.people.getEmail().trim();
                                String phone_number = Movies.people.getPhone_number().trim();
                                int member = Movies.people.getMember();
                                String password = Movies.people.getPassword().trim();
                                String fileName = "database/client/" + name + ".txt";
                                PrintWriter output = new PrintWriter(fileName);
                                output.println(id);
                                output.println(name);
                                output.println(email);
                                output.println(phone_number);
                                output.println(member);
                                output.println(final_money);
                                output.println(password);
                                output.close();
                                JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                //Receipt
                                try {
                                    String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie.toString() + "\n___________________________________________________________________\n\n";
                                    File secondFile = new File("database/receipt/" + name + ".txt");
                                    FileOutputStream fos = new FileOutputStream(secondFile, true);
                                    fos.write(receipt.getBytes());
                                } catch (IOException e) {
                                }
                                String movie = "database/movie/" + name + "/S" + passData + ".txt";
                                File moviefile = new File(movie);
                                moviefile.createNewFile();
                                historyPage();
                                check_movie = false;
                                check_movie2 = false;
                                S_show = false;
                                H_show = false;
                                S_R_show = false;
                                H_R_show = false;
                            } catch (FileNotFoundException z) {
                            } catch (Exception z) {
                            }
                        }
                    } else if (!passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                        if (nothing.equals("yes")) {
                            JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        }
        );
        HD.setOnAction(d
                -> {
            if (check_movie2 == true) {
                JOptionPane.showMessageDialog(null, "Go To Play Button To Watch Movie", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else if (check_movie2 == false) {
                if (Movies.people.getAmount() == 0) {
                    JOptionPane.showMessageDialog(null, "Your Amount Have No Money", "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did You Want To Reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("Movies");
                        dialog.setHeaderText("Secure Authentication");
                        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
                        dialogStage.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd);
                        dialog.getDialogPane().setContent(content);
                        dialog.setResultConverter(dialogButton -> {
                            if (dialogButton == ButtonType.OK) {
                                return pwd.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck = "";
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            passwordcheck = result.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog2 = new Dialog<>();
                                dialog2.setTitle("Movies Payment");
                                dialog2.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage2 = (Stage) dialog2.getDialogPane().getScene().getWindow();
                                dialogStage2.getIcons().add(ApplicationIcon);

                                TextField cash1 = new TextField();
                                HBox content2 = new HBox();
                                content2.setAlignment(Pos.CENTER_LEFT);
                                content2.setSpacing(10);
                                content2.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash1);
                                dialog2.getDialogPane().setContent(content2);
                                dialog2.setResultConverter(dialogButton2 -> {
                                    if (dialogButton2 == ButtonType.OK) {
                                        return cash1.getText();
                                    }
                                    return null;
                                });
                                String ok = "";
                                double amount = 0;
                                Optional<String> reload_money = dialog2.showAndWait();
                                if (reload_money.isPresent()) {
                                    amount = new Double(reload_money.get());
                                } else {
                                    ok = "ok";
                                }
                                double first = Movies.people.getAmount();

                                if (amount <= -1 || amount <= 0 || amount >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Fail", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(amount);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload successfully", "Congrats !", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, amount);
                                        //Receipt                               
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount + "\nAmount left " + amount + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {

                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {

                    }
                } else if (Movies.people.getAmount() < rent_price[passData]) {
                    JOptionPane.showMessageDialog(null, "Not enough money\nYour amount left " + Movies.people.getAmount(), "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog3 = new Dialog<>();
                        dialog3.setTitle("Movies");
                        dialog3.setHeaderText("Secure Authentication");
                        dialog3.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage3 = (Stage) dialog3.getDialogPane().getScene().getWindow();
                        dialogStage3.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog3.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd3 = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd3);
                        dialog3.getDialogPane().setContent(content);
                        dialog3.setResultConverter(dialogButton3 -> {
                            if (dialogButton3 == ButtonType.OK) {
                                return pwd3.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck3 = "";
                        Optional<String> result3 = dialog3.showAndWait();
                        if (result3.isPresent()) {
                            passwordcheck3 = result3.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            Dialog<String> dialog4 = new Dialog<>();
                            dialog4.setTitle("Movies Payment");
                            dialog4.setHeaderText(" ");
                            dialog4.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                            Stage dialogStage4 = (Stage) dialog4.getDialogPane().getScene().getWindow();
                            dialogStage4.getIcons().add(ApplicationIcon);

                            TextField cash2 = new TextField();
                            HBox content4 = new HBox();
                            content4.setAlignment(Pos.CENTER_LEFT);
                            content4.setSpacing(10);
                            content4.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash2);
                            dialog4.getDialogPane().setContent(content4);
                            dialog4.setResultConverter(dialogButton4 -> {
                                if (dialogButton4 == ButtonType.OK) {
                                    return cash2.getText();
                                }
                                return null;
                            });
                            String ok = "";
                            double amount2 = 0;
                            Optional<String> reload_money2 = dialog4.showAndWait();
                            if (reload_money2.isPresent()) {
                                amount2 = new Double(reload_money2.get());
                            } else {
                                ok = "not ok";
                            }
                            double first = Movies.people.getAmount();
                            Double left_money = new Double(Movies.people.getAmount());
                            Double final_money = amount2 + left_money;
                            try {
                                if (amount2 <= -1 || amount2 <= 0 || amount2 >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("not ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount2 + "\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                    }
                } else if (Movies.people.getMember() == 2) {
                    JOptionPane.showMessageDialog(null, "You not member yet\nMember have 30% discount", "Inportant Information !", JOptionPane.INFORMATION_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to become member ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog5 = new Dialog<>();
                        dialog5.setTitle("Movies Member");
                        dialog5.setHeaderText("Secure Authentication");
                        dialog5.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage5 = (Stage) dialog5.getDialogPane().getScene().getWindow();
                        dialogStage5.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog5.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd5 = new PasswordField();
                        HBox content5 = new HBox();
                        content5.setAlignment(Pos.CENTER_LEFT);
                        content5.setSpacing(10);
                        content5.getChildren().addAll(new Label("Enter Your Password :"), pwd5);
                        dialog5.getDialogPane().setContent(content5);
                        dialog5.setResultConverter(dialogButton5 -> {
                            if (dialogButton5 == ButtonType.OK) {
                                return pwd5.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck5 = "";
                        Optional<String> result5 = dialog5.showAndWait();
                        if (result5.isPresent()) {
                            passwordcheck5 = result5.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (Movies.people.getAmount() < 15) {
                                JOptionPane.showMessageDialog(null, "Amount Not Enough Money \nPlease Reload First", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int confirm_Member1 = JOptionPane.showConfirmDialog(null, "Did You Want To Become Member?\nYou Be Change MYR15", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                                if (confirm_Member1 == 0) {
                                    double first = Movies.people.getAmount();
                                    double final_money = Movies.people.getAmount() - 15;
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = 1;
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "You Are Member Now", "Congrats", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nMember Fee MYR 15\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else if (!passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        Dialog<String> dialog6 = new Dialog<>();
                        dialog6.setTitle("Movies Payment");
                        dialog6.setHeaderText("Secure Authentication");
                        dialog6.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage6 = (Stage) dialog6.getDialogPane().getScene().getWindow();
                        dialogStage6.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog6.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd6 = new PasswordField();
                        HBox content6 = new HBox();
                        content6.setAlignment(Pos.CENTER_LEFT);
                        content6.setSpacing(10);
                        content6.getChildren().addAll(new Label("Enter Your Password :"), pwd6);
                        dialog6.getDialogPane().setContent(content6);
                        dialog6.setResultConverter(dialogButton6 -> {
                            if (dialogButton6 == ButtonType.OK) {
                                return pwd6.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck6 = "";
                        Optional<String> result6 = dialog6.showAndWait();
                        if (result6.isPresent()) {
                            passwordcheck6 = result6.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                            double first_amount = Movies.people.getAmount();
                            int quantity = 2;
                            movie = new buy_movie(passData, quantity, Movies.people.getMember());
                            movie.getMoviePrice();
                            movie.getQuanlityPrice();
                            movie.getMembers();
                            if (Movies.people.getAmount() > movie.getTotal()) {
                                double final_money = movie.minus(Movies.people.getAmount());
                                try {
                                    String id = Movies.people.getId().trim();
                                    String name = Movies.people.getName().trim();
                                    String email = Movies.people.getEmail().trim();
                                    String phone_number = Movies.people.getPhone_number().trim();
                                    int member = Movies.people.getMember();
                                    String password = Movies.people.getPassword().trim();
                                    String fileName = "database/client/" + name + ".txt";
                                    PrintWriter output = new PrintWriter(fileName);
                                    output.println(id);
                                    output.println(name);
                                    output.println(email);
                                    output.println(phone_number);
                                    output.println(member);
                                    output.println(final_money);
                                    output.println(password);
                                    output.close();
                                    JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                    Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                    //Receipt                                 
                                    try {
                                        String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie.toString() + "\n___________________________________________________________________\n\n";
                                        File secondFile = new File("database/receipt/" + name + ".txt");
                                        FileOutputStream fos = new FileOutputStream(secondFile, true);
                                        fos.write(receipt.getBytes());
                                    } catch (IOException e) {
                                    }
                                    String movie = "database/movie/" + name + "/H" + passData + ".txt";
                                    File moviefile = new File(movie);
                                    moviefile.createNewFile();
                                    historyPage();
                                    check_movie = false;
                                    check_movie2 = false;
                                    S_show = false;
                                    H_show = false;
                                    S_R_show = false;
                                    H_R_show = false;
                                } catch (FileNotFoundException z) {
                                } catch (Exception z) {
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    }
                } else {
                    Dialog<String> dialog7 = new Dialog<>();
                    dialog7.setTitle("Movies Payment");
                    dialog7.setHeaderText("Secure Authentication");
                    dialog7.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                    Stage dialogStage7 = (Stage) dialog7.getDialogPane().getScene().getWindow();
                    dialogStage7.getIcons().add(ApplicationIcon);

                    DIALOG_HEADER_ICON.setFitHeight(48);
                    DIALOG_HEADER_ICON.setFitWidth(48);
                    dialog7.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                    PasswordField pwd7 = new PasswordField();
                    HBox content7 = new HBox();
                    content7.setAlignment(Pos.CENTER_LEFT);
                    content7.setSpacing(10);
                    content7.getChildren().addAll(new Label("Enter Your Password :"), pwd7);
                    dialog7.getDialogPane().setContent(content7);
                    dialog7.setResultConverter(dialogButton6 -> {
                        if (dialogButton6 == ButtonType.OK) {
                            return pwd7.getText();
                        }
                        return null;
                    });
                    String nothing = "no";
                    String passwordcheck7 = "";
                    Optional<String> result7 = dialog7.showAndWait();
                    if (result7.isPresent()) {
                        passwordcheck7 = result7.get();
                    } else {
                        nothing = "yes";
                    }
                    if (passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                        double first_amount = Movies.people.getAmount();
                        int quantity = 2;
                        movie = new buy_movie(passData, quantity, Movies.people.getMember());
                        movie.getMoviePrice();
                        movie.getQuanlityPrice();
                        movie.getMembers();
                        if (Movies.people.getAmount() > movie.getTotal()) {
                            double final_money = movie.minus(Movies.people.getAmount());
                            try {
                                String id = Movies.people.getId().trim();
                                String name = Movies.people.getName().trim();
                                String email = Movies.people.getEmail().trim();
                                String phone_number = Movies.people.getPhone_number().trim();
                                int member = Movies.people.getMember();
                                String password = Movies.people.getPassword().trim();
                                String fileName = "database/client/" + name + ".txt";
                                PrintWriter output = new PrintWriter(fileName);
                                output.println(id);
                                output.println(name);
                                output.println(email);
                                output.println(phone_number);
                                output.println(member);
                                output.println(final_money);
                                output.println(password);
                                output.close();
                                JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                //Receipt
                                try {
                                    String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie.toString() + "\n___________________________________________________________________\n\n";
                                    File secondFile = new File("database/receipt/" + name + ".txt");
                                    FileOutputStream fos = new FileOutputStream(secondFile, true);
                                    fos.write(receipt.getBytes());
                                } catch (IOException e) {
                                }
                                String movie = "database/movie/" + name + "/H" + passData + ".txt";
                                File moviefile = new File(movie);
                                moviefile.createNewFile();
                                historyPage();
                                check_movie = false;
                                check_movie2 = false;
                                S_show = false;
                                H_show = false;
                                S_R_show = false;
                                H_R_show = false;
                            } catch (FileNotFoundException z) {
                            } catch (Exception z) {
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if (!passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                        if (nothing.equals("yes")) {
                            JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        }
        );
        Rentstandard.setOnAction(c
                -> {
            if (check_movie3 == true) {
                if (Movies.people.getAmount() == 0) {
                    JOptionPane.showMessageDialog(null, "Your Amount Have No Money", "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did You Want To Reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("Movies");
                        dialog.setHeaderText("Secure Authentication");
                        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
                        dialogStage.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd);
                        dialog.getDialogPane().setContent(content);
                        dialog.setResultConverter(dialogButton -> {
                            if (dialogButton == ButtonType.OK) {
                                return pwd.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck = "";
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            passwordcheck = result.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog2 = new Dialog<>();
                                dialog2.setTitle("Movies Payment");
                                dialog2.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage2 = (Stage) dialog2.getDialogPane().getScene().getWindow();
                                dialogStage2.getIcons().add(ApplicationIcon);

                                TextField cash1 = new TextField();
                                HBox content2 = new HBox();
                                content2.setAlignment(Pos.CENTER_LEFT);
                                content2.setSpacing(10);
                                content2.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash1);
                                dialog2.getDialogPane().setContent(content2);
                                dialog2.setResultConverter(dialogButton2 -> {
                                    if (dialogButton2 == ButtonType.OK) {
                                        return cash1.getText();
                                    }
                                    return null;
                                });
                                String ok = "";
                                double amount = 0;
                                Optional<String> reload_money = dialog2.showAndWait();
                                if (reload_money.isPresent()) {
                                    amount = new Double(reload_money.get());
                                } else {
                                    ok = "ok";
                                }
                                double first = Movies.people.getAmount();

                                if (amount <= -1 || amount <= 0 || amount >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Fail", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(amount);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload successfully", "Congrats !", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, amount);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount + "\nAmount left " + amount + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {

                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {

                    }
                } else if (Movies.people.getAmount() < rent_price[passData]) {
                    JOptionPane.showMessageDialog(null, "Not enough money\nYour amount left " + Movies.people.getAmount(), "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog3 = new Dialog<>();
                        dialog3.setTitle("Movies");
                        dialog3.setHeaderText("Secure Authentication");
                        dialog3.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage3 = (Stage) dialog3.getDialogPane().getScene().getWindow();
                        dialogStage3.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog3.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd3 = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd3);
                        dialog3.getDialogPane().setContent(content);
                        dialog3.setResultConverter(dialogButton3 -> {
                            if (dialogButton3 == ButtonType.OK) {
                                return pwd3.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck3 = "";
                        Optional<String> result3 = dialog3.showAndWait();
                        if (result3.isPresent()) {
                            passwordcheck3 = result3.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog4 = new Dialog<>();
                                dialog4.setTitle("Movies Payment");
                                dialog4.setHeaderText(" ");
                                dialog4.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage4 = (Stage) dialog4.getDialogPane().getScene().getWindow();
                                dialogStage4.getIcons().add(ApplicationIcon);

                                TextField cash2 = new TextField();
                                HBox content4 = new HBox();
                                content4.setAlignment(Pos.CENTER_LEFT);
                                content4.setSpacing(10);
                                content4.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash2);
                                dialog4.getDialogPane().setContent(content4);
                                dialog4.setResultConverter(dialogButton4 -> {
                                    if (dialogButton4 == ButtonType.OK) {
                                        return cash2.getText();
                                    }
                                    return null;
                                });
                                String ok = "";
                                double amount2 = 0;
                                Optional<String> reload_money2 = dialog4.showAndWait();
                                if (reload_money2.isPresent()) {
                                    amount2 = new Double(reload_money2.get());
                                } else {
                                    ok = "not ok";
                                }
                                double first = Movies.people.getAmount();
                                Double left_money = new Double(Movies.people.getAmount());
                                Double final_money = amount2 + left_money;

                                if (amount2 <= -1 || amount2 <= 0 || amount2 >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("not ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount2 + "\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                    }
                } else if (Movies.people.getMember() == 2) {
                    JOptionPane.showMessageDialog(null, "You not member yet\nMember have 40% discount", "Inportant Information !", JOptionPane.INFORMATION_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to become member ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog5 = new Dialog<>();
                        dialog5.setTitle("Movies Member");
                        dialog5.setHeaderText("Secure Authentication");
                        dialog5.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage5 = (Stage) dialog5.getDialogPane().getScene().getWindow();
                        dialogStage5.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog5.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd5 = new PasswordField();
                        HBox content5 = new HBox();
                        content5.setAlignment(Pos.CENTER_LEFT);
                        content5.setSpacing(10);
                        content5.getChildren().addAll(new Label("Enter Your Password :"), pwd5);
                        dialog5.getDialogPane().setContent(content5);
                        dialog5.setResultConverter(dialogButton5 -> {
                            if (dialogButton5 == ButtonType.OK) {
                                return pwd5.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck5 = "";
                        Optional<String> result5 = dialog5.showAndWait();
                        if (result5.isPresent()) {
                            passwordcheck5 = result5.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (Movies.people.getAmount() < 15) {
                                JOptionPane.showMessageDialog(null, "Amount Not Enough Money \nPlease Reload First", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int confirm_Member1 = JOptionPane.showConfirmDialog(null, "Did You Want To Become Member?\nYou Be Change MYR15", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                                if (confirm_Member1 == 0) {
                                    double first = Movies.people.getAmount();
                                    double final_money = Movies.people.getAmount() - 15;
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = 1;
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "You Are Member Now", "Congrats", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nMember Fee MYR 15\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else if (!passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        Dialog<String> dialog_time = new Dialog<>();
                        dialog_time.setTitle("Movies Payment");
                        dialog_time.setHeaderText("Pick Your Day");
                        dialog_time.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage_time = (Stage) dialog_time.getDialogPane().getScene().getWindow();
                        dialogStage_time.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog_time.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        TextField _time = new TextField();
                        HBox content_time = new HBox();
                        content_time.setAlignment(Pos.CENTER_LEFT);
                        content_time.setSpacing(10);
                        content_time.getChildren().addAll(new Label("How Much Day Did you Want To Rent :"), _time);
                        dialog_time.getDialogPane().setContent(content_time);
                        dialog_time.setResultConverter(dialogButton_time -> {
                            if (dialogButton_time == ButtonType.OK) {
                                return _time.getText();
                            }
                            return null;
                        });
                        try {
                            String ok = "";
                            int rent_time = 0;
                            Optional<String> result_time = dialog_time.showAndWait();
                            if (result_time.isPresent()) {
                                rent_time = new Integer(result_time.get());
                            } else {
                                ok = "not ok";
                            }

                            if (rent_time <= -1 || rent_time <= 0 || rent_time >= 1000) {
                                JOptionPane.showMessageDialog(null, "Sorry Process Failed ! ", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else if (ok.equals("not ok")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel ! ", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                Dialog<String> dialog6 = new Dialog<>();
                                dialog6.setTitle("Movies Payment");
                                dialog6.setHeaderText("Secure Authentication");
                                dialog6.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage6 = (Stage) dialog6.getDialogPane().getScene().getWindow();
                                dialogStage6.getIcons().add(ApplicationIcon);

                                DIALOG_HEADER_ICON.setFitHeight(48);
                                DIALOG_HEADER_ICON.setFitWidth(48);
                                dialog6.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                                PasswordField pwd6 = new PasswordField();
                                HBox content6 = new HBox();
                                content6.setAlignment(Pos.CENTER_LEFT);
                                content6.setSpacing(10);
                                content6.getChildren().addAll(new Label("Enter Your Password :"), pwd6);
                                dialog6.getDialogPane().setContent(content6);
                                dialog6.setResultConverter(dialogButton6 -> {
                                    if (dialogButton6 == ButtonType.OK) {
                                        return pwd6.getText();
                                    }
                                    return null;
                                });
                                String nothing = "no";
                                String passwordcheck6 = "";
                                Optional<String> result6 = dialog6.showAndWait();
                                if (result6.isPresent()) {
                                    passwordcheck6 = result6.get();
                                } else {
                                    nothing = "yes";
                                }
                                if (passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                                    double first_amount = Movies.people.getAmount();
                                    int quantity = 1;
                                    movie1 = new rent_movie(passData, rent_time, quantity, Movies.people.getMember());
                                    movie1.getMoviePrice();
                                    movie1.getQuanlityPrice();
                                    movie1.getMembers();
                                    if (Movies.people.getAmount() <= movie1.getTotal() || Movies.people.getAmount() == 0) {
                                        JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        double final_money = movie1.minus(Movies.people.getAmount());
                                        try {
                                            String id = Movies.people.getId().trim();
                                            String name = Movies.people.getName().trim();
                                            String email = Movies.people.getEmail().trim();
                                            String phone_number = Movies.people.getPhone_number().trim();
                                            int member = Movies.people.getMember();
                                            String password = Movies.people.getPassword().trim();
                                            String fileName = "database/client/" + name + ".txt";
                                            PrintWriter output = new PrintWriter(fileName);
                                            output.println(id);
                                            output.println(name);
                                            output.println(email);
                                            output.println(phone_number);
                                            output.println(member);
                                            output.println(final_money);
                                            output.println(password);
                                            output.close();
                                            JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                            Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                            //Receipt                                                                      
                                            Date time = new Date();
                                            String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie1.toString() + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                            //day
                                            String movie_rentName = "database/movie/" + name + "/S_R" + passData + ".txt";
                                            try {
                                                File thirdFile = new File(movie_rentName);
                                                Scanner sr = new Scanner(thirdFile);
                                                str_day = sr.next();
                                                sr.close();
                                            } catch (Exception e) {
                                            }
                                            int day_rent_movie = new Integer(str_day);
                                            int New_day_rent_movie = day_rent_movie + rent_time;

                                            File thirdFile = new File(movie_rentName);
                                            PrintWriter new_rent_time = new PrintWriter(thirdFile);
                                            new_rent_time.println(New_day_rent_movie);
                                            new_rent_time.close();

                                            S_show = false;
                                            H_show = false;
                                            S_R_show = false;
                                            H_R_show = false;
                                            historyPage();
                                        } catch (FileNotFoundException z) {
                                        } catch (Exception z) {
                                        }
                                    }
                                } else if (!passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                                    if (nothing.equals("yes")) {
                                        JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    }
                                }

                            }
                        } catch (NumberFormatException a) {
                            JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    Dialog<String> dialog_time = new Dialog<>();
                    dialog_time.setTitle("Movies Payment");
                    dialog_time.setHeaderText("Pick Your Day");
                    dialog_time.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                    Stage dialogStage_time = (Stage) dialog_time.getDialogPane().getScene().getWindow();
                    dialogStage_time.getIcons().add(ApplicationIcon);

                    DIALOG_HEADER_ICON.setFitHeight(48);
                    DIALOG_HEADER_ICON.setFitWidth(48);
                    dialog_time.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                    TextField _time = new TextField();
                    HBox content_time = new HBox();
                    content_time.setAlignment(Pos.CENTER_LEFT);
                    content_time.setSpacing(10);
                    content_time.getChildren().addAll(new Label("How Much Day Did you Want To Rent :"), _time);
                    dialog_time.getDialogPane().setContent(content_time);
                    dialog_time.setResultConverter(dialogButton_time -> {
                        if (dialogButton_time == ButtonType.OK) {
                            return _time.getText();
                        }
                        return null;
                    });
                    try {
                        String ok = "";
                        int rent_time = 0;
                        Optional<String> result_time = dialog_time.showAndWait();
                        if (result_time.isPresent()) {
                            rent_time = new Integer(result_time.get());
                        } else {
                            ok = "not ok";
                        }

                        if (rent_time <= -1 || rent_time <= 0 || rent_time >= 1000) {
                            JOptionPane.showMessageDialog(null, "Sorry Process Failed ! ", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else if (ok.equals("not ok")) {
                            JOptionPane.showMessageDialog(null, "Process Cancel ! ", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Dialog<String> dialog7 = new Dialog<>();
                            dialog7.setTitle("Movies Payment");
                            dialog7.setHeaderText("Secure Authentication");
                            dialog7.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                            Stage dialogStage7 = (Stage) dialog7.getDialogPane().getScene().getWindow();
                            dialogStage7.getIcons().add(ApplicationIcon);

                            DIALOG_HEADER_ICON.setFitHeight(48);
                            DIALOG_HEADER_ICON.setFitWidth(48);
                            dialog7.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                            PasswordField pwd7 = new PasswordField();
                            HBox content7 = new HBox();
                            content7.setAlignment(Pos.CENTER_LEFT);
                            content7.setSpacing(10);
                            content7.getChildren().addAll(new Label("Enter Your Password :"), pwd7);
                            dialog7.getDialogPane().setContent(content7);
                            dialog7.setResultConverter(dialogButton6 -> {
                                if (dialogButton6 == ButtonType.OK) {
                                    return pwd7.getText();
                                }
                                return null;
                            });
                            String nothing = "no";
                            String passwordcheck7 = "";
                            Optional<String> result7 = dialog7.showAndWait();
                            if (result7.isPresent()) {
                                passwordcheck7 = result7.get();
                            } else {
                                nothing = "yes";
                            }
                            if (passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                                double first_amount = Movies.people.getAmount();
                                int quantity = 1;
                                movie1 = new rent_movie(passData, rent_time, quantity, Movies.people.getMember());
                                movie1.getMoviePrice();
                                movie1.getQuanlityPrice();
                                movie1.getMembers();
                                if (Movies.people.getAmount() <= movie1.getTotal() || Movies.people.getAmount() == 0) {
                                    JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    double final_money = movie1.minus(Movies.people.getAmount());
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie1.toString() + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                        String movie_rentName = "database/movie/" + name + "/S_R" + passData + ".txt";
                                        try {
                                            File thirdFile = new File(movie_rentName);
                                            Scanner sr = new Scanner(thirdFile);
                                            str_day = sr.next();
                                            sr.close();
                                        } catch (Exception e) {
                                        }
                                        int day_rent_movie = new Integer(str_day);
                                        int New_day_rent_movie = day_rent_movie + rent_time;

                                        File thirdFile = new File(movie_rentName);
                                        PrintWriter new_rent_time = new PrintWriter(thirdFile);
                                        new_rent_time.println(New_day_rent_movie);
                                        new_rent_time.close();
                                        S_show = false;
                                        H_show = false;
                                        S_R_show = false;
                                        H_R_show = false;
                                        historyPage();
                                    } catch (FileNotFoundException z) {
                                    } catch (Exception z) {
                                    }
                                }
                            } else if (!passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                                if (nothing.equals("yes")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                if (Movies.people.getAmount() == 0) {
                    JOptionPane.showMessageDialog(null, "Your Amount Have No Money", "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did You Want To Reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("Movies");
                        dialog.setHeaderText("Secure Authentication");
                        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
                        dialogStage.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd);
                        dialog.getDialogPane().setContent(content);
                        dialog.setResultConverter(dialogButton -> {
                            if (dialogButton == ButtonType.OK) {
                                return pwd.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck = "";
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            passwordcheck = result.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog2 = new Dialog<>();
                                dialog2.setTitle("Movies Payment");
                                dialog2.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage2 = (Stage) dialog2.getDialogPane().getScene().getWindow();
                                dialogStage2.getIcons().add(ApplicationIcon);

                                TextField cash1 = new TextField();
                                HBox content2 = new HBox();
                                content2.setAlignment(Pos.CENTER_LEFT);
                                content2.setSpacing(10);
                                content2.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash1);
                                dialog2.getDialogPane().setContent(content2);
                                dialog2.setResultConverter(dialogButton2 -> {
                                    if (dialogButton2 == ButtonType.OK) {
                                        return cash1.getText();
                                    }
                                    return null;
                                });
                                String ok = "";
                                double amount = 0;
                                Optional<String> reload_money = dialog2.showAndWait();
                                if (reload_money.isPresent()) {
                                    amount = new Double(reload_money.get());
                                } else {
                                    ok = "ok";
                                }
                                double first = Movies.people.getAmount();

                                if (amount <= -1 || amount <= 0 || amount >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Fail", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(amount);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload successfully", "Congrats !", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, amount);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount + "\nAmount left " + amount + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {

                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {

                    }
                } else if (Movies.people.getAmount() < rent_price[passData]) {
                    JOptionPane.showMessageDialog(null, "Not enough money\nYour amount left " + Movies.people.getAmount(), "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog3 = new Dialog<>();
                        dialog3.setTitle("Movies");
                        dialog3.setHeaderText("Secure Authentication");
                        dialog3.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage3 = (Stage) dialog3.getDialogPane().getScene().getWindow();
                        dialogStage3.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog3.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd3 = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd3);
                        dialog3.getDialogPane().setContent(content);
                        dialog3.setResultConverter(dialogButton3 -> {
                            if (dialogButton3 == ButtonType.OK) {
                                return pwd3.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck3 = "";
                        Optional<String> result3 = dialog3.showAndWait();
                        if (result3.isPresent()) {
                            passwordcheck3 = result3.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog4 = new Dialog<>();
                                dialog4.setTitle("Movies Payment");
                                dialog4.setHeaderText(" ");
                                dialog4.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage4 = (Stage) dialog4.getDialogPane().getScene().getWindow();
                                dialogStage4.getIcons().add(ApplicationIcon);

                                TextField cash2 = new TextField();
                                HBox content4 = new HBox();
                                content4.setAlignment(Pos.CENTER_LEFT);
                                content4.setSpacing(10);
                                content4.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash2);
                                dialog4.getDialogPane().setContent(content4);
                                dialog4.setResultConverter(dialogButton4 -> {
                                    if (dialogButton4 == ButtonType.OK) {
                                        return cash2.getText();
                                    }
                                    return null;
                                });
                                String ok = "";
                                double amount2 = 0;
                                Optional<String> reload_money2 = dialog4.showAndWait();
                                if (reload_money2.isPresent()) {
                                    amount2 = new Double(reload_money2.get());
                                } else {
                                    ok = "not ok";
                                }
                                double first = Movies.people.getAmount();
                                Double left_money = new Double(Movies.people.getAmount());
                                Double final_money = amount2 + left_money;

                                if (amount2 <= -1 || amount2 <= 0 || amount2 >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("not ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount2 + "\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                    }
                } else if (Movies.people.getMember() == 2) {
                    JOptionPane.showMessageDialog(null, "You not member yet\nMember have 40% discount", "Inportant Information !", JOptionPane.INFORMATION_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to become member ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog5 = new Dialog<>();
                        dialog5.setTitle("Movies Member");
                        dialog5.setHeaderText("Secure Authentication");
                        dialog5.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage5 = (Stage) dialog5.getDialogPane().getScene().getWindow();
                        dialogStage5.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog5.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd5 = new PasswordField();
                        HBox content5 = new HBox();
                        content5.setAlignment(Pos.CENTER_LEFT);
                        content5.setSpacing(10);
                        content5.getChildren().addAll(new Label("Enter Your Password :"), pwd5);
                        dialog5.getDialogPane().setContent(content5);
                        dialog5.setResultConverter(dialogButton5 -> {
                            if (dialogButton5 == ButtonType.OK) {
                                return pwd5.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck5 = "";
                        Optional<String> result5 = dialog5.showAndWait();
                        if (result5.isPresent()) {
                            passwordcheck5 = result5.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (Movies.people.getAmount() < 15) {
                                JOptionPane.showMessageDialog(null, "Amount Not Enough Money \nPlease Reload First", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int confirm_Member1 = JOptionPane.showConfirmDialog(null, "Did You Want To Become Member?\nYou Be Change MYR15", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                                if (confirm_Member1 == 0) {
                                    double first = Movies.people.getAmount();
                                    double final_money = Movies.people.getAmount() - 15;
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = 1;
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "You Are Member Now", "Congrats", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nMember Fee MYR 15\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else if (!passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        Dialog<String> dialog_time = new Dialog<>();
                        dialog_time.setTitle("Movies Payment");
                        dialog_time.setHeaderText("Pick Your Day");
                        dialog_time.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage_time = (Stage) dialog_time.getDialogPane().getScene().getWindow();
                        dialogStage_time.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog_time.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        TextField _time = new TextField();
                        HBox content_time = new HBox();
                        content_time.setAlignment(Pos.CENTER_LEFT);
                        content_time.setSpacing(10);
                        content_time.getChildren().addAll(new Label("How Much Day Did you Want To Rent :"), _time);
                        dialog_time.getDialogPane().setContent(content_time);
                        dialog_time.setResultConverter(dialogButton_time -> {
                            if (dialogButton_time == ButtonType.OK) {
                                return _time.getText();
                            }
                            return null;
                        });
                        try {
                            String ok = "";
                            int rent_time = 0;
                            Optional<String> result_time = dialog_time.showAndWait();
                            if (result_time.isPresent()) {
                                rent_time = new Integer(result_time.get());
                            } else {
                                ok = "not ok";
                            }

                            if (rent_time <= -1 || rent_time <= 0 || rent_time >= 1000) {
                                JOptionPane.showMessageDialog(null, "Sorry Process Failed ! ", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else if (ok.equals("not ok")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel ! ", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                Dialog<String> dialog6 = new Dialog<>();
                                dialog6.setTitle("Movies Payment");
                                dialog6.setHeaderText("Secure Authentication");
                                dialog6.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage6 = (Stage) dialog6.getDialogPane().getScene().getWindow();
                                dialogStage6.getIcons().add(ApplicationIcon);

                                DIALOG_HEADER_ICON.setFitHeight(48);
                                DIALOG_HEADER_ICON.setFitWidth(48);
                                dialog6.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                                PasswordField pwd6 = new PasswordField();
                                HBox content6 = new HBox();
                                content6.setAlignment(Pos.CENTER_LEFT);
                                content6.setSpacing(10);
                                content6.getChildren().addAll(new Label("Enter Your Password :"), pwd6);
                                dialog6.getDialogPane().setContent(content6);
                                dialog6.setResultConverter(dialogButton6 -> {
                                    if (dialogButton6 == ButtonType.OK) {
                                        return pwd6.getText();
                                    }
                                    return null;
                                });
                                String nothing = "no";
                                String passwordcheck6 = "";
                                Optional<String> result6 = dialog6.showAndWait();
                                if (result6.isPresent()) {
                                    passwordcheck6 = result6.get();
                                } else {
                                    nothing = "yes";
                                }
                                if (passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                                    double first_amount = Movies.people.getAmount();
                                    int quantity = 1;
                                    movie1 = new rent_movie(passData, rent_time, quantity, Movies.people.getMember());
                                    movie1.getMoviePrice();
                                    movie1.getQuanlityPrice();
                                    movie1.getMembers();
                                    if (Movies.people.getAmount() <= movie1.getTotal() || Movies.people.getAmount() == 0) {
                                        JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        double final_money = movie1.minus(Movies.people.getAmount());
                                        try {
                                            String id = Movies.people.getId().trim();
                                            String name = Movies.people.getName().trim();
                                            String email = Movies.people.getEmail().trim();
                                            String phone_number = Movies.people.getPhone_number().trim();
                                            int member = Movies.people.getMember();
                                            String password = Movies.people.getPassword().trim();
                                            String fileName = "database/client/" + name + ".txt";
                                            PrintWriter output = new PrintWriter(fileName);
                                            output.println(id);
                                            output.println(name);
                                            output.println(email);
                                            output.println(phone_number);
                                            output.println(member);
                                            output.println(final_money);
                                            output.println(password);
                                            output.close();
                                            JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                            Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                            //Receipt                                
                                            try {
                                                Date time = new Date();
                                                String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie1.toString() + "\n___________________________________________________________________\n\n";
                                                File secondFile = new File("database/receipt/" + name + ".txt");
                                                FileOutputStream fos = new FileOutputStream(secondFile, true);
                                                fos.write(receipt.getBytes());
                                            } catch (IOException e) {
                                            }
                                            String movie = "database/movie/" + name + "/S_R" + passData + ".txt";
                                            File moviefile = new File(movie);
                                            moviefile.createNewFile();
                                            PrintWriter time_rent = new PrintWriter(movie);
                                            time_rent.println(rent_time);
                                            time_rent.close();
                                            S_show = false;
                                            H_show = false;
                                            S_R_show = false;
                                            H_R_show = false;
                                            historyPage();
                                        } catch (FileNotFoundException z) {
                                        } catch (Exception z) {
                                        }
                                    }
                                } else if (!passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                                    if (nothing.equals("yes")) {
                                        JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    }
                                }

                            }
                        } catch (NumberFormatException a) {
                            JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    Dialog<String> dialog_time = new Dialog<>();
                    dialog_time.setTitle("Movies Payment");
                    dialog_time.setHeaderText("Pick Your Day");
                    dialog_time.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                    Stage dialogStage_time = (Stage) dialog_time.getDialogPane().getScene().getWindow();
                    dialogStage_time.getIcons().add(ApplicationIcon);

                    DIALOG_HEADER_ICON.setFitHeight(48);
                    DIALOG_HEADER_ICON.setFitWidth(48);
                    dialog_time.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                    TextField _time = new TextField();
                    HBox content_time = new HBox();
                    content_time.setAlignment(Pos.CENTER_LEFT);
                    content_time.setSpacing(10);
                    content_time.getChildren().addAll(new Label("How Much Day Did you Want To Rent :"), _time);
                    dialog_time.getDialogPane().setContent(content_time);
                    dialog_time.setResultConverter(dialogButton_time -> {
                        if (dialogButton_time == ButtonType.OK) {
                            return _time.getText();
                        }
                        return null;
                    });
                    try {
                        String ok = "";
                        int rent_time = 0;
                        Optional<String> result_time = dialog_time.showAndWait();
                        if (result_time.isPresent()) {
                            rent_time = new Integer(result_time.get());
                        } else {
                            ok = "not ok";
                        }

                        if (rent_time <= -1 || rent_time <= 0 || rent_time >= 1000) {
                            JOptionPane.showMessageDialog(null, "Sorry Process Failed ! ", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else if (ok.equals("not ok")) {
                            JOptionPane.showMessageDialog(null, "Process Cancel ! ", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Dialog<String> dialog7 = new Dialog<>();
                            dialog7.setTitle("Movies Payment");
                            dialog7.setHeaderText("Secure Authentication");
                            dialog7.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                            Stage dialogStage7 = (Stage) dialog7.getDialogPane().getScene().getWindow();
                            dialogStage7.getIcons().add(ApplicationIcon);

                            DIALOG_HEADER_ICON.setFitHeight(48);
                            DIALOG_HEADER_ICON.setFitWidth(48);
                            dialog7.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                            PasswordField pwd7 = new PasswordField();
                            HBox content7 = new HBox();
                            content7.setAlignment(Pos.CENTER_LEFT);
                            content7.setSpacing(10);
                            content7.getChildren().addAll(new Label("Enter Your Password :"), pwd7);
                            dialog7.getDialogPane().setContent(content7);
                            dialog7.setResultConverter(dialogButton6 -> {
                                if (dialogButton6 == ButtonType.OK) {
                                    return pwd7.getText();
                                }
                                return null;
                            });
                            String nothing = "no";
                            String passwordcheck7 = "";
                            Optional<String> result7 = dialog7.showAndWait();
                            if (result7.isPresent()) {
                                passwordcheck7 = result7.get();
                            } else {
                                nothing = "yes";
                            }
                            if (passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                                double first_amount = Movies.people.getAmount();
                                int quantity = 1;
                                movie1 = new rent_movie(passData, rent_time, quantity, Movies.people.getMember());
                                movie1.getMoviePrice();
                                movie1.getQuanlityPrice();
                                movie1.getMembers();
                                if (Movies.people.getAmount() <= movie1.getTotal() || Movies.people.getAmount() == 0) {
                                    JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    double final_money = movie1.minus(Movies.people.getAmount());
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie1.toString() + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                        String movie = "database/movie/" + name + "/S_R" + passData + ".txt";
                                        File moviefile = new File(movie);
                                        moviefile.createNewFile();
                                        PrintWriter time_rent = new PrintWriter(movie);
                                        time_rent.println(rent_time);
                                        time_rent.close();
                                        S_show = false;
                                        H_show = false;
                                        S_R_show = false;
                                        H_R_show = false;
                                        historyPage();
                                    } catch (FileNotFoundException z) {
                                    } catch (Exception z) {
                                    }
                                }
                            } else if (!passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                                if (nothing.equals("yes")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        );
        RentHD.setOnAction(c
                -> {
            if (check_movie4 == true) {
                if (Movies.people.getAmount() == 0) {
                    JOptionPane.showMessageDialog(null, "Your Amount Have No Money", "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did You Want To Reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("Movies");
                        dialog.setHeaderText("Secure Authentication");
                        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
                        dialogStage.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd);
                        dialog.getDialogPane().setContent(content);
                        dialog.setResultConverter(dialogButton -> {
                            if (dialogButton == ButtonType.OK) {
                                return pwd.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck = "";
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            passwordcheck = result.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog2 = new Dialog<>();
                                dialog2.setTitle("Movies Payment");
                                dialog2.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage2 = (Stage) dialog2.getDialogPane().getScene().getWindow();
                                dialogStage2.getIcons().add(ApplicationIcon);

                                TextField cash1 = new TextField();
                                HBox content2 = new HBox();
                                content2.setAlignment(Pos.CENTER_LEFT);
                                content2.setSpacing(10);
                                content2.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash1);
                                dialog2.getDialogPane().setContent(content2);
                                dialog2.setResultConverter(dialogButton2 -> {
                                    if (dialogButton2 == ButtonType.OK) {
                                        return cash1.getText();
                                    }
                                    return null;
                                });

                                String ok = "";
                                double amount = 0;
                                Optional<String> reload_money = dialog2.showAndWait();
                                if (reload_money.isPresent()) {
                                    amount = new Double(reload_money.get());
                                } else {
                                    ok = "ok";
                                }
                                double first = Movies.people.getAmount();

                                if (amount <= -1 || amount <= 0 || amount >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Fail", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(amount);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload successfully", "Congrats !", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, amount);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount + "\nAmount left " + amount + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {

                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {

                    }
                } else if (Movies.people.getAmount() < rent_price[passData]) {
                    JOptionPane.showMessageDialog(null, "Not enough money\nYour amount left " + Movies.people.getAmount(), "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog3 = new Dialog<>();
                        dialog3.setTitle("Movies");
                        dialog3.setHeaderText("Secure Authentication");
                        dialog3.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage3 = (Stage) dialog3.getDialogPane().getScene().getWindow();
                        dialogStage3.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog3.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd3 = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd3);
                        dialog3.getDialogPane().setContent(content);
                        dialog3.setResultConverter(dialogButton3 -> {
                            if (dialogButton3 == ButtonType.OK) {
                                return pwd3.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck3 = "";
                        Optional<String> result3 = dialog3.showAndWait();
                        if (result3.isPresent()) {
                            passwordcheck3 = result3.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog4 = new Dialog<>();
                                dialog4.setTitle("Movies Payment");
                                dialog4.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage4 = (Stage) dialog4.getDialogPane().getScene().getWindow();
                                dialogStage4.getIcons().add(ApplicationIcon);

                                TextField cash2 = new TextField();
                                HBox content4 = new HBox();
                                content4.setAlignment(Pos.CENTER_LEFT);
                                content4.setSpacing(10);
                                content4.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash2);
                                dialog4.getDialogPane().setContent(content4);
                                dialog4.setResultConverter(dialogButton4 -> {
                                    if (dialogButton4 == ButtonType.OK) {
                                        return cash2.getText();
                                    }
                                    return null;
                                });

                                String ok = "";
                                double amount2 = 0;
                                Optional<String> reload_money2 = dialog4.showAndWait();
                                if (reload_money2.isPresent()) {
                                    amount2 = new Double(reload_money2.get());
                                } else {
                                    ok = "not ok";
                                }
                                double first = Movies.people.getAmount();
                                Double left_money = new Double(Movies.people.getAmount());
                                Double final_money = amount2 + left_money;

                                if (amount2 <= -1 || amount2 <= 0 || amount2 >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("not ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount2 + "\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                    }
                } else if (Movies.people.getMember() == 2) {
                    JOptionPane.showMessageDialog(null, "You not member yet\nMember have 40% discount", "Inportant Information !", JOptionPane.INFORMATION_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to become member ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog5 = new Dialog<>();
                        dialog5.setTitle("Movies Member");
                        dialog5.setHeaderText("Secure Authentication");
                        dialog5.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage5 = (Stage) dialog5.getDialogPane().getScene().getWindow();
                        dialogStage5.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog5.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd5 = new PasswordField();
                        HBox content5 = new HBox();
                        content5.setAlignment(Pos.CENTER_LEFT);
                        content5.setSpacing(10);
                        content5.getChildren().addAll(new Label("Enter Your Password :"), pwd5);
                        dialog5.getDialogPane().setContent(content5);
                        dialog5.setResultConverter(dialogButton5 -> {
                            if (dialogButton5 == ButtonType.OK) {
                                return pwd5.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck5 = "";
                        Optional<String> result5 = dialog5.showAndWait();
                        if (result5.isPresent()) {
                            passwordcheck5 = result5.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (Movies.people.getAmount() < 15) {
                                JOptionPane.showMessageDialog(null, "Amount Not Enough Money \nPlease Reload First", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int confirm_Member1 = JOptionPane.showConfirmDialog(null, "Did You Want To Become Member?\nYou Be Change MYR15", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                                if (confirm_Member1 == 0) {
                                    double first = Movies.people.getAmount();
                                    double final_money = Movies.people.getAmount() - 15;
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = 1;
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "You Are Member Now", "Congrats", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nMember Fee MYR 15\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                        historyPage();
                                    } catch (FileNotFoundException z) {
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else if (!passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        Dialog<String> dialog_time = new Dialog<>();
                        dialog_time.setTitle("Movies Payment");
                        dialog_time.setHeaderText("Pick Your Day");
                        dialog_time.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage_time = (Stage) dialog_time.getDialogPane().getScene().getWindow();
                        dialogStage_time.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog_time.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        TextField _time = new TextField();
                        HBox content_time = new HBox();
                        content_time.setAlignment(Pos.CENTER_LEFT);
                        content_time.setSpacing(10);
                        content_time.getChildren().addAll(new Label("How Much Day Did you Want To Rent :"), _time);
                        dialog_time.getDialogPane().setContent(content_time);
                        dialog_time.setResultConverter(dialogButton_time -> {
                            if (dialogButton_time == ButtonType.OK) {
                                return _time.getText();
                            }
                            return null;
                        });
                        try {
                            String ok = "";
                            int rent_time = 0;
                            Optional<String> result_time = dialog_time.showAndWait();
                            if (result_time.isPresent()) {
                                rent_time = new Integer(result_time.get());
                            } else {
                                ok = "not ok";
                            }

                            if (rent_time <= -1 || rent_time <= 0 || rent_time >= 1000) {
                                JOptionPane.showMessageDialog(null, "Sorry Process Failed !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else if (ok.equals("not ok")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                Dialog<String> dialog6 = new Dialog<>();
                                dialog6.setTitle("Movies Payment");
                                dialog6.setHeaderText("Secure Authentication");
                                dialog6.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage6 = (Stage) dialog6.getDialogPane().getScene().getWindow();
                                dialogStage6.getIcons().add(ApplicationIcon);

                                DIALOG_HEADER_ICON.setFitHeight(48);
                                DIALOG_HEADER_ICON.setFitWidth(48);
                                dialog6.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                                PasswordField pwd6 = new PasswordField();
                                HBox content6 = new HBox();
                                content6.setAlignment(Pos.CENTER_LEFT);
                                content6.setSpacing(10);
                                content6.getChildren().addAll(new Label("Enter Your Password :"), pwd6);
                                dialog6.getDialogPane().setContent(content6);
                                dialog6.setResultConverter(dialogButton6 -> {
                                    if (dialogButton6 == ButtonType.OK) {
                                        return pwd6.getText();
                                    }
                                    return null;
                                });
                                String nothing = "no";
                                String passwordcheck6 = "";
                                Optional<String> result6 = dialog6.showAndWait();
                                if (result6.isPresent()) {
                                    passwordcheck6 = result6.get();
                                } else {
                                    nothing = "yes";
                                }
                                if (passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {

                                    double first_amount = Movies.people.getAmount();
                                    int quantity = 2;
                                    movie1 = new rent_movie(passData, rent_time, quantity, Movies.people.getMember());
                                    movie1.getMoviePrice();
                                    movie1.getQuanlityPrice();
                                    movie1.getMembers();
                                    if (Movies.people.getAmount() > movie1.getTotal()) {
                                        double final_money = movie1.minus(Movies.people.getAmount());
                                        try {
                                            String id = Movies.people.getId().trim();
                                            String name = Movies.people.getName().trim();
                                            String email = Movies.people.getEmail().trim();
                                            String phone_number = Movies.people.getPhone_number().trim();
                                            int member = Movies.people.getMember();
                                            String password = Movies.people.getPassword().trim();
                                            String fileName = "database/client/" + name + ".txt";
                                            PrintWriter output = new PrintWriter(fileName);
                                            output.println(id);
                                            output.println(name);
                                            output.println(email);
                                            output.println(phone_number);
                                            output.println(member);
                                            output.println(final_money);
                                            output.println(password);
                                            output.close();
                                            JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                            Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                            //Receipt
                                            try {
                                                Date time = new Date();
                                                String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie1.toString() + "\n___________________________________________________________________\n\n";
                                                File secondFile = new File("database/receipt/" + name + ".txt");
                                                FileOutputStream fos = new FileOutputStream(secondFile, true);
                                                fos.write(receipt.getBytes());
                                            } catch (IOException e) {
                                            }
                                            String movie_rentName = "database/movie/" + name + "/H_R" + passData + ".txt";
                                            try {
                                                File thirdFile = new File(movie_rentName);
                                                Scanner sr = new Scanner(thirdFile);
                                                hdr_day = sr.next();
                                                sr.close();
                                            } catch (Exception e) {
                                            }
                                            int day_rent_movie = new Integer(hdr_day);
                                            int New_day_rent_movie = day_rent_movie + rent_time;

                                            File thirdFile = new File(movie_rentName);
                                            PrintWriter new_rent_time = new PrintWriter(thirdFile);
                                            new_rent_time.println(New_day_rent_movie);
                                            new_rent_time.close();

                                            S_show = false;
                                            H_show = false;
                                            S_R_show = false;
                                            H_R_show = false;
                                            historyPage();
                                        } catch (FileNotFoundException z) {
                                        } catch (Exception z) {
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else if (!passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                                    if (nothing.equals("yes")) {
                                        JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                        } catch (NumberFormatException a) {
                            JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    Dialog<String> dialog_time = new Dialog<>();
                    dialog_time.setTitle("Movies Payment");
                    dialog_time.setHeaderText("Pick Your Day");
                    dialog_time.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                    Stage dialogStage_time = (Stage) dialog_time.getDialogPane().getScene().getWindow();
                    dialogStage_time.getIcons().add(ApplicationIcon);

                    DIALOG_HEADER_ICON.setFitHeight(48);
                    DIALOG_HEADER_ICON.setFitWidth(48);
                    dialog_time.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                    TextField _time = new TextField();
                    HBox content_time = new HBox();
                    content_time.setAlignment(Pos.CENTER_LEFT);
                    content_time.setSpacing(10);
                    content_time.getChildren().addAll(new Label("How Much Day Did you Want To Rent :"), _time);
                    dialog_time.getDialogPane().setContent(content_time);
                    dialog_time.setResultConverter(dialogButton_time -> {
                        if (dialogButton_time == ButtonType.OK) {
                            return _time.getText();
                        }
                        return null;
                    });
                    try {
                        String ok = "";
                        int rent_time = 0;
                        Optional<String> result_time = dialog_time.showAndWait();
                        if (result_time.isPresent()) {
                            rent_time = new Integer(result_time.get());
                        } else {
                            ok = "not ok";
                        }

                        if (rent_time <= -1 || rent_time <= 0 || rent_time >= 1000) {
                            JOptionPane.showMessageDialog(null, "Sorry Process Failed !", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else if (ok.equals("not ok")) {
                            JOptionPane.showMessageDialog(null, "Process Cancel !", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Dialog<String> dialog7 = new Dialog<>();
                            dialog7.setTitle("Movies Payment");
                            dialog7.setHeaderText("Secure Authentication");
                            dialog7.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                            Stage dialogStage7 = (Stage) dialog7.getDialogPane().getScene().getWindow();
                            dialogStage7.getIcons().add(ApplicationIcon);

                            DIALOG_HEADER_ICON.setFitHeight(48);
                            DIALOG_HEADER_ICON.setFitWidth(48);
                            dialog7.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                            PasswordField pwd7 = new PasswordField();
                            HBox content7 = new HBox();
                            content7.setAlignment(Pos.CENTER_LEFT);
                            content7.setSpacing(10);
                            content7.getChildren().addAll(new Label("Enter Your Password :"), pwd7);
                            dialog7.getDialogPane().setContent(content7);
                            dialog7.setResultConverter(dialogButton6 -> {
                                if (dialogButton6 == ButtonType.OK) {
                                    return pwd7.getText();
                                }
                                return null;
                            });
                            String nothing = "no";
                            String passwordcheck7 = "";
                            Optional<String> result7 = dialog7.showAndWait();
                            if (result7.isPresent()) {
                                passwordcheck7 = result7.get();
                            } else {
                                nothing = "yes";
                            }
                            if (passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                                double first_amount = Movies.people.getAmount();
                                int quantity = 2;
                                movie1 = new rent_movie(passData, rent_time, quantity, Movies.people.getMember());
                                movie1.getMoviePrice();
                                movie1.getQuanlityPrice();
                                movie1.getMembers();
                                if (Movies.people.getAmount() > movie1.getTotal()) {
                                    double final_money = movie1.minus(Movies.people.getAmount());
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie1.toString() + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                        String movie_rentName = "database/movie/" + name + "/H_R" + passData + ".txt";
                                        try {
                                            File thirdFile = new File(movie_rentName);
                                            Scanner sr = new Scanner(thirdFile);
                                            hdr_day = sr.next();
                                            sr.close();
                                        } catch (Exception e) {
                                        }
                                        int day_rent_movie = new Integer(hdr_day);
                                        int New_day_rent_movie = day_rent_movie + rent_time;

                                        File thirdFile = new File(movie_rentName);
                                        PrintWriter new_rent_time = new PrintWriter(thirdFile);
                                        new_rent_time.println(New_day_rent_movie);
                                        new_rent_time.close();
                                        S_show = false;
                                        H_show = false;
                                        S_R_show = false;
                                        H_R_show = false;
                                        historyPage();
                                    } catch (FileNotFoundException z) {
                                    } catch (Exception z) {
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            } else if (!passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                                if (nothing.equals("yes")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                if (Movies.people.getAmount() == 0) {
                    JOptionPane.showMessageDialog(null, "Your Amount Have No Money", "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did You Want To Reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("Movies");
                        dialog.setHeaderText("Secure Authentication");
                        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
                        dialogStage.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd);
                        dialog.getDialogPane().setContent(content);
                        dialog.setResultConverter(dialogButton -> {
                            if (dialogButton == ButtonType.OK) {
                                return pwd.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck = "";
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            passwordcheck = result.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog2 = new Dialog<>();
                                dialog2.setTitle("Movies Payment");
                                dialog2.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage2 = (Stage) dialog2.getDialogPane().getScene().getWindow();
                                dialogStage2.getIcons().add(ApplicationIcon);

                                TextField cash1 = new TextField();
                                HBox content2 = new HBox();
                                content2.setAlignment(Pos.CENTER_LEFT);
                                content2.setSpacing(10);
                                content2.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash1);
                                dialog2.getDialogPane().setContent(content2);
                                dialog2.setResultConverter(dialogButton2 -> {
                                    if (dialogButton2 == ButtonType.OK) {
                                        return cash1.getText();
                                    }
                                    return null;
                                });

                                String ok = "";
                                double amount = 0;
                                Optional<String> reload_money = dialog2.showAndWait();
                                if (reload_money.isPresent()) {
                                    amount = new Double(reload_money.get());
                                } else {
                                    ok = "ok";
                                }
                                double first = Movies.people.getAmount();

                                if (amount <= -1 || amount <= 0 || amount >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Fail", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(amount);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload successfully", "Congrats !", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, amount);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount + "\nAmount left " + amount + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {

                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {

                    }
                } else if (Movies.people.getAmount() < rent_price[passData]) {
                    JOptionPane.showMessageDialog(null, "Not enough money\nYour amount left " + Movies.people.getAmount(), "Warning !", JOptionPane.WARNING_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog3 = new Dialog<>();
                        dialog3.setTitle("Movies");
                        dialog3.setHeaderText("Secure Authentication");
                        dialog3.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage3 = (Stage) dialog3.getDialogPane().getScene().getWindow();
                        dialogStage3.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog3.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd3 = new PasswordField();
                        HBox content = new HBox();
                        content.setAlignment(Pos.CENTER_LEFT);
                        content.setSpacing(10);
                        content.getChildren().addAll(new Label("Enter Your Password :"), pwd3);
                        dialog3.getDialogPane().setContent(content);
                        dialog3.setResultConverter(dialogButton3 -> {
                            if (dialogButton3 == ButtonType.OK) {
                                return pwd3.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck3 = "";
                        Optional<String> result3 = dialog3.showAndWait();
                        if (result3.isPresent()) {
                            passwordcheck3 = result3.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            try {
                                Dialog<String> dialog4 = new Dialog<>();
                                dialog4.setTitle("Movies Payment");
                                dialog4.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage4 = (Stage) dialog4.getDialogPane().getScene().getWindow();
                                dialogStage4.getIcons().add(ApplicationIcon);

                                TextField cash2 = new TextField();
                                HBox content4 = new HBox();
                                content4.setAlignment(Pos.CENTER_LEFT);
                                content4.setSpacing(10);
                                content4.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash2);
                                dialog4.getDialogPane().setContent(content4);
                                dialog4.setResultConverter(dialogButton4 -> {
                                    if (dialogButton4 == ButtonType.OK) {
                                        return cash2.getText();
                                    }
                                    return null;
                                });

                                String ok = "";
                                double amount2 = 0;
                                Optional<String> reload_money2 = dialog4.showAndWait();
                                if (reload_money2.isPresent()) {
                                    amount2 = new Double(reload_money2.get());
                                } else {
                                    ok = "not ok";
                                }
                                double first = Movies.people.getAmount();
                                Double left_money = new Double(Movies.people.getAmount());
                                Double final_money = amount2 + left_money;

                                if (amount2 <= -1 || amount2 <= 0 || amount2 >= 1000000) {
                                    JOptionPane.showMessageDialog(null, "Reload Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else if (ok.equals("not ok")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Reload Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nReload MYR " + amount2 + "\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                    } catch (FileNotFoundException z) {
                                    }
                                }
                            } catch (NumberFormatException a) {
                                JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if (!passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                    }
                } else if (Movies.people.getMember() == 2) {
                    JOptionPane.showMessageDialog(null, "You not member yet\nMember have 40% discount", "Inportant Information !", JOptionPane.INFORMATION_MESSAGE);
                    int select = JOptionPane.showConfirmDialog(null, "Did you want to become member ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                    if (select == 0) {
                        Dialog<String> dialog5 = new Dialog<>();
                        dialog5.setTitle("Movies Member");
                        dialog5.setHeaderText("Secure Authentication");
                        dialog5.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage5 = (Stage) dialog5.getDialogPane().getScene().getWindow();
                        dialogStage5.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog5.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        PasswordField pwd5 = new PasswordField();
                        HBox content5 = new HBox();
                        content5.setAlignment(Pos.CENTER_LEFT);
                        content5.setSpacing(10);
                        content5.getChildren().addAll(new Label("Enter Your Password :"), pwd5);
                        dialog5.getDialogPane().setContent(content5);
                        dialog5.setResultConverter(dialogButton5 -> {
                            if (dialogButton5 == ButtonType.OK) {
                                return pwd5.getText();
                            }
                            return null;
                        });
                        String nothing = "no";
                        String passwordcheck5 = "";
                        Optional<String> result5 = dialog5.showAndWait();
                        if (result5.isPresent()) {
                            passwordcheck5 = result5.get();
                        } else {
                            nothing = "yes";
                        }
                        if (passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (Movies.people.getAmount() < 15) {
                                JOptionPane.showMessageDialog(null, "Amount Not Enough Money \nPlease Reload First", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                int confirm_Member1 = JOptionPane.showConfirmDialog(null, "Did You Want To Become Member?\nYou Be Change MYR15", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                                if (confirm_Member1 == 0) {
                                    double first = Movies.people.getAmount();
                                    double final_money = Movies.people.getAmount() - 15;
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = 1;
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "You Are Member Now", "Congrats", JOptionPane.WARNING_MESSAGE);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "The Amount MYR " + first + "\nMember Fee MYR 15\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                        historyPage();
                                    } catch (FileNotFoundException z) {
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else if (!passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                            if (nothing.equals("yes")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        Dialog<String> dialog_time = new Dialog<>();
                        dialog_time.setTitle("Movies Payment");
                        dialog_time.setHeaderText("Pick Your Day");
                        dialog_time.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        Stage dialogStage_time = (Stage) dialog_time.getDialogPane().getScene().getWindow();
                        dialogStage_time.getIcons().add(ApplicationIcon);

                        DIALOG_HEADER_ICON.setFitHeight(48);
                        DIALOG_HEADER_ICON.setFitWidth(48);
                        dialog_time.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                        TextField _time = new TextField();
                        HBox content_time = new HBox();
                        content_time.setAlignment(Pos.CENTER_LEFT);
                        content_time.setSpacing(10);
                        content_time.getChildren().addAll(new Label("How Much Day Did you Want To Rent :"), _time);
                        dialog_time.getDialogPane().setContent(content_time);
                        dialog_time.setResultConverter(dialogButton_time -> {
                            if (dialogButton_time == ButtonType.OK) {
                                return _time.getText();
                            }
                            return null;
                        });
                        try {
                            String ok = "";
                            int rent_time = 0;
                            Optional<String> result_time = dialog_time.showAndWait();
                            if (result_time.isPresent()) {
                                rent_time = new Integer(result_time.get());
                            } else {
                                ok = "not ok";
                            }

                            if (rent_time <= -1 || rent_time <= 0 || rent_time >= 1000) {
                                JOptionPane.showMessageDialog(null, "Sorry Process Failed !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else if (ok.equals("not ok")) {
                                JOptionPane.showMessageDialog(null, "Process Cancel !", "Warning !", JOptionPane.WARNING_MESSAGE);
                            } else {
                                Dialog<String> dialog6 = new Dialog<>();
                                dialog6.setTitle("Movies Payment");
                                dialog6.setHeaderText("Secure Authentication");
                                dialog6.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                                Stage dialogStage6 = (Stage) dialog6.getDialogPane().getScene().getWindow();
                                dialogStage6.getIcons().add(ApplicationIcon);

                                DIALOG_HEADER_ICON.setFitHeight(48);
                                DIALOG_HEADER_ICON.setFitWidth(48);
                                dialog6.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                                PasswordField pwd6 = new PasswordField();
                                HBox content6 = new HBox();
                                content6.setAlignment(Pos.CENTER_LEFT);
                                content6.setSpacing(10);
                                content6.getChildren().addAll(new Label("Enter Your Password :"), pwd6);
                                dialog6.getDialogPane().setContent(content6);
                                dialog6.setResultConverter(dialogButton6 -> {
                                    if (dialogButton6 == ButtonType.OK) {
                                        return pwd6.getText();
                                    }
                                    return null;
                                });
                                String nothing = "no";
                                String passwordcheck6 = "";
                                Optional<String> result6 = dialog6.showAndWait();
                                if (result6.isPresent()) {
                                    passwordcheck6 = result6.get();
                                } else {
                                    nothing = "yes";
                                }
                                if (passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {

                                    double first_amount = Movies.people.getAmount();
                                    int quantity = 2;
                                    movie1 = new rent_movie(passData, rent_time, quantity, Movies.people.getMember());
                                    movie1.getMoviePrice();
                                    movie1.getQuanlityPrice();
                                    movie1.getMembers();
                                    if (Movies.people.getAmount() > movie1.getTotal()) {
                                        double final_money = movie1.minus(Movies.people.getAmount());
                                        try {
                                            String id = Movies.people.getId().trim();
                                            String name = Movies.people.getName().trim();
                                            String email = Movies.people.getEmail().trim();
                                            String phone_number = Movies.people.getPhone_number().trim();
                                            int member = Movies.people.getMember();
                                            String password = Movies.people.getPassword().trim();
                                            String fileName = "database/client/" + name + ".txt";
                                            PrintWriter output = new PrintWriter(fileName);
                                            output.println(id);
                                            output.println(name);
                                            output.println(email);
                                            output.println(phone_number);
                                            output.println(member);
                                            output.println(final_money);
                                            output.println(password);
                                            output.close();
                                            JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                            Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                            //Receipt
                                            try {
                                                Date time = new Date();
                                                String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie1.toString() + "\n___________________________________________________________________\n\n";
                                                File secondFile = new File("database/receipt/" + name + ".txt");
                                                FileOutputStream fos = new FileOutputStream(secondFile, true);
                                                fos.write(receipt.getBytes());
                                            } catch (IOException e) {
                                            }
                                            String movie = "database/movie/" + name + "/H_R" + passData + ".txt";
                                            File moviefile = new File(movie);
                                            moviefile.createNewFile();
                                            PrintWriter time_rent = new PrintWriter(movie);
                                            time_rent.println(rent_time);
                                            time_rent.close();
                                            S_show = false;
                                            H_show = false;
                                            S_R_show = false;
                                            H_R_show = false;
                                            historyPage();
                                        } catch (FileNotFoundException z) {
                                        } catch (Exception z) {
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else if (!passwordcheck6.trim().equals(Movies.people.getPassword().trim())) {
                                    if (nothing.equals("yes")) {
                                        JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                        } catch (NumberFormatException a) {
                            JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    Dialog<String> dialog_time = new Dialog<>();
                    dialog_time.setTitle("Movies Payment");
                    dialog_time.setHeaderText("Pick Your Day");
                    dialog_time.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                    Stage dialogStage_time = (Stage) dialog_time.getDialogPane().getScene().getWindow();
                    dialogStage_time.getIcons().add(ApplicationIcon);

                    DIALOG_HEADER_ICON.setFitHeight(48);
                    DIALOG_HEADER_ICON.setFitWidth(48);
                    dialog_time.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                    TextField _time = new TextField();
                    HBox content_time = new HBox();
                    content_time.setAlignment(Pos.CENTER_LEFT);
                    content_time.setSpacing(10);
                    content_time.getChildren().addAll(new Label("How Much Day Did you Want To Rent :"), _time);
                    dialog_time.getDialogPane().setContent(content_time);
                    dialog_time.setResultConverter(dialogButton_time -> {
                        if (dialogButton_time == ButtonType.OK) {
                            return _time.getText();
                        }
                        return null;
                    });
                    try {
                        String ok = "";
                        int rent_time = 0;
                        Optional<String> result_time = dialog_time.showAndWait();
                        if (result_time.isPresent()) {
                            rent_time = new Integer(result_time.get());
                        } else {
                            ok = "not ok";
                        }

                        if (rent_time <= -1 || rent_time <= 0 || rent_time >= 1000) {
                            JOptionPane.showMessageDialog(null, "Sorry Process Failed !", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else if (ok.equals("not ok")) {
                            JOptionPane.showMessageDialog(null, "Process Cancel !", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Dialog<String> dialog7 = new Dialog<>();
                            dialog7.setTitle("Movies Payment");
                            dialog7.setHeaderText("Secure Authentication");
                            dialog7.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                            Stage dialogStage7 = (Stage) dialog7.getDialogPane().getScene().getWindow();
                            dialogStage7.getIcons().add(ApplicationIcon);

                            DIALOG_HEADER_ICON.setFitHeight(48);
                            DIALOG_HEADER_ICON.setFitWidth(48);
                            dialog7.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                            PasswordField pwd7 = new PasswordField();
                            HBox content7 = new HBox();
                            content7.setAlignment(Pos.CENTER_LEFT);
                            content7.setSpacing(10);
                            content7.getChildren().addAll(new Label("Enter Your Password :"), pwd7);
                            dialog7.getDialogPane().setContent(content7);
                            dialog7.setResultConverter(dialogButton6 -> {
                                if (dialogButton6 == ButtonType.OK) {
                                    return pwd7.getText();
                                }
                                return null;
                            });
                            String nothing = "no";
                            String passwordcheck7 = "";
                            Optional<String> result7 = dialog7.showAndWait();
                            if (result7.isPresent()) {
                                passwordcheck7 = result7.get();
                            } else {
                                nothing = "yes";
                            }
                            if (passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                                double first_amount = Movies.people.getAmount();
                                int quantity = 2;
                                movie1 = new rent_movie(passData, rent_time, quantity, Movies.people.getMember());
                                movie1.getMoviePrice();
                                movie1.getQuanlityPrice();
                                movie1.getMembers();
                                if (Movies.people.getAmount() > movie1.getTotal()) {
                                    double final_money = movie1.minus(Movies.people.getAmount());
                                    try {
                                        String id = Movies.people.getId().trim();
                                        String name = Movies.people.getName().trim();
                                        String email = Movies.people.getEmail().trim();
                                        String phone_number = Movies.people.getPhone_number().trim();
                                        int member = Movies.people.getMember();
                                        String password = Movies.people.getPassword().trim();
                                        String fileName = "database/client/" + name + ".txt";
                                        PrintWriter output = new PrintWriter(fileName);
                                        output.println(id);
                                        output.println(name);
                                        output.println(email);
                                        output.println(phone_number);
                                        output.println(member);
                                        output.println(final_money);
                                        output.println(password);
                                        output.close();
                                        JOptionPane.showMessageDialog(null, "Payment successfully \nYour left MYR" + decimal.format(final_money), "Congrats", JOptionPane.INFORMATION_MESSAGE, icon);
                                        Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                        //Receipt
                                        try {
                                            Date time = new Date();
                                            String receipt = "Amount : MYR" + decimal.format(first_amount) + "\n" + movie1.toString() + "\n___________________________________________________________________\n\n";
                                            File secondFile = new File("database/receipt/" + name + ".txt");
                                            FileOutputStream fos = new FileOutputStream(secondFile, true);
                                            fos.write(receipt.getBytes());
                                        } catch (IOException e) {
                                        }
                                        String movie = "database/movie/" + name + "/H_R" + passData + ".txt";
                                        File moviefile = new File(movie);
                                        moviefile.createNewFile();
                                        PrintWriter time_rent = new PrintWriter(movie);
                                        time_rent.println(rent_time);
                                        time_rent.close();
                                        S_show = false;
                                        H_show = false;
                                        S_R_show = false;
                                        H_R_show = false;
                                        historyPage();
                                    } catch (FileNotFoundException z) {
                                    } catch (Exception z) {
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sorry Process Failed ! Money Not Enough", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            } else if (!passwordcheck7.trim().equals(Movies.people.getPassword().trim())) {
                                if (nothing.equals("yes")) {
                                    JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        );
        update.setOnMouseEntered(c
                -> {
            update.setStyle("-fx-background-color: #94b447");
            update.setEffect(new DropShadow());
        }
        );
        update.setOnMouseExited(c
                -> {
            update.setEffect(null);
            update.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        }
        );
        reload.setOnMouseEntered(c
                -> {
            reload.setStyle("-fx-background-color: #94b447");
            reload.setEffect(new DropShadow());
        }
        );
        reload.setOnMouseExited(c
                -> {
            reload.setEffect(null);
            reload.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        }
        );
        memberchange.setOnMouseEntered(c
                -> {
            memberchange.setStyle("-fx-background-color: #94b447");
            memberchange.setEffect(new DropShadow());
        }
        );
        memberchange.setOnMouseExited(c
                -> {
            memberchange.setEffect(null);
            memberchange.setStyle("-fx-background-color: #CBE54E;-fx-text-fill: #5D6E1E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;");
        }
        );
        update.setOnAction(d
                -> {
            int select = JOptionPane.showConfirmDialog(null, "Did You Want Update Your Profile Data?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
            if (select == 0) {
                Dialog<String> dialog3 = new Dialog<>();
                dialog3.setTitle("Movies");
                dialog3.setHeaderText("Secure Authentication");
                dialog3.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                Stage dialogStage3 = (Stage) dialog3.getDialogPane().getScene().getWindow();
                dialogStage3.getIcons().add(ApplicationIcon);

                DIALOG_HEADER_ICON.setFitHeight(48);
                DIALOG_HEADER_ICON.setFitWidth(48);
                dialog3.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                PasswordField pwd3 = new PasswordField();
                HBox content = new HBox();
                content.setAlignment(Pos.CENTER_LEFT);
                content.setSpacing(10);
                content.getChildren().addAll(new Label("Enter Your Password :"), pwd3);
                dialog3.getDialogPane().setContent(content);
                dialog3.setResultConverter(dialogButton3 -> {
                    if (dialogButton3 == ButtonType.OK) {
                        return pwd3.getText();
                    }
                    return null;
                });
                String nothing = "no";
                String passwordcheck3 = "";
                Optional<String> result3 = dialog3.showAndWait();
                if (result3.isPresent()) {
                    passwordcheck3 = result3.get();
                } else {
                    nothing = "yes";
                }
                if (passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                    Dialog<String> dialog4 = new Dialog<>();
                    dialog4.setTitle("Profile Detail");
                    dialog4.setHeaderText(" ");
                    ButtonType updateButtonType = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
                    dialog4.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);
                    Stage dialogStage4 = (Stage) dialog4.getDialogPane().getScene().getWindow();
                    dialogStage4.getIcons().add(ApplicationIcon);

                    HBox update_name_row = new HBox();
                    HBox update_email_row = new HBox();
                    HBox update_phone_row = new HBox();
                    HBox update_password_row = new HBox();
                    HBox update_repeatpassword_row = new HBox();
                    TextField update_email = new TextField();
                    update_email.setPrefSize(150, 10);
                    update_email.setPromptText("email@example.com");
                    TextField update_phone = new TextField();
                    update_phone.setPrefSize(150, 10);
                    update_phone.setPromptText("ex. 000-0000000");
                    PasswordField update_password = new PasswordField();
                    update_password.setPrefSize(150, 10);
                    update_password.setPromptText("Reset your password");
                    PasswordField update_repeatpassword = new PasswordField();
                    update_repeatpassword.setPrefSize(150, 10);
                    update_repeatpassword.setPromptText("Retype Password");

                    update_name_row.getChildren().addAll(new Label("Your Name :         " + Movies.people.getName()));
                    update_email_row.getChildren().addAll(new Label("Your New Email :                           "), update_email);
                    update_phone_row.getChildren().addAll(new Label("Your New Phone Number :            "), update_phone);
                    update_password_row.getChildren().addAll(new Label("Your New Password :                     "), update_password);
                    update_repeatpassword_row.getChildren().addAll(new Label("Please Repeat Your Password :     "), update_repeatpassword);
                    update_name_row.setSpacing(10);
                    update_email_row.setSpacing(10);
                    update_phone_row.setSpacing(10);
                    update_password_row.setSpacing(10);
                    update_repeatpassword_row.setSpacing(10);

                    VBox content4 = new VBox();
                    content4.setAlignment(Pos.CENTER_LEFT);
                    content4.setSpacing(10);
                    content4.getChildren().addAll(update_name_row, update_email_row, update_phone_row, update_password_row, update_repeatpassword_row);
                    Node updateButton = dialog4.getDialogPane().lookupButton(updateButtonType);
                    updateButton.setDisable(true);
                    update_repeatpassword.textProperty().addListener((observable, oldValue, newValue) -> {
                        updateButton.setDisable(newValue.isEmpty());
                    });
                    dialog4.getDialogPane().setContent(content4);
                    dialog4.setResultConverter(dialogButton4 -> {
                        if (dialogButton4 == updateButtonType) {
                            if (!validEmail(update_email.getText())) {
                                JOptionPane.showMessageDialog(null, "Process Failed ! Email Format Unceptable", "Warning !", JOptionPane.WARNING_MESSAGE);
                                dialog4.getOnShowing();
                                return "ok";
                            } else if (!validPhoneNumber(update_phone.getText()) && !validPhoneNumber2(update_phone.getText()) && !validPhoneNumber3(update_phone.getText()) && !validPhoneNumber4(update_phone.getText())) {
                                JOptionPane.showMessageDialog(null, "Process Failed ! Phone Number Format Unceptable", "Warning !", JOptionPane.WARNING_MESSAGE);
                                return "ok";
                            } else if (!update_password.getText().equals(update_repeatpassword.getText())) {
                                JOptionPane.showMessageDialog(null, "Process Failed ! Password Not Match", "Warning !", JOptionPane.WARNING_MESSAGE);
                                return "ok";
                            } else {
                                emailfield = update_email.getText();
                                numberfield = update_phone.getText();
                                passwordfield = update_password.getText();
                                passwordfield2 = update_repeatpassword.getText();
                                return "get";
                            }
                        }
                        if (dialogButton4 == ButtonType.CANCEL) {
                            return "Cancel";
                        }
                        return "ok";
                    });
                    String ok = "";
                    Optional<String> Profile_data = dialog4.showAndWait();
                    if (Profile_data.isPresent()) {
                        ok = Profile_data.get();
                    }
                    if (ok.equals("get")) {
                        try {
                            String id = Movies.people.getId().trim();
                            String name = Movies.people.getName().trim();
                            String email = emailfield;
                            String phone_number = numberfield;
                            int member = Movies.people.getMember();
                            String password = passwordfield;
                            double amount = Movies.people.getAmount();
                            String fileName = "database/client/" + name + ".txt";
                            PrintWriter output = new PrintWriter(fileName);
                            output.println(id);
                            output.println(name);
                            output.println(email);
                            output.println(phone_number);
                            output.println(member);
                            output.println(amount);
                            output.println(password);
                            output.close();
                            JOptionPane.showMessageDialog(null, "Update Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                            Movies.people = new client(name, id, phone_number, email, password, member, amount);
                            SecondPage();
                        } catch (FileNotFoundException z) {
                        }
                    } else if (ok.equals("ok")) {
                        emailfield = "";
                        numberfield = "";
                        passwordfield = "";
                        passwordfield2 = "";
                    } else if (ok.equals("Cancel")) {
                        JOptionPane.showMessageDialog(null, "Cancel Succesful", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }

                } else if (!passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                    if (nothing.equals("yes")) {
                        JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry Password Wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Process Cancel", "Warning !", JOptionPane.WARNING_MESSAGE);
            }
        }
        );

        reload.setOnAction(d
                -> {
            int select = JOptionPane.showConfirmDialog(null, "Did you want to reload ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
            if (select == 0) {
                Dialog<String> dialog3 = new Dialog<>();
                dialog3.setTitle("Movies");
                dialog3.setHeaderText("Secure Authentication");
                dialog3.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                Stage dialogStage3 = (Stage) dialog3.getDialogPane().getScene().getWindow();
                dialogStage3.getIcons().add(ApplicationIcon);

                DIALOG_HEADER_ICON.setFitHeight(48);
                DIALOG_HEADER_ICON.setFitWidth(48);
                dialog3.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                PasswordField pwd3 = new PasswordField();
                HBox content = new HBox();
                content.setAlignment(Pos.CENTER_LEFT);
                content.setSpacing(10);
                content.getChildren().addAll(new Label("Enter Your Password :"), pwd3);
                dialog3.getDialogPane().setContent(content);
                dialog3.setResultConverter(dialogButton3 -> {
                    if (dialogButton3 == ButtonType.OK) {
                        return pwd3.getText();
                    }
                    return null;
                });
                String nothing = "no";
                String passwordcheck3 = "";
                Optional<String> result3 = dialog3.showAndWait();
                if (result3.isPresent()) {
                    passwordcheck3 = result3.get();
                } else {
                    nothing = "yes";
                }
                if (passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                    Dialog<String> dialog4 = new Dialog<>();
                    dialog4.setTitle("Movies Payment");
                    dialog4.setHeaderText(" ");
                    dialog4.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                    Stage dialogStage4 = (Stage) dialog4.getDialogPane().getScene().getWindow();
                    dialogStage4.getIcons().add(ApplicationIcon);

                    TextField cash2 = new TextField();
                    HBox content4 = new HBox();
                    content4.setAlignment(Pos.CENTER_LEFT);
                    content4.setSpacing(10);
                    content4.getChildren().addAll(new Label("How Mush Did You Want To Reload :"), cash2);
                    dialog4.getDialogPane().setContent(content4);
                    dialog4.setResultConverter(dialogButton4 -> {
                        if (dialogButton4 == ButtonType.OK) {
                            return cash2.getText();
                        }
                        return null;
                    });
                    String notok = "ok";
                    double amount2 = 0;
                    Optional<String> reload_money2 = dialog4.showAndWait();
                    if (reload_money2.isPresent()) {
                        amount2 = new Double(reload_money2.get());
                    } else {
                        notok = "not ok";
                    }
                    double first = Movies.people.getAmount();
                    Double left_money = new Double(Movies.people.getAmount());
                    Double final_money = amount2 + left_money;
                    try {
                        if (amount2 <= -1 || amount2 <= 0 || amount2 >= 1000000) {
                            JOptionPane.showMessageDialog(null, "Reload Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else if (notok.equals("not ok")) {
                            JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        } else {
                            try {
                                String id = Movies.people.getId().trim();
                                String name = Movies.people.getName().trim();
                                String email = Movies.people.getEmail().trim();
                                String phone_number = Movies.people.getPhone_number().trim();
                                int member = Movies.people.getMember();
                                String password = Movies.people.getPassword().trim();
                                String fileName = "database/client/" + name + ".txt";
                                PrintWriter output = new PrintWriter(fileName);
                                output.println(id);
                                output.println(name);
                                output.println(email);
                                output.println(phone_number);
                                output.println(member);
                                output.println(final_money);
                                output.println(password);
                                output.close();
                                JOptionPane.showMessageDialog(null, "Reload Successfully", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
                                Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                //Receipt
                                try {
                                    Date time = new Date();
                                    String receipt = "The Amount MYR " + first + "\nReload MYR " + amount2 + "\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                    File secondFile = new File("database/receipt/" + name + ".txt");
                                    FileOutputStream fos = new FileOutputStream(secondFile, true);
                                    fos.write(receipt.getBytes());
                                } catch (IOException e) {
                                }
                                historyPage();
                            } catch (FileNotFoundException z) {
                            }
                        }
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "Format Must Be Number", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (!passwordcheck3.trim().equals(Movies.people.getPassword().trim())) {
                    if (nothing.equals("yes")) {
                        JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry password wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                }
                //
            } else {
                JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
            }
        }
        );

        memberchange.setOnAction(d
                -> {
            int select = JOptionPane.showConfirmDialog(null, "Did You want to become member ?", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
            if (select == 0) {
                Dialog<String> dialog5 = new Dialog<>();
                dialog5.setTitle("Movies Member");
                dialog5.setHeaderText("Secure Authentication");
                dialog5.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                Stage dialogStage5 = (Stage) dialog5.getDialogPane().getScene().getWindow();
                dialogStage5.getIcons().add(ApplicationIcon);

                DIALOG_HEADER_ICON.setFitHeight(48);
                DIALOG_HEADER_ICON.setFitWidth(48);
                dialog5.getDialogPane().setGraphic(DIALOG_HEADER_ICON);
                PasswordField pwd5 = new PasswordField();
                HBox content5 = new HBox();
                content5.setAlignment(Pos.CENTER_LEFT);
                content5.setSpacing(10);
                content5.getChildren().addAll(new Label("Enter Your Password :"), pwd5);
                dialog5.getDialogPane().setContent(content5);
                dialog5.setResultConverter(dialogButton5 -> {
                    if (dialogButton5 == ButtonType.OK) {
                        return pwd5.getText();
                    }
                    return null;
                });
                String nothing = "no";
                String passwordcheck5 = "";
                Optional<String> result5 = dialog5.showAndWait();
                if (result5.isPresent()) {
                    passwordcheck5 = result5.get();
                } else {
                    nothing = "yes";
                }
                if (passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                    if (Movies.people.getAmount() < 15) {
                        JOptionPane.showMessageDialog(null, "Amount Not Enough Money \nPlease Reload First", "Warning !", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int confirm_Member1 = JOptionPane.showConfirmDialog(null, "Did You Want To Become Member?\nYou Be Change MYR15", "Movies", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                        if (confirm_Member1 == 0) {
                            double first = Movies.people.getAmount();
                            double final_money = Movies.people.getAmount() - 15;
                            try {
                                String id = Movies.people.getId().trim();
                                String name = Movies.people.getName().trim();
                                String email = Movies.people.getEmail().trim();
                                String phone_number = Movies.people.getPhone_number().trim();
                                int member = 1;
                                String password = Movies.people.getPassword().trim();
                                String fileName = "database/client/" + name + ".txt";
                                PrintWriter output = new PrintWriter(fileName);
                                output.println(id);
                                output.println(name);
                                output.println(email);
                                output.println(phone_number);
                                output.println(member);
                                output.println(final_money);
                                output.println(password);
                                output.close();
                                JOptionPane.showMessageDialog(null, "You Are Member Now", "Congrats", JOptionPane.WARNING_MESSAGE);
                                Movies.people = new client(name, id, phone_number, email, password, member, final_money);
                                //Receipt
                                try {
                                    Date time = new Date();
                                    String receipt = "The Amount MYR " + first + "\nMember Fee MYR 15\nAmount left " + final_money + "\nDate : " + time + "\n___________________________________________________________________\n\n";
                                    File secondFile = new File("database/receipt/" + name + ".txt");
                                    FileOutputStream fos = new FileOutputStream(secondFile, true);
                                    fos.write(receipt.getBytes());
                                } catch (IOException e) {
                                }
                                historyPage();
                            } catch (FileNotFoundException z) {
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else if (!passwordcheck5.trim().equals(Movies.people.getPassword().trim())) {
                    if (nothing.equals("yes")) {
                        JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry password wrong !", "Warning !", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Process Failed", "Warning !", JOptionPane.WARNING_MESSAGE);
            }
        }
        );
    }

    public void SecondPage() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        VBox lineBeutfly = new VBox();
        StackPane menu = new StackPane();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);

        top1.getChildren().addAll(ActionName);
        mA.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        center.getChildren().addAll(RomaticName, line2);
        mR.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        HistoryName.setFill(Color.YELLOWGREEN);
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu, mA, mC, mD, mH, mR, mProfile, mHistory, mlogn_out);
        column.setSpacing(20);

        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        VBox rightBase = new VBox();
        searchBar.setPadding(new Insets(10, 0, 10, 30));
        searchBar.setStyle("-fx-background-color:#F0FFF0;-fx-background-radius: 30px;");
        HBox searchline = new HBox();
        searchText.setPromptText("                                                       Search ... ");
        searchText.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        searchText.setPrefSize(500, 40);
        searchline.getChildren().addAll(searchText);
        searchBar.getChildren().addAll(searchline);
        ScrollPane sp = new ScrollPane();
        VBox Allrow = new VBox();
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();
        HBox row4 = new HBox();
        HBox row5 = new HBox();
        HBox row6 = new HBox();
        HBox row7 = new HBox();
        HBox row8 = new HBox();
        HBox row9 = new HBox();

        VBox one = new VBox();
        images[0] = new Image(imageData[0]);
        pics[0] = new ImageView(images[0]);
        Text a1 = new Text(MovieName[0]);
        a1.setFont(Font.font("Segoe UI Semibold", 15));
        one.getChildren().addAll(pics[0], a1);
        this.movie_0.getChildren().add(one);

        VBox two = new VBox();
        images[1] = new Image(imageData[1]);
        pics[1] = new ImageView(images[1]);
        Text a2 = new Text(MovieName[1]);
        a2.setFont(Font.font("Segoe UI Semibold", 15));
        two.getChildren().addAll(pics[1], a2);
        this.movie_1.getChildren().add(two);

        VBox three = new VBox();
        images[2] = new Image(imageData[2]);
        pics[2] = new ImageView(images[2]);
        Text a3 = new Text(MovieName[2]);
        a3.setFont(Font.font("Segoe UI Semibold", 15));
        three.getChildren().addAll(pics[2], a3);
        this.movie_2.getChildren().add(three);

        row1.getChildren().addAll(this.movie_0, this.movie_1, this.movie_2);
        row1.setSpacing(43);

        VBox four = new VBox();
        images[3] = new Image(imageData[3]);
        pics[3] = new ImageView(images[3]);
        Text a4 = new Text(MovieName[3]);
        a4.setFont(Font.font("Segoe UI Semibold", 15));
        four.getChildren().addAll(pics[3], a4);
        this.movie_3.getChildren().add(four);

        VBox five = new VBox();
        images[4] = new Image(imageData[4]);
        pics[4] = new ImageView(images[4]);
        Text a5 = new Text(MovieName[4]);
        a5.setFont(Font.font("Segoe UI Semibold", 15));
        five.getChildren().addAll(pics[4], a5);
        this.movie_4.getChildren().add(five);

        VBox six = new VBox();
        images[5] = new Image(imageData[5]);
        pics[5] = new ImageView(images[5]);
        Text a6 = new Text(MovieName[5]);
        a6.setFont(Font.font("Segoe UI Semibold", 15));
        six.getChildren().addAll(pics[5], a6);
        this.movie_5.getChildren().add(six);

        row2.getChildren().addAll(this.movie_3, this.movie_4, this.movie_5);
        row2.setSpacing(43);

        VBox seven = new VBox();
        images[6] = new Image(imageData[6]);
        pics[6] = new ImageView(images[6]);
        Text a7 = new Text(MovieName[6]);
        a7.setFont(Font.font("Segoe UI Semibold", 15));
        seven.getChildren().addAll(pics[6], a7);
        this.movie_6.getChildren().add(seven);

        VBox eight = new VBox();
        images[7] = new Image(imageData[7]);
        pics[7] = new ImageView(images[7]);
        Text a8 = new Text(MovieName[7]);
        a8.setFont(Font.font("Segoe UI Semibold", 15));
        eight.getChildren().addAll(pics[7], a8);
        this.movie_7.getChildren().add(eight);

        VBox night = new VBox();
        images[8] = new Image(imageData[8]);
        pics[8] = new ImageView(images[8]);
        Text a9 = new Text(MovieName[8]);
        a9.setFont(Font.font("Segoe UI Semibold", 15));
        night.getChildren().addAll(pics[8], a9);
        this.movie_8.getChildren().add(night);

        row3.getChildren().addAll(movie_6, movie_7, movie_8);
        row3.setSpacing(30);

        VBox ten = new VBox();
        images[9] = new Image(imageData[9]);
        pics[9] = new ImageView(images[9]);
        Text a10 = new Text(MovieName[9]);
        a10.setFont(Font.font("Segoe UI Semibold", 15));
        ten.getChildren().addAll(pics[9], a10);
        this.movie_9.getChildren().add(ten);

        VBox eleven = new VBox();
        images[10] = new Image(imageData[10]);
        pics[10] = new ImageView(images[10]);
        Text a11 = new Text(MovieName[10]);
        a11.setFont(Font.font("Segoe UI Semibold", 15));
        eleven.getChildren().addAll(pics[10], a11);
        this.movie_10.getChildren().add(eleven);

        VBox twenth = new VBox();
        images[11] = new Image(imageData[11]);
        pics[11] = new ImageView(images[11]);
        Text a12 = new Text(MovieName[11]);
        a12.setFont(Font.font("Segoe UI Semibold", 15));
        twenth.getChildren().addAll(pics[11], a12);
        this.movie_11.getChildren().add(twenth);

        row4.getChildren().addAll(this.movie_9, this.movie_10, this.movie_11);
        row4.setSpacing(25);

        VBox thirth = new VBox();
        images[12] = new Image(imageData[12]);
        pics[12] = new ImageView(images[12]);
        Text a13 = new Text(MovieName[12]);
        a13.setFont(Font.font("Segoe UI Semibold", 13));
        thirth.getChildren().addAll(pics[12], a13);
        this.movie_12.getChildren().add(thirth);

        VBox fourth = new VBox();
        images[13] = new Image(imageData[13]);
        pics[13] = new ImageView(images[13]);
        Text a14 = new Text(MovieName[13]);
        a14.setFont(Font.font("Segoe UI Semibold", 15));
        fourth.getChildren().addAll(pics[13], a14);
        this.movie_13.getChildren().add(fourth);

        VBox fiveth = new VBox();
        images[14] = new Image(imageData[14]);
        pics[14] = new ImageView(images[14]);
        Text a15 = new Text(MovieName[14]);
        a15.setFont(Font.font("Segoe UI Semibold", 15));
        fiveth.getChildren().addAll(pics[14], a15);
        this.movie_14.getChildren().add(fiveth);

        row5.getChildren().addAll(this.movie_12, this.movie_13, this.movie_14);
        row5.setSpacing(25);

        VBox sixth = new VBox();
        images[15] = new Image(imageData[15]);
        pics[15] = new ImageView(images[15]);
        Text a16 = new Text(MovieName[15]);
        a16.setFont(Font.font("Segoe UI Semibold", 15));
        sixth.getChildren().addAll(pics[15], a16);
        this.movie_15.getChildren().add(sixth);

        VBox seventh = new VBox();
        images[16] = new Image(imageData[16]);
        pics[16] = new ImageView(images[16]);
        Text a17 = new Text(MovieName[16]);
        a17.setFont(Font.font("Segoe UI Semibold", 15));
        seventh.getChildren().addAll(pics[16], a17);
        this.movie_16.getChildren().add(seventh);

        VBox eightth = new VBox();
        images[17] = new Image(imageData[17]);
        pics[17] = new ImageView(images[17]);
        Text a18 = new Text(MovieName[17]);
        a18.setFont(Font.font("Segoe UI Semibold", 15));
        eightth.getChildren().addAll(pics[17], a18);
        this.movie_17.getChildren().add(eightth);

        row6.getChildren().addAll(this.movie_15, this.movie_16, this.movie_17);
        row6.setSpacing(25);

        VBox nineth = new VBox();
        images[18] = new Image(imageData[18]);
        pics[18] = new ImageView(images[18]);
        Text a19 = new Text(MovieName[18]);
        a19.setFont(Font.font("Segoe UI Semibold", 15));
        nineth.getChildren().addAll(pics[18], a19);
        this.movie_18.getChildren().add(nineth);

        VBox twenty = new VBox();
        images[19] = new Image(imageData[19]);
        pics[19] = new ImageView(images[19]);
        Text a20 = new Text(MovieName[19]);
        a20.setFont(Font.font("Segoe UI Semibold", 15));
        twenty.getChildren().addAll(pics[19], a20);
        this.movie_19.getChildren().add(twenty);

        VBox twenty_one = new VBox();
        images[20] = new Image(imageData[20]);
        pics[20] = new ImageView(images[20]);
        Text a21 = new Text(MovieName[20]);
        a21.setFont(Font.font("Segoe UI Semibold", 15));
        twenty_one.getChildren().addAll(pics[20], a21);
        this.movie_20.getChildren().add(twenty_one);

        row7.getChildren().addAll(this.movie_18, this.movie_19, this.movie_20);
        row7.setSpacing(25);

        VBox twenty_two = new VBox();
        images[21] = new Image(imageData[21]);
        pics[21] = new ImageView(images[21]);
        Text a22 = new Text(MovieName[21]);
        a22.setFont(Font.font("Segoe UI Semibold", 15));
        twenty_two.getChildren().addAll(pics[21], a22);
        this.movie_21.getChildren().add(twenty_two);

        VBox twenty_three = new VBox();
        images[22] = new Image(imageData[22]);
        pics[22] = new ImageView(images[22]);
        Text a23 = new Text(MovieName[22]);
        a23.setFont(Font.font("Segoe UI Semibold", 15));
        twenty_three.getChildren().addAll(pics[22], a23);
        this.movie_22.getChildren().add(twenty_three);

        VBox twenty_four = new VBox();
        images[23] = new Image(imageData[23]);
        pics[23] = new ImageView(images[23]);
        Text a24 = new Text(MovieName[23]);
        a24.setFont(Font.font("Segoe UI Semibold", 12));
        twenty_four.getChildren().addAll(pics[23], a24);
        this.movie_23.getChildren().add(twenty_four);

        row8.getChildren().addAll(this.movie_21, this.movie_22, this.movie_23);
        row8.setSpacing(25);

        VBox twenty_five = new VBox();
        images[24] = new Image(imageData[24]);
        pics[24] = new ImageView(images[24]);
        Text a25 = new Text(MovieName[24]);
        a25.setFont(Font.font("Segoe UI Semibold", 15));
        twenty_five.getChildren().addAll(pics[24], a25);
        this.movie_24.getChildren().add(twenty_five);

        row9.getChildren().addAll(this.movie_24);

        for (int i = 0; i < 25; i++) {
            pics[i].setFitWidth(260);
            pics[i].setFitHeight(250);
            pics[i].setPreserveRatio(true);
        }
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Allrow.getChildren().addAll(row1, row2, row3, row4, row5, row6, row7, row8, row9);
        sp.setPrefViewportHeight(500);
        sp.setMaxWidth(600);
        sp.setMinViewportHeight(500);
        sp.setContent(Allrow);
        sp.setStyle("-fx-background-color: transparent;-fx-focus-color: transparent;");
        main.setPadding(new Insets(0, 500, 0, 100));
        rightBase.getChildren().addAll(searchBar, main, sp);

        rightBase.setSpacing(30);
        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(40, 200, 400, 100));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void ActionPage() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        StackPane mA1 = new StackPane();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        VBox lineBeutfly = new VBox();
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu1.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);
        top1.getChildren().addAll(ActionName);
        mA1.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC1.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD1.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH1.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        center.getChildren().addAll(RomaticName, line2);
        mR1.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile1.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        HistoryName.setFill(Color.YELLOWGREEN);
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory1.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out1.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu1, mA1, mC1, mD1, mH1, mR1, mProfile1, mHistory1, mlogn_out1);
        column.setSpacing(20);

        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        VBox rightBase = new VBox();
        searchBar.setPadding(new Insets(10, 0, 10, 30));
        searchBar.setStyle("-fx-background-color:#F0FFF0;-fx-background-radius: 30px;");
        HBox searchline = new HBox();
        searchText.setPromptText("                                                       Search ... ");
        searchText.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        searchText.setPrefSize(500, 40);
        searchline.getChildren().addAll(searchText);
        searchBar.getChildren().addAll(searchline);
        ScrollPane sp = new ScrollPane();
        VBox Allrow = new VBox();
        HBox row1 = new HBox();
        HBox row2 = new HBox();

        VBox one = new VBox();
        images[0] = new Image(imageData[0]);
        pics[0] = new ImageView(images[0]);
        Text a1 = new Text(MovieName[0]);
        a1.setFont(Font.font("Segoe UI Semibold", 15));
        one.getChildren().addAll(pics[0], a1);
        this.movie_0.getChildren().add(one);

        VBox two = new VBox();
        images[1] = new Image(imageData[1]);
        pics[1] = new ImageView(images[1]);
        Text a2 = new Text(MovieName[1]);
        a2.setFont(Font.font("Segoe UI Semibold", 15));
        two.getChildren().addAll(pics[1], a2);
        this.movie_1.getChildren().add(two);

        VBox three = new VBox();
        images[2] = new Image(imageData[2]);
        pics[2] = new ImageView(images[2]);
        Text a3 = new Text(MovieName[2]);
        a3.setFont(Font.font("Segoe UI Semibold", 15));
        three.getChildren().addAll(pics[2], a3);
        this.movie_2.getChildren().add(three);

        row1.getChildren().addAll(this.movie_0, this.movie_1, this.movie_2);
        row1.setSpacing(43);

        VBox four = new VBox();
        images[3] = new Image(imageData[3]);
        pics[3] = new ImageView(images[3]);
        Text a4 = new Text(MovieName[3]);
        a4.setFont(Font.font("Segoe UI Semibold", 15));
        four.getChildren().addAll(pics[3], a4);
        this.movie_3.getChildren().add(four);

        VBox five = new VBox();
        images[4] = new Image(imageData[4]);
        pics[4] = new ImageView(images[4]);
        Text a5 = new Text(MovieName[4]);
        a5.setFont(Font.font("Segoe UI Semibold", 15));
        five.getChildren().addAll(pics[4], a5);
        this.movie_4.getChildren().add(five);

        row2.getChildren().addAll(this.movie_3, this.movie_4);
        row2.setSpacing(43);

        for (int i = 0; i < 5; i++) {
            pics[i].setFitWidth(260);
            pics[i].setFitHeight(250);
            pics[i].setPreserveRatio(true);
        }
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Allrow.getChildren().addAll(row1, row2);
        sp.setPrefViewportHeight(500);
        sp.setMaxWidth(600);
        sp.setMinViewportHeight(500);
        sp.setContent(Allrow);
        sp.setStyle("-fx-background-color: transparent;-fx-focus-color: transparent;");

        main.setPadding(new Insets(0, 500, 0, 100));
        rightBase.getChildren().addAll(searchBar, main, sp);

        rightBase.setSpacing(30);
        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(40, 200, 400, 100));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void ComedyPage() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        StackPane mC2 = new StackPane();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        VBox lineBeutfly = new VBox();
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu2.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);
        top1.getChildren().addAll(ActionName);
        mA2.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC2.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD2.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH2.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        center.getChildren().addAll(RomaticName, line2);
        mR2.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile2.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        HistoryName.setFill(Color.YELLOWGREEN);
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory2.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out2.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu2, mA2, mC2, mD2, mH2, mR2, mProfile2, mHistory2, mlogn_out2);
        column.setSpacing(20);

        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        VBox rightBase = new VBox();
        searchBar.setPadding(new Insets(10, 0, 10, 30));
        searchBar.setStyle("-fx-background-color:#F0FFF0;-fx-background-radius: 30px;");
        HBox searchline = new HBox();
        searchText.setPromptText("                                                       Search ... ");
        searchText.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        searchText.setPrefSize(500, 40);
        searchline.getChildren().addAll(searchText);
        searchBar.getChildren().addAll(searchline);
        ScrollPane sp = new ScrollPane();
        VBox Allrow = new VBox();

        HBox row2 = new HBox();
        HBox row3 = new HBox();

        VBox four = new VBox();
        images[5] = new Image(imageData[5]);
        pics[5] = new ImageView(images[5]);
        Text a6 = new Text(MovieName[5]);
        a6.setFont(Font.font("Segoe UI Semibold", 15));
        four.getChildren().addAll(pics[5], a6);
        this.movie_5.getChildren().add(four);

        VBox five = new VBox();
        images[6] = new Image(imageData[6]);
        pics[6] = new ImageView(images[6]);
        Text a7 = new Text(MovieName[6]);
        a7.setFont(Font.font("Segoe UI Semibold", 15));
        five.getChildren().addAll(pics[6], a7);
        this.movie_6.getChildren().add(five);

        VBox six = new VBox();
        images[7] = new Image(imageData[7]);
        pics[7] = new ImageView(images[7]);
        Text a8 = new Text(MovieName[7]);
        a8.setFont(Font.font("Segoe UI Semibold", 15));
        six.getChildren().addAll(pics[7], a8);
        this.movie_7.getChildren().add(six);

        row2.getChildren().addAll(this.movie_5, this.movie_6, this.movie_7);
        row2.setSpacing(30);

        VBox seven = new VBox();
        images[8] = new Image(imageData[8]);
        pics[8] = new ImageView(images[8]);
        Text a9 = new Text(MovieName[8]);
        a9.setFont(Font.font("Segoe UI Semibold", 15));
        seven.getChildren().addAll(pics[8], a9);
        this.movie_8.getChildren().add(seven);

        VBox eight = new VBox();
        images[9] = new Image(imageData[9]);
        pics[9] = new ImageView(images[9]);
        Text a10 = new Text(MovieName[9]);
        a10.setFont(Font.font("Segoe UI Semibold", 15));
        eight.getChildren().addAll(pics[9], a10);
        this.movie_9.getChildren().add(eight);

        row3.getChildren().addAll(this.movie_8, this.movie_9);
        row3.setSpacing(30);

        for (int i = 5; i < 10; i++) {
            pics[i].setFitWidth(260);
            pics[i].setFitHeight(250);
            pics[i].setPreserveRatio(true);
        }
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Allrow.getChildren().addAll(row2, row3);
        sp.setPrefViewportHeight(500);
        sp.setMaxWidth(600);
        sp.setMinViewportHeight(500);
        sp.setContent(Allrow);
        sp.setStyle("-fx-background-color: transparent;-fx-focus-color: transparent;");

        main.setPadding(new Insets(0, 500, 0, 100));
        rightBase.getChildren().addAll(searchBar, main, sp);

        rightBase.setSpacing(30);
        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(40, 200, 400, 100));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void DramaPage() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        StackPane mD3 = new StackPane();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        VBox lineBeutfly = new VBox();
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu3.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);
        top1.getChildren().addAll(ActionName);
        mA3.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC3.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD3.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH3.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        center.getChildren().addAll(RomaticName, line2);
        mR3.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile3.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        HistoryName.setFill(Color.YELLOWGREEN);
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory3.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out3.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu3, mA3, mC3, mD3, mH3, mR3, mProfile3, mHistory3, mlogn_out3);
        column.setSpacing(20);

        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        VBox rightBase = new VBox();
        searchBar.setPadding(new Insets(10, 0, 10, 30));
        searchBar.setStyle("-fx-background-color:#F0FFF0;-fx-background-radius: 30px;");
        HBox searchline = new HBox();
        searchText.setPromptText("                                                       Search ... ");
        searchText.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        searchText.setPrefSize(500, 40);
        searchline.getChildren().addAll(searchText);
        searchBar.getChildren().addAll(searchline);
        ScrollPane sp = new ScrollPane();
        VBox Allrow = new VBox();

        HBox row4 = new HBox();
        HBox row5 = new HBox();

        VBox eleven = new VBox();
        images[10] = new Image(imageData[10]);
        pics[10] = new ImageView(images[10]);
        Text a11 = new Text(MovieName[10]);
        a11.setFont(Font.font("Segoe UI Semibold", 15));
        eleven.getChildren().addAll(pics[10], a11);
        this.movie_10.getChildren().add(eleven);

        VBox twenth = new VBox();
        images[11] = new Image(imageData[11]);
        pics[11] = new ImageView(images[11]);
        Text a12 = new Text(MovieName[11]);
        a12.setFont(Font.font("Segoe UI Semibold", 15));
        twenth.getChildren().addAll(pics[11], a12);
        this.movie_11.getChildren().add(twenth);

        VBox thirth = new VBox();
        images[12] = new Image(imageData[12]);
        pics[12] = new ImageView(images[12]);
        Text a13 = new Text(MovieName[12]);
        a13.setFont(Font.font("Segoe UI Semibold", 13));
        thirth.getChildren().addAll(pics[12], a13);
        this.movie_12.getChildren().add(thirth);

        row4.getChildren().addAll(this.movie_10, this.movie_11, this.movie_12);
        row4.setSpacing(30);

        VBox fourth = new VBox();
        images[13] = new Image(imageData[13]);
        pics[13] = new ImageView(images[13]);
        Text a14 = new Text(MovieName[13]);
        a14.setFont(Font.font("Segoe UI Semibold", 15));
        fourth.getChildren().addAll(pics[13], a14);
        this.movie_13.getChildren().add(fourth);

        VBox fiveth = new VBox();
        images[14] = new Image(imageData[14]);
        pics[14] = new ImageView(images[14]);
        Text a15 = new Text(MovieName[14]);
        a15.setFont(Font.font("Segoe UI Semibold", 15));
        fiveth.getChildren().addAll(pics[14], a15);
        this.movie_14.getChildren().add(fiveth);

        row5.getChildren().addAll(this.movie_13, this.movie_14);
        row5.setSpacing(25);

        for (int i = 10; i < 15; i++) {
            pics[i].setFitWidth(260);
            pics[i].setFitHeight(250);
            pics[i].setPreserveRatio(true);
        }
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Allrow.getChildren().addAll(row4, row5);
        sp.setPrefViewportHeight(500);
        sp.setMaxWidth(600);
        sp.setMinViewportHeight(500);
        sp.setContent(Allrow);
        sp.setStyle("-fx-background-color: transparent;-fx-focus-color: transparent;");

        main.setPadding(new Insets(0, 500, 0, 100));
        rightBase.getChildren().addAll(searchBar, main, sp);

        rightBase.setSpacing(30);
        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(40, 200, 400, 100));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void HorrorPage() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        StackPane mH4 = new StackPane();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        VBox lineBeutfly = new VBox();
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu4.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);
        top1.getChildren().addAll(ActionName);
        mA4.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC4.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD4.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH4.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        center.getChildren().addAll(RomaticName, line2);
        mR4.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile4.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        HistoryName.setFill(Color.YELLOWGREEN);
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory4.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out4.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu4, mA4, mC4, mD4, mH4, mR4, mProfile4, mHistory4, mlogn_out4);
        column.setSpacing(20);

        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        VBox rightBase = new VBox();
        searchBar.setPadding(new Insets(10, 0, 10, 30));
        searchBar.setStyle("-fx-background-color:#F0FFF0;-fx-background-radius: 30px;");
        HBox searchline = new HBox();
        searchText.setPromptText("                                                       Search ... ");
        searchText.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        searchText.setPrefSize(500, 40);
        searchline.getChildren().addAll(searchText);
        searchBar.getChildren().addAll(searchline);
        ScrollPane sp = new ScrollPane();
        VBox Allrow = new VBox();

        HBox row6 = new HBox();
        HBox row7 = new HBox();

        VBox sixth = new VBox();
        images[15] = new Image(imageData[15]);
        pics[15] = new ImageView(images[15]);
        Text a16 = new Text(MovieName[15]);
        a16.setFont(Font.font("Segoe UI Semibold", 15));
        sixth.getChildren().addAll(pics[15], a16);
        this.movie_15.getChildren().add(sixth);

        VBox seventh = new VBox();
        images[16] = new Image(imageData[16]);
        pics[16] = new ImageView(images[16]);
        Text a17 = new Text(MovieName[16]);
        a17.setFont(Font.font("Segoe UI Semibold", 15));
        seventh.getChildren().addAll(pics[16], a17);
        this.movie_16.getChildren().add(seventh);

        VBox eightth = new VBox();
        images[17] = new Image(imageData[17]);
        pics[17] = new ImageView(images[17]);
        Text a18 = new Text(MovieName[17]);
        a18.setFont(Font.font("Segoe UI Semibold", 15));
        eightth.getChildren().addAll(pics[17], a18);
        this.movie_17.getChildren().add(eightth);

        row6.getChildren().addAll(this.movie_15, this.movie_16, this.movie_17);
        row6.setSpacing(25);

        VBox nineth = new VBox();
        images[18] = new Image(imageData[18]);
        pics[18] = new ImageView(images[18]);
        Text a19 = new Text(MovieName[18]);
        a19.setFont(Font.font("Segoe UI Semibold", 15));
        nineth.getChildren().addAll(pics[18], a19);
        this.movie_18.getChildren().add(nineth);

        VBox twenty = new VBox();
        images[19] = new Image(imageData[19]);
        pics[19] = new ImageView(images[19]);
        Text a20 = new Text(MovieName[19]);
        a20.setFont(Font.font("Segoe UI Semibold", 15));
        twenty.getChildren().addAll(pics[19], a20);
        this.movie_19.getChildren().add(twenty);

        row7.getChildren().addAll(this.movie_18, this.movie_19);
        row7.setSpacing(25);

        for (int i = 15; i < 20; i++) {
            pics[i].setFitWidth(260);
            pics[i].setFitHeight(250);
            pics[i].setPreserveRatio(true);
        }
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Allrow.getChildren().addAll(row6, row7);
        sp.setPrefViewportHeight(500);
        sp.setMaxWidth(600);
        sp.setMinViewportHeight(500);
        sp.setContent(Allrow);
        sp.setStyle("-fx-background-color: transparent;-fx-focus-color: transparent;");

        main.setPadding(new Insets(0, 500, 0, 100));
        rightBase.getChildren().addAll(searchBar, main, sp);

        rightBase.setSpacing(30);
        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(40, 200, 400, 100));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void RomaticPage() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        StackPane mR5 = new StackPane();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        VBox lineBeutfly = new VBox();
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu5.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);
        top1.getChildren().addAll(ActionName);
        mA5.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC5.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD5.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH5.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        center.getChildren().addAll(RomaticName, line2);
        mR5.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile5.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        HistoryName.setFill(Color.YELLOWGREEN);
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory5.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out5.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu5, mA5, mC5, mD5, mH5, mR5, mProfile5, mHistory5, mlogn_out5);
        column.setSpacing(20);

        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        VBox rightBase = new VBox();
        searchBar.setPadding(new Insets(10, 0, 10, 30));
        searchBar.setStyle("-fx-background-color:#F0FFF0;-fx-background-radius: 30px;");
        HBox searchline = new HBox();
        searchText.setPromptText("                                                       Search ... ");
        searchText.setStyle("-fx-focus-color: transparent;-fx-background-color: #F0FFF0;-fx-text-fill: #5D6E1E; -fx-prompt-text-fill: #556B2F;");
        searchText.setPrefSize(500, 40);
        searchline.getChildren().addAll(searchText);
        searchBar.getChildren().addAll(searchline);
        ScrollPane sp = new ScrollPane();
        VBox Allrow = new VBox();

        HBox row8 = new HBox();
        HBox row9 = new HBox();

        VBox twenty_one = new VBox();
        images[20] = new Image(imageData[20]);
        pics[20] = new ImageView(images[20]);
        Text a21 = new Text(MovieName[20]);
        a21.setFont(Font.font("Segoe UI Semibold", 15));
        twenty_one.getChildren().addAll(pics[20], a21);
        this.movie_20.getChildren().add(twenty_one);

        VBox twenty_two = new VBox();
        images[21] = new Image(imageData[21]);
        pics[21] = new ImageView(images[21]);
        Text a22 = new Text(MovieName[21]);
        a22.setFont(Font.font("Segoe UI Semibold", 15));
        twenty_two.getChildren().addAll(pics[21], a22);
        this.movie_21.getChildren().add(twenty_two);

        VBox twenty_three = new VBox();
        images[22] = new Image(imageData[22]);
        pics[22] = new ImageView(images[22]);
        Text a23 = new Text(MovieName[22]);
        a23.setFont(Font.font("Segoe UI Semibold", 15));
        twenty_three.getChildren().addAll(pics[22], a23);
        this.movie_22.getChildren().add(twenty_three);

        row8.getChildren().addAll(this.movie_20, this.movie_21, this.movie_22);
        row8.setSpacing(25);

        VBox twenty_four = new VBox();
        images[23] = new Image(imageData[23]);
        pics[23] = new ImageView(images[23]);
        Text a24 = new Text(MovieName[23]);
        a24.setFont(Font.font("Segoe UI Semibold", 12));
        twenty_four.getChildren().addAll(pics[23], a24);
        this.movie_23.getChildren().add(twenty_four);

        VBox twenty_five = new VBox();
        images[24] = new Image(imageData[24]);
        pics[24] = new ImageView(images[24]);
        Text a25 = new Text(MovieName[24]);
        a25.setFont(Font.font("Segoe UI Semibold", 15));
        twenty_five.getChildren().addAll(pics[24], a25);
        this.movie_24.getChildren().add(twenty_five);

        row9.getChildren().addAll(this.movie_23, this.movie_24);
        row9.setSpacing(25);

        for (int i = 20; i < 25; i++) {
            pics[i].setFitWidth(260);
            pics[i].setFitHeight(250);
            pics[i].setPreserveRatio(true);
        }
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Allrow.getChildren().addAll(row8, row9);
        sp.setPrefViewportHeight(500);
        sp.setMaxWidth(600);
        sp.setMinViewportHeight(500);
        sp.setContent(Allrow);
        sp.setStyle("-fx-background-color: transparent;-fx-focus-color: transparent;");

        main.setPadding(new Insets(0, 500, 0, 100));
        rightBase.getChildren().addAll(searchBar, main, sp);

        rightBase.setSpacing(30);
        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(40, 200, 400, 100));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void profilePage() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        StackPane mProfile6 = new StackPane();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        VBox lineBeutfly = new VBox();
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu6.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);
        top1.getChildren().addAll(ActionName);
        mA6.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC6.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD6.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH6.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        center.getChildren().addAll(RomaticName, line2);
        mR6.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile6.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        HistoryName.setFill(Color.YELLOWGREEN);
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory6.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out6.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu6, mA6, mC6, mD6, mH6, mR6, mProfile6, mHistory6, mlogn_out6);
        column.setSpacing(20);

        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        StackPane rightBase = new StackPane();
        VBox profiledetail = new VBox();

        HBox buttondetail = new HBox();
        Text Profilename = new Text("           ~Profile~");
        Text name = new Text("Name : " + Movies.people.getName());
        Text email = new Text("Email : " + Movies.people.getEmail());
        Text phone = new Text("Phone Number : " + Movies.people.getPhone_number());
        Text money = new Text("Amount : MYR " + decimal.format(Movies.people.getAmount()));
        Profilename.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 50));
        name.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        email.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        phone.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        money.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        Profilename.setFill(Color.DARKGREEN);
        name.setFill(Color.DARKGREEN);
        email.setFill(Color.DARKGREEN);
        phone.setFill(Color.DARKGREEN);
        money.setFill(Color.DARKGREEN);

        update.setText("Update Information");
        update.setMinSize(150, 50);
        update.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        reload.setText("Reload Money");
        reload.setMinSize(150, 50);
        reload.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        memberchange.setText("Become Member ?");
        memberchange.setMinSize(150, 50);
        memberchange.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        buttondetail.getChildren().addAll(update, memberchange, reload);
        buttondetail.setSpacing(20);
        profiledetail.getChildren().addAll(Profilename, name, email, phone, money, buttondetail);
        profiledetail.setSpacing(50);
        rightBase.getChildren().add(profiledetail);
        rightBase.setStyle("-fx-background-color:#CBE54E");
        rightBase.setPadding(new Insets(30, 100, 100, 80));
        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(60, 60, 60, 60));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void historyPage() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        StackPane mHistory7 = new StackPane();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        VBox lineBeutfly = new VBox();
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu7.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);
        top1.getChildren().addAll(ActionName);
        mA7.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC7.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD7.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH7.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        center.getChildren().addAll(RomaticName, line2);
        mR7.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile7.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        HistoryName.setFill(Color.YELLOWGREEN);
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory7.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out7.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu7, mA7, mC7, mD7, mH7, mR7, mProfile7, mHistory7, mlogn_out7);
        column.setSpacing(20);
        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        StackPane rightBase = new StackPane();
        VBox content = new VBox();
        Text title = new Text("           ~History~");
        title.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 50));
        title.setFill(Color.DARKGREEN);
        Text name = new Text("\nName : " + Movies.people.getName() + "\n");
        name.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 30));
        name.setFill(Color.DARKGREEN);
        String receipt_filename = "database/receipt/" + Movies.people.getName() + ".txt";

        String receipt = "";
        try {
            BufferedReader input = new BufferedReader(new FileReader(receipt_filename));
            while ((receipt = input.readLine()) != null) {
                receipt_area_show.appendText(receipt + "\r\n");
            }

        } catch (IOException e) {
        }

        receipt_area_show.setWrapText(true);
        receipt_area_show.setEditable(false);
        receipt_area_show.setMinHeight(340);
        receipt_area_show.setMinWidth(505);
        receipt_area_show.setStyle("-fx-border-color: transparent ;-fx-control-inner-background:#CBE54E;-fx-background-color: #CBE54E;");
        content.getChildren().addAll(title, name, receipt_area_show);
        rightBase.getChildren().addAll(content);
        rightBase.setStyle("-fx-background-color:#CBE54E");
        rightBase.setPadding(new Insets(30, 80, 50, 80));
        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(60, 60, 60, 60));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public void Information() {
        HBox base = new HBox();
        StackPane left = new StackPane();
        VBox column = new VBox();
        HBox top = new HBox();
        Image img = new Image("file:resources/movieIcon.png");
        ImageView pic = new ImageView(img);
        pic.setFitHeight(40);
        pic.setFitWidth(40);
        VBox lineBeutfly = new VBox();
        line.setFill(Color.YELLOWGREEN);
        line.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        Logoname.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Logoname.setFill(Color.YELLOWGREEN);
        top.getChildren().addAll(pic, Logoname);
        top.setSpacing(5);
        lineBeutfly.getChildren().addAll(top, line);
        menu8.getChildren().add(lineBeutfly);
        VBox top1 = new VBox();
        ActionName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ActionName.setFill(Color.YELLOWGREEN);
        top1.getChildren().addAll(ActionName);
        mA8.getChildren().addAll(top1);
        ComedyName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ComedyName.setFill(Color.YELLOWGREEN);
        mC8.getChildren().addAll(ComedyName);
        DramaName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        DramaName.setFill(Color.YELLOWGREEN);
        mD8.getChildren().addAll(DramaName);
        HorrorName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        HorrorName.setFill(Color.YELLOWGREEN);
        mH8.getChildren().addAll(HorrorName);
        VBox center = new VBox();
        line2.setFill(Color.YELLOWGREEN);
        line2.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        RomaticName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        RomaticName.setFill(Color.YELLOWGREEN);
        center.getChildren().addAll(RomaticName, line2);
        mR8.getChildren().addAll(center);
        ProfileName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        ProfileName.setFill(Color.YELLOWGREEN);
        mProfile8.getChildren().addAll(ProfileName);
        HistoryName.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        VBox bottom = new VBox();
        HistoryName.setFill(Color.YELLOWGREEN);
        line3.setFill(Color.YELLOWGREEN);
        line3.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 20));
        bottom.getChildren().addAll(HistoryName, line3);
        mHistory8.getChildren().addAll(bottom);
        lognOut.setFont(Font.font("Segoe UI Semibold", FontWeight.NORMAL, 20));
        lognOut.setFill(Color.YELLOWGREEN);
        mlogn_out8.getChildren().addAll(lognOut);
        column.getChildren().addAll(menu8, mA8, mC8, mD8, mH8, mR8, mProfile8, mHistory8, mlogn_out8);
        column.setSpacing(20);

        left.getChildren().addAll(column);
        left.setStyle("-fx-background-color:#0E4301");
        left.setPadding(new Insets(20, 0, 600, 0));

        StackPane right = new StackPane();
        StackPane rightBase = new StackPane();
        VBox background = new VBox();
        HBox row = new HBox();
        VBox ImageArea = new VBox();
        back.setFont(Font.font("Segoe UI Semibold", FontWeight.LIGHT, 15));
        back.setFill(Color.DARKGREEN);
        images[passData] = new Image(imageData[passData]);
        pics[passData] = new ImageView(images[passData]);
        pics[passData].setFitWidth(260);
        pics[passData].setFitHeight(250);
        pics[passData].setPreserveRatio(true);
        ImageArea.getChildren().addAll(back, pics[passData]);
        VBox detail = new VBox();
        VBox wordDetail = new VBox();
        Text title = new Text(MovieName[passData]);
        title.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 30));
        Text yearNum = new Text(" " + years[passData]);
        yearNum.setFont(Font.font("Segoe UI Semibold", FontWeight.BOLD, 25));
        wordDetail.getChildren().addAll(title, yearNum);
        VBox buttonSelect = new VBox();
        play.setText("Play");
        play.setMinSize(200, 40);
        play.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        play.setVisible(false);
        HBox rent_price = new HBox();
        HBox buy_price = new HBox();
        Rentstandard.setText("Rent Standard Definition: MYR" + this.rent_price[passData]);
        Rentstandard.setMinSize(200, 40);
        Rentstandard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        RentHD.setText("Rent High Definition: MYR" + (this.rent_price[passData] + 5));
        RentHD.setMinSize(200, 40);
        RentHD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        standard.setText("Buy Standard Definition: MYR" + this.price[passData]);
        standard.setMinSize(200, 40);
        standard.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        HD.setText("Buy High Definition: MYR" + (this.price[passData] + 5));
        HD.setMinSize(200, 40);
        HD.setStyle("-fx-background-color: #CBE54E;-fx-border-color: #5D6E1E;-fx-border-width: 0.5px;-fx-text-fill: #5D6E1E;");
        rent_price.getChildren().addAll(Rentstandard, RentHD);
        buy_price.getChildren().addAll(standard, HD);
        buttonSelect.getChildren().addAll(play, rent_price, buy_price);
        detail.getChildren().addAll(wordDetail, buttonSelect);
        buttonSelect.setSpacing(10);
        rent_price.setSpacing(10);
        buy_price.setSpacing(10);
        detail.setSpacing(50);
        row.getChildren().addAll(ImageArea, detail);
        row.setSpacing(30);
        TextArea plots = new TextArea(this.detail[passData]);
        plots.setWrapText(true);
        plots.setEditable(false);
        plots.setMinHeight(150);
        plots.setStyle("-fx-border-color: transparent ;-fx-control-inner-background:#CBE54E;-fx-background-color: #CBE54E;");

        background.getChildren().addAll(row, plots);
        background.setSpacing(20);
        rightBase.getChildren().addAll(background);
        rightBase.setStyle("-fx-background-color:#CBE54E");
        rightBase.setPadding(new Insets(50, 10, 100, 50));

        right.getChildren().addAll(rightBase);
        right.setStyle("-fx-background-color:#5BA8A0");
        right.setPadding(new Insets(65, 80, 65, 60));
        base.getChildren().addAll(left, right);
        root.getChildren().add(base);
    }

    public static void main(String[] args) {
        launch(args);
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

    public static boolean validNumber(String input) {
        return input.matches("[0-9]+");
    }
}
