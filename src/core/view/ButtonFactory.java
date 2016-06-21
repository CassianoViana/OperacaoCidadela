package core.view;
import javax.swing.JButton;

public final class ButtonFactory {
	/**
	 * @wbp.factory
	 */
	public static JButton createJButton() {
		return new GameButton("");
	}
	
}