package dao;

import java.util.List;

public interface FileDao {
    List<String> readFile(String fileName);
}