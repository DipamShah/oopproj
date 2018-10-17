/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchart;
/**
 *
 * @author shlok
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.ChartTheme;
import static org.knowm.xchart.style.Styler.LegendPosition.OutsideE;
import static org.knowm.xchart.style.Styler.LegendPosition.OutsideS;
public class PeriodicalsPerYear implements ExampleChart<CategoryChart> {

  public static void main(String[] args) {

    ExampleChart<CategoryChart> exampleChart = new PeriodicalsPerYear();
    CategoryChart chart = exampleChart.getChart();
    new SwingWrapper<CategoryChart>(chart).displayChart();
  }

  @Override
  public CategoryChart getChart() {

    // Create Chart
    CategoryChart chart =
        new CategoryChartBuilder()
            .width(800)
            .height(600)
            .title("PERIODICALS PER YEAR")
            .xAxisTitle("YEAR")
            .yAxisTitle("PERIODICALS")
            .theme(ChartTheme.GGPlot2)
            .build();

    // Customize Chart
    chart.getStyler().setPlotGridVerticalLinesVisible(false);
    chart.getStyler().setStacked(true);
    chart.getStyler().setToolTipsEnabled(true);
    chart.getStyler().setToolTipType(Styler.ToolTipType.yLabels);
    chart.getStyler().setPlotGridLinesVisible(false);
    chart.getStyler().setLegendPosition(OutsideS);
    chart.getStyler().setXAxisLabelRotation(50);
    // Series
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<Double> b = new ArrayList<Double>();
    Connection con = DbConnect.getConnection();
    int i = 0;
    try
    {
        Statement statement = null;
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM expenditureonperiodicals");
        while(rs.next())
        {
            a.add(rs.getString("year"));
            b.add(Double.parseDouble(rs.getString("amount")));
            i++;
        }
    }catch(Exception e)
    {
        System.out.println(e);
    }
    chart.addSeries("EXPENDITURE ON PERIODICALS",a,b);
    return chart;
  }
}