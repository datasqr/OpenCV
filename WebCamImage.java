import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

// https://www.youtube.com/watch?v=7K_Oeu-l2G8

public class WebCamImage 
{

	public static void main(String[] args)
	{

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture cap = new VideoCapture(0);
		
		//It is necessary for camera initialization
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!cap.isOpened())
		{
			System.out.println("Did not connect to camera");
		}
		 
		Mat frame1 = new Mat();
		
		cap.retrieve(frame1);
		
		Highgui.imwrite("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\testWebCame.jpg", frame1);
		
		Mat frame2 = new Mat();
		Imgproc.cvtColor(frame1, frame2, Imgproc.COLOR_RGB2GRAY);
		
		Highgui.imwrite("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\testWebCame1.jpg", frame2);

		cap.release();
	}

}
