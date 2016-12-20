package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCVS {

	public static void main(String[] args) {

		ReadCVS obj = new ReadCVS();
		obj.run();

	}

	public void run() {

		String csvFile = "E://Java/csv/Base.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// используем запятую в качестве разделителя
				String[] base = line.split(cvsSplitBy);
				String a = base[0];
				String b = base[1];
				String c = base[2];
				String d = base[3];
				String e = base[4];

				/*
				 * System.out.println("должность: " + base[0] + ", ФИО: " +
				 * base[1] + ", " + base[2] + " дней отпуска" + ", с: " +
				 * base[3] + " по: " + base[4]);
				 */
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
	}

}