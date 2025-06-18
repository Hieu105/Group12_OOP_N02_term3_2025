package Minesweeper;

//Xu ly logic tro choi

import java.util.ArrayList;
import java.util.Random;

public class MineBoard {
	private MineTile[][] board;
	private ArrayList<MineTile> mineList;
	private int numRows;
	private int numCols;
	private int mineCount;
	private Random random;

	public MineBoard(int rows, int cols, int mines) {
		this.numRows = rows;
		this.numCols = cols;
		this.mineCount = mines;
		board = new MineTile[rows][cols];
		mineList = new ArrayList<>();
		random = new Random();
	}

	public MineTile[][] getBoard() {
		return board;
	}

	public ArrayList<MineTile> getMineList() {
		return mineList;
	}

	public void initializeBoard() {
		try {
			for (int r = 0; r < numRows; r++) {
				for (int c = 0; c < numCols; c++) {
					board[r][c] = new MineTile(r, c);
				}
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi khởi tạo bảng: " + e.getMessage());
		} finally {
			System.out.println("Đã chạy initializeBoard()");
		}
	}

	public void setMines() {
		try {
			int minesLeft = mineCount;
			while (minesLeft > 0) {
				int r = random.nextInt(numRows);
				int c = random.nextInt(numCols);
				MineTile tile = board[r][c];
				if (!mineList.contains(tile)) {
					mineList.add(tile);
					minesLeft--;
				}
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi đặt mìn: " + e.getMessage());
		} finally {
			System.out.println("Đã chạy setMines()");
		}
	}

	public boolean isMine(MineTile tile) {
		try {
			return mineList.contains(tile);
		} catch (Exception e) {
			System.err.println("Lỗi khi kiểm tra mìn: " + e.getMessage());
			return false;
		} finally {
			System.out.println("Kiểm tra isMine()");
		}
	}

	public MineTile getTile(int r, int c) {
		try {
			return board[r][c];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Truy cập ngoài phạm vi bảng: " + e.getMessage());
			return null;
		} catch (Exception e) {
			System.err.println("Lỗi khác trong getTile: " + e.getMessage());
			return null;
		} finally {
			System.out.println("Đã gọi getTile(" + r + ", " + c + ")");
		}
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public int getMineCount() {
		return mineCount;
	}
}
