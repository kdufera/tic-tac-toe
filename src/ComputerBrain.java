import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ComputerBrain {

	String playerType;

	public ComputerBrain(String playerType) {
		this.playerType = playerType;
	}


	/**
	 * Method used to finalize main grid position 
	 * @param currenGridInfo
	 * @param availiblePositions
	 * @return
	 */
	public String SelectPosition(HashMap<String,String> currenGridInfo, HashSet<String> availiblePositions) {
		String position = "";
		position =  this.analyzeGridPosition(currenGridInfo, availiblePositions);

		return position;
	}
	
	/**
	 * Method used to analyze and plan grid move position
	 * @param currenGridInfo
	 * @param availiblePositions
	 * @return
	 */

	public String analyzeGridPosition(HashMap<String,String> currenGridInfo, HashSet<String> availiblePositions) {
		String finalPosition = "";

		finalPosition = this.analyzeGridDefensePosition(currenGridInfo, availiblePositions);

		if(finalPosition == "") { // return random item from the list of position
			int size = availiblePositions.size();
			int item = new Random().nextInt(size); 
			int i = 0;
			for(Object obj : availiblePositions)
			{
				if (i == item)
					finalPosition = (String) obj;
				i++;
			} 
		}
		return finalPosition;
	}
	
	/**
	 * Method used to analyze grid defense positions
	 * @param currenGridInfo
	 * @param availiblePositions
	 * @return
	 */

	public String analyzeGridDefensePosition(HashMap<String,String> currenGridInfo, HashSet<String> availiblePositions) {
		String defensePosition = "";

		String A1 = (currenGridInfo.get("A1") != null)? currenGridInfo.get("A1"):"";
		String A2 = (currenGridInfo.get("A2") != null)? currenGridInfo.get("A2"):"";
		String A3 = (currenGridInfo.get("A3") != null)? currenGridInfo.get("A3"):"";
		String B1 = (currenGridInfo.get("B1") != null)? currenGridInfo.get("B1"):"";
		String B2 = (currenGridInfo.get("B2") != null)? currenGridInfo.get("B2"):"";
		String B3 = (currenGridInfo.get("B3") != null)? currenGridInfo.get("B3"):"";
		String C1 = (currenGridInfo.get("C1") != null)? currenGridInfo.get("C1"):"";
		String C2 = (currenGridInfo.get("C2") != null)? currenGridInfo.get("C2"):"";
		String C3 = (currenGridInfo.get("C3") != null)? currenGridInfo.get("C3"):"";

		defensePosition = this.checkForRiskOnAllPositions(A1, A2, A3, "A1", "A2", "A3");	
		if(defensePosition == "") {
			defensePosition = this.checkForRiskOnAllPositions(C1, C2, C3, "C1", "C2", "C3");
			if(defensePosition == "") {
				defensePosition = this.checkForRiskOnAllPositions(A1, B1, C1, "A1", "B1", "C1");
				if(defensePosition == "") {
					defensePosition = this.checkForRiskOnAllPositions(A2, B2, C2, "A2", "B2", "C2");
					if(defensePosition == "") {
						defensePosition = this.checkForRiskOnAllPositions(A3, B3, C3, "A3", "B3", "C3");
						if(defensePosition == "") {
							defensePosition = this.checkForRiskOnAllPositions(A3, B2, C1, "A3", "B2", "C1");
							if(defensePosition == "") {
								defensePosition = this.checkForRiskOnAllPositions(A1, B2, C3, "A1", "B2", "C3");
								if(defensePosition == "") {
									defensePosition = this.checkForRiskOnAllPositions(B1, B2, B3, "B1", "B2", "B3");
									if (defensePosition == "") {
										defensePosition = this.checkForRiskOnAllPositions(C1, C2, C3, "C1", "C2", "C3");
									}
								}
							}
						}
					}
				}
			}
		}

		return defensePosition;

	}

	/**
	 * Returns a position at risk
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */

	public String checkForRiskOnAllPositions(String x, String y, String z, String posA, String posB, String posC) {
		String positionAtRisk = "";

		positionAtRisk = (y != "" && z!= "" && x == "" && this.playerType != y && this.playerType != z)? posA : "";
		if(positionAtRisk == "") {
			positionAtRisk = (x != "" && z!= "" && y == "" && this.playerType != x && this.playerType != z)? posB:"";
			if (positionAtRisk == "") {
				positionAtRisk = (x != "" && y!= "" && z == "" && this.playerType != x && this.playerType != y)? posC :"";
			}
		}
		
		//System.out.println("\n" + "******Checking for " + posA  + " : " + posB + " : " + posC  + " Risk position: " + positionAtRisk );

		return positionAtRisk;
	}

	/**
	 *  Method analyze grid attack positions
	 * @param currenGridInfo
	 * @param availiblePositions
	 * @return
	 */
	public String analyzeGridAttackPosition(HashMap<String,String> currenGridInfo, HashSet<String> availiblePositions) {
		String defensePosition = "";
		String A1 = (currenGridInfo.get("A1") != null)? currenGridInfo.get("A1"):"";
		String A2 = (currenGridInfo.get("A2") != null)? currenGridInfo.get("A2"):"";
		String A3 = (currenGridInfo.get("A3") != null)? currenGridInfo.get("A3"):"";
		String B1 = (currenGridInfo.get("B1") != null)? currenGridInfo.get("B1"):"";
		String B2 = (currenGridInfo.get("B2") != null)? currenGridInfo.get("B2"):"";
		String B3 = (currenGridInfo.get("B3") != null)? currenGridInfo.get("B3"):"";
		String C1 = (currenGridInfo.get("C1") != null)? currenGridInfo.get("C1"):"";
		String C2 = (currenGridInfo.get("C2") != null)? currenGridInfo.get("C2"):"";
		String C3 = (currenGridInfo.get("C3") != null)? currenGridInfo.get("C3"):"";

		return defensePosition;

	}
	
	public String checkForAttackPositions(String x, String y, String z, String posA, String posB, String posC) {
		String positionAtRisk = "";

		positionAtRisk = (y != "" && z!= "" && x == "" && this.playerType != y && this.playerType != z)? posA : "";
		if(positionAtRisk == "") {
			positionAtRisk = (x != "" && z!= "" && y == "" && this.playerType != x && this.playerType != z)? posB:"";
			if (positionAtRisk == "") {
				positionAtRisk = (x != "" && y!= "" && z == "" && this.playerType != x && this.playerType != y)? posC :"";
			}
		}
		//		System.out.println("\n" + "******Checking for " + posA  + " : " + posB + " : " + posC  + " Risk position: " + positionAtRisk );

		return positionAtRisk;
	}
}


