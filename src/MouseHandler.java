import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MouseHandler extends MouseAdapter {
	public int r, c; // instance variables

	public MouseHandler(int r, int c) {
		this.r = r;
		this.c = c;
	}
	public MouseHandler() {
		
		
	}

	public void mouseClicked(MouseEvent e, JButton [][] field) {
		if (e.getButton() == 1) {
			field[r][c].setText("T");
		} else if (e.getButton() == 3) {
			field[r][c].setText("F");
		}
	}
}