//package testjavafx;

import java.io.*;
import java.util.Random;
import java.util.jar.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Test3 extends Application{
    public static ImageView readImageFromJar(String jarname, String picname) {
        ImageView imageView = null;
        try {
            JarFile jarFile = new JarFile(jarname);
            JarEntry entry = jarFile.getJarEntry(picname);
            InputStream in = jarFile.getInputStream(entry);
            imageView = new ImageView(new Image(in));
            in.close();
            jarFile.close();
        }
        catch (IOException e) {
            System.err.println("read file error.");
        }
        return imageView;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        Random random = new Random((int)(System.currentTimeMillis()));
        int img1Number = random.nextInt(54) + 1;
        String img1Address = "cards/" + img1Number + ".png";

        int img2Number;
        do {
            img2Number = random.nextInt(54) + 1;
        }
        while(img2Number == img1Number);
        String img2Address = "cards/" + img2Number + ".png";

        int img3Number;
        do {
            img3Number = random.nextInt(54) + 1;
        }
        while(img3Number == img1Number || img3Number == img2Number);
        String img3Address = "cards/" + img3Number + ".png";

        int img4Number;
        do {
            img4Number = random.nextInt(54) + 1;
        }
        while(img4Number == img1Number || img4Number == img2Number || img4Number == img3Number);
        String img4Address = "cards/" + img4Number + ".png";

        ImageView img1View = readImageFromJar("cards.jar", img1Address);
        ImageView img2View = readImageFromJar("cards.jar", img2Address);
        ImageView img3View = readImageFromJar("cards.jar", img3Address);
        ImageView img4View = readImageFromJar("cards.jar", img4Address);

        String card1Name = getName(img1Number);
        String card2Name = getName(img2Number);
        String card3Name = getName(img3Number);
        String card4Name = getName(img4Number);

        Label label1 = new Label(card1Name);
        Label label2 = new Label(card2Name);
        Label label3 = new Label(card3Name);
        Label label4 = new Label(card4Name);

        GridPane.setHalignment(label1, HPos.CENTER);
        GridPane.setHalignment(label2, HPos.CENTER);
        GridPane.setHalignment(label3, HPos.CENTER);
        GridPane.setHalignment(label4, HPos.CENTER);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.add(img1View, 0, 0);
        grid.add(img2View, 1, 0);
        grid.add(img3View, 2, 0);
        grid.add(img4View, 3, 0);
        grid.add(label1, 0, 1);
        grid.add(label2, 1, 1);
        grid.add(label3, 2, 1);
        grid.add(label4, 3, 1);
        pane.setCenter(grid);

        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Four Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String getName(int number) {
        String name = "";

        switch((number - 1) / 13) {
            case 0: name = name + "黑桃"; break;
            case 1: name = name + "红心"; break;
            case 2: name = name + "方块"; break;
            case 3: name = name + "梅花"; break;
            default: {
                if(number == 53)
                    name = name + "小 王";
                else if(number == 54)
                    name = name + "大 王";
            }
        }

        if(1 <= number && number <= 52) {
            if((number - 1) % 13 == 0)
                name = name + "A";
            else if(1 <= (number - 1) % 13 && (number - 1) % 13 <= 9)
                name = name + ((number - 1) % 13 + 1) + "";
            else if((number - 1) % 13 == 10)
                name = name + "J";
            else if((number - 1) % 13 == 11)
                name = name + "Q";
            else
                name = name + "K";
        }

        return name;
    }
}
