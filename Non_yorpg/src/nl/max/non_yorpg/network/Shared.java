package nl.max.non_yorpg.network;

import nl.max.non_yorpg.actors.Player.Direction;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Shared {
	
	public static void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(MoveRequest.class);
		kryo.register(MoveResponse.class);
		kryo.register(Direction.class);
	}
	
	public static class MoveRequest {
		public int x, y;
		public Direction direction;
		
		public MoveRequest() {}
		public MoveRequest(int x, int y, Direction direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
	
	public static class MoveResponse {
		public int id, x, y;
		public Direction direction;
		
		public MoveResponse(){}
		public MoveResponse(int id, int x, int y, Direction direction) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
	
}
