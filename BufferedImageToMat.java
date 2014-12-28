import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.CvType;
import org.opencv.core.Mat;


public class BufferedImageToMat 
{
	BufferedImage image;
	Mat mat;
	
	public BufferedImageToMat(BufferedImage image)
	{
		this.image = image;
	}
	
	public Mat getMatObject()
	{
		byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    	mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
    	mat.put(0, 0, pixels);
    	//return mat;
    	return mat;
	}

}
