package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("You Hold\n"+game.getYourCards().toString());
        System.out.println("Your Score is:"+game.score(game.getYourCards())+"\n");
        System.out.println("House Holds\n"+game.getHouseCards().toString());
    }

  @Override
    public boolean hitMe() { 
        
       System.out.println("Another Card? (y/n)");   
       String Input=user.nextLine();       
       
       if("y".equals(Input)){
           return true;
       }
       
       else{
          return false; 
       }
    }

  @Override
    public void gameOver() {
        int Playerscore=game.score(game.getYourCards());
        int Housescore=game.score(game.getHouseCards());
        
        System.out.println("The House's score is: "+Housescore+"\n"+"Your Score is: "+Playerscore);
        
        if( (Playerscore > Housescore || Housescore > 21) && (Playerscore <= 21)){
            System.out.println("You Win");
        }
        
        else{
            System.out.println("House Wins");
        }
    }
}
    