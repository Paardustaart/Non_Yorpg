package nl.max.non_yorpg.network;

import java.io.IOException;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class GameServer {
	
	private Server server; // Kryonet server instance.
	
	public GameServer(int tcpPort, int udpPort) throws IOException {
		
		// Instantiate kryonet sever and register classes to the server instance.
		server = new Server();
		Shared.register(server);
		
		// Start server and bind to TCP and UDP ports.
		server.start();
		server.bind(tcpPort, udpPort);
		
		// Add object listener to the server.
		server.addListener(new Listener(){
			
			@Override
			public void connected(Connection connection) {
				
			}
			
			
			@Override
			public void received(Connection connection, Object object) {
				
			}
			
			
			@Override
			public void disconnected(Connection connection) {
				
			}
			
		});
	}
	
}
