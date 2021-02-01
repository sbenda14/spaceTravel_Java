package gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

/**
 * GUI panel for project. 
 * source: https://www.technical-recipes.com/2017/creating-a-windows-application-in-java-using-eclipse/
 */
public class GUI extends JFrame {
	 private JPanel contentPane;
	 
	/**
    * Create the frame.
    */
   public GUI() {
	   setTitle("Space Travel");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/gui/favicon-16x16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		// set up a file picker component
	    FilePicker filePicker = new FilePicker("Pick a file", "Browse...");
	    filePicker.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    FlowLayout flowLayout = (FlowLayout) filePicker.getLayout();
        filePicker.setMode(FilePicker.MODE_OPEN);
        filePicker.addFileTypeFilter(".txt", "Text files");
        filePicker.setSize(new Dimension(345, 5));
       
	        
       contentPane.add(filePicker);
		
        JPanel runAlgo = new JPanel();
        runAlgo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		runAlgo.setLayout(new BorderLayout(0, 0));
		JButton btnNearestNeighbor = new JButton("Run Nearest Neighbor");
		runAlgo.add(btnNearestNeighbor, BorderLayout.NORTH);
		
		JLabel lblDistance = new JLabel("Total Distance:");
		runAlgo.add(lblDistance, BorderLayout.SOUTH);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setOpaque(true);
		lblResults.setBackground(Color.WHITE);
		lblResults.setVerticalAlignment(SwingConstants.TOP);
		runAlgo.add(lblResults, BorderLayout.CENTER);
		contentPane.add(runAlgo);
   }
   
}
