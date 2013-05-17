package pf.filter;

import pf.image.Image;

public class ScaleSaturationFilter extends AbstractFilter {

	int scale;
	
	int iterations;
	
	public ScaleSaturationFilter(int scale) {
		if(scale < 0) {
			this.scale = -2;
			scale *= -1;
		} else {
			this.scale = 2;
		}
		iterations = scale;
	}
	@Override
	public void filter(Image image) {
		for(int i = 0; i < iterations; i++) {
			for(int y = 0; y < image.height(); y++) {
				for(int x = 0; x < image.width(); x++) {
					int color = image.get(x, y);
					float[] hsb = hsb(color);
					hsb[1] = hsb[1] += scale;
					color = rgb(hsb);
					image.set(x, y, color);
				}
			}
		}
	}

	public String name() {
		return "scale_saturation" + scale + "x" + iterations;
	}
	
}
