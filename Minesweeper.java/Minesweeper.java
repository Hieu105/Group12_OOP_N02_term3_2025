package Minesweeper;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Minesweeper {
	private class MineTile extends JButton {
		private int row;
		private int col;

		public MineTile(int row, int col) {
			this.setRow(row);
			this.setCol(col);
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}
	}

	int tileSSize = 70;
	int numRows = 8;
	int numCols = numRows;
	int boardWidth = numCols * tileSSize;
	int boardHeight = numRows * tileSSize;

	JFrame frame = new JFrame("Minesweeper");
	JLabel textLabel = new JLabel();
	JPanel textPanel = new JPanel();
	JPanel boardPanel = new JPanel();

	int mineCount = 10;
	MineTile[][] board = new MineTile[numRows][numCols];
	ArrayList<MineTile> mineList;
	Random random = new Random();
	int tilesClicked = 0;
	boolean gameOver = false;

	Minesweeper() {
		try {
			frame.setSize(boardWidth, boardHeight);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BorderLayout());

			textLabel.setFont(new Font("Arial", Font.BOLD, 25));
			textLabel.setHorizontalAlignment(JLabel.CENTER);
			textLabel.setText("MineSweeper: " + Integer.toString(mineCount));
			textLabel.setOpaque(true);

			textPanel.setLayout(new BorderLayout());
			textPanel.add(textLabel);
			frame.add(textPanel, BorderLayout.NORTH);

			boardPanel.setLayout(new GridLayout(numRows, numCols));
			boardPanel.setBackground(Color.gray);
			frame.add(boardPanel, BorderLayout.CENTER);

			for (int r = 0; r < numRows; r++) {
				for (int c = 0; c < numCols; c++) {
					MineTile tile = new MineTile(r, c);
					board[r][c] = tile;

					tile.setFocusable(false);
					tile.setMargin(new Insets(0, 0, 0, 0));
					tile.setFont(new Font("Arial Unicode Ms", Font.PLAIN, 45));
					boardPanel.add(tile);

					tile.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							try {
								if (gameOver) return;

								MineTile tile = (MineTile) e.getSource();
								// left click
								if (e.getButton() == MouseEvent.BUTTON1) {
									if (tile.getText().equals("")) {
										if (mineList.contains(tile)) {
											revealMines();
										} else {
											checkMine(tile.row, tile.col);
										}
									}
								}
								// right click
								else if (e.getButton() == MouseEvent.BUTTON3) {
									if (tile.getText().equals("") && tile.isEnabled()) {
										tile.setText("🚩");
									} else if (tile.getText().equals("🚩")) {
										tile.setText("");
									}
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							} finally {
								// Xử lý cleanup nếu cần
							}
						}
					});
				}
			}
			frame.setVisible(true);
			setMines();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Khối finally ở constructor
		}
	}
}
