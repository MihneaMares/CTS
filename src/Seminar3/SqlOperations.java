package Seminar3;

import Seminar3.Interfaces.Operations;

import java.sql.*;

import static Seminar3.AppConstants.SqlConstants.*;

public class SqlOperations implements Operations {

    @Override
    public void createTable(Connection connection) {


        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlDrop);
            statement.executeUpdate(sqlCreate);
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertData(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlInsert);
            statement.close();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlInsertWithParams);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Ionescu Vasile");
            preparedStatement.setString(3, "Brasov");
            preparedStatement.setDouble(4, 4500);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void readData(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            while(rs.next()) {
                int id = rs.getInt("id");
                System.out.println("id: " + id);
                String name = rs.getString(2);
                System.out.println("name: " + name);
                String address = rs.getString("address");
                System.out.println("address: " + address);
                double salary = rs.getDouble("salary");
                System.out.println("salary: " + salary);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
