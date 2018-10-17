/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xproject;
/**
 *
 * @author shlok
 */
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.ChartTheme;
import static org.knowm.xchart.style.Styler.LegendPosition.InsideNW;
import static org.knowm.xchart.style.Styler.LegendPosition.OutsideS;
public class Users implements ExampleChart<PieChart> {

  public static void main(String[] args) throws IOException {

    ExampleChart<PieChart> exampleChart = new Users();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<PieChart>(chart).displayChart();
    JPanel pnlChart = new XChartPanel(chart);      
    pnlChart.validate();
  }
  @Override
  public PieChart getChart() {
     Connection con =  DbConnect.getConnection();  
    // Create Chart
    PieChart chart =
        new PieChartBuilder()
            .width(800)
            .height(600)
            .title("USERS IN THE LIBRARY")
            .theme(ChartTheme.Matlab)
            .build();
    // Customize Chart
    chart.getStyler().setLegendVisible(true);
    chart.getStyler().setAnnotationDistance(1.5);
    chart.getStyler().setPlotContentSize(.7);
    chart.getStyler().setPlotBackgroundColor(new Color(229,229,229));
    chart.getStyler().setCircular(true);
    chart.getStyler().setStartAngleInDegrees(90);
    chart.getStyler().setToolTipsEnabled(true);
    chart.getStyler().setToolTipType(Styler.ToolTipType.xAndYLabels);
    chart.getStyler().setLegendPosition(InsideNW);
    //chart.getStyler().set
    Color[] sliceColors =
        new Color[] {
          new Color(127,127,127),
          new Color(229,248,255),
          new Color(25,81,102),
        };
    chart.getStyler().setSeriesColors(sliceColors);
    chart.getStyler().setAnnotationType(AnnotationType.Value);
    // Series
    String xData[] = new String[3];
    int yData[] = new int[3];
    try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                int i = 0;
                while (resultSet.next()) 
                {
                    xData[i] = resultSet.getString("USERS");
                    yData[i] = Integer.parseInt(resultSet.getString("VALUE"));
                    chart.addSeries(xData[i],yData[i]);
                }
            } 
    catch (NumberFormatException | SQLException e) 
    {
                System.out.println(e);
    }
    //chart.addSeries(xData,yData);
    return chart;
  }
}