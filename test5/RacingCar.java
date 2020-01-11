import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RacingCar extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Car carPane = new Car();

        carPane.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case UP: {
                    carPane.up();
                }break;
                case DOWN: {
                    carPane.down();
                }break;
                case LEFT: {
                    carPane.left();
                }break;
                case RIGHT: {
                    carPane.right();
                }break;
            }
        });

        pane.getChildren().add(carPane);

        Scene scene = new Scene(pane, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Racing car");
        primaryStage.show();
        carPane.requestFocus();
    }
}

class Car extends Pane {
    Circle leftWheel = new Circle(5, BLACK);
    Circle rightWheel = new Circle(5, BLACK);
    Rectangle body = new Rectangle(50, 10, AQUA);
    Polygon hat = new Polygon();

    Car() {
        leftWheel.setCenterX(15);
        leftWheel.setCenterY(95);
        rightWheel.setCenterX(35);
        rightWheel.setCenterY(95);
        body.setX(0);
        body.setY(80);
        ObservableList<Double> list = hat.getPoints();
        list.addAll(20.0, 70.0,
                30.0, 70.0,
                40.0, 80.0,
                10.0, 80.0);
        hat.setFill(BLUE);
        getChildren().addAll(leftWheel, rightWheel, body, hat);
    }

    public void up() {
        if(leftWheel.getCenterY() - 10 >= 25) {
            leftWheel.setCenterY(leftWheel.getCenterY() - 10);
            rightWheel.setCenterY(rightWheel.getCenterY() - 10);
            body.setY(body.getY() - 10);
            ObservableList<Double> list = hat.getPoints();
            for(int i = 1; i < 8; i = i + 2)
                list.set(i, list.get(i) - 10);
        }
    }

    public void down() {
        if(leftWheel.getCenterY() + 10 <= 95) {
            leftWheel.setCenterY(leftWheel.getCenterY() + 10);
            rightWheel.setCenterY(rightWheel.getCenterY() + 10);
            body.setY(body.getY() + 10);
            ObservableList<Double> list = hat.getPoints();
            for(int i = 1; i < 8; i = i + 2)
                list.set(i, list.get(i) + 10);
        }
    }

    public void left() {
        if(leftWheel.getCenterX() - 10 >= 15) {
            leftWheel.setCenterX(leftWheel.getCenterX() - 10);
            rightWheel.setCenterX(rightWheel.getCenterX() - 10);
            body.setX(body.getX() - 10);
            ObservableList<Double> list = hat.getPoints();
            for(int i = 0; i < 8; i = i + 2)
                list.set(i, list.get(i) - 10);
        }
    }

    public void right() {
        if(leftWheel.getCenterX() + 10 <= 165) {
            leftWheel.setCenterX(leftWheel.getCenterX() + 10);
            rightWheel.setCenterX(rightWheel.getCenterX() + 10);
            body.setX(body.getX() + 10);
            ObservableList<Double> list = hat.getPoints();
            for(int i = 0; i < 8; i = i + 2)
                list.set(i, list.get(i) + 10);
        }
    }
}