package net.mims.minnlakes;

import net.mims.minnlakes.domain.FishSpecies;
import net.mims.minnlakes.domain.Waterbody;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.lang.StringBuilder;
import java.net.URL;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteMinnDataToExcel {
	public WriteMinnDataToExcel(ArrayList<Waterbody> waterbodies) {
		
		ClassLoader classloader =
				   org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
				URL res = classloader.getResource(
				             "org/apache/poi/poifs/filesystem/POIFSFileSystem.class");
				String path = res.getPath();
				System.out.println("POI Core came from " + path);

				//classloader = org.apache.poi.ooxml.POIXMLDocument.class.getClassLoader();
				//res = classloader.getResource("org/apache/poi/POIXMLDocument.class");
				//path = res.getPath();
				//System.out.println("POI OOXML came from " + path);

				classloader = org.apache.poi.hslf.usermodel.HSLFSlideShow.class.getClassLoader();
				res = classloader.getResource("org/apache/poi/hslf/usermodel/HSLFSlideShow.class");
				path = res.getPath();
				System.out.println("POI Scratchpad came from " + path);

		@SuppressWarnings("resource")
		Workbook workbook = new HSSFWorkbook();


		Sheet sheet = workbook.createSheet();
		// Create a row and put some cells in it. Rows are 0 based.
		Row row  = sheet.createRow(0);
		
		row.createCell(1).setCellValue("STATE_CODE");
		row.createCell(2).setCellValue("STATE_NAME");
		row.createCell(3).setCellValue("COUNTY_NAME");
		row.createCell(4).setCellValue("LAKE_NAME");
		row.createCell(5).setCellValue("ACRES");
		row.createCell(6).setCellValue("LATITUDE");
		row.createCell(7).setCellValue("LONGITUDE");
		row.createCell(8).setCellValue("FISH_SPECIES");
		
		


		// Iterate over data and write to sheet
		
		int rownum = 1;
		HashSet<FishSpecies> fishes;
		
		String fishList;
		
		for (Waterbody waterbody : waterbodies) {
			row = sheet.createRow(rownum);
			
			row.createCell(1).setCellValue(waterbody.getStateCode());
			row.createCell(2).setCellValue(waterbody.getStateName());
			row.createCell(3).setCellValue(waterbody.getCountyName());
			row.createCell(4).setCellValue(waterbody.getLakeName());
			row.createCell(5).setCellValue(waterbody.getAcres());
			row.createCell(6).setCellValue(waterbody.getLatitude());
			row.createCell(7).setCellValue(waterbody.getLongitude());
			
			fishes = (HashSet<FishSpecies>) waterbody.getFishSpeciesList();
			fishList = "";

			for (FishSpecies fish : fishes) {

				fishList += fish.getFishTypeName() + ", ";

			}

			fishList = fishList.trim();

			StringBuilder sb = new StringBuilder(fishList);

			sb.deleteCharAt(fishList.length() - 1);
						
			row.createCell(8).setCellValue(sb.toString());
			
			
			rownum++;
			
			
			
			
			
		}
		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("MinnLakeData2.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("MinnLakeData.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}