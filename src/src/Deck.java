import java.util.*;

public class Deck {
  private ArrayList<Card> cards;

// Construct
  public Deck(){
    this.cards = new ArrayList<Card>();
  }

//Generate cards
  public void createFulldeck(){
    for(Suit cardSuit : Suit.values()){

      for(Value cardValue : Value.values()){

        //Add new card
        this.cards.add(new Card(cardSuit, cardValue));

      }

    }
  }

  public void shuffle(){
    ArrayList<Card> tempDeck = new ArrayList<Card>();
    Random random = new Random();
    int randomCardIndex = 0;
    int originalSize = this.cards.size();

    for(int i =0; i < originalSize; i++){
      randomCardIndex = random.nextInt((this.cards.size()-1) + 1);
      tempDeck.add(this.cards.get(randomCardIndex));
      this.cards.remove(randomCardIndex);

    }

    this.cards = tempDeck;
  }

  public String toString(){
   String cardListOutput = "";
     for(Card aCard : this.cards){
       cardListOutput += "\n " + aCard.toString();
     }
     return cardListOutput;
   }

  public void removeCard(int i){
 this.cards.remove(i);
  }

    public Card getCard(int i){
  return this.cards.get(i);
  }

  public void addCard(Card addCard){
    this.cards.add(addCard);

  }

  

  

//Draws from the deck
  public void Draw(Deck comingfrom ){
    this.cards.add(comingfrom.getCard(0));
    comingfrom.removeCard(0);
  }

  public int deckSize(){
    return this.cards.size();
  }

  public void movealltoDeck(Deck moveto){
  int thisdeckSize = this.cards.size();

  for(int i = 0; i < thisdeckSize; i++){
    moveto.addCard(this.getCard(i));
  }

  
  for(int i = 0; i < thisdeckSize; i++){
   this.removeCard(0);
  }
  }

// Return value of cards in deck
 //public int cardsValue(){
 // int cardValue =0;
 

  //for(src.Card aCards : this.cards){
   // switch(aCards.getValue()){
    //case Two: cardValue = 2; break;
  //  case Three: cardValue = 3; break;
  //  case Four: cardValue = 4; break;
   // case Five: cardValue = 5; break;
  //  case Six: cardValue = 6; break;
  //  case Seven: cardValue = 7; break;
   // case Eight: cardValue = 8; break;
  //  case Nine: cardValue = 9; break;
  //  case Ten: cardValue = 10; break;
  //  case Jack: cardValue = 11; break;
  //  case Queen: cardValue = 12; break;
  //  case King: cardValue = 13; break;
  //  case Ace: cardValue = 14; break;
 //   }

  
    

      
   // }
   //   return cardValue;

 // }

  
  


  }


 