package io.pgJtester.SQLOperation;



import io.pgJtester.Common.Sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Delete extends Sql {

    public Delete(String sql) {
        this.queryType="delete";
        this.sql=sql;
    }
    public byte[] execute(Connection conn) throws SQLException, IOException, UnsupportedOperationException {
        log.debug("executing Sql:{}", getSql());
        int count=0;
        String res;
        try{
            stmt = conn.createStatement();
            stmt.executeUpdate(getSql());
            count=stmt.getUpdateCount();
            res="update " + count + " rows";
            conn.commit();
        } catch (Exception e){
            throw new SQLException("Delete error");
        } finally {
            stmt.close();
        }
        return res.getBytes();
    }

}


