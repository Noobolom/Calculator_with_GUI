package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerGraphFunctionBuilder {

    @FXML
    private AreaChart<Double, Double> areaGraph;

    @FXML
    private TextField field_for_function;

    @FXML
    private Button Build_Graphic;

    @FXML
    private Button Clear;

    @FXML
    private TextField LeftBound;

    @FXML
    private TextField Step;

    @FXML
    private TextField RightBound;

    @FXML
    private Label StepErrorLabel;

    private MyGraph areaMathsGraph;

    @FXML
    public void initialize() {

        Build_Graphic.setOnAction(event -> {
            try {
                double left_bound = Double.parseDouble(LeftBound.getText());
                double right_bound = Double.parseDouble(RightBound.getText());
                double step = Double.parseDouble(Step.getText());
                if (step <= 0){
                    StepErrorLabel.setText("Step can't be negative");
                } else if (step <= 0.001){
                    StepErrorLabel.setText("Step is too small");
                } else {
                    areaMathsGraph = new MyGraph(areaGraph, left_bound, right_bound, step);
                    String Example = field_for_function.getText();
                    plotLine(Example);
                    StepErrorLabel.setText("");
                }
            } catch (Exception e){}
        });


        Clear.setOnAction(event -> areaMathsGraph.clear());
    }

    private void plotLine(String Example) {
        areaMathsGraph.plotLine(Example);
    }
}
