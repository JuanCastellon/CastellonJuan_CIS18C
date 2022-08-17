package dequedemo;

public class DequeDemo {

    public static void main(String[] args) {
        Deque<String> words = new Deque<String>();
        
        // interactive testing
        do {
            System.out.println("\nDeque Test Menu");
            System.out.println("1. Enqueue_front a word");
            System.out.println("2. Enqueue_back a word");
            System.out.println("3. Push_front a word");
            System.out.println("4. Push_back a word");
            System.out.println("5. Dequeue_front a word");
            System.out.println("6. Dequeue_back a word");
            System.out.println("7. Pop_front a word");
            System.out.println("8. Pop_back a word");
            System.out.println("9. Display the queue");
            System.out.println("0. Display front and back");
            System.out.println("Q. Quit");
            System.out.print("Choose an option 1 to 9, 0, Q: ");
            String choice = new java.util.Scanner(System.in).next();
            
            if (choice.equalsIgnoreCase("q")) break; 
            if (choice.equals("1"))
            {
                System.out.print("Enter a word: ");
                String wd = new java.util.Scanner(System.in).next();
                
                words.enqueue_front(wd);
                
                System.out.printf("The word '%s' enqueued to front %n", wd);
                System.out.printf("Deque has %d elements%n",words.size());
            }
            
            if (choice.equals("2"))
            {
                System.out.print("Enter a word: ");
                String wd = new java.util.Scanner(System.in).next();
                
                words.enqueue_back(wd);
                
                System.out.printf("The word '%s' enqueued to back %n", wd);
                System.out.printf("Deque has %d elements%n",words.size());
            }
            
            if (choice.equals("3"))
            {
                System.out.print("Enter a word: ");
                String wd = new java.util.Scanner(System.in).next();
                
                words.push_front(wd);
                
                System.out.printf("The word '%s' pushed to front %n", wd);
                System.out.printf("Deque has %d elements%n",words.size());
            }
            
            if (choice.equals("4"))
            {
                System.out.print("Enter a word: ");
                String wd = new java.util.Scanner(System.in).next();
                
                words.push_front(wd);
                
                System.out.printf("The word '%s' pushed to back %n", wd);
                System.out.printf("Deque has %d elements%n",words.size());
            }
        
            if (choice.equals("5"))
            {
                String wd = words.dequeue_front();
                
                System.out.printf("The word '%s' dequeued from the front%n", wd);
                System.out.printf("Deque has %d elements%n",words.size());
            }
            
            if (choice.equals("6"))
            {
                String wd = words.dequeue_back();
                
                System.out.printf("The word '%s' dequeued from the back%n", wd);
                System.out.printf("Deque has %d elements%n",words.size());
            }
            
            if (choice.equals("7"))
            {
                String wd = words.pop_front();
                
                System.out.printf("The word '%s' popped from the front%n", wd);
                System.out.printf("Deque has %d elements%n",words.size());
            }
            
            if (choice.equals("8"))
            {
                String wd = words.pop_back();
                
                System.out.printf("The word '%s' popped from the back%n", wd);
                System.out.printf("Deque has %d elements%n",words.size());
            }
            
            
            if (choice.equals("9")) 
            {
                System.out.print("The deque of words is: ");
                words.display();
                System.out.println();
            }
            
            if (choice.equals("0"))
            {
                System.out.printf("front='%s', back='%s'%n",words.front(),words.back());
            }
        } while(true);
    }
    
}
