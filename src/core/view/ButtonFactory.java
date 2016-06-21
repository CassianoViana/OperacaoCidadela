package core.view;
import javax.swing.JButton;

public final class ButtonFactory {
	/**
	 * @wbp.factory
	 */
	public static JButton createJButton() {
		JButton button = new GameButton("Back");
		return button;
	}
	
}