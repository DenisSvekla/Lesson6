package dbEntries;

import baseEntity.BaseDBTest;
import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class CasesTable extends BaseDBTest {
    public static Logger logger = Logger.getLogger(CustomersTable.class);
    DataBaseService dataBaseService;

    public CasesTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTableSql() {
        logger.info("создаем новую таблицу cases");

        String createTableSQL = "CREATE TABLE cases (" +
                "id SERIAL PRIMARY KEY, " +
                "title CHARACTER VARYING(100), " +
                "preconditions CHARACTER VARYING(255) " +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable () {
        logger.info("Удаляем таблицу cases");
        String deleteTAbleSql = "DROP TABLE cases";
        dataBaseService.executeSQL(deleteTAbleSql);
    }

    public ResultSet getAllCases() {

        logger.info("получаем все Cases");

        String sql = "SELECT * FROM cases";

        return dataBaseService.executeQuery(sql);
    }
    public ResultSet getCaseById(int id) {

        logger.info("получаем case по id");

        String sql = "SELECT * FROM cases WHERE id = "+id+";";

        return dataBaseService.executeQuery(sql);
    }


}
