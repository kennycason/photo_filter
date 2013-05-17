package pf.filter;

import java.awt.Color;

public abstract class AbstractFilter implements IFilter {

	protected int red(int rgb) {
		return (rgb >> 16) & 0xFF;
	}
	
	protected int green(int rgb) {
		return (rgb >> 8) & 0xFF;
	}
	
	protected int blue(int rgb) {
		return rgb & 0xFF;
	}
	
	/*
	 * 0 to 360 (degrees)
	 * http://en.wikipedia.org/wiki/HSL_and_HSV
	 * http://www.f4.fhtw-berlin.de/~barthel/ImageJ/ColorInspector/HTMLHelp/farbraumJava.htm
	 */
	protected void hsb(int rgb, float[] hsb) {
		Color.RGBtoHSB(red(rgb), green(rgb), blue(rgb), hsb);
		hsb[0] *= 0xFF;
		hsb[1] *= 0xFF;
		hsb[2] *= 0xFF;
	}
	
	protected float[] hsb(int rgb) {
		float[] hsb = new float[3];
		Color.RGBtoHSB(red(rgb), green(rgb), blue(rgb), hsb);
		hsb[0] *= 0xFF;
		hsb[1] *= 0xFF;
		hsb[2] *= 0xFF;
		return hsb;
	}
	
	protected int rgb(float[] hsb) {
		return Color.HSBtoRGB(hsb[0] / 0xFF, hsb[1] / 0xFF, hsb[2] / 0xFF);
	}
	
	protected float hue(int rgb) {
		return hsb(rgb)[0];
	}
	
	protected float saturation(int rgb) {
		return hsb(rgb)[1];
	}
	
	protected float brightness(int rgb) {
		return hsb(rgb)[2];
	}
	
	protected int color(int r, int g, int b) {
		return ((r & 0xFF)  << 16)
				+ ((g & 0xFF) << 8)
				+ (b & 0xFF); 
	}
	
	protected int color(double r, double g, double b) {
		return color((int) r, (int) g, (int) b);
	}

	protected int max(int a, int b) {
		return a > b ? a : b;
	}
	
	protected int max(int a, int b, int c) {
		return max(a, max(b, c));
	}	
	
	protected int min(int a, int b) {
		return a < b ? a : b;
	}
	
	protected int min(int a, int b, int c) {
		return min(a, min(b, c));
	}	
	
}
