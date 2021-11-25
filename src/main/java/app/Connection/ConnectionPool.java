package app.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    static {
        try {
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/network_db");
            cpds.setUser("root");
            cpds.setPassword("root");
        } catch (PropertyVetoException e) {

        }
    }

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    private ConnectionPool(){}
}
