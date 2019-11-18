package Service;

import Model.Table;

import java.util.List;

public interface TableService {
    List<Table> findAll();

    void save(Table table);

    Table findById(int id_table);

    void update(int id_table, Table table, int is_available);

    void remove(int id_table);
    List<Table> findEmptyTable();
    List<Table> tableAction();
}
