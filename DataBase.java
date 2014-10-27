/*******************************************************************************
 * This class is the database "control tower" that manage all kinds of data    *
 * base performances; save, read, and delete.                                  *
 * When the users adds a customer to the data base the save method, which      *
 * allows you to save in a table, is called. When the user cancel a registrat- *
 * ion, the delete method is called. Finally, the read method is called every  *
 * time we open the program, in that way the Link List gets pupulated from the *
 * database.                                                                   *
 *                                                                             *
 * Developed by         : Santiago De La Torre.                                *
 * Last Modification    : April 8 2011.                                        *
 * Educational Center   : Bunker Hill Community College.                       *
 *******************************************************************************
 */
package collosusairlines;
import java.sql.*;


 class DataBase {

    private Statement statement = null;
    private Connection connection = null;
    private ResultSet resultset = null;
    private static final String DataBase = "jdbc:mysql://localhost:3306/cAirlines";

    public void Save(Node saveNode) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DataBase, "santi", "santi");
        statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO customersdata(Name, LastName,Address,"
                + "City, State,ZipCode,Flight, Seat)VALUES('"
                + saveNode.sName + "','" + saveNode.sLstName + "','" + saveNode.sstAddress + "','"
                + saveNode.sCity + "','" + saveNode.sState + "','" + saveNode.sZip + "','"
                + saveNode.iFlight + "','" + saveNode.iSeat + "')");
        connection.close();
        statement.close();
    }
    public LinkedList Read() throws ClassNotFoundException, SQLException {
        LinkedList temp = new LinkedList();
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DataBase, "santi", "santi");
        statement = connection.createStatement();
        resultset = statement.executeQuery("SELECT Name, LastName,Address,"
                + "City, State,ZipCode,Flight, Seat FROM customersdata ");
        while (resultset.next())
            temp.addCustomer(new Node(resultset.getObject(1).toString(), resultset.getObject(2).toString(), resultset.getObject(3).toString(), resultset.getObject(4).toString(), resultset.getObject(5).toString(), resultset.getObject(6).toString(), Integer.parseInt(resultset.getObject(7).toString()), Integer.parseInt(resultset.getObject(8).toString())));
        connection.close();
        statement.close();
        resultset.close();
        return temp;
    }

    public void Delete(String name) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DataBase, "santi", "santi");
        statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM customersdata WHERE Name=" + "'" + name + "'");
        connection.close();
        statement.close();
    }
}
