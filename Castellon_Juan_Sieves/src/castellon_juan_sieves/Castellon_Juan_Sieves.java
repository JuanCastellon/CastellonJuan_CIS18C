/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castellon_juan_sieves;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Juan
 */
public class Castellon_Juan_Sieves {
    
    public static void main(String[] args) {
        //Declaring Scanner
        Scanner input = new Scanner(System.in);
        
        //Declaring variables
        Queue<Integer> queueOfIntegers = new Queue<>();
        Queue<Integer> queueOfPrimes = new Queue<>();
        Queue<Integer> queueOfNumbers = new Queue<>();
        int n; //Integer you end at
        
        //Prompting user for the input
        System.out.print("Please enter an integer : ");
        n = input.nextInt();
        
        //Loading up the queue with all the integers
        for(int i=2;i<n;i++){
            queueOfIntegers.push_back(i);
        }
        
        do{
            if(queueOfIntegers.size() == 0){
                break;
            }
            else{
                int p = queueOfIntegers.front();
                queueOfPrimes.push_back(p);
                System.out.println("Dequeuing a prime number   : " 
                                + queueOfIntegers.front());
                System.out.print("Content of: queueOfPrimes  : ");
                queueOfPrimes.display();
                System.out.println();

                queueOfIntegers.pop_front();

                while(queueOfIntegers.size() != 0){
                    if(queueOfIntegers.front()%p != 0){
                        queueOfNumbers.push_back(queueOfIntegers.front());
                        queueOfIntegers.pop_front();
                    }
                    else{
                        queueOfIntegers.pop_front();
                    }
                }

                while(queueOfNumbers.size() != 0){
                    queueOfIntegers.push_back(queueOfNumbers.front());
                    queueOfNumbers.pop_front();
                }
                
                System.out.print("Content of: queueOfIntegers: ");
                queueOfIntegers.display();
                System.out.println();
                System.out.println();
            }
        }while(queueOfPrimes.front() < Math.sqrt(n));
        
        System.out.print("queueOfPrimes: ");
        queueOfPrimes.display();
        System.out.println();
        }
}
    
