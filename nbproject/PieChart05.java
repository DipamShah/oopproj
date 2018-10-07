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
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.colors.BaseSeriesColors;
import org.knowm.xchart.style.colors.ChartColor;
import static org.knowm.xchart.style.colors.GGPlot2SeriesColors.BLUE;
/**
 * Pie Chart with Donut Style and sum.
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>Donut Chart
 *   <li>PieChartBuilder
 *   <li>XChart Theme
 */
public class PieChart05 implements ExampleChart<PieChart> {

  public static void main(String[] args) throws IOException {

    ExampleChart<PieChart> exampleChart = new PieChart05();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<PieChart>(chart).displayChart();
    BitmapEncoder.saveBitmap(chart, "./Library Area", BitmapEncoder.BitmapFormat.PNG);
  }

  @Override
  public PieChart getChart() {
  Connection con = DbConnect.getConnection();
    // Create Chart
    PieChart chart =
        new PieChartBuilder()
            .width(800)
            .height(600)
            .title("LIBRARY AREA")
            .theme(ChartTheme.GGPlot2).build();
    // Customize Chart
    chart.getStyler().setLegendVisible(true);
    chart.getStyler().setAnnotationType(AnnotationType.Label);
    chart.getStyler().setAnnotationDistance(.82);
    chart.getStyler().setPlotContentSize(.9);
    chart.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);
    chart.getStyler().setDecimalPattern("#");
    chart.getStyler().setSeriesColors(new BaseSeriesColors().getSeriesColors());
    chart.getStyler().setSumVisible(true);
    chart.getStyler().setSumFontSize(30f);
    chart.getStyler().setChartBackgroundColor(Color.LIGHT_GRAY);
    chart.getStyler().setPlotBackgroundColor(ChartColor.getAWTColor(ChartColor.WHITE));
    // Series
    try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM libraryarea");
                double data = 0;
                String str = "";
                while (resultSet.next()) 
                {
                    System.out.println("Connected to database");
                    str = resultSet.getString("TYPE");
                    data=(Double.parseDouble(resultSet.getString("AREA")));
                    chart.addSeries(str,data);
                }
            } 
    catch (NumberFormatException | SQLException e) 
    {
                System.out.println(e);
    }
    return chart;
  }
}