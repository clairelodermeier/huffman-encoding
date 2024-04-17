import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FrequencyCalculator {

	FrequencyTable table;
	String fileContent;
	int totalLength;

	public FrequencyCalculator(String fileName) throws IOException {
		this.fileContent = fileToString(fileName);
		this.totalLength = fileContent.length();

		this.table = buildTable();
	}

	public FrequencyTable table() {
		return this.table;
	}

	public String getFileContent() {
		return this.fileContent;
	}

	private FrequencyTable buildTable() {
		// Builds the frequency table and returns it
		FrequencyTable frequencyTable = new FrequencyTable(totalLength);

		// Go character by character and add them to the frequency table
		for (int i = 0; i < totalLength; i++) {
			frequencyTable.add(fileContent.charAt(i));
		}

		return frequencyTable;
	}

	private String fileToString(String fileName) throws IOException {
		String result = "";
		// Turns the contents of the file named fileName into a string
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			StringBuilder stringBuilder = new StringBuilder();

			String line = reader.readLine();
			while (line != null) {
				stringBuilder.append(line);
				line = reader.readLine();
			}
			reader.close();
			result = stringBuilder.toString();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return result;
	}

}
