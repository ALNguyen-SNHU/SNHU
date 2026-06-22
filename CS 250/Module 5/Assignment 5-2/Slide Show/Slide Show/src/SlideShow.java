/*
 * Did I revise all appropriate sections of code related to the new requirements?
 * getResizeIcon (image sources) and getTextDescription (descriptions and titles) were the only methods modified to include the new images and text.
 * 
 * Is the software functional?
 * The software is still working as of now. I ran the program with the commands: javac SlideShow.java and java SlideShow.
 * 
 * Did I add comments to explain the changes I made and why I made them?
 * I added comments to descriptions of the images, most of the images came from Wikimedia Commons, added url links to the source of the images, and added new title destinations and descriptions.
 
 [Name]: Andrew Nguyen
 [Date]: 04/04/2024
 [Time Started]: 12:00 PM
 */

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
		textPane.setBackground(Color.BLUE);
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
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
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
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){			// https://commons.wikimedia.org/wiki/File:Bar_in_pool_at_Tabac%C3%B3n.gk.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/CostaRica.jpg") + "'</body></html>";
		} else if (i==2){	// https://commons.wikimedia.org/wiki/File:Geysir_Geothermal_Field,_Haukadalur_Valley,_Iceland,_20230501_0905_3752.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Iceland.jpg") + "'</body></html>";
		} else if (i==3){	// https://commons.wikimedia.org/wiki/File:Kusatsu_Onsen,_Gunma_Prefecture;_November_2018_(13).jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Japan.jpg") + "'</body></html>";
		} else if (i==4){	// https://commons.wikimedia.org/wiki/File:Panoramic_view_of_Oia,_Santorini_island_(Thira),_Greece.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Greece.jpg") + "'</body></html>";
		} else if (i==5){	// https://pelorustravel.com/canada/accommodation/nimmo-bay
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Canada.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values				// ISSUE: The text and color around it are visible, but hard to see due to the background AND text color. I want white text and purple background.
	 */
	private String getTextDescription(int i) {		// Added font size and break line to the text to all the destinations. Added descriptions to all the destinations. Added a background specifically to the text area.
		String text = ""; 
		if (i==1){
			text = "<html><body style='background-color:#8000FF; color:white;'><font size='5'>#1 Costa Rica Wellness Spa</font> <br>Spa treatment and organic cuisine. Swim in saltwater pools, participate in daily yoga sessions, or explore the jungle trails.</body></html>";	// <br> is used to add a line break in the text, and <font> is used to change the font size. Replaced the grand canyon with Costa Rica Wellness Spa and added description.
		} else if (i==2){
			text = "<html><body style='background-color:#8000FF; color:white;'><font size='5'>#2 Icelandic Hot Springs Detox</font> <br>Dine at on-site restaurants featuring Icelandic cuisine while enjoying the silica, algae, and minerals of the saltwater Blue Lagoon.</body></html>";	// Added Icelandic Hot Springs Detox and description. Added <br> and <font> tags to change the font size and add line breaks.
		} else if (i==3){
			text = "<html><body style='background-color:#8000FF; color:white;'><font size='5'>#3 Japanese Onsen Escape</font> <br>Hidden garden resort with a blend of modern and traditional hospitality overlooking Kusatsu serene gardens.</body></html>";						// Using the same format, added Japanese Onsen Escape and description.
		} else if (i==4){
			text = "<html><body style='background-color:#8000FF; color:white;'><font size='5'>#4 Greek Island Mind-Body Reboot</font> <br>Enjoy yoga, meditation, and clean eating with views of the Aegean Sea.</body></html>";													// Added Greek Island Mind-Body Reboot and description.
		} else if (i==5){
			text = "<html><body style='background-color:#8000FF; color:white;'><font size='5'>#5 Canadian Wilderness Wellness Lodge</font> <br>Outdoor wilderness adventure. Reconnect with nature with activities such as hiking, snorkeling, and kayaking.</body></html>";		// Added Canadian Wilderness Wellness Lodge and description.
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