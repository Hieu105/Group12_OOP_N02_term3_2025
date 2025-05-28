package Minesweeper;

//Giao dien chinh

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class GameUI {
	private JFrame frame;
	private JLabel textLabel;
	private JPanel boardPanel;
	private final MineBoard board;
	private boolean gameOver = false;
	private int tilesClicked = 0;
	private JButton resetButton;
	private JLabel timerLabel;
	private Timer timer;
	private int elapsedSeconds = 0;

	public GameUI(MineBoard board) {
		this.board = board;
		setupFrame();
	}

	private void setupFrame() {
		frame = new JFrame("Minesweeper");
		frame.setSize(board.getNumCols() * 70, board.getNumRows() * 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		textLabel = new JLabel("Minesweeper: " + board.getMineCount(), SwingConstants.CENTER);
		textLabel.setFont(new Font("Arial", Font.BOLD, 25));
		JPanel textPanel = new JPanel(new BorderLayout());
		textPanel.add(textLabel, BorderLayout.CENTER);
		frame.add(textPanel, BorderLayout.NORTH);

		boardPanel = new JPanel(new GridLayout(board.getNumRows(), board.getNumCols()));
		boardPanel.setBackground(Color.gray);
		frame.add(boardPanel, BorderLayout.CENTER);

		textLabel = new JLabel("Minesweeper: " + board.getMineCount(), SwingConstants.CENTER);
		textLabel.setFont(new Font("Arial", Font.BOLD, 25));

		timerLabel = new JLabel("Time: 0s", SwingConstants.RIGHT);
		timerLabel.setFont(new Font("Arial", Font.PLAIN, 18));

		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Arial", Font.PLAIN, 25));
		resetButton.addActionListener(e -> resetGame());

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(resetButton, BorderLayout.WEST);
		topPanel.add(textLabel, BorderLayout.CENTER);
		topPanel.add(timerLabel, BorderLayout.EAST);
		frame.add(topPanel, BorderLayout.NORTH);
		resetButton.setFocusPainted(false);
		resetButton.setBorderPainted(false);
		resetButton.setBackground(Color.LIGHT_GRAY);

	}