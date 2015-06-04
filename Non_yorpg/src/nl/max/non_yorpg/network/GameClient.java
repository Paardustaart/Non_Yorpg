package nl.max.non_yorpg.network;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class GameClient {
	
	private Client client; // Kryonet client instance.
	
	public GameClient(String host, int tcpPort, int udpPort) throws IOException {
		
		// Instantiate kryonet client and register classes to the client instance.
		client = new Client();
		Shared.register(client);
		
		// Start client and bind to the Host, TCP and UDP ports.
		client.start();
		client.connect(5000, host, tcpPort, udpPort);
		
		// Add object listener to the client.
		client.addListener(new Listener(){
			
			@Override
			public void received(Connection connection, Object object) {
				
			}
			
		});
	}
	
}
