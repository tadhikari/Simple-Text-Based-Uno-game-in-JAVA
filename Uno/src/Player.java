import java.util.ArrayList;
import java.util.Scanner;


public class Player {

	
	
	private ArrayList<Card> playercards; 
	private String name; //player name
	
	public Player(String name) {
		/*
		 * creates a array list that will store player cards
		 * assigns name to the player
		 */
		
		//player object are created in uno class
		
		playercards = new ArrayList<Card>();
		this.name = name;
		
	}
	
	public int numberOfCards() {
		/*
		 * returns number of cards player has in hand
		 */
		return playercards.size();
	}
	
	public ArrayList<Card> PlayerCards(){
		/*
		 * returns all the cards player has in hand as an ArrayList
		 * This is used mainly to check if player has any valid cards to play.(Check the Uno class)
		 */
		
		return playercards;
	}
	
	
	public void pickCards(Card c) {
		/*
		 * 
		 */
		playercards.add(c);
		
	}
	
	public Card throwCard(int c) {
		/*
		 * player throws a card from hand which is at position 'c'. c is a integer value and is passed as an argument.
		 */
		
		
		return playercards.remove(c);
	}
	
	public void sayUno() {
		/*
		 * player says uno if they only have 1 card in the hand.
		 */
		Scanner s = new Scanner(System.in);
		
		if (playercards.size()==1){
			
			System.out.println("Uno");
			System.out.println("Press Enter...");
			s.nextLine();
		}
	}
	
	
	public void showCards() {
		/*
		 * this is graphical representation of a card
		 * just to make cards look more look like cards
		 * used in showboard() method in Uno class
		 */
		
		String[] card = {" ----- ","|     |","|     |"," ----- "};
		String c = "";
		
		
		for(int i=0;i<card.length;i++) {
				
			for(int j=0;j<playercards.size();j++) {
					
				if(!playercards.get(j).isSpecial()) {
					if(i==1) {
						
						c = c +"| "+playercards.get(j).getColor()+" |"+" ";
						
					}
					
					else if(i==2) {
						
						c = c + "|  "+playercards.get(j).getValue()+"  |"+" ";
					}
					
					else {
						c = c + card[i]+" "; 
					}
					
					}
				
				else if(playercards.get(j).isSpecial()) {
					
					if(i==1) {
						
						c = c +"| "+"+"+playercards.get(j).getValue()+"  |"+" ";
						
					}
					else {
						c = c + card[i]+" ";
					}
					
				}
				
					}
				
				c +="\n";
				
			}
				
		
		
		
		System.out.print(c);
	}
	
	public void hideCards() {
		
		/*
		 * to hide player cards
		 * used in showboard() method in Uno class
		 */
		
		String[] card = {" ----- ","|     |","|     |"," ----- "};
		String c = "";
		
		
		for(int i=0;i<card.length;i++) {
				
			for(int j=0;j<playercards.size();j++) {
		
				c = c + card[i]+" ";
		
			}
		c+="\n";
		}
		
		System.out.print(c);
	}
	
	public boolean hasWon() {
		/*
		 * checks if player has won or not
		 */
		if(playercards.size()==0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		/*
		 * text representation of player
		 */
		return this.name;
	}
	
	
	
	
}
