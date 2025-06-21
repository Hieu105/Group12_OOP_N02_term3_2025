package Minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Minesweeper {
	private class MineTile extends JButton {
		private int row;
		private int col;

		public MineTile(int row, int col) {
			try {
				this.setRow(row);
				this.setCol(col);
			} catch (Exception e) {
				System.out.println("Lỗi khi tạo MineTile: " + e.getMessage());
			}
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
			textLabel.setText("MineSweeper: " + mineCount);
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
					tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
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
								System.out.println("Lỗi khi nhấn chuột: " + ex.getMessage());
							} finally {
								// Có thể để trống hoặc thêm xử lý cleanup nếu cần
							}
						}
					});
				}
			}
			frame.setVisible(true);
			setMines();
		} catch (Exception e) {
			System.out.println("Lỗi trong constructor Minesweeper: " + e.getMessage());
		} finally {
			System.out.println("Khởi tạo giao diện hoàn tất.");
		}
	}

	public void setMines() {
		try {
			mineList = new ArrayList<MineTile>();
			int mineLeft = mineCount;
			while (mineLeft > 0) {
				int r = random.nextInt(numRows);
				int c = random.nextInt(numCols);
				MineTile tile = board[r][c];
				if (!mineList.contains(tile)) {
					mineList.add(tile);
					mineLeft--;
				}
			}
		} catch (Exception e) {
			System.out.println("Lỗi khi đặt mìn: " + e.getMessage());
		} finally {
			System.out.println("Đã thực hiện xong setMines.");
		}
	}

	