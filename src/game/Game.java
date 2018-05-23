package game;

import table.Position;
import table.Table;

public class Game {

	protected Table table_;
	protected Player player_;
	protected Player opponent_;

	public Game(int width, int height) {
		this.table_ = new Table(height, width);
		this.opponent_ = new Player();
	}

	public Position getPosition(int x, int y) {
		return this.table_.getPosition(x, y);

	}

	public void setPlayersOnTable(int i, Player player) {
		this.player_ = player;
		if (i == 1) {
			this.player_.setTurn(true);
		}
	}

	public String getPlayerName() {
		return this.player_.getName();
	}

	public Action selectPosition(Position clickedPosition) {
		if (this.player_.getSelectedPosition() == null)
			this.player_.setSelectedPosition(clickedPosition);
		System.out.println("select");
		return null;
	}

	public Action attack(Position clickedPosition) {
		System.out.println("attack");
		return null;
	}

	public Action move(Position clickedPosition) {
		Position selectedPosition = this.player_.getSelectedPosition();
		Character character = selectedPosition.getCharacter();
		
		clickedPosition.setCharacter(character);
		selectedPosition.removeCharacter();
		

		return null;
	}

	public Action changeTurn() {
		this.player_.setTurn(false);
		this.opponent_.setTurn(true);

		return new Action(TypeAction.CHANGE_TURN);
	}

	// ##########################
	// teste

	public Player getOpponent() {
		return this.opponent_;
	}

}
