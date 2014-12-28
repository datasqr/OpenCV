import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;


public class MatToBufferedImage 
{
	
	BufferedImage bufImage;
	Mat mat;
	MatOfByte mob;
	
	public MatToBufferedImage(Mat mat)
	{
		this.mat = mat;
	}
	
	public BufferedImage getBufferedImage()
	{
		
		mob = new MatOfByte();
		Highgui.imencode(".png", mat, mob); 
		//convert the "matrix of bytes" into a byte array
		byte[] byteArray = mob.toArray();
		bufImage = null;
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


}
