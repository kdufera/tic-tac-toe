import java.util.HashSet;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean processMove = false;

		while (true) { // initial inpit
			System.out.println("Which player do you want to be? X or O ? ");
			String userInput = scanner.nextLine();

			if(!isValidInitialInput(userInput)) {
				System.out.println("Invalid Input!");
				continue;

			} else {
				//				System.out.println("Great, you are now player " + userInput);
				String computer = (userInput.equals("X")) ? "O": "X";

				Grid tttGrid = new Grid(userInput,computer);

				while(true) { // move
					System.out.println("\n");
					System.out.println("where do you want to move ?");
					String inputMove = scanner.nextLine();

					if(!isValidPosition(inputMove)) {
						System.out.println("Invalid Positin!");
						continue;
					} else {

						System.out.println("You Selected: " + inputMove + "\n");

						if(tttGrid.insertAtPosition(tttGrid.player, inputMove)) {







							continue;
						} else {
							if(tttGrid.gridIsFull) {
								System.out.println(" Grid is full. Restaring the Game!");
								tttGrid.setUpAvailablePositions();
							} 

							if(tttGrid.winner != "") {
								if(tttGrid.winner.equals(tttGrid.player)) {
									System.out.println("\n");

									System.out.println("*** Your are the winner ****");
									tttGrid.setUpAvailablePositions();

								} else {
									System.out.println( "\n" + " *** Computer Wins! Please try again! ****: ");
									tttGrid.setUpAvailablePositions();
								}

								//								System.out.println(" ***The Winner is ****: " + tttGrid.winner);
							}
						}



						//						System.out.println( tttGrid.checkForWInnerPosition("X", "X", "X") + "  Checking for winner");
						//						System.out.println("The winner is " + tttGrid.winner);






						continue;




					}
				}

			}
		}
	}

	public static boolean isValidPosition (String position ) {
		HashSet<String> validPositions = new HashSet<String>();
		validPositions.add("A1");
		validPositions.add("A2");
		validPositions.add("A3");
		validPositions.add("B1");
		validPositions.add("B2");
		validPositions.add("B3");
		validPositions.add("C1");
		validPositions.add("C2");
		validPositions.add("C3");
		return validPositions.contains(position);
	}

	/**
	 * Helper Method for user input Validation
	 * @param input
	 * @return
	 */

	public static boolean isValidInitialInput(String inputToken) {
		boolean validInputSelection = ((inputToken.equals("X")) || inputToken.equals("O")) ? true: false;
		return validInputSelection;
	}



}

