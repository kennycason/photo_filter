package pf.filter;

import pf.image.Image;

public class InvertRGBFilter extends AbstractFilter {

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				image.set(x, y, color(0xFF - red(color), 0xFF - green(color), 0xFF - blue(color)));
			}
		}
	}

	public String name() {
		return "invert_rgb";
	}
	
}
