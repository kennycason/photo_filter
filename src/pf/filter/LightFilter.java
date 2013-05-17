package pf.filter;

import pf.image.Image;

public class LightFilter extends AbstractFilter {

	private final double brightness;
	
	public LightFilter(double brightness) {
		this.brightness = brightness;
	}
	
	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				float[] hsb = hsb(color);
				hsb[2] *= brightness;
				if(hsb[2] > 0xFF) {
					hsb[2] = 0xFF;
				}
				color = rgb(hsb);
				image.set(x, y, color);
			}
		}
	}

	public String name() {
		return "light" + brightness;
	}
	
}
