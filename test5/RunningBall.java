package testjavafx;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunningBall extends Application {
    private boolean isPlay;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        for(int i = 50; i <= 400; ++i) {
            list.add((double)i);
            list.add(50 * Math.cos(((double)i) / 50.0 * Math.PI) + 100);
        }
        pane.getChildren().addAll(polyline);

        Line axisX = new Line(25.0, 100.0, 425.0, 100.0);
        Line arrowX1 = new Line(420.0, 95.0, 425.0, 100.0);
        Line arrowX2 = new Line(420.0, 105.0, 425.0, 100.0);
        Line axisY = new Line(225.0, 175.0, 225.0, 25.0);
        Line arrowY1 = new Line(220.0, 30.0, 225.0, 25.0);
        Line arrowY2 = new Line(230.0, 30.0, 225.0, 25.0);
        pane.getChildren().addAll(axisX, arrowX1, arrowX2, axisY, arrowY1, arrowY2);

        Text X = new Text(410.0, 90.0, "X");
        Text Y = new Text(235.0, 30.0, "Y");
        Text Zero = new Text(228.0, 112.0, "0");
        Text Pi = new Text(265.0, 110.0, "л");
        Text minusPi = new Text(160.0, 110.0, "-л");
        Text doublePi = new Text(325.0, 112.0, "2л");
        Text minusDoublePi = new Text(125.0, 112.0, "-2л");
        pane.getChildren().addAll(X, Y, Zero, Pi, minusPi, doublePi, minusDoublePi);

        Circle ball = new Circle(5);
        ball.setCenterX(50);
        ball.setCenterY(50);
        ball.setFill(Color.BLACK);
        pane.getChildren().add(ball);

        PathTransition pt = new PathTransition();
        pt.setNode(ball);
        pt.setPath(polyline);
        pt.setDuration(Duration.millis(6000));
        pt.play();

        pt.currentTimeProperty().addListener((ov, old_val, new_val) -> {
            if(pt.getCurrentTime().compareTo(pt.getDuration()) >= 0)
                pt.playFromStart();
        });

        isPlay = true;
        ball.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.SPACE) {
                if(isPlay == true) {
                    pt.pause();
                    isPlay = false;
                }
                else {
                    pt.play();
                    isPlay = true;
                }
            }
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Running Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
        ball.requestFocus();
    }
}

