package pf.filter;

import pf.image.Image;

public class GrayScaleBlueFilter extends AbstractFilter {

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				image.set(x, y, color(blue(color), blue(color), blue(color)));
			}
		}
	}

	public String name() {
		return "grayscale_blue";
	}
	
}
