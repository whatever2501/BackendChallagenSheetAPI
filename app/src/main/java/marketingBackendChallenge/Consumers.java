/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketingBackendChallenge;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.awt.Color;
import static java.awt.Color.red;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author L
 */
public class Consumers {
   
   
   
    private int consumersWithChildren = 0 ;
    private int consumersWithTeens= 0 ;
    private List<Consumers> allConsumers = new ArrayList<>();
    private List<Consumers> consumers57 = new ArrayList<>();
    private int consumersWithoutChildren;
    private int consumersWithoutTeens;
    private int children;
    private int teens;
    private int othersConsumers;
    private int size ;
    
    
    Consumers(List<List<Object>> values ){
     
       Consumers57(values);
        
    }
    Consumers(int children,int teens){
    
        this.children = children;
        this.teens = teens;
                
    }
            
    
  
    public void Consumers57(List<List<Object>> costumers) {
         size = costumers.size();
        float totalOfConstumers57 = 0;
         for(int row = 1; row < size; row++){
           
           List<Object> costumer = costumers.get(row);
           
           String id = costumer.get(0).toString();
           int yearBirth = Integer.parseInt(costumer.get(1).toString());
           String education = costumer.get(2).toString();
           String martialStatus = costumer.get(3).toString();
           int children = Integer.parseInt(costumer.get(5).toString()) ;
           int teens = Integer.parseInt(costumer.get(6).toString());
           
          
           allConsumers.add(new Consumers(children,teens));
           if(yearBirth >= 1957 && yearBirth <= 1967 && education.equals("Master") && martialStatus.equals("Married")){
               consumers57.add(new Consumers(children,teens));
               totalOfConstumers57++; 
           }  
      }
         
         for(Consumers c : allConsumers){
            
             if(c.getChildren() > 0){
                 consumersWithChildren++;
             }if(c.getTeens() > 0){
                 consumersWithTeens++;
             }if(c.getChildren() == 0){
                 consumersWithoutChildren++;
             }if(c.getTeens() == 0){ 
                 consumersWithoutTeens++;
             }
         }
         othersConsumers = size - consumers57.size();
     
    }
    public ChartFrame getConsumers57to67(){
            
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Consumers with different age", othersConsumers);
		dataset.setValue("Consumers born between 1958 to 1968", consumers57.size());
	
		// Creation Of Chart.
		JFreeChart chart = ChartFactory.createPieChart("Consumers Age", dataset, true, // legend?
				true, // tooltips?
				false // URLs?
		);
                
		chart.setTitle("Consumers Age");
                
		ChartFrame frame = new ChartFrame("Consumers Age", chart);
                frame.setSize(500, 500);
		
		return frame;

        
    }
    
        public ChartFrame HowManyHaveTeens(){
        DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Consumers with Teenagers", consumersWithTeens);
		dataset.setValue("Consumers without Teenagers", (consumers57.size()-consumersWithTeens));
	
		// Creation Of Chart.
		JFreeChart chart = ChartFactory.createPieChart("Consumers born between 1958 to 1968 Teens at home", dataset, true, // legend?
				true, // tooltips?
				false // URLs?
		);
                
		chart.setTitle("Consumers born between 1958 to 1968 Teens at home");
                
		ChartFrame frame = new ChartFrame("Consumers Teens", chart);
                frame.setSize(500, 500);
		
		return frame;
        
    }
    
    
    public int getChildren() {
        return children;
    }

    public int getTeens() {
        return teens;
    }

    public int getOthersCostumers() {
        return othersConsumers;
    }

 

    public int getCostumersWithChildren() {
        return consumersWithChildren;
    }

    public int getCostumersWithTeens() {
        return consumersWithTeens;
    }

    public List<Consumers> getCostumers57() {
        return consumers57;
    }

    public int getCostumersWithoutChildren() {
        return consumersWithoutChildren;
    }

    public int getCostumersWithoutTeens() {
        return consumersWithoutTeens;
    }


    
    
    
    
}
