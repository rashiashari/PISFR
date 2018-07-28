/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_BLL;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 *
 * @author Rashini_Ashari
 */
public class FeatureEx {
       
    private static final double U_H = .4;   
    private static final double U_L = .05;   
    private static final int S = 4, T = 4; // filter mask size   
    private static final int M = 5, N = 8; // scale & orientation   
   
    private static final double A = Math.pow((U_H / U_L), 1. / (M - 1));   
    private static final double[] theta = new double[N];   
    private static final double[] modulationFrequency = new double[M];   
    private static final double[] sigma_x = new double[M];   
    private static final double[] sigma_y = new double[M];   
    private static final double[][][][][] selfSimilarGaborWavelets = new double[S][T][M][N][2];   
   
    private static final double LOG2 = Math.log(2);   
   
    private double[][][][][] gaborWavelet = null;     
   
   static {   
        for (int i = 0; i < N; i++) {   
            theta[i] = i * Math.PI / N;   
        }   
        for (int i = 0; i < M; i++) {   
            modulationFrequency[i] = Math.pow(A, i) * U_L;   
            sigma_x[i] =   
                    (A + 1) * Math.sqrt(2 * LOG2) /   
                            (2 * Math.PI * Math.pow(A, i) * (A - 1) * U_L);   
            sigma_y[i] = 1 / (2 * Math.PI * Math.tan(Math.PI / (2 * N)) * Math.sqrt(Math.pow(U_H, 2) / (2 * LOG2) - Math.pow(1 / (2 * Math.PI * sigma_x[i]), 2)));   
   
        }   
        FeatureEx gaborFeature = new FeatureEx();   
        double[] selfSimilarGaborWavelet;   
        for (int s = 0; s < S; s++) {   
            for (int t = 0; t < T; t++) {   
                for (int m = 0; m < M; m++) {   
                    for (int n = 0; n < N; n++) {   
                        selfSimilarGaborWavelet = gaborFeature.selfSimilarGaborWavelet(s, t, m, n);   
                        selfSimilarGaborWavelets[s][t][m][n][0] = selfSimilarGaborWavelet[0];   
                        selfSimilarGaborWavelets[s][t][m][n][1] = selfSimilarGaborWavelet[1];   
                    }   
                }   
            }   
        }   
    }      
   
    public double[] getFeature(BufferedImage image) {   
        //image = ImageUtils.scaleImage(image, MAX_IMG_HEIGHT);   
        Raster imageRaster = image.getRaster();   
        int[][] grayLevel = new int[imageRaster.getWidth()][imageRaster.getHeight()];   
        int[] tmp = new int[3];   
        for (int i = 0; i < imageRaster.getWidth(); i++) {   
            for (int j = 0; j < imageRaster.getHeight(); j++) {   
                grayLevel[i][j] = imageRaster.getPixel(i, j, tmp)[0];   
            }   
        }   
   
        double[] featureVector = new double[M * N * 2];   
        double[][] magnitudes = computeMagnitudes(grayLevel);   
        int imageSize = image.getWidth() * image.getHeight();   
        double[][] magnitudesForVariance = new double[M][N];   
   
        if (this.gaborWavelet == null) {   
            precomputeGaborWavelet(grayLevel);   
        }   
   
        for (int m = 0; m < M; m++) {   
            for (int n = 0; n < N; n++) {   
                featureVector[m * N + n * 2] = magnitudes[m][n] / imageSize;   
                for (int i = 0; i < magnitudesForVariance.length; i++) {   
                    for (int j = 0; j < magnitudesForVariance[0].length; j++) {   
                        magnitudesForVariance[i][j] = 0.;   
                    }   
                }   
                for (int x = S; x < image.getWidth(); x++) {   
                    for (int y = T; y < image.getHeight(); y++) {   
                        magnitudesForVariance[m][n] += Math.pow(Math.sqrt(Math.pow(this.gaborWavelet[x - S][y - T][m][n][0], 2) + Math.pow(this.gaborWavelet[x - S][y - T][m][n][1], 2)) - featureVector[m * N + n * 2], 2);   
                    }   
                }   
   
                featureVector[m * N + n * 2 + 1] = Math.sqrt(magnitudesForVariance[m][n]) / imageSize;   
            }   
        }   
        this.gaborWavelet = null;   
   
        return featureVector;   
    }   
   
    private void precomputeGaborWavelet(int[][] image) {   
        this.gaborWavelet = new double[image.length - S][image[0].length - T][M][N][2];   
        double[] gaborWavelet;   
        for (int m = 0; m < M; m++) {   
            for (int n = 0; n < N; n++) {   
                for (int x = S; x < image.length; x++) {   
                    for (int y = T; y < image[0].length; y++) {   
                        gaborWavelet = gaborWavelet(image, x, y, m, n);   
                        this.gaborWavelet[x - S][y - T][m][n][0] = gaborWavelet[0];   
                        this.gaborWavelet[x - S][y - T][m][n][1] = gaborWavelet[1];   
                    }   
                }   
            }   
        }   
    }   
   
    private double[][] computeMagnitudes(int[][] image) {   
        double[][] magnitudes = new double[M][N];   
        for (int i = 0; i < magnitudes.length; i++) {   
            for (int j = 0; j < magnitudes[0].length; j++) {   
                magnitudes[i][j] = 0.;   
            }   
        }   
   
        if (this.gaborWavelet == null) {   
            precomputeGaborWavelet(image);   
        }   
   
        for (int m = 0; m < M; m++) {   
            for (int n = 0; n < N; n++) {   
                for (int x = S; x < image.length; x++) {   
                    for (int y = T; y < image[0].length; y++) {   
                        magnitudes[m][n] += Math.sqrt(Math.pow(this.gaborWavelet[x - S][y - T][m][n][0], 2) 
                                + Math.pow(this.gaborWavelet[x - S][y - T][m][n][1], 2));   
   
                    }   
                }   
            }   
        }   
        return magnitudes;   
    }   
   
    // returns 2 doubles representing the real ([0]) and imaginary ([1]) part of the mother wavelet   
    private double[] gaborWavelet(int[][] img, int x, int y, int m, int n) {   
        double re = 0;   
        double im = 0;   
        for (int s = 0; s < S; s++) {   
            for (int t = 0; t < T; t++) {   
                re += img[x][y] * selfSimilarGaborWavelets[s][t][m][n][0];   
                im += img[x][y] * -selfSimilarGaborWavelets[s][t][m][n][1];   
            }   
        }   
   
        return new double[]{re, im};   
    }   
   
    // returns 2 doubles representing the real ([0]) and imaginary ([1]) part of the mother wavelet   
    private double[] computeMotherWavelet(double x, double y, int m, int n) {   
   
        return new double[]{   
                1 / (2 * Math.PI * sigma_x[m] * sigma_y[m]) *   
                        Math.exp(-1 / 2 * (Math.pow(x, 2) / Math.pow(sigma_x[m], 2) + Math.pow(y, 2) / Math.pow(sigma_y[m], 2))) *   
                        Math.cos(2 * Math.PI * modulationFrequency[m] * x),   
                1 / (2 * Math.PI * sigma_x[m] * sigma_y[m]) *   
                        Math.exp(-1 / 2 * (Math.pow(x, 2) / Math.pow(sigma_x[m], 2) + Math.pow(y, 2) / Math.pow(sigma_y[m], 2))) *   
                        Math.sin(2 * Math.PI * modulationFrequency[m] * x)};   
    }   
   
    private double x_tilde(int x, int y, int m, int n) {   
        return   
                Math.pow(A, -m) * (x * Math.cos(theta[n]) + y * Math.sin(theta[n]));   
    }   
   
    private double y_tilde(int x, int y, int m, int n) {   
        return   
                Math.pow(A, -m) * (-x * Math.sin(theta[n] + y * Math.cos(theta[n])));   
    }   
   
    private double[] selfSimilarGaborWavelet(int x, int y, int m, int n) {   
        double[] motherWavelet = computeMotherWavelet(x_tilde(x, y, m, n), y_tilde(x, y, m, n), m, n);   
        return new double[]{   
                Math.pow(A, -m) * motherWavelet[0],   
                Math.pow(A, -m) * motherWavelet[1]};   
    }   
  
}   


