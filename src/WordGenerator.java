import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {

	public Scanner scanner;
	private int wordCount;
	private int sentenceCount;


	public WordGenerator (String filename) throws IOException {
		this.scanner = new Scanner(new File(filename));
		this.wordCount = 0;
		this.sentenceCount = 0;
	}

	public boolean hasNext() {
		return this.scanner.hasNext();
	}

	
	public String next() {
		String output = this.scanner.next();
		if (output.endsWith(".")
				|| output.endsWith("!")
				|| output.endsWith("?")) {
			this.sentenceCount++;
		}
		if (this.hasNext()) {
			this.wordCount++;
		}
		return output;
	}

	public int getWordCount() {
		return this.wordCount;
	}

	public int getSentenceCount() {
		return this.sentenceCount;
	}

}