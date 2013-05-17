package pf.filter;

import pf.image.Image;

public interface IFilter {

	void filter(Image image);

	String name();
	
}
