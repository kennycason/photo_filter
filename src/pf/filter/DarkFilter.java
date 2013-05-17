package pf.filter;

import pf.image.Image;

public class DarkFilter extends AbstractFilter {
	
	private final double darkness;
	
	public DarkFilter(double darkness) {
		this.darkness = darkness;
	}

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				float[] hsb = hsb(color);
				hsb[2] *= darkness;
				color = rgb(hsb);
				image.set(x, y, color);
			}
		}
	}

	public String name() {
		return "dark" + darkness;
	}
	
}
