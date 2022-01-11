package ru.lanit.at.DBConnector;
//STEP 1. Import required packages

import java.sql.*;

public class JDBCPostgreSQL {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://178.154.246.238:58083/hrm";
    static final String USER = "tester";
    static final String PASS = "ITrGOw3N";

    public static void main(String[] args) throws SQLException {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

        //getTables(connection);

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM core_employee");



        //Получаем список имен столбцов таблицы core_employee
/*        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rsmd.getColumnName(i));
        }*/

        //Получаем список имен и фамилий из таблицы core_employee

         while (rs.next()) {
                System.out.println(rs.getString(2)+" "+rs.getString(3));
            }


        connection.close();


    }

    public static void getTables(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        String[] types = {"TABLE"};
        //Retrieving the columns in the database
        ResultSet tables = metaData.getTables(null, null, "%", types);
        while (tables.next()) {
            System.out.println(tables.getString("TABLE_NAME"));
        }


    }
}






    

















