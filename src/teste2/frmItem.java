package teste2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class frmItem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmItem frame = new frmItem();
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
	public frmItem() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados requeridos:");
		lblInsiraOsDados.setBounds(109, 11, 232, 14);
		contentPane.add(lblInsiraOsDados);
		
		JLabel lblHrsDeUso = new JLabel("Hrs de uso mensal do aparelho:");
		lblHrsDeUso.setBounds(22, 98, 215, 14);
		contentPane.add(lblHrsDeUso);
		
		JLabel lblPotenciaDoAparelho = new JLabel("Potencia do aparelho:");
		lblPotenciaDoAparelho.setBounds(22, 141, 215, 14);
		contentPane.add(lblPotenciaDoAparelho);
		
		textField = new JTextField();
		textField.setBounds(288, 95, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(288, 138, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnResultadoEmKwh = new JButton("Resultado em Kwh");
		btnResultadoEmKwh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = Integer.parseInt(textField.getText()); 		//AQUI VAMOS PEGAR O textfield1 e colocar na variavel x
			    double y = Integer.parseInt(textField_1.getText()); 	//AQUI VAMOS PEGAR O textfield2 e colocar na variavel y
			    double z = x * y / 1000;                       			//DEPOIS IREMOS SOMAR OS 2 textfield E COLOCAR NA VARIAVEL Z
			    String msg = String.format("%.2f", z);

			    // btnResultadoEmKwh.setText(String.valueOf(z));   		//AGORA AQUI IREMOS COLOCAR A VARIAVEL Z no JButton btnResultadoEmKwh
			    
				JOptionPane.showMessageDialog(null, "O seu consumo mensal do Item " + textField_2.getText() + " é de: " + msg + " kwh");
				
				File Ponto = new File("C://exemplo/Consumo por Item/Valor em Kwh.txt");

			    try {

			        FileWriter fw = new FileWriter(Ponto, true);
			        BufferedWriter bw = new BufferedWriter(fw);

			        bw.write("O seu consumo mensal do Item " + textField_2.getText() + " é de: " + msg + " kwh");
			        bw.newLine();

			        bw.close();
			        fw.close();

			    } catch (IOException ex) {
			    	System.out.println ("Erro ao abrir o arquivo");
			    }
			}
		});
		btnResultadoEmKwh.setBounds(109, 194, 225, 23);
		contentPane.add(btnResultadoEmKwh);
		
		JButton btnResultadoEmR = new JButton("Resultado em R$");
		btnResultadoEmR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = Integer.parseInt(textField.getText()); 		//AQUI VAMOS PEGAR O textfield1 e colocar na variavel x
			    double y = Integer.parseInt(textField_1.getText()); 	//AQUI VAMOS PEGAR O textfield2 e colocar na variavel y
			    double z = x * y / 1000;                       			//DEPOIS IREMOS SOMAR OS 2 textfield E COLOCAR NA VARIAVEL Z

				double b = 0.69118; // 0,69118 ou 0,69118
				double c = z * b;
				String msg = String.format("%.2f", c);
				
				JOptionPane.showMessageDialog(null, "O seu gato mensal com o Item " + textField_2.getText() + " é de: R$ " + msg);
				
				File Ponto = new File("C://exemplo/Consumo por Item/Valor em R$.txt");

			    try {

			        FileWriter fw = new FileWriter(Ponto, true);
			        BufferedWriter bw = new BufferedWriter(fw);

			        bw.write("O seu gato mensal com o Item " + textField_2.getText() + " é de: R$ " + msg);
			        bw.newLine();

			        bw.close();
			        fw.close();

			    } catch (IOException ex) {
			    	System.out.println ("Erro ao abrir o arquivo");
			    }
			}
		});
		btnResultadoEmR.setBounds(109, 228, 225, 23);
		contentPane.add(btnResultadoEmR);
		
		JLabel lblNomeDoAparelho = new JLabel("Nome do aparelho:");
		lblNomeDoAparelho.setBounds(22, 50, 166, 14);
		contentPane.add(lblNomeDoAparelho);
		
		textField_2 = new JTextField();
		textField_2.setBounds(288, 45, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
