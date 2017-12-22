import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;
	
		public Deck() {
			
			/*
			 * The constructor creates a new deck
			 * There are 4 colors: red, blue, green, yellow
			 * Each suit has two of the same card except 0 (it only appears once in each suit).
			 * For example: green suit has two 1s but only 1 zero
			 */
			
			
			deck = new ArrayList<Card>();
			String[] colors = {"red","blu","grn","ylw"};
			int[] numbers = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,0}; //regular cards
			int[] specialnumbers = {2,2,4,4}; //special cards +2, +2, +4 and +4
			
			
			for(String c:colors) { //adding regular cards to the deck
				for(int i:numbers) {
					deck.add(new Card(i,c)); //adding new cards to our deck
				}
			}
			
			
			for(int i:specialnumbers) { //adding special cards to the deck
				deck.add(new Card(i));
			}
			
			
			
		}
		
		
		public Deck(ArrayList<Card> c) { //overloaded constructor
			/*
			 * incase the current deck becomes empty, all the thrown cards are collected and it becomes the new deck;
			 * 
			 */
			deck = c;
		}
	
			
		public boolean isEmpty() { //is deck empty?
			/*
			 * Checks the size of the deck. If it is greater than 0 then returns false. If not, returns true 
			 */
			
			if(deck.size()>0) {
				return false;
			}
			return true;
		}
		
		public void shuffle() {
			
			/*
			 *  Shuffles the deck
			 */
			
			Collections.shuffle(deck);
					
		}
		
		public Card getTopCard() {
			/*
			 * gets the topmost card from a inverted deck
			 */
			return deck.remove(deck.size()-1);
		}
		
		public Card peek() {
			
			return deck.get(deck.size()-1);
		}
		
		
		public String toString() {
			
			String deck="";
			
			for(Card c:this.deck) {
				
				deck = deck +c+ " ";
			}
			
			return deck;
			
		}
		
		
		
			
		
		
		
		
		
		
}
