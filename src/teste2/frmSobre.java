package teste2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class frmSobre extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSobre frame = new frmSobre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmSobre() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><center>Produzido por Ezequiel Santos de Almeida<br>Para saber mais sobre as taxas utilizadas para os c\u00E1lculos, acesse;</br><br><i>https://bit.ly/1GsDLtF</i></center></br></html>");
		lblNewLabel.setBounds(31, 11, 379, 71);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//private void BconfirmarActionPerformed(java.awt.event.ActionEvent evt) {
				    File Ponto = new File("C://exemplo/Sobre/Sobre.txt");

				    try {

				        FileWriter fw = new FileWriter(Ponto, true);
				        BufferedWriter bw = new BufferedWriter(fw);

				        bw.write(textField.getText());
				        bw.newLine();

				        bw.close();
				        fw.close();

				    } catch (IOException ex) {
				    }

				}
		});
		textField.setBounds(44, 147, 295, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDeixeSuaMensagem = new JLabel("<html>Voc\u00EA tem elogios ou algo \u00E0 acrescentar ao nosso sistema?<br>Deixe uma mensagem abaixo;</br></html>");
		lblDeixeSuaMensagem.setBounds(41, 93, 339, 43);
		contentPane.add(lblDeixeSuaMensagem);
		
		JLabel lblObsParaQue = new JLabel("<html>Obs: Para que sua mensagem seja gravada;<br>Ap\u00F3s digit\u00E1-la aperte a tecla enter.<br><center>Obrigado!! </center></html>");
		lblObsParaQue.setBounds(54, 193, 285, 58);
		contentPane.add(lblObsParaQue);
	}

}
