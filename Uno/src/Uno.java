import java.util.ArrayList;
import java.util.Scanner;

public class Uno {

	private Card current; // the current card or previously played card or starting card
	private Deck deck; // the deck of the game
	private ArrayList<Card> cardpile; //when players throw card, it piles up here. Also, creates a new deck if the current deck is empty
	private int penalty; // when wildcards stack up the penalty stacks up. If a player is unable to counter the current wildcard on play, player is penalised "penalty" number of cards
	private Scanner choice;
	private Player p1,p2; //player 1 and 2
	private int pick; // players pick
	
	public Uno() {
		/*constructor
		 * constructs the game
		 * prepares the game to play
		 */
		deck = new Deck();
		deck.shuffle();
		penalty = 0;
		current = getStartingCard();
		cardpile = new ArrayList<Card>();
		cardpile.add(current);
		choice = new Scanner(System.in);
		p1 = new Player("Player 1");
		p2 = new Player("Player 2");
		distributecards();
		
	
	}
	
	
	
	public void game() {
				
		int turn=0;
		while(!gameOver(p1,p2)) {
			if(turn%2==0) {
			playGame(p1);}
			else {
			playGame(p2);}
			turn++;
		}
		
	}
	
	
private void distributecards() {
		
		for(int i=0;i<10;i++) {
			
			if(i%2==0) {
				p1.pickCards(deck.getTopCard());
			}
			
			else {
				p2.pickCards(deck.getTopCard());
			}
			
			
		}
	}
	
	
	
	public void playGame(Player p) {
		
		decorate();
		System.out.println(p+", It is your turn\nThe current card on play is:\n"+current);
		
		decorate();
		showBoard(p);
		decorate();
		
		if(current.isSpecial()) {
			penalty+=current.getValue();
			Card pick;
			if(!canOverride(p)) {
				System.out.println("You dont have a card to override the current special card, so you are penalised");
				for(int i=0;i<penalty;i++) {

					if(deck.isEmpty()) {
						deck = new Deck(cardpile);
					}
					pick = deck.getTopCard();
					p.pickCards(pick);
					System.out.println("You picked: \n"+pick);
					pause();
					
				}
				penalty = 0;
				current = deck.getTopCard();
				System.out.println("The new current card is: \n"+current);
			}
			
			
			}
			
//		}   
		
		
	
		
	
		if(!hasColor(p) && !hasValue(p) && !hasSpecial(p)) {
				Card pick=null;	
				System.out.println("You dont have a valid card to play, so you have to pick cards.");
				while(!hasColor(p) && !hasValue(p) && !hasSpecial(p)) {
					
					pause();
					pick = deck.getTopCard();
					p.pickCards(pick);
					System.out.println("You picked:\n"+pick);
					
				}
				
				System.out.println("You recieved a valid card!");
				pause();
				System.out.println("You have the following cards: ");
				p.showCards();
			}
			
	
		
		
		
		System.out.println("Please pick a card:");
		pick = choice.nextInt()-1;
		//System.out.println(pick);
		
		while(!isValidChoice(p,pick)) {
			
			System.out.println("Invalid pick. Please pick a valid card.");
			pick = choice.nextInt()-1;
			
		}
		
		Card play = p.throwCard(pick);
		
		p.sayUno();
		current = play;
		cardpile.add(current);
		reviveDeck();
	}
	
	
	private boolean hasSpecial(Player p) {
		// TODO Auto-generated method stub
		
		for(Card c:p.PlayerCards()) {
			
			if(c.isSpecial()) {
				return true;
			}
			
		}
		
		
		return false;
	}



	public void reviveDeck() {
		
		if(deck.isEmpty()) {
			deck = new Deck(cardpile);
		}
		
	}
	
	
	private boolean isValidChoice(Player p,int choice) {
		
		/*
		 * checks if the user selection was a valid choice or not
		 * to be a valid choice: the player must have the card, the card must be either the same color or value as the current card(card in play/previously played card)
		 */
		
		if(choice <= p.PlayerCards().size()) {
			//add for special
			
			if(p.PlayerCards().get(choice).getColor().equals(current.getColor()) || p.PlayerCards().get(choice).getValue()==current.getValue() || p.PlayerCards().get(choice).isSpecial()) {
				return true;
			}
			
			
		}
		
		return false;
	}
	
	
	private void pause() {
		/*
		 * creates a pause
		 * asks the user to press enter
		 * purpose is simply to get user engagement
		 */
		System.out.println("Press enter to continue......");
		choice.nextLine();
		
	}
	
		
	private boolean hasColor(Player p) {
		/*
		 * checks if player has card of the same color as the current card that is being played
		 */
		for(Card c:p.PlayerCards()) {
			
			if(c.getColor().equals(current.getColor())) {
				return true;
			}
			
			
		}
		
		return false;
	}
	
	private boolean hasValue(Player p) {  
		/*
		 * checks if the player has the card of the same value as the current that is being played. 
		 */
		
		for(Card c:p.PlayerCards()) {
			
			if(c.getValue()==current.getValue()) {
				
				return true;
				
			}
		}
		
		return false;
	}
	
	
	private boolean canOverride(Player p) {
		
		/*
		 * checks if player has a wild card (special card)
		 * special cards can be played when you don't have a card with the same color or the value of the card that is being currently played
		 * if the current card is a special card, then player must have a special card with the same or greater value to play.
		 */
		for(Card c:p.PlayerCards()) {
			
			if(c.isSpecial()) {
				if(c.getValue() >= current.getValue()) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	private void decorate() {
		/*
		 * draws asterik lines
		 */
		
		
		System.out.println("***********************************************************************************");
	}
	
	
	
	
	private Card getStartingCard() {
		
		/*
		 * gets a valid starting card.
		 * starting card cannot be a special card
		 */
		
		Card temp = deck.peek();
		while(temp.isSpecial()) {
			deck.shuffle();
			temp = deck.peek();
		}
		
		temp = deck.getTopCard();
		return temp;
	}
	
	
	


public boolean gameOver(Player p1,Player p2) {
	
	if(p1.hasWon()) {
		System.out.println("**************************************************");
		System.out.println("Player 1 has won");
		System.out.println("**************************************************");
		return true;
	}
	
	else if(p2.hasWon()) {
		System.out.println("**************************************************");
		System.out.println("Player 2 has won");
		System.out.println("**************************************************");
		return true;
	}
	
	return false;
}

public void showBoard(Player p) {
	
	if(p.toString().equals("Player 1")) {
		System.out.println("                Player 1");
		p1.showCards();
		p2.hideCards();
		System.out.println("                Player 2");
		System.out.println("");
	}
	else {
		
		System.out.println("                Player 1");
		p1.hideCards();
		p2.showCards();
		System.out.println("                Player 2");
		System.out.println("");
		
	}
	
}



}