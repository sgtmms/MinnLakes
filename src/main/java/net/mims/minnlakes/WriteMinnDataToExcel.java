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
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;


public class WriteMinnDataToExcel 
{
 public WriteMinnDataToExcel( ArrayList<Waterbody> waterbodies) 
 {
 
  XSSFWorkbook workbook = new XSSFWorkbook(); 
  
  XSSFSheet sheet = workbook.createSheet("Minnesota Data");
   
  //This data needs to be written (Object[])
  Map<String, Object[]> data = new TreeMap<String, Object[]>();
  data.put("1", new Object[] {"STATE_CODE", "STATE_NAME", "COUNTY_NAME", "LAKE_NAME", "ACRES", "LATITUDE", "LONGITUDE", "FISH_SPECIES"});
  data = loadDataToMap(data, waterbodies);
   
  //Iterate over data and write to sheet
  Set<String> keyset = data.keySet();
  int rownum = 0;
  for (String key : keyset)
  {
      Row row = sheet.createRow(rownum++);
      Object [] objArr = data.get(key);
      int cellnum = 0;
      for (Object obj : objArr)
      {
         Cell cell = row.createCell(cellnum++);
         if(obj instanceof String)
              cell.setCellValue((String)obj);
          else if(obj instanceof Integer)
              cell.setCellValue((Integer)obj);
      }
  }
  try 
  {
   //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(new File("MinnLakeData.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println("MinnLakeData.xlsx written successfully on disk.");
  } 
  catch (Exception e) 
  {
      e.printStackTrace();
  }
 }
 //{"STATE_CODE", "STATE_NAME", "COUNTY_NAME", "LAKE_NAME", "ACRES", "LATITUDE", "LONGITUDE", "FISH_SPECIES"}
   Map <String, Object[]> loadDataToMap(Map<String, Object[]> data, ArrayList<Waterbody> waterbodies) {
     
     int row = 2;
     
     String fishList = "";
     
     for(Waterbody waterbody : waterbodies){
     
         HashSet<FishSpecies> fishes = waterbody.getFishSpeciesList();
         
         
         
         for(FishSpecies fish : fishes) {
          
             fishList += fish.getFishTypeName() + ", "; 
          
         } 
         
         fishList = fishList.trim();
         
         StringBuilder sb = new StringBuilder(fishList);
         
         sb.deleteCharAt(fishList.length()-1);
         
         Integer rowNumber = new Integer(row);
         
         data.put(rowNumber.toString(), new Object[] {waterbody.getStateCode(), waterbody.getStateName(),
                      waterbody.getCountyName(), waterbody.getLakeName(), waterbody.getAcres().toString(),
                      waterbody.getLatitude().toString(), waterbody.getLongitude().toString(), sb.toString()});
                      
         row++;
         
     
     }
     
     
     return data;
     
     
   
   
   } 
   
 
}