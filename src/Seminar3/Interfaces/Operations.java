package Seminar3.Interfaces;

import java.sql.Connection;

public interface Operations {
    void createTable(Connection connection);
    void insertData(Connection connection);
    void readData(Connection connection);

}
