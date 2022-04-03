package net.mims.minnlakes;

import net.mims.minnlakes.domain.FishSpecies;
import net.mims.minnlakes.domain.Waterbody;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WriteMinnDataToExcel {
	public WriteMinnDataToExcel(List<Waterbody> waterbodies) throws NoSuchMethodException {


		@SuppressWarnings("resource")
		SXSSFWorkbook workbook = null;
		FileOutputStream fos = null;

		try {

			workbook = new SXSSFWorkbook(100);

		Sheet sheet = workbook.createSheet();
		// Create a row and put some cells in it. Rows are 0 based.
		Row row  = sheet.createRow(0);

		row.createCell(0).setCellValue("STATE_CODE");
		row.createCell(1).setCellValue("STATE_NAME");
		row.createCell(2).setCellValue("COUNTY_NAME");
		row.createCell(3).setCellValue("LAKE_NAME");
		row.createCell(4).setCellValue("ACRES");
		row.createCell(5).setCellValue("LATITUDE");
		row.createCell(6).setCellValue("LONGITUDE");
		row.createCell(7).setCellValue("FISH_SPECIES");



			@SuppressWarnings("unchecked")

		// Iterate over data and write to sheet

		int rownum = 1;
		HashSet<FishSpecies> fishes;

		String fishList;

		for (Waterbody waterbody : waterbodies) {
			row = sheet.createRow(rownum);

			row.createCell(0).setCellValue(waterbody.getStateCode());
			row.createCell(1).setCellValue(waterbody.getStateName());
			row.createCell(2).setCellValue(waterbody.getCountyName());
			row.createCell(3).setCellValue(waterbody.getLakeName());
			row.createCell(4).setCellValue(waterbody.getAcres());
			row.createCell(5).setCellValue(waterbody.getLatitude());
			row.createCell(6).setCellValue(waterbody.getLongitude());

			fishes = (HashSet<FishSpecies>) waterbody.getFishSpeciesList();
			fishList = "";

			for (FishSpecies fish : fishes) {

				fishList += fish.getFishTypeName() + ", ";

			}

			fishList = fishList.trim();

			StringBuilder sb = new StringBuilder(fishList);

			sb.deleteCharAt(fishList.length() - 1);

			row.createCell(7).setCellValue(sb.toString());

			if (rownum % 100 == 0) {
				// retain 100 last rows and flush all others
				((SXSSFSheet) sheet).flushRows(100);
			}

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


	} catch (NullPointerException npe){
			npe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

		public String capitalizeInitialLetter (String s){
			if (s.length() == 0)
				return s;
			return s.substring(0, 1).toUpperCase() + s.substring(1);
		}

	}