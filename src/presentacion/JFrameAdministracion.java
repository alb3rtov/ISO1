package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dominio.GestorAdministracion;

public class JFrameAdministracion extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldNumTemporadas;
	private JTextField textFieldFinalizada;
	private JTextField textFieldSaga;
	private JTextField textField3D;
	private JTextField textFieldFechaEstrenoCine;
	private JTextField textFieldTitulo;
	private JTextField textFieldFechaEstreno;
	private JTextField textFieldSinopsis;
	private JTextField textFieldActores;
	private JTextField textFieldDuracion;
	private JTextField textFieldPais;
	private JTextField textFieldGenero;
	private JTextField textFieldDirector;
	private JTextField textFieldIdContenido;
	private JTextPane textPane;
	
	public JFrameAdministracion() {
		setTitle("Añadir peliculas/series a la base de datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContenido = new JLabel("Introduzca los datos para añadir contenido");
		lblContenido.setBounds(6, 0, 250, 30);
		contentPane.add(lblContenido);
		
		//Campos para series y peliculas
		
		JLabel lblnumTemporadas= new JLabel("Numero temporadas: ");
		lblnumTemporadas.setBounds(7, 320, 150, 30);
		contentPane.add(lblnumTemporadas);
		lblnumTemporadas.setVisible(false);
		
		textFieldNumTemporadas = new JTextField();
		textFieldNumTemporadas.setBounds(7, 347, 134, 28);
		contentPane.add(textFieldNumTemporadas);
		textFieldNumTemporadas.setColumns(10);
		textFieldNumTemporadas.setVisible(false);
		
		JLabel lblfinalizada= new JLabel("Finalizada (true/false): ");
		lblfinalizada.setBounds(7, 370, 150, 30);
		contentPane.add(lblfinalizada);
		lblfinalizada.setVisible(false);
		
		textFieldFinalizada = new JTextField();
		textFieldFinalizada.setBounds(7, 397, 134, 28);
		contentPane.add(textFieldFinalizada);
		textFieldFinalizada.setColumns(10);
		textFieldFinalizada.setVisible(false);
		
		JLabel lblsaga= new JLabel("Saga: ");
		lblsaga.setBounds(7, 320, 150, 30);
		contentPane.add(lblsaga);
		lblsaga.setVisible(false);
		
		textFieldSaga = new JTextField();
		textFieldSaga.setBounds(7, 347, 134, 28);
		contentPane.add(textFieldSaga);
		textFieldSaga.setColumns(10);
		textFieldSaga.setVisible(false);

		JLabel lbl3D= new JLabel("3D (true/false): ");
		lbl3D.setBounds(7, 370, 150, 30);
		contentPane.add(lbl3D);
		lbl3D.setVisible(false);
		
		textField3D = new JTextField();
		textField3D.setBounds(7, 397, 134, 28);
		contentPane.add(textField3D);
		textField3D.setColumns(10);
		textField3D.setVisible(false);
			
		JLabel lblFechaEstrenoCine= new JLabel("Fecha estreno cine: ");
		lblFechaEstrenoCine.setBounds(200, 370, 150, 30);
		contentPane.add(lblFechaEstrenoCine);
		lblFechaEstrenoCine.setVisible(false);
		
		textFieldFechaEstrenoCine = new JTextField();
		textFieldFechaEstrenoCine.setBounds(200, 397, 134, 28);
		contentPane.add(textFieldFechaEstrenoCine);
		textFieldFechaEstrenoCine.setColumns(10);
		textFieldFechaEstrenoCine.setVisible(false);
		
		JLabel lbltipo= new JLabel("Tipo: ");
		lbltipo.setBounds(6, 25, 150, 30);
		contentPane.add(lbltipo);
		
		JRadioButton rbtn1=new JRadioButton("serie",false);
		JRadioButton rbtn2=new JRadioButton("pelicula",false);
		
		rbtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Desactivar campos pelicula
				lblFechaEstrenoCine.setVisible(false);
				textFieldFechaEstrenoCine.setVisible(false);
				textField3D.setVisible(false);
				lblsaga.setVisible(false);
				textFieldSaga.setVisible(false);
				lbl3D.setVisible(false);
				//Activar campos serie
				textFieldFinalizada.setVisible(true);
				textFieldNumTemporadas.setVisible(true);
				lblnumTemporadas.setVisible(true);
				lblfinalizada.setVisible(true);
				
				}
		});
		
		rbtn2.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				//Desactivar campos serie
				textFieldFinalizada.setVisible(false);
				textFieldNumTemporadas.setVisible(false);
				lblnumTemporadas.setVisible(false);
				lblfinalizada.setVisible(false);
				//Activar campos pelicula
				textFieldSaga.setVisible(true);
				lblsaga.setVisible(true);
				lbl3D.setVisible(true);
				textField3D.setVisible(true);
				textFieldFechaEstrenoCine.setVisible(true);
				lblFechaEstrenoCine.setVisible(true);
			}
		});
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rbtn1);
		grupo1.add(rbtn2);

		rbtn1.setBounds(6, 50, 150, 30);
		contentPane.add(rbtn1);
		rbtn2.setBounds(6, 70, 150, 30);
		contentPane.add(rbtn2);
		
		JLabel lbltitulo = new JLabel("Titulo: ");
		lbltitulo.setBounds(6, 95, 150, 30);
		contentPane.add(lbltitulo);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(7, 122, 134, 28);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);	
		
		JLabel lblfechaEstreno = new JLabel("Fecha estreno (yyyy/mm/dd): ");
		lblfechaEstreno.setBounds(6, 150, 200, 30);
		contentPane.add(lblfechaEstreno);

		textFieldFechaEstreno = new JTextField();
		textFieldFechaEstreno.setBounds(7, 177, 134, 28);
		contentPane.add(textFieldFechaEstreno);
		textFieldFechaEstreno.setColumns(10);
		
		JLabel lblsinopsis = new JLabel("Sinopsis: ");
		lblsinopsis.setBounds(6, 205, 150, 30);
		contentPane.add(lblsinopsis);

		textFieldSinopsis = new JTextField();
		textFieldSinopsis.setBounds(7, 232, 134, 28);
		contentPane.add(textFieldSinopsis);
		textFieldSinopsis.setColumns(10);
		
		JLabel lblactores = new JLabel("Actores: ");
		lblactores.setBounds(6, 260, 150, 30);
		contentPane.add(lblactores);
		
		textFieldActores = new JTextField();
		textFieldActores.setBounds(7, 287, 134, 28);
		contentPane.add(textFieldActores);
		textFieldActores.setColumns(10);
		
		JLabel lblidContenido = new JLabel("ID Contenido: ");
		lblidContenido.setBounds(200, 95, 150, 30);
		contentPane.add(lblidContenido);
		
		textFieldIdContenido = new JTextField();
		textFieldIdContenido.setBounds(201, 122, 134, 28);
		contentPane.add(textFieldIdContenido);
		textFieldIdContenido.setColumns(10);
		
		JLabel lblpais = new JLabel("Pais (ESP): ");
		lblpais.setBounds(200, 150, 200, 30);
		contentPane.add(lblpais);

		textFieldPais= new JTextField();
		textFieldPais.setBounds(201, 177, 134, 28);
		contentPane.add(textFieldPais);
		textFieldPais.setColumns(10);
		
		JLabel lblgenero = new JLabel("Genero: ");
		lblgenero.setBounds(200, 205, 150, 30);
		contentPane.add(lblgenero);

		textFieldGenero = new JTextField();
		textFieldGenero.setBounds(201, 232, 134, 28);
		contentPane.add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		JLabel lbldirector = new JLabel("Director: ");
		lbldirector.setBounds(200, 260, 150, 30);
		contentPane.add(lbldirector);
		
		textFieldDirector = new JTextField();
		textFieldDirector.setBounds(201, 287, 134, 28);
		contentPane.add(textFieldDirector);
		textFieldDirector.setColumns(10);
		
		JLabel lblduracion = new JLabel("Duracion: ");
		lblduracion.setBounds(200, 320, 150, 30);
		contentPane.add(lblduracion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(200, 347, 134, 28);
		contentPane.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JButton buttonAnadir = new JButton("Añadir");
		buttonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean insertado = false;
				
				
				if (rbtn1.isSelected()) {
					
					try {
						insertado = GestorAdministracion.anadirContenido(textFieldIdContenido.getText(),textFieldTitulo.getText(), textFieldFechaEstreno.getText(), 
								textFieldSinopsis.getText(), textFieldActores.getText(), textFieldDuracion.getText(), 
								textFieldPais.getText(), textFieldGenero.getText(), textFieldDirector.getText(), textFieldNumTemporadas.getText(), textFieldFinalizada.getText());
						
					} catch (Exception e) {
						textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
					}
					
					if (insertado) {
						textPane.setText("Serie añadida");
					} else {
						textPane.setText("Ha ocurrido un error durante la inserción");
					}
					
				} else if (rbtn2.isSelected()) {
					

					try {
						insertado = GestorAdministracion.anadirContenido(textFieldIdContenido.getText(), textFieldTitulo.getText(), textFieldFechaEstreno.getText(), 
								textFieldSinopsis.getText(), textFieldActores.getText(), textFieldDuracion.getText(), 
								textFieldPais.getText(), textFieldGenero.getText(), textFieldDirector.getText(),
								textFieldSaga.getText(), textField3D.getText(), textFieldFechaEstrenoCine.getText());
						
					} catch (Exception e) {
						textPane.setText("Ha ocurrido un error, vuelva a intentarlo" + e.toString());
					}
					
					if (insertado) {
						textPane.setText("Pelicula añadida");
					} else {
						textPane.setText("Ha ocurrido un error durante la inserción");
					}
					
				} else {
					textPane.setText("Debe seleccionar un tipo de contenido");
				}
			}
		});

		buttonAnadir.setBounds(200, 50, 148, 29);
		contentPane.add(buttonAnadir);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el resultado de la comprobaci\u00F3n de buscar contenido o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 440, 350, 80);
		contentPane.add(textPane);
	}
}
