

package server;

import model.Automobile;

public interface AutoServer {
	public void serve(int port);
	public void addAuto(Automobile auto);
	public String avaliableAuto();
}
