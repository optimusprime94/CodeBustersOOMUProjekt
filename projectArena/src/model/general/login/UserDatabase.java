/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.general.login;

import static java.lang.Integer.parseInt;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class handles the communication between ARENA and the database in
 * regards to user credentials
 *
 * @author S153977
 */
public class UserDatabase {

    private UserDatabase() {
    }

    /**
     * This function takes a username, and return true if it exists in the
     * database.
     *
     * @param name
     * @return
     */
    public static boolean getUser(String name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String getUser = "select userName from arenaUser where userName = '" + name + "'";
            ResultSet resultSet = statement.executeQuery(getUser);

            while (resultSet.next()) {
                if (resultSet.getString(1).matches(name)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        return false;
    }

    /**
     * This function takes a username, and returns the corresponding password
     * from the database.
     *
     * @param name
     * @return
     */
    public static String getPassword(String name) {
        String password = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String getUser = "select userPassword from arenaUser where userName = '" + name + "'";
            ResultSet resultSet = statement.executeQuery(getUser);
            while (resultSet.next()) {
                password = resultSet.getString(1);
                return (password);
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return password;
    }
        public static String getUserId(String name) {
        String userID = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String getUser = "select userID from arenaUser where userName = '" + name + "'";
            ResultSet resultSet = statement.executeQuery(getUser);
            while (resultSet.next()) {
                userID = resultSet.getString(1);
                return (userID);
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return userID;
    }

    /**
     * this function takes a username, and returns the integer associated with
     * its type
     *
     * @param name
     * @return
     */
    public static int getUserType(String name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String getUser = "select userType from arenaUser where userName = '" + name + "'";
            ResultSet resultSet = statement.executeQuery(getUser);
            while (resultSet.next()) {
                String userType = resultSet.getString(1);
                return (parseInt(userType));
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return -1;
    }

    public static void newUser(String name, String password, int type) {
        try {
            InetAddress adress = InetAddress.getLocalHost();
            String ipAdress = adress.getHostAddress();
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String getUser = "insert into arenaUser(userName, userPassword, userType, ipAdress) values('" + name + "', '" + password + "', " + type + ", '" + ipAdress + "')";
            statement.executeUpdate(getUser);
            connection.close();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    public static void updateUser(String name, String password, int type) {
        try {

            if (type == 0) {
                type = UserDatabase.getUserType(name);
            }
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String updateUser = "UPDATE arenaUser SET userPassword ='" + password + "', userType = " + type + " WHERE userName = '" + name + "';";
            statement.executeUpdate(updateUser);
            connection.close();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    /* tar bort användaren från databasen genom namn sökning. */

    public static void deleteUser(String name) {

    

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String deleteUser = "DELETE FROM arenaUser WHERE userName ='" + name + "';";
            statement.executeUpdate(deleteUser);
            connection.close();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }


    public static void updateIpAdress(String name) {
        try {
            InetAddress adress = InetAddress.getLocalHost();
            String ipAdress = adress.getHostAddress();
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String getUser = "UPDATE arenaUser SET ipAdress ='" + ipAdress + "' WHERE userName = '" + name + "';";
            statement.executeUpdate(getUser);
            connection.close();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    public static ObservableList<String> showUser() {
        String userInfo = "";
        ObservableList<String> names = FXCollections.observableArrayList();
        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlserver://hitsql-db.hb.se:56077;database=dbtht1629;user=dbtht1629;password=hiss99");
            Statement statement = connection.createStatement();
            String getUser = "SELECT * FROM arenaUser";
            ResultSet resultSet = statement.executeQuery(getUser);
            while (resultSet.next()) {
                userInfo = "Id: " + resultSet.getString(1) + " Name: " + resultSet.getString(2) + " Password: " + resultSet.getString(3);
                names.add(userInfo);

            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return names;
    }

}
