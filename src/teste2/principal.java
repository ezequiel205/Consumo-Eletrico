package teste2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCalculo = new JMenu("Menu");
		menuBar.add(mnCalculo);
		
		JMenu mnMensal = new JMenu("C\u00E1lculo Mensal");
		mnCalculo.add(mnMensal);
		
		JMenuItem mntmResidencia = new JMenuItem("Residencia completa");
		mntmResidencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmResidencia principal = new frmResidencia(); 
				principal.setVisible(true);
			}
		});
		mnMensal.add(mntmResidencia);
		
		JMenuItem mntmPorItem = new JMenuItem("Por Aparelho");
		mntmPorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmItem principal = new frmItem(); 
				principal.setVisible(true);
			}
		});
		mnMensal.add(mntmPorItem);
		
		JMenuItem mntmPorComodo = new JMenuItem("Por c\u00F4modo");
		mntmPorComodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmComodo principal = new frmComodo(); 
				principal.setVisible(true);
			}
		});
		mnMensal.add(mntmPorComodo);
		
		JMenuItem mntmDiario = new JMenuItem("C\u00E1lculo Diario");
		mntmDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDiario principal = new frmDiario(); 
				principal.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		mnCalculo.add(separator);
		mnCalculo.add(mntmDiario);
		
		JSeparator separator_1 = new JSeparator();
		mnCalculo.add(separator_1);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(EXIT_ON_CLOSE);
				
			}
		});
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSobre principal = new frmSobre(); 
				principal.setVisible(true); 
			}
		});
		mnCalculo.add(mntmSobre);
		
		JSeparator separator_2 = new JSeparator();
		mnCalculo.add(separator_2);
		mnCalculo.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
