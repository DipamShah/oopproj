/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler.ChartTheme;
/**
 *
 * @author shlok
 */
  public class BarChart05 implements ExampleChart<CategoryChart> {
      
      
  public XChartPanel getPanel() throws IOException {
    ExampleChart<CategoryChart> exampleChart = new BarChart05();
    CategoryChart chart = exampleChart.getChart();
    XChartPanel panel=new XChartPanel(chart);
    
    return panel;
    //new SwingWrapper<CategoryChart>(chart).displayChart();
    //BitmapEncoder.saveBitmap(chart, "./BRANCH WISE DISTRIBUTION", BitmapEncoder.BitmapFormat.PNG);
  }
  @Override
  public CategoryChart getChart() {
    // Create Chart
   // Connection con = DbConnect.getConnection();
    CategoryChart chart = new CategoryChartBuilder().width(800).height(600)
            .title("BRANCH WISE DISTRIBUTION")
            .xAxisTitle("BRANCH")
            .yAxisTitle("DISTRIBUTION")
            .theme(ChartTheme.GGPlot2).build();
    // Customize Chart
    chart.getStyler().setPlotGridLinesVisible(false);
    // Series
    List<String> xData = new ArrayList<String>();
    List<Integer> yData = new ArrayList<Integer>();
 /*   try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM noofvolumes");
                int i = 0;
                while (resultSet.next()) 
                {
                    System.out.println("Connected to database");
                    xData.add(i,resultSet.getString("BRANCH"));
                    yData.add(i,Integer.parseInt(resultSet.getString("VOLUMES")));
                    i++;
                }
            } 
    catch (NumberFormatException | SQLException e) 
    {
                System.out.println(e);
    }*/
    xData.add("A");
    xData.add("B");
    yData.add(new Integer(4));
    yData.add(new Integer(10));
    chart.addSeries("NUMBER OF VOLUMES",xData,yData);
    List<String> xData1 = new ArrayList<String>();
    List<Integer> yData1 = new ArrayList<Integer>();
   /* try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM nooftitles");
                int i = 0;
                while (resultSet.next()) 
                {
                    System.out.println("Connected to database");
                    xData1.add(i,resultSet.getString("BRANCH"));
                    yData1.add(i,Integer.parseInt(resultSet.getString("TITLES")));
                    i++;
                }
            } 
    catch (NumberFormatException | SQLException e) 
    {
                System.out.println(e);
    }*/
   xData1.add("C");
   xData1.add("D");
   yData1.add(new Integer(20));
   yData1.add(new Integer(1));
    chart.addSeries("NUMBER OF TITLES",xData1,yData1);
    return chart;
  }
}