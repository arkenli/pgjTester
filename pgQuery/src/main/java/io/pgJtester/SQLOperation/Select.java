package io.pgJtester.SQLOperation;


import io.pgJtester.Common.Sql;
import io.pgJtester.common.Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select extends Sql {
    public Select(String sql) {
        this.queryType="select";
        this.sql=sql;
    }
    public byte[] execute(Connection conn) throws SQLException, IOException, UnsupportedOperationException {
        log.debug("executing Sql:{}", getSql());
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( getSql() );
            conn.commit();
            return Utils.resultSetToString(rs).getBytes();
        } catch (Exception e){
            throw new SQLException("Delete error");
        }finally {
            rs.close();
            stmt.close();
        }
    }

}

