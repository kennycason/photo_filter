package pf;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import pf.filter.DefaultFilter;
import pf.filter.IFilter;
import pf.image.Image;


public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Image image;
	
	IFilter filter = new DefaultFilter();

    public ImagePanel(Image image) {
    	this.image = image;
    }
    
    public void filter(IFilter filter) {
    	this.filter = filter;
    	filter.filter(image);
    }
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.image(), 0, 0, this);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 200, 22);
        g.setColor(Color.WHITE);
        g.drawString(filter.name(), 5, 14);
        image.save("output/" + filter.name() + ".png");
        image.saveThumbnail("output/thumb/" + filter.name() + ".png");
    }
   
    protected void repaint(Graphics g) {
    	paintComponents(g);

    }
    
    public Image image() {
    	return image;
    }
    
    public void image(Image image) {
    	this.image = image;
    }
 
}
