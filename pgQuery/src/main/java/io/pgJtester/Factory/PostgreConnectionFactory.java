package io.pgJtester.Factory;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

@Data
public class PostgreConnectionFactory implements ConnectionFactory{
    private final static Logger log= LoggerFactory.getLogger(PostgreConnectionFactory.class);
    String driverPath;
    String dbPath;
    String user;
    String password;
    Connection connection;
    public PostgreConnectionFactory(String driverPath, String user, String password){
        this.driverPath=driverPath;
        this.user=user;
        this.password=password;
    }
    public void initConnection() {

        try {
            if (connection!=null)
                return;
            Class.forName(driverPath);
            connection = DriverManager
                    .getConnection(dbPath,
                            user, password);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException("Cannot get PostgreSql connection",e);
        }
    }
    public Connection fetchConnection(){
        if (connection!=null)
            return connection;
        else
            initConnection();
        return connection;
    }
    public void close(){
        try {
            if(connection !=null)connection.close();
        } catch (Exception e) {
            throw new RuntimeException("Cannot close connection",e);
        }
    }

}

