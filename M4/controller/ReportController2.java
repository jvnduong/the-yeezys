package controller;

/**
 * Created by Brandon on 10/19/16.
 */

import fxapp.MainFXApplication;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import model.User;
import model.Report;

public class ReportController2 {

    private MainFXApplication screen;
    private Report selection;

    @FXML
    private Label srcName;

    @FXML
    private Label name;

    @FXML
    private Label latitude;

    @FXML
    private Label longitude;

    @FXML
    private Label nsLabel;

    @FXML
    private Label ewLabel;

    @FXML
    private Label number;

    @FXML
    private Label verified;

    @FXML
    private Label date;

    /**
     * Sets the controller's main to the application.
     * @param screen The application using this controller.
     */
    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    /**
     * Loads and displays a report.
     * @param report Report that gets loaded and displayed.
     */
    public void loadReport(Report report) {
        selection = report;

        String day = selection.getDate();
        User reporter = selection.getReporter();
        String ns = selection.getNSDir();
        String ew = selection.getEWDir();
        String type = selection.getType();
        User verifier = selection.getVerifier();
        String condition = selection.getCondition();
        int num = selection.getNumber();
        double lat = Math.abs(selection.getX());
        double lon = Math.abs(selection.getY());

        number.setText(Integer.toString(num));
        date.setText(day);
        srcName.setText(type);
        name.setText(reporter.getName());
        latitude.setText(Double.toString(lat));
        longitude.setText("\t" + Double.toString(lon));
        nsLabel.setText("\t" + ns);
        ewLabel.setText("\t" + ew);
        verified.setText(condition);

        number.setVisible(true);
        date.setVisible(true);
        srcName.setVisible(true);
        name.setVisible(true);
        latitude.setVisible(true);
        longitude.setVisible(true);
        nsLabel.setVisible(true);
        ewLabel.setVisible(true);
        verified.setVisible(true);
    }

    @FXML
    private void handleBack() {
        screen.init(7);
    }
}