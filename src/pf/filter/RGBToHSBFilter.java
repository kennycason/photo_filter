package pf.filter;

import pf.image.Image;

/**
 * @author kenny
 *
 */
public class RGBToHSBFilter extends AbstractFilter {

	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				float[] hsb = hsb(color);
				image.set(x, y, color(hsb[0], hsb[1], hsb[2]));
			}
		}
	}

	public String name() {
		return "rgb_to_hsb";
	}
	
}
