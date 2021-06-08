package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dominio.Contenido;
import dominio.GestorContenido;

public class JFrameContenido extends JFrame{
	
	private JPanel contentPane;
	private JTextField textFieldContenido;
	private JTextPane textPane;
	
	public JFrameContenido() {
		setTitle("Buscar peliculas/series a la base de datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContenido = new JLabel("Buscar contenido: ");
		lblContenido.setBounds(6, 37, 150, 30);
		contentPane.add(lblContenido);
		
		textFieldContenido = new JTextField();
		textFieldContenido.setBounds(120, 37, 134, 28);
		contentPane.add(textFieldContenido);
		textFieldContenido.setColumns(10);
		
		JButton btnBuscarContenido = new JButton("Buscar contenido");
		btnBuscarContenido.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if (textFieldContenido.getText().length() != 0) { 
					try {
						ArrayList<Contenido> contenidoEncontrado =  new ArrayList<Contenido>();
						ArrayList<String> titulos = new ArrayList<String>();
						contenidoEncontrado = GestorContenido.buscarContenido(textFieldContenido.getText());
						
						String cadenaTitulos = "";
						textPane.setText("");
						
						for (int i = 0; i < contenidoEncontrado.size(); i++) {
							titulos.add(contenidoEncontrado.get(i).getTitulo());
						}
						for (int j = 0; j < titulos.size(); j++) {
							cadenaTitulos += titulos.get(j) + "\n";
						}

						if (cadenaTitulos.length() != 0) {
							textPane.setText(cadenaTitulos);
						} else {
							textPane.setText("No se han encontrado resultados");
						}
						

					} catch (Exception e) {
						textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
					}
				} else {
					textPane.setText("Introduzca algun caracter");
				}


			}
		});
		
		btnBuscarContenido.setBounds(20, 76, 160, 29);
		contentPane.add(btnBuscarContenido);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el resultado de la comprobaci\u00F3n de buscar contenido o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 154, 407, 102);
		contentPane.add(textPane);
	}
}
