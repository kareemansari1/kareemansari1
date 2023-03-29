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

import net.cyperts.cfs.entity.NotesForFinancialStatementBSPL;

public class NotesForFinancialStatementHelper {

	// check that file is excel type or not
		public static boolean checkExcelFormat(MultipartFile file)
		{
		String contentType	=file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
		}
		
		// convert excel to list of products
		public static List<NotesForFinancialStatementBSPL> convertExcelToListOfProduct(InputStream is)
		{
			List<NotesForFinancialStatementBSPL> list=new ArrayList<>();
			try
			{
				
			XSSFWorkbook workbook=	new XSSFWorkbook(is);
			//XSSFSheet sheet = workbook.getSheet("sheet");
			
			int sheetCount = workbook.getNumberOfSheets();
			
			for(int i=0;i<sheetCount;i++) {
				XSSFSheet s1 = workbook.getSheetAt(i);
			
			int rowNumber=0;
			
			Iterator<Row> iterator =s1.iterator();	
			
			while(iterator.hasNext())
			{
				Row row =iterator.next();
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
				Iterator<Cell> ceIterator = row.iterator();
				int cid =0;
				NotesForFinancialStatementBSPL n= new NotesForFinancialStatementBSPL();
				while(ceIterator.hasNext())
				{
					 Cell cell = ceIterator.next();	
					 
					 
					 switch (cid) {
					 case 0:
						 n.setId((int)cell.getNumericCellValue());break;
					 case 1:
						 n.setLineItem((String)cell.getStringCellValue());
					case 2:
						n.setNotesForFinancialstatementBSPL((String)cell.getStringCellValue());break;
						default:
							break;
					
					}
					 cid++;
					
					}
				list.add(n);
			 }
			
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}
