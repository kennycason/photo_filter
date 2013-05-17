package pf.filter;

import pf.image.Image;

public class BrightnessThresholdFilter extends AbstractFilter {

	private double threshold = 0xFF / 2;
	
	public BrightnessThresholdFilter() {
	}
	
	/*
	 * 0 to 1
	 */
	public BrightnessThresholdFilter(double threshold) {
		this.threshold = threshold * 0xFF;
	}
	
	@Override
	public void filter(Image image) {
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				int color = image.get(x, y);
				if(brightness(color) > threshold) {
					image.set(x, y, 0xFFFFFF);
				} else {
					image.set(x, y, 0);
				}
			}
		}
	}

	public String name() {
		return "brightness_threshold" + threshold;
	}
	
}
