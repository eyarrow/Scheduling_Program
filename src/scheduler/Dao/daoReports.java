package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Type;
import scheduler.util.dbOperations;

import java.sql.ResultSet;
import java.sql.SQLException;

public class daoReports {

    public static ObservableList<Type> returnTypeAggregatesDAO() {
        ObservableList<Type> aggregate = FXCollections.observableArrayList();
        ResultSet rs;

        for(String type: Type.returnTypes()) {
            String TYPE_SUM_QUERY = String.format("select count(*) from appointments where Type = '%s';", type);
            try {
                rs = dbOperations.dbQuery(TYPE_SUM_QUERY);
                while(rs.next()) {
                    int sum = rs.getInt("count(*)");
                    Type t = new Type(sum, type);
                    aggregate.add(t);
                }
            }
            catch(SQLException e) {
                e.printStackTrace();
            }

        }




        return aggregate;
    }
}
