package service;

import Utils.DataSourceUtils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import dao.TransferDao;

import java.sql.Connection;
import java.sql.SQLException;

public class TransferService {
    public boolean transfer(String out, String in, double money) {

        TransferDao dao = new TransferDao();
        boolean isTransferSuccess = true;
        //转出钱的方法
        Connection connection =  null;
        try {

            //开启事务
            //conn = DataSourceUtils.getConnection();
            //conn.setAutoCommit(false);

            //开启事务
            DataSourceUtils.startTransaction();

            //转出钱的方法
            dao.out(out,money);
            int i = 1/0;
            //转入钱的方法
            dao.in(in,money);

        } catch (Exception e) {
            isTransferSuccess = false;
            //回滚事务
            try {
                DataSourceUtils.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally{
            try {
                DataSourceUtils.commitAndRelease();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isTransferSuccess;
    }
}
