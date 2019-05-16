import javax.swing.JFrame;
import javax.swing.JPanel;

public class TileTesterApp {
	public static void main(String[] args) {
		TileTesterMineSweeper tt = new TileTesterMineSweeper();
		JPanel jp = new JPanel();
		JFrame f = new JFrame("MineSweeper");
		f.setSize(500, 500);
		f.setLocation(300, 300);
		tt.generateMineField();
		tt.fillMineField();
		tt.buildTile(jp);
		f.getContentPane().add(jp);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jp.setVisible(true);
		f.setVisible(true);
	}

}
