package Minesweeper;

//Dien dien cho moi o vuong

import javax.swing.JButton;

public class MineTile extends JButton implements IMineTile {
	private int row;
	private int col;

	public MineTile(int row, int col) {
		try {
			this.setRow(row);
			this.setCol(col);
		} catch (Exception e) {
			System.err.println("Lỗi khi khởi tạo MineTile: " + e.getMessage());
		} finally {
			System.out.println("Đã gọi constructor MineTile(" + row + ", " + col + ")");
		}
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getCol() {
		return col;
	}

	@Override
	public void setRow(int row) {
		try {
			this.row = row;
		} catch (Exception e) {
			System.err.println("Lỗi khi setRow: " + e.getMessage());
		} finally {
			System.out.println("setRow(" + row + ") hoàn tất");
		}
	}

	@Override
	public void setCol(int col) {
		try {
			this.col = col;
		} catch (Exception e) {
			System.err.println("Lỗi khi setCol: " + e.getMessage());
		} finally {
			System.out.println("setCol(" + col + ") hoàn tất");
		}
	}
}
