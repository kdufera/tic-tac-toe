
import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {

	@Test
	public void testGrid() {
		Grid myGrid = new Grid("X", "0");
		assertEquals("X", myGrid.player);
		assertEquals("0", myGrid.computer);
		assertEquals(false, myGrid.findAllAvaliableSpaces().isEmpty());
	}

	@Test
	public void testInsertAtPosition() {
		Grid myGrid = new Grid("X", "0");
		myGrid.insertAtPosition("X", "A1");
		myGrid.insertAtPosition("O", "A2");
		assertEquals("X", myGrid.gridInfo().get("A1"));
		assertEquals("O", myGrid.gridInfo().get("A2"));
	}

	@Test
	public void testDisplayAvailablePositions() {
		Grid myGrid = new Grid("X", "0");
		assertEquals(9, myGrid.findAllAvaliableSpaces().size());
		myGrid.insertAtPosition("X", "A1");
		assertEquals(8, myGrid.findAllAvaliableSpaces().size());
	}

	@Test
	public void testGridInfo() {
		Grid myGrid = new Grid("X", "0");
		myGrid.insertAtPosition("X", "A2");
		assertEquals("X", myGrid.gridInfo().get("A2"));
	}

	@Test
	public void testCheckForWinner() {
		Grid myGrid = new Grid("X", "0");
		myGrid.insertAtPosition("X", "A1");
		myGrid.insertAtPosition("X", "A2");
		myGrid.insertAtPosition("X", "A3");
		assertEquals(true, myGrid.checkForWinner());
	}

	@Test
	public void testCheckForWInnerPosition() {
		Grid myGrid = new Grid("X", "0");
		assertEquals(true, myGrid.checkForWInnerPosition("X", "X", "X"));
		assertEquals(true, myGrid.checkForWInnerPosition("O", "O", "O"));
		assertEquals(false, myGrid.checkForWInnerPosition("O", "X", "O"));
		assertEquals(false, myGrid.checkForWInnerPosition("", "X", "O"));
	}

		@Test
		public void testSetUpAvailablePositions() {
			Grid myGrid = new Grid("X", "0");
			myGrid.setUpAvailablePositions();
			assertEquals(9, myGrid.findAllAvaliableSpaces().size());
		}
}
