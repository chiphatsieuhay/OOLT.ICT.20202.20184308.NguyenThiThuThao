package hust.soict.globalict.MemoryDaemon;
import java.lang.Runnable;


public class MemoryDaemon implements Runnable{
	long memoryUsed;
	public void run(){
		Runtime rt = Runtime.getRuntime();
		long used;
		while (true) {
			used = rt.totalMemory() - rt.freeMemory();
			if(used != memoryUsed) {
				System.out.println("\tMemory used = " + used);
				memoryUsed = used;
			}
		}
	}

}
