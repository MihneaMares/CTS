package Seminar3;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        SqlOperations sqlDb = new SqlOperations();
        MongoOperations mongoDb = new MongoOperations();

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            sqlDb.createTable(connection);
            sqlDb.insertData(connection);
            sqlDb.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}