package teste2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class frmComodo extends JFrame {

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
					frmComodo frame = new frmComodo();
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
	public frmComodo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscolhaOsItens = new JLabel("Insira os dados requeridos:");
		lblEscolhaOsItens.setBounds(76, 11, 348, 14);
		contentPane.add(lblEscolhaOsItens);
		
		JButton btnResultadoEmKwh = new JButton("Resultado em Kwh");
		btnResultadoEmKwh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = Integer.parseInt(textField.getText()); 		//AQUI VAMOS PEGAR O textfield1 e colocar na variavel x
			    double y = Integer.parseInt(textField_1.getText()); 	//AQUI VAMOS PEGAR O textfield2 e colocar na variavel y
			    double z = x * y / 1000;                       			//DEPOIS IREMOS SOMAR OS 2 textfield E COLOCAR NA VARIAVEL Z
			    String msg = String.format("%.2f", z);
				
			    // btnResultadoEmKwh.setText(String.valueOf(z));   		//AGORA AQUI IREMOS COLOCAR A VARIAVEL Z no JButton btnResultadoEmKwh
			    
				JOptionPane.showMessageDialog(null, "O seu consumo mensal no cômodo " + textField_2.getText() + " é de: " + msg + " kwh");
				
				File Ponto = new File("C://exemplo/Consumo por Comodo/Valor em Kwh.txt");

			    try {

			        FileWriter fw = new FileWriter(Ponto, true);
			        BufferedWriter bw = new BufferedWriter(fw);

			        bw.write("O seu consumo mensal no cômodo " + textField_2.getText() + " é de: " + msg + " kwh");
			        bw.newLine();

			        bw.close();
			        fw.close();

			    } catch (IOException ex) {
			    	System.out.println ("Erro ao abrir o arquivo");
			    }
			}
		});
		btnResultadoEmKwh.setBounds(121, 194, 195, 23);
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
				
				JOptionPane.showMessageDialog(null, "O seu gasto mensal no cômodo " + textField_2.getText() + " é de: R$ " + msg);
			
				File Ponto = new File("C://exemplo/Consumo por Comodo/Valor em R$.txt");

			    try {

			        FileWriter fw = new FileWriter(Ponto, true);
			        BufferedWriter bw = new BufferedWriter(fw);

			        bw.write("O seu gasto mensal no cômodo " + textField_2.getText() + " é de: R$ " + msg);
			        bw.newLine();

			        bw.close();
			        fw.close();

			    } catch (IOException ex) {
			    	System.out.println ("Erro ao abrir o arquivo");
			    }
			}
		});
		btnResultadoEmR.setBounds(121, 228, 195, 23);
		contentPane.add(btnResultadoEmR);
		
		JLabel lblHrsDeUso = new JLabel("Hrs de uso mensal dos aparelhos no comodo:");
		lblHrsDeUso.setBounds(23, 94, 277, 14);
		contentPane.add(lblHrsDeUso);
		
		textField = new JTextField();
		textField.setBounds(310, 91, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTeet = new JLabel("M\u00E9dia da Potencia dos aparelhos:");
		lblTeet.setBounds(23, 140, 227, 14);
		contentPane.add(lblTeet);
		
		textField_1 = new JTextField();
		textField_1.setBounds(310, 137, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNomeDoCmodo = new JLabel("Nome do c\u00F4modo:");
		lblNomeDoCmodo.setBounds(23, 52, 195, 14);
		contentPane.add(lblNomeDoCmodo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(310, 49, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
