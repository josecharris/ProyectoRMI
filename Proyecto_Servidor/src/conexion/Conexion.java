package conexion;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import logic.ServerImplements;
public class Conexion {
	
	public void createServer(){
		try{
			String ipServer = InetAddress.getLocalHost().getHostAddress();
			System.out.println("IP SERVER : "+ipServer);
			Registry miRegistry = LocateRegistry.createRegistry(1234);
		    miRegistry.rebind("Hello", new ServerImplements());
		    
		    System.out.println("Server Running...");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
