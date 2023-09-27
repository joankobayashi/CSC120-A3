//importing
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/** 
 * Class of Conversation
*/
class Conversation {

  /** 
  * Takes in inputs from the user (including the number of rounds) and replies according to the inputs
  * @param inputs (number of rounds and strings) from user
  * @return response to the inputs according to the inputs, either changing parts of the inputs or random replies
  */
  
  public static void main(String[] arguments) {
    Scanner input = new Scanner(System.in); //takes in
    System.out.println("How many rounds?"); //scanning the num of rounds 
    int rounds = input.nextInt(); //assigns it to rounds
    input.nextLine(); //clears buffer
    System.out.println(); //prints new line


    //making a string array for random
    Random rand = new Random();
    String[] random_array = new String[5];
    random_array[0] = "Nice!";
    random_array[1] = "Huh...";
    random_array[2] = "Are you serious?? No way!";
    random_array[3] = "Interesting...";
    random_array[4] = "I don't know what you mean.";


    //making transcript base
    ArrayList<String> tran_array = new ArrayList<String>();
    

    //first question which scans 
    Scanner sc = new Scanner(System.in);
    System.out.println("Hi there!  What's on your mind?");
    tran_array.add("Hi there!  What's on your mind?"); //adds to transcript


    for (int i = 0; i < rounds; i++){
      String answer = sc.nextLine();  //scanning the response
      tran_array.add(answer);
      String response = "";
      String[] splited = answer.split(" ");  //splitting with spaces
      
      //makes array for the replaced words
      ArrayList<String> full_res = new ArrayList<String>();
      boolean replaced = false; //initiates as false
      
      //finding out the num of words and ask that many times
      int num_words = splited.length;
    
      //for number of words, search
      for (int w = 0; w < num_words; w++){ 
        
        //replacing ? with .
        if (splited[w].contains("?") && (w == num_words-1)){
          splited[w] = splited[w].substring(0, splited[w].length()-1)+".";
        }

        //replacing ! with .
        if (splited[w].contains("!") && (w == num_words-1)){
          splited[w] = splited[w].substring(0, splited[w].length()-1)+".";
        }

        //I -> You when start of sentence
        if (splited[w].equals("I") && (w == 0)) {
          splited[w] = splited[w].replace("I", "You");
          
          //adds renewed word to the arraylist
          full_res.add(splited[w]);
          replaced = true;
        }
        
        //I -> you when not first
        else if (splited[w].equals("I")) {
          splited[w] = splited[w].replace("I", "you");
          
          full_res.add(splited[w]);
          replaced = true;
        }
        
        //me -> you
        else if (splited[w].equals("me")){
          splited[w] = splited[w].replace("me", "you");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //am -> are
        else if (splited[w].equals("am")){
          splited[w] = splited[w].replace("am", "are");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //are -> am
        else if (splited[w].equals("are")){
          splited[w] = splited[w].replace("are", "am");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //you -> I
        else if (splited[w].equals("you")){
          splited[w] = splited[w].replace("you", "I");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //you. -> me.
        else if (splited[w].equals("you.")){
          splited[w] = splited[w].replace("you.", "me.");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //You -> I
        else if (splited[w].equals("You")){
          splited[w] = splited[w].replace("You", "I");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //my -> your
        else if (splited[w].equals("my")){
          splited[w] = splited[w].replace("my", "your");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //your -> my
        else if (splited[w].equals("your")){
          splited[w] = splited[w].replace("your", "my");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //I'm -> You're
        else if (splited[w].equals("I'm")){
          splited[w] = splited[w].replace("I'm", "You're");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //You're -> I'm  
        else if (splited[w].equals("You're")){
          splited[w] = splited[w].replace("You're", "I'm");
          
          full_res.add(splited[w]);
          replaced = true;
        }

        //else, repeat the word
        else {
          full_res.add(splited[w]);
        }
        
      }

      // dealing with the ending (. or ?)
      if (replaced == true) {
        String sentence = new String();
        
        //ArrayList to sentence
        for (String str : full_res) { 
          sentence += (str + " ");
        }

        //replacing the last space with ?
        if (sentence.contains(".")){
          sentence = sentence.substring(0, sentence.length()-2)+"?";
        }

        //else, prints ? instead of space
        else{
          sentence = sentence.substring(0, sentence.length()-1)+"?";
        }
        
        
        System.out.print(sentence+"\n"); //prints sentence
        tran_array.add(sentence); //records

        }


      //else calls random number
      else {
        int rand_number = rand.nextInt(5); //sets random
        response = random_array[rand_number]; //picks random number
        System.out.println(response);
        tran_array.add(response); //records
      }
    
    }

    //adds see ya!
    System.out.println("See ya!");
    tran_array.add("See ya!");


    //transcript
    String tran_sent = new String();
  
      for (String str : tran_array) //ArrayList to sentence
        tran_sent += (str + " " + "\n"); //inserts new line in between

    System.out.println("\n"); //new line
    System.out.println("TRANSCRIPT:");
    System.out.println(tran_sent); //prints the recorded 
  }
}
