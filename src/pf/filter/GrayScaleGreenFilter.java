package pf.filter;

import pf.image.Image;

public class GrayScaleGreenFilter extends AbstractFilter {

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				image.set(x, y, color(green(color), green(color), green(color)));
			}
		}
	}

	public String name() {
		return "grayscale_green";
	}
	
}
