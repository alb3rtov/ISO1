package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameLogin extends JFrame{

	private JPanel contentPane;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLogin frame = new JFrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
		
	public JFrameLogin() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAnadirContenido = new JButton("Añadir contenido");
		btnAnadirContenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameAdministracion frame = new JFrameAdministracion();
				frame.setVisible(true);
			}
		});
		btnAnadirContenido.setBounds(120, 90, 200, 50);
		contentPane.add(btnAnadirContenido);
		
		JButton btnBuscarContenido = new JButton("Buscar contenido");
		btnBuscarContenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameContenido frame = new JFrameContenido();
				frame.setVisible(true);
			}
		});
		btnBuscarContenido.setBounds(120, 170, 200, 50);
		contentPane.add(btnBuscarContenido);
		
	}
}
	

