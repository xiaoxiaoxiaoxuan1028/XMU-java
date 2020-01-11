import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShowSlides extends Application {
    private int imgNumber = 1;
    private boolean isPlay = true;

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        String imgAddress = "cards/" + imgNumber + ".png";
        ImageView imgView = new ImageView();
        imgView.setImage(readImageFromJar(".\\cards.jar", imgAddress));

        pane.setCenter(imgView);

        EventHandler<ActionEvent> eventHandler = e -> {
            imgNumber = imgNumber % 54 + 1;
            String imgAddressNew = "cards/" + imgNumber + ".png";
            imgView.setImage(readImageFromJar(".\\cards.jar", imgAddressNew));
        };

        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();

        imgView.setOnKeyPressed(e -> {
            if(e.getCode().compareTo(KeyCode.UP) == 0) {
                if(tl.getRate() < 1000)
                    tl.setRate(tl.getRate() * 2);
            }
            else if(e.getCode().compareTo(KeyCode.DOWN) == 0) {
                if(tl.getRate() >= 0.5)
                    tl.setRate(tl.getRate() / 2);
            }
        });
        imgView.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY && e.getClickCount() == 2) {
                if(isPlay == true) {
                    tl.pause();
                    isPlay = false;
                }
                else {
                    tl.play();
                    isPlay = true;
                }
            }
        });

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Show Slides");
        primaryStage.setScene(scene);
        primaryStage.show();
        imgView.requestFocus();
    }

    public static Image readImageFromJar(String jarname, String picname) {
        Image image = null;
        try {
            JarFile jarFile = new JarFile(jarname);
            JarEntry entry = jarFile.getJarEntry(picname);
            InputStream in = jarFile.getInputStream(entry);
            image = new Image(in);
            in.close();
            jarFile.close();
        }
        catch (IOException e) {
            System.err.println("read file error.");
        }
        return image;
    }
}
