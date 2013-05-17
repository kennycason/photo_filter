package pf.filter;

import pf.image.Image;

public class GaussianBlurFilter extends AbstractFilter {
	
	private final int radius;
	
	private final double theta;
	
	/**
	 * TODO speed up by precomputing values with a given radius, using Pascal's triangle
	 * @param radius
	 * @param theta
	 */
	public GaussianBlurFilter(int radius, double theta) {
		this.radius = radius;
		this.theta = theta;
	}

	@Override
	public void filter(Image image) {
		double[][] weights = generateGaussian();
		int[][] newPixels = new int[image.width()][image.height()];
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				newPixels[x][y] = calculateBlur(x, y, image, weights);
			}
		}
		
		// update
		for(int y = 0; y < image.height(); y++) {
			for(int x = 0; x < image.width(); x++) {
				image.set(x, y, newPixels[x][y]);
			}
		}
	}
	
	private int calculateBlur(int x0, int y0, Image image, double[][] weights) {
		int dim = radius * 2 + 1;
		double[][] localWeights = new double[dim][dim];
		for(int y = 0; y < dim; y++) {
			for(int x = 0; x < dim; x++) {
				localWeights[x][y] = weights[x][y];
			}
		}
		
		int dx, dy;
		double r = 0, g = 0, b = 0;
		for(int y = -radius; y <= radius; y++) {
			for(int x = -radius; x <= radius; x++) {
				dx = x0 - x;
				dy = y0 - y;
				if(dx >= 0 && dx < image.width() 
					 & dy >= 0 && dy < image.height()) {
					int rgb = image.get(dx, dy);
					r += localWeights[x + radius][y + radius] * red(rgb);
					g += localWeights[x + radius][y + radius] * green(rgb);
					b += localWeights[x + radius][y + radius] * blue(rgb);
				}
			}
		}
		return color(r, g, b);
	}

	/*
	 * for radius = 1, theta = 1.5, should return
	 *	generate gaussian
	 *	0.04535423476987057 0.05664058479678963 0.04535423476987057 
	 *	0.05664058479678963 0.0707355302630646 0.05664058479678963 
	 *	0.04535423476987057 0.05664058479678963 0.04535423476987057 
	 *	
	 *	sum: 0.4787148085297054
	 *	divide by sum
	 *	0.0947416582101747 0.1183180127031206 0.0947416582101747 
	 *	0.1183180127031206 0.14776131634681883 0.1183180127031206 
	 *	0.0947416582101747 0.1183180127031206 0.0947416582101747 
	 */
	private double[][] generateGaussian() {
		int dim = radius * 2 + 1;
		double[][] weights = new double[dim][dim];
		for(int y = -radius; y <= radius; y++) {
			for(int x = -radius; x <= radius; x++) {
				weights[x + radius][y + radius] = gaussian(x, y);
				 // System.out.print(weights[x + radius][y + radius] + " ");
			}
			 // System.out.println();
		}
		// System.out.println();
		double sum = 0;
		for(int y = 0; y < dim; y++) {
			for(int x = 0; x < dim; x++) {
				sum += weights[x][y];
			}
		}
		// System.out.println("sum: " + sum);
		for(int y = 0; y < dim; y++) {
			for(int x = 0; x < dim; x++) {
				weights[x][y] /= sum;
				// System.out.print(weights[x][y] + " ");
			}
			// System.out.println();
		}
		return weights;
	}

	private double gaussian(int x, int y) {
		return (1 / (2 * Math.PI * theta * theta)) * Math.pow(Math.E, -((x * x + y * y) / (2 * theta * theta)));
	}

	public String name() {
		return "gaussian_blur_" + radius + "_" + theta;
	}
	
}
