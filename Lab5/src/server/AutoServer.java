

package server;

import java.util.Properties;
import model.Automobile;

public interface AutoServer {

	public void serve(int port);
	public Automobile acceptPropertiesObject(Properties props);

}
