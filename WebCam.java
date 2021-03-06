import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;


public class WebCam extends JFrame
{
	JFrame frame;
	JPanel panel;
	JButton buttonStart, buttonStop;
	JLabel label1;
	
	VideoCapture capture;
			
	static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME );}
	
	public WebCam()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(700, 600);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel();
		frame.setContentPane(panel);
				
		ListenForButton lForButton = new ListenForButton();
		
		buttonStart = new JButton("Start");
		buttonStart.setToolTipText("Star the Camera");
		buttonStart.setBorderPainted(false);
		buttonStart.addActionListener(lForButton);
		frame.add(buttonStart);
		
		buttonStop = new JButton("Stop");
		buttonStop.setToolTipText("Stop the Camera");
		buttonStop.setBorderPainted(false);
		buttonStop.addActionListener(lForButton);
		frame.add(buttonStop);
		
		label1 = new JLabel(" ", JLabel.CENTER);
		panel.add(label1);
		
		frame.validate();
		frame.setVisible(true);    
		
		Mat webImage = new Mat();
		capture = new VideoCapture(0);
		try{Thread.sleep(200);} 
		 catch (InterruptedException e1) 
		 {e1.printStackTrace();}
		
	    if(capture.isOpened())  
	    {  
	      while( true )  
	      {  
	    	  System.out.println(" Whiel loop entered ");  
	    	  capture.read(webImage);
			
	    	  if(!webImage.empty())
	    	  {
	    		  	//frame.setSize(webImage.width()+40, webImage.height()+60);
					MatToBufferedImage M2B = new MatToBufferedImage();
					BufferedImage image = M2B.getBufferedImage(webImage);
					ImageIcon imageIcon = new ImageIcon(image);
					label1.setIcon(imageIcon);
					panel.repaint();
					 
	    	  }
	    	  else
	    	  {
	    		  	System.out.println(" --(!) No captured frame -- Break!");  
			        break;  
	    	  }
	      } 
		}
	    return;
	}
	
	private class ListenForButton implements ActionListener
	{
		
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 
			 if(e.getSource() == buttonStart)
			 { 
				 capture.grab();				   
			 }
			 
			 if(e.getSource() == buttonStop)
			 {
				 capture.release();
			 }
			 
		 }
		
	}

	public static void main(String[] args) 
	{
		new WebCam();
	}

}
