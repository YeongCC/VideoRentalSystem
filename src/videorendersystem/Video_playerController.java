package videorendersystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Video_playerController implements Initializable {

    MediaPlayer player;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button playBtn;
    @FXML
    private Button preBtn;
    @FXML
    private Button nextBtn;

    @FXML
    private Slider timeSlider;

    @FXML
    public void play(ActionEvent event) {
        try {
            MediaPlayer.Status status = player.getStatus();
            if (status == MediaPlayer.Status.PLAYING) {
                player.pause();
                playBtn.setGraphic(new ImageView(new Image("file:resources/play.png")));
            } else {
                player.play();
                playBtn.setGraphic(new ImageView(new Image("file:resources/pause.png")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            String movie1 = "resources/movie_video/0.mp4";
            String movie[] = {"resources/movie_video/0.mp4", "resources/movie_video/1.mp4", "resources/movie_video/2.mp4", "resources/movie_video/3.mp4", "resources/movie_video/4.mp4",
                "resources/movie_video/6.mp4", "resources/movie_video/7.mp4", "resources/movie_video/7.mp4", "resources/movie_video/8.mp4", "resources/movie_video/9.mp4",
                "resources/movie_video/10.mp4", "resources/movie_video/11.mp4", "resources/movie_video/12.mp4", "resources/movie_video/13.mp4", "resources/movie_video/14.mp4",
                "resources/movie_video/15.mp4", "resources/movie_video/16.mp4", "resources/movie_video/17.mp4", "resources/movie_video/18.mp4", "resources/movie_video/19.mp4",
                "resources/movie_video/20.mp4", "resources/movie_video/21.mp4", "resources/movie_video/22.mp4", "resources/movie_video/23.mp4", "resources/movie_video/24.mp4"
            };

            preBtn.setGraphic(new ImageView(new Image("file:resources/previous.png")));
            nextBtn.setGraphic(new ImageView(new Image("file:resources/next.png")));
            Media media = new Media(new File(movie[Secondpage.passData]).toURI().toString());
            player = new MediaPlayer(media);
            mediaView.setMediaPlayer(player);

            player.setOnReady(() -> {
                timeSlider.setMin(0);
                timeSlider.setMax(player.getMedia().getDuration().toMinutes());
                timeSlider.setValue(0);
                playBtn.setGraphic(new ImageView(new Image("file:resources/play.png")));
            });
            player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                    Duration d = player.getCurrentTime();
                    timeSlider.setValue(d.toMinutes());
                }
            });
            timeSlider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    if (timeSlider.isPressed()) {
                        double val = timeSlider.getValue();
                        player.seek(new Duration(val * 60 * 1000));
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void preBtnClick(ActionEvent event) {
        double d = player.getCurrentTime().toSeconds();
        d = d - 10;
        player.seek(new Duration(d * 1000));
    }

    @FXML
    public void nextBtnClick(ActionEvent event) {
        double d = player.getCurrentTime().toSeconds();
        d = d + 10;
        player.seek(new Duration(d * 1000));
    }
}
