package io.pgJtester.common;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class Utils {
    public static String resultSetToString(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();

        StringBuilder sb = new StringBuilder();

        int numColumns = meta.getColumnCount();
        for (int i = 1; i <= numColumns; i++) {
            sb.append(meta.getColumnLabel(i));
            if (i == numColumns) {
                sb.append('\n');
            } else {
                sb.append('\t');
            }
        }
        while (rs.next()) {
            for (int i = 1; i <= numColumns; i++) {
                sb.append(rs.getString(i));
                if (i == numColumns) {
                    sb.append('\n');
                } else {
                    sb.append('\t');
                }
            }
        }
        return sb.toString();
    }

    public static Properties getProperties(String s) throws FileNotFoundException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(new File(s));
            //从class文件路径加载properties文件
            prop.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return prop;
    }
}
