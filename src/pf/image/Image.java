package pf.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	private BufferedImage bi;
	
	public Image(String file) {
		String path = "images/charlize.jpg";
        try {
			bi = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void set(int x, int y, int rgb) {
		bi.setRGB(x, y, rgb);
	}
	
	public int get(int x, int y) {
		return bi.getRGB(x, y);
	}
	
	public BufferedImage image() {
		return bi;
	}
	
	public int width() {
		return bi.getWidth();
	}
	
	public int height() {
		return bi.getHeight();
	}

	public void save(String file) {
		try {
		    File outputfile = new File(file);
		    ImageIO.write(bi, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
