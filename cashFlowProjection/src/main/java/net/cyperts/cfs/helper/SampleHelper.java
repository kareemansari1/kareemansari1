package net.cyperts.cfs.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.sample;

public class SampleHelper {

	public static boolean checkExcelFormat(MultipartFile file) {
		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}

	}

	// convert excel to list of products
	public static List<sample> convertExcelToListOfProduct(InputStream is) {
		List<sample> list = new ArrayList<>();
		try {

			XSSFWorkbook workbook = new XSSFWorkbook(is);

			int sheetCount = workbook.getNumberOfSheets();

			for (int i = 0; i < sheetCount; i++) {
				XSSFSheet s1 = workbook.getSheetAt(i);

				int rowNumber = 0;

				Iterator<Row> iterator = s1.iterator();

				while (iterator.hasNext()) {
					Row row = iterator.next();
					if (rowNumber == 0) {
						rowNumber++;
						continue;
					}
					Iterator<Cell> ceIterator = row.iterator();
					int cid = 0;
					sample s = new sample();
					while (ceIterator.hasNext()) {
						Cell cell = ceIterator.next();

						switch (cid) {
						case 0:
							s.setId((int)cell.getNumericCellValue());
							break;
						case 1:
							s.setParticulars((String)cell.getStringCellValue());
							break;
						case 2:
							s.setNote((String)cell.getStringCellValue());
							break;
						case 3:
							s.setAs_at_31_March_2022_IGAAP((double)cell.getNumericCellValue());
						case 4:
							s.setIndasentries1((double)cell.getNumericCellValue());
						case 5:
							s.setAs_at_31_March_2022_Ind_AS((double)cell.getNumericCellValue());
						case 6:
							s.setAs_at_31_March_2022((double)cell.getNumericCellValue());
						case 7:
							s.setYearended31march2022((double)cell.getNumericCellValue());
						case 8:
							s.setAs_at_31_March_2021_IGAAP((double)cell.getNumericCellValue());
						case 9:
							s.setIndasentries2((double)cell.getNumericCellValue());
						case 10:
							s.setIndasregroup2((double)cell.getNumericCellValue());
						case 11:
							s.setAs_at_31_March_2021_Ind_AS((double)cell.getNumericCellValue());
						case 12:
							s.setAs_at_31_March_2021_Ind_AS2((double)cell.getNumericCellValue());
						case 13:
							s.setAs_at_31_March_2020_IGAAP((double)cell.getNumericCellValue());
						case 14:
							s.setIndasentries3((double)cell.getNumericCellValue());
						case 15:
							s.setIndasregroup3((double)cell.getNumericCellValue());
						case 16:
							s.setAs_at_31_March_2020_Ind_AS((double)cell.getNumericCellValue());
						case 17:
							s.setAs_at_01_April_2020((double)cell.getNumericCellValue());
						default:
							break;

						}
						cid++;

					}
					list.add(s);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
