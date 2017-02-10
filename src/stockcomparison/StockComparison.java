/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcomparison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author achis
 */
public class StockComparison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String line = null;
        String fileName = "table2.csv";
        
        //array list to store data in. Used arraylist so we can change number of lines read and not worry about it
        ArrayList<String> stockInfoArrayList = new ArrayList<>();
        
        //reads in 31 lines of data from file, adds each line to stockInfoArrayList
        try{
            int i = 0;
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null && i <=31){
                stockInfoArrayList.add(line);
                i++;
            }
            
        }
        catch(Exception ex){
            System.out.println("Something went wrong");
        }
        
        // Making new array to store arrays of data made by splitting lines at
        // commas because it will use up less memory than the ArrayList which
        // can now be garbage collected
        String[][] stockInfo = new String[stockInfoArrayList.size()][6];
        
        // Printing the info we want, in this case date, high, low, and close price
        for (int i = 0; i < stockInfoArrayList.size();i++){
            stockInfo[i] = stockInfoArrayList.get(i).split(",");
            System.out.println(stockInfo[i][0] + " " + stockInfo[i][2] + " " + stockInfo[i][3] + " " + stockInfo[i][4]);
        }
        
    }
    
}
