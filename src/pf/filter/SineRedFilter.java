package pf.filter;

import pf.image.Image;

public class SineRedFilter extends AbstractFilter {

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				double sinR = Math.sin(red(color)) * 0xFF;
				image.set(x, y, color(sinR, green(color), blue(color)));
			}
		}
	}

	public String name() {
		return "sine_red";
	}
	
}
