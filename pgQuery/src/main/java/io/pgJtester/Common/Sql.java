package io.pgJtester.Common;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Data
public abstract class Sql {
    protected String sql;
    protected String queryType;
    static protected Logger log = LoggerFactory.getLogger(Sql.class);
    private String queryTimeout = "";
    protected Statement stmt;
    protected ResultSet rs;
    public abstract byte[] execute(Connection conn) throws SQLException, IOException, UnsupportedOperationException;
    //public abstract byte[] execute(Connection conn) throws SQLException, IOException, UnsupportedOperationException;
    protected void setQueryTimeout(Statement stmt, int timeout) throws SQLException {
        if(timeout >= 0) {
            stmt.setQueryTimeout(timeout);
        }
    }
    //    public int getIntegerQueryTimeout() {
//        int timeout;
//        if(StringUtils.isEmpty(queryTimeout)) {
//            return 0;
//        } else {
//            try {
//                timeout = Integer.parseInt(queryTimeout);
//            } catch (NumberFormatException nfe) {
//                timeout = 0;
//            }
//        }
//        return timeout;
//    }
    public static void close(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            log.warn("Error closing Statement {}", s, e);
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            log.warn("Error closing ResultSet", e);
        }
    }

}
