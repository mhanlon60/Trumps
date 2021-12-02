package src;

import java.util.*;

public class Card{
private Suit suit;
private Value value;
 private ArrayList<Card> cards; // sus

  public Card(Suit suit, Value value){

 this.cards = new ArrayList<Card>(); //sus
    this.value = value;
    this.suit = suit;


  }

  public String toString(){
    return this.value.toString() + " of " + this.suit.toString();
  }

  public int toInt(){
     return Integer.parseInt(this.value.toString());
  }

  public Value getValue(){
    return this.value;
  }

  public Suit getSuit() 
   { 
      return this.suit; 
   }

   //  public int cardsValue(src.Deck playerDeck1, src.Deck playerDeck2){
  //int cardValue =0;
 

  //for(int i = 0; i < playerDeck1.deckSize(); i++){
   // switch(playerDeck1.getCard(i).getValue()){
   // case Two: cardValue = 2; break;
  // case Three: cardValue = 3; break;
   // case Four: cardValue = 4; break;
   // case Five: cardValue = 5; break;
  //  case Six: cardValue = 6; break;
   // case Seven: cardValue = 7; break;
  //  case Eight: cardValue = 8; break;
   // case Nine: cardValue = 9; break;
   // case Ten: cardValue = 10; break;
  //  case Jack: cardValue = 11; break;
   // case Queen: cardValue = 12; break;
  //  case King: cardValue = 13; break;
  //  case Ace: cardValue = 14; break;
 // }

  
    

      
 // }

   // for(int i = 0; i < playerDeck2.deckSize(); i++){
  //  switch(playerDeck2.getCard(i).getValue()){
   // case Two: cardValue = 2; break;
  // case Three: cardValue = 3; break;
  //  case Four: cardValue = 4; break;
  //  case Five: cardValue = 5; break;
 //   case Six: cardValue = 6; break;
  //  case Seven: cardValue = 7; break;
 //   case Eight: cardValue = 8; break;
 //   case Nine: cardValue = 9; break;
 //   case Ten: cardValue = 10; break;
 //   case Jack: cardValue = 11; break;
 //   case Queen: cardValue = 12; break;
  //  case King: cardValue = 13; break;
  //  case Ace: cardValue = 14; break;
 // }

  
    

      
 // }
  //   return cardValue;

//}


   
}

