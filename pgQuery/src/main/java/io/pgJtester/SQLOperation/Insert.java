package io.pgJtester.SQLOperation;



import io.pgJtester.Common.Sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert extends Sql {
    public Insert(String sql) {
        this.queryType="insert";
        this.sql=sql;
    }
    public byte[] execute(Connection conn) throws SQLException, IOException, UnsupportedOperationException {
        log.debug("executing Sql:{}", getSql());
        int count=0;
        String res;
        try{
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            stmt.executeUpdate(getSql());
            count=stmt.getUpdateCount();
            res="update " + count + " rows";
            conn.commit();
        } catch (Exception e){
            throw new SQLException("Insert error");
        }finally {
            stmt.close();
        }
        return res.getBytes();
    }
}
