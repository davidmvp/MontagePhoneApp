package edu.jhu.cs.oose.montage.client.kryonet;

/**
 * Client thread necessary to keep the KryoClient running.
 * @author Greg Kogut
 *
 */
public class ClientThread extends Thread {
	/**Underlying kryoclient.*/
	private volatile boolean running;
	
	/**
	 * ClientThread constructor.
	 */
	public ClientThread() {
		this.running = true;
	}

	@Override
	public void run() {
		long initTime = System.currentTimeMillis();
        while(running)
        {
            if(System.currentTimeMillis() - initTime > 1000)
            {
                initTime = System.currentTimeMillis();
            }
        }
	}
	
	/**
	 * Stops this thread.
	 */
	public void stopThread() {
		this.running = false;
	}
	
}
