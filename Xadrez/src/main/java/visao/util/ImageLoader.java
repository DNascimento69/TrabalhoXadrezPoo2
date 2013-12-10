package visao.util;

import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class ImageLoader {
	public static Image LoadImage(String file) {
		Image image = null;

		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}
}