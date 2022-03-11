package Seminar3.AppConstants;

public class SqlConstants {
    public static String sqlDrop = "DROP TABLE IF EXISTS employees";
    public static String sqlCreate = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
            + "name TEXT, address TEXT, salary REAL)";
    public static String sqlInsert = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
    public static String sqlSelect = "SELECT * FROM employees";
    public static String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";
}
