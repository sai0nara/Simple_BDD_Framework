package steps.api;

import java.sql.*;
import java.util.ArrayList;

public class Connector implements Fixturable {
    private static final String DB_URL = "jdbc:postgresql://178.154.246.238:58083/hrm";
    private static final String USER = "tester";
    private static final String PASS = "ITrGOw3N";
    private static final String DRIVER = "org.postgresql.Driver";

    public static void main(String[] args) {
//        try (Connection connection = connectToDatabase();
//                Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM core_employee;");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getString(3));
//                System.out.println(resultSet.getString(4));
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        System.out.println(getFixture(Tables.getEmployees()));
        System.out.println(getFixture(Tables.getProjects()));
        System.out.println(getFixture(Tables.getPositions()));
    }

    public static ArrayList<Integer> getFixture(String queryFrom) {
        ArrayList<Integer> result = new ArrayList<>();
        try (Connection connection = connectToDatabase();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + queryFrom);
            while (resultSet.next()) {
                result.add(Integer.valueOf(resultSet.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Connection connectToDatabase() {
        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        return connection;
    }
}
