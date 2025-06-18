package Minesweeper;

// Dieu khien game

public class GameController {
	private final MineBoard board;
	private final GameUI ui;

	public GameController(MineBoard board, GameUI ui) {
		this.board = board;
		this.ui = ui;
	}

	public void startGame() {
		try {
			board.initializeBoard();
			board.setMines();
			ui.setupBoard();
			ui.startTimer();
		} catch (Exception e) {
			System.err.println("Đã xảy ra lỗi khi bắt đầu trò chơi: " + e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("GameController.startGame() đã thực thi.");
		}
	}
}
