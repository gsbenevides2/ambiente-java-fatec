package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDBCFacade {
    private Connection connection = null;
    private ResultSet resultSet = null;
    PreparedStatement statement = null;
    List<String> parameters = new ArrayList<>();

    public void getConnectionWithPostgreSQL(String ipAddress, String port, String databaseName, String username, String password) throws SQLException {
        String connectionUrl = "jdbc:postgresql://" + ipAddress + ":" + port + "/" + databaseName;
        connection = DriverManager.getConnection(connectionUrl, username, password);
    }
    public void executeSQL(String sql) throws SQLException {
        if(connection == null) throw new IllegalCallerException("Please call first getConnectionWithPostgreSQL method");
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    public void executeSQLStatement(String sqlStatement) throws SQLException {
        if(connection == null) throw new IllegalCallerException("Please call first getConnectionWithPostgreSQL method");
        PreparedStatement statement = connection.prepareStatement(sqlStatement);
        ResultSet resultSet1 = statement.executeQuery();
        if(resultSet1.next()) resultSet = resultSet1;
        else resultSet = null;
    }
    public boolean hasResults() throws SQLException {
         if(resultSet != null) return true;
         else return false;
    }
    public String getStringValueFromColumn(String columnName) throws SQLException {
        if(resultSet == null) throw new IllegalCallerException("Please call first executeSQLStatement method");
        return resultSet.getString(columnName);
    }
    public void goToNextRow() throws SQLException{
        if(resultSet == null) throw new IllegalCallerException("Please call first executeSQLStatement method");
        if(!resultSet.next()) resultSet = null;
    }
    public void liberateConnection() throws SQLException{
        if(connection == null) throw new IllegalCallerException("Please call first getConnectionWithPostgreSQL method");
        connection.close();
    }
    public void prepareSQLWithParameters(String sql) throws SQLException {
        if(connection == null) throw new IllegalCallerException("Please call first getConnectionWithPostgreSQL method");
        String regex = "\\:([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(sql);
        while(matcher.find()) {
            parameters.add(matcher.group(1));
        }
        sql = sql.replaceAll(regex, "?");
        statement = connection.prepareStatement(sql);
    }
    public void setStringParameter(String parameterName, String parameterValue) throws SQLException{
        if(statement == null) throw new IllegalCallerException("Please call first prepareSQLWithParameters method");
        int parameterIndex = parameters.indexOf(parameterName) + 1;
        if(parameterIndex == 0) throw new IllegalCallerException("Not found parameter with name " + parameterName + " in SQL statement");
        this.setStringParameter(parameterIndex, parameterValue);

    }
    public void setStringParameter(int parameterIndex, String parameterValue) throws SQLException {
        if(statement == null) throw new IllegalCallerException("Please call first prepareSQLWithParameters method");
        statement.setString(parameterIndex, parameterValue);
    }
    public void executeSQL() throws SQLException {
        if(statement == null) throw new IllegalCallerException("Please call first prepareSQLWithParameters method");
        statement.execute();
        statement = null;
        parameters.clear();
    }
    public void executeSQLStatement() throws SQLException {
        if(statement == null) throw new IllegalCallerException("Please call first prepareSQLWithParameters method");
        ResultSet resultSet1 = statement.executeQuery();
        if(resultSet1.next()) resultSet = resultSet1;
        else resultSet = null;
        statement = null;
        parameters.clear();
    }

    // Fluent API

    public JDBCFacade withPreparedStatement(String sql) throws SQLException {
        prepareSQLWithParameters(sql);
        return this;
    }
    public JDBCFacade withStringParameter(String parameterName, String parameterValue) throws SQLException {
        setStringParameter(parameterName, parameterValue);
        return this;
    }
    public JDBCFacade withStringParameter(int parameterIndex, String parameterValue) throws SQLException {
        setStringParameter(parameterIndex, parameterValue);
        return this;
    }
    public JDBCFacade andExecuteSQLStatement() throws SQLException {
        executeSQLStatement();
        return this;
    }
    public JDBCFacade andExecuteSQL() throws SQLException {
        executeSQL();
        return this;
    }

}
