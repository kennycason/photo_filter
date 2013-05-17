package pf;

import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;

import pf.filter.BlueFilter;
import pf.filter.BlurFilter;
import pf.filter.BrightnessThresholdFilter;
import pf.filter.DarkFilter;
import pf.filter.DefaultFilter;
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
				new BlurFilter(1), 
				new BlurFilter(2),
				new BlurFilter(3),
				new InvertBrightnessFilter(),
				new InvertSaturationFilter(), 
				new InvertHueFilter(),
				new InvertRGBFilter(), 
				new InvertHSBFilter(),
				new InvertSBFilter(), 
				new ScaleSaturationFilter(20) 
		};

		Image image = new Image("images/charlize.jpg");
		ImagePanel imagePanel = new ImagePanel(image);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(imagePanel);
		f.setSize(imagePanel.image().width(), imagePanel.image().height());
		f.setLocation(0, 0);
		f.setVisible(true);
		
		int i = 0;
		for(;;) {
			imagePanel.image(new Image("images/charlize.jpg"));
			imagePanel.filter(filters[i]);
			imagePanel.repaint();
			try {
				if(filters[i].name().startsWith("blur")) {
					Thread.sleep(3000);
				} else {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			i %= filters.length;
		}

	}
}
