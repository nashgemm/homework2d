import java.awt.*;
import java.io.IOException;

public class SpeedReader {

	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length != 5) {
			System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
			return;
		}
		String filename = args[0];
		int width = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		int fontSize = Integer.parseInt(args[3]);
		int wpm = Integer.parseInt(args[4]);

		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontSize);
		g.setFont(f);

		WordGenerator text = new WordGenerator(filename);

		while (text.hasNext()) {
			FontMetrics metrics = g.getFontMetrics();
			String word = text.next();
			int hgt = metrics.getHeight();
			int wdth = metrics.stringWidth(word);
			g.setColor(Color.black);
			g.drawString(word, (width/2 - wdth/2), (height/2 - hgt/2));
			g.setColor(Color.red);
			int x = 0;
			if (word.length() <= 1) {
				x = 0;
			} else if (word.length() >= 2 && word.length() <= 5) {
				x = 1;
			} else if (word.length() >= 6 && word.length() <= 9) {
				x = 2;
			} else if (word.length() >= 10 && word.length() <= 13) {
				x = 3;
			} else if (word.length() >= 13) {
				x = 4;
			}
			g.drawString(String.valueOf(word.toCharArray()[x]), 
					width/2 - wdth/2 + metrics.stringWidth(word.substring(0, x)), height/2 - hgt/2);
			Thread.sleep(60000 / wpm);
			g.setColor(Color.white);
			g.fillRect(0, 0, width, height);
		}


	}
}
