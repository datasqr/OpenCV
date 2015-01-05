import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

// source http://stackoverflow.com/questions/17035005/using-get-and-put-to-access-pixel-values-in-opencv-for-java

public class Contrast 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME );
		MatToBufferedImage M2B = new MatToBufferedImage();
        	Mat mat = Highgui.imread("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image6.png",Highgui.CV_LOAD_IMAGE_COLOR);
        	Mat newMat = new Mat(mat.rows(), mat.cols(), mat.type());
        	mat.convertTo(mat, CvType.CV_64FC3); //CV_64FC3 it can use double[] instead of byte[] 
        	//Mat newMat = mat.clone();
        
        	//byte buff[] = new byte[(int) (mat.total() * mat.channels())];
        	double buff[] = new double[(int) (mat.total() * mat.channels())];
        
		double alpha = 2.2;
        	int beta = 50; 
        
        	System.out.println(mat.type());
        
        	mat.get(0, 0, buff);
        
        	ImageShow imshow = new ImageShow(M2B.getBufferedImage(mat));
        
        	for( int i = 0; i<buff.length; i++)
        	{
        		buff[i] = (alpha*buff[i]+beta);
        	}
        
        	newMat.put(0, 0, buff);
                
		ImageShow imshow1 = new ImageShow(M2B.getBufferedImage(newMat));
        

	}

}
