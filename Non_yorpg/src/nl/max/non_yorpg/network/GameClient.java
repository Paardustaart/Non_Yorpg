package nl.max.non_yorpg.network;

import java.io.IOException;

import nl.max.non_yorpg.actors.Player;
import nl.max.non_yorpg.actors.Player.Direction;
import nl.max.non_yorpg.network.Shared.MoveRequest;
import nl.max.non_yorpg.network.Shared.MoveResponse;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class GameClient {
	
	private Client client; // Kryonet client instance.
	
	private Player actor;
	
	public GameClient(String host, int tcpPort, int udpPort, Player actor) throws IOException {
		
		// Set actor instance
		this.actor = actor;
		
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
				
				if(object instanceof MoveResponse) {
					MoveResponse response = (MoveResponse) object;
					actor.move(response.direction);
				}
				
			}
			
		});
	}
	
	public void sendMoveRequest(int x, int y, Direction direction) {
		client.sendTCP(new MoveRequest(x, y, direction));
	}
	
}
