import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Sharpen 
{

	Mat m;
	static Mat dest = null;
	
	public Sharpen()
	{
		this.m = m;
	}
	
	public static Mat getSharpen(Mat m)
	{
		try
		{
	         System.loadLibrary(Core.NATIVE_LIBRARY_NAME );
	         //m = Highgui.imread("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image6.png",Highgui.CV_LOAD_IMAGE_COLOR);
	         dest = new Mat(m.rows(),m.cols(),m.type());
	         Imgproc.GaussianBlur(m, dest, new Size(0,0), 10);
	         Core.addWeighted(m, 1.5, dest, -0.5, 0, dest);
	         Highgui.imwrite("sharp.jpg", dest);
	         
	     }catch (Exception e){}
		
		return dest;

	}
	public static void main(String[] args) 
	{
		
		/***********************************************
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME );
        Mat mat = Highgui.imread("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image5.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
		Sharpen sharp = new Sharpen();
		
		Mat des = sharp.getSharpen(mat);
		
		MatToBufferedImage M2B = new MatToBufferedImage();

		ImageShow imshow = new ImageShow(M2B.getBufferedImage(des));
		************************************************/
	}

}
