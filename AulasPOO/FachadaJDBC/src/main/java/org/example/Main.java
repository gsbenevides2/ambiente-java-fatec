package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        JDBCFacade jdbcFacade = new JDBCFacade();
        jdbcFacade.getConnectionWithPostgreSQL(
                "localhost",
                "5432",
                "facade",
                "postgres",
                "12345678"
        );
        jdbcFacade.executeSQL(
                "INSERT INTO contacts (name, phone) VALUES ('John', '123456789')"
        );
        jdbcFacade.executeSQL(
                "INSERT INTO contacts (name, phone) VALUES ('Mary', '987654321')"
        );

        jdbcFacade = jdbcFacade
                .withPreparedStatement("INSERT INTO contacts (name, phone) VALUES (?,?)")
                .withStringParameter(1, "Robert")
                .withStringParameter(2, "123456789")
                .andExecuteSQL();

        jdbcFacade = jdbcFacade
                .withPreparedStatement("INSERT INTO contacts (name, phone) VALUES (:name, :phone)")
                .withStringParameter("name", "Peter")
                .withStringParameter("phone", "123456789")
                .andExecuteSQL();

        jdbcFacade.executeSQLStatement(
                "SELECT name, phone FROM contacts"
        );


        while(jdbcFacade.hasResults()) {
            System.out.println(
                    jdbcFacade.getStringValueFromColumn("name") + " " + jdbcFacade.getStringValueFromColumn("phone")
            );
            jdbcFacade.goToNextRow();
        }

        System.out.println("Contacts with the number is: 123456789");

        jdbcFacade = jdbcFacade
                .withPreparedStatement("SELECT name, phone FROM contacts WHERE phone = :phone")
                .withStringParameter("phone", "123456789")
                .andExecuteSQLStatement();

        while(jdbcFacade.hasResults()) {
            System.out.println(
                    jdbcFacade.getStringValueFromColumn("name") + " " + jdbcFacade.getStringValueFromColumn("phone")
            );
            jdbcFacade.goToNextRow();
        }

        jdbcFacade.liberateConnection();

        
    }
}