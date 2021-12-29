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
public class Costumers {
   
   
    private List<List<Object>> values;
    private int costumersWithChildren = 0 ;
    private int costumersWithTeens= 0 ;
    private List<Costumers> allCostumers = new ArrayList<>();
    private List<Costumers> costumers57 = new ArrayList<>();
    private int yearBorn;
    private String education;
    private int costumersWithoutChildren;
    private int costumersWithoutTeens;
    private String martialStatus;
    private int children;
    private int teens;
    private int othersCostumers;
    private int size ;
    
    
    Costumers(List<List<Object>> values ){
       this.values = values;
       Costumers57(values);
        
    }
    Costumers(int yearBorn,String education,String martialStatus,int children,int teens){
        this.yearBorn = yearBorn;
        this.education = education;
        this.martialStatus = martialStatus;
        this.children = children;
        this.teens = teens;
                
    }
            
    
  
    public void Costumers57(List<List<Object>> costumers) {
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
           
          
           allCostumers.add(new Costumers(yearBirth,education,martialStatus,children,teens));
           if(yearBirth >= 1957 && yearBirth <= 1967 && education.equals("Master") && martialStatus.equals("Married")){
               costumers57.add(new Costumers(yearBirth,education,martialStatus,children,teens));
               totalOfConstumers57++; 
           }  
      }
         
         for(Costumers c : allCostumers){
            
             if(c.getChildren() > 0){
                 
                 costumersWithChildren++;
             }if(c.getTeens() > 0){
                 costumersWithTeens++;
             }if(c.getChildren() == 0){
                 
                 costumersWithoutChildren++;
             }if(c.getTeens() == 0){
                 
                 
                 costumersWithoutTeens++;
             }
         }
         othersCostumers = size - costumers57.size();
     
    }
    public ChartFrame getCostumers57to67(){
            
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Costumers with different age", othersCostumers);
		dataset.setValue("Costumers born between 1958 to 1968", costumers57.size());
	
		// Creation Of Chart.
		JFreeChart chart = ChartFactory.createPieChart("Costumers Age", dataset, true, // legend?
				true, // tooltips?
				false // URLs?
		);
                
		chart.setTitle("Costumers Age");
                
		ChartFrame frame = new ChartFrame("Costumers Age", chart);
                frame.setSize(500, 500);
		
		return frame;

        
    }

    public void HowManyHaveChilden(){
        
               
        System.out.println("aa");
        /**DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Costumers  with Children", costumersWithChildren);
		dataset.setValue("Costumers without children", (costumers57.size()-costumersWithChildren));
                
		// Creation Of Chart.
		JFreeChart chart = ChartFactory.createPieChart("Costumersborn between 1958 to 1968 with Kids at home", dataset, true, // legend?
				true, // tooltips?
				false // URLs?
		);
                
		
                chart.setTitle("Costumersborn between 1958 to 1968 Kids at home");
                
		ChartFrame frame = new ChartFrame("Costumers Kids", chart);
                
                frame.setSize(500, 500);
		
		return frame;**/
        
    }
    
        public ChartFrame HowManyHaveTeens(){
        DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Costumers with Teenagers", costumersWithTeens);
		dataset.setValue("Costumers without Teenagers", (costumers57.size()-costumersWithTeens));
	
		// Creation Of Chart.
		JFreeChart chart = ChartFactory.createPieChart("Costumers born between 1958 to 1968 Teens at home", dataset, true, // legend?
				true, // tooltips?
				false // URLs?
		);
                
		chart.setTitle("Costumers born between 1958 to 1968 Teens at home");
                
		ChartFrame frame = new ChartFrame("Costumers Teens", chart);
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
        return othersCostumers;
    }

 

    public int getCostumersWithChildren() {
        return costumersWithChildren;
    }

    public int getCostumersWithTeens() {
        return costumersWithTeens;
    }

    public List<Costumers> getCostumers57() {
        return costumers57;
    }

    public int getCostumersWithoutChildren() {
        return costumersWithoutChildren;
    }

    public int getCostumersWithoutTeens() {
        return costumersWithoutTeens;
    }


    
    
    
    
}
