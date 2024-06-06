import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class ShifumiWin {

	private JFrame frame;
	private int nbPoints;
	private JButton btn3Points;
	private JButton btn5Points;
	private JButton btn10Points;
	private JLabel lblResultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShifumiWin window = new ShifumiWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShifumiWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblShifumi = new JLabel("Shifumi");
		lblShifumi.setBounds(174, 22, 97, 52);
		frame.getContentPane().add(lblShifumi);

		System.out.println("Victoire du joueur");
		lblResultat = new JLabel("--");
		lblResultat.setBounds(21, 85, 377, 32);
		frame.getContentPane().add(lblResultat);
		lblResultat.setText("");
		lblResultat.setVisible(false);

		btn3Points = new JButton("Partie en 3 points ");
		btn3Points.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nbPoints = 3;
				try {
					Shifumi();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn3Points.setBounds(21, 132, 143, 32);
		frame.getContentPane().add(btn3Points);
		btn3Points.setVisible(true);

		btn5Points = new JButton("Partie en 5 points ");
		btn5Points.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nbPoints = 5;

				try {
					Shifumi();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn5Points.setBounds(258, 132, 143, 32);
		frame.getContentPane().add(btn5Points);
		btn5Points.setVisible(true);

		btn10Points = new JButton("Partie en 10 points ");
		btn10Points.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nbPoints = 10;
				try {
					Shifumi();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn10Points.setBounds(139, 175, 143, 32);
		frame.getContentPane().add(btn10Points);
		btn10Points.setVisible(true);

	}
	public void Shifumi() throws InterruptedException {
		lblResultat.setText("");
		lblResultat.setVisible(false);
		btn3Points.setVisible(false);
		btn5Points.setVisible(false);
		btn10Points.setVisible(false);

		Scanner sc= new Scanner (System.in);
		int choix;
		int choixPC;
		int  point = 0;
		int pointPC = 0;

		while(nbPoints!=pointPC && nbPoints !=point) {

			choixPC= (int)(Math.random()*(3))+1;

			//Thread.sleep(3*1000);
			System.out.println(choixPC);

			do { //on r�p�te si on saisie autre chose que 1 2 ou 3

				//le joueur fait un choix entre 1 et 3
				System.out.println("(1) Pierre,(2) Feuille ou (3) Ciseau ?");
				choix = sc.nextInt();
				if(choix <1 || choix>3) 
				{
					System.out.println("erreur veuillez resaisir");
				}
			}while(choix<1 || choix>3);

			switch(choix) {
			case 1 : // joueur PIERRE 
				switch(choixPC) {
				case 1: // PC choisit PIERRE 
					System.out.println("match nul");
					break;
				case 2: // cas PC choisit FEUILLE
					System.out.println("Perdu");
					pointPC = pointPC+1;
					break;
				case 3: // cas PC choisit CISEAU
					System.out.println("GG");
					point = point+1;
					break;
				}
				break;

			case 2 : // cas joueur choisit FEUILLE 
				switch(choixPC) {
				case 1: // cas PC choisit PIERRE
					System.out.println("GG");
					point = point+1;
					break;
				case 2: // cas PC choisit FEUILLE
					System.out.println("match nul");
					break;
				case 3: // cas PC choisit CISEAU
					System.out.println("Perdu");
					pointPC = pointPC+1;
					break;
				}
				break;
			case 3 : 
				switch(choixPC) {
				case 1: // cas PC choisit PIERRE
					System.out.println("Perdu");
					pointPC = pointPC+1;
					break;

				case 2: // cas PC choisit FEUILLE
					System.out.println("GG");
					point = point+1;
					break;

				case 3: // cas PC choisit CISEAU
					System.out.println("Match nul");
					break;
				}
				System.out.println("Vos points :"+point+" - Point PC ="+pointPC);


			}

		}  


		if(point==nbPoints) {

			lblResultat.setText("C'est gagné ! Appuyer sur un bouton pour recommencer");
			
		}
		else

			lblResultat.setText("C'est perdu ! Appuyer sur un bouton pour recommencer");	
		lblResultat.setVisible(true);
		btn3Points.setVisible(true);
		btn5Points.setVisible(true);
		btn10Points.setVisible(true);
	}


}
