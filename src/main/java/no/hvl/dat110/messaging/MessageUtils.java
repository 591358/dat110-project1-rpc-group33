package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[128];
		byte[] data;
		
		// TODO - START
		data = message.getData();
		int length = data.length;
		segment[0] = (byte) length;
		for(int i = 0; i<length;i++) {
			segment[i+1] = data[i]; 
		}
		
		
			
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		int length = segment[0];
		// TODO - START
		// decapsulate segment and put received payload data into a message
		byte[] decapsulated = new byte[length];
		
		for(int i = 0; i<length;i++) {
			decapsulated[i] = segment[i+1];
		}
		message = new Message(decapsulated);
		
		// TODO - END
		
		return message;
		
	}
	
}
