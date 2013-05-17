package pf.filter;

import pf.image.Image;

public class InvertSBFilter extends AbstractFilter {

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				float[] hsb = hsb(color);
				hsb[1] = 0xFF - hsb[1];
				hsb[2] = 0xFF - hsb[2];
				color = rgb(hsb);
				image.set(x, y, color);
			}
		}
	}

	public String name() {
		return "invert_sb";
	}
	
}
