package dao;

import Utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UsercheckDao {
    public Long checkusername(String name){
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from userinfo where name=?";
        Long query = null;
        try {
            query = (Long) queryRunner.query(sql,new ScalarHandler(),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
