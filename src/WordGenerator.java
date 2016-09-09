import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {
	
	public Scanner scanner;
	private boolean hasNext;
	private String next;
	private int wordCount;
	private int sentenceCount;
	
	
	public WordGenerator (String filename) throws IOException {
		this.scanner = new Scanner(new File(filename));
		this.hasNext = this.scanner.hasNext();
		this.next = this.scanner.next();
		this.wordCount = 0;
		this.sentenceCount = 0;
	}
	
	public boolean hasNext() {
		if (this.hasNext) {
			return true;
		} else {
			return false;
		}
	}
	
	public String next() {
		if (this.next.endsWith(".") 
				|| this.next.endsWith("!")
				|| this.next.endsWith("?")) {
			this.sentenceCount++;
		}
		this.wordCount++;
		return this.next;
	}
	
	public int getWordCount() {
		return this.wordCount;
	}
	
	public int getSentenceCount() {
		return this.sentenceCount;
	}
	
}