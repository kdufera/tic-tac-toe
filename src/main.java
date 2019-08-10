import java.util.HashSet;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while (true) { // initial init
			System.out.println("Which player do you want to be? X or O ? ");
			String userInput = scanner.nextLine();

			if(!isValidInitialInput(userInput)) {
				System.out.println("Invalid Input!");
				continue;

			} else {

				String computer = (userInput.equals("X")) ? "O": "X";
				Grid tttGrid = new Grid(userInput,computer);
				ComputerBrain compBrain = new ComputerBrain(computer); // Instantiate computer brain
				while(true) { // move
					System.out.println("\n");
					System.out.println("Where do you want to move ?");
					String inputMove = scanner.nextLine();

					if(!isValidPosition(inputMove)) {
						System.out.println(" ** Invalid Position! **");
						continue;
					} else {

						System.out.println("You Selected: " + inputMove + "\n");					
						if(!tttGrid.findAllAvaliableSpaces().isEmpty()  && tttGrid.insertAtPosition(tttGrid.player, inputMove)) { // player move
							if(!tttGrid.findAllAvaliableSpaces().isEmpty()) {
								String compMove = compBrain.SelectPosition(tttGrid.gridInfo(), tttGrid.findAllAvaliableSpaces());
								System.out.println( "\n" + "\n" + "Computer Selected: " + compMove + "\n");
								if(!tttGrid.findAllAvaliableSpaces().isEmpty() && tttGrid.insertAtPosition(tttGrid.computer, compMove)) { // computer move
									continue;
								} else {
									if(tttGrid.gridIsFull) {
										System.out.println(" Grid is full. Restaring the Game!");
										tttGrid.setUpAvailablePositions();
									} 

									if(tttGrid.winner != "") {
										if(tttGrid.winner.equals(tttGrid.player)) {
											System.out.println("\n" + "\n" + "--- Congrats! Your are the winner ---" + "\n" + "\n");
											System.out.println("\n");
											System.out.println("--- Re-setting the grid for a new game! ---" + "\n" + "\n" );
											tttGrid.setUpAvailablePositions();
//											scanner.close(); //TODO: Might need to close the scanner but the game runs continuously by reseting
											// the grid after every game. (Not sure if this is a requirement) 

										} else {
											System.out.println( "\n" + "\n" + " --- Computer Wins! Please try again! ---" + "\n" + "\n");
											System.out.println("--- Re-setting the grid for a new game! ---" + "\n" + "\n" );
											tttGrid.setUpAvailablePositions();
//											scanner.close();
										}

									} else {
										continue;
									}
								}
							} else {
								System.out.println(" ---- Grid is full. Restaring the Game! ---" + "\n" + "\n");
								tttGrid.setUpAvailablePositions();
							}

						} else {
							if(tttGrid.gridIsFull) {
								System.out.println("--- Grid is full. Restaring the Game! ---" + "\n" + "\n");
								tttGrid.setUpAvailablePositions();
//								scanner.close();
							} 

							if(tttGrid.winner != "") {
								if(tttGrid.winner.equals(tttGrid.player)) {
									System.out.println("\n" + "\n" + "--- Congrats! Your are the winner ---" + "\n" + "\n");
									System.out.println("*** Re-setting the grid for a new game! **" + "\n" + "\n");
									tttGrid.setUpAvailablePositions();
//									scanner.close();

								} else {
									System.out.println( "\n" + " ---- Computer Wins! Please try again! ---"+ "\n" + "\n");
									System.out.println("--- Re-setting the grid for a new game! ---"+ "\n" + "\n" );
									tttGrid.setUpAvailablePositions();
//									scanner.close();
								}

							} else {
								continue;
							}
						}
						continue;
					}
				}
			}
		}
	}

	/**
	 * Method used to validate valid Positions
	 * @param position
	 * @return
	 */

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

