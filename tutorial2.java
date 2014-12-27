import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

//# http://docs.opencv.org/trunk/doc/py_tutorials/py_gui/py_drawing_functions/py_drawing_functions.html

public class tutorial2 extends JFrame
{
	
	// Create an image from array
	private static final int HEIGHT = 250;
    private static final int WIDTH = 250;

    public static void main(String[] args)
    {
    	
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	
    	// Create an image with black background
    	// source: http://sumitkumariit.blogspot.com/2013/08/coverting-opencv-mat-to-bufferedimage.html   	
    	// This works only when BufferedImage.TYPE_3BYTE_BGR and CvType.CV_8UC3
    	// Atherwise throus an error 
    	BufferedImage image = new BufferedImage(HEIGHT, WIDTH, BufferedImage.TYPE_3BYTE_BGR);
    	
    	//From an image create Mat object
    	Mat mat = BufferedImageToMat(image);
    	
    	//Functions to draw grometries
    	Core.line(mat, new Point(0,10), new Point(50,50), new Scalar(0, 0, 255),4);
    	Core.rectangle(mat, new Point(10,20), new Point(60,70), new Scalar(0, 0, 255),4);
    	Core.circle(mat, new Point(10,20), 10, new Scalar(0, 0, 255),4);
    	
    	// write file to a HD
    	Highgui.imwrite("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\test.png", mat);
    	
    	// convert Mat to Buffered Image to display in JFrame
    	// https://sites.google.com/site/pdopencvjava/mat-to-java-bufferedimage
     	
    	BufferedImage bufImage = MatToBufferedImage(mat);
		
    	imshow(bufImage);
    	
    }
    
    public static Mat BufferedImageToMat(BufferedImage image)
    {
    	// create array of  bytes
    	byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    	Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
    	// methode to modify the pixel in Mat
    	mat.put(0, 0, pixels);
    	return mat;
    	
    }
    
    public static BufferedImage MatToBufferedImage(Mat mat)
    {
    	
    	MatOfByte mob = new MatOfByte();
    	//byte mat is to convert image into stream of bytes.
    	// this will put the bytes into bytemat object
    	Highgui.imencode(".png", mat ,mob); 
		//convert byte mat into array of bytes.
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
    
    static byte[] getBytes(BufferedImage img) 
    {
        return ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
    }
    
     static void imshow(BufferedImage image)
    {
    	
    	JFrame frame = new JFrame("Tutorial2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		// Inserts the image icon
		ImageIcon image1 = new ImageIcon(image);
		frame.setSize(image1.getIconWidth()+10,image1.getIconHeight()+35);
		// Draw the Image data into the BufferedImage
		JLabel label1 = new JLabel(" ", image1, JLabel.CENTER);
		frame.getContentPane().add(label1);
		 
		frame.validate();
		frame.setVisible(true);     
    	
    }
     
     
     
}
