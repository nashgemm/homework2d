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
			Thread.sleep(60000 / wpm);
			g.setColor(Color.white);
			g.fillRect(0, 0, width, height);
		}


	}
}
