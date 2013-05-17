package pf.filter;

import pf.image.Image;

public class SineCosineFilter extends AbstractFilter {

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				double sin = Math.sin(red(color)) * 0xFF;
				double cos = Math.cos(green(color)) * 0xFF;
				image.set(x, y, color(sin, cos, blue(color)));
			}
		}
	}

	public String name() {
		return "sinecosine";
	}
	
}
