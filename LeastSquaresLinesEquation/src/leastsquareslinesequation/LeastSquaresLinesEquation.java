package leastsquareslinesequation;
import java.util.Scanner;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.Vector;
import java.util.LinkedList;
/**
 *
 * @author Juan
 */
public class LeastSquaresLinesEquation {

    public static void main(String[] args) {
        //Creating scanner for inputting data
        Scanner input = new Scanner(System.in);
        
        //Declaring variables
        String fileName;//For storing the file name
        float[] colOne = new float[100];
        float[] colTwo = new float[100];
        int numPair = 0;
        float sumX = 0.0f;
        float sumY = 0.0f;
        float sumXSq = 0.0f;
        float sumProd = 0.0f;
        float xAvg = 0.0f;
        float yAvg = 0.0f;
        float slope;
        float yInt;
        
        
        
        //Prompting the user for the name of the file
        System.out.println("Please enter the name of the file : ");
        fileName = input.next();
        
        //Reading in the file's contents and inserting it into 2 linked lists
        try(Scanner fileInput = new Scanner(Paths.get(fileName))){
            while(fileInput.hasNext()){
                colOne[numPair]=fileInput.nextFloat();
                colTwo[numPair]=fileInput.nextFloat();
                numPair++;
            }
        }
        catch(IOException | NoSuchElementException | IllegalStateException e){
            e.printStackTrace();
        }
        
        for(int i=0;i<numPair;i++){
            System.out.printf("%f ",colOne[i]);
            System.out.printf("%f%n",colTwo[i]);
        }
        
        //Summing all the Xs and getting the X average
        for(int i=0;i<numPair;i++){
            sumX+=colOne[i];
        }
        xAvg=(sumX/numPair);
        
        //Summing all the Ys and getting the Y average
        for(int i=0;i<numPair;i++){
            sumY+=colTwo[i];
        }
        yAvg=(sumY/numPair);
        
        //Summing the product of the Xs and Ys
        for(int i=0;i<numPair;i++){
            sumProd+=((colOne[i])*(colTwo[i]));
        }
        
        //Summing the Xs squared
        for(int i=0;i<numPair;i++){
            sumXSq+=(colOne[i]*colOne[i]);
        }
        
        //Calculating the Slope and Y-intercept
        slope=(sumProd-(sumX*yAvg))/(sumXSq-(sumX*xAvg));
        yInt=(yAvg-(slope*xAvg));
        
        //Displaying the variables
        System.out.printf("sumX = %f%n",sumX);
        System.out.printf("sumXSq = %f%n",sumXSq);
        System.out.printf("sumProd = %f%n",sumProd);
        
        //Display Slope
        System.out.printf("Equation of least squares "
                + "line: y = %fx + %f%n", slope,yInt);
    }
    
}
