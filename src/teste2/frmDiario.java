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

public class frmDiario extends JFrame {

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
					frmDiario frame = new frmDiario();
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
	public frmDiario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados requeridos:");
		lblInsiraOsDados.setBounds(66, 11, 243, 14);
		contentPane.add(lblInsiraOsDados);
		
		JLabel lblHrsDeUso = new JLabel("Hrs de uso mensal dos aparelhos:");
		lblHrsDeUso.setBounds(30, 56, 235, 14);
		contentPane.add(lblHrsDeUso);
		
		JLabel lblMdiaDaPotencia = new JLabel("M\u00E9dia da Potencia dos aparelhos:");
		lblMdiaDaPotencia.setBounds(30, 113, 214, 14);
		contentPane.add(lblMdiaDaPotencia);
		
		textField = new JTextField();
		textField.setBounds(311, 53, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(311, 110, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnResultadoEmKwh = new JButton("Resultado em Kwh");
		btnResultadoEmKwh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = Integer.parseInt(textField.getText()); 		//AQUI VAMOS PEGAR O textfield1 e colocar na variavel x
			    double y = Integer.parseInt(textField_1.getText()); 	//AQUI VAMOS PEGAR O textfield2 e colocar na variavel y
			    double z = x * y / 1000 /30;                       			//DEPOIS IREMOS SOMAR OS 2 textfield E COLOCAR NA VARIAVEL Z
			    String msg = String.format("%.2f", z);
							    
				// btnResultadoEmKwh.setText(String.valueOf(z));   		//AGORA AQUI IREMOS COLOCAR A VARIAVEL Z no JButton btnResultadoEmKwh
			    
				JOptionPane.showMessageDialog(null, "O seu consumo mensal na cômodo é de: " + msg + " kwh");
				
				File Ponto = new File("C://exemplo/Consumo Diario/Valor em Kwh.txt");

			    try {

			        FileWriter fw = new FileWriter(Ponto, true);
			        BufferedWriter bw = new BufferedWriter(fw);

			        bw.write("O seu consumo mensal na cômodo é de: " + msg + " kwh");
			        bw.newLine();

			        bw.close();
			        fw.close();

			    } catch (IOException ex) {
			    	System.out.println ("Erro ao abrir o arquivo");
			    }
			    
			}
		});
		btnResultadoEmKwh.setBounds(130, 170, 179, 23);
		contentPane.add(btnResultadoEmKwh);
		
		JButton btnResultadoEmR = new JButton("Resultado em R$");
		btnResultadoEmR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = Integer.parseInt(textField.getText()); 		//AQUI VAMOS PEGAR O textfield1 e colocar na variavel x
			    double y = Integer.parseInt(textField_1.getText()); 	//AQUI VAMOS PEGAR O textfield2 e colocar na variavel y
			    double z = x * y / 1000;                       			//DEPOIS IREMOS SOMAR OS 2 textfield E COLOCAR NA VARIAVEL Z

				double b = 0.69118; 
				double c = z * b / 30;
				String msg = String.format("%.2f", c);
				
				JOptionPane.showMessageDialog(null, "O seu gasto mensal é de: R$ " + msg);
				
				File Ponto = new File("C://exemplo/Consumo Diario/Valor em R$.txt");

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
		btnResultadoEmR.setBounds(130, 228, 179, 23);
		contentPane.add(btnResultadoEmR);
	}

}
