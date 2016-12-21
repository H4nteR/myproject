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

		try {
			ArrayList<String> arr = ReadCVS.run();
			FileInputStream fis = new FileInputStream("E://Java/csv/template.docx");
			// Этот клас используеться для извлечения содержимого
			XWPFDocument docx = new XWPFDocument(fis);
			// Выборка абзаца используя метод getParagraphText()
			// Получаем все пункты документа
			List<XWPFParagraph> paragraphList = docx.getParagraphs();

			// перебераем paragraphList
			for (XWPFParagraph paragraph : paragraphList) {
				// System.out.println(paragraph.getText());
			}

			FileInputStream doc = new FileInputStream("E://Java/csv/template.docx");
			XWPFDocument dok = new XWPFDocument(doc);
			// Замена текста
			for (XWPFParagraph p : dok.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {
					for (XWPFRun r : runs) {
						String text = r.getText(0);
						if (text != null && text.contains("Поле1")) {
							text = text.replace("Поле1", arr.get(0));
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
			dok.write(new FileOutputStream("output.docx"));
			System.out.println("Готово");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
