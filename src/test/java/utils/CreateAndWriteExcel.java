package utils;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CreateAndWriteExcel extends XLSCBCS{	
	
	public CreateAndWriteExcel(String xlsName) throws RowsExceededException, WriteException, IOException{
		super(xlsName);		
	}
	
	public CreateAndWriteExcel inDirectory(String reportPath) throws RowsExceededException, WriteException, IOException{
		directoryName = reportPath;
		File file = new File(directoryName);
		
		if( ! file.exists()){
			file.mkdirs();
		}			
		
		return this;
	}	
	
	
	public CreateAndWriteExcel createWorkbook(String text) throws IOException, RowsExceededException, WriteException{
		File file = new File(directoryName + "/" + xlsName);
		if( ! file.exists()){
			file = new File(file.getPath());
			createXls(Workbook.createWorkbook(file.getAbsoluteFile()), text);
		}
		return this;
	}
	
	public void addRow(String... columns) throws IOException, WriteException{
		File file = new File(directoryName + "/" + xlsName);
		WritableWorkbook workbook = null;
		Workbook wb = null;
		WritableSheet sheet = null;
		
		try {
			if(file.exists()){
				
				wb = Workbook.getWorkbook(file);
				workbook = Workbook.createWorkbook(file, wb);
				
				for(int h=0; h<7; h++){						
					sheet = workbook.getSheet(h);
					sheet.addCell(new Label(3, 2, columns[0]));					
					
				}
				//sheet = workbook.getSheet(0);
				//sheet.addCell(new Label(0, 2, columns[0]));	
				/*for(int i=2; i<5; i++){				
				sheet.addCell(new Label(0, i, columns[0]));				
				};*/										
		
			}else{
				System.err.println("File does not exist");
			}	
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
			if(workbook != null){				
				workbook.write();
				workbook.close();
			}
			
			if(wb != null){
				wb.close();
			}
		}
	}	
	
	private void createXls(WritableWorkbook workbook, String Text) throws RowsExceededException, WriteException, IOException{
		WritableSheet sheet = workbook.createSheet("Orders",0); 
		//sheet.addCell(new Label(0, 0, Text));
		workbook.write();
        workbook.close();
	}
	
	
}