package tprac;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1261530724857466122L;

	private Integer xx = 0, yy = 0;
	private static Integer clicks = 0;

	private JFrame frame;
	private JLabel lbMover;
	private JLabel lbRecuadroReglas;
	private JLabel lbCerrar;
	private JLabel lbMinimizar;
	private JLabel lbResultado;
	private JLabel lbTituloReglas;
	private JLabel lbReglas;
	private JLabel lbGifCelebracion;
	private JLabel lbFondo;

	private JTextField tF1_1;
	private JTextField tF1_2;
	private JTextField tF1_3;
	private JTextField tF1_4;
	private JTextField tF2_1;
	private JTextField tF2_2;
	private JTextField tF2_3;
	private JTextField tF2_4;
	private JTextField tF3_1;
	private JTextField tF3_2;
	private JTextField tF3_3;
	private JTextField tF3_4;
	private JTextField tF4_1;
	private JTextField tF4_2;
	private JTextField tF4_3;
	private JTextField tF4_4;

	private JButton btnVerificar;
	private JButton btnBorrar;
	private JButton btnJuegoNuevo;
	private JButton btnReglas;

	private JDialog frameReglas;
	private JDialog frameWinner;

	private static Map<String, ArrayList<JTextField>> grupoInputsUsr;
	private static Map<String, JLabel> lblsFilas;
	private static Map<String, JLabel> lblsColumnas;

	private ArrayList<JTextField> txfsFila1;
	private ArrayList<JTextField> txfsFila2;
	private ArrayList<JTextField> txfsFila3;
	private ArrayList<JTextField> txfsFila4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interfaz() {
		inicializar();
	}

	private void inicializar() {
		frames();
		botones();
		textFields();
		labels();
		eventos();
	}

	private void frames() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/tprac/Imgs/icon.png")));
		frame.getContentPane().setBackground(new Color(51, 51, 102));
		frame.setBounds(0, 0, 640, 480);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		frameReglas = new JDialog(frame, "");
		frameReglas.getContentPane().setBackground(new Color(51, 51, 102));
		frameReglas.setBounds(frame.getX() + 650, frame.getY(), 215, 480);
		frameReglas.setUndecorated(true);
		frameReglas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		frameWinner = new JDialog(frame, "");
		frameWinner.getContentPane().setBackground(new Color(51, 51, 102));
		frameWinner.setBounds(frame.getX() + 80, frame.getY() - 210, 480, 200);
		frameWinner.setUndecorated(true);
		frameWinner.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	private void botones() {

		btnReglas = new JButton("instrucciones");
		btnReglas.setOpaque(false);
		btnReglas.setForeground(Color.WHITE);
		btnReglas.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		btnReglas.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnReglas.setBackground(Color.BLACK);
		btnReglas.setBounds(49, 425, 121, 29);
		frame.getContentPane().add(btnReglas);

		btnBorrar = new JButton("borrar");
		btnBorrar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnBorrar.setOpaque(false);
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setBackground(Color.BLACK);
		btnBorrar.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		btnBorrar.setBounds(197, 425, 111, 29);
		frame.getContentPane().add(btnBorrar);

		btnJuegoNuevo = new JButton("juego nuevo");
		btnJuegoNuevo.setOpaque(false);
		btnJuegoNuevo.setForeground(Color.WHITE);
		btnJuegoNuevo.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		btnJuegoNuevo.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnJuegoNuevo.setBackground(Color.BLACK);
		btnJuegoNuevo.setBounds(335, 425, 115, 29);
		frame.getContentPane().add(btnJuegoNuevo);

		btnVerificar = new JButton("verificar");
		btnVerificar.setOpaque(false);
		btnVerificar.setForeground(Color.WHITE);
		btnVerificar.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		btnVerificar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnVerificar.setBackground(Color.BLACK);
		btnVerificar.setBounds(473, 425, 115, 29);
		frame.getContentPane().add(btnVerificar);
	}

	private void textFields() {
		grupoInputsUsr = new HashMap<String, ArrayList<JTextField>>();
		txfsFila1 = new ArrayList<JTextField>();
		txfsFila2 = new ArrayList<JTextField>();
		txfsFila3 = new ArrayList<JTextField>();
		txfsFila4 = new ArrayList<JTextField>();
		////////////////////////////////////////
		tF1_1 = new JTextField();
		tF1_1.setForeground(new Color(255, 255, 255));
		tF1_1.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF1_1.setHorizontalAlignment(SwingConstants.CENTER);
		tF1_1.setOpaque(false);
		tF1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF1_1.setBounds(182, 126, 45, 40);
		frame.getContentPane().add(tF1_1);
		tF1_1.setColumns(10);

		tF1_2 = new JTextField();
		tF1_2.setForeground(new Color(255, 255, 255));
		tF1_2.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF1_2.setHorizontalAlignment(SwingConstants.CENTER);
		tF1_2.setOpaque(false);
		tF1_2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF1_2.setBounds(248, 126, 45, 40);
		tF1_2.setColumns(10);
		frame.getContentPane().add(tF1_2);

		tF1_3 = new JTextField();
		tF1_3.setForeground(new Color(255, 255, 255));
		tF1_3.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF1_3.setHorizontalAlignment(SwingConstants.CENTER);
		tF1_3.setOpaque(false);
		tF1_3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF1_3.setBounds(318, 126, 45, 40);
		tF1_3.setColumns(10);
		frame.getContentPane().add(tF1_3);

		tF1_4 = new JTextField();
		tF1_4.setForeground(new Color(255, 255, 255));
		tF1_4.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF1_4.setHorizontalAlignment(SwingConstants.CENTER);
		tF1_4.setOpaque(false);
		tF1_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF1_4.setBounds(388, 125, 45, 40);
		tF1_4.setColumns(10);
		frame.getContentPane().add(tF1_4);

		txfsFila1.add(tF1_1);
		txfsFila1.add(tF1_2);
		txfsFila1.add(tF1_3);
		txfsFila1.add(tF1_4);
		grupoInputsUsr.put("f1", txfsFila1);
		////////////////////////////////////////
		tF2_1 = new JTextField();
		tF2_1.setForeground(new Color(255, 255, 255));
		tF2_1.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF2_1.setHorizontalAlignment(SwingConstants.CENTER);
		tF2_1.setOpaque(false);
		tF2_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF2_1.setColumns(10);
		tF2_1.setBounds(182, 183, 45, 40);
		frame.getContentPane().add(tF2_1);

		tF2_2 = new JTextField();
		tF2_2.setForeground(new Color(255, 255, 255));
		tF2_2.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF2_2.setHorizontalAlignment(SwingConstants.CENTER);
		tF2_2.setOpaque(false);
		tF2_2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF2_2.setColumns(10);
		tF2_2.setBounds(248, 183, 45, 40);
		frame.getContentPane().add(tF2_2);

		tF2_3 = new JTextField();
		tF2_3.setForeground(new Color(255, 255, 255));
		tF2_3.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF2_3.setHorizontalAlignment(SwingConstants.CENTER);
		tF2_3.setOpaque(false);
		tF2_3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF2_3.setColumns(10);
		tF2_3.setBounds(318, 183, 45, 40);
		frame.getContentPane().add(tF2_3);

		tF2_4 = new JTextField();
		tF2_4.setForeground(new Color(255, 255, 255));
		tF2_4.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF2_4.setHorizontalAlignment(SwingConstants.CENTER);
		tF2_4.setOpaque(false);
		tF2_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF2_4.setColumns(10);
		tF2_4.setBounds(388, 183, 45, 40);
		frame.getContentPane().add(tF2_4);

		txfsFila2.add(tF2_1);
		txfsFila2.add(tF2_2);
		txfsFila2.add(tF2_3);
		txfsFila2.add(tF2_4);
		grupoInputsUsr.put("f2", txfsFila2);
		////////////////////////////////////////
		tF3_1 = new JTextField();
		tF3_1.setForeground(new Color(255, 255, 255));
		tF3_1.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF3_1.setHorizontalAlignment(SwingConstants.CENTER);
		tF3_1.setOpaque(false);
		tF3_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF3_1.setColumns(10);
		tF3_1.setBounds(182, 242, 45, 40);
		frame.getContentPane().add(tF3_1);

		tF3_2 = new JTextField();
		tF3_2.setForeground(new Color(255, 255, 255));
		tF3_2.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF3_2.setHorizontalAlignment(SwingConstants.CENTER);
		tF3_2.setOpaque(false);
		tF3_2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF3_2.setColumns(10);
		tF3_2.setBounds(248, 242, 45, 40);
		frame.getContentPane().add(tF3_2);

		tF3_3 = new JTextField();
		tF3_3.setForeground(new Color(255, 255, 255));
		tF3_3.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF3_3.setHorizontalAlignment(SwingConstants.CENTER);
		tF3_3.setOpaque(false);
		tF3_3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF3_3.setColumns(10);
		tF3_3.setBounds(318, 242, 45, 40);
		frame.getContentPane().add(tF3_3);

		tF3_4 = new JTextField();
		tF3_4.setForeground(new Color(255, 255, 255));
		tF3_4.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF3_4.setHorizontalAlignment(SwingConstants.CENTER);
		tF3_4.setOpaque(false);
		tF3_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF3_4.setColumns(10);
		tF3_4.setBounds(388, 242, 45, 40);
		frame.getContentPane().add(tF3_4);

		txfsFila3.add(tF3_1);
		txfsFila3.add(tF3_2);
		txfsFila3.add(tF3_3);
		txfsFila3.add(tF3_4);
		grupoInputsUsr.put("f3", txfsFila3);
		////////////////////////////////////////
		tF4_1 = new JTextField();
		tF4_1.setForeground(new Color(255, 255, 255));
		tF4_1.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF4_1.setHorizontalAlignment(SwingConstants.CENTER);
		tF4_1.setOpaque(false);
		tF4_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF4_1.setColumns(10);
		tF4_1.setBounds(182, 300, 45, 40);
		frame.getContentPane().add(tF4_1);

		tF4_2 = new JTextField();
		tF4_2.setForeground(new Color(255, 255, 255));
		tF4_2.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF4_2.setHorizontalAlignment(SwingConstants.CENTER);
		tF4_2.setOpaque(false);
		tF4_2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF4_2.setColumns(10);
		tF4_2.setBounds(248, 300, 45, 40);
		frame.getContentPane().add(tF4_2);

		tF4_3 = new JTextField();
		tF4_3.setForeground(new Color(255, 255, 255));
		tF4_3.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF4_3.setHorizontalAlignment(SwingConstants.CENTER);
		tF4_3.setOpaque(false);
		tF4_3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF4_3.setColumns(10);
		tF4_3.setBounds(318, 300, 45, 40);
		frame.getContentPane().add(tF4_3);

		tF4_4 = new JTextField();
		tF4_4.setForeground(new Color(255, 255, 255));
		tF4_4.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		tF4_4.setHorizontalAlignment(SwingConstants.CENTER);
		tF4_4.setOpaque(false);
		tF4_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 24));
		tF4_4.setColumns(10);
		tF4_4.setBounds(388, 300, 45, 40);
		frame.getContentPane().add(tF4_4);

		txfsFila4.add(tF4_1);
		txfsFila4.add(tF4_2);
		txfsFila4.add(tF4_3);
		txfsFila4.add(tF4_4);
		grupoInputsUsr.put("f4", txfsFila4);
		////////////////////////////////////////
	}

	private void labels() {

		lbCerrar = new JLabel("X");
		lbCerrar.setBounds(613, 0, 17, 29);
		lbCerrar.setForeground(new Color(255, 255, 255));
		lbCerrar.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 22));
		frame.getContentPane().add(lbCerrar);

		lbMinimizar = new JLabel("----");
		lbMinimizar.setBounds(586, 0, 17, 29);
		lbMinimizar.setForeground(Color.WHITE);
		lbMinimizar.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 22));
		frame.getContentPane().add(lbMinimizar);

		lbMover = new JLabel("");
		lbMover.setBounds(0, 0, 640, 29);
		lbMover.setBorder(new LineBorder(Color.WHITE, 2, true));
		frame.getContentPane().add(lbMover);

		lbResultado = new JLabel("");
		lbResultado.setVisible(false);
		lbResultado.setForeground(Color.WHITE);
		lbResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lbResultado.setFont(new Font("Quicksand Medium", Font.PLAIN, 28));
		lbResultado.setBounds(182, 86, 251, 29);
		frame.getContentPane().add(lbResultado);

		// labels de las soluciones de las filas
		lblsFilas = new HashMap<String, JLabel>();

		JLabel slcF1 = new JLabel("X");
		slcF1.setHorizontalAlignment(SwingConstants.CENTER);
		slcF1.setForeground(new Color(255, 255, 255));
		slcF1.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		slcF1.setBounds(449, 126, 45, 40);
		frame.getContentPane().add(slcF1);

		JLabel slcF2 = new JLabel("X");
		slcF2.setHorizontalAlignment(SwingConstants.CENTER);
		slcF2.setForeground(Color.WHITE);
		slcF2.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		slcF2.setBounds(449, 183, 45, 40);
		frame.getContentPane().add(slcF2);

		JLabel slcF3 = new JLabel("X");
		slcF3.setHorizontalAlignment(SwingConstants.CENTER);
		slcF3.setForeground(Color.WHITE);
		slcF3.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		slcF3.setBounds(449, 242, 45, 40);
		frame.getContentPane().add(slcF3);

		JLabel slcF4 = new JLabel("X");
		slcF4.setHorizontalAlignment(SwingConstants.CENTER);
		slcF4.setForeground(Color.WHITE);
		slcF4.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		slcF4.setBounds(449, 300, 45, 40);
		frame.getContentPane().add(slcF4);

		lblsFilas.put("1", slcF1);
		lblsFilas.put("2", slcF2);
		lblsFilas.put("3", slcF3);
		lblsFilas.put("4", slcF4);

		// labels de las soluciones de las columnas
		lblsColumnas = new HashMap<String, JLabel>();

		JLabel slcC1 = new JLabel("X");
		slcC1.setHorizontalAlignment(SwingConstants.CENTER);
		slcC1.setForeground(Color.WHITE);
		slcC1.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		slcC1.setBounds(182, 351, 45, 40);
		frame.getContentPane().add(slcC1);

		JLabel slcC2 = new JLabel("X");
		slcC2.setHorizontalAlignment(SwingConstants.CENTER);
		slcC2.setForeground(Color.WHITE);
		slcC2.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		slcC2.setBounds(248, 351, 45, 40);
		frame.getContentPane().add(slcC2);

		JLabel slcC3 = new JLabel("X");
		slcC3.setHorizontalAlignment(SwingConstants.CENTER);
		slcC3.setForeground(Color.WHITE);
		slcC3.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		slcC3.setBounds(318, 351, 45, 40);
		frame.getContentPane().add(slcC3);

		JLabel slcC4 = new JLabel("X");
		slcC4.setHorizontalAlignment(SwingConstants.CENTER);
		slcC4.setForeground(Color.WHITE);
		slcC4.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		slcC4.setBounds(388, 351, 45, 40);
		frame.getContentPane().add(slcC4);

		lblsColumnas.put("1", slcC1);
		lblsColumnas.put("2", slcC2);
		lblsColumnas.put("3", slcC3);
		lblsColumnas.put("4", slcC4);

		lbFondo = new JLabel("");
		lbFondo.setIcon(new ImageIcon(Interfaz.class.getResource("/tprac/Imgs/fondo.png")));
		lbFondo.setBounds(0, 0, 640, 480);
		frame.getContentPane().add(lbFondo);

		cambiarSoluciones();

		// labels del frame ventanaReglas
		lbRecuadroReglas = new JLabel("");
		lbRecuadroReglas.setBounds(0, 0, 215, 480);
		lbRecuadroReglas.setBorder(new LineBorder(Color.WHITE, 1, true));
		frameReglas.getContentPane().add(lbRecuadroReglas);

		lbTituloReglas = new JLabel("instrucciones");
		lbTituloReglas.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloReglas.setForeground(new Color(255, 255, 255));
		lbTituloReglas.setFont(new Font("Quicksand Medium", Font.PLAIN, 22));
		lbTituloReglas.setBounds(0, 0, 215, 45);
		frameReglas.getContentPane().add(lbTituloReglas);

		lbReglas = new JLabel(
				"<html>Para poder ganar usted debe ingresar numeros (00-99) de tal forma que la suma de cada fila sea igual al numero que se encuetra al final de cada una de ellas, al mismo tiempo esto debe ocurrir con la suma de cada columna y el numero al final de ellas.<p>El boton BORRAR vacia a todos los casilleros, el boton JUEGO NUEVO genera un juego con otros numeros y el boton VERIFICAR comprueba si el juego esta ganado o no.</html>");
		lbReglas.setHorizontalAlignment(SwingConstants.LEFT);
		lbReglas.setForeground(new Color(255, 255, 255));
		lbReglas.setFont(new Font("Quicksand Medium", Font.PLAIN, 17));
		lbReglas.setBounds(4, 50, 215, 300);
		frameReglas.getContentPane().add(lbReglas);

		// label del frame winner
		lbGifCelebracion = new JLabel("");
		lbGifCelebracion.setIcon(new ImageIcon(Interfaz.class.getResource("/tprac/Imgs/gifCelebration2.gif")));
		lbGifCelebracion.setBounds(0, 0, 640, 200);
		frameWinner.getContentPane().add(lbGifCelebracion);
	}

	private void eventos() {
		inputValido(grupoInputsUsr);

		// accion boton minimizar
		lbMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		// accion boton cerrar
		lbCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
		// accion boton reglas
		btnReglas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicks += 1;
				if (clicks % 2 != 0) {
					frameReglas.setVisible(true);
				} else {
					frameReglas.setVisible(false);
				}
			}
		});
		// accion boton borrar inputs del usuario
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarNumerosUsr();
				ocultarResultado();
			}
		});
		// accion boton juego nuevo
		btnJuegoNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarNumerosUsr();
				cambiarSoluciones();
				ocultarResultado();
			}
		});
		// accion verificar inputs del usuario
		btnVerificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean booleanFilas = verificarFilas();
				boolean booleanColumnas = verificarColumnas();
				if (booleanFilas && booleanColumnas) {
					resultadoJuego(true, "¡¡¡GANASTE!!!");
				} else {
					resultadoJuego(false, "INCORRECTO");
				}
			}
		});
		// permite arrastrar el frame principal, los otros estan anclados a este
		lbMover.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				yy = e.getY();
			}
		});
		lbMover.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent ev) {
				int x = ev.getXOnScreen();
				int y = ev.getYOnScreen();
				frame.setBounds(x - xx, y - yy, 640, 480);
				frameReglas.setBounds(x + 650 - xx, y - yy, 215, 480);
				frameWinner.setBounds(x - xx + 80, y - 210 - yy, 480, 200);
			}
		});
	}

	// verifica si las sumas de las filas es igual a cada una de las soluciones
	private static boolean verificarFilas() {
		boolean ret = true;
		for (int i = 1; i <= 4; i++) {
			ArrayList<JTextField> filaI = grupoInputsUsr.get("f" + String.valueOf(i));
			ArrayList<Integer> numerosFilaI = new ArrayList<Integer>();
			for (int j = 0; j < filaI.size(); j++) {
				if (!filaI.get(j).getText().equals("")) {
					numerosFilaI.add(Integer.parseInt((filaI.get(j).getText())));
				}
			}
			if (!Negocio.sumarNumerosGrupo(numerosFilaI, i, "f")) {
				ret &= true;
				cambiarColorMal(lblsFilas.get(String.valueOf(i)));
			} else {
				cambiarColorBien(lblsFilas.get(String.valueOf(i)));
			}
		}
		return ret;
	}

	// verifica si las sumas de las columnas es igual a cada una de las soluciones
	private static boolean verificarColumnas() {
		boolean ret = true;
		for (int i = 1; i <= 4; i++) {
			ArrayList<Integer> numerosColumnaI = new ArrayList<Integer>();
			for (int j = 1; j < 5; j++) {
				if (!grupoInputsUsr.get("f" + String.valueOf(j)).get(i - 1).getText().equals("")) {
					numerosColumnaI
							.add(Integer.parseInt(grupoInputsUsr.get("f" + String.valueOf(j)).get(i - 1).getText()));
				}
			}
			if (!Negocio.sumarNumerosGrupo(numerosColumnaI, i, "c")) {
				ret &= false;
				cambiarColorMal(lblsColumnas.get(String.valueOf(i)));
			} else {
				cambiarColorBien(lblsColumnas.get(String.valueOf(i)));
			}
		}
		return ret;
	}

	// cambia el color de la label recibida a rojo
	public static void cambiarColorMal(JLabel l) {
		l.setForeground(new Color(255, 0, 51));
		ActionListener tP = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				l.setForeground(new Color(255, 255, 255));
			}
		};
		javax.swing.Timer tick = new javax.swing.Timer(2000, tP);
		tick.setRepeats(false);
		tick.start();
	}

	// cambia el color de la label recibida a verde
	public static void cambiarColorBien(JLabel l) {
		l.setForeground(new Color(0, 255, 0));

		ActionListener tP = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				l.setForeground(new Color(255, 255, 255));
			}
		};
		javax.swing.Timer tick = new javax.swing.Timer(2000, tP);
		tick.setRepeats(false);
		tick.start();

	}

	// borra los numeros ingresados por el usuario en los textFields
	private static void borrarNumerosUsr() {
		for (Map.Entry<String, ArrayList<JTextField>> e : grupoInputsUsr.entrySet()) {
			for (JTextField arr : e.getValue()) {
				arr.setText("");
			}
		}
	}

	// Pide las soluciones a una funcion del codigo de negocio (generarSolucionesFilasYColumnas())
	// y las pone en
	// los labels de las soluciones de filas y columnas
	private static void cambiarSoluciones() {
		ArrayList<ArrayList<Integer>> soluciones = Negocio.generarSolucionesFilasYColumnas();
		for (int i = 0; i < 4; i++) {
			lblsFilas.get(String.valueOf(i + 1)).setText(String.valueOf(soluciones.get(0).get(i)));
		}
		for (int i = 0; i < 4; i++) {
			lblsColumnas.get(String.valueOf(i + 1)).setText(String.valueOf(soluciones.get(1).get(i)));
		}
	}

	// hacen que los datos que ingresa el usuario sean numeros entre 00 y 99
	private static void inputValido(Map<String, ArrayList<JTextField>> m) {
		for (Map.Entry<String, ArrayList<JTextField>> e : m.entrySet()) {
			for (JTextField arr : e.getValue()) {
				inputSoloNumeros(arr);
			}
		}
	}

	private static void inputSoloNumeros(JTextField tf) {
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((tf.getText().length() <= 1) && (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| (ke.getKeyChar() == (char) 8)) {
					tf.setEditable(true);
				} else {
					tf.setEditable(false);
				}
			}
		});
	}

	// muestras ciertas cosas dependiendo del estado del juego, si esta ganado o no.
	private void resultadoJuego(boolean bool, String mensaje) {
		if (bool) {
			frameWinner.setVisible(bool);
			lbResultado.setText(mensaje);
			lbResultado.setForeground(Color.GREEN);
			lbResultado.setVisible(bool);
		} else {
			lbResultado.setText(mensaje);
			lbResultado.setForeground(Color.RED);
			lbResultado.setVisible(!bool);

			ActionListener tP = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					lbResultado.setVisible(false);
				}
			};
			javax.swing.Timer tick = new javax.swing.Timer(2000, tP);
			tick.setRepeats(false);
			tick.start();
		}
	}

	// oculta el cartel de ganaste y el de celebracion
	private void ocultarResultado() {
		lbResultado.setVisible(false);
		frameWinner.setVisible(false);
	}
}
