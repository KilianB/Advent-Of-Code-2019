package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.xml.transform.stream.StreamSource;

/**
 * Utility reader to handling file read operations
 * 
 * @author Kilian
 *
 */
public class InputReader implements AutoCloseable {

	BufferedReader br;

	public InputReader(String fileName) throws FileNotFoundException {
		br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName)));
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

	/**
	 * @return the next line of the file
	 * @throws IOException
	 */
	public String next() throws IOException {
		return br.readLine();
	}

	/**
	 * @return The next line of the file as integer
	 * @throws IOException
	 */
	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	public int[] asInt(String delimiter) throws IOException {
		String[] tokens = next(delimiter);

		int[] integers = new int[tokens.length];
		
		for(int i = 0; i < tokens.length; i++) {
			integers[i] = Integer.parseInt(tokens[i]);
		}
		return integers;
	}

	public String[] next(String delimiter) throws IOException {
		return br.readLine().split(delimiter);
	}

	/**
	 * Convert the input file to a list of strings split at the line break
	 * 
	 * @return a list of the file content
	 * @throws IOException
	 */
	public List<String> asList() throws IOException {
		List<String> input = new ArrayList<>();
		while (ready()) {
			input.add(next());
		}
		return input;
	}

	/**
	 * Convert the input file to an integer stream
	 * 
	 * @return a list of the file content
	 * @throws IOException
	 */
	public IntStream asIntStream() throws IOException {
		List<Integer> input = new ArrayList<>();
		while (ready()) {
			input.add(nextInt());
		}
		return input.stream().mapToInt(Integer::intValue);
	}
	
	
	public List<Integer> asIntList() throws IOException {
		List<Integer> input = new ArrayList<>();
		while (ready()) {
			input.add(nextInt());
		}
		return input;
	}

	@Override
	public void close() {
		try {
			br.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
