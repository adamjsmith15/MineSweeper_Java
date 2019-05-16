import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TileTesterMineSweeper {
	private JButton[][] t = new JButton[10][10]; // Declared much earlier in the program, right after the class
													// declaration.

	public void generateMineField() {
		// int userEntry = Validator.getInt(sc, "How large would you like the mine
		// field?");
		// field = new String[userEntry][userEntry];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = new JButton("O");
			}

		}
	}

	public void fillMineField() {
		Random rand = new Random();
		int mines = 20;
		while (mines > 0) {
			int randomInteger = (int) (rand.nextDouble() * t.length);
			int randomInteger2 = (int) (rand.nextDouble() * t.length);
			if (t[randomInteger][randomInteger2].getText().equals("X")) {
				continue;
			} else {
				t[randomInteger][randomInteger2].setText("X");
				;
				mines--;
			}
		}

	}

	public void buildTile(JPanel panelc) {
		// JPanel panelc = new JPanel();
		panelc.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (t[i][j].getText().equals("X")) {
					t[i][j] = new JButton(("X"));
					t[i][j].setBackground(Color.BLACK);
					t[i][j].setForeground(Color.WHITE);
					t[i][j].addActionListener(new TileListener());
					t[i][j].addMouseListener(new CustomMouseListener(t[i][j]));
					panelc.add(t[i][j]);
				} else {
					int counter = 0;
					if (i == 0 && j == 0) {
						if (t[i + 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i + 1][j + 1].getText().equals("X")) {
							counter++;
						}
					} else if (i == 0 && j == (t.length - 1)) {
						if (t[i + 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i + 1][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i][j - 1].getText().equals("X")) {
							counter++;
						}
					} else if (i == 0) {
						if (t[i + 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i + 1][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i + 1][j - 1].getText().equals("X")) {
							counter++;
						}
					} else if (i == (t.length - 1) && j == 0) {
						if (t[i - 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j + 1].getText().equals("X")) {
							counter++;
						}
					} else if (i == (t.length - 1) && j == (t.length - 1)) {
						if (t[i - 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i][j - 1].getText().equals("X")) {
							counter++;
						}
					} else if (j == (t.length - 1)) {
						if (t[i + 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i + 1][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j - 1].getText().equals("X")) {
							counter++;
						}
					} else if (j == 0) {
						if (t[i + 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i + 1][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j].getText().equals("X")) {
							counter++;
						}
					} else if (i == (t.length - 1)) {
						if (t[i][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j].getText().equals("X")) {
							counter++;
						}
					} else {
						if (t[i + 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j].getText().equals("X")) {
							counter++;
						}
						if (t[i][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j - 1].getText().equals("X")) {
							counter++;
						}
						if (t[i - 1][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i + 1][j + 1].getText().equals("X")) {
							counter++;
						}
						if (t[i + 1][j - 1].getText().equals("X")) {
							counter++;
						}
					}

					t[i][j] = new JButton(Integer.toString(counter));
					t[i][j].setBackground(Color.BLACK);
					t[i][j].setForeground(Color.WHITE);
					t[i][j].addActionListener(new TileListener());
					t[i][j].addMouseListener(new CustomMouseListener(t[i][j]));
					//t[i][j].addMouseListener(new MouseHandler(i,j));
					panelc.add(t[i][j]);
				}
			}

		}
	}

	private class TileListener implements ActionListener {
		public void actionPerformed(MouseEvent e) {
			JButton source = (JButton) e.getSource();
			MouseHandler mh = new MouseHandler();
			mh.mouseClicked(e, t);
			// source.getDisplayedMnemonicIndex();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
