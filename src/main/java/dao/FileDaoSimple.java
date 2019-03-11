package dao;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileDaoSimple implements FileDao {
    public List<String> readFile(String fileName) {
        List<String> listOfStrings = new ArrayList<String>();
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName), ',', '"');
            List<String[]> tempList = reader.readAll();
            for (String[] s : tempList) {
                listOfStrings.addAll(Arrays.asList(s));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfStrings;
    }
}