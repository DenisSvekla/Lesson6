package dbEntries;

import baseEntity.BaseDBTest;
import core.DataBaseService;
import models.Milestone;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class MilestoneTable extends BaseDBTest {
    public static Logger logger = Logger.getLogger(CustomersTable.class);
    DataBaseService dataBaseService;

    public MilestoneTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable() {
        logger.info("Создаем milestone таблицу");

        String createTableSql = "CREATE TABLE milestones (" +
                "id SERIAL PRIMARY KEY," +
                "name CHARACTER VARYING(30)," +
                "references CHARACTER VARYING(30)," +
                "description CHARACTER VARYING(255)" +
                ")";
        dataBaseService.executeSQL(createTableSql);
    }

    public void dropTable() {
        logger.info("Удаляем milestone таблицу");

        String deleteTableSql = "DROP TABLE milestones";

        dataBaseService.executeSQL(deleteTableSql);
    }

    public ResultSet getAllMilestones() {
        logger.info("Получаем все milestones из таблицы");

        String sql = "SELECT * FROM milestones";

       return dataBaseService.executeQuery(sql);
    }

    public ResultSet getMilestoneByID(int id) {
        logger.info("Получаем  milestone по id");
        String sql = "SELECT * FROM milestones WHERE id = " + id + ";";
        return dataBaseService.executeQuery(sql);
    }

    public ResultSet getMilestoneByName(String name) {
        logger.info("Получаем  milestone по имени");
        String sql = "SELECT * FROM milestones WHERE name = " + name + ";";
        return dataBaseService.executeQuery(sql);
    }



    public void addMilestone(String name, String reference, String description) {
        logger.info("Добавляем запись в таблицу milestones");

        String insertTableSQL = "INSERT INTO public.milestones(" +
                "name, reference, description)" +
                "VALUES ('" + name + "', '" + reference + "', '" + description + "');";

        dataBaseService.executeSQL(insertTableSQL);
    }







}

