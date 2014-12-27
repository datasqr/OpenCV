import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

// http://docs.opencv.org/trunk/doc/py_tutorials/py_gui/py_image_display/py_image_display.html#py-display-image 

public class tutorial1 extends JFrame
{

	public static void main(String[] args)
	{
		//This line should be always decleared when using OpenCV
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// Create an object Mat with importing image with Highgui
		Mat m = Highgui.imread("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image5.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
		
		JFrame frame = new JFrame("Tutorial1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		// Inserts the image icon
		ImageIcon image = new ImageIcon("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image5.jpg");
		frame.setSize(image.getIconWidth()+10,image.getIconHeight()+35);
		// Draw the Image data into the BufferedImage
		JLabel label1 = new JLabel(" ", image, JLabel.CENTER);
		frame.getContentPane().add(label1);
		 
		frame.validate();
		frame.setVisible(true);
	   	
	}	
	
}
