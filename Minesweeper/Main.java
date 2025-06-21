package Minesweeper;

public class Main {
	public static void main(String[] args) {
		try {
			MineBoard board = new MineBoard(8, 8, 10);
			GameUI ui = new GameUI(board);
			Gamecontroller controller = new Gamecontroller(board, ui);
			controller.startGame();
		} catch (Exception e) {
			System.out.println("Đã xảy ra lỗi trong quá trình khởi động trò chơi: " + e.getMessage());
			e.printStackTrace(); // Giúp in lỗi chi tiết để dễ sửa
		} finally {
			System.out.println("Chương trình main() đã kết thúc.");
		}
	}
}
