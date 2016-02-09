package ctrl;

import java.io.Serializable;

import board.Board;
import character.Event;
import character.Player;

/**The game class holds the variables that the game requires, a board, a player, difficulty etc.
 * 
 * @author Grant
 *
 */
public class Game implements Serializable{

	private static final long serialVersionUID = 1L;
	private Player player;
	private Board gmBoard;
	private Controller ctrl;
	//private PlayerEffect Effect;//I don't think this makes sense here-W
	private Event event;
	private int difficulty; //0 = easy; 1 = medium; 2 = hard;

	
	/**
	 * Generates a new game, with the specified variables
	 * @param pName The name of the Player
	 * @param numSBoards The number of subBoards
	 * @param nSpaces The number of spaces on each subBoard
	 * @param diff Difficulty of the Game
	 * @param controller The controller Object which contains this Game, required for Player death.
	 */
	public Game(String pName, int numSBoards, int nSpaces, int diff, Controller controller) {
		player = new Player(pName);
		ctrl = controller;
		gmBoard = new Board(numSBoards, nSpaces);
	}

	
/*
	public PlayerEffect getEffect() {

		return Effect;
	}


	public void setEffect(PlayerEffect effect) {
		Effect = effect;
	}
*/
	/**
	 * Returns the current event 
	 * @return the current event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Sets the current event to a predefined event, and applies it to the Player
	 */
	public void setEvent(Event event) {
		this.event = event;
		player.applyEvent(this.event);
	}
	/**
	 * Sets the current event to a random event, and applies it to the Player
	 * @return The description of the event
	 */
	public String setRndEvent() {
		event = Event.rndEvent();
		player.applyEvent(event);
		return event.getText();
	}
	/**
	 * @return The difficulty of the current game
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Sets the difficult of the current game
	 * @param difficulty The new Game difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * @return The Player of the Game
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Changes the Player of the Game to another Player
	 * @param player The new Player of the Game
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return The board on which the Game is being played
	 */
	public Board getGmBoard() {
		return gmBoard;
	}

	/**
	 * Changes the board on which the Game is being played
	 * @param gmBoard The new board on which the Game is to be played
	 */
	public void setGmBoard(Board gmBoard) {
		this.gmBoard = gmBoard;
	}

	/**
	 * Signals to the controller that the game has ended due to the Player's demise.
	 */
	public void gameOver() {
		ctrl.gmOver();
	}

	
	

}
