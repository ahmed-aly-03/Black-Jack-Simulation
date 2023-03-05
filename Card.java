package coe318.lab5;

public class Card implements Comparable {
  

  private static final int CLUB = 0;
  private static final int DIAMOND = 1;
  private static final int HEART = 2;
  private static final int SPADE = 3;
  private int suit,rank;
  private boolean faceUp;
  
  
  public Card(int rank, int suit, boolean faceUp) {
    this.rank=rank;
    this.suit=suit;
    this.faceUp=faceUp;
  }

  
  public boolean isFaceUp() {
    return faceUp; 
  }

 
  public void setFaceUp(boolean faceUp) {
      this.faceUp=faceUp;
  }

 
  public int getRank() {
    return this.rank; 
  }


  public int getSuit() {
    return this.suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    
    if (c.getSuit()==this.getSuit() && c.getRank()==this.getRank()){
        return true;
    }
    else{
        return false; 
    }
          
  }

  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
      
    if(this.getRank()==c.getRank()){
        
       if(this.getSuit()>c.getSuit()){
           return 1;
       }
       
       else if(this.getSuit()<c.getSuit()){
           return -1;
       }
       
       else{
           return 0;
       }
    }
    else if (this.getRank()>c.getRank()){
        return 1;              
    }
    
    else{
        return -1;
    }
        
    }
    
    
  public String getRankString() {
     
    int x=this.getRank();
    
    switch(x){
        
        case 11:
            return "Jack";
           
        case 12:
            return "Queen";
       
        case 13:
            return "King";
        
        case 14:
            return "Ace";
            
        default:
            
            return ""+this.getRank();
    }
      
              
  }
   
  
  public String getSuitString() {
      
      int x=this.getSuit();
      
      switch(x){
          
        case 0:
            return "Clubs";
            
        case 1:
            return "Diamonds";
              
        case 2:
                return "Hearts";
        
        default:
            return "Spades";  
      }
  
  }

  
  @Override
  public String toString() {
    
     if(this.isFaceUp()==false){
         return "?";
     }
     
     else{
         return""+this.getRankString()+" of "+this.getSuitString();
     }
  
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
