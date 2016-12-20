package csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ReadDocxFile {

	public static void main(String[] args) {

		try {
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
			for (XWPFParagraph p : dok.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {
					for (XWPFRun r : runs) {
						String text = r.getText(0);
						if (text != null && text.contains("Поле1")) {
							text = text.replace("Поле1", "ЗАМЕНА");
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
