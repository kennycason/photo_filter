package pf.filter;

import pf.image.Image;

public class BlurFilter extends AbstractFilter {
	
	private final int amount;
	
	public BlurFilter(int amount) {
		this.amount = amount;
	}

	@Override
	public void filter(Image image) {
		int[][] p = new int[image.width()][image.height()];
		for(int i = 0; i < amount; i++) {
			// calculate avg
			for(int y = 0; y < image.height(); y++) {
				for(int x = 0; x < image.width(); x++) {
					int count = 1;
					int rTot = red(image.get(x, y));
					int gTot = green(image.get(x, y));
					int bTot = blue(image.get(x, y));
					
					if(x > 0) {
						if(y > 0) {
							count++;
							rTot += red(image.get(x - 1, y - 1));
							gTot += green(image.get(x - 1, y - 1));
							bTot += blue(image.get(x - 1, y - 1));
						}
						count++;
						rTot += red(image.get(x - 1, y));
						gTot += green(image.get(x - 1, y));
						bTot += blue(image.get(x - 1, y));
						if(y < image.height() - 1) {
							count++;
							rTot += red(image.get(x - 1, y + 1));
							gTot += green(image.get(x - 1, y + 1));
							bTot += blue(image.get(x - 1, y + 1));
						}
					}
					if(y > 0) {
						count++;
						rTot += red(image.get(x, y - 1));
						gTot += green(image.get(x, y - 1));
						bTot += blue(image.get(x, y - 1));
					}
					if(y < image.height() - 1) {
						count++;
						rTot += red(image.get(x, y + 1));
						gTot += green(image.get(x, y + 1));
						bTot += blue(image.get(x, y + 1));
					}
					if(x < image.width() - 1) {
						if(y > 0) {
							count++;
							rTot += red(image.get(x + 1, y - 1));
							gTot += green(image.get(x + 1, y - 1));
							bTot += blue(image.get(x + 1, y - 1));
						}
						count++;
						rTot += red(image.get(x + 1, y));
						gTot += green(image.get(x + 1, y));
						bTot += blue(image.get(x + 1, y));
						if(y < image.height() - 1) {
							count++;
							rTot += red(image.get(x + 1, y + 1));
							gTot += green(image.get(x + 1, y + 1));
							bTot += blue(image.get(x + 1, y + 1));
						}
					}
					
					p[x][y] = color(rTot / count, gTot / count, bTot / count);
				}
			}
			// update
			for(int y = 0; y < image.height(); y++) {
				for(int x = 0; x < image.width(); x++) {
					image.set(x, y, p[x][y]);
				}
			}
		}
	}

	public String name() {
		return "blur" + amount;
	}
	
}
