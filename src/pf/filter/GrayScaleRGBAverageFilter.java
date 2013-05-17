package pf.filter;

import pf.image.Image;

public class GrayScaleRGBAverageFilter extends AbstractFilter {

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				int grayscaleRed = color(red(color), red(color), red(color));
				int grayscaleGreen = color(green(color), green(color), green(color));
				int grayscaleBlue = color(blue(color), blue(color), blue(color));
				
				int avg = (grayscaleRed + grayscaleGreen + grayscaleBlue) / 3;
				image.set(x, y, color(avg, avg, avg));
			}
		}
	}

	public String name() {
		return "grayscale_rgb_average";
	}
	
}
