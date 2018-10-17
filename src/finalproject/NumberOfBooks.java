/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xproject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import static org.knowm.xchart.style.Styler.LegendPosition.OutsideS;
/**
 *
 * @author shlok
 */
public class NumberOfBooks implements ExampleChart<CategoryChart>
{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  public static void main(String[] args){

    ExampleChart<CategoryChart> exampleChart = new NumberOfBooks();
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
            .title("BOOKS PURCHASED EVERY YEAR")
            .xAxisTitle("YEAR")
            .yAxisTitle("NUMBER OF BOOKS")
            .theme(Styler.ChartTheme.Matlab)
            .build();

    // Customize Chart
    chart.getStyler().setPlotGridVerticalLinesVisible(false);
    chart.getStyler().setStacked(true);
    chart.getStyler().setToolTipsEnabled(true);
    chart.getStyler().setToolTipType(Styler.ToolTipType.yLabels);
    chart.getStyler().setPlotGridLinesVisible(false);
    chart.getStyler().setLegendPosition(OutsideS);
    chart.getStyler().setXAxisLabelRotation(45);
    // Series
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<Double> b = new ArrayList<Double>();
    Connection con = DbConnect.getConnection();
    int i = 0;
    try
    {
        Statement statement = null;
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM numberofbooks");
        while(rs.next())
        {
            a.add(rs.getString("year"));
            b.add(Double.parseDouble(rs.getString("numberofbooks")));
            i++;
        }
    }catch(Exception e)
    {
        System.out.println(e);
    }
    chart.addSeries("NUMBER OF BOOKS PURCHASED BY LIBRARY EVERY YEAR",a,b);
    return chart;
  }
}
