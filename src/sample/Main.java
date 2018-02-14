package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.awt.SystemColor.text;
import static java.awt.SystemColor.window;
import static javafx.application.Platform.exit;
import static javafx.scene.paint.Color.RED;

public class Main extends Application {

    public static String userDir = System.getProperty("user.home");
    //public static String dataSheetDir = "C:\\Users\\1153\\Documents\\Datasheets";
    public static String dataSheetDir = userDir + "\\Documents\\Datasheets";
    public Writer writer = null;

    public ArrayList<RobotData> robotList = new ArrayList<RobotData>();
    public List<AllianceData> adList1 = new ArrayList<AllianceData>();
    public List<AllianceData> adList2 = new ArrayList<AllianceData>();
    public List<AllianceData> adList3 = new ArrayList<AllianceData>();
    public List<AllianceData> adList4 = new ArrayList<AllianceData>();
    public List<AllianceData> adList5 = new ArrayList<AllianceData>();
    public List<AllianceData> adList6 = new ArrayList<AllianceData>();
    public List<AllianceData> adList7 = new ArrayList<AllianceData>();
    public List<AllianceData> adList8 = new ArrayList<AllianceData>();
    public List<Integer> teamList = new ArrayList<Integer>();

    public AllianceData alliance1 = new AllianceData();
    public AllianceData alliance2 = new AllianceData();
    public AllianceData alliance3 = new AllianceData();
    public AllianceData alliance4 = new AllianceData();
    public AllianceData alliance5 = new AllianceData();
    public AllianceData alliance6 = new AllianceData();
    public AllianceData alliance7 = new AllianceData();
    public AllianceData alliance8 = new AllianceData();

    public List<Text> alliance1TextList = new ArrayList<Text>();
    public List<Text> alliance2TextList = new ArrayList<Text>();
    public List<Text> alliance3TextList = new ArrayList<Text>();
    public List<Text> alliance4TextList = new ArrayList<Text>();
    public List<Text> alliance5TextList = new ArrayList<Text>();
    public List<Text> alliance6TextList = new ArrayList<Text>();
    public List<Text> alliance7TextList = new ArrayList<Text>();
    public List<Text> alliance8TextList = new ArrayList<Text>();
    public List<Text> robotTextList = new ArrayList<Text>();

    public Text predictedScore1;
    public Text predictedScore2;
    public Text predictedScore3;
    public Text predictedScore4;
    public Text predictedScore5;
    public Text predictedScore6;
    public Text predictedScore7;
    public Text predictedScore8;

    public Text avgTeleSwitchText1;
    public Text avgAutoSwitchText1;
    public Text avgTeleScaleText1;
    public Text avgAutoScaleText1;
    public Text avgVaultText1;
    public Text avgClimbsText1;

    public Text avgTeleSwitchText2;
    public Text avgAutoSwitchText2;
    public Text avgTeleScaleText2;
    public Text avgAutoScaleText2;
    public Text avgVaultText2;
    public Text avgClimbsText2;

    public Text avgTeleSwitchText3;
    public Text avgAutoSwitchText3;
    public Text avgTeleScaleText3;
    public Text avgAutoScaleText3;
    public Text avgVaultText3;
    public Text avgClimbsText3;

    public Text avgTeleSwitchText4;
    public Text avgAutoSwitchText4;
    public Text avgTeleScaleText4;
    public Text avgAutoScaleText4;
    public Text avgVaultText4;
    public Text avgClimbsText4;

    public Text avgTeleSwitchText5;
    public Text avgAutoSwitchText5;
    public Text avgTeleScaleText5;
    public Text avgAutoScaleText5;
    public Text avgVaultText5;
    public Text avgClimbsText5;

    public Text avgTeleSwitchText6;
    public Text avgAutoSwitchText6;
    public Text avgTeleScaleText6;
    public Text avgAutoScaleText6;
    public Text avgVaultText6;
    public Text avgClimbsText6;

    public Text avgTeleSwitchText7;
    public Text avgAutoSwitchText7;
    public Text avgTeleScaleText7;
    public Text avgAutoScaleText7;
    public Text avgVaultText7;
    public Text avgClimbsText7;

    public Text avgTeleSwitchText8;
    public Text avgAutoSwitchText8;
    public Text avgTeleScaleText8;
    public Text avgAutoScaleText8;
    public Text avgVaultText8;
    public Text avgClimbsText8;

    public int avgAutoScale1X = 408;
    public int avgAutoScale1Y = 73;
    public int avgTeleScale1X = 498;
    public int avgTeleScale1Y = 73;
    public int avgAutoSwitch1X = 595;
    public int avgAutoSwitch1Y = 73;
    public int avgTeleSwitch1X = 695;
    public int avgTeleSwitch1Y = 73;
    public int avgVault1X = 772;
    public int avgVault1Y = 73;
    public int avgClimbs1X = 836;
    public int avgClimbs1Y = 73;

    public int avgAutoScale2X = 408;
    public int avgAutoScale2Y = 140;
    public int avgTeleScale2X = 498;
    public int avgTeleScale2Y = 140;
    public int avgAutoSwitch2X = 595;
    public int avgAutoSwitch2Y = 140;
    public int avgTeleSwitch2X = 695;
    public int avgTeleSwitch2Y = 140;
    public int avgVault2X = 772;
    public int avgVault2Y = 73;
    public int avgClimbs2X = 836;
    public int avgClimbs2Y = 140;

    public int avgAutoScale3X = 408;
    public int avgAutoScale3Y = 201;
    public int avgTeleScale3X = 498;
    public int avgTeleScale3Y = 201;
    public int avgAutoSwitch3X = 595;
    public int avgAutoSwitch3Y = 201;
    public int avgTeleSwitch3X = 695;
    public int avgTeleSwitch3Y = 201;
    public int avgVault3X = 772;
    public int avgVault3Y = 73;
    public int avgClimbs3X = 836;
    public int avgClimbs3Y = 201;

    public int avgAutoScale4X = 408;
    public int avgAutoScale4Y = 269;
    public int avgTeleScale4X = 498;
    public int avgTeleScale4Y = 269;
    public int avgAutoSwitch4X = 595;
    public int avgAutoSwitch4Y = 269;
    public int avgTeleSwitch4X = 695;
    public int avgTeleSwitch4Y = 269;
    public int avgVault4X = 772;
    public int avgVault4Y = 73;
    public int avgClimbs4X = 836;
    public int avgClimbs4Y = 269;

    public int avgAutoScale5X = 408;
    public int avgAutoScale5Y = 333;
    public int avgTeleScale5X = 498;
    public int avgTeleScale5Y = 333;
    public int avgAutoSwitch5X = 595;
    public int avgAutoSwitch5Y = 333;
    public int avgTeleSwitch5X = 695;
    public int avgTeleSwitch5Y = 333;
    public int avgVault5X = 772;
    public int avgVault5Y = 73;
    public int avgClimbs5X = 836;
    public int avgClimbs5Y = 333;

    public int avgAutoScale6X = 408;
    public int avgAutoScale6Y = 398;
    public int avgTeleScale6X = 498;
    public int avgTeleScale6Y = 398;
    public int avgAutoSwitch6X = 595;
    public int avgAutoSwitch6Y = 398;
    public int avgTeleSwitch6X = 695;
    public int avgTeleSwitch6Y = 398;
    public int avgVault6X = 772;
    public int avgVault6Y = 73;
    public int avgClimbs6X = 836;
    public int avgClimbs6Y = 398;

    public int avgAutoScale7X = 408;
    public int avgAutoScale7Y = 465;
    public int avgTeleScale7X = 498;
    public int avgTeleScale7Y = 465;
    public int avgAutoSwitch7X = 595;
    public int avgAutoSwitch7Y = 465;
    public int avgTeleSwitch7X = 695;
    public int avgTeleSwitch7Y = 465;
    public int avgVault7X = 772;
    public int avgVault7Y = 73;
    public int avgClimbs7X = 836;
    public int avgClimbs7Y = 465;

    public int avgAutoScale8X = 408;
    public int avgAutoScale8Y = 528;
    public int avgTeleScale8X = 498;
    public int avgTeleScale8Y = 528;
    public int avgAutoSwitch8X = 595;
    public int avgAutoSwitch8Y = 528;
    public int avgTeleSwitch8X = 695;
    public int avgTeleSwitch8Y = 528;
    public int avgVault8X = 772;
    public int avgVault8Y = 73;
    public int avgClimbs8X = 836;
    public int avgClimbs8Y = 528;

    public int predictedScore1X = 333;
    public int predictedScore1Y = 73;

    public int predictedScore2X = 333;
    public int predictedScore2Y = 140;

    public int predictedScore3X = 333;
    public int predictedScore3Y = 201;

    public int predictedScore4X = 333;
    public int predictedScore4Y = 269;

    public int predictedScore5X = 333;
    public int predictedScore5Y = 333;

    public int predictedScore6X = 333;
    public int predictedScore6Y = 398;

    public int predictedScore7X = 333;
    public int predictedScore7Y = 465;

    public int predictedScore8X = 333;
    public int predictedScore8Y = 528;

    public int predictedScoreLabelX = 330;
    public int predictedScoreLabelY = 25;
    public int avgTeleScaleLabelX = 480;
    public int avgTeleScaleLabelY = 25;
    public int avgAutoScaleLabelX = 390;
    public int avgAutoScaleLabelY = 25;
    public int avgTeleSwitchLabelX = 670;
    public int avgTeleSwitchLabelY = 25;
    public int avgAutoSwitchLabelX = 570;
    public int avgAutoSwitchLabelY = 25;
    public int avgVaultLabelX = 770;
    public int avgVaultLabelY = 25;
    public int avgClimbsLabelX = 830;
    public int avgClimbsLabelY = 25;


    public int alliance1TextY = 50;
    public int alliance1TextX = 150;
    public int alliance2TextY = 115;
    public int alliance2TextX = 150;
    public int alliance3TextY = 180;
    public int alliance3TextX = 150;
    public int alliance4TextY = 245;
    public int alliance4TextX = 150;
    public int alliance5TextY = 310;
    public int alliance5TextX = 150;
    public int alliance6TextY = 375;
    public int alliance6TextX = 150;
    public int alliance7TextY = 440;
    public int alliance7TextX = 150;
    public int alliance8TextY = 505;
    public int alliance8TextX = 150;
    public int robotTextY = 50;
    public int robotTextX = 5;

    public int startX = 5;
    public int startY = 38;
    public int incrX = 30;
    public int allianceIncrX = 55;
    public int incrY = 25;
    public int currX = startX;
    public int currY = startY;
    public int columns = 4;
    public int robotColumns = 4;
    public int robotYOffset = 30;
    public int alliance1YOffset = 30;
    public int alliance2YOffset = 30;
    public int alliance3YOffset = 30;
    public int alliance4Columns = 3;
    public int alliance4YOffset = 30;
    public int alliance5Columns = 3;
    public int alliance5YOffset = 30;
    public int alliance6Columns = 3;
    public int alliance6YOffset = 30;
    public int alliance7Columns = 3;
    public int alliance7YOffset = 30;
    public int alliance8Columns = 3;
    public int alliance8YOffset = 30;

    @Override
    public void start(Stage primaryStage) throws Exception{
        getDataFromDB();
        Group root = new Group();
        primaryStage.setTitle("Playoff Predictor");
        primaryStage.setScene(new Scene(root, 900, 650));
        Button bracket = new Button();
        bracket.setLayoutX(5);
        bracket.setLayoutY(5);
        bracket.setPrefSize(95, 10);
        bracket.setText("Create Bracket");
        root.getChildren().add(bracket);
        //make new page to show Bracket
        bracket.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                         if ((alliance1TextList.size() < 3) ||
                                (alliance2TextList.size() < 3) ||
                                (alliance3TextList.size() < 3) ||
                                (alliance4TextList.size() < 3) ||
                                (alliance5TextList.size() < 3) ||
                                (alliance6TextList.size() < 3) ||
                                (alliance7TextList.size() < 3) ||
                                (alliance8TextList.size() < 3)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Enter More Robots");
                            alert.setHeaderText("24 Robots must be entered into the boxes to open this page");
                            alert.showAndWait();
                            exit();
                        }

                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        dialog.initOwner(primaryStage);
                        GridPane bracket = new GridPane ();
                        bracket.setHgap(10);
                        bracket.setVgap(10);
                        bracket.setPadding(new Insets(0, 10, 0, 10));
                        Scene dialogScene = new Scene(bracket, 900, 650);

                        Text alliance1Label = new Text("Alliance 1");
                        alliance1Label.setStyle("-fx-font: 15 cambria");
                        alliance1Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(alliance1Label, 0, 0);

                        Text alliance1Score = new Text("");
                        alliance1Score.setStyle("-fx-font: 13 cambria");
                        alliance1Score.setFill(Color.RED);
                        bracket.add(alliance1Score, 0, 1);
                        alliance1Score.setText(predictedScore1.getText().toString());


                        Text A1VA8 = new Text ("Vs.");
                        A1VA8.setStyle("-fx-font: 13 cambria");
                        bracket.add(A1VA8, 0, 2);

                        Text alliance8Label = new Text("Alliance 8");
                        alliance8Label.setStyle("-fx-font: 15 cambria");
                        alliance8Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(alliance8Label, 0, 3);

                        Text alliance8Score = new Text("");
                        alliance8Score.setStyle("-fx-font: 13 cambria");
                        alliance8Score.setFill(Color.RED);
                        bracket.add(alliance8Score, 0, 4);
                        alliance8Score.setText(predictedScore8.getText().toString());

                        Text alliance3Label = new Text("Alliance 3");
                        alliance3Label.setStyle("-fx-font: 15 cambria");
                        alliance3Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(alliance3Label, 0, 18);

                        Text alliance3Score = new Text("");
                        alliance3Score.setStyle("-fx-font: 13 cambria");
                        alliance3Score.setFill(Color.RED);
                        bracket.add(alliance3Score, 0, 19);
                        alliance3Score.setText(predictedScore3.getText().toString());

                        Text A3VA6 = new Text ("Vs.");
                        A3VA6.setStyle("-fx-font: 13 cambria");
                        bracket.add(A3VA6, 0, 20);

                        Text alliance6Label = new Text("Alliance 6");
                        alliance6Label.setStyle("-fx-font: 15 cambria");
                        alliance6Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(alliance6Label, 0, 21);

                        Text alliance6Score = new Text("");
                        alliance6Score.setStyle("-fx-font: 13 cambria");
                        alliance6Score.setFill(Color.RED);
                        bracket.add(alliance6Score, 0, 22);
                        alliance6Score.setText(predictedScore6.getText().toString());

                        Text alliance2Label = new Text("Alliance 2");
                        alliance2Label.setStyle("-fx-font: 15 cambria");
                        alliance2Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(alliance2Label, 0, 12);

                        Text alliance2Score = new Text("");
                        alliance2Score.setStyle("-fx-font: 13 cambria");
                        alliance2Score.setFill(Color.RED);
                        bracket.add(alliance2Score, 0, 13);
                        alliance2Score.setText(predictedScore2.getText().toString());

                        Text A2VA7 = new Text ("Vs.");
                        A2VA7.setStyle("-fx-font: 13 cambria");
                        bracket.add(A2VA7, 0, 14);

                        Text alliance7Label = new Text("Alliance 7");
                        alliance7Label.setStyle("-fx-font: 15 cambria");
                        alliance7Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(alliance7Label, 0, 15);

                        Text alliance7Score = new Text("");
                        alliance7Score.setStyle("-fx-font: 13 cambria");
                        alliance7Score.setFill(Color.RED);
                        bracket.add(alliance7Score, 0, 16);
                        alliance7Score.setText(predictedScore7.getText().toString());

                        Text alliance4Label = new Text("Alliance 4");
                        alliance4Label.setStyle("-fx-font: 15 cambria");
                        alliance4Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(alliance4Label, 0, 6);

                        Text alliance4Score = new Text("");
                        alliance4Score.setStyle("-fx-font: 13 cambria");
                        alliance4Score.setFill(Color.RED);
                        bracket.add(alliance4Score, 0, 7);
                        alliance4Score.setText(predictedScore4.getText().toString());

                        Text A4VA5 = new Text ("Vs.");
                        A4VA5.setStyle("-fx-font: 13 cambria");
                        bracket.add(A4VA5, 0, 8);

                        Text alliance5Label = new Text("Alliance 5");
                        alliance5Label.setStyle("-fx-font: 15 cambria");
                        alliance5Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(alliance5Label, 0, 9);

                        Text alliance5Score = new Text("");
                        alliance5Score.setStyle("-fx-font: 13 cambria");
                        alliance5Score.setFill(Color.RED);
                        bracket.add(alliance5Score, 0, 10);
                        alliance5Score.setText(predictedScore5.getText().toString());

                        Text A1vA8Label = new Text ("");
                        A1vA8Label.setStyle("-fx-font: 15 cambria");
                        A1vA8Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(A1vA8Label, 3, 2);
                        Text A1vA8Score = new Text ("");
                        A1vA8Score.setStyle("-fx-font: 13 cambria");
                        A1vA8Score.setFill(Color.RED);
                        bracket.add(A1vA8Score, 3, 3);
                        if (Double.parseDouble(alliance1Score.getText().toString()) >= (Double.parseDouble(alliance8Score.getText().toString()))){
                            A1vA8Label.setText(alliance1Label.getText().toString());
                            A1vA8Score.setText(predictedScore1.getText().toString());
                        } else if (Double.parseDouble(alliance1Score.getText().toString()) <= (Double.parseDouble(alliance8Score.getText().toString()))){
                            A1vA8Label.setText(alliance8Label.getText().toString());
                            A1vA8Score.setText(predictedScore8.getText().toString());
                        }

                        Text A3vA6Label = new Text ("");
                        A3vA6Label.setStyle("-fx-font: 15 cambria");
                        A3vA6Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(A3vA6Label, 3, 20);
                        Text A3vA6Score = new Text ("");
                        A3vA6Score.setStyle("-fx-font: 13 cambria");
                        A3vA6Score.setFill(Color.RED);
                        bracket.add(A3vA6Score, 3,21);
                        if (Double.parseDouble(alliance3Score.getText().toString()) >= (Double.parseDouble(alliance6Score.getText().toString()))){
                            A3vA6Label.setText(alliance3Label.getText().toString());
                            A3vA6Score.setText(predictedScore3.getText().toString());
                        } else if (Double.parseDouble(alliance3Score.getText().toString()) <= (Double.parseDouble(alliance6Score.getText().toString()))){
                            A3vA6Label.setText(alliance6Label.getText().toString());
                            A3vA6Score.setText(predictedScore6.getText().toString());
                        }

                        Text A7vA2Label = new Text ("");
                        A7vA2Label.setStyle("-fx-font: 15 cambria");
                        bracket.add(A7vA2Label, 3, 14);
                        A7vA2Label.setFill(Color.MEDIUMBLUE);
                        Text A7vA2Score = new Text ("");
                        A7vA2Score.setStyle("-fx-font: 13 cambria");
                        A7vA2Score.setFill(Color.RED);
                        bracket.add(A7vA2Score, 3, 15);
                        if (Double.parseDouble(alliance7Score.getText().toString()) >= (Double.parseDouble(alliance2Score.getText().toString()))){
                            A7vA2Label.setText(alliance7Label.getText().toString());
                            A7vA2Score.setText(predictedScore7.getText().toString());
                        } else if (Double.parseDouble(alliance7Score.getText().toString()) <= (Double.parseDouble(alliance2Score.getText().toString()))){
                            A7vA2Label.setText(alliance2Label.getText().toString());
                            A7vA2Score.setText(predictedScore2.getText().toString());
                        }

                        Text A4vA5Label = new Text ("");
                        A4vA5Label.setStyle("-fx-font: 15 cambria");
                        bracket.add(A4vA5Label, 3, 8);
                        A4vA5Label.setFill(Color.MEDIUMBLUE);
                        Text A4vA5Score = new Text ("");
                        A4vA5Score.setStyle("-fx-font: 13 cambria");
                        A4vA5Score.setFill(Color.RED);
                        bracket.add(A4vA5Score, 3, 9);
                        if (Double.parseDouble(alliance4Score.getText().toString()) >= (Double.parseDouble(alliance5Score.getText().toString()))){
                            A4vA5Label.setText(alliance4Label.getText().toString());
                            A4vA5Score.setText(predictedScore4.getText().toString());
                        } else if (Double.parseDouble(alliance4Score.getText().toString()) <= (Double.parseDouble(alliance5Score.getText().toString()))){
                            A4vA5Label.setText(alliance5Label.getText().toString());
                            A4vA5Score.setText(predictedScore5.getText().toString());
                        }

                        Text vs21 = new Text ("Vs.");
                        vs21.setStyle("-fx-font: 13 cambria");
                        bracket.add(vs21, 3, 6);

                        Text vs22 = new Text ("Vs.");
                        vs22.setStyle("-fx-font: 13 cambria");
                        bracket.add(vs22, 3, 18);

                        Text f1Label = new Text ("");
                        f1Label.setStyle("-fx-font: 15 cambria");
                        f1Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(f1Label, 5, 6);
                        Text f1Score = new Text ("");
                        f1Score.setStyle("-fx-font: 13 cambria");
                        f1Score.setFill(Color.RED);
                        bracket.add(f1Score, 5,7);
                        if (Double.parseDouble(A1vA8Score.getText().toString()) >= (Double.parseDouble(A4vA5Score.getText().toString()))){
                            f1Label.setText(A1vA8Label.getText().toString());
                            f1Score.setText(A1vA8Score.getText().toString());
                        } else if (Double.parseDouble(A1vA8Score.getText().toString()) <= (Double.parseDouble(A4vA5Score.getText().toString()))){
                            f1Label.setText(A4vA5Label.getText().toString());
                            f1Score.setText(A4vA5Score.getText().toString());
                        }

                        Text f2Label = new Text ("");
                        f2Label.setStyle("-fx-font: 15 cambria");
                        f2Label.setFill(Color.MEDIUMBLUE);
                        bracket.add(f2Label, 5, 18);
                        Text f2Score = new Text ("");
                        f2Score.setStyle("-fx-font: 13 cambria");
                        f2Score.setFill(Color.RED);
                        bracket.add(f2Score, 5, 19);
                        if (Double.parseDouble(A7vA2Score.getText().toString()) >= (Double.parseDouble(A3vA6Score.getText().toString()))){
                            f2Label.setText(A7vA2Label.getText().toString());
                            f2Score.setText(A7vA2Score.getText().toString());
                        } else if (Double.parseDouble(A7vA2Score.getText().toString()) <= (Double.parseDouble(A3vA6Score.getText().toString()))){
                            f2Label.setText(A3vA6Label.getText().toString());
                            f2Score.setText(A3vA6Score.getText().toString());
                        }

                        Text vF = new Text("Vs.");
                        vF.setStyle("-fx-font: 13 cambria");
                        bracket.add(vF, 5, 12);

                        Text wLabel = new Text ("");
                        wLabel.setStyle("-fx-font: 18 cambria");
                        bracket.add(wLabel, 7, 12);
                        wLabel.setFill(Color.MEDIUMBLUE);
                        if (Double.parseDouble(f1Score.getText().toString()) >= (Double.parseDouble(f2Score.getText().toString()))){
                            wLabel.setText(f1Label.getText().toString());
                        } else if (Double.parseDouble(f1Score.getText().toString()) <= (Double.parseDouble(f2Score.getText().toString()))){
                            wLabel.setText(f2Label.getText().toString());
                        }

                        dialog.setScene(dialogScene);
                        dialog.show();

                    }});
        Button scores = new Button();
        scores.setLayoutX(105);
        scores.setLayoutY(5);
        scores.setPrefSize(85, 10);
        scores.setText("Show Scores");
        root.getChildren().add(scores);
        //make new page to show scores, high/low/raw
        scores.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if ((alliance1TextList.size() < 3) ||
                                (alliance2TextList.size() < 3) ||
                                (alliance3TextList.size() < 3) ||
                                (alliance4TextList.size() < 3) ||
                                (alliance5TextList.size() < 3) ||
                                (alliance6TextList.size() < 3) ||
                                (alliance7TextList.size() < 3) ||
                                (alliance8TextList.size() < 3)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Enter More Robots");
                            alert.setHeaderText("24 Robots must be entered into the boxes to open this page");
                            alert.showAndWait();
                            exit();
                        }
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        dialog.initOwner(primaryStage);
                        GridPane scores = new GridPane();
                        scores.setHgap(10);
                        scores.setVgap(10);
                        scores.setPadding(new Insets(0, 10, 0, 10));
                        Scene dialogScene = new Scene(scores, 900, 650);

                        Text scoreHighLabel = new Text("Rounded Score");
                        scoreHighLabel.setStyle("-fx-font: 24 cambria");
                        scoreHighLabel.setFill(Color.MEDIUMBLUE);
                        scores.add(scoreHighLabel, 2, 0);

                        Text scoreRawLabel = new Text("Raw Score");
                        scoreRawLabel.setStyle("-fx-font: 24 cambria");
                        scoreRawLabel.setFill(Color.MEDIUMBLUE);
                        scores.add(scoreRawLabel, 3, 0);

                        Text scoreLowLabel = new Text("Low Score");
                        scoreLowLabel.setStyle("-fx-font: 24 cambria");
                        scoreLowLabel.setFill(Color.MEDIUMBLUE);
                        scores.add(scoreLowLabel, 4, 0);

                        Text alliance1Label = new Text("Alliance 1");
                        alliance1Label.setStyle("-fx-font: 24 cambria");
                        alliance1Label.setFill(Color.MEDIUMBLUE);
                        scores.add(alliance1Label, 0, 1);

                        Text alliance2Label = new Text("Alliance 2");
                        alliance2Label.setStyle("-fx-font: 24 cambria");
                        alliance2Label.setFill(Color.MEDIUMBLUE);
                        scores.add(alliance2Label, 0, 2);

                        Text alliance3Label = new Text("Alliance 3");
                        alliance3Label.setStyle("-fx-font: 24 cambria");
                        alliance3Label.setFill(Color.MEDIUMBLUE);
                        scores.add(alliance3Label, 0, 3);

                        Text alliance4Label = new Text("Alliance 4");
                        alliance4Label.setStyle("-fx-font: 24 cambria");
                        alliance4Label.setFill(Color.MEDIUMBLUE);
                        scores.add(alliance4Label, 0, 4);

                        Text alliance5Label = new Text("Alliance 5");
                        alliance5Label.setStyle("-fx-font: 24 cambria");
                        alliance5Label.setFill(Color.MEDIUMBLUE);
                        scores.add(alliance5Label, 0, 5);

                        Text alliance6Label = new Text("Alliance 6");
                        alliance6Label.setStyle("-fx-font: 24 cambria");
                        alliance6Label.setFill(Color.MEDIUMBLUE);
                        scores.add(alliance6Label, 0, 6);

                        Text alliance7Label = new Text("Alliance 7");
                        alliance7Label.setStyle("-fx-font: 24 cambria");
                        alliance7Label.setFill(Color.MEDIUMBLUE);
                        scores.add(alliance7Label, 0, 7);

                        Text alliance8Label = new Text("Alliance 8");
                        alliance8Label.setStyle("-fx-font: 24 cambria");
                        alliance8Label.setFill(Color.MEDIUMBLUE);
                        scores.add(alliance8Label, 0, 8);

                        Text alliance1Raw = new Text(String.format("%3.1f", alliance1.allianceRawStrength));
                        alliance1Raw.setStyle("-fx-font: 22 cambria");
                        alliance1Raw.setFill(Color.RED);
                        scores.add(alliance1Raw, 3, 1);

                        Text alliance1High = new Text(String.format("%3.1f", alliance1.allianceHighStrength));
                        alliance1High.setStyle("-fx-font: 22 cambria");
                        alliance1High.setFill(Color.RED);
                        scores.add(alliance1High, 2, 1);

                        Text alliance1Low = new Text(String.format("%3.1f", alliance1.allianceLowStrength));
                        alliance1Low.setStyle("-fx-font: 22 cambria");
                        alliance1Low.setFill(Color.RED);
                        scores.add(alliance1Low, 4, 1);

                        Text alliance2Raw = new Text(String.format("%3.1f", alliance2.allianceRawStrength));
                        alliance2Raw.setStyle("-fx-font: 22 cambria");
                        alliance2Raw.setFill(Color.RED);
                        scores.add(alliance2Raw, 3, 2);

                        Text alliance2High = new Text(String.format("%3.1f", alliance2.allianceHighStrength));
                        alliance2High.setStyle("-fx-font: 22 cambria");
                        alliance2High.setFill(Color.RED);
                        scores.add(alliance2High, 2, 2);

                        Text alliance2Low = new Text(String.format("%3.1f", alliance2.allianceLowStrength));
                        alliance2Low.setStyle("-fx-font: 22 cambria");
                        alliance2Low.setFill(Color.RED);
                        scores.add(alliance2Low, 4, 2);

                        Text alliance3Raw = new Text(String.format("%3.1f", alliance3.allianceRawStrength));
                        alliance3Raw.setStyle("-fx-font: 22 cambria");
                        alliance3Raw.setFill(Color.RED);
                        scores.add(alliance3Raw, 3, 3);

                        Text alliance3High = new Text(String.format("%3.1f", alliance3.allianceHighStrength));
                        alliance3High.setStyle("-fx-font: 22 cambria");
                        alliance3High.setFill(Color.RED);
                        scores.add(alliance3High, 2, 3);

                        Text alliance3Low = new Text(String.format("%3.1f", alliance3.allianceLowStrength));
                        alliance3Low.setStyle("-fx-font: 22 cambria");
                        alliance3Low.setFill(Color.RED);
                        scores.add(alliance3Low, 4, 3);

                        Text alliance4Raw = new Text(String.format("%3.1f", alliance4.allianceRawStrength));
                        alliance4Raw.setStyle("-fx-font: 22 cambria");
                        alliance4Raw.setFill(Color.RED);
                        scores.add(alliance4Raw, 3, 4);

                        Text alliance4High = new Text(String.format("%3.1f", alliance4.allianceHighStrength));
                        alliance4High.setStyle("-fx-font: 22 cambria");
                        alliance4High.setFill(Color.RED);
                        scores.add(alliance4High, 2, 4);

                        Text alliance4Low = new Text(String.format("%3.1f", alliance4.allianceLowStrength));
                        alliance4Low.setStyle("-fx-font: 22 cambria");
                        alliance4Low.setFill(Color.RED);
                        scores.add(alliance4Low, 4, 4);

                        Text alliance5Raw = new Text(String.format("%3.1f", alliance5.allianceRawStrength));
                        alliance5Raw.setStyle("-fx-font: 22 cambria");
                        alliance5Raw.setFill(Color.RED);
                        scores.add(alliance5Raw, 3, 5);

                        Text alliance5High = new Text(String.format("%3.1f", alliance5.allianceHighStrength));
                        alliance5High.setStyle("-fx-font: 22 cambria");
                        alliance5High.setFill(Color.RED);
                        scores.add(alliance5High, 2, 5);

                        Text alliance5Low = new Text(String.format("%3.1f", alliance5.allianceLowStrength));
                        alliance5Low.setStyle("-fx-font: 22 cambria");
                        alliance5Low.setFill(Color.RED);
                        scores.add(alliance5Low, 4, 5);

                        Text alliance6Raw = new Text(String.format("%3.1f", alliance6.allianceRawStrength));
                        alliance6Raw.setStyle("-fx-font: 22 cambria");
                        alliance6Raw.setFill(Color.RED);
                        scores.add(alliance6Raw, 3, 6);

                        Text alliance6High = new Text(String.format("%3.1f", alliance6.allianceHighStrength));
                        alliance6High.setStyle("-fx-font: 22 cambria");
                        alliance6High.setFill(Color.RED);
                        scores.add(alliance6High, 2, 6);

                        Text alliance6Low = new Text(String.format("%3.1f", alliance6.allianceLowStrength));
                        alliance6Low.setStyle("-fx-font: 22 cambria");
                        alliance6Low.setFill(Color.RED);
                        scores.add(alliance6Low, 4, 6);

                        Text alliance7Raw = new Text(String.format("%3.1f", alliance7.allianceRawStrength));
                        alliance7Raw.setStyle("-fx-font: 22 cambria");
                        alliance7Raw.setFill(Color.RED);
                        scores.add(alliance7Raw, 3, 7);

                        Text alliance7High = new Text(String.format("%3.1f", alliance7.allianceHighStrength));
                        alliance7High.setStyle("-fx-font: 22 cambria");
                        alliance7High.setFill(Color.RED);
                        scores.add(alliance7High, 2, 7);

                        Text alliance7Low = new Text(String.format("%3.1f", alliance7.allianceLowStrength));
                        alliance7Low.setStyle("-fx-font: 22 cambria");
                        alliance7Low.setFill(Color.RED);
                        scores.add(alliance7Low, 4, 7);

                        Text alliance8Raw = new Text(String.format("%3.1f", alliance8.allianceRawStrength));
                        alliance8Raw.setStyle("-fx-font: 22 cambria");
                        alliance8Raw.setFill(Color.RED);
                        scores.add(alliance8Raw, 3, 8);

                        Text alliance8High = new Text(String.format("%3.1f", alliance8.allianceHighStrength));
                        alliance8High.setStyle("-fx-font: 22 cambria");
                        alliance8High.setFill(Color.RED);
                        scores.add(alliance8High, 2, 8);

                        Text alliance8Low = new Text(String.format("%3.1f", alliance8.allianceLowStrength));
                        alliance8Low.setStyle("-fx-font: 22 cambria");
                        alliance8Low.setFill(Color.RED);
                        scores.add(alliance8Low, 4, 8);

                        dialog.setScene(dialogScene);
                        dialog.show();
                    }});

        Button data = new Button();
        data.setLayoutX(195);
        data.setLayoutY(5);
        data.setPrefSize(85, 10);
        data.setText("Sort Data");
        root.getChildren().add(data);
        //make new page to sort data
        data.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if ((alliance1TextList.size() < 3) ||
                                (alliance2TextList.size() < 3) ||
                                (alliance3TextList.size() < 3) ||
                                (alliance4TextList.size() < 3) ||
                                (alliance5TextList.size() < 3) ||
                                (alliance6TextList.size() < 3) ||
                                (alliance7TextList.size() < 3) ||
                                (alliance8TextList.size() < 3)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Enter More Robots");
                            alert.setHeaderText("24 Robots must be entered into the boxes to open this page");
                            alert.showAndWait();
                            exit();
                        }

                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        dialog.initOwner(primaryStage);
                        GridPane data = new GridPane();
                        data.setHgap(10);
                        data.setVgap(10);
                        data.setPadding(new Insets(0, 10, 0, 10));
                        Scene dialogScene = new Scene(data, 900, 650);

                        Text alliance1Label = new Text("Alliance 1");
                        alliance1Label.setStyle("-fx-font: 24 cambria");
                        alliance1Label.setFill(Color.MEDIUMBLUE);
                        data.add(alliance1Label, 0, 1);

                        Text alliance2Label = new Text("Alliance 2");
                        alliance2Label.setStyle("-fx-font: 24 cambria");
                        alliance2Label.setFill(Color.MEDIUMBLUE);
                        data.add(alliance2Label, 0, 2);

                        Text alliance3Label = new Text("Alliance 3");
                        alliance3Label.setStyle("-fx-font: 24 cambria");
                        alliance3Label.setFill(Color.MEDIUMBLUE);
                        data.add(alliance3Label, 0, 3);

                        Text alliance4Label = new Text("Alliance 4");
                        alliance4Label.setStyle("-fx-font: 24 cambria");
                        alliance4Label.setFill(Color.MEDIUMBLUE);
                        data.add(alliance4Label, 0, 4);

                        Text alliance5Label = new Text("Alliance 5");
                        alliance5Label.setStyle("-fx-font: 24 cambria");
                        alliance5Label.setFill(Color.MEDIUMBLUE);
                        data.add(alliance5Label, 0, 5);

                        Text alliance6Label = new Text("Alliance 6");
                        alliance6Label.setStyle("-fx-font: 24 cambria");
                        alliance6Label.setFill(Color.MEDIUMBLUE);
                        data.add(alliance6Label, 0, 6);

                        Text alliance7Label = new Text("Alliance 7");
                        alliance7Label.setStyle("-fx-font: 24 cambria");
                        alliance7Label.setFill(Color.MEDIUMBLUE);
                        data.add(alliance7Label, 0, 7);

                        Text alliance8Label = new Text("Alliance 8");
                        alliance8Label.setStyle("-fx-font: 24 cambria");
                        alliance8Label.setFill(Color.MEDIUMBLUE);
                        data.add(alliance8Label, 0, 8);

                        Text autoSwitch1 = new Text(avgAutoSwitchText1.getText().toString());
                        autoSwitch1.setStyle("-fx-font: 24 cambria");
                        autoSwitch1.setFill(Color.MEDIUMBLUE);
                        data.add(autoSwitch1, 1, 1);

                        Text autoSwitch2 = new Text(avgAutoSwitchText2.getText().toString());
                        autoSwitch2.setStyle("-fx-font: 24 cambria");
                        autoSwitch2.setFill(Color.MEDIUMBLUE);
                        data.add(autoSwitch2, 1, 2);

                        Text autoSwitch3 = new Text(avgAutoSwitchText3.getText().toString());
                        autoSwitch3.setStyle("-fx-font: 24 cambria");
                        autoSwitch3.setFill(Color.MEDIUMBLUE);
                        data.add(autoSwitch3, 1, 3);

                        Text autoSwitch4 = new Text(avgAutoSwitchText4.getText().toString());
                        autoSwitch4.setStyle("-fx-font: 24 cambria");
                        autoSwitch4.setFill(Color.MEDIUMBLUE);
                        data.add(autoSwitch4, 1, 4);

                        Text autoSwitch5 = new Text(avgAutoSwitchText5.getText().toString());
                        autoSwitch5.setStyle("-fx-font: 24 cambria");
                        autoSwitch5.setFill(Color.MEDIUMBLUE);
                        data.add(autoSwitch5, 1, 5);

                        Text autoSwitch6 = new Text(avgAutoSwitchText6.getText().toString());
                        autoSwitch6.setStyle("-fx-font: 24 cambria");
                        autoSwitch6.setFill(Color.MEDIUMBLUE);
                        data.add(autoSwitch6, 1, 6);

                        Text autoSwitch7 = new Text(avgAutoSwitchText7.getText().toString());
                        autoSwitch7.setStyle("-fx-font: 24 cambria");
                        autoSwitch7.setFill(Color.MEDIUMBLUE);
                        data.add(autoSwitch7, 1, 7);

                        Text autoSwitch8 = new Text(avgAutoSwitchText8.getText().toString());
                        autoSwitch8.setStyle("-fx-font: 24 cambria");
                        autoSwitch8.setFill(Color.MEDIUMBLUE);
                        data.add(autoSwitch8, 1, 8);

                        Text teleSwitch1 = new Text(avgTeleSwitchText1.getText().toString());
                        teleSwitch1.setStyle("-fx-font: 24 cambria");
                        teleSwitch1.setFill(Color.MEDIUMBLUE);
                        data.add(teleSwitch1, 2, 1);

                        Text teleSwitch2 = new Text(avgTeleSwitchText2.getText().toString());
                        teleSwitch2.setStyle("-fx-font: 24 cambria");
                        teleSwitch2.setFill(Color.MEDIUMBLUE);
                        data.add(teleSwitch2, 2, 2);

                        Text teleSwitch3 = new Text(avgTeleSwitchText3.getText().toString());
                        teleSwitch3.setStyle("-fx-font: 24 cambria");
                        teleSwitch3.setFill(Color.MEDIUMBLUE);
                        data.add(teleSwitch3, 2, 3);

                        Text teleSwitch4 = new Text(avgTeleSwitchText4.getText().toString());
                        teleSwitch4.setStyle("-fx-font: 24 cambria");
                        teleSwitch4.setFill(Color.MEDIUMBLUE);
                        data.add(teleSwitch4, 2, 4);

                        Text teleSwitch5 = new Text(avgTeleSwitchText5.getText().toString());
                        teleSwitch5.setStyle("-fx-font: 24 cambria");
                        teleSwitch5.setFill(Color.MEDIUMBLUE);
                        data.add(teleSwitch5, 2, 5);

                        Text teleSwitch6 = new Text(avgTeleSwitchText6.getText().toString());
                        teleSwitch6.setStyle("-fx-font: 24 cambria");
                        teleSwitch6.setFill(Color.MEDIUMBLUE);
                        data.add(teleSwitch6, 2, 6);

                        Text teleSwitch7 = new Text(avgTeleSwitchText7.getText().toString());
                        teleSwitch7.setStyle("-fx-font: 24 cambria");
                        teleSwitch7.setFill(Color.MEDIUMBLUE);
                        data.add(teleSwitch7, 2, 7);

                        Text teleSwitch8 = new Text(avgTeleSwitchText8.getText().toString());
                        teleSwitch8.setStyle("-fx-font: 24 cambria");
                        teleSwitch8.setFill(Color.MEDIUMBLUE);
                        data.add(teleSwitch8, 2, 8);

                        Text autoScale1 = new Text(avgAutoScaleText1.getText().toString());
                        autoScale1.setStyle("-fx-font: 24 cambria");
                        autoScale1.setFill(Color.MEDIUMBLUE);
                        data.add(autoScale1, 3, 1);

                        Text autoScale2 = new Text(avgAutoScaleText2.getText().toString());
                        autoScale2.setStyle("-fx-font: 24 cambria");
                        autoScale2.setFill(Color.MEDIUMBLUE);
                        data.add(autoScale2, 3, 2);

                        Text autoScale3 = new Text(avgAutoScaleText3.getText().toString());
                        autoScale3.setStyle("-fx-font: 24 cambria");
                        autoScale3.setFill(Color.MEDIUMBLUE);
                        data.add(autoScale3, 3, 3);

                        Text autoScale4 = new Text(avgAutoScaleText4.getText().toString());
                        autoScale4.setStyle("-fx-font: 24 cambria");
                        autoScale4.setFill(Color.MEDIUMBLUE);
                        data.add(autoScale4, 3, 4);

                        Text autoScale5 = new Text(avgAutoScaleText5.getText().toString());
                        autoScale5.setStyle("-fx-font: 24 cambria");
                        autoScale5.setFill(Color.MEDIUMBLUE);
                        data.add(autoScale5, 3, 5);

                        Text autoScale6 = new Text(avgAutoScaleText6.getText().toString());
                        autoScale6.setStyle("-fx-font: 24 cambria");
                        autoScale6.setFill(Color.MEDIUMBLUE);
                        data.add(autoScale6, 3, 6);

                        Text autoScale7 = new Text(avgAutoScaleText7.getText().toString());
                        autoScale7.setStyle("-fx-font: 24 cambria");
                        autoScale7.setFill(Color.MEDIUMBLUE);
                        data.add(autoScale7, 3, 7);

                        Text autoScale8 = new Text(avgAutoScaleText8.getText().toString());
                        autoScale8.setStyle("-fx-font: 24 cambria");
                        autoScale8.setFill(Color.MEDIUMBLUE);
                        data.add(autoScale8, 3, 8);

                        Text teleScale1 = new Text(avgTeleScaleText1.getText().toString());
                        teleScale1.setStyle("-fx-font: 24 cambria");
                        teleScale1.setFill(Color.MEDIUMBLUE);
                        data.add(teleScale1, 4, 1);

                        Text teleScale2 = new Text(avgTeleScaleText2.getText().toString());
                        teleScale2.setStyle("-fx-font: 24 cambria");
                        teleScale2.setFill(Color.MEDIUMBLUE);
                        data.add(teleScale2, 4, 2);

                        Text teleScale3 = new Text(avgTeleScaleText3.getText().toString());
                        teleScale3.setStyle("-fx-font: 24 cambria");
                        teleScale3.setFill(Color.MEDIUMBLUE);
                        data.add(teleScale3, 4, 3);

                        Text teleScale4 = new Text(avgTeleScaleText4.getText().toString());
                        teleScale4.setStyle("-fx-font: 24 cambria");
                        teleScale4.setFill(Color.MEDIUMBLUE);
                        data.add(teleScale4, 4, 4);

                        Text teleScale5 = new Text(avgTeleScaleText5.getText().toString());
                        teleScale5.setStyle("-fx-font: 24 cambria");
                        teleScale5.setFill(Color.MEDIUMBLUE);
                        data.add(teleScale5, 4, 5);

                        Text teleScale6 = new Text(avgTeleScaleText6.getText().toString());
                        teleScale6.setStyle("-fx-font: 24 cambria");
                        teleScale6.setFill(Color.MEDIUMBLUE);
                        data.add(teleScale6, 4, 6);

                        Text teleScale7 = new Text(avgTeleScaleText7.getText().toString());
                        teleScale7.setStyle("-fx-font: 24 cambria");
                        teleScale7.setFill(Color.MEDIUMBLUE);
                        data.add(teleScale7, 4, 7);

                        Text teleScale8 = new Text(avgTeleScaleText8.getText().toString());
                        teleScale8.setStyle("-fx-font: 24 cambria");
                        teleScale8.setFill(Color.MEDIUMBLUE);
                        data.add(teleScale8, 4, 8);

                        Text vault1 = new Text(avgVaultText1.getText().toString());
                        vault1.setStyle("-fx-font: 24 cambria");
                        vault1.setFill(Color.MEDIUMBLUE);
                        data.add(vault1, 5, 1);

                        Text vault2 = new Text(avgVaultText2.getText().toString());
                        vault2.setStyle("-fx-font: 24 cambria");
                        vault2.setFill(Color.MEDIUMBLUE);
                        data.add(vault2, 5, 2);

                        Text vault3 = new Text(avgVaultText3.getText().toString());
                        vault3.setStyle("-fx-font: 24 cambria");
                        vault3.setFill(Color.MEDIUMBLUE);
                        data.add(vault3, 5, 3);

                        Text vault4 = new Text(avgVaultText4.getText().toString());
                        vault4.setStyle("-fx-font: 24 cambria");
                        vault4.setFill(Color.MEDIUMBLUE);
                        data.add(vault4, 5, 4);

                        Text vault5 = new Text(avgVaultText5.getText().toString());
                        vault5.setStyle("-fx-font: 24 cambria");
                        vault5.setFill(Color.MEDIUMBLUE);
                        data.add(vault5, 5, 5);

                        Text vault6 = new Text(avgVaultText6.getText().toString());
                        vault6.setStyle("-fx-font: 24 cambria");
                        vault6.setFill(Color.MEDIUMBLUE);
                        data.add(vault6, 5, 6);

                        Text vault7 = new Text(avgVaultText7.getText().toString());
                        vault7.setStyle("-fx-font: 24 cambria");
                        vault7.setFill(Color.MEDIUMBLUE);
                        data.add(vault7, 5, 7);

                        Text vault8 = new Text(avgVaultText8.getText().toString());
                        vault8.setStyle("-fx-font: 24 cambria");
                        vault8.setFill(Color.MEDIUMBLUE);
                        data.add(vault8, 5, 8);

                        Text climb1 = new Text(avgClimbsText1.getText().toString());
                        climb1.setStyle("-fx-font: 24 cambria");
                        climb1.setFill(Color.MEDIUMBLUE);
                        data.add(climb1, 5, 1);

                        Text climb2 = new Text(avgClimbsText2.getText().toString());
                        climb2.setStyle("-fx-font: 24 cambria");
                        climb2.setFill(Color.MEDIUMBLUE);
                        data.add(climb2, 5, 2);

                        Text climb3 = new Text(avgClimbsText3.getText().toString());
                        climb3.setStyle("-fx-font: 24 cambria");
                        climb3.setFill(Color.MEDIUMBLUE);
                        data.add(climb3, 5, 3);

                        Text climb4 = new Text(avgClimbsText4.getText().toString());
                        climb4.setStyle("-fx-font: 24 cambria");
                        climb4.setFill(Color.MEDIUMBLUE);
                        data.add(climb4, 5, 4);

                        Text climb5 = new Text(avgClimbsText5.getText().toString());
                        climb5.setStyle("-fx-font: 24 cambria");
                        climb5.setFill(Color.MEDIUMBLUE);
                        data.add(climb5, 5, 5);

                        Text climb6 = new Text(avgClimbsText6.getText().toString());
                        climb6.setStyle("-fx-font: 24 cambria");
                        climb6.setFill(Color.MEDIUMBLUE);
                        data.add(climb6, 5, 6);

                        Text climb7 = new Text(avgClimbsText7.getText().toString());
                        climb7.setStyle("-fx-font: 24 cambria");
                        climb7.setFill(Color.MEDIUMBLUE);
                        data.add(climb7, 5, 7);

                        Text climb8 = new Text(avgClimbsText8.getText().toString());
                        climb8.setStyle("-fx-font: 24 cambria");
                        climb8.setFill(Color.MEDIUMBLUE);
                        data.add(climb8, 5, 8);

                        Button autoSwitchButton = new Button ("Auto Switch");
                        autoSwitchButton.setStyle("-fx-font: 24 cambria");
                        data.add(autoSwitchButton, 1, 0);
                        autoSwitchButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                ArrayList<AllianceData> sortList = new ArrayList<AllianceData>();
                                sortList.add(alliance1);
                                sortList.add(alliance2);
                                sortList.add(alliance3);
                                sortList.add(alliance4);
                                sortList.add(alliance5);
                                sortList.add(alliance6);
                                sortList.add(alliance7);
                                sortList.add(alliance8);
                                Collections.sort(sortList, new Comparator<AllianceData>() {
                                    public int compare(AllianceData o1, AllianceData o2) {
                                        if (o1.avgAutoSwitch == o2.avgAutoSwitch)
                                            return 0;
                                        return o1.avgAutoSwitch > o2.avgAutoSwitch ? -1 : 1;
                                    }
                                });
                                autoSwitch1.setText(String.format("%3.1f", sortList.get(0).avgAutoSwitch));
                                autoSwitch2.setText(String.format("%3.1f", sortList.get(1).avgAutoSwitch));
                                autoSwitch3.setText(String.format("%3.1f", sortList.get(2).avgAutoSwitch));
                                autoSwitch4.setText(String.format("%3.1f", sortList.get(3).avgAutoSwitch));
                                autoSwitch5.setText(String.format("%3.1f", sortList.get(4).avgAutoSwitch));
                                autoSwitch6.setText(String.format("%3.1f", sortList.get(5).avgAutoSwitch));
                                autoSwitch7.setText(String.format("%3.1f", sortList.get(6).avgAutoSwitch));
                                autoSwitch8.setText(String.format("%3.1f", sortList.get(7).avgAutoSwitch));

                                teleSwitch1.setText(String.format("%3.1f", sortList.get(0).avgTeleSwitch));
                                teleSwitch2.setText(String.format("%3.1f", sortList.get(1).avgTeleSwitch));
                                teleSwitch3.setText(String.format("%3.1f", sortList.get(2).avgTeleSwitch));
                                teleSwitch4.setText(String.format("%3.1f", sortList.get(3).avgTeleSwitch));
                                teleSwitch5.setText(String.format("%3.1f", sortList.get(4).avgTeleSwitch));
                                teleSwitch6.setText(String.format("%3.1f", sortList.get(5).avgTeleSwitch));
                                teleSwitch7.setText(String.format("%3.1f", sortList.get(6).avgTeleSwitch));
                                teleSwitch8.setText(String.format("%3.1f", sortList.get(7).avgTeleSwitch));

                                autoScale1.setText(String.format("%3.1f", sortList.get(0).avgAutoScale));
                                autoScale2.setText(String.format("%3.1f", sortList.get(1).avgAutoScale));
                                autoScale3.setText(String.format("%3.1f", sortList.get(2).avgAutoScale));
                                autoScale4.setText(String.format("%3.1f", sortList.get(3).avgAutoScale));
                                autoScale5.setText(String.format("%3.1f", sortList.get(4).avgAutoScale));
                                autoScale6.setText(String.format("%3.1f", sortList.get(5).avgAutoScale));
                                autoScale7.setText(String.format("%3.1f", sortList.get(6).avgAutoScale));
                                autoScale8.setText(String.format("%3.1f", sortList.get(7).avgAutoScale));

                                teleScale1.setText(String.format("%3.1f", sortList.get(0).avgTeleScale));
                                teleScale2.setText(String.format("%3.1f", sortList.get(1).avgTeleScale));
                                teleScale3.setText(String.format("%3.1f", sortList.get(2).avgTeleScale));
                                teleScale4.setText(String.format("%3.1f", sortList.get(3).avgTeleScale));
                                teleScale5.setText(String.format("%3.1f", sortList.get(4).avgTeleScale));
                                teleScale6.setText(String.format("%3.1f", sortList.get(5).avgTeleScale));
                                teleScale7.setText(String.format("%3.1f", sortList.get(6).avgTeleScale));
                                teleScale8.setText(String.format("%3.1f", sortList.get(7).avgTeleScale));

                                vault1.setText(String.format("%3.1f", sortList.get(0).avgVault));
                                vault2.setText(String.format("%3.1f", sortList.get(1).avgVault));
                                vault3.setText(String.format("%3.1f", sortList.get(2).avgVault));
                                vault4.setText(String.format("%3.1f", sortList.get(3).avgVault));
                                vault5.setText(String.format("%3.1f", sortList.get(4).avgVault));
                                vault6.setText(String.format("%3.1f", sortList.get(5).avgVault));
                                vault7.setText(String.format("%3.1f", sortList.get(6).avgVault));
                                vault8.setText(String.format("%3.1f", sortList.get(7).avgVault));

                                climb1.setText(String.format("%3.1f", sortList.get(0).avgClimbs));
                                climb2.setText(String.format("%3.1f", sortList.get(1).avgClimbs));
                                climb3.setText(String.format("%3.1f", sortList.get(2).avgClimbs));
                                climb4.setText(String.format("%3.1f", sortList.get(3).avgClimbs));
                                climb5.setText(String.format("%3.1f", sortList.get(4).avgClimbs));
                                climb6.setText(String.format("%3.1f", sortList.get(5).avgClimbs));
                                climb7.setText(String.format("%3.1f", sortList.get(6).avgClimbs));
                                climb8.setText(String.format("%3.1f", sortList.get(7).avgClimbs));

                                alliance1Label.setText("Alliance " + Integer.toString(sortList.get(0).allianceNumber));
                                alliance2Label.setText("Alliance " + Integer.toString(sortList.get(1).allianceNumber));
                                alliance3Label.setText("Alliance " + Integer.toString(sortList.get(2).allianceNumber));
                                alliance4Label.setText("Alliance " + Integer.toString(sortList.get(3).allianceNumber));
                                alliance5Label.setText("Alliance " + Integer.toString(sortList.get(4).allianceNumber));
                                alliance6Label.setText("Alliance " + Integer.toString(sortList.get(5).allianceNumber));
                                alliance7Label.setText("Alliance " +Integer.toString(sortList.get(6).allianceNumber));
                                alliance8Label.setText("Alliance " + Integer.toString(sortList.get(7).allianceNumber));
                            }});
                        Button teleSwitchButton = new Button ("Tele Switch");
                        teleSwitchButton.setStyle("-fx-font: 24 cambria");
                        data.add(teleSwitchButton, 2, 0);
                        teleSwitchButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                ArrayList<AllianceData> sortList = new ArrayList<AllianceData>();
                                sortList.add(alliance1);
                                sortList.add(alliance2);
                                sortList.add(alliance3);
                                sortList.add(alliance4);
                                sortList.add(alliance5);
                                sortList.add(alliance6);
                                sortList.add(alliance7);
                                sortList.add(alliance8);
                                Collections.sort(sortList, new Comparator<AllianceData>() {
                                    public int compare(AllianceData o1, AllianceData o2) {
                                        if (o1.avgTeleSwitch == o2.avgTeleSwitch)
                                            return 0;
                                        return o1.avgTeleSwitch > o2.avgTeleSwitch ? -1 : 1;
                                    }
                                });
                                autoSwitch1.setText(String.format("%3.1f", sortList.get(0).avgAutoSwitch));
                                autoSwitch2.setText(String.format("%3.1f", sortList.get(1).avgAutoSwitch));
                                autoSwitch3.setText(String.format("%3.1f", sortList.get(2).avgAutoSwitch));
                                autoSwitch4.setText(String.format("%3.1f", sortList.get(3).avgAutoSwitch));
                                autoSwitch5.setText(String.format("%3.1f", sortList.get(4).avgAutoSwitch));
                                autoSwitch6.setText(String.format("%3.1f", sortList.get(5).avgAutoSwitch));
                                autoSwitch7.setText(String.format("%3.1f", sortList.get(6).avgAutoSwitch));
                                autoSwitch8.setText(String.format("%3.1f", sortList.get(7).avgAutoSwitch));

                                teleSwitch1.setText(String.format("%3.1f", sortList.get(0).avgTeleSwitch));
                                teleSwitch2.setText(String.format("%3.1f", sortList.get(1).avgTeleSwitch));
                                teleSwitch3.setText(String.format("%3.1f", sortList.get(2).avgTeleSwitch));
                                teleSwitch4.setText(String.format("%3.1f", sortList.get(3).avgTeleSwitch));
                                teleSwitch5.setText(String.format("%3.1f", sortList.get(4).avgTeleSwitch));
                                teleSwitch6.setText(String.format("%3.1f", sortList.get(5).avgTeleSwitch));
                                teleSwitch7.setText(String.format("%3.1f", sortList.get(6).avgTeleSwitch));
                                teleSwitch8.setText(String.format("%3.1f", sortList.get(7).avgTeleSwitch));

                                autoScale1.setText(String.format("%3.1f", sortList.get(0).avgAutoScale));
                                autoScale2.setText(String.format("%3.1f", sortList.get(1).avgAutoScale));
                                autoScale3.setText(String.format("%3.1f", sortList.get(2).avgAutoScale));
                                autoScale4.setText(String.format("%3.1f", sortList.get(3).avgAutoScale));
                                autoScale5.setText(String.format("%3.1f", sortList.get(4).avgAutoScale));
                                autoScale6.setText(String.format("%3.1f", sortList.get(5).avgAutoScale));
                                autoScale7.setText(String.format("%3.1f", sortList.get(6).avgAutoScale));
                                autoScale8.setText(String.format("%3.1f", sortList.get(7).avgAutoScale));

                                teleScale1.setText(String.format("%3.1f", sortList.get(0).avgTeleScale));
                                teleScale2.setText(String.format("%3.1f", sortList.get(1).avgTeleScale));
                                teleScale3.setText(String.format("%3.1f", sortList.get(2).avgTeleScale));
                                teleScale4.setText(String.format("%3.1f", sortList.get(3).avgTeleScale));
                                teleScale5.setText(String.format("%3.1f", sortList.get(4).avgTeleScale));
                                teleScale6.setText(String.format("%3.1f", sortList.get(5).avgTeleScale));
                                teleScale7.setText(String.format("%3.1f", sortList.get(6).avgTeleScale));
                                teleScale8.setText(String.format("%3.1f", sortList.get(7).avgTeleScale));

                                vault1.setText(String.format("%3.1f", sortList.get(0).avgVault));
                                vault2.setText(String.format("%3.1f", sortList.get(1).avgVault));
                                vault3.setText(String.format("%3.1f", sortList.get(2).avgVault));
                                vault4.setText(String.format("%3.1f", sortList.get(3).avgVault));
                                vault5.setText(String.format("%3.1f", sortList.get(4).avgVault));
                                vault6.setText(String.format("%3.1f", sortList.get(5).avgVault));
                                vault7.setText(String.format("%3.1f", sortList.get(6).avgVault));
                                vault8.setText(String.format("%3.1f", sortList.get(7).avgVault));

                                climb1.setText(String.format("%3.1f", sortList.get(0).avgClimbs));
                                climb2.setText(String.format("%3.1f", sortList.get(1).avgClimbs));
                                climb3.setText(String.format("%3.1f", sortList.get(2).avgClimbs));
                                climb4.setText(String.format("%3.1f", sortList.get(3).avgClimbs));
                                climb5.setText(String.format("%3.1f", sortList.get(4).avgClimbs));
                                climb6.setText(String.format("%3.1f", sortList.get(5).avgClimbs));
                                climb7.setText(String.format("%3.1f", sortList.get(6).avgClimbs));
                                climb8.setText(String.format("%3.1f", sortList.get(7).avgClimbs));

                                alliance1Label.setText("Alliance " + Integer.toString(sortList.get(0).allianceNumber));
                                alliance2Label.setText("Alliance " + Integer.toString(sortList.get(1).allianceNumber));
                                alliance3Label.setText("Alliance " + Integer.toString(sortList.get(2).allianceNumber));
                                alliance4Label.setText("Alliance " + Integer.toString(sortList.get(3).allianceNumber));
                                alliance5Label.setText("Alliance " + Integer.toString(sortList.get(4).allianceNumber));
                                alliance6Label.setText("Alliance " + Integer.toString(sortList.get(5).allianceNumber));
                                alliance7Label.setText("Alliance " +Integer.toString(sortList.get(6).allianceNumber));
                                alliance8Label.setText("Alliance " + Integer.toString(sortList.get(7).allianceNumber));
                            }});

                        Button autoScaleButton = new Button ("Auto Scale");
                        autoScaleButton.setStyle("-fx-font: 24 cambria");
                        data.add(autoScaleButton, 3, 0);
                                autoScaleButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        ArrayList<AllianceData> sortList = new ArrayList<AllianceData>();
                                        sortList.add(alliance1);
                                        sortList.add(alliance2);
                                        sortList.add(alliance3);
                                        sortList.add(alliance4);
                                        sortList.add(alliance5);
                                        sortList.add(alliance6);
                                        sortList.add(alliance7);
                                        sortList.add(alliance8);
                                        Collections.sort(sortList, new Comparator<AllianceData>() {
                                            public int compare(AllianceData o1, AllianceData o2) {
                                                if (o1.avgAutoScale == o2.avgAutoScale)
                                                    return 0;
                                                return o1.avgAutoScale > o2.avgAutoScale ? -1 : 1;
                                            }
                                        });
                                        autoSwitch1.setText(String.format("%3.1f", sortList.get(0).avgAutoSwitch));
                                        autoSwitch2.setText(String.format("%3.1f", sortList.get(1).avgAutoSwitch));
                                        autoSwitch3.setText(String.format("%3.1f", sortList.get(2).avgAutoSwitch));
                                        autoSwitch4.setText(String.format("%3.1f", sortList.get(3).avgAutoSwitch));
                                        autoSwitch5.setText(String.format("%3.1f", sortList.get(4).avgAutoSwitch));
                                        autoSwitch6.setText(String.format("%3.1f", sortList.get(5).avgAutoSwitch));
                                        autoSwitch7.setText(String.format("%3.1f", sortList.get(6).avgAutoSwitch));
                                        autoSwitch8.setText(String.format("%3.1f", sortList.get(7).avgAutoSwitch));

                                        teleSwitch1.setText(String.format("%3.1f", sortList.get(0).avgTeleSwitch));
                                        teleSwitch2.setText(String.format("%3.1f", sortList.get(1).avgTeleSwitch));
                                        teleSwitch3.setText(String.format("%3.1f", sortList.get(2).avgTeleSwitch));
                                        teleSwitch4.setText(String.format("%3.1f", sortList.get(3).avgTeleSwitch));
                                        teleSwitch5.setText(String.format("%3.1f", sortList.get(4).avgTeleSwitch));
                                        teleSwitch6.setText(String.format("%3.1f", sortList.get(5).avgTeleSwitch));
                                        teleSwitch7.setText(String.format("%3.1f", sortList.get(6).avgTeleSwitch));
                                        teleSwitch8.setText(String.format("%3.1f", sortList.get(7).avgTeleSwitch));

                                        autoScale1.setText(String.format("%3.1f", sortList.get(0).avgAutoScale));
                                        autoScale2.setText(String.format("%3.1f", sortList.get(1).avgAutoScale));
                                        autoScale3.setText(String.format("%3.1f", sortList.get(2).avgAutoScale));
                                        autoScale4.setText(String.format("%3.1f", sortList.get(3).avgAutoScale));
                                        autoScale5.setText(String.format("%3.1f", sortList.get(4).avgAutoScale));
                                        autoScale6.setText(String.format("%3.1f", sortList.get(5).avgAutoScale));
                                        autoScale7.setText(String.format("%3.1f", sortList.get(6).avgAutoScale));
                                        autoScale8.setText(String.format("%3.1f", sortList.get(7).avgAutoScale));

                                        teleScale1.setText(String.format("%3.1f", sortList.get(0).avgTeleScale));
                                        teleScale2.setText(String.format("%3.1f", sortList.get(1).avgTeleScale));
                                        teleScale3.setText(String.format("%3.1f", sortList.get(2).avgTeleScale));
                                        teleScale4.setText(String.format("%3.1f", sortList.get(3).avgTeleScale));
                                        teleScale5.setText(String.format("%3.1f", sortList.get(4).avgTeleScale));
                                        teleScale6.setText(String.format("%3.1f", sortList.get(5).avgTeleScale));
                                        teleScale7.setText(String.format("%3.1f", sortList.get(6).avgTeleScale));
                                        teleScale8.setText(String.format("%3.1f", sortList.get(7).avgTeleScale));

                                        vault1.setText(String.format("%3.1f", sortList.get(0).avgVault));
                                        vault2.setText(String.format("%3.1f", sortList.get(1).avgVault));
                                        vault3.setText(String.format("%3.1f", sortList.get(2).avgVault));
                                        vault4.setText(String.format("%3.1f", sortList.get(3).avgVault));
                                        vault5.setText(String.format("%3.1f", sortList.get(4).avgVault));
                                        vault6.setText(String.format("%3.1f", sortList.get(5).avgVault));
                                        vault7.setText(String.format("%3.1f", sortList.get(6).avgVault));
                                        vault8.setText(String.format("%3.1f", sortList.get(7).avgVault));

                                        climb1.setText(String.format("%3.1f", sortList.get(0).avgClimbs));
                                        climb2.setText(String.format("%3.1f", sortList.get(1).avgClimbs));
                                        climb3.setText(String.format("%3.1f", sortList.get(2).avgClimbs));
                                        climb4.setText(String.format("%3.1f", sortList.get(3).avgClimbs));
                                        climb5.setText(String.format("%3.1f", sortList.get(4).avgClimbs));
                                        climb6.setText(String.format("%3.1f", sortList.get(5).avgClimbs));
                                        climb7.setText(String.format("%3.1f", sortList.get(6).avgClimbs));
                                        climb8.setText(String.format("%3.1f", sortList.get(7).avgClimbs));

                                        alliance1Label.setText("Alliance " + Integer.toString(sortList.get(0).allianceNumber));
                                        alliance2Label.setText("Alliance " + Integer.toString(sortList.get(1).allianceNumber));
                                        alliance3Label.setText("Alliance " + Integer.toString(sortList.get(2).allianceNumber));
                                        alliance4Label.setText("Alliance " + Integer.toString(sortList.get(3).allianceNumber));
                                        alliance5Label.setText("Alliance " + Integer.toString(sortList.get(4).allianceNumber));
                                        alliance6Label.setText("Alliance " + Integer.toString(sortList.get(5).allianceNumber));
                                        alliance7Label.setText("Alliance " +Integer.toString(sortList.get(6).allianceNumber));
                                        alliance8Label.setText("Alliance " + Integer.toString(sortList.get(7).allianceNumber));
                                    }});

                        Button teleScaleButton = new Button ("Tele Scale");
                        teleScaleButton.setStyle("-fx-font: 24 cambria");
                        data.add(teleScaleButton, 4, 0);
                                        teleScaleButton.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                ArrayList<AllianceData> sortList = new ArrayList<AllianceData>();
                                                sortList.add(alliance1);
                                                sortList.add(alliance2);
                                                sortList.add(alliance3);
                                                sortList.add(alliance4);
                                                sortList.add(alliance5);
                                                sortList.add(alliance6);
                                                sortList.add(alliance7);
                                                sortList.add(alliance8);
                                                Collections.sort(sortList, new Comparator<AllianceData>() {
                                                    public int compare(AllianceData o1, AllianceData o2) {
                                                        if (o1.avgTeleScale == o2.avgTeleScale)
                                                            return 0;
                                                        return o1.avgTeleScale > o2.avgTeleScale ? -1 : 1;
                                                    }
                                                });
                                                autoSwitch1.setText(String.format("%3.1f", sortList.get(0).avgAutoSwitch));
                                                autoSwitch2.setText(String.format("%3.1f", sortList.get(1).avgAutoSwitch));
                                                autoSwitch3.setText(String.format("%3.1f", sortList.get(2).avgAutoSwitch));
                                                autoSwitch4.setText(String.format("%3.1f", sortList.get(3).avgAutoSwitch));
                                                autoSwitch5.setText(String.format("%3.1f", sortList.get(4).avgAutoSwitch));
                                                autoSwitch6.setText(String.format("%3.1f", sortList.get(5).avgAutoSwitch));
                                                autoSwitch7.setText(String.format("%3.1f", sortList.get(6).avgAutoSwitch));
                                                autoSwitch8.setText(String.format("%3.1f", sortList.get(7).avgAutoSwitch));

                                                teleSwitch1.setText(String.format("%3.1f", sortList.get(0).avgTeleSwitch));
                                                teleSwitch2.setText(String.format("%3.1f", sortList.get(1).avgTeleSwitch));
                                                teleSwitch3.setText(String.format("%3.1f", sortList.get(2).avgTeleSwitch));
                                                teleSwitch4.setText(String.format("%3.1f", sortList.get(3).avgTeleSwitch));
                                                teleSwitch5.setText(String.format("%3.1f", sortList.get(4).avgTeleSwitch));
                                                teleSwitch6.setText(String.format("%3.1f", sortList.get(5).avgTeleSwitch));
                                                teleSwitch7.setText(String.format("%3.1f", sortList.get(6).avgTeleSwitch));
                                                teleSwitch8.setText(String.format("%3.1f", sortList.get(7).avgTeleSwitch));

                                                autoScale1.setText(String.format("%3.1f", sortList.get(0).avgAutoScale));
                                                autoScale2.setText(String.format("%3.1f", sortList.get(1).avgAutoScale));
                                                autoScale3.setText(String.format("%3.1f", sortList.get(2).avgAutoScale));
                                                autoScale4.setText(String.format("%3.1f", sortList.get(3).avgAutoScale));
                                                autoScale5.setText(String.format("%3.1f", sortList.get(4).avgAutoScale));
                                                autoScale6.setText(String.format("%3.1f", sortList.get(5).avgAutoScale));
                                                autoScale7.setText(String.format("%3.1f", sortList.get(6).avgAutoScale));
                                                autoScale8.setText(String.format("%3.1f", sortList.get(7).avgAutoScale));

                                                teleScale1.setText(String.format("%3.1f", sortList.get(0).avgTeleScale));
                                                teleScale2.setText(String.format("%3.1f", sortList.get(1).avgTeleScale));
                                                teleScale3.setText(String.format("%3.1f", sortList.get(2).avgTeleScale));
                                                teleScale4.setText(String.format("%3.1f", sortList.get(3).avgTeleScale));
                                                teleScale5.setText(String.format("%3.1f", sortList.get(4).avgTeleScale));
                                                teleScale6.setText(String.format("%3.1f", sortList.get(5).avgTeleScale));
                                                teleScale7.setText(String.format("%3.1f", sortList.get(6).avgTeleScale));
                                                teleScale8.setText(String.format("%3.1f", sortList.get(7).avgTeleScale));

                                                vault1.setText(String.format("%3.1f", sortList.get(0).avgVault));
                                                vault2.setText(String.format("%3.1f", sortList.get(1).avgVault));
                                                vault3.setText(String.format("%3.1f", sortList.get(2).avgVault));
                                                vault4.setText(String.format("%3.1f", sortList.get(3).avgVault));
                                                vault5.setText(String.format("%3.1f", sortList.get(4).avgVault));
                                                vault6.setText(String.format("%3.1f", sortList.get(5).avgVault));
                                                vault7.setText(String.format("%3.1f", sortList.get(6).avgVault));
                                                vault8.setText(String.format("%3.1f", sortList.get(7).avgVault));

                                                climb1.setText(String.format("%3.1f", sortList.get(0).avgClimbs));
                                                climb2.setText(String.format("%3.1f", sortList.get(1).avgClimbs));
                                                climb3.setText(String.format("%3.1f", sortList.get(2).avgClimbs));
                                                climb4.setText(String.format("%3.1f", sortList.get(3).avgClimbs));
                                                climb5.setText(String.format("%3.1f", sortList.get(4).avgClimbs));
                                                climb6.setText(String.format("%3.1f", sortList.get(5).avgClimbs));
                                                climb7.setText(String.format("%3.1f", sortList.get(6).avgClimbs));
                                                climb8.setText(String.format("%3.1f", sortList.get(7).avgClimbs));

                                                alliance1Label.setText("Alliance " + Integer.toString(sortList.get(0).allianceNumber));
                                                alliance2Label.setText("Alliance " + Integer.toString(sortList.get(1).allianceNumber));
                                                alliance3Label.setText("Alliance " + Integer.toString(sortList.get(2).allianceNumber));
                                                alliance4Label.setText("Alliance " + Integer.toString(sortList.get(3).allianceNumber));
                                                alliance5Label.setText("Alliance " + Integer.toString(sortList.get(4).allianceNumber));
                                                alliance6Label.setText("Alliance " + Integer.toString(sortList.get(5).allianceNumber));
                                                alliance7Label.setText("Alliance " +Integer.toString(sortList.get(6).allianceNumber));
                                                alliance8Label.setText("Alliance " + Integer.toString(sortList.get(7).allianceNumber));
                                            }});

                        Button vaultButton = new Button ("Vault");
                        vaultButton.setStyle("-fx-font: 24 cambria");
                        data.add(vaultButton, 5, 0);
                        vaultButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                ArrayList<AllianceData> sortList = new ArrayList<AllianceData>();
                                sortList.add(alliance1);
                                sortList.add(alliance2);
                                sortList.add(alliance3);
                                sortList.add(alliance4);
                                sortList.add(alliance5);
                                sortList.add(alliance6);
                                sortList.add(alliance7);
                                sortList.add(alliance8);
                                Collections.sort(sortList, new Comparator<AllianceData>() {
                                    public int compare(AllianceData o1, AllianceData o2) {
                                        if (o1.avgVault == o2.avgVault)
                                            return 0;
                                        return o1.avgVault > o2.avgVault ? -1 : 1;
                                    }
                                });
                                autoSwitch1.setText(String.format("%3.1f", sortList.get(0).avgAutoSwitch));
                                autoSwitch2.setText(String.format("%3.1f", sortList.get(1).avgAutoSwitch));
                                autoSwitch3.setText(String.format("%3.1f", sortList.get(2).avgAutoSwitch));
                                autoSwitch4.setText(String.format("%3.1f", sortList.get(3).avgAutoSwitch));
                                autoSwitch5.setText(String.format("%3.1f", sortList.get(4).avgAutoSwitch));
                                autoSwitch6.setText(String.format("%3.1f", sortList.get(5).avgAutoSwitch));
                                autoSwitch7.setText(String.format("%3.1f", sortList.get(6).avgAutoSwitch));
                                autoSwitch8.setText(String.format("%3.1f", sortList.get(7).avgAutoSwitch));

                                teleSwitch1.setText(String.format("%3.1f", sortList.get(0).avgTeleSwitch));
                                teleSwitch2.setText(String.format("%3.1f", sortList.get(1).avgTeleSwitch));
                                teleSwitch3.setText(String.format("%3.1f", sortList.get(2).avgTeleSwitch));
                                teleSwitch4.setText(String.format("%3.1f", sortList.get(3).avgTeleSwitch));
                                teleSwitch5.setText(String.format("%3.1f", sortList.get(4).avgTeleSwitch));
                                teleSwitch6.setText(String.format("%3.1f", sortList.get(5).avgTeleSwitch));
                                teleSwitch7.setText(String.format("%3.1f", sortList.get(6).avgTeleSwitch));
                                teleSwitch8.setText(String.format("%3.1f", sortList.get(7).avgTeleSwitch));

                                autoScale1.setText(String.format("%3.1f", sortList.get(0).avgAutoScale));
                                autoScale2.setText(String.format("%3.1f", sortList.get(1).avgAutoScale));
                                autoScale3.setText(String.format("%3.1f", sortList.get(2).avgAutoScale));
                                autoScale4.setText(String.format("%3.1f", sortList.get(3).avgAutoScale));
                                autoScale5.setText(String.format("%3.1f", sortList.get(4).avgAutoScale));
                                autoScale6.setText(String.format("%3.1f", sortList.get(5).avgAutoScale));
                                autoScale7.setText(String.format("%3.1f", sortList.get(6).avgAutoScale));
                                autoScale8.setText(String.format("%3.1f", sortList.get(7).avgAutoScale));

                                teleScale1.setText(String.format("%3.1f", sortList.get(0).avgTeleScale));
                                teleScale2.setText(String.format("%3.1f", sortList.get(1).avgTeleScale));
                                teleScale3.setText(String.format("%3.1f", sortList.get(2).avgTeleScale));
                                teleScale4.setText(String.format("%3.1f", sortList.get(3).avgTeleScale));
                                teleScale5.setText(String.format("%3.1f", sortList.get(4).avgTeleScale));
                                teleScale6.setText(String.format("%3.1f", sortList.get(5).avgTeleScale));
                                teleScale7.setText(String.format("%3.1f", sortList.get(6).avgTeleScale));
                                teleScale8.setText(String.format("%3.1f", sortList.get(7).avgTeleScale));

                                vault1.setText(String.format("%3.1f", sortList.get(0).avgVault));
                                vault2.setText(String.format("%3.1f", sortList.get(1).avgVault));
                                vault3.setText(String.format("%3.1f", sortList.get(2).avgVault));
                                vault4.setText(String.format("%3.1f", sortList.get(3).avgVault));
                                vault5.setText(String.format("%3.1f", sortList.get(4).avgVault));
                                vault6.setText(String.format("%3.1f", sortList.get(5).avgVault));
                                vault7.setText(String.format("%3.1f", sortList.get(6).avgVault));
                                vault8.setText(String.format("%3.1f", sortList.get(7).avgVault));

                                climb1.setText(String.format("%3.1f", sortList.get(0).avgClimbs));
                                climb2.setText(String.format("%3.1f", sortList.get(1).avgClimbs));
                                climb3.setText(String.format("%3.1f", sortList.get(2).avgClimbs));
                                climb4.setText(String.format("%3.1f", sortList.get(3).avgClimbs));
                                climb5.setText(String.format("%3.1f", sortList.get(4).avgClimbs));
                                climb6.setText(String.format("%3.1f", sortList.get(5).avgClimbs));
                                climb7.setText(String.format("%3.1f", sortList.get(6).avgClimbs));
                                climb8.setText(String.format("%3.1f", sortList.get(7).avgClimbs));

                                alliance1Label.setText("Alliance " + Integer.toString(sortList.get(0).allianceNumber));
                                alliance2Label.setText("Alliance " + Integer.toString(sortList.get(1).allianceNumber));
                                alliance3Label.setText("Alliance " + Integer.toString(sortList.get(2).allianceNumber));
                                alliance4Label.setText("Alliance " + Integer.toString(sortList.get(3).allianceNumber));
                                alliance5Label.setText("Alliance " + Integer.toString(sortList.get(4).allianceNumber));
                                alliance6Label.setText("Alliance " + Integer.toString(sortList.get(5).allianceNumber));
                                alliance7Label.setText("Alliance " +Integer.toString(sortList.get(6).allianceNumber));
                                alliance8Label.setText("Alliance " + Integer.toString(sortList.get(7).allianceNumber));
                            }});
                Button climbsButton = new Button ("Climbs");
                climbsButton.setStyle("-fx-font: 24 cambria");
                data.add(climbsButton, 5, 0);
                climbsButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ArrayList<AllianceData> sortList = new ArrayList<AllianceData>();
                        sortList.add(alliance1);
                        sortList.add(alliance2);
                        sortList.add(alliance3);
                        sortList.add(alliance4);
                        sortList.add(alliance5);
                        sortList.add(alliance6);
                        sortList.add(alliance7);
                        sortList.add(alliance8);
                        Collections.sort(sortList, new Comparator<AllianceData>() {
                            public int compare(AllianceData o1, AllianceData o2) {
                                if (o1.avgClimbs == o2.avgClimbs)
                                    return 0;
                                return o1.avgClimbs > o2.avgClimbs ? -1 : 1;
                            }
                        });
                        autoSwitch1.setText(String.format("%3.1f", sortList.get(0).avgAutoSwitch));
                        autoSwitch2.setText(String.format("%3.1f", sortList.get(1).avgAutoSwitch));
                        autoSwitch3.setText(String.format("%3.1f", sortList.get(2).avgAutoSwitch));
                        autoSwitch4.setText(String.format("%3.1f", sortList.get(3).avgAutoSwitch));
                        autoSwitch5.setText(String.format("%3.1f", sortList.get(4).avgAutoSwitch));
                        autoSwitch6.setText(String.format("%3.1f", sortList.get(5).avgAutoSwitch));
                        autoSwitch7.setText(String.format("%3.1f", sortList.get(6).avgAutoSwitch));
                        autoSwitch8.setText(String.format("%3.1f", sortList.get(7).avgAutoSwitch));

                        teleSwitch1.setText(String.format("%3.1f", sortList.get(0).avgTeleSwitch));
                        teleSwitch2.setText(String.format("%3.1f", sortList.get(1).avgTeleSwitch));
                        teleSwitch3.setText(String.format("%3.1f", sortList.get(2).avgTeleSwitch));
                        teleSwitch4.setText(String.format("%3.1f", sortList.get(3).avgTeleSwitch));
                        teleSwitch5.setText(String.format("%3.1f", sortList.get(4).avgTeleSwitch));
                        teleSwitch6.setText(String.format("%3.1f", sortList.get(5).avgTeleSwitch));
                        teleSwitch7.setText(String.format("%3.1f", sortList.get(6).avgTeleSwitch));
                        teleSwitch8.setText(String.format("%3.1f", sortList.get(7).avgTeleSwitch));

                        autoScale1.setText(String.format("%3.1f", sortList.get(0).avgAutoScale));
                        autoScale2.setText(String.format("%3.1f", sortList.get(1).avgAutoScale));
                        autoScale3.setText(String.format("%3.1f", sortList.get(2).avgAutoScale));
                        autoScale4.setText(String.format("%3.1f", sortList.get(3).avgAutoScale));
                        autoScale5.setText(String.format("%3.1f", sortList.get(4).avgAutoScale));
                        autoScale6.setText(String.format("%3.1f", sortList.get(5).avgAutoScale));
                        autoScale7.setText(String.format("%3.1f", sortList.get(6).avgAutoScale));
                        autoScale8.setText(String.format("%3.1f", sortList.get(7).avgAutoScale));

                        teleScale1.setText(String.format("%3.1f", sortList.get(0).avgTeleScale));
                        teleScale2.setText(String.format("%3.1f", sortList.get(1).avgTeleScale));
                        teleScale3.setText(String.format("%3.1f", sortList.get(2).avgTeleScale));
                        teleScale4.setText(String.format("%3.1f", sortList.get(3).avgTeleScale));
                        teleScale5.setText(String.format("%3.1f", sortList.get(4).avgTeleScale));
                        teleScale6.setText(String.format("%3.1f", sortList.get(5).avgTeleScale));
                        teleScale7.setText(String.format("%3.1f", sortList.get(6).avgTeleScale));
                        teleScale8.setText(String.format("%3.1f", sortList.get(7).avgTeleScale));

                        vault1.setText(String.format("%3.1f", sortList.get(0).avgVault));
                        vault2.setText(String.format("%3.1f", sortList.get(1).avgVault));
                        vault3.setText(String.format("%3.1f", sortList.get(2).avgVault));
                        vault4.setText(String.format("%3.1f", sortList.get(3).avgVault));
                        vault5.setText(String.format("%3.1f", sortList.get(4).avgVault));
                        vault6.setText(String.format("%3.1f", sortList.get(5).avgVault));
                        vault7.setText(String.format("%3.1f", sortList.get(6).avgVault));
                        vault8.setText(String.format("%3.1f", sortList.get(7).avgVault));

                        climb1.setText(String.format("%3.1f", sortList.get(0).avgClimbs));
                        climb2.setText(String.format("%3.1f", sortList.get(1).avgClimbs));
                        climb3.setText(String.format("%3.1f", sortList.get(2).avgClimbs));
                        climb4.setText(String.format("%3.1f", sortList.get(3).avgClimbs));
                        climb5.setText(String.format("%3.1f", sortList.get(4).avgClimbs));
                        climb6.setText(String.format("%3.1f", sortList.get(5).avgClimbs));
                        climb7.setText(String.format("%3.1f", sortList.get(6).avgClimbs));
                        climb8.setText(String.format("%3.1f", sortList.get(7).avgClimbs));

                        alliance1Label.setText("Alliance " + Integer.toString(sortList.get(0).allianceNumber));
                        alliance2Label.setText("Alliance " + Integer.toString(sortList.get(1).allianceNumber));
                        alliance3Label.setText("Alliance " + Integer.toString(sortList.get(2).allianceNumber));
                        alliance4Label.setText("Alliance " + Integer.toString(sortList.get(3).allianceNumber));
                        alliance5Label.setText("Alliance " + Integer.toString(sortList.get(4).allianceNumber));
                        alliance6Label.setText("Alliance " + Integer.toString(sortList.get(5).allianceNumber));
                        alliance7Label.setText("Alliance " +Integer.toString(sortList.get(6).allianceNumber));
                        alliance8Label.setText("Alliance " + Integer.toString(sortList.get(7).allianceNumber));
                    }});
                dialog.setScene(dialogScene);
                dialog.show();
            }});


        int currNum = 1;

        final Text alliance1Text = new Text (alliance1TextX,alliance1TextY-3,"Alliance 1");
        alliance1Text.setFill(Color.MEDIUMBLUE);
        alliance1Text.setStyle("-fx-font: 20 cambria");
        final Text alliance2Text = new Text (alliance2TextX,alliance2TextY-3,"Alliance 2");
        alliance2Text.setFill(Color.MEDIUMBLUE);
        alliance2Text.setStyle("-fx-font: 20 cambria");
        final Text alliance3Text = new Text (alliance3TextX,alliance3TextY-3,"Alliance 3");
        alliance3Text.setFill(Color.MEDIUMBLUE);
        alliance3Text.setStyle("-fx-font: 20 cambria");
        final Text alliance4Text = new Text (alliance4TextX,alliance4TextY-3,"Alliance 4");
        alliance4Text.setFill(Color.MEDIUMBLUE);
        alliance4Text.setStyle("-fx-font: 20 cambria");
        final Text alliance5Text = new Text (alliance5TextX,alliance5TextY-3,"Alliance 5");
        alliance5Text.setFill(Color.MEDIUMBLUE);
        alliance5Text.setStyle("-fx-font: 20 cambria");
        final Text alliance6Text = new Text (alliance6TextX,alliance6TextY-3,"Alliance 6");
        alliance6Text.setFill(Color.MEDIUMBLUE);
        alliance6Text.setStyle("-fx-font: 20 cambria");
        final Text alliance7Text = new Text (alliance7TextX,alliance7TextY-3,"Alliance 7");
        alliance7Text.setFill(Color.MEDIUMBLUE);
        alliance7Text.setStyle("-fx-font: 20 cambria");
        final Text alliance8Text = new Text (alliance8TextX,alliance8TextY-3,"Alliance 8");
        alliance8Text.setFill(Color.MEDIUMBLUE);
        alliance8Text.setStyle("-fx-font: 20 cambria");
        final Text robotText = new Text (robotTextX+27,robotTextY-3,"Robots");
        robotText.setFill(Color.MEDIUMBLUE);
        robotText.setStyle("-fx-font: 20 cambria");

        predictedScore1 = new Text(predictedScore1X,predictedScore1Y,"");
        predictedScore1.setFill(RED);
        predictedScore1.setStyle("-fx-font: 25 cambria");
        predictedScore2 = new Text(predictedScore2X,predictedScore2Y,"");
        predictedScore2.setFill(RED);
        predictedScore2.setStyle("-fx-font: 25 cambria");
        predictedScore3 = new Text(predictedScore3X,predictedScore3Y,"");
        predictedScore3.setFill(RED);
        predictedScore3.setStyle("-fx-font: 25 cambria");
        predictedScore4 = new Text(predictedScore4X,predictedScore4Y,"");
        predictedScore4.setFill(RED);
        predictedScore4.setStyle("-fx-font: 25 cambria");
        predictedScore5 = new Text(predictedScore5X,predictedScore5Y,"");
        predictedScore5.setFill(RED);
        predictedScore5.setStyle("-fx-font: 25 cambria");
        predictedScore6 = new Text(predictedScore6X,predictedScore6Y,"");
        predictedScore6.setFill(RED);
        predictedScore6.setStyle("-fx-font: 25 cambria");
        predictedScore7 = new Text(predictedScore7X,predictedScore7Y,"");
        predictedScore7.setFill(RED);
        predictedScore7.setStyle("-fx-font: 25 cambria");
        predictedScore8 = new Text(predictedScore8X,predictedScore8Y,"");
        predictedScore8.setFill(RED);
        predictedScore8.setStyle("-fx-font: 25 cambria");

        avgTeleScaleText1 = new Text (avgTeleScale1X,avgTeleScale1Y, "");
        avgTeleScaleText1.setFill(RED);
        avgTeleScaleText1.setStyle("-fx-font: 25 cambria");
        avgAutoScaleText1 = new Text (avgAutoScale1X,avgAutoScale1Y, "");
        avgAutoScaleText1.setFill(RED) ;
        avgAutoScaleText1.setStyle("-fx-font: 25 cambria");
        avgTeleSwitchText1 = new Text (avgTeleSwitch1X,avgTeleSwitch1Y, "");
        avgTeleSwitchText1.setFill(RED);
        avgTeleSwitchText1.setStyle("-fx-font: 25 cambria");
        avgAutoSwitchText1 = new Text (avgAutoSwitch1X,avgAutoSwitch1Y, "") ;
        avgAutoSwitchText1.setFill(RED);
        avgAutoSwitchText1.setStyle("-fx-font: 25 cambria");
        avgVaultText1 = new Text (avgVault1X,avgVault1Y, "");
        avgVaultText1.setFill(RED);
        avgVaultText1.setStyle("-fx-font: 25 cambria");
        avgClimbsText1 = new Text (avgClimbs1X,avgClimbs1Y, "");
        avgClimbsText1.setFill(RED);
        avgClimbsText1.setStyle("-fx-font: 25 cambria");

        avgTeleScaleText2 = new Text (avgTeleScale2X,avgTeleScale2Y, "");
        avgTeleScaleText2.setFill(RED);
        avgTeleScaleText2.setStyle("-fx-font: 25 cambria");
        avgAutoScaleText2 = new Text (avgAutoScale2X,avgAutoScale2Y, "");
        avgAutoScaleText2.setFill(RED) ;
        avgAutoScaleText2.setStyle("-fx-font: 25 cambria");
        avgTeleSwitchText2 = new Text (avgTeleSwitch2X,avgTeleSwitch2Y, "");
        avgTeleSwitchText2.setFill(RED);
        avgTeleSwitchText2.setStyle("-fx-font: 25 cambria");
        avgAutoSwitchText2 = new Text (avgAutoSwitch2X,avgAutoSwitch2Y, "") ;
        avgAutoSwitchText2.setFill(RED);
        avgAutoSwitchText2.setStyle("-fx-font: 25 cambria");
        avgVaultText2 = new Text (avgVault2X,avgVault2Y, "");
        avgVaultText2.setFill(RED);
        avgVaultText2.setStyle("-fx-font: 25 cambria");
        avgClimbsText2 = new Text (avgClimbs2X,avgClimbs2Y, "");
        avgClimbsText2.setFill(RED);
        avgClimbsText2.setStyle("-fx-font: 25 cambria");

        avgTeleScaleText3 = new Text (avgTeleScale3X,avgTeleScale3Y, "");
        avgTeleScaleText3.setFill(RED);
        avgTeleScaleText3.setStyle("-fx-font: 25 cambria");
        avgAutoScaleText3 = new Text (avgAutoScale3X,avgAutoScale3Y, "");
        avgAutoScaleText3.setFill(RED) ;
        avgAutoScaleText3.setStyle("-fx-font: 25 cambria");
        avgTeleSwitchText3 = new Text (avgTeleSwitch3X,avgTeleSwitch3Y, "");
        avgTeleSwitchText3.setFill(RED);
        avgTeleSwitchText3.setStyle("-fx-font: 25 cambria");
        avgAutoSwitchText3 = new Text (avgAutoSwitch3X,avgAutoSwitch3Y, "") ;
        avgAutoSwitchText3.setFill(RED);
        avgAutoSwitchText3.setStyle("-fx-font: 25 cambria");
        avgVaultText3 = new Text (avgVault3X,avgVault3Y, "");
        avgVaultText3.setFill(RED);
        avgVaultText3.setStyle("-fx-font: 25 cambria");
        avgClimbsText3 = new Text (avgClimbs3X,avgClimbs3Y, "");
        avgClimbsText3.setFill(RED);
        avgClimbsText3.setStyle("-fx-font: 25 cambria");

        avgTeleScaleText4 = new Text (avgTeleScale4X,avgTeleScale4Y, "");
        avgTeleScaleText4.setFill(RED);
        avgTeleScaleText4.setStyle("-fx-font: 25 cambria");
        avgAutoScaleText4 = new Text (avgAutoScale4X,avgAutoScale4Y, "");
        avgAutoScaleText4.setFill(RED) ;
        avgAutoScaleText4.setStyle("-fx-font: 25 cambria");
        avgTeleSwitchText4 = new Text (avgTeleSwitch4X,avgTeleSwitch4Y, "");
        avgTeleSwitchText4.setFill(RED);
        avgTeleSwitchText4.setStyle("-fx-font: 25 cambria");
        avgAutoSwitchText4 = new Text (avgAutoSwitch4X,avgAutoSwitch4Y, "") ;
        avgAutoSwitchText4.setFill(RED);
        avgAutoSwitchText4.setStyle("-fx-font: 25 cambria");
        avgVaultText4 = new Text (avgVault4X,avgVault4Y, "");
        avgVaultText4.setFill(RED);
        avgVaultText4.setStyle("-fx-font: 25 cambria");
        avgClimbsText4 = new Text (avgClimbs4X,avgClimbs4Y, "");
        avgClimbsText4.setFill(RED);
        avgClimbsText4.setStyle("-fx-font: 25 cambria");

        avgTeleScaleText5 = new Text (avgTeleScale5X,avgTeleScale5Y, "");
        avgTeleScaleText5.setFill(RED);
        avgTeleScaleText5.setStyle("-fx-font: 25 cambria");
        avgAutoScaleText5 = new Text (avgAutoScale5X,avgAutoScale5Y, "");
        avgAutoScaleText5.setFill(RED) ;
        avgAutoScaleText5.setStyle("-fx-font: 25 cambria");
        avgTeleSwitchText5 = new Text (avgTeleSwitch5X,avgTeleSwitch5Y, "");
        avgTeleSwitchText5.setFill(RED);
        avgTeleSwitchText5.setStyle("-fx-font: 25 cambria");
        avgAutoSwitchText5 = new Text (avgAutoSwitch5X,avgAutoSwitch5Y, "") ;
        avgAutoSwitchText5.setFill(RED);
        avgAutoSwitchText5.setStyle("-fx-font: 25 cambria");
        avgVaultText5 = new Text (avgVault5X,avgVault5Y, "");
        avgVaultText5.setFill(RED);
        avgVaultText5.setStyle("-fx-font: 25 cambria");
        avgClimbsText5 = new Text (avgClimbs5X,avgClimbs5Y, "");
        avgClimbsText5.setFill(RED);
        avgClimbsText5.setStyle("-fx-font: 25 cambria");

        avgTeleScaleText6 = new Text (avgTeleScale6X,avgTeleScale6Y, "");
        avgTeleScaleText6.setFill(RED);
        avgTeleScaleText6.setStyle("-fx-font: 25 cambria");
        avgAutoScaleText6 = new Text (avgAutoScale6X,avgAutoScale6Y, "");
        avgAutoScaleText6.setFill(RED) ;
        avgAutoScaleText6.setStyle("-fx-font: 25 cambria");
        avgTeleSwitchText6 = new Text (avgTeleSwitch6X,avgTeleSwitch6Y, "");
        avgTeleSwitchText6.setFill(RED);
        avgTeleSwitchText6.setStyle("-fx-font: 25 cambria");
        avgAutoSwitchText6 = new Text (avgAutoSwitch6X,avgAutoSwitch6Y, "") ;
        avgAutoSwitchText6.setFill(RED);
        avgAutoSwitchText6.setStyle("-fx-font: 25 cambria");
        avgVaultText6 = new Text (avgVault6X,avgVault6Y, "");
        avgVaultText6.setFill(RED);
        avgVaultText6.setStyle("-fx-font: 25 cambria");
        avgClimbsText6 = new Text (avgClimbs6X,avgClimbs6Y, "");
        avgClimbsText6.setFill(RED);
        avgClimbsText6.setStyle("-fx-font: 25 cambria");

        avgTeleScaleText7 = new Text (avgTeleScale7X,avgTeleScale7Y, "");
        avgTeleScaleText7.setFill(RED);
        avgTeleScaleText7.setStyle("-fx-font: 25 cambria");
        avgAutoScaleText7 = new Text (avgAutoScale7X,avgAutoScale7Y, "");
        avgAutoScaleText7.setFill(RED) ;
        avgAutoScaleText7.setStyle("-fx-font: 25 cambria");
        avgTeleSwitchText7 = new Text (avgTeleSwitch7X,avgTeleSwitch7Y, "");
        avgTeleSwitchText7.setFill(RED);
        avgTeleSwitchText7.setStyle("-fx-font: 25 cambria");
        avgAutoSwitchText7 = new Text (avgAutoSwitch7X,avgAutoSwitch7Y, "") ;
        avgAutoSwitchText7.setFill(RED);
        avgAutoSwitchText7.setStyle("-fx-font: 25 cambria");
        avgVaultText7 = new Text (avgVault7X,avgVault7Y, "");
        avgVaultText7.setFill(RED);
        avgVaultText7.setStyle("-fx-font: 25 cambria");
        avgClimbsText7 = new Text (avgClimbs7X,avgClimbs7Y, "");
        avgClimbsText7.setFill(RED);
        avgClimbsText7.setStyle("-fx-font: 25 cambria");

        avgTeleScaleText8 = new Text (avgTeleScale8X,avgTeleScale8Y, "");
        avgTeleScaleText8.setFill(RED);
        avgTeleScaleText8.setStyle("-fx-font: 25 cambria");
        avgAutoScaleText8 = new Text (avgAutoScale8X,avgAutoScale8Y, "");
        avgAutoScaleText8.setFill(RED) ;
        avgAutoScaleText8.setStyle("-fx-font: 25 cambria");
        avgTeleSwitchText8 = new Text (avgTeleSwitch8X,avgTeleSwitch8Y, "");
        avgTeleSwitchText8.setFill(RED);
        avgTeleSwitchText8.setStyle("-fx-font: 25 cambria");
        avgAutoSwitchText8 = new Text (avgAutoSwitch8X,avgAutoSwitch8Y, "") ;
        avgAutoSwitchText8.setFill(RED);
        avgAutoSwitchText8.setStyle("-fx-font: 25 cambria");
        avgVaultText8 = new Text (avgVault8X,avgVault8Y, "");
        avgVaultText8.setFill(RED);
        avgVaultText8.setStyle("-fx-font: 25 cambria");
        avgClimbsText8 = new Text (avgClimbs8X,avgClimbs8Y, "");
        avgClimbsText8.setFill(RED);
        avgClimbsText8.setStyle("-fx-font: 25 cambria");

        root.getChildren().add(predictedScore1);
        root.getChildren().add(predictedScore2);
        root.getChildren().add(predictedScore3);
        root.getChildren().add(predictedScore4);
        root.getChildren().add(predictedScore5);
        root.getChildren().add(predictedScore6);
        root.getChildren().add(predictedScore7);
        root.getChildren().add(predictedScore8);

        root.getChildren().add(avgTeleScaleText1);
        root.getChildren().add(avgAutoScaleText1);
        root.getChildren().add(avgTeleSwitchText1);
        root.getChildren().add(avgAutoSwitchText1);
        root.getChildren().add(avgVaultText1);
        root.getChildren().add(avgClimbsText1);

        root.getChildren().add(avgTeleScaleText2);
        root.getChildren().add(avgAutoScaleText2);
        root.getChildren().add(avgTeleSwitchText2);
        root.getChildren().add(avgAutoSwitchText2);
        root.getChildren().add(avgVaultText2);
        root.getChildren().add(avgClimbsText2);

        root.getChildren().add(avgTeleScaleText3);
        root.getChildren().add(avgAutoScaleText3);
        root.getChildren().add(avgTeleSwitchText3);
        root.getChildren().add(avgAutoSwitchText3);
        root.getChildren().add(avgVaultText3);
        root.getChildren().add(avgClimbsText3);

        root.getChildren().add(avgTeleScaleText4);
        root.getChildren().add(avgAutoScaleText4);
        root.getChildren().add(avgTeleSwitchText4);
        root.getChildren().add(avgAutoSwitchText4);
        root.getChildren().add(avgVaultText4);
        root.getChildren().add(avgClimbsText4);

        root.getChildren().add(avgTeleScaleText5);
        root.getChildren().add(avgAutoScaleText5);
        root.getChildren().add(avgTeleSwitchText5);
        root.getChildren().add(avgAutoSwitchText5);
        root.getChildren().add(avgVaultText5);
        root.getChildren().add(avgClimbsText5);

        root.getChildren().add(avgTeleScaleText6);
        root.getChildren().add(avgAutoScaleText6);
        root.getChildren().add(avgTeleSwitchText6);
        root.getChildren().add(avgAutoSwitchText6);
        root.getChildren().add(avgVaultText6);
        root.getChildren().add(avgClimbsText6);

        root.getChildren().add(avgTeleScaleText7);
        root.getChildren().add(avgAutoScaleText7);
        root.getChildren().add(avgTeleSwitchText7);
        root.getChildren().add(avgAutoSwitchText7);
        root.getChildren().add(avgVaultText7);
        root.getChildren().add(avgClimbsText7);

        root.getChildren().add(avgTeleScaleText8);
        root.getChildren().add(avgAutoScaleText8);
        root.getChildren().add(avgTeleSwitchText8);
        root.getChildren().add(avgAutoSwitchText8);
        root.getChildren().add(avgVaultText8);
        root.getChildren().add(avgClimbsText8);

        Text predictedScoreLabel = new Text (predictedScoreLabelX, predictedScoreLabelY, "Score");
        predictedScoreLabel.setFill(Color.MEDIUMBLUE);
        predictedScoreLabel.setStyle("-fx-font: 16 cambria");
        Text avgTeleScaleLabel = new Text (avgTeleScaleLabelX, avgTeleScaleLabelY, "Tele Scale");
        avgTeleScaleLabel.setFill(Color.MEDIUMBLUE);
        avgTeleScaleLabel.setStyle("-fx-font: 16 cambria");
        Text avgAutoScaleLabel = new Text (avgAutoScaleLabelX, avgAutoScaleLabelY, "Auto Scale");
        avgAutoScaleLabel.setFill(Color.MEDIUMBLUE);
        avgAutoScaleLabel.setStyle("-fx-font: 16 cambria");
        Text avgAutoSwitchLabel = new Text (avgAutoSwitchLabelX, avgAutoSwitchLabelY, "Auto Switch");
        avgAutoSwitchLabel.setFill(Color.MEDIUMBLUE);
        avgAutoSwitchLabel.setStyle("-fx-font: 16 cambria");
        Text avgTeleSwitchLabel = new Text (avgTeleSwitchLabelX, avgTeleSwitchLabelY, "Tele Switch");
        avgTeleSwitchLabel.setFill(Color.MEDIUMBLUE);
        avgTeleSwitchLabel.setStyle("-fx-font: 16 cambria");
        Text avgVaultLabel = new Text (avgVaultLabelX, avgVaultLabelY, "Vault");
        avgVaultLabel.setFill(Color.MEDIUMBLUE);
        avgVaultLabel.setStyle("-fx-font: 16 cambria");
        Text avgClimbsLabel = new Text (avgClimbsLabelX, avgClimbsLabelY, "Climbs");
        avgClimbsLabel.setFill(Color.MEDIUMBLUE);
        avgClimbsLabel.setStyle("-fx-font: 16 cambria");

        root.getChildren().add(predictedScoreLabel);
        root.getChildren().add(avgTeleScaleLabel);
        root.getChildren().add(avgAutoScaleLabel);
        root.getChildren().add(avgAutoSwitchLabel);
        root.getChildren().add(avgTeleSwitchLabel);
        root.getChildren().add(avgVaultLabel);
        root.getChildren().add(avgClimbsLabel);
        root.getChildren().add(alliance1Text);
        root.getChildren().add(alliance2Text);
        root.getChildren().add(alliance3Text);
        root.getChildren().add(alliance4Text);
        root.getChildren().add(alliance5Text);
        root.getChildren().add(alliance6Text);
        root.getChildren().add(alliance7Text);
        root.getChildren().add(alliance8Text);
        root.getChildren().add(robotText);

         if (adList1.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Database is empty");
            alert.setHeaderText("Check the SQL database");
            alert.showAndWait();
            exit();
        }

        final Rectangle robotRect = new Rectangle(robotTextX, robotTextY, 125, 575);
        robotRect.setFill(null);
        robotRect.setStroke(Color.MEDIUMBLUE);
        robotRect.toBack();
        root.getChildren().add(robotRect);

        final TextFlow robotTarget = new TextFlow(
        );
        robotTarget.setLayoutX(robotTextX);
        robotTarget.setLayoutY(robotTextY);
        robotTarget.setPrefSize(125,575);
        robotTarget.toBack();

        final Rectangle alliance1Rect = new Rectangle(alliance1TextX, alliance1TextY, 160, 40);
        alliance1Rect.setFill(null);
        alliance1Rect.setStroke(Color.MEDIUMBLUE);
        alliance1Rect.toBack();
        root.getChildren().add(alliance1Rect);

        final TextFlow alliance1Target = new TextFlow(
        );
        alliance1Target.setLayoutX(alliance1TextX);
        alliance1Target.setLayoutY(alliance1TextY);
        alliance1Target.setPrefSize(160,40);
        alliance1Target.toBack();

        final Rectangle alliance2Rect = new Rectangle(alliance2TextX, alliance2TextY, 160, 40);
        alliance2Rect.setFill(null);
        alliance2Rect.setStroke(Color.MEDIUMBLUE);
        alliance2Rect.toBack();
        root.getChildren().add(alliance2Rect);

        final TextFlow alliance2Target = new TextFlow(
        );
        alliance2Target.setLayoutX(alliance2TextX);
        alliance2Target.setLayoutY(alliance2TextY);
        alliance2Target.setPrefSize(160,40);
        alliance2Target.toBack();

        final Rectangle alliance3Rect = new Rectangle(alliance3TextX, alliance3TextY, 160, 40);
        alliance3Rect.setFill(null);
        alliance3Rect.setStroke(Color.MEDIUMBLUE);
        alliance3Rect.toBack();
        root.getChildren().add(alliance3Rect);

        final TextFlow alliance3Target = new TextFlow(
        );
        alliance3Target.setLayoutX(alliance3TextX);
        alliance3Target.setLayoutY(alliance3TextY);
        alliance3Target.setPrefSize(160,40);
        alliance3Target.toBack();

        final Rectangle alliance4Rect = new Rectangle(alliance4TextX, alliance4TextY, 160, 40);
        alliance4Rect.setFill(null);
        alliance4Rect.setStroke(Color.MEDIUMBLUE);
        alliance4Rect.toBack();
        root.getChildren().add(alliance4Rect);

        final TextFlow alliance4Target = new TextFlow(
        );
        alliance4Target.setLayoutX(alliance4TextX);
        alliance4Target.setLayoutY(alliance4TextY);
        alliance4Target.setPrefSize(160,40);
        alliance4Target.toBack();

        final Rectangle alliance5Rect = new Rectangle(alliance5TextX, alliance5TextY, 160, 40);
        alliance5Rect.setFill(null);
        alliance5Rect.setStroke(Color.MEDIUMBLUE);
        alliance5Rect.toBack();
        root.getChildren().add(alliance5Rect);

        final TextFlow alliance5Target = new TextFlow(
        );
        alliance5Target.setLayoutX(alliance5TextX);
        alliance5Target.setLayoutY(alliance5TextY);
        alliance5Target.setPrefSize(160,40);
        alliance5Target.toBack();

        final Rectangle alliance6Rect = new Rectangle(alliance6TextX, alliance6TextY, 160, 40);
        alliance6Rect.setFill(null);
        alliance6Rect.setStroke(Color.MEDIUMBLUE);
        alliance6Rect.toBack();
        root.getChildren().add(alliance6Rect);

        final TextFlow alliance6Target = new TextFlow(
        );
        alliance6Target.setLayoutX(alliance6TextX);
        alliance6Target.setLayoutY(alliance6TextY);
        alliance6Target.setPrefSize(160,40);
        alliance6Target.toBack();

        final Rectangle alliance7Rect = new Rectangle(alliance7TextX, alliance7TextY, 160, 40);
        alliance7Rect.setFill(null);
        alliance7Rect.setStroke(Color.MEDIUMBLUE);
        alliance7Rect.toBack();
        root.getChildren().add(alliance7Rect);

        final TextFlow alliance7Target = new TextFlow(
        );
        alliance7Target.setLayoutX(alliance7TextX);
        alliance7Target.setLayoutY(alliance7TextY);
        alliance7Target.setPrefSize(160,40);
        alliance7Target.toBack();

        final Rectangle alliance8Rect = new Rectangle(alliance8TextX, alliance8TextY, 160, 40);
        alliance8Rect.setFill(null);
        alliance8Rect.setStroke(Color.MEDIUMBLUE);
        alliance8Rect.toBack();
        root.getChildren().add(alliance8Rect);

        final TextFlow alliance8Target = new TextFlow(
        );
        alliance8Target.setLayoutX(alliance8TextX);
        alliance8Target.setLayoutY(alliance8TextY);
        alliance8Target.setPrefSize(160,40);
        alliance8Target.toBack();

        //final Text allianceTargetText = new Text(allianceTextX, allianceTextY+15,"Add to Alliance");

        Collections.sort(teamList);

        // create text for each team
        for (int teamNum : teamList) {
            //System.out.println(teamNum);
            Text teamText = new Text(0,0,Integer.toString(teamNum));
            teamText.setStyle("-fx-font: 12 cambria");
            if (teamNum == 1153) {
                teamText.setFill(RED);
            }
            // create an event handler to handle drag and drop
            teamText.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                /* drag detected */
                    Dragboard db = teamText.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(teamText.getText());
                    db.setContent(content);

                    event.consume();
                }
            });
            teamText.setOnDragDone(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent event) {
                    if (event.getTransferMode() == TransferMode.MOVE) {
                        //teamText.setText("");
                        teamText.toFront();
                    }
                    event.consume();
                }
            });
            robotTextList.add(teamText);
            root.getChildren().add(teamText);
        }
        placeTeams();
        ///////////////////////////////////////////////////////////////////////
        // Handle pickedTarget
        ///////////////////////////////////////////////////////////////////////
        // create an event handler for the target
        robotTarget.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != robotTarget &&
                        event.getDragboard().hasString() && isInRobotTextList(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        robotTarget.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != robotTarget &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        robotTarget.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        robotTarget.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInAlliance2(t.getText())) {
                        alliance2TextList.remove(t);
                        resetData(2);
                        placeAlliance2();

                    } else if (isInAlliance1(t.getText())) {
                        alliance1TextList.remove(t);
                        resetData(1);
                        placeAlliance1();

                    } else if (isInAlliance3(t.getText())) {
                        alliance3TextList.remove(t);
                        resetData(3);
                        placeAlliance3();

                    } else if (isInAlliance4(t.getText())) {
                        alliance4TextList.remove(t);
                        resetData(4);
                        placeAlliance4();

                    } else if (isInAlliance5(t.getText())) {
                        alliance5TextList.remove(t);
                        resetData(5);
                        placeAlliance5();

                    } else if (isInAlliance6(t.getText())) {
                        alliance6TextList.remove(t);
                        resetData(6);
                        placeAlliance6();

                    } else if (isInAlliance7(t.getText())) {
                        alliance7TextList.remove(t);
                        resetData(7);
                        placeAlliance7();

                    }  else if (isInAlliance8(t.getText())) {
                        alliance8TextList.remove(t);
                        resetData(8);
                        placeAlliance8();
                    }
                    robotTextList.add(t);
                    placeRobots();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });
        alliance1Target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != alliance1Target &&
                        event.getDragboard().hasString() && isInAlliance1(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        alliance1Target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != alliance1Target &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        alliance1Target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        alliance1Target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("draggedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInRobotTextList(t.getText())) {
                        robotTextList.remove(t);
                        placeRobots();

                    } else if (isInAlliance2(t.getText())) {
                        alliance2TextList.remove(t);
                        resetData(2);
                        placeAlliance2();

                    } else if (isInAlliance3(t.getText())) {
                        alliance3TextList.remove(t);
                        resetData(3);
                        placeAlliance3();

                    } else if (isInAlliance4(t.getText())) {
                        alliance4TextList.remove(t);
                        resetData(4);
                        placeAlliance4();

                    } else if (isInAlliance5(t.getText())) {
                        alliance5TextList.remove(t);
                        resetData(5);
                        placeAlliance5();

                    } else if (isInAlliance6(t.getText())) {
                        alliance6TextList.remove(t);
                        resetData(6);
                        placeAlliance6();

                    } else if (isInAlliance7(t.getText())) {
                        alliance7TextList.remove(t);
                        resetData(7);
                        placeAlliance7();

                    }  else if (isInAlliance8(t.getText())) {
                        alliance8TextList.remove(t);
                        resetData(8);
                        placeAlliance8();
                    }
                    alliance1TextList.add(t);
                    placeAlliance1();
                    getStrongestAlliance1();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });
       ///STOP///
        alliance2Target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != alliance2Target &&
                        event.getDragboard().hasString() && isInAlliance2(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        alliance2Target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != alliance2Target &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        alliance2Target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        alliance2Target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInRobotTextList(t.getText())) {
                        robotTextList.remove(t);
                        placeRobots();

                    } else if (isInAlliance1(t.getText())) {
                        alliance1TextList.remove(t);
                        resetData(1);
                        placeAlliance1();

                    } else if (isInAlliance3(t.getText())) {
                        alliance3TextList.remove(t);
                        resetData(3);
                        placeAlliance3();

                    } else if (isInAlliance4(t.getText())) {
                        alliance4TextList.remove(t);
                        resetData(4);
                        placeAlliance4();

                    } else if (isInAlliance5(t.getText())) {
                        alliance5TextList.remove(t);
                        resetData(5);
                        placeAlliance5();

                    } else if (isInAlliance6(t.getText())) {
                        alliance6TextList.remove(t);
                        resetData(6);
                        placeAlliance6();

                    } else if (isInAlliance7(t.getText())) {
                        alliance7TextList.remove(t);
                        resetData(7);
                        placeAlliance7();

                    }  else if (isInAlliance8(t.getText())) {
                        alliance8TextList.remove(t);
                        resetData(8);
                        placeAlliance8();
                    }
                    alliance2TextList.add(t);
                    placeAlliance2();
                    getStrongestAlliance2();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });
        alliance3Target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != alliance3Target &&
                        event.getDragboard().hasString() && isInAlliance3(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        alliance3Target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != alliance3Target &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        alliance3Target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        alliance3Target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInAlliance1(t.getText())) {
                        alliance1TextList.remove(t);
                        resetData(1);
                        placeAlliance1();

                    } else if (isInAlliance2(t.getText())) {
                        alliance2TextList.remove(t);
                        resetData(2);
                        placeAlliance2();

                    } else if (isInRobotTextList(t.getText())) {
                        robotTextList.remove(t);
                        resetData(3);
                        placeRobots();

                    } else if (isInAlliance4(t.getText())) {
                        alliance4TextList.remove(t);
                        resetData(4);
                        placeAlliance4();

                    } else if (isInAlliance5(t.getText())) {
                        alliance5TextList.remove(t);
                        resetData(5);
                        placeAlliance5();

                    } else if (isInAlliance6(t.getText())) {
                        alliance6TextList.remove(t);
                        resetData(6);
                        placeAlliance6();

                    } else if (isInAlliance7(t.getText())) {
                        alliance7TextList.remove(t);
                        resetData(7);
                        placeAlliance7();

                    }  else if (isInAlliance8(t.getText())) {
                        alliance8TextList.remove(t);
                        resetData(8);
                        placeAlliance8();
                    }
                    alliance3TextList.add(t);
                    placeAlliance3();
                    getStrongestAlliance3();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });
        alliance4Target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != alliance4Target &&
                        event.getDragboard().hasString() && isInAlliance4(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        alliance4Target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != alliance4Target &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        alliance4Target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        alliance4Target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInAlliance1(t.getText())) {
                        alliance1TextList.remove(t);
                        resetData(1);
                        placeAlliance1();

                    } else if (isInAlliance2(t.getText())) {
                        alliance2TextList.remove(t);
                        resetData(2);
                        placeAlliance2();

                    } else if (isInAlliance3(t.getText())) {
                        alliance3TextList.remove(t);
                        resetData(3);
                        placeAlliance3();

                    } else if (isInRobotTextList(t.getText())) {
                        robotTextList.remove(t);
                        placeRobots();

                    } else if (isInAlliance5(t.getText())) {
                        alliance5TextList.remove(t);
                        resetData(5);
                        placeAlliance5();

                    } else if (isInAlliance6(t.getText())) {
                        alliance6TextList.remove(t);
                        resetData(6);
                        placeAlliance6();

                    } else if (isInAlliance7(t.getText())) {
                        alliance7TextList.remove(t);
                        resetData(7);
                        placeAlliance7();

                    }  else if (isInAlliance8(t.getText())) {
                        alliance8TextList.remove(t);
                        resetData(8);
                        placeAlliance8();
                    }
                    alliance4TextList.add(t);
                    placeAlliance4();
                    getStrongestAlliance4();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });
        alliance5Target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != alliance5Target &&
                        event.getDragboard().hasString() && isInAlliance5(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        alliance5Target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != alliance5Target &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        alliance5Target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        alliance5Target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInAlliance1(t.getText())) {
                        alliance1TextList.remove(t);
                        resetData(1);
                        placeAlliance1();

                    } else if (isInAlliance2(t.getText())) {
                        alliance2TextList.remove(t);
                        resetData(2);
                        placeAlliance2();

                    } else if (isInAlliance3(t.getText())) {
                        alliance3TextList.remove(t);
                        resetData(3);
                        placeAlliance3();

                    } else if (isInRobotTextList(t.getText())) {
                        robotTextList.remove(t);
                        placeRobots();

                    } else if (isInAlliance4(t.getText())) {
                        alliance4TextList.remove(t);
                        resetData(4);
                        placeAlliance4();

                    } else if (isInAlliance6(t.getText())) {
                        alliance6TextList.remove(t);
                        resetData(6);
                        placeAlliance6();

                    } else if (isInAlliance7(t.getText())) {
                        alliance7TextList.remove(t);
                        resetData(7);
                        placeAlliance7();

                    }  else if (isInAlliance8(t.getText())) {
                        alliance8TextList.remove(t);
                        resetData(8);
                        placeAlliance8();
                    }
                    alliance5TextList.add(t);
                    placeAlliance5();
                    getStrongestAlliance5();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });
        alliance6Target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != alliance6Target &&
                        event.getDragboard().hasString() && isInAlliance6(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        alliance6Target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != alliance6Target &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        alliance6Target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        alliance6Target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInAlliance1(t.getText())) {
                        alliance1TextList.remove(t);
                        resetData(1);
                        placeAlliance1();

                    } else if (isInAlliance2(t.getText())) {
                        alliance2TextList.remove(t);
                        resetData(2);
                        placeAlliance2();

                    } else if (isInAlliance3(t.getText())) {
                        alliance3TextList.remove(t);
                        resetData(3);
                        placeAlliance3();

                    } else if (isInAlliance4(t.getText())) {
                        alliance4TextList.remove(t);
                        resetData(4);
                        placeAlliance4();

                    } else if (isInAlliance5(t.getText())) {
                        alliance5TextList.remove(t);
                        resetData(5);
                        placeAlliance5();

                    } else if (isInRobotTextList(t.getText())) {
                        robotTextList.remove(t);
                        placeRobots();

                    } else if (isInAlliance7(t.getText())) {
                        alliance7TextList.remove(t);
                        resetData(7);
                        placeAlliance7();

                    }  else if (isInAlliance8(t.getText())) {
                        alliance8TextList.remove(t);
                        resetData(8);
                        placeAlliance8();
                    }
                    alliance6TextList.add(t);
                    placeAlliance6();
                    getStrongestAlliance6();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });

        alliance7Target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != alliance7Target &&
                        event.getDragboard().hasString() && isInAlliance7(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        alliance7Target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != alliance7Target &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        alliance7Target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        alliance7Target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInAlliance1(t.getText())) {
                        alliance1TextList.remove(t);
                        resetData(1);
                        placeAlliance1();

                    } else if (isInAlliance2(t.getText())) {
                        alliance2TextList.remove(t);
                        resetData(2);
                        placeAlliance2();

                    } else if (isInAlliance3(t.getText())) {
                        alliance3TextList.remove(t);
                        resetData(3);
                        placeAlliance3();

                    } else if (isInAlliance4(t.getText())) {
                        alliance4TextList.remove(t);
                        resetData(4);
                        placeAlliance4();

                    } else if (isInAlliance5(t.getText())) {
                        alliance5TextList.remove(t);
                        resetData(5);
                        placeAlliance5();

                    } else if (isInAlliance6(t.getText())) {
                        alliance6TextList.remove(t);
                        resetData(6);
                        placeAlliance6();

                    } else if (isInRobotTextList(t.getText())) {
                        robotTextList.remove(t);
                        placeRobots();

                    }  else if (isInAlliance8(t.getText())) {
                        alliance8TextList.remove(t);
                        resetData(8);
                        placeAlliance8();
                    }
                    alliance7TextList.add(t);
                    placeAlliance7();
                    getStrongestAlliance7();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });
        alliance8Target.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedOver");
                if (event.getGestureSource() != alliance8Target &&
                        event.getDragboard().hasString() && isInAlliance8(event.getDragboard().getString()) == false) {
                    /* allow both copy and move */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
            }
        });

        alliance8Target.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedEntered");
                if (event.getGestureSource() != alliance8Target &&
                        event.getDragboard().hasString()) {
                    //pickedTarget.setFill(Color.GREEN);
                }
            }
        });

        alliance8Target.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedExited");
                //pickedTarget.setFill(Color.BLACK);
            }
        });

        alliance8Target.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println("dragedDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());

                    Text t = getTextObject(db.getString());

                    if (isInAlliance1(t.getText())) {
                        alliance1TextList.remove(t);
                        resetData(1);
                        placeAlliance1();

                    } else if (isInAlliance2(t.getText())) {
                        alliance2TextList.remove(t);
                        resetData(2);
                        placeAlliance2();

                    } else if (isInAlliance3(t.getText())) {
                        alliance3TextList.remove(t);
                        resetData(3);
                        placeAlliance3();

                    } else if (isInAlliance4(t.getText())) {
                        alliance4TextList.remove(t);
                        resetData(4);
                        placeAlliance4();

                    } else if (isInAlliance5(t.getText())) {
                        alliance5TextList.remove(t);
                        resetData(5);
                        placeAlliance5();

                    } else if (isInAlliance6(t.getText())) {
                        alliance6TextList.remove(t);
                        resetData(6);
                        placeAlliance6();

                    } else if (isInAlliance7(t.getText())) {
                        alliance7TextList.remove(t);
                        resetData(7);
                        placeAlliance7();

                    }  else if (isInRobotTextList(t.getText())) {
                        robotTextList.remove(t);
                        placeRobots();
                    }
                    alliance8TextList.add(t);
                    placeAlliance8();
                    getStrongestAlliance8();
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });

        root.getChildren().add(alliance1Target);
        root.getChildren().add(alliance2Target);
        root.getChildren().add(alliance3Target);
        root.getChildren().add(alliance4Target);
        root.getChildren().add(alliance5Target);
        root.getChildren().add(alliance6Target);
        root.getChildren().add(alliance7Target);
        root.getChildren().add(alliance8Target);
        root.getChildren().add(robotTarget);
        // put the target button in the back of the layout stack
        alliance1Target.toBack();
        alliance2Target.toBack();
        alliance3Target.toBack();
        alliance4Target.toBack();
        alliance5Target.toBack();
        alliance6Target.toBack();
        alliance7Target.toBack();
        alliance8Target.toBack();
        robotTarget.toBack();
        primaryStage.show();
    }
    // Display Alliance 1 Stats
    public void getStrongestAlliance1() {
        // first sort alliances by strength
        Collections.sort(adList1, new Comparator<AllianceData>() {
            public int compare(AllianceData o1, AllianceData o2) {
                if (o1.allianceLowStrength == o2.allianceLowStrength)
                    return 0;
                return o1.allianceLowStrength > o2.allianceLowStrength ? -1 : 1;
            }
        });

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        double strength = 0.0;
        double avgAutoScale = 0;
        double avgTeleScale = 0;
        double avgAutoSwitch = 0;
        double avgTeleSwitch = 0;
        double avgVault = 0;
        double avgClimbs = 0;
        // if there's three robots, show the score
        if (alliance1TextList.size() == 3) {
            // find highest matching alliance with all 3 robots in it
            // find highest matching alliance with robots 1 and 2 in it
            r1 = Integer.parseInt(alliance1TextList.get(0).getText().toString());
            r2 = Integer.parseInt(alliance1TextList.get(1).getText().toString());
            r3 = Integer.parseInt(alliance1TextList.get(2).getText().toString());

            // find highest matching alliance with robot 1 in it
            int c =0;
            boolean keepSearching = true;
            while (keepSearching == true) {
                if ((adList1.get(c).robot1 == r1 || adList1.get(c).robot2 == r1 || adList1.get(c).robot3 == r1) &&
                        (adList1.get(c).robot1 == r2 || adList1.get(c).robot2 == r2 || adList1.get(c).robot3 == r2) &&
                        (adList1.get(c).robot1 == r3 || adList1.get(c).robot2 == r3 || adList1.get(c).robot3 == r3)) {
                    keepSearching = false;
                    // set all of the robot numbers
                    r1 = adList1.get(c).robot1;
                    r2 = adList1.get(c).robot2;
                    r3 = adList1.get(c).robot3;
                    strength = adList1.get(c).allianceLowStrength;
                    avgAutoScale = adList1.get(c).avgAutoScale;
                    avgTeleScale = adList1.get(c).avgTeleScale;
                    avgAutoSwitch = adList1.get(c).avgAutoSwitch;
                    avgTeleSwitch = adList1.get(c).avgTeleSwitch;
                    avgVault = adList1.get(c).avgVault;
                    avgClimbs = adList1.get(c).avgClimbs;
                    alliance1.allianceHighStrength = adList1.get(c).allianceHighStrength;
                    alliance1.allianceLowStrength = adList1.get(c).allianceLowStrength;
                    alliance1.allianceRawStrength = adList1.get(c).allianceRawStrength;
                    alliance1.avgAutoSwitch = adList1.get(c).avgAutoSwitch;
                    alliance1.avgTeleSwitch = adList1.get(c).avgTeleSwitch;
                    alliance1.avgAutoScale = adList1.get(c).avgAutoScale;
                    alliance1.avgTeleScale = adList1.get(c).avgTeleScale;
                    alliance1.avgClimbs = adList1.get(c).avgClimbs;
                    alliance1.allianceNumber = 1;
                }

                c++;
                if (c >= adList1.size()) {
                    keepSearching = false;
                }
            }
        }
        predictedScore1.setText(String.format("%.1f",strength));
        avgAutoScaleText1.setText(String.format("%.1f",avgAutoScale));
        avgTeleScaleText1.setText(String.format("%.1f", avgTeleScale));
        avgAutoSwitchText1.setText(String.format("%.1f", avgAutoSwitch));
        avgTeleSwitchText1.setText(String.format("%.1f", avgTeleSwitch));
        avgVaultText1.setText(String.format("%.1f", avgVault));
        avgClimbsText1.setText(String.format("%.1f", avgClimbs));

    }

    // Display Alliance 2 Stats
    public void getStrongestAlliance2() {
        // first sort alliances by strength
        Collections.sort(adList2, new Comparator<AllianceData>() {
            public int compare(AllianceData o1, AllianceData o2) {
                if (o1.allianceLowStrength == o2.allianceLowStrength)
                    return 0;
                return o1.allianceLowStrength > o2.allianceLowStrength ? -1 : 1;
            }
        });

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        double strength = 0.0;
        double avgAutoScale = 0;
        double avgTeleScale = 0;
        double avgAutoSwitch = 0;
        double avgTeleSwitch = 0;
        double avgVault = 0;
        double avgClimbs = 0;
        // if there's three robots, show the score
        if (alliance2TextList.size() == 3) {
            // find highest matching alliance with all 3 robots in it
            // find highest matching alliance with robots 1 and 2 in it
            r1 = Integer.parseInt(alliance2TextList.get(0).getText().toString());
            r2 = Integer.parseInt(alliance2TextList.get(1).getText().toString());
            r3 = Integer.parseInt(alliance2TextList.get(2).getText().toString());

            // find highest matching alliance with robot 1 in it
            int c =0;
            boolean keepSearching = true;
            while (keepSearching == true) {
                if ((adList2.get(c).robot1 == r1 || adList2.get(c).robot2 == r1 || adList2.get(c).robot3 == r1) &&
                        (adList2.get(c).robot1 == r2 || adList2.get(c).robot2 == r2 || adList2.get(c).robot3 == r2) &&
                        (adList2.get(c).robot1 == r3 || adList2.get(c).robot2 == r3 || adList2.get(c).robot3 == r3)) {
                    keepSearching = false;
                    // set all of the robot numbers
                    r1 = adList2.get(c).robot1;
                    r2 = adList2.get(c).robot2;
                    r3 = adList2.get(c).robot3;
                    strength = adList2.get(c).allianceLowStrength;
                    avgAutoScale = adList2.get(c).avgAutoScale;
                    avgTeleScale = adList2.get(c).avgTeleScale;
                    avgAutoSwitch = adList2.get(c).avgAutoSwitch;
                    avgTeleSwitch = adList2.get(c).avgTeleSwitch;
                    avgVault = adList2.get(c).avgVault;
                    avgClimbs = adList2.get(c).avgClimbs;
                    alliance2.allianceHighStrength = adList2.get(c).allianceHighStrength;
                    alliance2.allianceLowStrength = adList2.get(c).allianceLowStrength;
                    alliance2.allianceRawStrength = adList2.get(c).allianceRawStrength;
                    alliance2.avgAutoSwitch = adList2.get(c).avgAutoSwitch;
                    alliance2.avgTeleSwitch = adList2.get(c).avgTeleSwitch;
                    alliance2.avgAutoScale = adList2.get(c).avgAutoScale;
                    alliance2.avgTeleScale = adList2.get(c).avgTeleScale;
                    alliance2.avgClimbs = adList2.get(c).avgClimbs;
                    alliance2.allianceNumber = 2;

                }
                c++;
                if (c >= adList2.size()) {
                    keepSearching = false;
                }
            }
        }
        predictedScore2.setText(String.format("%.1f",strength));
        avgAutoScaleText2.setText(String.format("%.1f",avgAutoScale));
        avgTeleScaleText2.setText(String.format("%.1f", avgTeleScale));
        avgAutoSwitchText2.setText(String.format("%.1f", avgAutoSwitch));
        avgTeleSwitchText2.setText(String.format("%.1f", avgTeleSwitch));
        avgVaultText2.setText(String.format("%.1f", avgVault));
        avgClimbsText2.setText(String.format("%.1f", avgClimbs));
    }
    // Display Alliance 3 Stats
    public void getStrongestAlliance3() {
        // first sort alliances by strength
        Collections.sort(adList3, new Comparator<AllianceData>() {
            public int compare(AllianceData o1, AllianceData o2) {
                if (o1.allianceLowStrength == o2.allianceLowStrength)
                    return 0;
                return o1.allianceLowStrength > o2.allianceLowStrength ? -1 : 1;
            }
        });

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        double strength = 0.0;
        double avgAutoScale = 0;
        double avgTeleScale = 0;
        double avgAutoSwitch = 0;
        double avgTeleSwitch = 0;
        double avgVault = 0;
        double avgClimbs = 0;
        // if there's three robots, show the score
        if (alliance3TextList.size() == 3) {
            // find highest matching alliance with all 3 robots in it
            // find highest matching alliance with robots 1 and 2 in it
            r1 = Integer.parseInt(alliance3TextList.get(0).getText().toString());
            r2 = Integer.parseInt(alliance3TextList.get(1).getText().toString());
            r3 = Integer.parseInt(alliance3TextList.get(2).getText().toString());

            // find highest matching alliance with robot 1 in it
            int c =0;
            boolean keepSearching = true;
            while (keepSearching == true) {
                if ((adList3.get(c).robot1 == r1 || adList3.get(c).robot2 == r1 || adList3.get(c).robot3 == r1) &&
                        (adList3.get(c).robot1 == r2 || adList3.get(c).robot2 == r2 || adList3.get(c).robot3 == r2) &&
                        (adList3.get(c).robot1 == r3 || adList3.get(c).robot2 == r3 || adList3.get(c).robot3 == r3)) {
                    keepSearching = false;
                    // set all of the robot numbers
                    r1 = adList3.get(c).robot1;
                    r2 = adList3.get(c).robot2;
                    r3 = adList3.get(c).robot3;
                    strength = adList3.get(c).allianceLowStrength;
                    avgAutoScale = adList3.get(c).avgAutoScale;
                    avgTeleScale = adList3.get(c).avgTeleScale;
                    avgAutoSwitch = adList3.get(c).avgAutoSwitch;
                    avgTeleSwitch = adList3.get(c).avgTeleSwitch;
                    avgClimbs = adList3.get(c).avgClimbs;
                    alliance3.allianceHighStrength = adList3.get(c).allianceHighStrength;
                    alliance3.allianceLowStrength = adList3.get(c).allianceLowStrength;
                    alliance3.allianceRawStrength = adList3.get(c).allianceRawStrength;
                    alliance3.avgAutoSwitch = adList3.get(c).avgAutoSwitch;
                    alliance3.avgTeleSwitch = adList3.get(c).avgTeleSwitch;
                    alliance3.avgAutoScale = adList3.get(c).avgAutoScale;
                    alliance3.avgTeleScale = adList3.get(c).avgTeleScale;
                    alliance3.avgClimbs = adList3.get(c).avgClimbs;
                    alliance3.allianceNumber = 3;

                }
                c++;
                if (c >= adList3.size()) {
                    keepSearching = false;
                }
            }
        }
        predictedScore3.setText(String.format("%.1f",strength));
        avgAutoScaleText3.setText(String.format("%.1f",avgAutoScale));
        avgTeleScaleText3.setText(String.format("%.1f", avgTeleScale));
        avgAutoSwitchText3.setText(String.format("%.1f", avgAutoSwitch));
        avgTeleSwitchText3.setText(String.format("%.1f", avgTeleSwitch));
        avgClimbsText3.setText(String.format("%.1f", avgClimbs));
    }
    // Display Alliance 4 Stats
    public void getStrongestAlliance4() {
        // first sort alliances by strength
        Collections.sort(adList4, new Comparator<AllianceData>() {
            public int compare(AllianceData o1, AllianceData o2) {
                if (o1.allianceLowStrength == o2.allianceLowStrength)
                    return 0;
                return o1.allianceLowStrength > o2.allianceLowStrength ? -1 : 1;
            }
        });

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        double strength = 0.0;
        double avgAutoScale = 0;
        double avgTeleScale = 0;
        double avgAutoSwitch = 0;
        double avgTeleSwitch = 0;
        double avgClimbs = 0;
        // if there's three robots, show the score
        if (alliance4TextList.size() == 3) {
            // find highest matching alliance with all 3 robots in it
            // find highest matching alliance with robots 1 and 2 in it
            r1 = Integer.parseInt(alliance4TextList.get(0).getText().toString());
            r2 = Integer.parseInt(alliance4TextList.get(1).getText().toString());
            r3 = Integer.parseInt(alliance4TextList.get(2).getText().toString());

            // find highest matching alliance with robot 1 in it
            int c =0;
            boolean keepSearching = true;
            while (keepSearching == true) {
                if ((adList4.get(c).robot1 == r1 || adList4.get(c).robot2 == r1 || adList4.get(c).robot3 == r1) &&
                        (adList4.get(c).robot1 == r2 || adList4.get(c).robot2 == r2 || adList4.get(c).robot3 == r2) &&
                        (adList4.get(c).robot1 == r3 || adList4.get(c).robot2 == r3 || adList4.get(c).robot3 == r3)) {
                    keepSearching = false;
                    // set all of the robot numbers
                    r1 = adList4.get(c).robot1;
                    r2 = adList4.get(c).robot2;
                    r3 = adList4.get(c).robot3;
                    strength = adList4.get(c).allianceLowStrength;
                    avgAutoScale = adList4.get(c).avgAutoScale;
                    avgTeleScale = adList4.get(c).avgTeleScale;
                    avgAutoSwitch = adList4.get(c).avgAutoSwitch;
                    avgTeleSwitch = adList4.get(c).avgTeleSwitch;
                    avgClimbs = adList4.get(c).avgClimbs;
                    alliance4.allianceHighStrength = adList4.get(c).allianceHighStrength;
                    alliance4.allianceLowStrength = adList4.get(c).allianceLowStrength;
                    alliance4.allianceRawStrength = adList4.get(c).allianceRawStrength;
                    alliance4.avgAutoSwitch = adList4.get(c).avgAutoSwitch;
                    alliance4.avgTeleSwitch = adList4.get(c).avgTeleSwitch;
                    alliance4.avgAutoScale = adList4.get(c).avgAutoScale;
                    alliance4.avgTeleScale = adList4.get(c).avgTeleScale;
                    alliance4.avgClimbs = adList4.get(c).avgClimbs;
                    alliance4.allianceNumber = 4;

                }
                c++;
                if (c >= adList4.size()) {
                    keepSearching = false;
                }
            }
        }
        predictedScore4.setText(String.format("%.1f",strength));
        avgAutoScaleText4.setText(String.format("%.1f",avgAutoScale));
        avgTeleScaleText4.setText(String.format("%.1f", avgTeleScale));
        avgAutoSwitchText4.setText(String.format("%.1f", avgAutoSwitch));
        avgTeleSwitchText4.setText(String.format("%.1f", avgTeleSwitch));
        avgClimbsText4.setText(String.format("%.1f", avgClimbs));
    }
    // Display Alliance 5 Stats
    public void getStrongestAlliance5() {
        // first sort alliances by strength
        Collections.sort(adList5, new Comparator<AllianceData>() {
            public int compare(AllianceData o1, AllianceData o2) {
                if (o1.allianceLowStrength == o2.allianceLowStrength)
                    return 0;
                return o1.allianceLowStrength > o2.allianceLowStrength ? -1 : 1;
            }
        });

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        double strength = 0.0;
        double avgAutoScale = 0;
        double avgTeleScale = 0;
        double avgAutoSwitch = 0;
        double avgTeleSwitch = 0;
        double avgClimbs = 0;
        // if there's three robots, show the score
        if (alliance5TextList.size() == 3) {
            // find highest matching alliance with all 3 robots in it
            // find highest matching alliance with robots 1 and 2 in it
            r1 = Integer.parseInt(alliance5TextList.get(0).getText().toString());
            r2 = Integer.parseInt(alliance5TextList.get(1).getText().toString());
            r3 = Integer.parseInt(alliance5TextList.get(2).getText().toString());

            // find highest matching alliance with robot 1 in it
            int c =0;
            boolean keepSearching = true;
            while (keepSearching == true) {
                if ((adList5.get(c).robot1 == r1 || adList5.get(c).robot2 == r1 || adList5.get(c).robot3 == r1) &&
                        (adList5.get(c).robot1 == r2 || adList5.get(c).robot2 == r2 || adList5.get(c).robot3 == r2) &&
                        (adList5.get(c).robot1 == r3 || adList5.get(c).robot2 == r3 || adList5.get(c).robot3 == r3)) {
                    keepSearching = false;
                    // set all of the robot numbers
                    r1 = adList5.get(c).robot1;
                    r2 = adList5.get(c).robot2;
                    r3 = adList5.get(c).robot3;
                    strength = adList5.get(c).allianceLowStrength;
                    avgAutoScale = adList5.get(c).avgAutoScale;
                    avgTeleScale = adList5.get(c).avgTeleScale;
                    avgAutoSwitch = adList5.get(c).avgAutoSwitch;
                    avgTeleSwitch = adList5.get(c).avgTeleSwitch;
                    avgClimbs = adList5.get(c).avgClimbs;
                    alliance5.allianceHighStrength = adList5.get(c).allianceHighStrength;
                    alliance5.allianceLowStrength = adList5.get(c).allianceLowStrength;
                    alliance5.allianceRawStrength = adList5.get(c).allianceRawStrength;
                    alliance5.avgAutoSwitch = adList5.get(c).avgAutoSwitch;
                    alliance5.avgTeleSwitch = adList5.get(c).avgTeleSwitch;
                    alliance5.avgAutoScale = adList5.get(c).avgAutoScale;
                    alliance5.avgTeleScale = adList5.get(c).avgTeleScale;
                    alliance5.avgClimbs = adList5.get(c).avgClimbs;
                    alliance5.allianceNumber = 5;

                }
                c++;
                if (c >= adList5.size()) {
                    keepSearching = false;
                }
            }
        }
        predictedScore5.setText(String.format("%.1f",strength));
        avgAutoScaleText5.setText(String.format("%.1f",avgAutoScale));
        avgTeleScaleText5.setText(String.format("%.1f", avgTeleScale));
        avgAutoSwitchText5.setText(String.format("%.1f", avgAutoSwitch));
        avgTeleSwitchText5.setText(String.format("%.1f", avgTeleSwitch));
        avgClimbsText5.setText(String.format("%.1f", avgClimbs));
    }
    // Display Alliance 6 Stats
    public void getStrongestAlliance6() {
        // first sort alliances by strength
        Collections.sort(adList6, new Comparator<AllianceData>() {
            public int compare(AllianceData o1, AllianceData o2) {
                if (o1.allianceLowStrength == o2.allianceLowStrength)
                    return 0;
                return o1.allianceLowStrength > o2.allianceLowStrength ? -1 : 1;
            }
        });

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        double strength = 0.0;
        double avgAutoScale = 0;
        double avgTeleScale = 0;
        double avgAutoSwitch = 0;
        double avgTeleSwitch = 0;
        double avgClimbs = 0;
        // if there's three robots, show the score
        if (alliance6TextList.size() == 3) {
            // find highest matching alliance with all 3 robots in it
            // find highest matching alliance with robots 1 and 2 in it
            r1 = Integer.parseInt(alliance6TextList.get(0).getText().toString());
            r2 = Integer.parseInt(alliance6TextList.get(1).getText().toString());
            r3 = Integer.parseInt(alliance6TextList.get(2).getText().toString());

            // find highest matching alliance with robot 1 in it
            int c =0;
            boolean keepSearching = true;
            while (keepSearching == true) {
                if ((adList6.get(c).robot1 == r1 || adList6.get(c).robot2 == r1 || adList6.get(c).robot3 == r1) &&
                        (adList6.get(c).robot1 == r2 || adList6.get(c).robot2 == r2 || adList6.get(c).robot3 == r2) &&
                        (adList6.get(c).robot1 == r3 || adList6.get(c).robot2 == r3 || adList6.get(c).robot3 == r3)) {
                    keepSearching = false;
                    // set all of the robot numbers
                    r1 = adList6.get(c).robot1;
                    r2 = adList6.get(c).robot2;
                    r3 = adList6.get(c).robot3;
                    strength = adList6.get(c).allianceLowStrength;
                    avgAutoScale = adList6.get(c).avgAutoScale;
                    avgTeleScale = adList6.get(c).avgTeleScale;
                    avgAutoSwitch = adList6.get(c).avgAutoSwitch;
                    avgTeleSwitch = adList6.get(c).avgTeleSwitch;
                    avgClimbs = adList6.get(c).avgClimbs;
                    alliance6.allianceHighStrength = adList6.get(c).allianceHighStrength;
                    alliance6.allianceLowStrength = adList6.get(c).allianceLowStrength;
                    alliance6.allianceRawStrength = adList6.get(c).allianceRawStrength;
                    alliance6.avgAutoSwitch = adList6.get(c).avgAutoSwitch;
                    alliance6.avgTeleSwitch = adList6.get(c).avgTeleSwitch;
                    alliance6.avgAutoScale = adList6.get(c).avgAutoScale;
                    alliance6.avgTeleScale = adList6.get(c).avgTeleScale;
                    alliance6.avgClimbs = adList6.get(c).avgClimbs;
                    alliance6.allianceNumber = 6;

                }
                c++;
                if (c >= adList6.size()) {
                    keepSearching = false;
                }
            }
        }
        predictedScore6.setText(String.format("%.1f",strength));
        avgAutoScaleText6.setText(String.format("%.1f",avgAutoScale));
        avgTeleScaleText6.setText(String.format("%.1f", avgTeleScale));
        avgAutoSwitchText6.setText(String.format("%.1f", avgAutoSwitch));
        avgTeleSwitchText6.setText(String.format("%.1f", avgTeleSwitch));
        avgClimbsText6.setText(String.format("%.1f", avgClimbs));
    }
    // Display Alliance 7 Stats
    public void getStrongestAlliance7() {
        // first sort alliances by strength
        Collections.sort(adList7, new Comparator<AllianceData>() {
            public int compare(AllianceData o1, AllianceData o2) {
                if (o1.allianceLowStrength == o2.allianceLowStrength)
                    return 0;
                return o1.allianceLowStrength > o2.allianceLowStrength ? -1 : 1;
            }
        });

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        double strength = 0.0;
        double avgAutoScale = 0;
        double avgTeleScale = 0;
        double avgAutoSwitch = 0;
        double avgTeleSwitch = 0;
        double avgClimbs = 0;
        // if there's three robots, show the score
        if (alliance7TextList.size() == 3) {
            // find highest matching alliance with all 3 robots in it
            // find highest matching alliance with robots 1 and 2 in it
            r1 = Integer.parseInt(alliance7TextList.get(0).getText().toString());
            r2 = Integer.parseInt(alliance7TextList.get(1).getText().toString());
            r3 = Integer.parseInt(alliance7TextList.get(2).getText().toString());

            // find highest matching alliance with robot 1 in it
            int c =0;
            boolean keepSearching = true;
            while (keepSearching == true) {
                if ((adList7.get(c).robot1 == r1 || adList7.get(c).robot2 == r1 || adList7.get(c).robot3 == r1) &&
                        (adList7.get(c).robot1 == r2 || adList7.get(c).robot2 == r2 || adList7.get(c).robot3 == r2) &&
                        (adList7.get(c).robot1 == r3 || adList7.get(c).robot2 == r3 || adList7.get(c).robot3 == r3)) {
                    keepSearching = false;
                    // set all of the robot numbers
                    r1 = adList7.get(c).robot1;
                    r2 = adList7.get(c).robot2;
                    r3 = adList7.get(c).robot3;
                    strength = adList7.get(c).allianceLowStrength;
                    avgAutoScale = adList7.get(c).avgAutoScale;
                    avgTeleScale = adList7.get(c).avgTeleScale;
                    avgAutoSwitch = adList7.get(c).avgAutoSwitch;
                    avgTeleSwitch = adList7.get(c).avgTeleSwitch;
                    avgClimbs = adList7.get(c).avgClimbs;
                    alliance7.allianceHighStrength = adList7.get(c).allianceHighStrength;
                    alliance7.allianceLowStrength = adList7.get(c).allianceLowStrength;
                    alliance7.allianceRawStrength = adList7.get(c).allianceRawStrength;
                    alliance7.avgAutoSwitch = adList7.get(c).avgAutoSwitch;
                    alliance7.avgTeleSwitch = adList7.get(c).avgTeleSwitch;
                    alliance7.avgAutoScale = adList7.get(c).avgAutoScale;
                    alliance7.avgTeleScale = adList7.get(c).avgTeleScale;
                    alliance7.avgClimbs = adList7.get(c).avgClimbs;
                    alliance7.allianceNumber = 7;

                }
                c++;
                if (c >= adList7.size()) {
                    keepSearching = false;
                }
            }
        }
        predictedScore7.setText(String.format("%.1f",strength));
        avgAutoScaleText7.setText(String.format("%.1f",avgAutoScale));
        avgTeleScaleText7.setText(String.format("%.1f", avgTeleScale));
        avgAutoSwitchText7.setText(String.format("%.1f", avgAutoSwitch));
        avgTeleSwitchText7.setText(String.format("%.1f", avgTeleSwitch));
        avgClimbsText7.setText(String.format("%.1f", avgClimbs));
    }
    // Display Alliance 8 Stats
    public void getStrongestAlliance8() {
        // first sort alliances by strength
        Collections.sort(adList8, new Comparator<AllianceData>() {
            public int compare(AllianceData o1, AllianceData o2) {
                if (o1.allianceLowStrength == o2.allianceLowStrength)
                    return 0;
                return o1.allianceLowStrength > o2.allianceLowStrength ? -1 : 1;
            }
        });

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        double strength = 0.0;
        double avgAutoScale = 0;
        double avgTeleScale = 0;
        double avgAutoSwitch = 0;
        double avgTeleSwitch = 0;
        double avgClimbs = 0;
        // if there's three robots, show the score
        if (alliance8TextList.size() == 3) {
            // find highest matching alliance with all 3 robots in it
            // find highest matching alliance with robots 1 and 2 in it
            r1 = Integer.parseInt(alliance8TextList.get(0).getText().toString());
            r2 = Integer.parseInt(alliance8TextList.get(1).getText().toString());
            r3 = Integer.parseInt(alliance8TextList.get(2).getText().toString());

            // find highest matching alliance with robot 1 in it
            int c =0;
            boolean keepSearching = true;
            while (keepSearching == true) {
                if ((adList8.get(c).robot1 == r1 || adList8.get(c).robot2 == r1 || adList8.get(c).robot3 == r1) &&
                        (adList8.get(c).robot1 == r2 || adList8.get(c).robot2 == r2 || adList8.get(c).robot3 == r2) &&
                        (adList8.get(c).robot1 == r3 || adList8.get(c).robot2 == r3 || adList8.get(c).robot3 == r3)) {
                    keepSearching = false;
                    // set all of the robot numbers
                    r1 = adList8.get(c).robot1;
                    r2 = adList8.get(c).robot2;
                    r3 = adList8.get(c).robot3;
                    strength = adList8.get(c).allianceLowStrength;
                    avgAutoScale = adList8.get(c).avgAutoScale;
                    avgTeleScale = adList8.get(c).avgTeleScale;
                    avgAutoSwitch = adList8.get(c).avgAutoSwitch;
                    avgTeleSwitch = adList8.get(c).avgTeleSwitch;
                    avgClimbs = adList8.get(c).avgClimbs;
                    alliance8.allianceHighStrength = adList8.get(c).allianceHighStrength;
                    alliance8.allianceLowStrength = adList8.get(c).allianceLowStrength;
                    alliance8.allianceRawStrength = adList8.get(c).allianceRawStrength;
                    alliance8.avgAutoSwitch = adList8.get(c).avgAutoSwitch;
                    alliance8.avgTeleSwitch = adList8.get(c).avgTeleSwitch;
                    alliance8.avgAutoScale = adList8.get(c).avgAutoScale;
                    alliance8.avgTeleScale = adList8.get(c).avgTeleScale;
                    alliance8.avgClimbs = adList8.get(c).avgClimbs;
                    alliance8.allianceNumber = 8;

                }
                c++;
                if (c >= adList8.size()) {
                    keepSearching = false;
                }
            }
        }
        predictedScore8.setText(String.format("%.1f",strength));
        avgAutoScaleText8.setText(String.format("%.1f",avgAutoScale));
        avgTeleScaleText8.setText(String.format("%.1f", avgTeleScale));
        avgAutoSwitchText8.setText(String.format("%.1f", avgAutoSwitch));
        avgTeleSwitchText8.setText(String.format("%.1f", avgTeleSwitch));
        avgClimbsText8.setText(String.format("%.1f", avgClimbs));
    }

    // loop through available team list and place teams
    public void placeTeams() {
        int currNum = 0;
        currY = startY;
        //System.out.println("size of available team list = " + availableTeamTextList.size());
        Collections.sort(robotTextList, new Comparator<Text>() {
            public int compare(Text o1, Text o2) {
                if (Integer.parseInt(o1.getText()) == Integer.parseInt(o2.getText()))
                    return 0;
                return  Integer.parseInt(o1.getText())> Integer.parseInt(o2.getText()) ? 1 : -1;
            }
        });
        for (Text t : robotTextList) {
            currX = (currNum % columns)*incrX + startX;
            if (currNum % columns == 0) {
                currX = startX;
                currY += incrY;
            }
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void resetData(int allianceNumber) {
        if (allianceNumber == 1) {
            avgAutoSwitchText1.setText("");
            avgTeleSwitchText1.setText("");
            avgAutoScaleText1.setText("");
            avgTeleScaleText1.setText("");
            avgClimbsText1.setText("");
            predictedScore1.setText("");
        }
        if (allianceNumber == 2) {
            avgAutoSwitchText2.setText("");
            avgTeleSwitchText2.setText("");
            avgAutoScaleText2.setText("");
            avgTeleScaleText2.setText("");
            avgClimbsText2.setText("");
            predictedScore2.setText("");
        }
        if (allianceNumber == 3) {
            avgAutoSwitchText3.setText("");
            avgTeleSwitchText3.setText("");
            avgAutoScaleText3.setText("");
            avgTeleScaleText3.setText("");
            avgClimbsText3.setText("");
            predictedScore3.setText("");
        }
        if (allianceNumber == 4) {
            avgAutoSwitchText4.setText("");
            avgTeleSwitchText4.setText("");
            avgAutoScaleText4.setText("");
            avgTeleScaleText4.setText("");
            avgClimbsText4.setText("");
            predictedScore4.setText("");
        }
        if (allianceNumber == 5) {
            avgAutoSwitchText5.setText("");
            avgTeleSwitchText5.setText("");
            avgAutoScaleText5.setText("");
            avgTeleScaleText5.setText("");
            avgClimbsText5.setText("");
            predictedScore5.setText("");
        }
        if (allianceNumber == 6) {
            avgAutoSwitchText6.setText("");
            avgTeleSwitchText6.setText("");
            avgAutoScaleText6.setText("");
            avgTeleScaleText6.setText("");
            avgClimbsText6.setText("");
            predictedScore6.setText("");
        }
        if (allianceNumber == 7) {
            avgAutoSwitchText7.setText("");
            avgTeleSwitchText7.setText("");
            avgAutoScaleText7.setText("");
            avgTeleScaleText7.setText("");
            avgClimbsText7.setText("");
            predictedScore7.setText("");
        }
        if (allianceNumber == 8) {
            avgAutoSwitchText8.setText("");
            avgTeleSwitchText8.setText("");
            avgAutoScaleText8.setText("");
            avgTeleScaleText8.setText("");
            avgClimbsText8.setText("");
            predictedScore8.setText("");
        }
    }
    public void placeRobots() {
        int currNum = 0;
        currY = robotTextY + robotYOffset;
        //System.out.println("size of picked team list = " + pickedTeamTextList.size());
        Collections.sort(robotTextList, new Comparator<Text>() {
            public int compare(Text o1, Text o2) {
                if (Integer.parseInt(o1.getText()) == Integer.parseInt(o2.getText()))
                    return 0;
                return  Integer.parseInt(o1.getText())> Integer.parseInt(o2.getText()) ? 1 : -1;
            }
        });
        for (Text t : robotTextList) {
            currX = (currNum % robotColumns)*incrX + robotTextX;
            if (currNum % robotColumns == 0) {
                currX = robotTextX;
                currY += incrY;
            }
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void placeAlliance1() {
        int currNum = 0;
        currY = alliance1TextY + alliance1YOffset - 5;
        //System.out.println("size of picked team list = " + pickedTeamTextList.size());
        /* Collections.sort(alliance1TextList, new Comparator<Text>() {
            public int compare(Text o1, Text o2) {
                if (Integer.parseInt(o1.getText()) == Integer.parseInt(o2.getText()))
                    return 0;
                return  Integer.parseInt(o1.getText())> Integer.parseInt(o2.getText()) ? 1 : -1;
            }
        }); */
        for (Text t : alliance1TextList) {
            currX = currNum*allianceIncrX + alliance1TextX + 18;
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void placeAlliance2() {
        int currNum = 0;
        currY = alliance2TextY + alliance2YOffset - 5;
        for (Text t : alliance2TextList) {
            currX = currNum*allianceIncrX + alliance2TextX + 18;
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void placeAlliance3() {
        int currNum = 0;
        currY = alliance3TextY + alliance3YOffset - 5;
        for (Text t : alliance3TextList) {
            currX = currNum*allianceIncrX + alliance3TextX + 18;
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void placeAlliance4() {
        int currNum = 0;
        currY = alliance4TextY + alliance4YOffset - 5;
        for (Text t : alliance4TextList) {
            currX = (currNum % alliance4Columns)*allianceIncrX + alliance4TextX + 18;
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void placeAlliance5() {
        int currNum = 0;
        currY = alliance5TextY + alliance5YOffset - 5;
        //System.out.println("size of picked team list = " + pickedTeamTextList.size());
        for (Text t : alliance5TextList) {
            currX = (currNum % alliance5Columns)*allianceIncrX + alliance5TextX + 18;
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void placeAlliance6() {
        int currNum = 0;
        currY = alliance6TextY + alliance6YOffset - 5;
        //System.out.println("size of picked team list = " + pickedTeamTextList.size());
        for (Text t : alliance6TextList) {
            currX = (currNum % alliance6Columns)*allianceIncrX + alliance6TextX + 18;
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void placeAlliance7() {
        int currNum = 0;
        currY = alliance7TextY + alliance7YOffset - 5;
        //System.out.println("size of picked team list = " + pickedTeamTextList.size());
        for (Text t : alliance7TextList) {
            currX = (currNum % alliance7Columns)*allianceIncrX + alliance7TextX + 18;
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    public void placeAlliance8() {
        int currNum = 0;
        currY = alliance8TextY + alliance8YOffset - 5;
        //System.out.println("size of picked team list = " + pickedTeamTextList.size());
        for (Text t : alliance8TextList) {
            currX = (currNum % alliance8Columns)*allianceIncrX + alliance8TextX + 18;
            t.setX(currX);
            t.setY(currY);
            currNum++;
        }
    }
    // given a robot number string, return the text
    public Text getTextObject (String robotNumber) {
        // check all three lists
        for (Text t : alliance1TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        // check all three lists
        for (Text t : alliance2TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        for (Text t : alliance3TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        for (Text t : alliance4TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        for (Text t : alliance5TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        for (Text t : alliance6TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        for (Text t : alliance7TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        for (Text t : alliance8TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        for (Text t : robotTextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumber)) {
                return t;
            }
        }
        return null;
    }
    public boolean isInRobotTextList (String robotNumberString) {
        for (Text t : robotTextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }
    public boolean isInAlliance1 (String robotNumberString) {
        // check all three lists
        // check all three lists
        for (Text t : alliance1TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }

    public boolean isInAlliance2 (String robotNumberString) {
        // check all three lists
        // check all three lists
        for (Text t : alliance2TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }
    public boolean isInAlliance3 (String robotNumberString) {
        // check all three lists
        // check all three lists
        for (Text t : alliance3TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }
    public boolean isInAlliance4 (String robotNumberString) {
        // check all three lists
        // check all three lists
        for (Text t : alliance4TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }
    public boolean isInAlliance5 (String robotNumberString) {
        // check all three lists
        // check all three lists
        for (Text t : alliance5TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }
    public boolean isInAlliance6 (String robotNumberString) {
        // check all three lists
        // check all three lists
        for (Text t : alliance6TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }
    public boolean isInAlliance7 (String robotNumberString) {
        // check all three lists
        // check all three lists
        for (Text t : alliance7TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }
    public boolean isInAlliance8 (String robotNumberString) {
        // check all three lists
        // check all three lists
        for (Text t : alliance8TextList) {
            if (t.getText().toString().equalsIgnoreCase(robotNumberString)) {
                return true;
            }
        }

        return false;
    }


    // check the robot list to see if we have a robot already with the given number
    public boolean haveRobot(int robotNumber) {
        for (RobotData r : robotList) {
            if (r.robotNumber == robotNumber) {
                return true;
            }
        }
        return false;
    }

    // get the robot with the given robotNumber from the list
    // or return null
    public RobotData getRobot(int robotNumber) {

        for (RobotData r : robotList) {
            if (r.robotNumber == robotNumber) {
                return r;
            }
        }
        return null;
    }

    public void getRanks() {
        // rank the robots based on average alliance score
        ArrayList<RobotData> rankList = new ArrayList<RobotData>();
        for (RobotData r : robotList) {
            rankList.add(r);
        }

        Collections.sort(rankList, new Comparator<RobotData>() {
            public int compare(RobotData o1, RobotData o2) {
                if (o1.totalSwitch.avg == o2.totalSwitch.avg)
                    return 0;
                return o1.totalSwitch.avg > o2.totalSwitch.avg ? -1 : 1;
            }
        });
        // now loop through the lists and set the rank based on avg score
        for (int c = 0; c < rankList.size(); c++) {
            if (c > 0) {
                int prev_rank = getRobot(rankList.get(c-1).robotNumber).autoSwitch.rank;
                if (getRobot(rankList.get(c).robotNumber).autoSwitch.avg < getRobot(rankList.get(c-1).robotNumber).autoSwitch.avg) {
                    getRobot(rankList.get(c).robotNumber).autoSwitch.rank = prev_rank + 1;
                } else {
                    getRobot(rankList.get(c).robotNumber).autoSwitch.rank = prev_rank;
                }
            } else {
                getRobot(rankList.get(c).robotNumber).autoSwitch.rank = 1;
            }
        }

        for (int c = 0; c < rankList.size(); c++) {
            if (c > 0) {
                int prev_rank = getRobot(rankList.get(c-1).robotNumber).autoScale.rank;
                if (getRobot(rankList.get(c).robotNumber).autoScale.avg < getRobot(rankList.get(c-1).robotNumber).autoScale.avg) {
                    getRobot(rankList.get(c).robotNumber).autoScale.rank = prev_rank + 1;
                } else {
                    getRobot(rankList.get(c).robotNumber).autoScale.rank = prev_rank;
                }
            } else {
                getRobot(rankList.get(c).robotNumber).autoScale.rank = 1;
            }
        }

        for (int c = 0; c < rankList.size(); c++) {
            if (c > 0) {
                int prev_rank = getRobot(rankList.get(c-1).robotNumber).totalSwitch.rank;
                if (getRobot(rankList.get(c).robotNumber).totalSwitch.avg < getRobot(rankList.get(c-1).robotNumber).totalSwitch.avg) {
                    getRobot(rankList.get(c).robotNumber).totalSwitch.rank = prev_rank + 1;
                } else {
                    getRobot(rankList.get(c).robotNumber).totalSwitch.rank = prev_rank;
                }
            } else {
                getRobot(rankList.get(c).robotNumber).totalSwitch.rank = 1;
            }
        }

        Collections.sort(rankList, new Comparator<RobotData>() {
            public int compare(RobotData o1, RobotData o2) {
                if (o1.totalScale.avg == o2.totalScale.avg)
                    return 0;
                return o1.totalScale.avg > o2.totalScale.avg ? -1 : 1;
            }
        });
        // now loop through the lists and set the rank based on avg score
        for (int c = 0; c < rankList.size(); c++) {
            if (c > 0) {
                int prev_rank = getRobot(rankList.get(c-1).robotNumber).totalScale.rank;
                if (getRobot(rankList.get(c).robotNumber).totalScale.avg < getRobot(rankList.get(c-1).robotNumber).totalScale.avg) {
                    getRobot(rankList.get(c).robotNumber).totalScale.rank = prev_rank + 1;
                } else {
                    getRobot(rankList.get(c).robotNumber).totalScale.rank = prev_rank;
                }
            } else {
                getRobot(rankList.get(c).robotNumber).totalScale.rank = 1;
            }
        }
        Collections.sort(rankList, new Comparator<RobotData>() {
            public int compare(RobotData o1, RobotData o2) {
                if (o1.autoCross.avg == o2.autoCross.avg)
                    return 0;
                return o1.autoCross.avg > o2.autoCross.avg ? -1 : 1;
            }
        });
        // now loop through the lists and set the rank based on avg score
        for (int c = 0; c < rankList.size(); c++) {
            getRobot(rankList.get(c).robotNumber).autoCross.rank = c + 1;
        }
        for (int c = 0; c < rankList.size(); c++) {
            if (c > 0) {
                int prev_rank = getRobot(rankList.get(c-1).robotNumber).autoCross.rank;
                if (getRobot(rankList.get(c).robotNumber).autoCross.avg < getRobot(rankList.get(c-1).robotNumber).autoCross.avg) {
                    getRobot(rankList.get(c).robotNumber).autoCross.rank = prev_rank + 1;
                } else {
                    getRobot(rankList.get(c).robotNumber).autoCross.rank = prev_rank;
                }
            } else {
                getRobot(rankList.get(c).robotNumber).autoCross.rank = 1;
            }
        }

        Collections.sort(rankList, new Comparator<RobotData>() {
            public int compare(RobotData o1, RobotData o2) {
                if (o1.autoSwitch.avg == o2.autoSwitch.avg)
                    return 0;
                return o1.autoSwitch.avg > o2.autoSwitch.avg ? -1 : 1;
            }
        });
        // now loop through the lists and set the rank based on avg score
        for (int c = 0; c < rankList.size(); c++) {
            if (c > 0) {
                int prev_rank = getRobot(rankList.get(c-1).robotNumber).autoSwitch.rank;
                if (getRobot(rankList.get(c).robotNumber).autoSwitch.avg < getRobot(rankList.get(c-1).robotNumber).autoSwitch.avg) {
                    getRobot(rankList.get(c).robotNumber).autoSwitch.rank = prev_rank + 1;
                } else {
                    getRobot(rankList.get(c).robotNumber).autoSwitch.rank = prev_rank;
                }
            } else {
                getRobot(rankList.get(c).robotNumber).autoSwitch.rank = 1;
            }
        }
        Collections.sort(rankList, new Comparator<RobotData>() {
            public int compare(RobotData o1, RobotData o2) {
                if (o1.totalSwitch.avg == o2.totalSwitch.avg)
                    return 0;
                return o1.totalSwitch.avg > o2.totalSwitch.avg ? -1 : 1;
            }
        });
        // now loop through the lists and set the rank based on avg score
        for (int c = 0; c < rankList.size(); c++) {
            if (c > 0) {
                int prev_rank = getRobot(rankList.get(c-1).robotNumber).totalSwitch.rank;
                if (getRobot(rankList.get(c).robotNumber).totalSwitch.avg < getRobot(rankList.get(c-1).robotNumber).totalSwitch.avg) {
                    getRobot(rankList.get(c).robotNumber).totalSwitch.rank = prev_rank + 1;
                } else {
                    getRobot(rankList.get(c).robotNumber).totalSwitch.rank = prev_rank;
                }
            } else {
                getRobot(rankList.get(c).robotNumber).totalSwitch.rank = 1;
            }
        }

        Collections.sort(rankList, new Comparator<RobotData>() {
            public int compare(RobotData o1, RobotData o2) {
                if (o1.climb.avg == o2.climb.avg)
                    return 0;
                return o1.climb.avg > o2.climb.avg ? -1 : 1;
            }
        });
        // now loop through the lists and set the rank based on avg score
        for (int c = 0; c < rankList.size(); c++) {
            if (c > 0) {
                int prev_rank = getRobot(rankList.get(c-1).robotNumber).climb.rank;
                if (getRobot(rankList.get(c).robotNumber).climb.avg < getRobot(rankList.get(c-1).robotNumber).climb.avg) {
                    getRobot(rankList.get(c).robotNumber).climb.rank = prev_rank + 1;
                } else {
                    getRobot(rankList.get(c).robotNumber).climb.rank = prev_rank;
                }
            } else {
                getRobot(rankList.get(c).robotNumber).climb.rank = 1;
            }
        }
    }

    public void getDataFromDB() {

        // make directory if not found
        File dataSheetDirFile = new File(dataSheetDir);
        if (dataSheetDirFile.exists() == false) {
            dataSheetDirFile.mkdir();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("My SQL JDBC Driver Not Registered?");
            e.printStackTrace();
            return;
        }
        System.out.println("Getting Data from SQL Database");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/roborebels", "root", "roborebels1153");
            Statement stmt;
            ResultSet rs;

            //create hashmap of data
            stmt = conn.createStatement();

            //get match table, then create robots
            rs = stmt.executeQuery("SELECT * from matchdata");

            //process Data
            RobotData rd;
            while (rs.next()) {
                int rn = rs.getInt("RobotNumber");
                String matchName = rs.getString("matchNumber");
                Integer matchNumber = Integer.parseInt(matchName);

                if (haveRobot(rn)) {
                    // check to see if we have this match number already, if not, add it to the list and increase
                    // number of matches
                    if (getRobot(rn).matchList.contains(matchNumber) == false) {
                        getRobot(rn).matches++;
                        getRobot(rn).matchList.add(matchNumber);
                    }
                } else {
                    rd = new RobotData();
                    rd.robotNumber = rn;
                    rd.matches = 1;
                    rd.matchList.add(matchNumber);
                    robotList.add(rd);

                }
            }
            rs.close();
            rs = stmt.executeQuery("SELECT * from matchdata");
            while (rs.next()) {
                int rn = rs.getInt("RobotNumber");
                if (haveRobot(rn)) {
                    String gameEvent = rs.getString("gameEvent");
                    if (gameEvent.equals("crossBaselineAuto")){getRobot(rn).autoCross.total++;}
                    if (gameEvent.equals("climbed")){getRobot(rn).climb.total++;}
                    if (gameEvent.equals("autoSwitch")){getRobot(rn).autoSwitch.total++;}
                    if (gameEvent.equals("teleSwitch")){getRobot(rn).teleSwitch.total++;}
                    if (gameEvent.equals("autoScale")){getRobot(rn).autoScale.total++;}
                    if (gameEvent.equals("teleScale")){getRobot(rn).teleScale.total++;}
                    if (gameEvent.equals("autoSwitch") || gameEvent.equals("teleSwitch")){getRobot(rn).totalSwitch.total++;}
                    if (gameEvent.equals("autoScale") || gameEvent.equals("teleScale")){getRobot(rn).totalScale.total++;}
                }
            }
            rs.close();
            stmt.close();

            //averages
            for (RobotData r : robotList) {
                r.autoCross.avg = (double) r.autoCross.total / r.matches;
                r.autoScale.avg = (double) r.autoScale.total / r.matches;
                r.teleScale.avg = (double) r.teleScale.total / r.matches;
                r.autoSwitch.avg = (double) r.autoSwitch.total / r.matches;
                r.teleSwitch.avg = (double) r.teleSwitch.total / r.matches;
                r.climb.avg = (double) r.climb.total / r.matches;
                r.totalSwitch.avg = (double) r.totalSwitch.total / r.matches;
                r.totalScale.avg = (double) r.totalScale.total / r.matches;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getRanks();



        for (RobotData r : robotList) {
            teamList.add(r.robotNumber);
        }

        //System.out.println("Got " + teamList.size() + " robots");

        for (Integer t1 : teamList) {
            for (Integer t2 : teamList) {
                for (Integer t3 : teamList) {
                    if (t1 != t3 && t3 != t2 && t1 != t2) {
                        AllianceData ad = new AllianceData();
                        ad.robot1 = t1;
                        ad.robot2 = t2;
                        ad.robot3 = t3;

                        // create the combined averages
                        ad.avgAutoScale = (getRobot(t1).autoScale.avg + getRobot(t2).autoScale.avg + getRobot(t3).autoScale.avg);
                        ad.avgTeleScale = (getRobot(t1).teleScale.avg + getRobot(t2).teleScale.avg + getRobot(t3).teleScale.avg);
                        ad.avgAutoSwitch = getRobot(t1).autoSwitch.avg + getRobot(t2).autoSwitch.avg + getRobot(t3).autoSwitch.avg;
                        ad.avgTeleSwitch = getRobot(t1).teleSwitch.avg + getRobot(t2).teleSwitch.avg + getRobot(t3).teleSwitch.avg;
                        ad.avgVault = getRobot(t1).vault.avg + getRobot(t2).vault.avg + getRobot(t3).vault.avg;
                        ad.avgClimbs = getRobot(t1).climb.avg + getRobot(t2).climb.avg + getRobot(t3).climb.avg;

                        ad.calcStrength();
                        adList1.add(ad);
                    }
                }
            }
        }

        for (Integer t1 : teamList) {
            for (Integer t2 : teamList) {
                for (Integer t3 : teamList) {
                    if (t1 != t3 && t3 != t2 && t1 != t2) {
                        AllianceData ad = new AllianceData();
                        ad.robot1 = t1;
                        ad.robot2 = t2;
                        ad.robot3 = t3;

                        // create the combined averages
                        ad.avgAutoScale = (getRobot(t1).autoScale.avg + getRobot(t2).autoScale.avg + getRobot(t3).autoScale.avg);
                        ad.avgTeleScale = (getRobot(t1).teleScale.avg + getRobot(t2).teleScale.avg + getRobot(t3).teleScale.avg);
                        ad.avgAutoSwitch = getRobot(t1).autoSwitch.avg + getRobot(t2).autoSwitch.avg + getRobot(t3).autoSwitch.avg;
                        ad.avgTeleSwitch = getRobot(t1).teleSwitch.avg + getRobot(t2).teleSwitch.avg + getRobot(t3).teleSwitch.avg;
                        ad.avgVault = getRobot(t1).vault.avg + getRobot(t2).vault.avg + getRobot(t3).vault.avg;
                        ad.avgClimbs = getRobot(t1).climb.avg + getRobot(t2).climb.avg + getRobot(t3).climb.avg;

                        ad.calcStrength();
                        adList2.add(ad);
                    }
                }
            }
        }
        for (Integer t1 : teamList) {
            for (Integer t2 : teamList) {
                for (Integer t3 : teamList) {
                    if (t1 != t3 && t3 != t2 && t1 != t2) {
                        AllianceData ad = new AllianceData();
                        ad.robot1 = t1;
                        ad.robot2 = t2;
                        ad.robot3 = t3;

                        // create the combined averages
                        ad.avgAutoScale = (getRobot(t1).autoScale.avg + getRobot(t2).autoScale.avg + getRobot(t3).autoScale.avg);
                        ad.avgTeleScale = (getRobot(t1).teleScale.avg + getRobot(t2).teleScale.avg + getRobot(t3).teleScale.avg);
                        ad.avgAutoSwitch = getRobot(t1).autoSwitch.avg + getRobot(t2).autoSwitch.avg + getRobot(t3).autoSwitch.avg;
                        ad.avgTeleSwitch = getRobot(t1).teleSwitch.avg + getRobot(t2).teleSwitch.avg + getRobot(t3).teleSwitch.avg;
                        ad.avgVault = getRobot(t1).vault.avg + getRobot(t2).vault.avg + getRobot(t3).vault.avg;
                        ad.avgClimbs = getRobot(t1).climb.avg + getRobot(t2).climb.avg + getRobot(t3).climb.avg;

                        ad.calcStrength();
                        adList3.add(ad);
                    }
                }
            }
        }
        for (Integer t1 : teamList) {
            for (Integer t2 : teamList) {
                for (Integer t3 : teamList) {
                    if (t1 != t3 && t3 != t2 && t1 != t2) {
                        AllianceData ad = new AllianceData();
                        ad.robot1 = t1;
                        ad.robot2 = t2;
                        ad.robot3 = t3;

                        // create the combined averages
                        ad.avgAutoScale = (getRobot(t1).autoScale.avg + getRobot(t2).autoScale.avg + getRobot(t3).autoScale.avg);
                        ad.avgTeleScale = (getRobot(t1).teleScale.avg + getRobot(t2).teleScale.avg + getRobot(t3).teleScale.avg);
                        ad.avgAutoSwitch = getRobot(t1).autoSwitch.avg + getRobot(t2).autoSwitch.avg + getRobot(t3).autoSwitch.avg;
                        ad.avgTeleSwitch = getRobot(t1).teleSwitch.avg + getRobot(t2).teleSwitch.avg + getRobot(t3).teleSwitch.avg;
                        ad.avgVault = getRobot(t1).vault.avg + getRobot(t2).vault.avg + getRobot(t3).vault.avg;
                        ad.avgClimbs = getRobot(t1).climb.avg + getRobot(t2).climb.avg + getRobot(t3).climb.avg;

                        ad.calcStrength();
                        adList4.add(ad);
                    }
                }
            }
        }
        for (Integer t1 : teamList) {
            for (Integer t2 : teamList) {
                for (Integer t3 : teamList) {
                    if (t1 != t3 && t3 != t2 && t1 != t2) {
                        AllianceData ad = new AllianceData();
                        ad.robot1 = t1;
                        ad.robot2 = t2;
                        ad.robot3 = t3;

                        // create the combined averages
                        ad.avgAutoScale = (getRobot(t1).autoScale.avg + getRobot(t2).autoScale.avg + getRobot(t3).autoScale.avg);
                        ad.avgTeleScale = (getRobot(t1).teleScale.avg + getRobot(t2).teleScale.avg + getRobot(t3).teleScale.avg);
                        ad.avgAutoSwitch = getRobot(t1).autoSwitch.avg + getRobot(t2).autoSwitch.avg + getRobot(t3).autoSwitch.avg;
                        ad.avgTeleSwitch = getRobot(t1).teleSwitch.avg + getRobot(t2).teleSwitch.avg + getRobot(t3).teleSwitch.avg;
                        ad.avgVault = getRobot(t1).vault.avg + getRobot(t2).vault.avg + getRobot(t3).vault.avg;
                        ad.avgClimbs = getRobot(t1).climb.avg + getRobot(t2).climb.avg + getRobot(t3).climb.avg;

                        ad.calcStrength();
                        adList5.add(ad);
                    }
                }
            }
        }
        for (Integer t1 : teamList) {
            for (Integer t2 : teamList) {
                for (Integer t3 : teamList) {
                    if (t1 != t3 && t3 != t2 && t1 != t2) {
                        AllianceData ad = new AllianceData();
                        ad.robot1 = t1;
                        ad.robot2 = t2;
                        ad.robot3 = t3;

                        // create the combined averages
                        ad.avgAutoScale = (getRobot(t1).autoScale.avg + getRobot(t2).autoScale.avg + getRobot(t3).autoScale.avg);
                        ad.avgTeleScale = (getRobot(t1).teleScale.avg + getRobot(t2).teleScale.avg + getRobot(t3).teleScale.avg);
                        ad.avgAutoSwitch = getRobot(t1).autoSwitch.avg + getRobot(t2).autoSwitch.avg + getRobot(t3).autoSwitch.avg;
                        ad.avgTeleSwitch = getRobot(t1).teleSwitch.avg + getRobot(t2).teleSwitch.avg + getRobot(t3).teleSwitch.avg;
                        ad.avgVault = getRobot(t1).vault.avg + getRobot(t2).vault.avg + getRobot(t3).vault.avg;
                        ad.avgClimbs = getRobot(t1).climb.avg + getRobot(t2).climb.avg + getRobot(t3).climb.avg;

                        ad.calcStrength();
                        adList6.add(ad);
                    }
                }
            }
        }
        for (Integer t1 : teamList) {
            for (Integer t2 : teamList) {
                for (Integer t3 : teamList) {
                    if (t1 != t3 && t3 != t2 && t1 != t2) {
                        AllianceData ad = new AllianceData();
                        ad.robot1 = t1;
                        ad.robot2 = t2;
                        ad.robot3 = t3;

                        // create the combined averages
                        ad.avgAutoScale = (getRobot(t1).autoScale.avg + getRobot(t2).autoScale.avg + getRobot(t3).autoScale.avg);
                        ad.avgTeleScale = (getRobot(t1).teleScale.avg + getRobot(t2).teleScale.avg + getRobot(t3).teleScale.avg);
                        ad.avgAutoSwitch = getRobot(t1).autoSwitch.avg + getRobot(t2).autoSwitch.avg + getRobot(t3).autoSwitch.avg;
                        ad.avgTeleSwitch = getRobot(t1).teleSwitch.avg + getRobot(t2).teleSwitch.avg + getRobot(t3).teleSwitch.avg;
                        ad.avgVault = getRobot(t1).vault.avg + getRobot(t2).vault.avg + getRobot(t3).vault.avg;
                        ad.avgClimbs = getRobot(t1).climb.avg + getRobot(t2).climb.avg + getRobot(t3).climb.avg;

                        ad.calcStrength();
                        adList7.add(ad);
                    }
                }
            }
        }
        for (Integer t1 : teamList) {
            for (Integer t2 : teamList) {
                for (Integer t3 : teamList) {
                    if (t1 != t3 && t3 != t2 && t1 != t2) {
                        AllianceData ad = new AllianceData();
                        ad.robot1 = t1;
                        ad.robot2 = t2;
                        ad.robot3 = t3;

                        // create the combined averages
                        ad.avgAutoScale = (getRobot(t1).autoScale.avg + getRobot(t2).autoScale.avg + getRobot(t3).autoScale.avg);
                        ad.avgTeleScale = (getRobot(t1).teleScale.avg + getRobot(t2).teleScale.avg + getRobot(t3).teleScale.avg);
                        ad.avgAutoSwitch = getRobot(t1).autoSwitch.avg + getRobot(t2).autoSwitch.avg + getRobot(t3).autoSwitch.avg;
                        ad.avgTeleSwitch = getRobot(t1).teleSwitch.avg + getRobot(t2).teleSwitch.avg + getRobot(t3).teleSwitch.avg;
                        ad.avgVault = getRobot(t1).vault.avg + getRobot(t2).vault.avg + getRobot(t3).vault.avg;
                        ad.avgClimbs = getRobot(t1).climb.avg + getRobot(t2).climb.avg + getRobot(t3).climb.avg;

                        ad.calcStrength();
                        adList8.add(ad);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
