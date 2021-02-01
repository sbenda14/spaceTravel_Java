package gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import src.AdjacencyList;
import src.FileImporter;
import src.Nearest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

/**
 * GUI Driver for the traveling salesperson problem. Takes in user file of x,y,z coordinates
* and parses into adjacency matrix/list. Sends on to method to solve with dynamic programming. 
 * source: https://www.technical-recipes.com/2017/creating-a-windows-application-in-java-using-eclipse/
 */
public class GUI extends JFrame {
	 private JPanel contentPane;
	 private FilePicker filePicker;
	 private JLabel lblResults;
	 private JLabel lblDistance;
	 
	 public static void main(String[] args)  {
		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    GUI frame = new GUI();
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
	    filePicker = new FilePicker("Pick a file", "Browse...");
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
		btnNearestNeighbor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            	btnNearestActionPerformed(evt);            
            }
        });
		runAlgo.add(btnNearestNeighbor, BorderLayout.NORTH);
		
		lblDistance = new JLabel("Total Distance:");
		runAlgo.add(lblDistance, BorderLayout.SOUTH);
		
		lblResults = new JLabel("Results");
		lblResults.setOpaque(true);
		lblResults.setBackground(Color.WHITE);
		lblResults.setVerticalAlignment(SwingConstants.TOP);
		runAlgo.add(lblResults, BorderLayout.CENTER);
		contentPane.add(runAlgo);
   }
   
	private void btnNearestActionPerformed(ActionEvent evt) {
		FileImporter newFile = new FileImporter();
		try {
			AdjacencyList myList = newFile.importFile(filePicker.getSelectedFilePath());
			
			Nearest nearPath = new Nearest(myList);
			
			lblResults.setText(nearPath.printString());
			
			DecimalFormat numberFormat = new DecimalFormat("#.00");
			lblDistance.setText("Total distance " + numberFormat.format(nearPath.getTotalDistance()));
		} catch (FileNotFoundException e) {
			lblResults.setText("File not found");
		}catch(NumberFormatException e) {
			lblResults.setText("Check GPS formatting");
		}catch(Exception e) {
			lblResults.setText("Ruh Roh! Something went wrong. Check GPS formatting");
		}
		
    }
   
}
