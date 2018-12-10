package ru.ncedu.simpleweb.utils;

import ru.ncedu.simpleweb.consts.EnvironmentVariables;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBUtils {

    public static Connection getConnection() {
        return getEnvConnection();
    }

    private static Connection getDataSourceConnection() {
        try {
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/simpleweb");
            return dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getEnvConnection() {
        String connectionUrl = System.getenv(EnvironmentVariables.DB_URL);
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
