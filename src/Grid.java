import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class Grid {

	static String player;
	static String computer;
	static String winner = "";
	static boolean gridIsFull = false;

	HashMap<String, String> tttGridMap = new HashMap<String, String>();
	HashSet<String> avaliablePositions = new HashSet<String>(); // track available positions 

	public Grid(String player, String computer ) {
		this.player = player;
		this.computer = computer;
		System.out.print("Thanks, you are Player : " + this.player + "  " + "Computer: " + this.computer + "\n" +  "\n");

		if (!this.setUpAvailablePositions()) {
			System.out.print("Unable to setup  up grid! please re-run the game");
		}

	}

	/**
	 * Place a move for a given player and update available 
	 * positions
	 * @param player
	 * @param position
	 * @return
	 */

	public boolean insertAtPosition(String player, String position) {
		boolean posAvaliable = true;

		if(!avaliablePositions.isEmpty()) { // positions available  

			tttGridMap.put(position, player);
			avaliablePositions.remove(position); // updated available positions

			this.displayAvailablePositions();
			if (checkForWinner()) { /// check for winner 
				posAvaliable = false;
			}
		} else {
			this.gridIsFull = true;
			posAvaliable = false;
		}
		return posAvaliable;
	}

	/**
	 * Returns all available positions  
	 * @param Position
	 * @return
	 */

	public HashSet<String> findAllAvaliableSpaces(String Position) {
		return this.avaliablePositions;
	}

	/**
	 * Display a list of available positions
	 */

	public void displayAvailablePositions() {

		System.out.println("** Available Positions **" + "\n");

		Iterator<String> i = this.avaliablePositions.iterator(); 
		while (i.hasNext()) 
			System.out.print(i.next() + " "); 
	} 


	/**
	 * Return ttt grid map for computer to process
	 * @return
	 */

	public HashMap<String, String> gridInfo() {
		return this.tttGridMap;
	}


	/**
	 * Checks to see if there is a winner on the grid
	 * @return boolean 
	 */

	public  boolean checkForWinner() {
		boolean winner = false;
		String A1 = (tttGridMap.get("A1") != null)? tttGridMap.get("A1"):"";
		String A2 = (tttGridMap.get("A2") != null)? tttGridMap.get("A2"):"";
		String A3 = (tttGridMap.get("A3") != null)? tttGridMap.get("A3"):"";
		String B1 = (tttGridMap.get("B1") != null)? tttGridMap.get("B1"):"";
		String B2 = (tttGridMap.get("B2") != null)? tttGridMap.get("B2"):"";
		String B3 = (tttGridMap.get("B3") != null)? tttGridMap.get("B3"):"";
		String C1 = (tttGridMap.get("C1") != null)? tttGridMap.get("C1"):"";
		String C2 = (tttGridMap.get("C2") != null)? tttGridMap.get("C2"):"";
		String C3 = (tttGridMap.get("C3") != null)? tttGridMap.get("C3"):"";


		if(this.checkForWInnerPosition(A1, A2, A3) || this.checkForWInnerPosition(B1, B2, B3)|| 
				this.checkForWInnerPosition(C1, C2, C3) || this.checkForWInnerPosition(A1, B1, C1)|| 
				this.checkForWInnerPosition(A2, B2, C2)|| this.checkForWInnerPosition(A3, B3, C3)||
				this.checkForWInnerPosition(A3, B2, C1) || this.checkForWInnerPosition(A1, B2, C3)) {

			return true;
		} else {
			return false;
		}
	}


	/**
	 * check for winning positions by comparing all three 
	 * positions
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public boolean checkForWInnerPosition(String x, String y, String z) {
		HashSet<String> checkDuplicateHash = new HashSet<String>(); // removes duplicates

		if( x== "" || y == "" || z == "") {
			return false;
		} else {

			checkDuplicateHash.add(x);
			checkDuplicateHash.add(y);
			checkDuplicateHash.add(z);

			if((checkDuplicateHash.size() == 1)) {

				this.winner = x;
				return true;
			} else {
				return false;
			}
		}

	}
	
	/**
	 * Method used to reset grid 
	 * @return
	 */

	public boolean setUpAvailablePositions() {

		this.avaliablePositions.clear();
		this.tttGridMap.clear();
		this.avaliablePositions.add("A1");
		this.avaliablePositions.add("A2");
		this.avaliablePositions.add("A3");
		this.avaliablePositions.add("B1");
		this.avaliablePositions.add("B2");
		this.avaliablePositions.add("B3");
		this.avaliablePositions.add("C1");
		this.avaliablePositions.add("C2");
		this.avaliablePositions.add("C3");

		if(!avaliablePositions.isEmpty()) {
			this.displayAvailablePositions();
			return true;
		} else {
			return false;
		}
	}

}
