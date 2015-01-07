import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

// source http://stackoverflow.com/questions/17035005/using-get-and-put-to-access-pixel-values-in-opencv-for-java

public class Blending {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME );
		MatToBufferedImage M2B = new MatToBufferedImage();
        Mat mat1 = Highgui.imread("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image6.png",Highgui.CV_LOAD_IMAGE_COLOR);
        Mat mat2 = Highgui.imread("C:\\Users\\Dell\\Desktop\\Projects\\OpenCV\\image5.png",Highgui.CV_LOAD_IMAGE_COLOR);
        
        Mat newMat = new Mat(mat1.rows(), mat1.cols(), mat1.type());
        mat1.convertTo(mat1, CvType.CV_64FC3); //CV_64FC3 it can use double[] instead of byte[] 
        mat2.convertTo(mat2, CvType.CV_64FC3); //CV_64FC3 it can use double[] instead of byte[] 
        //Mat newMat = mat.clone();
        
        //byte buff[] = new byte[(int) (mat.total() * mat.channels())];
        double buff1[] = new double[(int) (mat1.total() * mat1.channels())];
        double buff2[] = new double[(int) (mat2.total() * mat2.channels())];
        
        double alpha = 0.7;
        
        mat1.get(0, 0, buff1);
        mat2.get(0, 0, buff2);
        
        ImageShow imshow = new ImageShow(M2B.getBufferedImage(mat1));
        
        for( int i = 0; i<buff1.length; i++)
        {
        	buff1[i] = (1-alpha)*buff1[i]+alpha*buff2[i];
        }
        
        newMat.put(0, 0, buff1);
                
		ImageShow imshow1 = new ImageShow(M2B.getBufferedImage(newMat));
        

	}

}
