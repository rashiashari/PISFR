/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_BLL;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author Rashini_Ashari
 */
public class PreProcessing {
    //convert colored image to gray scale image
     public BufferedImage converttoGray(BufferedImage img)
    {
        int height=img.getHeight();
        int width=img.getWidth();
        try
        {
            for(int i = 0; i < height; i++)
            {
                for(int j = 0; j < width; j++)
                {
                    Color c=new Color(img.getRGB(j, i));
                    int r=(int)(c.getRed()*0.299);
                    int g=(int)(c.getGreen()*0.587);
                    int b=(int)(c.getBlue()*0.114);
                    
                    Color nc=new Color(r+g+b,r+g+b,r+g+b);
                    
                    img.setRGB(j, i, nc.getRGB());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return img;
    }
     
     //another method to convert to grayscale this is the preferred method
     public BufferedImage converttoGray3(BufferedImage img)
    {
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                int p = img.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                
                int avg = (r+g+b)/3;

                //replace RGB value with avg
                p = (a<<24)|(avg<<16) | (avg<<8) | avg;
                img.setRGB(x, y, p);
            }
        }
        return img;
    }   
     //method to perform histogram equalization on grayScale image
     public BufferedImage histogramEqualization(BufferedImage img)
     {
         BufferedImage histImg = new BufferedImage(img.getWidth(), img.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
         WritableRaster wr = img.getRaster();
         WritableRaster er = histImg.getRaster();
         int pixel= wr.getWidth()*wr.getHeight();
         int[] histogram = new int[256];
         for (int x = 0; x < wr.getWidth(); x++)
         {
             for (int y = 0; y < wr.getHeight(); y++) 
             {
                 histogram[wr.getSample(x, y, 0)]++;
             }
         }
         
         int[] chistogram = new int[256];
         chistogram[0] = histogram[0];
         for(int i=1;i<256;i++)
         {
             chistogram[i] = chistogram[i-1] + histogram[i];
         }
         
         float[] arr = new float[256];
         for(int i=0;i<256;i++)
         {
             arr[i] =  (float)((chistogram[i]*255.0)/(float)pixel);
         
         }
         
         for (int x = 0; x < wr.getWidth(); x++) 
         {
             for (int y = 0; y < wr.getHeight(); y++) 
             {
                 int nVal = (int) arr[wr.getSample(x, y, 0)];
                 er.setSample(x, y, 0, nVal);
             }
         }
         histImg.setData(er);
         return histImg;
     }
}
