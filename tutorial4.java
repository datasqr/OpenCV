import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

//http://docs.opencv.org/trunk/doc/tutorials/introduction/load_save_image/load_save_image.html#load-save-image

public class tutorial4
{

	public static void main(String[] args)
	{
		//This line should be always decleared when using OpenCV
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// Create an object Mat with importing image with Highgui
		Mat m = Highgui.imread("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image6.png",Highgui.CV_LOAD_IMAGE_COLOR);
		
		Mat gray_image = new Mat();
		Imgproc.cvtColor(m, gray_image, Imgproc.COLOR_RGB2GRAY);
		
		Highgui.imwrite("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\test.png", gray_image);
		
	   	
	}	
	
}
