package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YourDatabaseUtil {
    
    public static List<String> retrieveDepartmentsFromDatabase(Connection connection) throws SQLException {
        List<String> sectionNames = new ArrayList<>();
        
        String sql = "SELECT `section_name` FROM `m_section`";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                sectionNames.add(resultSet.getString("section_name"));
                System.out.println(sectionNames);
            }
        }
            return sectionNames;
    }
    public static List<String> retrieveLanguagesFromDatabase(Connection connection) throws SQLException {
        List<String> languages = new ArrayList<>();
        
        String sql = "SELECT language_name FROM m_language";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                languages.add(resultSet.getString("language_name"));
            }
            System.out.println(languages);

        }	
        return languages;
    }
}
