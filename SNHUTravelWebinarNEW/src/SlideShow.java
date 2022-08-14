import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.YELLOW);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("SNHU Travel Webinar");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 7; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images that display the Title page, all 5 Destinations, and the Marketing closing page
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/SNHUTitlePage.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/GrandCanyon.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Provincetown_Cape_cod_Massachusetts.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Lauterbrunnen.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Paris_France.jpg") + "'</body></html>";
		} else if (i==6){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Seattle_WA.jpg") + "'</body></html>";
		} else if (i==7){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Marketing.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values for each slide that provides details to the relevant destination images
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>Welcome to the SNHU Travel Webinar!</font><br>"
					+ "We are sure you will find a destination you'll love to visit!</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#1 The Grand Canyon, Arizona</font> <br>"
					+ "Spectacular canyon views and hiking.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#2 Provincetown, Cape Cod, Massachusetts</font><br>"
					+ "Famous for sandy beaches, lobster rolls, and laid-back fun.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#3 Lauterbrunnen, Switzerland</font><br>"
					+ "A quaint, charming Swiss village surrounded by majestic waterfalls and a breathtaking valley.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#4 Paris, France</font><br>"
					+ "Visit museums, gourmet restaurants, and the iconic Eiffel Tower.</body></html>";
		} else if (i==6){
			text = "<html><body><font size='5'>#5 Seattle, Washington</font><br>"
					+ "A city known for its weather and coffee culture, visit the famous Space Needle!</body></html>";
		} else if (i==7){
			text = "<html><body><font size='5'>Choose your vacation package today by visiting our <a href=\"https://docs.google.com/document/d/1ILzhty1MiKVXVA_aKKBWAdBrkAb0K-hx6XSBswaMgR8/edit?usp=sharing\">Pricing Chart</a>.</font></body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}