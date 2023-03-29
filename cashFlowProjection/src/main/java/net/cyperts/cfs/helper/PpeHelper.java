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

import net.cyperts.cfs.entity.Ppe;

public class PpeHelper {

	// check that file is excel type or not
				public static boolean checkExcelFormatPpe(MultipartFile file)
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
				public static List<Ppe> convertExcelToListPpe(InputStream is)
				{
					List<Ppe> list=new ArrayList<>();
					try
					{
						
					XSSFWorkbook workbook=	new XSSFWorkbook(is);
					
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
						Ppe p = new Ppe();
						while(ceIterator.hasNext())
						{
							 Cell cell = ceIterator.next();	
							 
							 
							 switch (cid) {
							 case 0:
								 p.setId((int)cell.getNumericCellValue());break;
							 case 1:
								 p.setParticulars((String)cell.getStringCellValue());break;
							case 2:
								p.setComputer_HardwareandSoftware((double)cell.getNumericCellValue());
							case 3:
								p.setOffice_Equipment((double)cell.getNumericCellValue());
							case 4:
								p.setLeasehold_Improvements((double)cell.getNumericCellValue());
							case 5:
								p.setFurniture_and_Fixtures((double)cell.getNumericCellValue());
							case 6:
								p.setTotal((double)cell.getNumericCellValue());
								default:
									break;
							
							}
							 cid++;
							
							}
						list.add(p);
					 }
					
					}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					return list;
				}
}
