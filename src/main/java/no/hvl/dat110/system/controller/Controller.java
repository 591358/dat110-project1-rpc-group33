package no.hvl.dat110.system.controller;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCClientStopStub;

public class Controller  {
	
	private static int N = 5;
	
	public static void main (String[] args) throws IOException, InterruptedException {
		
		DisplayStub display;
		SensorStub sensor;
		
		RPCClient displayclient,sensorclient;
		
		System.out.println("Controller starting ...");
				
		// create RPC clients for the system
		displayclient = new RPCClient(Common.DISPLAYHOST,Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST,Common.SENSORPORT);
		
		// setup stop methods in the RPC middleware
		RPCClientStopStub stopdisplay = new RPCClientStopStub(displayclient);
		RPCClientStopStub stopsensor = new RPCClientStopStub(sensorclient);
		
		
		// TODO - START
		
		// create local display and sensor stub objects
		// connect to sensor and display RPC servers
		// read value from sensor using RPC and write to display using RPC
		displayclient.connect();
		sensorclient.connect();
		display = new DisplayStub(displayclient);
		sensor = new SensorStub(sensorclient);
		
		for(int i = 0; i<N;i++) {
			
			Thread.sleep(1000);
			display.write("" + sensor.read());
		}
		
		// TODO - END
		
		stopdisplay.stop();
		stopsensor.stop();
	
		displayclient.disconnect();
		sensorclient.disconnect();
		
		System.out.println("Controller stopping ...");
		
	}
}
