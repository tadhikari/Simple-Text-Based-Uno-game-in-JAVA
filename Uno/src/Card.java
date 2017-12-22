
public class Card {
	
	private String color;
	private int value;
	private int specialValue;
	private boolean special;

	public Card(int value,String color) {
		
		/*
		 * constructs a non speicla card
		 * sets the color and numerical value
		 * sets it to the normal card category
		 */
		
		
		this.color = color;
		this.value = value;
		this.specialValue = 0;
		this.special = false;
	}
	
	
	public Card(int specialValue) { // constructor for special cards like +4 and +2	
		
		/*
		 * assigns special value to the card
		 * sets the card to special category
		 */
		
		this.color="";
		this.specialValue = specialValue;
		this.value = 0;
		this.special = true;
	}
	
	public String getColor() {
		/*
		 * returns color of the card
		 */
		
		return this.color;
	}
	
	public int getValue() {
		
		/*
		 * returns numerical value of the card
		 */
		
		if(!this.special) {
		return this.value;}
		
		else {
			return this.specialValue;
		}
	}
	
	public String toString() {
		
		/*
		 * prints the card.
		 * prints [ color - card value ] if the card is not a special card
		 * prints [ + value ] if it is a special card 
		 */
		
//		if(!special) {
//			return "[ "+this.color+"-"+this.value+" ]";
//		}
//		
//		else if(special){
//			
//			return "[ "+"+"+this.specialValue+" ]"; 
//		}
//		return null;
		
		String[] card = {" ----- ","|     |","|     |"," ----- "};
		String c = "";
		
		
		for(int i=0;i<card.length;i++) {
				
			for(int j=0;j<1;j++) {
					
				if(!this.isSpecial()) {
					if(i==1) {
						
						c = c +"| "+this.getColor()+" |"+" ";
						
					}
					
					else if(i==2) {
						
						c = c + "|  "+this.getValue()+"  |"+" ";
					}
					
					else {
						c = c + card[i]+" "; 
					}
					
					}
				
				else if(this.isSpecial()) {
					
					if(i==1) {
						
						c = c +"| "+"+"+this.getValue()+"  |"+" ";
						
					}
					else {
						c = c + card[i]+" ";
					}
					
				}
				
					}
				
				c +="\n";
				
			}
				
		
		
		
		return c;
		
		
		
		
	}
	
	public boolean isSpecial() {
		
		/*
		 * returns true if card is a special card
		 * returns false if card is not a special card
		 */
		
		
		if(special) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
}
