package no.hvl.dat110.rpc.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat110.rpc.RPCUtils;

class TestRPCUtils {

	@Test
	void testDecapsulate() {
		
		byte[] rpcrequest = {0,1,2};
		
		byte[] payload = RPCUtils.decapsulate(rpcrequest);
		
		assertEquals(2,payload.length);
		assertEquals(1,payload[0]);
		assertEquals(2,payload[1]);
		
	}
	
	@Test
	void testEncapsulate() {
		
		byte[] payload = {1,2};
		
		byte[] rpcrequest = RPCUtils.encapsulate((byte)0, payload);
		
		assertEquals(0,rpcrequest[0]);
		assertEquals(1,rpcrequest[1]);
		assertEquals(2,rpcrequest[2]);
		
	}
	

	
	@Test
	void testMarshallString() {
		
		String str = "teststring";
		String str2 = "tests";
		
		byte[] encoded = RPCUtils.marshallString(str);
		byte[] encoded2 = RPCUtils.marshallString(str2);
		String decoded = RPCUtils.unmarshallString(encoded);
		String decoded2 = RPCUtils.unmarshallString(encoded2);
		assertEquals(encoded.length,decoded.length());
		assertEquals(str,decoded);
		assertEquals(str2,decoded2);
	}
	
	@Test
	void testMarshallInteger() {
		
		int testint = 255;
		
		byte[] encoded = RPCUtils.marshallInteger(testint);
		int decoded = RPCUtils.unmarshallInteger(encoded);
		
		assertEquals(testint,decoded);
	}
	
	@Test
	void testMarshallBoolean( ) {
		
		byte[] encoded = RPCUtils.marshallBoolean(true);
		boolean decoded = RPCUtils.unmarshallBoolean(encoded);
		
		assertTrue(decoded);
		
		encoded = RPCUtils.marshallBoolean(false);
		decoded = RPCUtils.unmarshallBoolean(encoded);
		
		assertFalse(decoded);
		
	}
}
