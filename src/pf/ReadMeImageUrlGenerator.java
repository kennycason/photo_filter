package pf;

import java.io.File;
import java.io.IOException;

public class ReadMeImageUrlGenerator {

	public static void main(String[] args) throws IOException {
		// Directory path here
		String path = "./output/";

		String file;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		System.out.println("<table>");
		for (int i = 0; i < listOfFiles.length; i += 2) {
			System.out.println("<tr><td>");
			if (listOfFiles[i].isFile()) {
				file = listOfFiles[i].getName();
				System.out.println(file.replace(".png", "") + "<br/>");
				System.out.println("<img src=\"https://raw.github.com/kennycason/photo_filter/master/output/thumb/" + file + "\" width=\"600px\"/>");
			}
			if(i + 1 < listOfFiles.length) {
				System.out.println("</td><td>");
				file = listOfFiles[i + 1].getName();
				System.out.println(file.replace(".png", "") + "<br/>");
				System.out.println("<img src=\"https://raw.github.com/kennycason/photo_filter/master/output/thumb/" + file + "\" width=\"600px\"/>");
			
			}
			System.out.println("</td></tr>");
		}
		System.out.println("</table>");
	}

}