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
import javax.swing.JSeparator;

public class frmResidencia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmResidencia frame = new frmResidencia();
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
	public frmResidencia() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCalculoEmKwh = new JLabel("Insira os dados requeridos:");
		lblCalculoEmKwh.setBounds(20, 11, 220, 14);
		contentPane.add(lblCalculoEmKwh);
		
		textField = new JTextField();
		textField.setBounds(250, 50, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblHrsDeUso = new JLabel("Hrs de uso mensal:");
		lblHrsDeUso.setBounds(20, 53, 220, 14);
		contentPane.add(lblHrsDeUso);
		
		JLabel lblPotenciaDoAparelho = new JLabel("M\u00E9dia da Potencia dos aparelhos:");
		lblPotenciaDoAparelho.setBounds(20, 97, 220, 14);
		contentPane.add(lblPotenciaDoAparelho);
		
		textField_1 = new JTextField();
		textField_1.setBounds(250, 94, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnResultadoEmKwh = new JButton("Resultado em kwh");
		btnResultadoEmKwh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    double x = Integer.parseInt(textField.getText()); 		//AQUI VAMOS PEGAR O textfield1 e colocar na variavel x
			    double y = Integer.parseInt(textField_1.getText()); 	//AQUI VAMOS PEGAR O textfield2 e colocar na variavel y
			    double z = x * y / 1000;                       			//DEPOIS IREMOS SOMAR OS 2 textfield E COLOCAR NA VARIAVEL Z
			    String msg = String.format("%.2f", z);

			   // btnResultadoEmKwh.setText(String.valueOf(z));   		//AGORA AQUI IREMOS COLOCAR A VARIAVEL Z no JButton btnResultadoEmKwh
			    
				JOptionPane.showMessageDialog(null, "O seu consumo mensal é de: " + msg + " kwh");
				
				File Ponto = new File("C://exemplo/Consumo na Residencia/Valor em Kwh.txt");

			    try {

			        FileWriter fw = new FileWriter(Ponto, true);
			        BufferedWriter bw = new BufferedWriter(fw);

			        bw.write("O seu consumo mensal é de: " + msg + " kwh");
			        bw.newLine();

			        bw.close();
			        fw.close();

			    } catch (IOException ex) {
			    	System.out.println ("Erro ao abrir o arquivo");
			    }
			}
		});
		btnResultadoEmKwh.setBounds(78, 156, 162, 23);
		contentPane.add(btnResultadoEmKwh);
		
		JButton btnResultadoEmR = new JButton("Resultado em R$");
		btnResultadoEmR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = Integer.parseInt(textField.getText()); 		//AQUI VAMOS PEGAR O textfield1 e colocar na variavel x
			    double y = Integer.parseInt(textField_1.getText()); 	//AQUI VAMOS PEGAR O textfield2 e colocar na variavel y
			    double z = x * y / 1000;                       			//DEPOIS IREMOS SOMAR OS 2 textfield E COLOCAR NA VARIAVEL Z

				double b = 0.69118; 
				double c = z * b;
				String msg = String.format("%.2f", c);
				
				JOptionPane.showMessageDialog(null, "O seu gasto mensal é de: R$ " + msg);
				
				File Ponto = new File("C://exemplo/Consumo na Residencia/Valor em R$.txt");
				
			    try {

			        FileWriter fw = new FileWriter(Ponto, true);
			        BufferedWriter bw = new BufferedWriter(fw);

			        bw.write("O seu gasto mensal é de: R$ " + msg);
			        bw.newLine();

			        bw.close();
			        fw.close();

			    } catch (IOException ex) {
			    	System.out.println ("Erro ao abrir o arquivo");
			    }
			}
		});
		btnResultadoEmR.setBounds(78, 203, 162, 23);
		contentPane.add(btnResultadoEmR);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(127, 156, 1, 2);
		contentPane.add(separator);
	}
}
