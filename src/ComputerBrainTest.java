import static org.junit.Assert.*;

import org.junit.Test;

public class ComputerBrainTest {

	@Test
	public void testComputerBrain() {
		ComputerBrain brain = new ComputerBrain("X");
		assertEquals("X", brain.getPlayerType());
		ComputerBrain brain1 = new ComputerBrain("O");
		assertEquals("O", brain1.getPlayerType());
	}

	@Test
	public void testSelectPosition() {
		Grid myGrid = new Grid("0", "X");
		ComputerBrain brain = new ComputerBrain("X");
		myGrid.insertAtPosition("X", "A1");
		myGrid.insertAtPosition("X", "A2");
		assertEquals("A3", brain.SelectPosition(myGrid.gridInfo(), myGrid.findAllAvaliableSpaces()));

	}

	@Test
	public void testAnalyzeGridPosition() {
		Grid myGrid = new Grid("X", "O");
		ComputerBrain brain = new ComputerBrain("O");
		myGrid.insertAtPosition("X", "B1");
		myGrid.insertAtPosition("X", "C2");
		myGrid.insertAtPosition("O", "A3");
		myGrid.insertAtPosition("O", "A2");
		assertEquals("A1", brain.analyzeGridPosition(myGrid.gridInfo(), myGrid.findAllAvaliableSpaces())); // attack before defense test
	}

	@Test
	public void testAnalyzeGridDefensePosition() {
		Grid myGrid = new Grid("X", "O");
		ComputerBrain brain = new ComputerBrain("O");
		myGrid.insertAtPosition("X", "A1");
		myGrid.insertAtPosition("X", "A2");
		assertEquals("A3", brain.analyzeGridDefensePosition(myGrid.gridInfo(), myGrid.findAllAvaliableSpaces())); // defense position test

	}

	@Test
	public void testCheckForRiskOnAllPositions() {
		ComputerBrain brain = new ComputerBrain("O");
		assertEquals("C", brain.checkForRiskOnAllPositions("X", "X", "", "A", "B", "C"));
		assertEquals("B", brain.checkForRiskOnAllPositions("X", "", "X", "A", "B", "C"));
		assertEquals("A", brain.checkForRiskOnAllPositions("", "X", "X", "A", "B", "C"));
		assertEquals("", brain.checkForRiskOnAllPositions("", "O", "X", "A", "B", "C"));
	}

	@Test
	public void testAnalyzeGridAttackPosition() {
		Grid myGrid = new Grid("X", "O");
		ComputerBrain brain = new ComputerBrain("O");
		myGrid.insertAtPosition("O", "A1");
		myGrid.insertAtPosition("O", "A2");
		assertEquals("A3", brain.analyzeGridAttackPosition(myGrid.gridInfo(), myGrid.findAllAvaliableSpaces())); // defense position test

	}

	@Test
	public void testCheckForAttackPositions() {
		ComputerBrain brain = new ComputerBrain("O");
		assertEquals("C", brain.checkForAttackPositions("O", "O", "", "A", "B", "C"));
		assertEquals("B", brain.checkForAttackPositions("O", "", "O", "A", "B", "C"));
		assertEquals("A", brain.checkForAttackPositions("", "O", "O", "A", "B", "C"));
		assertEquals("", brain.checkForAttackPositions("", "X", "O", "A", "B", "C"));

	}
}
