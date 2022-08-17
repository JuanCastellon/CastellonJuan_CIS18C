package castellon_juan_in_balance;

import java.util.Scanner;

public class Castellon_Juan_In_Balance {

   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Declare variables
        Stack<String> baseStk = new Stack<>();
        Stack<String> leftBra = new Stack<>();
        Stack<String> rigtBra = new Stack<>();
        String string;                              //For user inputted string
        char x;                                     //Character for processing
        String comp1;
        int counter = 0;                            //For terminating while loop
        boolean run = true;                         //Test for termination
        
        System.out.print("Please enter your string : ");
        string = input.nextLine();
        
        //Starting the for loop at the end of the string and
        //decrementing the counter to put things in the stack in order
        for(int i=string.length()-1;i>=0;i--){
            x = string.charAt(i);
            if(x=='('||x==')'){
                comp1=Character.toString(x);
                baseStk.push(comp1);
            }
            if(x=='{'||x=='}'){
                comp1=Character.toString(x);
                baseStk.push(comp1);
            }
            if(x=='['||x==']'){
                comp1=Character.toString(x);
                baseStk.push(comp1);
            }
        }
        
        //Displaying everything
        baseStk.display();
        
        //Balancing Process ->
        
        //If the stack is 
        if(baseStk.peek()==null){
            System.out.println("There are no parentheses/brackets to balance.");
            System.exit(0);
        }
        
        
        //This is the main algorithm for balancing.
        //The process goes like this :
        //
        // (1)
        //
        //We start with the first element of the base stack. If it is a left
        //bracket/parenthesis, we will pop that element off the base stack and
        //push it onto the left bracket/parenthesis stack. 
        //
        // (2)
        //
        //On the second iteration of the while loop, we will do the same process
        //if we encounter a left bracket/parenthesis at the top of the base
        //stack when we peek at it. If we encounter a right variant, however,
        //we will check the left bracket/parenthesis stack to see if there is
        //a corresponding left variant to balance it out. If there is, pop the
        //first element of the left stack off.
        //
        // (3)
        //
        //If the left bracket/parenthesis stack does not have a corresponding 
        //variant to complete the balance with your right bracket/parenthesis,
        //the right variant will be deposited into the right bracket/parenthesis
        //stack indicating that it has no complementary bracket/parenthesis.
        //If both the left and right bracket/parenthesis stacks have elements
        //left over, this means that they did not have complementary variants
        //and thus were never popped off their respective stacks, leaving you 
        //with the conclusion that the string is not balanced.
        
           while(baseStk.peek()!=null){
            //Assigning a value specified for comparions specifically
            //(({{{}}()}))
            
            //If the first element of the stack is a left bracket, push onto
            //the leftBracket stack
            if(baseStk.peek().equals("(")||
               baseStk.peek().equals("[")||
               baseStk.peek().equals("{")){
                leftBra.push(baseStk.peek());
            }
            
            //If statements for dealing with right parentheses/brackets
            
            if(baseStk.peek().equals(")")){
                if(leftBra.peek()==null){
                    System.out.println("The inputted string is not balanced.");
                    System.exit(0);
                }
                if(leftBra.peek().equals("(")){
                    leftBra.pop();
                }
                else{
                    rigtBra.push(baseStk.peek());
                }
            }
            
            if(baseStk.peek().equals("]")){
                if(leftBra.peek()==null){
                    System.out.println("The inputted string is not balanced.");
                    System.exit(0);
                }
                if(leftBra.peek().equals("[")){
                    leftBra.pop();
                }
                else{
                    rigtBra.push(baseStk.peek());
                }
            }
            
            if(baseStk.peek().equals("}")){
                if(leftBra.peek()==null){
                    System.out.println("The inputted string is not balanced.");
                    System.exit(0);
                }
                if(leftBra.peek().equals("{")){
                    leftBra.pop();
                }
                else{
                    rigtBra.push(baseStk.peek());
                }
            }
            
            baseStk.pop();
        }

        
        if(leftBra.peek()==null && rigtBra.peek()==null){
            System.out.println("The inputted string is balanced!");
        }
        else{
            System.out.println("The inputted string is not balanced.");
        }
        
    }

    
}
