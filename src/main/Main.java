/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author gagan
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 600, 600);
        FileChooser fileChooser = new FileChooser();
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label inputFile = new Label("Input File:");
        grid.add(inputFile, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Button fileBtn = new Button("Select input file");
        grid.add(fileBtn, 2, 1);
        fileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                userTextField.setText(fileChooser.showOpenDialog(primaryStage).getAbsolutePath());
            }
        });

        Label pw = new Label("Output Location:");
        grid.add(pw, 0, 2);

        TextField outLocation = new TextField();
        grid.add(outLocation, 1, 2);

        Button outBtn = new Button("Select output path");
        grid.add(outBtn, 2, 2);

        outBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                outLocation.setText(fileChooser.showSaveDialog(primaryStage).getAbsolutePath());
            }
        });

        Button btn = new Button("Convert");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                process(userTextField.getText(), outLocation.getText());
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Done !");
            }
        });

        primaryStage.setTitle("File Encrypt");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void process(String inputPath, String outPath) {
        System.out.print("Processing ...");
    }

}
