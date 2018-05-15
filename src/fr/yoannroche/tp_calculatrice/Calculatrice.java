package fr.yoannroche.tp_calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Calculatrice extends JFrame {

	public static final JComponent couleur = null;
	/**
	 * Les Variables d'instance.
	 */

	private JButton bouton0 = new JButton("0");
	private JButton bouton1 = new JButton("1");
	private JButton bouton2 = new JButton("2");
	private JButton bouton3 = new JButton("3");
	private JButton bouton4 = new JButton("4");
	private JButton bouton5 = new JButton("5");
	private JButton bouton6 = new JButton("6");
	private JButton bouton7 = new JButton("7");
	private JButton bouton8 = new JButton("8");
	private JButton bouton9 = new JButton("9");
	private JButton boutonad = new JButton("+");
	private JButton boutonso = new JButton("-");
	private JButton boutondi = new JButton("/");
	private JButton boutonmu = new JButton("*");
	private JButton boutonc = new JButton("C");
	private JButton boutonp = new JButton(".");
	private JButton boutoneg = new JButton("=");
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton couleur1 = new JRadioButton("C1");
	private JRadioButton couleur2 = new JRadioButton("C2");
	private JRadioButton couleur3 = new JRadioButton("C3");
	private JRadioButton couleur0 = new JRadioButton("C0");

	private JPanel container = new JPanel();
	private JLabel ecran = new JLabel();
	private Double chiffre1 ;
	private boolean clicOperateur = false, update = false;
	private String operateur = "";
	


	/**
	 * Création de la boite Calculatrice dans son contructeur
	 */
	public Calculatrice () {
		this.setTitle("Calculatrice");
		this.setSize(270, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.DARK_GRAY);

		/**
		 * Géneration du Contenu
		 */
		Contenu();



		this.setVisible(true);
		this.setContentPane(container);
	}
	private void Contenu () {
		
		JPanel couleur = new JPanel ();
		couleur.setBackground(Color.orange);
		couleur.setPreferredSize(new Dimension(120,30));
		couleur0.addActionListener(new CouleurListener());
		couleur1.addActionListener(new CouleurListener());
		couleur2.addActionListener(new CouleurListener());
		couleur3.addActionListener(new CouleurListener());
		bg.add(couleur0);
		bg.add(couleur1);
		bg.add(couleur2);
		bg.add(couleur3);
		couleur.add(couleur0);
		couleur.add(couleur1);
		couleur.add(couleur2);
		couleur.add(couleur3);
		couleur0.setPreferredSize(new Dimension (20,20));
		couleur1.setPreferredSize(new Dimension (20,20));
		couleur2.setPreferredSize(new Dimension (20,20));
		couleur3.setPreferredSize(new Dimension (20,20));
		couleur0.setBackground(Color.orange);
		couleur1.setBackground(Color.orange);
		couleur2.setBackground(Color.orange);
		couleur3.setBackground(Color.orange);
		couleur.setBorder(BorderFactory.createLineBorder(Color.black));
		container.add(couleur , BorderLayout.NORTH);
		
		/**
		 * Création du JPanel du cadre de l'écran.
		 */

		JPanel ecranP = new JPanel();
		ecranP.setPreferredSize(new Dimension(235, 50));
		ecranP.setBackground(Color.LIGHT_GRAY);
		container.add(ecranP, BorderLayout.NORTH);
		ecranP.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/**
		 * Création du JLabel qui sera situé dans l'écran
		 */
		
		Font police = new Font ("Impact",Font.BOLD,40);
		ecran = new JLabel ("0");
		ecran.setForeground(Color.black);
		ecran.setFont(police);
		
		
		
		
		

		/**
		 * Création du JPanel des chiffres et les signes "=" "."
		 */

		JPanel chiffre = new JPanel(); 
		chiffre.setPreferredSize(new Dimension(165, 132));
		chiffre.setBackground(Color.GRAY);
		container.add(chiffre, BorderLayout.CENTER);
		chiffre.setBorder(BorderFactory.createLineBorder(Color.black));

		/**
		 * Ajout des boutons 123456789 . et =
		 */
		
		chiffre.add(bouton1);
		chiffre.add(bouton2);
		chiffre.add(bouton3);
		chiffre.add(bouton4);
		chiffre.add(bouton5);
		chiffre.add(bouton6);
		chiffre.add(bouton7);
		chiffre.add(bouton8);
		chiffre.add(bouton9);
		chiffre.add(boutonp);
		chiffre.add(bouton0); 
		chiffre.add(boutoneg);

		/**
		 * Création du JPanel operateur pour les boutons + - / *
		 */

		JPanel operateur = new JPanel();
		operateur.setPreferredSize(new Dimension (70, 170));
		operateur.setBackground(Color.orange);
		container.add(operateur, BorderLayout.EAST);
		operateur.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/**
		 * Ajout des boutons operateur + - / * C
		 */

		operateur.add(boutonc);
		operateur.add(boutonad);
		operateur.add(boutonso);
		operateur.add(boutondi);
		operateur.add(boutonmu);
		
		boutonc.setForeground(Color.red);

		/**
		 * Ajout du JPanel de l'écran de résultat
		 */

		ecran.setHorizontalAlignment(JLabel.RIGHT);
		ecran.setPreferredSize(new Dimension(220, 40));
		ecranP.add(ecran);
		
		

		/**
		 * Ajout des ActionListener pour les chiffres.
		 */

		bouton1.addActionListener(new ChiffreListener());
		bouton2.addActionListener(new ChiffreListener());
		bouton3.addActionListener(new ChiffreListener());
		bouton4.addActionListener(new ChiffreListener());
		bouton5.addActionListener(new ChiffreListener());
		bouton6.addActionListener(new ChiffreListener());
		bouton7.addActionListener(new ChiffreListener());
		bouton8.addActionListener(new ChiffreListener());
		bouton9.addActionListener(new ChiffreListener());
		bouton0.addActionListener(new ChiffreListener());
		
		/**
		 * Ajout de l'ActionListener de multiplication.
		 */
		boutonmu.addActionListener(new MultiListener());
		
		/**
		 * Ajout de l'ActionListener de l'addition.
		 */
		boutonad.addActionListener(new PlusListener());
		
		/**
		 * Ajout de l'ActionListener de la soustraction.
		 */
		boutonso.addActionListener(new MoinsListener());
		
		/**
		 * Ajout de l'ActionListener de la division.
		 */
		boutondi.addActionListener(new DivListener());
		
		/**
		 * Ajout de l'ActionListenr de l'égalisation
		 */
		boutoneg.addActionListener(new EgalListener());
		
		/**
		 * Ajout de l'ActionListener du bouton de la remise à zéro.
		 */
		boutonc.addActionListener(new ResetListener());
		/**
		 * Ajout de l'ActionListener du point
		 */
		boutonp.addActionListener(new PointListener());
		

	}
	
	
	
	/**
	 * Méthodes de calculs
	 */
	private void calcul(){
		if(operateur.equals("+")){
			chiffre1 = chiffre1 + 
					Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(chiffre1));
		}
		if(operateur.equals("-")){
			chiffre1 = chiffre1 - 
					Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(chiffre1));
		}          
		if(operateur.equals("*")){
			chiffre1 = chiffre1 * 
					Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(chiffre1));
		}     
		if(operateur.equals("/")){
			try{
				chiffre1 = chiffre1 / 
						Double.valueOf(ecran.getText()).doubleValue();
				ecran.setText(String.valueOf(chiffre1));
			} catch(ArithmeticException e) {
				ecran.setText("0");
			}
		}
	}
	/**
	 * Listener des chiffres
	 * @author Yoann
	 *
	 */
	class ChiffreListener implements ActionListener{
		//Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton)e.getSource()).getText();
			if(update){
				update = false;
			}
			else{
				if(!ecran.getText().equals("0"))
					str = ecran.getText() + str;
			}
			ecran.setText(str);
		}
	}
	/**
	 * Listener du bouton =
	 * @author Yoann
	 *
	 */
	class EgalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			calcul();
			update = true;
			clicOperateur = false;
		}
	}

	/**
	 * Listener du bouton +
	 * @author Yoann
	 *
	 */
	class PlusListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "+";
			update = true;
		}
	}

	/**
	 * Listener du bouton -
	 * @author Yoann
	 *
	 */
	class MoinsListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "-";
			update = true;
		}
	}

	/**
	 * Listener du bouton *
	 * @author Yoann
	 *
	 */
	class MultiListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "*";
			update = true;
		}
	}

	/**
	 * Listener du bouton /
	 * @author Yoann
	 *
	 */
	class DivListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "/";
			update = true;
		}
	}

	/**
	 * Listener du bouton C ( reset )
	 * @author Yoann
	 *
	 */
	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			clicOperateur = false;
			update = true;
			chiffre1 = null;
			operateur = "";
			ecran.setText("0");
		}
	} 
	/**
	 * Listener de la virgule
	 * @author Yoann
	 *
	 */
	 class PointListener implements ActionListener {
		    public void actionPerformed(ActionEvent e){
		    	String str = ((JButton)e.getSource()).getText();
				if(update){
					update = false;
				}
				else{
					if(!ecran.getText().equals("0"))
						str = ecran.getText() + str;
				}
				ecran.setText(str);
			}
	 }
	 class CouleurListener implements ActionListener{
		
		 public void actionPerformed(ActionEvent e) {
			 
			
			 if(couleur1.isSelected()) {
				 container.setBackground(Color.blue);
				 
				 
				 
			 }
			 if(couleur2.isSelected()) {
				 container.setBackground(Color.RED);
			
			 }
			 if(couleur3.isSelected()) {
				 container.setBackground(Color.GREEN);
			 }
			 if(couleur0.isSelected()) {
				 container.setBackground(Color.DARK_GRAY);
			 }
			 
		 
	 }

	
			
		}
	 }














