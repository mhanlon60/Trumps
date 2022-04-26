import java.util.*;
import java.io.*;
import java.lang.*;

public class Leaderboard  {

  Scanner keyboard = new Scanner(System.in);

 

// top level design
  void processLeaderboard () throws IOException, NumberFormatException{

      String csv = "";
      String[] valueList = new String[2];
      String [][] aTest = new String [2][2];
      
      String csv1 = "";
      String[] valueList1 = new String[2];

    // identify file
    String inputFile = "leaderboard.txt";
    // java file reader, opens file named by inputFile
    Scanner fileReader = new Scanner(new File(inputFile));
    
     String inputFile1 = "opponent.txt";
    // java file reader, opens file named by inputFile
    Scanner fileReader1 = new Scanner(new File(inputFile1));

  // loop for every csv row, fetch from file and store
//  try{

 
    // fetch row from file
    csv = fileReader.nextLine();
  csv1 = fileReader1.nextLine();
    // split row into separate values
    valueList = csv.split(",");
     valueList1 = csv1.split(",");
    
   
        
    // store separated values into parallel arrays
    aTest[0][0] = valueList[0];
    aTest[0][1] = (valueList[1]);

    aTest[1][0] = valueList1[0];
    aTest[1][1] = (valueList1[1]);
  

  
//}
//catch(ArrayIndexOutOfBoundsException exception){
//}

      fileReader.close();
      fileReader1.close();

      for(int d = 0; d < aTest.length; d++){
        (aTest[d][1]).toString();      
        }

//   int gameswon = Integer.parseInt([0][1]) ;
  // int gameslost = Integer.parseInt(aTest[1][1]);    
  
//try{
  
 
          int n = aTest.length;
   boolean swap = true; 


        while(swap == true && n > 0){

          for(int i = 0; i < n-1; i++){

            if(Integer.parseInt(aTest[i][1]) < Integer.parseInt(aTest[i+1][1])){

                System.out.print("BUBBLE");
              String tempname = aTest[i][0];
              String tempnumber = aTest[i][1];
            
              

              aTest[i][1] = aTest[i+1][1];
              aTest[i][0] = aTest[i+1][0];

              aTest[i+1][1] = tempnumber;
              aTest[i+1][0] = tempname;
           
              swap = true;

            }
            else {
              swap = false;
            }

           

          }
          n = n-1;

   }
//}
//catch(NumberFormatException e){

 

             // String tempname = aTest[0][0];
            //  String tempnumber = aTest[0][1];
            
              

          //   aTest[0][1] = aTest[1][1];
            //  aTest[0][0] = aTest[1][0];

            //  aTest[1][1] = tempnumber;
            //  aTest[1][0] = tempname;
 // }
        
        
  
      
 


//catch(NumberFormatException exception){

//}

 System.out.println("src.Leaderboard");
 System.out.println("Player Name         Games Won");
      
      for(int i = 0; i < 2; i++){
    System.out.println(aTest[i][0] + " :             " +  aTest[i][1]);
     
      
 }

 playagain();


      


}


    
     
              






public int playagain(){
   
   
     int  startingcards = 0;
     startingcards--;


try{
 
 
     Trumps AHProject = new Trumps();
    AHProject.processTrumps();

 }

catch(IOException exception){

}
 

  return startingcards;
  }
}