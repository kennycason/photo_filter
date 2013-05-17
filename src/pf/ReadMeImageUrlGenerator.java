package pf;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReadMeImageUrlGenerator {

	public static void main(String[] args) throws IOException {
		String path = "./output/";

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		List<String> filesList = new LinkedList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if(listOfFiles[i].getName().contains(".png")) {
			filesList.add(listOfFiles[i].getName());
		}
		}
		String[] files = filesList.toArray(new String[filesList.size()]);
		Arrays.sort(files);

		System.out.println("<table>");
		for (int i = 0; i < files.length; i += 3) {
			System.out.println("<tr><td>");
			System.out.println(files[i].replace(".png", "") + "<br/>");
			System.out.println("<img src=\"https://raw.github.com/kennycason/photo_filter/master/output/thumb/" + files[i] + "\"/>");
	
			if(i + 1 < files.length) {
				System.out.println("</td><td>");
				System.out.println(files[i + 1].replace(".png", "") + "<br/>");
				System.out.println("<img src=\"https://raw.github.com/kennycason/photo_filter/master/output/thumb/" + files[i + 1] + "\"/>");
			
			}
			if(i + 2 < files.length) {
				System.out.println("</td><td>");
				System.out.println(files[i + 2].replace(".png", "") + "<br/>");
				System.out.println("<img src=\"https://raw.github.com/kennycason/photo_filter/master/output/thumb/" + files[i + 2] + "\"/>");
			
			}
			System.out.println("</td></tr>");
		}
		System.out.println("</table>");
	}

}