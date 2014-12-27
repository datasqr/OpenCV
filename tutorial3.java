import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.image.DataBufferByte;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Core;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.highgui.Highgui;
import org.opencv.core.Scalar;


public class tutorial3a extends JFrame
{
	
	// Create an image from array
	private static final int HEIGHT = 250;
    private static final int WIDTH = 250;

    static Mat mat;
    JFrame frame;
    JLabel label1;
    JPanel thePanel;

    BufferedImage[] imagesArray;
    
    int clicked = 0;
    
    public static void main(String[] args)
    {
    	
    	new tutorial3a();
    	
    }
    
    public tutorial3a()
    {
    	
    	imagesArray = new  BufferedImage[20];
    	
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	
    	BufferedImage image = new BufferedImage(HEIGHT, WIDTH, BufferedImage.TYPE_3BYTE_BGR);
    	    
    	imagesArray[1] = image;
    	JFrame frame = new JFrame("Tutorial3");
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		frame.setResizable(true);
 		frame.setLocationRelativeTo(null);
 		frame.validate();
 		frame.setVisible(true);
 		
 		JPanel thePanel = new JPanel();	
 		frame.add(thePanel);
 		
 		ListenForMouse lForMouse = new ListenForMouse();	 	
 		frame.addMouseListener(lForMouse);
 		
 		int mouseX = 0;
		int mouseY = 0;
 		//lForMouse. 	
		
		//imagesArray[2] = drawMat(mouseX, mouseY, imagesArray[1]);
 		
 		ImageIcon image1 = new ImageIcon(imagesArray[1]);
 		frame.setSize(image1.getIconWidth()+10,image1.getIconHeight()+35);
 		label1 = new JLabel(" ", image1, JLabel.CENTER);
 		frame.add(label1);
     	
    }
    
    public static BufferedImage drawMat(int x, int y, BufferedImage image)
    {
    	
    	Mat mat = BufferedImageToMat(image);         
        //Function to draw a line
    	Core.circle(mat, new Point(x,y), 10, new Scalar(0, 0, 255),4);
       	BufferedImage bufImage = MatToBufferedImage(mat);
     	return bufImage;
     	
    }
        
    public static Mat BufferedImageToMat(BufferedImage image)
    {
    	
    	byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    	Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
    	mat.put(0, 0, pixels);
    	return mat;
    	
    }
    
    public static BufferedImage MatToBufferedImage(Mat mat)
    {
    	
    	MatOfByte mob = new MatOfByte();
    	Highgui.imencode(".png", mat ,mob); 
		//convert the "matrix of bytes" into a byte array
		byte[] byteArray = mob.toArray();
		BufferedImage bufImage = null;
		try {
				// Pass these bytes into ByteArrayInputStream to get a stream of bytes
				InputStream in = new ByteArrayInputStream(byteArray);
				// pass this stream in read method of ImageIO class, which we will be able to put in JLabel
		    	bufImage = ImageIO.read(in);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		
		return bufImage;
    	
    }
    
    
	private class ListenForMouse implements MouseListener
	{
		
		int mouseX = 0;
		int mouseY = 0;
		
		public int getX()
		{
			return this.mouseX;
		}
		
		public int getY()
		{
			return this.mouseY;
		}

		public void mouseClicked(MouseEvent e) 
		{
			
			System.out.println("Mouse clicked at " + e.getX() + ", " + e.getY());
			int mouseX = e.getX();
			int mouseY = e.getY();	

			clicked++;
			System.out.println(clicked);
			
			imagesArray[clicked+1] = drawMat(mouseX, mouseY, imagesArray[clicked]);
	 		
	 		ImageIcon image1 = new ImageIcon(imagesArray[clicked+1]);
	 		label1.setIcon(image1);
			
			
						
		}

		public void mouseEntered(MouseEvent arg0) {}
		
		public void mouseExited(MouseEvent arg0) {}
		
		public void mousePressed(MouseEvent arg0) {}
		
		public void mouseReleased(MouseEvent arg0) {}
		
		
		
	}
		
          
}
