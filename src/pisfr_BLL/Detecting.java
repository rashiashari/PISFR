/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_BLL;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import static org.bytedeco.javacpp.helper.opencv_objdetect.cvHaarDetectObjects;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.CvMemStorage;
import org.bytedeco.javacpp.opencv_core.CvRect;
import org.bytedeco.javacpp.opencv_core.CvScalar;
import org.bytedeco.javacpp.opencv_core.CvSeq;
import org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvClearMemStorage;
import static org.bytedeco.javacpp.opencv_core.cvCopy;
import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvGetSeqElem;
import static org.bytedeco.javacpp.opencv_core.cvGetSize;
import static org.bytedeco.javacpp.opencv_core.cvPoint;
import static org.bytedeco.javacpp.opencv_core.cvSetImageROI;
import static org.bytedeco.javacpp.opencv_imgproc.CV_AA;
import static org.bytedeco.javacpp.opencv_imgproc.CV_INTER_AREA;
import static org.bytedeco.javacpp.opencv_imgproc.cvRectangle;
import static org.bytedeco.javacpp.opencv_imgproc.cvResize;
import static org.bytedeco.javacpp.opencv_objdetect.CV_HAAR_DO_CANNY_PRUNING;
import org.bytedeco.javacpp.opencv_objdetect.CvHaarClassifierCascade;
/**
 *
 * @author Rashini_Ashari
 */
public class Detecting {
     
    private String CASCADE_FILE;
    private CvHaarClassifierCascade classifier = null;
    private CvSeq faces = null;
    IplImage grayimage;
    BufferedImage gray,detimg;
    CvMemStorage storage = CvMemStorage.create();
    
    
    public BufferedImage detectFace(BufferedImage imgfile)//method to detect faces
    {
        BufferedImage result=null;
        PreProcessing obj=new PreProcessing();
        Util uobj=new Util();

        try{
        CASCADE_FILE = "C:\\PISFC\\Others\\haarcascade_frontalface_alt.xml";//the cascade file
        classifier = CvHaarClassifierCascade.load(CASCADE_FILE, opencv_core.AbstractCvSize.ZERO);//load file
        
        gray=obj.converttoGray(imgfile);//convert to gray
        grayimage=uobj.bufferedtoIpl(gray);//convert to iplimage
        IplImage smallimage = IplImage.create(grayimage.width(), grayimage.height(), grayimage.depth(), grayimage.nChannels());
        //cvConvert(grayimage,smallimage);
        cvClearMemStorage(storage);
        cvResize(grayimage, smallimage, CV_INTER_AREA);//resize the image for detection
        faces = cvHaarDetectObjects(smallimage, classifier, storage, 1.1, 3, CV_HAAR_DO_CANNY_PRUNING);
        
        if (faces != null)
        {
            System.out.println(faces.total());
        }
        int numface=faces.total();//get the count if total more than please do something
        if(numface>1)
        {
            result=null;
        }
        else if(numface==0)
        {
            result=null;
        }
        else
        {
            for(int i=0;i<numface;i++)
            {
                CvRect r = new CvRect(cvGetSeqElem(faces, i));
                 cvRectangle (
                        smallimage,
                        cvPoint(r.x(), r.y()),
                        cvPoint(r.width() + r.x(), r.height() + r.y()),
                        CvScalar.RED,
                        2,
                        CV_AA,
                        0);
                 cvSetImageROI(smallimage, r);
                 IplImage cropped = cvCreateImage(cvGetSize(smallimage), smallimage.depth(), smallimage.nChannels());
                 cvCopy(smallimage,cropped);
                 result=uobj.resizeImage(cropped, 100, 100);
            }
        }}
        catch(Exception e)
        {
            logger(e);
        }
        return result;
    }   
     private static final Logger logger = Logger.getLogger(Detecting.class.getName());
    FileHandler fhandler;
    private void logger(Exception e)
    {
        try {
            fhandler = new FileHandler("C:\\PISFC\\Logger\\Logger.log", true);
            logger.addHandler(fhandler);
            SimpleFormatter formatter = new SimpleFormatter(); 
            fhandler.setFormatter(formatter);
            logger.log(Level.SEVERE, e.getMessage(), e);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(Detecting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
