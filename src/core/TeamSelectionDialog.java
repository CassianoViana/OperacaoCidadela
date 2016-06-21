package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import resources.R;
import core.view.ButtonFactory;
import core.view.GameDialogs;

public class TeamSelectionDialog extends JDialog {

	private final class TeamButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			selectedTeamName = ((AbstractButton) e.getSource()).getText();
		}
	}

	private final class IniciarAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				validateTeamSelection();
				validatePlayerName();
				TeamSelectionDialog.this.dispose();
			} catch (Exception e2) {
				GameDialogs.error(e2.getMessage());
			}
		}

		private void validatePlayerName() {
			if (textField.getText().isEmpty()) {
				throw new IllegalStateException(
						"Falta informar o nome do jogador!");
			}
		}

		private void validateTeamSelection() {
			if (selectedTeamName == null) {
				throw new IllegalStateException("Falta selecionar o time!");
			}
		}
	}

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private String selectedTeamName;
	private final TeamButtonAction teamButtonAction = new TeamButtonAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TeamSelectionDialog dialog = new TeamSelectionDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TeamSelectionDialog() {
		setSize(GameWindow.WIDTH, GameWindow.HEIGHT);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.YELLOW);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNome.setBounds(51, 54, 70, 15);
		contentPanel.add(lblNome);

		textField = new JTextField();
		textField.setBounds(51, 81, 323, 48);
		contentPanel.add(textField);
		textField.setColumns(10);

		JButton btnUnioSovitica = ButtonFactory.createJButton();
		btnUnioSovitica.setAction(teamButtonAction);
		btnUnioSovitica.setText(Teams.URSS.getName());
		btnUnioSovitica.setBounds(545, 268, 387, 102);
		contentPanel.add(btnUnioSovitica);

		JButton btnAlemanha = ButtonFactory.createJButton();
		btnAlemanha.setAction(teamButtonAction);
		btnAlemanha.setText(Teams.GERMANY.getName());
		btnAlemanha.setBounds(63, 268, 331, 102);
		contentPanel.add(btnAlemanha);

		JButton btnIniciar = ButtonFactory.createJButton();
		btnIniciar.setAction(new IniciarAction());
		btnIniciar.setText("Iniciar");
		btnIniciar.setBounds(662, 409, 272, 102);
		contentPanel.add(btnIniciar);

		JLabel lblFundo = new JLabel(new ImageIcon(R.load(R.FUNDO)));
		lblFundo.setBounds(0, -25, GameWindow.WIDTH, GameWindow.HEIGHT);
		contentPanel.add(lblFundo);
	}

	public String getSelectedTeamName() {
		return selectedTeamName;
	}

	public String getPlayerName() {
		return textField.getText();
	}
}
