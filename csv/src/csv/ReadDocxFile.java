package csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import csv.ReadCVS;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ReadDocxFile {

	public static void main(String[] args) {
		int length = ReadCVS.getLength();
		for (int i = 0; i <= length; i++) {
			test(i);
		}
	}

	public static void test(int number) {

		try {
			ArrayList<String> arr = ReadCVS.run(number);
			FileInputStream fis = new FileInputStream("E://Java/csv/template.docx");
			// This class is used to extract the contents
			XWPFDocument docx = new XWPFDocument(fis);
			// get all the items of the document
			List<XWPFParagraph> paragraphList = docx.getParagraphs();

			// iterate paragraphList
			for (XWPFParagraph paragraph : paragraphList) {
				// System.out.println(paragraph.getText());
			}

			FileInputStream doc = new FileInputStream("E://Java/csv/template.docx");
			XWPFDocument dok = new XWPFDocument(doc);
			// replace text

			for (XWPFParagraph p : dok.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {

					for (XWPFRun r : runs) {
						String text = r.getText(0);
						// System.out.print(text.contains("{"));
						// text.contains("{work}");
						// System.out.println(text);
						if (text != null && text.contains("work")) {
							// System.out.println("ВОШЕЛ");
							text = text.replace("work", arr.get(0));
							r.setText(text, 0);
						}
						if (text != null && text.contains("Поле2")) {
							text = text.replace("Поле2", arr.get(1));
							r.setText(text, 0);
						}
						if (text != null && text.contains("Поле3")) {
							text = text.replace("Поле3", arr.get(2));
							r.setText(text, 0);
						}
						if (text != null && text.contains("Поле4")) {
							text = text.replace("Поле4", arr.get(3));
							r.setText(text, 0);
						}
						if (text != null && text.contains("Поле5")) {
							text = text.replace("Поле5", arr.get(4));
							r.setText(text, 0);
						}
					}
				}
			}
			/*
			 * for (XWPFTable tbl : dok.getTables()) { for (XWPFTableRow row :
			 * tbl.getRows()) { for (XWPFTableCell cell : row.getTableCells()) {
			 * for (XWPFParagraph p : cell.getParagraphs()) { for (XWPFRun r :
			 * p.getRuns()) { String text = r.getText(0); if
			 * (text.contains("Должность")) { text = text.replace("Должность",
			 * "фыв"); r.setText(text); } } } } } }
			 */
			dok.write(new FileOutputStream("output_" + number + ".docx"));
			System.out.println("Готово " + number);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
