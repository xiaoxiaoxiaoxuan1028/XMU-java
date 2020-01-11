//package testjavafx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Test4 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setTop(getTextField());
        pane.setBottom(getGrid());

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("计算器");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private TextField getTextField() {
        TextField textField = new TextField("0");
        textField.setPadding(new Insets(30, 20, 5, 10));
        textField.setEditable(false);
        textField.setAlignment(Pos.BOTTOM_RIGHT);
        textField.setStyle("-fx-font: 22 Consolas;");
        return textField;
    }

    private GridPane getGrid() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(5, 0, 0, 10));

        Button b00 = new Button("MC");
        b00.setPrefSize(40, 20);
        pane.add(b00, 0, 0);

        Button b01 = new Button("MR");
        b01.setPrefSize(40, 20);
        pane.add(b01, 1, 0);

        Button b02 = new Button("MS");
        b02.setPrefSize(40, 20);
        pane.add(b02, 2, 0);

        Button b03 = new Button("M+");
        b03.setPrefSize(40, 20);
        pane.add(b03, 3, 0);

        Button b04 = new Button("M-");
        b04.setPrefSize(40, 20);
        pane.add(b04, 4, 0);

        Button b10 = new Button("←");
        b10.setPrefSize(40, 20);
        pane.add(b10, 0, 1);

        Button b11 = new Button("CE");
        b11.setPrefSize(40, 20);
        pane.add(b11, 1, 1);

        Button b12 = new Button("C");
        b12.setPrefSize(40, 20);
        pane.add(b12, 2, 1);

        Button b13 = new Button("±");
        b13.setPrefSize(40, 20);
        pane.add(b13, 3, 1);

        Button b14 = new Button("√");
        b14.setPrefSize(40, 20);
        pane.add(b14, 4, 1);

        Button b20 = new Button("7");
        b20.setPrefSize(40, 20);
        b20.setStyle("-fx-base: lightgray");
        pane.add(b20, 0, 2);

        Button b21 = new Button("8");
        b21.setStyle("-fx-base: lightgray");
        b21.setPrefSize(40, 20);
        pane.add(b21, 1, 2);

        Button b22 = new Button("9");
        b22.setPrefSize(40, 20);
        b22.setStyle("-fx-base: lightgray");
        pane.add(b22, 2, 2);

        Button b23 = new Button("/");
        b23.setPrefSize(40, 20);
        pane.add(b23, 3, 2);

        Button b24 = new Button("%");
        b24.setPrefSize(40, 20);
        pane.add(b24, 4, 2);

        Button b30 = new Button("4");
        b30.setPrefSize(40, 20);
        b30.setStyle("-fx-base: lightgray");
        pane.add(b30, 0, 3);

        Button b31 = new Button("5");
        b31.setPrefSize(40, 20);
        b31.setStyle("-fx-base: lightgray");
        pane.add(b31, 1, 3);

        Button b32 = new Button("6");
        b32.setPrefSize(40, 20);
        b32.setStyle("-fx-base: lightgray");
        pane.add(b32, 2, 3);

        Button b33 = new Button("*");
        b33.setPrefSize(40, 20);
        pane.add(b33, 3, 3);

        Button b34 = new Button("1/x");
        b34.setPrefSize(40, 20);
        pane.add(b34, 4, 3);

        Button b40 = new Button("1");
        b40.setPrefSize(40, 20);
        b40.setStyle("-fx-base: lightgray");
        pane.add(b40, 0, 4);

        Button b41 = new Button("2");
        b41.setPrefSize(40, 20);
        b41.setStyle("-fx-base: lightgray");
        pane.add(b41, 1, 4);

        Button b42 = new Button("3");
        b42.setPrefSize(40, 20);
        b42.setStyle("-fx-base: lightgray");
        pane.add(b42, 2, 4);

        Button b43 = new Button("-");
        b43.setPrefSize(40, 20);
        pane.add(b43, 3, 4);

        Button b44 = new Button("=");
        b44.setPrefSize(40, 50);
        GridPane.setValignment(b44, VPos.TOP);
        pane.add(b44, 4, 4, 4, 5);

        Button b50 = new Button("0");
        b50.setPrefSize(85, 20);
        GridPane.setValignment(b50, VPos.TOP);
        b50.setStyle("-fx-base: lightgray");
        pane.add(b50, 0, 5, 2, 5);

        Button b52 = new Button(".");
        b52.setPrefSize(40, 20);
        b52.setStyle("-fx-base: lightgray");
        pane.add(b52, 2, 5);

        Button b53 = new Button("+");
        b53.setPrefSize(40, 20);
        pane.add(b53, 3, 5);

        return pane;
    }
}