package marketingBackendChallenge;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;
import marketingBackendChallenge.Consumers;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.DefaultPieDataset;

public class ChartTeens extends JFrame {

    private Consumers consumer;
    
    public ChartTeens(Consumers consumer) {
        this.consumer = consumer;
        initUI();
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
       
        ChartPanel chartPanel = new ChartPanel(chart);
        
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        
        add(chartPanel);

        pack();
        setTitle("Consumers with Teenagers at home");
        setLocationRelativeTo(null);
        setSize(500, 500);
        
        
        
    }

    private CategoryDataset createDataset() {

    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(consumer.getCostumersWithTeens(), "Consumers", "With Teenagers");
                dataset.setValue(consumer.getCostumersWithoutTeens(), "Consumers", "Without Teenagers");
                

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        
        JFreeChart barChart = ChartFactory.createBarChart(
                "Consumers with Teenagers at home",
                "",
                "Consumers",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return barChart;
    }

}
  


