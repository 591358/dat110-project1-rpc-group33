package no.hvl.dat110.rpc;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {

	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = new byte[payload.length + 1];

		// TODO - START
		// Encapsulate the rpcid and payload in a byte array according to the RPC
		// message syntax / format
		rpcmsg[0] = rpcid;
		for (int i = 0; i < rpcmsg.length - 1; i++) {
			rpcmsg[i + 1] = payload[i];
		}

		// TODO - END

		return rpcmsg;
	}

	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] payload = new byte[rpcmsg.length - 1];

		// TODO - START

		// Decapsulate the rpcid and payload in a byte array according to the RPC
		// message syntax
		for (int i = 0; i < rpcmsg.length - 1; i++) {
			payload[i] = rpcmsg[i + 1];
		}

		// TODO - END

		return payload;

	}

	// convert String to byte array
	public static byte[] marshallString(String str) {

		byte[] encoded = null;
		
		
		encoded = str.getBytes();

		// TODO - END

		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {

		String decoded = "";
//		char[] results =new char[data.length];
//		for(int i = 0; i<data.length;i++) {
//			results[i] = (char) data[i];
//			decoded+=results[i];
//		}
		decoded = new String(data);
		// TODO - START

		// TODO - END

		return decoded;
	}

	public static byte[] marshallVoid() {

		byte[] encoded = new byte[0];

		// TODO - START

		// TODO - END

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO

	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {

		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else {
			encoded[0] = 0;
		}

		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {

		return (data[0] > 0);

	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {

		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(x);
		byte[] encoded = bb.array();
		// TODO - START

		// TODO - END

		return encoded;
	}

	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {

		int decoded = ByteBuffer.wrap(data).getInt();
		;

		// TODO - START

		// TODO - END

		return decoded;

	}
}
