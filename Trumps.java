

import java.util.*;
import java.io.*;
import java.lang.*;

public class Trumps  {

  Scanner keyboard = new Scanner(System.in);

    int handswon = 0;
  int handslost = 0;
  int gameswon = 0;
  int gameslost = 0;

 

// top level design
  void processTrumps() throws IOException {

     System.out.println("\nWelcome to Trumps");

     

      System.out.println("\nEnter player name (7 characters)");
    String playername = keyboard.nextLine();

    //while (playername.length() != 7){
     // System.out.println("\n Error! Enter player name (7 characters)");
      // playername = keyboard.nextLine();
   // }

      

   //Create Playing Deck
   Deck playingDeck = new Deck();
   playingDeck.createFulldeck();
   playingDeck.shuffle();
    
  Deck playerDeck1 = new Deck();
  Deck playerDeck2 = new Deck();
  Deck player1Wins = new Deck();
  Deck player2Wins = new Deck();

  
  int intvalue1 =0 ;
   int intvalue2 =0 ;

   //int handswon = 0;
  // int gameswon = 0;
  // int handslost = 0;
  // int gameslost = 0;
   int startingcards = 7;
   int DealtCards = 0;
   int handsplayed = 0;
   int u = 0;



  Card chosenCard;

   boolean endRound = false;
   boolean trump = false;
   boolean gameover = false;
  
   boolean Gameplaying = true;
   boolean handplaying = true;

   String trumpSuit = "";
 


     
   



  

   

         trumpSuit = (gettrumpSuit());
        //Start Dealing
    //Player gets two cards
while(DealtCards < startingcards){
    playerDeck1.Draw(playingDeck);
   

    //Dealer cards
    playerDeck2.Draw(playingDeck);
    DealtCards++;
}
   
 
   
   
      //Game Loop
    while(Gameplaying = true){
      while(u < playerDeck1.deckSize()){
    

     

      System.out.println("\nYour hand:");
        System.out.println(playerDeck1.toString());

       // System.out.println("\nOpponent hand:");
       // System.out.println(playerDeck2.toString());

      

         //Player Move
    System.out.println("\nWhat card do you want to play");
    int cardchoice = keyboard.nextInt();

    


    while(cardchoice > playerDeck1.deckSize() || cardchoice < 1){
      
      System.out.println("\nError, Input card number again");
       cardchoice = keyboard.nextInt();
      
      
    }
   

    
        chosenCard = playerDeck1.getCard(cardchoice-1);
         Card opponentCard = null;
        playerDeck1.removeCard(cardchoice-1);
    
   System.out.println(chosenCard) ;


validate( playerDeck1,  playerDeck2 ,  chosenCard,  opponentCard,  trumpSuit, cardchoice, gameover, Gameplaying, playername, startingcards);




    }
    }
       
      // if(Gameplaying == false){


   // System.out.println("Press 'L' for leaderboard");
    // System.out.println("Press 'P' TO play");

   //  String leaderboardchoice = "";
// leaderboardchoice = keyboard.nextLine();

// if(leaderboardchoice == "L"){
  //Leaderboard Leaderboard = new Leaderboard();
   //     Leaderboard.processLeaderboard();

// }
// if (leaderboardchoice == "P"){
//   System.out.println("Game over");

// }

      // }

handsplayed++;



    



  }
  


  
  
  
  public void validate(Deck playerDeck1, Deck playerDeck2 , Card chosenCard, Card opponentCard, String trumpSuit,int cardchoice, boolean gameover, boolean Gameplaying,String playername, int startingcards) throws IOException{
     boolean Suitvalidated = false;
     boolean foundsameSuit = false;
  boolean foundtrumpSuit = false;
  boolean foundnoSuit = false;


  
     int s =0;
   int t = 0;
   int z = 0;


    while(Suitvalidated == false){


        //plays same suit
    //works
 
        while(s < playerDeck2.deckSize()){
       if(playerDeck2.getCard(s).getSuit() == chosenCard.getSuit()){
     opponentCard = playerDeck2.getCard(s);
     playerDeck2.removeCard(s);
     System.out.println("\nOpponent plays " +  opponentCard);
     
   
  
  
     foundsameSuit = true;

     if(foundsameSuit == true){
        if(cardsValue1(chosenCard) > cardsValue2(playerDeck2,  opponentCard)){
         
       System.out.println("\nYou win");
       handswon += 1;

     }
     else if(cardsValue1(chosenCard) < cardsValue2(playerDeck2,  opponentCard)){
         
       System.out.println("\nYou lose ");
   handslost += 1;
     }
     }
    
     Suitvalidated = true;
     
    break;
   }
   s++;
        }
           
 
       //plays trumps
      if(foundsameSuit == false){
        while(t < playerDeck2.deckSize()){
          if((((playerDeck2.getCard(t).getSuit())).toString().equals(trumpSuit))){
      opponentCard = playerDeck2.getCard(t);
      playerDeck2.removeCard(t);
    System.out.println("Opponent plays " +  opponentCard);
    
    foundtrumpSuit = true;

    if(cardsValue1(chosenCard) > cardsValue2(playerDeck2,  opponentCard)){
         
       System.out.println("You win");
   handswon += 1;
     }
     else if(cardsValue1(chosenCard) < cardsValue2(playerDeck2,  opponentCard)){
         
       System.out.println("You lose ");
         handslost += 1;
     }


         if(foundtrumpSuit == true && foundsameSuit == false){
         
       System.out.println("You lose");
           handslost += 1;
     }

     
   
     
     
     
     Suitvalidated = true;
     
     break;
          }
          t++;
        }
           
      }

       if(foundsameSuit == false && foundtrumpSuit == false){
      int minValuePosition = 0;

      opponentCard = playerDeck2.getCard(0);
      playerDeck2.removeCard(0);
      
    System.out.println("Opponent plays " +  opponentCard);
   
    foundnoSuit = true;

    if(foundnoSuit == true){
      System.out.println("You win");
     handswon += 1;
    }
     
     Suitvalidated = true;
     }
     
//if(playerDeck1.deckSize() == 0){

  // System.out.println("Out of cards");
  // gameover = true;
  
 
//}
 
  
    


    }
    
  if(playerDeck1.deckSize() == 0){

  if(handslost < handswon){
     System.out.println("You win the game");
     gameswon++;
     endgame(playerDeck1, cardchoice, gameover, handswon, gameswon, playername);
      Gameplaying = false;
      
    
   }
   else if(handslost > handswon){
      System.out.println("You lose the game");
     gameslost++;
    endgame(playerDeck1, cardchoice, gameover, handswon, gameswon, playername);
      Gameplaying = false;
    
   }


   
}

  if(Gameplaying == false){
    startingcards--;
  }

   
   
   

  }

  public void endgame(Deck playerDeck1, int cardchoice, boolean gameover, int handswon, int gameswon, String playername) throws IOException{

     if(playerDeck1.deckSize() == 0){
 if(cardchoice > 0){
   String decision = "";
   System.out.println("Out of cards");
   gameover = true;

    String resultsData = "";
    String resultsData1 = "";

 
// Java object to output a file
    PrintWriter fileWriter;
      PrintWriter fileWriter1;


    // open file for writing
    fileWriter = new PrintWriter("leaderboard.txt");

    // write output string to file
    fileWriter.println(resultsData = resultsData + playername + "," + gameswon + "\n");


    // close the file
    fileWriter.close();

     // open file for writing
    fileWriter1 = new PrintWriter("opponent.txt");

    // write output string to file
    fileWriter1.println(resultsData1 = resultsData1 + "Player2" + "," + gameslost + "\n");


    // close the file
    fileWriter1.close();



   Leaderboard Leaderboard = new Leaderboard();
        Leaderboard.processLeaderboard();

        
 
 }
}
  }

  public String gettrumpSuit(){
        int r = (int) (Math.random()*4);
        String trumpSuit = new String [] {"Clubs", "Diamonds", "Spades", "Hearts"}[r];
       System.out.println("Trumps is " + trumpSuit);
        return trumpSuit;
    }

   public int cardsValue1(Card chosenCard){
     
      int intvalue1 = 0;
     

     if(chosenCard.getValue().toString() == ("Two")){
       intvalue1 = 2;
  
     }
     else   if(chosenCard.getValue().toString() == ("Three")){
       intvalue1 = 3;
   
     }
     else   if(chosenCard.getValue().toString() == ("Four")){
       intvalue1 = 4;
      
     }
     else   if(chosenCard.getValue().toString() == ("Five")){
       intvalue1 = 5;
       
     }
     else   if(chosenCard.getValue().toString() == ("Six")){
       intvalue1 = 6;
       
     }
     else   if(chosenCard.getValue().toString() == ("Seven")){
       intvalue1 = 7;
       
     }
     else   if(chosenCard.getValue().toString() == ("Eight")){
       intvalue1 = 8;
      
     }
     else   if(chosenCard.getValue().toString() == ("Nine")){
       intvalue1 = 9;
    
     }
     else   if(chosenCard.getValue().toString() == ("Ten")){
       intvalue1 = 10;
    
     }
     else   if(chosenCard.getValue().toString() == ("Jack")){
       intvalue1 = 11;
    
     }
     else   if(chosenCard.getValue().toString() == ("Queen")){
       intvalue1 = 12;

     }
     else   if(chosenCard.getValue().toString() == ("King")){
       intvalue1 = 13;
      
     }
     else   if(chosenCard.getValue().toString() == ("Ace")){
       intvalue1 = 14;
   
     }

    
     
  
     
      
       return intvalue1;
    }
    

    public int cardsValue2(Deck playerDeck2, Card opponentCard){
     
      int intvalue2 = 0;
    

     if(opponentCard.getValue().toString() == ("Two")){
       intvalue2 = 2;
      
     }
     else   if(opponentCard.getValue().toString() == ("Three")){
       intvalue2 = 3;
   
     }
     else   if(opponentCard.getValue().toString() == ("Four")){
       intvalue2 = 4;
   
     }
     else   if(opponentCard.getValue().toString() == ("Five")){
       intvalue2 = 5;
   
     }
     else   if(opponentCard.getValue().toString() == ("Six")){
       intvalue2 = 6;

     }
     else   if(opponentCard.getValue().toString() == ("Seven")){
       intvalue2 = 7;
  
     }
     else   if(opponentCard.getValue().toString() == ("Eight")){
       intvalue2 = 8;
    
     }
     else   if(opponentCard.getValue().toString() == ("Nine")){
       intvalue2 = 9;
     
     }
     else   if(opponentCard.getValue().toString() == ("Ten")){
       intvalue2 = 10;
     
     }
     else   if(opponentCard.getValue().toString() == ("Jack")){
       intvalue2 = 11;
  
     }
     else   if(opponentCard.getValue().toString() == ("Queen")){
       intvalue2 = 12;
    
     }
     else   if(opponentCard.getValue().toString() == ("King")){
       intvalue2 = 13;
    
     }
     else   if(opponentCard.getValue().toString() == ("Ace")){
       intvalue2 = 14;
     
     }

    
     
  
     
      
       return intvalue2;
    }

    public String playername(String playername){
      return playername;
    }

   // public int minValue(Deck playerDeck2){
   //   int minValue = 0;
   //   int minValuePosition =0;
    
    
  //  minValue = playerDeck2.cardsValue();

   // for(int i = 0; i < 3; i++){
    //  if((playerDeck2.cardsValue()) <minValue){
    //    minValue = playerDeck2.cardsValue();
     //   minValuePosition = i;
    //  }

   // }

 //   return minValuePosition;
  //  }

  
}

//if(playerDeck2.getCard(s-1).getSuit() != chosenCard.getSuit()){
      
    
  // if((((playerDeck2.getCard(s-1).getSuit())).toString().equals(trumpSuit))){
 ///     opponentCard = playerDeck2.getCard(t-1);
 //    System.out.println("Opponent plays " +  opponentCard);
 //    foundtrumpSuit = true;
  //   Suitvalidated = true;
    
   
  // }
  
 //  }