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
			// ���� ���� ������������� ��� ���������� �����������
			XWPFDocument docx = new XWPFDocument(fis);
			// ������� ������ ��������� ����� getParagraphText()
			// �������� ��� ������ ���������
			List<XWPFParagraph> paragraphList = docx.getParagraphs();

			// ���������� paragraphList
			for (XWPFParagraph paragraph : paragraphList) {
				// System.out.println(paragraph.getText());
			}

			FileInputStream doc = new FileInputStream("E://Java/csv/template.docx");
			XWPFDocument dok = new XWPFDocument(doc);
			// ������ ������
			for (XWPFParagraph p : dok.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {
					for (XWPFRun r : runs) {
						String text = r.getText(0);
						if (text != null && text.contains("����1")) {
							text = text.replace("����1", arr.get(0));
							r.setText(text, 0);
						}
						if (text != null && text.contains("����2")) {
							text = text.replace("����2", arr.get(1));
							r.setText(text, 0);
						}
						if (text != null && text.contains("����3")) {
							text = text.replace("����3", arr.get(2));
							r.setText(text, 0);
						}
						if (text != null && text.contains("����4")) {
							text = text.replace("����4", arr.get(3));
							r.setText(text, 0);
						}
						if (text != null && text.contains("����5")) {
							text = text.replace("����5", arr.get(4));
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
			 * (text.contains("���������")) { text = text.replace("���������",
			 * "���"); r.setText(text); } } } } } }
			 */
			dok.write(new FileOutputStream("output.docx"));
			System.out.println("������");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
