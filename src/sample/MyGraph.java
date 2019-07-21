package sample;
import com.sun.jdi.event.StepEvent;
import javafx.scene.chart.XYChart;

public class MyGraph {
    private XYChart<Double, Double> graph;
    private double LeftBound;
    private double RightBound;
    private double Step;

    public MyGraph(final XYChart<Double, Double> graph, final double LeftBound, final double RightBound, final double Step) {
        this.graph = graph;
        this.LeftBound = LeftBound;
        this.RightBound = RightBound;
        this.Step = Step;
    }
    public void plotLine(String Example) {
        String ReplacedExample = Example;
        final XYChart.Series<Double, Double> series = new XYChart.Series<>();
        try {
            if (LeftBound > RightBound) throw new Exception();
            for (double x = LeftBound; x <= RightBound; x = x + Step) {
                ReplacedExample = ReplacedExample.replaceAll("X", String.valueOf(x));
                plotPoint(x, Double.parseDouble(BasicCalculator.Calculate(ReplacedExample)), series);
                ReplacedExample = Example;
            }
            graph.getData().add(series);
        } catch (Exception e){

        }
    }
    private void plotPoint(double x, double y, XYChart.Series<Double, Double> series) {
        series.getData().add(new XYChart.Data<>(x, y));
    }
    public void clear() {
        graph.getData().clear();
    }
}
