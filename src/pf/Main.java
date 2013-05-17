package pf;

import java.io.IOException;

import pf.filter.BlueFilter;
import pf.filter.BrightnessThresholdFilter;
import pf.filter.CosineRedFilter;
import pf.filter.DarkFilter;
import pf.filter.DefaultFilter;
import pf.filter.GaussianBlurFilter;
import pf.filter.GrayScaleBlueFilter;
import pf.filter.GrayScaleGreenFilter;
import pf.filter.GrayScaleRGBAverageFilter;
import pf.filter.GrayScaleRedFilter;
import pf.filter.GreenFilter;
import pf.filter.IFilter;
import pf.filter.InvertBrightnessFilter;
import pf.filter.InvertHSBFilter;
import pf.filter.InvertHueFilter;
import pf.filter.InvertRGBFilter;
import pf.filter.InvertSBFilter;
import pf.filter.InvertSaturationFilter;
import pf.filter.LightFilter;
import pf.filter.RGBAverageFilter;
import pf.filter.RGBToHSBFilter;
import pf.filter.RedFilter;
import pf.filter.ScaleSaturationFilter;
import pf.filter.SineCosineFilter;
import pf.filter.SineRedFilter;
import pf.image.Image;

public class Main {

	public static void main(String[] args) throws IOException {

		IFilter[] filters = { 
				new DefaultFilter(), 
				new RedFilter(),
				new GreenFilter(),
				new BlueFilter(),
				new GrayScaleRedFilter(),
				new GrayScaleGreenFilter(),
				new GrayScaleBlueFilter(),
				new GrayScaleRGBAverageFilter(),
				new RGBAverageFilter(), // grayscale
				new DarkFilter(0.2), 
				new DarkFilter(0.4),
				new DarkFilter(0.6),
				new DarkFilter(0.8),
				new LightFilter(1.5),
				new LightFilter(2.0),
				new LightFilter(4),
				new LightFilter(8),
				new LightFilter(50.0),
				new LightFilter(100.0),
				new BrightnessThresholdFilter(0.4), 
				new BrightnessThresholdFilter(0.6), 
				new BrightnessThresholdFilter(0.8),
				new RGBToHSBFilter(),
				new GaussianBlurFilter(1, 1.5), 
				new GaussianBlurFilter(2, 1.5),
				new GaussianBlurFilter(3, 1.5),
				new GaussianBlurFilter(3, 4.5),
				new GaussianBlurFilter(5, 2.4),
				new InvertBrightnessFilter(),
				new InvertSaturationFilter(), 
				new InvertHueFilter(),
				new InvertRGBFilter(), 
				new InvertHSBFilter(),
				new InvertSBFilter(), 
				new ScaleSaturationFilter(20),
				new SineRedFilter(),
				new CosineRedFilter(),
				new SineCosineFilter()
		};

		for(IFilter filter : filters) {
			Image image = new Image("images/charlize.jpg");
			System.out.println(filter.name());
			filter.filter(image);
	        image.save("output/" + filter.name() + ".png");
	        image.saveThumbnail("output/thumb/" + filter.name() + ".png");
		}
		System.out.println("Filtered images generated!");

	}
}
