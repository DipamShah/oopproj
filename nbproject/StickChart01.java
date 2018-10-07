/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xproject;

import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries.CategorySeriesRenderStyle;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.Styler.LegendPosition;

/**
 *
 * @author shlok
 */
public class StickChart01 implements ExampleChart<CategoryChart> {
 
  public static void main(String[] args) throws IOException {
 
    ExampleChart<CategoryChart> exampleChart = new StickChart01();
    CategoryChart chart = exampleChart.getChart();
    new SwingWrapper<CategoryChart>(chart).displayChart();
    BitmapEncoder.saveBitmap(chart, "./NATIONAL JOURNALS", BitmapEncoder.BitmapFormat.PNG);
  }
 
  @Override
  public CategoryChart getChart() {
    Connection con = DbConnect.getConnection();
    // Create Chart
    CategoryChart chart = new CategoryChartBuilder()
            .width(800).height(600).
            title("JOURNALS ISSUED BY LIBRARY EVERY YEAR").
            theme(ChartTheme.Matlab).build();
    // Customize Chart
    chart.getStyler().setChartTitleVisible(true);
    chart.getStyler().setLegendPosition(LegendPosition.OutsideS);
    chart.getStyler().setDefaultSeriesRenderStyle(CategorySeriesRenderStyle.Stick);
    chart.getStyler().setPlotGridLinesColor(new Color(255, 255, 255));
    chart.getStyler().setChartFontColor(Color.BLACK);
    // Series
    List<Integer> xData = new ArrayList<Integer>();
    List<Integer> yData = new ArrayList<Integer>();
    try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM nationaljournal");
                int i = 0;
                while (resultSet.next()) 
                {
                    System.out.println("Connected to database");
                    xData.add(i,Integer.parseInt(resultSet.getString("YEAR")));
                    yData.add(i,Integer.parseInt(resultSet.getString("NUMBER")));
                }
            } 
    catch (NumberFormatException | SQLException e) 
    {
                System.out.println(e);
    }
    chart.addSeries("NUMBER OF JOURNALS IN LIBRARY", xData, yData);
    return chart;
  }
}
