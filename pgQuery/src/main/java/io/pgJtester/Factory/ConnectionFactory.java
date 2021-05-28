

package io.pgJtester.Factory;

import java.sql.Connection;

public interface ConnectionFactory {
    void initConnection();
    Connection fetchConnection();

}
