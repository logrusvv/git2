package vovik.java.webapp.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Vovik
 * 3/3/2019
 */

public interface SqlTransaction<T> {
    T execute(Connection conn) throws SQLException;
}
