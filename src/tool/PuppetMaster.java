package tool;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * description Db helper
 * author Melo Chan
 * date 2017/12/25
 * version 0.0.0.1
 */
@SuppressWarnings({"unused", "WeakerAccess", "JavaDoc"})
public final class PuppetMaster {

    private static boolean usePool = false;

    private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&useSSL=false",
            user = "root",
            password = "melody";

    private static final String config = "jdbc/local";

    public static final Gson gson = new GsonBuilder().setLenient().create();

    private static DataSource pool;

    private Connection connection;

    private PreparedStatement preparedStatement;

    private Statement batchStatement;

    public PuppetMaster() {
        init();
    }

    private void init() {
        if (!usePool) return;

        try {
            if (pool == null) {
                Context env = (Context) new InitialContext().lookup("java:comp/env");
                if (env != null) pool = ((DataSource) env.lookup(config));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        try {
            if (usePool) {
                init();
                return pool.getConnection();
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection(url, user, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void close() {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (batchStatement != null) batchStatement.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * insert and get primary key
     *
     * @param sql    sql
     * @param params params
     * @return -1 while exception occurs
     * 0 while fail
     * the primary key (id usually) while succeed
     */
    public int insert(String sql, Object... params) {
        connection = getConnection();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                handleParams(preparedStatement, params);
                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    ResultSet resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()) return resultSet.getInt(1);
                } else return rows;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        return -1;
    }

    /**
     * update
     *
     * @param sql    sql
     * @param params params
     * @return -1 while exception occurs
     * the row count else
     */
    public int update(String sql, Object... params) {
        connection = getConnection();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                handleParams(preparedStatement, params);
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        return -1;
    }

    /**
     * raw query
     *
     * @param sql    sql
     * @param params params
     * @return null while exception occurs
     * a result set else
     */
    public ResultSet queryRaw(String sql, Object... params) {
        connection = getConnection();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                handleParams(preparedStatement, params);
                return preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * query
     *
     * @param sql    sql
     * @param params params
     * @return empty list while error occurs or empty query
     * an array list of hash table else
     */
    public List<Map<String, Object>> query(String sql, Object... params) {
        connection = getConnection();
        List<Map<String, Object>> result = new ArrayList<>();

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                handleParams(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet != null) {
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    while (resultSet.next()) {
                        Map<String, Object> item = new Hashtable<>();

                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            Object value = resultSet.getObject(i);
                            if (value != null) item.put(metaData.getColumnLabel(i), value);
                        }

                        result.add(item);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        return result;
    }

    /**
     * query to get a list of beans
     *
     * @param sql    sql
     * @param clazz  bean type class
     * @param params params
     * @param <T>    bean type
     * @return a list of beans
     */
    public <T> List<T> query(String sql, Class<T> clazz, Object... params) {
        connection = getConnection();
        List<T> result = new ArrayList<>();

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                handleParams(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet != null) {
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    while (resultSet.next()) {
                        Map<String, Object> item = new Hashtable<>();

                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            Object value = resultSet.getObject(i);
                            if (value != null) item.put(metaData.getColumnLabel(i), value);
                        }

                        result.add(gson.fromJson(gson.toJson(item), clazz));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        return result;
    }

    /**
     * query the first one
     *
     * @param sql    sql
     * @param params params
     * @return the first one
     * null if none queried
     */
    public Map<String, Object> get(String sql, Object... params) {
        connection = getConnection();

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                handleParams(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet != null) {
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    if (resultSet.next()) {
                        Map<String, Object> item = new Hashtable<>();

                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            Object value = resultSet.getObject(i);
                            if (value != null) item.put(metaData.getColumnLabel(i), value);
                        }

                        return item;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        return null;
    }

    /**
     * query the first one as a bean
     *
     * @param sql    sql
     * @param params params
     * @return the first one as a bean
     * null if none queried
     */
    public <T> T get(String sql, Class<T> clazz, Object... params) {
        connection = getConnection();

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                handleParams(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet != null) {
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    if (resultSet.next()) {
                        Map<String, Object> item = new Hashtable<>();

                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            Object value = resultSet.getObject(i);
                            if (value != null) item.put(metaData.getColumnLabel(i), value);
                        }

                        return gson.fromJson(gson.toJson(item), clazz);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        return null;
    }

    /**
     * get the value at first low first column
     *
     * @param sql    sql
     * @param params params
     * @return the value
     * null if none queried
     */
    public Object getValue(String sql, Object... params) {
        connection = getConnection();

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                handleParams(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet != null && resultSet.next())
                    if (resultSet.getMetaData().getColumnCount() > 0)
                        return resultSet.getObject(1);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        return null;
    }

    /**
     * methods below {@link #beginBatch()} {@link #addBatch(String)} {@link #commit(int)} about batch
     */
    public PuppetMaster beginBatch() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            connection.setAutoCommit(false);
            batchStatement = connection.createStatement();
        }

        return this;
    }

    public PuppetMaster addBatch(String sql) throws SQLException {
        if (batchStatement != null) batchStatement.addBatch(sql);
        return this;
    }

    public boolean commit(int check) throws SQLException {
        if (batchStatement != null) {
            Connection connection = batchStatement.getConnection();
            int[] results = batchStatement.executeBatch();

            boolean result = results.length == check;

            if (!result) connection.rollback();
            else connection.commit();

            batchStatement.close();
            connection.setAutoCommit(true);
            connection.close();

            return result;
        }

        return false;
    }

    /**
     * to handle page
     *
     * @param source source sql with out limit
     * @param page   page start with 0
     * @param row    row count
     * @return the sql with limit
     */
    public static String handlePage(String source, String page, String row) {
        try {
            return handlePage(source, Integer.parseInt(page), Integer.parseInt(row));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return source;
    }

    public static String handlePage(String source, int page, int row) {
        return source + " limit " + page * row + ", " + (page * row + row);
    }

    private static void handleParams(PreparedStatement statement, Object... params) throws SQLException {
        if (params != null && params.length > 0)
            for (int i = 0; i < params.length; i++) {
                Object param = params[i];
                if (param instanceof Integer) statement.setInt(i + 1, (int) param);
                else statement.setString(i + 1, String.valueOf(param));
            }
    }
}
