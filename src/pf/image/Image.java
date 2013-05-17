package pf.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
		    ImageIO.write(bi, "png", new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveThumbnail(String file) {
		int width = bi.getWidth() / 4;
		int height = bi.getHeight() / 4;

		int imgWidth = bi.getWidth();
		int imgHeight = bi.getHeight();
		if (imgWidth * height < imgHeight * width) {
			width = imgWidth * height / imgHeight;
		} else {
			height = imgHeight * width / imgWidth;
		}
		BufferedImage newImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = newImage.createGraphics();
		try {
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g.setBackground(Color.BLACK);
			g.clearRect(0, 0, width, height);
			g.drawImage(bi, 0, 0, width, height, null);
		} finally {
			g.dispose();
		}
		try {
			ImageIO.write(newImage, "png", new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
