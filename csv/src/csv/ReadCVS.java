package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCVS {

	public static ArrayList[] arrayOfStringList = new ArrayList[5];

	public static void main(String[] args) {

		ReadCVS obj = new ReadCVS();
		// obj.run();

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<String> run(int num) {

		String csvFile = "E://Java/csv/Base.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			int i = 0;
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				ArrayList<String> result = new ArrayList<String>();

				// use a comma as a delimiter
				String[] base = line.split(cvsSplitBy);
				String a = base[0];
				result.add(a);
				String b = base[1];
				result.add(b);
				String c = base[2];
				result.add(c);
				String d = base[3];
				result.add(d);
				String e = base[4];
				result.add(e);

				arrayOfStringList[i] = result;
				i++;
				// System.out.println("должность: " + base[0] + ", ФИО: " +
				// base[1] + ", " + base[2] + " дней отпуска" + ", с: " +
				// base[3] + " по: " + base[4]);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// System.out.println("Готово");
		return arrayOfStringList[num];
	}

	public static int getLength() {

		return arrayOfStringList.length - 1;

	}

}