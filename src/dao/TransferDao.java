package dao;

import Utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class TransferDao {
    public void out(String out,double money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Connection con = DataSourceUtils.getConnection();
        String sql = "update transfer set money=money-? where name=?";
        qr.update(con,sql,money,out);
    }

    public void in(String in,double money)throws SQLException{
        QueryRunner qr = new QueryRunner();
        Connection con = DataSourceUtils.getConnection();
        String sql = "update transfer set money=money+? where name=?";
        qr.update(con,sql,money,in);
    }
}
