package vovik.java.webapp.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Vovik
 * 3/3/2019
 */

public interface SqlExecutor<T> {
    T execute(PreparedStatement st) throws SQLException;
}