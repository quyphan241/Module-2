package Utils;

import Model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDb {
    public List<Table> findEmptyTable() {
        List<Table> tables=new ArrayList<>();
        try (Connection connection = MySQLConnUtils.getSqlConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_table,local,capacity,is_available FROM coffee.table_coffee WHERE is_available=1;")) {
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int id_table=rs.getInt("id_table");
                String local=rs.getString("local");
                int capacity=rs.getInt("capacity");
                int is_available=rs.getInt("is_available");
                Table table=new Table(id_table,local,capacity,is_available);
                tables.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tables;
    }
    public List<Table> findAll() {
        List<Table> tables=new ArrayList<>();
        try (Connection connection=MySQLConnUtils.getSqlConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("SELECT id_table,local,capacity,is_available FROM coffee.table_coffee WHERE is_delete=0;")
        ){
            System.out.println(preparedStatement);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id_table");
                String local=rs.getString("local");
                int capacity=rs.getInt("capacity");
                int is_available=rs.getInt("is_available");
                Table table=new Table(id,local,capacity,is_available);
                tables.add(table);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        return tables;
    }
    public void save(Table table) {
        try (Connection connection=MySQLConnUtils.getSqlConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO coffee.table_coffee"+ "(local,capacity) VALUES"+" (?,?);")){
            preparedStatement.setString(1,table.getLocal());
            preparedStatement.setInt(2,table.getCapacity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Table findById(int id_table) {
        Table table=null;
        try (Connection connection=MySQLConnUtils.getSqlConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("SELECT id_table,local,capacity,is_available FROM coffee.table_coffee WHERE id_table=?;")){
            preparedStatement.setInt(1,id_table);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String local=rs.getString("local");
                int capacity=rs.getInt("capacity");
                int is_available=rs.getInt("is_available");
                table=new Table(id_table,local,capacity,is_available);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return table;
    }
    public void update(int id_table, Table table,int is_available) {
        boolean rowUpdated;
        try (Connection connection = MySQLConnUtils.getSqlConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE coffee.table_coffee SET local=?,capacity=?,is_available=? WHERE id_table=?;")) {
            preparedStatement.setString(1, table.getLocal());
            preparedStatement.setInt(2, table.getCapacity());
            preparedStatement.setInt(3, table.getIs_available());
            preparedStatement.setInt(4, id_table);
            rowUpdated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void remove(int id_table) {
        try(Connection connection=MySQLConnUtils.getSqlConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE coffee.table_coffee SET is_delete=1 WHERE id_table=?;")) {
            preparedStatement.setInt(1,id_table);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<Table> tableAction() {
        List<Table> tables=new ArrayList<>();
        try (Connection connection=MySQLConnUtils.getSqlConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("SELECT id_table,local,capacity,is_available FROM coffee.table_coffee WHERE is_available=0;")){
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int id_table=rs.getInt("id_table");
                String local=rs.getString("local");
                int capacity=rs.getInt("capacity");
                int is_available=rs.getInt("is_available");
                Table table=new Table(id_table,local,capacity,is_available);
                tables.add(table);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tables;
    }
}
