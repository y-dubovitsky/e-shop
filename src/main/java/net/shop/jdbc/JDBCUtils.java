package net.shop.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {

    /**
     * Метод получает sql запрос с параметрами. Выполняет запрос, получает ResultSet -> и преобразует ResultSet в объект
     * благодаря методу из интерфейса public interface ResultSetHandler<T>
     * @param c
     * @param sql - PreparedStatement с параметрами ? ? ?
     * @param resultSet
     * @param parameters - параметры ? ? ?
     * @param <T> - тип возвращаемого объекта
     * @return - возвращает ОБЪЕКТ, который получается путем преобразования ResultSet в T
     * @throws SQLException
     */
    public static <T> T select(Connection c, String sql, ResultSetHandler<T> resultSet, Object... parameters) throws SQLException {
        try(PreparedStatement statement = c.prepareStatement(sql)) {
            populatePreparedStatement(statement, parameters);
            ResultSet rs = statement.executeQuery();
            return resultSet.handler(rs); //! Метод получает ResultSet и получает объекты типа T
        }
    }

    /**
     * Заполняет PreparedStatement параметрами ?, ?, ? - Object... parameters
     * @param ps
     * @param params
     * @throws SQLException
     */
    private static void populatePreparedStatement(PreparedStatement ps, Object... params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]); //? Зачем тут +1?
            }
        }
    }

    private JDBCUtils() {}
}
