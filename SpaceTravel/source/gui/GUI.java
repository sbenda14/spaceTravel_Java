package gui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

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
	   setLayout(new FlowLayout());
	   setTitle("Space Travel");
	// set up a file picker component
       FilePicker filePicker = new FilePicker("Pick a file", "Browse...");
       filePicker.setMode(FilePicker.MODE_OPEN);
       filePicker.addFileTypeFilter(".txt", "Text files");
        
       // access JFileChooser class directly
       JFileChooser fileChooser = filePicker.getFileChooser();
       fileChooser.setCurrentDirectory(new File("C:/Users/sbend/OneDrive/Desktop"));
        
       // add the component to the frame
       
       setVisible(true);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 450, 300);
       contentPane = new JPanel();
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       contentPane.setLayout(new BorderLayout(0, 0));
       contentPane.add(filePicker);
       setContentPane(contentPane);
   }
}
