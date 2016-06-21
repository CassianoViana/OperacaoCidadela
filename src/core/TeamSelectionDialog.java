package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import resources.R;
import core.view.ButtonFactory;

public class TeamSelectionDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

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
		lblNome.setBounds(439, 94, 70, 15);
		contentPanel.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(316, 127, 323, 48);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnUnioSovitica = ButtonFactory.createJButton();
		btnUnioSovitica.setText("UNIÃO SOVIÉTICA");
		btnUnioSovitica.setFont(new Font("Khmer OS", Font.BOLD, 37));
		btnUnioSovitica.setBounds(545, 268, 387, 102);
		contentPanel.add(btnUnioSovitica);
		
		JButton btnAlemanha = ButtonFactory.createJButton();
		btnAlemanha.setText("ALEMANHA");
		btnAlemanha.setFont(new Font("Khmer OS", Font.BOLD, 37));
		btnAlemanha.setBounds(63, 268, 331, 102);
		contentPanel.add(btnAlemanha);
		
		JButton btnIniciar = ButtonFactory.createJButton();
		
		btnIniciar.setText("INICIAR");
		btnIniciar.setFont(new Font("Khmer OS", Font.BOLD, 37));
		btnIniciar.setBounds(695, 409, 272, 102);
		contentPanel.add(btnIniciar);
		
		JLabel lblFundo = new JLabel(new ImageIcon(R.load(R.FUNDO)));
		lblFundo.setBounds(0, -25, GameWindow.WIDTH, GameWindow.HEIGHT);
		contentPanel.add(lblFundo);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
		}
	}
}
