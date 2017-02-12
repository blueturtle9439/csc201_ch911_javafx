package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX ch911");
        primaryStage.show();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        Scene scene = new Scene(grid, 700, 375);
        primaryStage.setScene(scene);


        Text scenetitle = new Text("Please enter a, b, c, d, e, and f for calculation");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);


        Label a = new Label("a:");
        grid.add(a, 0, 1);
        TextField ainput = new TextField();
        grid.add(ainput, 1, 1);

        Label b = new Label("b:");
        grid.add(b, 0, 2);
        TextField binput = new TextField();
        grid.add(binput, 1, 2);

        Label c = new Label("c:");
        grid.add(c, 0, 3);
        TextField cinput = new TextField();
        grid.add(cinput, 1, 3);


        Label d = new Label("d:");
        grid.add(d, 0, 4);
        TextField dinput = new TextField();
        grid.add(dinput, 1, 4);


        Label e = new Label("e:");
        grid.add(e, 0, 5);
        TextField einput = new TextField();
        grid.add(einput, 1, 5);


        Label f = new Label("f:");
        grid.add(f, 0, 6);
        TextField finput = new TextField();
        grid.add(finput, 1, 6);

        Button btn = new Button("calculate X and Y");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 7);

        final Text result = new Text();
        grid.add(result, 1, 8);


        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                double a1 = Double.parseDouble(ainput.getText());
                double b1 = Double.parseDouble(binput.getText());
                double c1 = Double.parseDouble(cinput.getText());
                double d1 = Double.parseDouble(dinput.getText());
                double e1 = Double.parseDouble(einput.getText());
                double f1 = Double.parseDouble(finput.getText());


                LinearEquation eq = new LinearEquation(a1, b1, c1, d1, e1, f1);

                result.setFill(Color.FIREBRICK);

                if (eq.isSolvable()) {
                    result.setText("x is " + eq.getX() + " and y is " + eq.getY());
                } else {
                    result.setText("The equation has no solution");
                }
            }
        });
    }

}