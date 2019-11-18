package Service;

import Model.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Utils.MySQLConnUtils;
import Utils.TableDb;

public class TableServiceImpl implements TableService {
    private void printSQLException(SQLException ex){
        for (Throwable e:ex){

            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState:"+((SQLException) e).getSQLState());
                System.err.println("Error Code:"+((SQLException) e).getSQLState());
                System.err.println("Message: "+e.getMessage());
                Throwable t=ex.getCause();
                while (t!= null){
                    System.out.println("Cause: "+t);
                    t=t.getCause();
                }
            }
        }
    }

    @Override
    public List<Table> findAll() {
        TableDb tableDb=new TableDb();
        return tableDb.findAll();
    }

    @Override
    public void save(Table table) {
        TableDb tableDb=new TableDb();
        tableDb.save(table);
    }

    @Override
    public Table findById(int id_table) {
        TableDb tableDb=new TableDb();
        return tableDb.findById(id_table);
    }

    @Override
    public void update(int id_table, Table table,int is_available) {
        TableDb tableDb=new TableDb();
        tableDb.update(id_table,table,is_available);
    }

    @Override
    public void remove(int id_table) {
        TableDb tableDb=new TableDb();
        tableDb.remove(id_table);
    }

    @Override
    public List<Table> findEmptyTable() {
        TableDb tableDb = new TableDb();
        return tableDb.findEmptyTable();
    }

    @Override
    public List<Table> tableAction() {
        TableDb tableDb = new TableDb();
        return tableDb.tableAction();
    }
}