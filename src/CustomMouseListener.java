import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPopupMenu;

public class CustomMouseListener implements MouseListener {
	private JButton b;
	private Graphics g;
	
	public CustomMouseListener() {
		
	}
	public CustomMouseListener(JButton b) {
		this.b = b;
	}


	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			if(b.getText().equals("X")) {
				b.setForeground(Color.RED);
				b.setBackground(Color.GRAY);
				JPopupMenu lose = new JPopupMenu("Game Over");
				lose.add(new JButton("Game Over"));
				lose.setSize(300,300);
				lose.setLocation(450, 450);
				lose.setVisible(true);
				b.removeMouseListener(this);
			}else {
				b.setForeground(Color.GREEN);
				b.removeMouseListener(this);
			}
		} else if (e.getButton() == 3) {
			
			//b.createImage(producer);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}