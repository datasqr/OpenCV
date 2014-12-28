import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.CvType;

public class tutorial5
{
	
	public static void main(String[] args)
	{
		//This line should be always decleared when using OpenCV
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// function to measure the performance of the code
		double t = Core.getTickCount();
		
		// Create an object Mat with importing image with Highgui
		Mat m = Highgui.imread("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image6.png",Highgui.CV_LOAD_IMAGE_COLOR);
		System.out.println("characteristics of the image " + m.channels() + " cols " +  m.cols() + " rows " +  m.rows());
		
		MatToBufferedImage M2B = new MatToBufferedImage(m);
		ImageShow imshow = new ImageShow(M2B.getBufferedImage());
		
		double[] speckColor = new double[]{100, 50, 200};
		for(int i = 0; i<100; i++)
		{
			for(int j = 0; j<100;j++)
			{
				m.put(i, j, speckColor);
			}
			
		}

		MatToBufferedImage M2B1 = new MatToBufferedImage(m);
		ImageShow imshow1 = new ImageShow(M2B1.getBufferedImage());
		
	    t = (Core.getTickCount() - t)/Core.getTickFrequency();
	    System.out.println(t);
	}	

	
}
