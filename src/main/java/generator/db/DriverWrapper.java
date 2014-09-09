/**
 * 
 */
package generator.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;

/**
 * @author tspaulding
 *
 */
public class DriverWrapper implements Driver {
    private Driver driver;
    
    public DriverWrapper(Driver driver)
    {
        this.driver = driver;
    }
    
    public Connection connect(String url, Properties info) throws SQLException
    {
        return driver.connect(url, info);
    }
    
    public boolean acceptsURL(String url) throws SQLException
    {
        return driver.acceptsURL(url);
    }
    
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException
    {
        return driver.getPropertyInfo(url,info);
    }
    
    public int getMajorVersion()
    {
        return driver.getMajorVersion();
    }
    
    public int getMinorVersion()
    {
        return driver.getMinorVersion();
    }
    
    public boolean jdbcCompliant()
    {
        return driver.jdbcCompliant();
    }

	public java.util.logging.Logger getParentLogger()
			throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return driver.getParentLogger();
	}
}
