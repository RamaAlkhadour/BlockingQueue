
package session3_homework1;

import java.util.LinkedList;
import java.util.List;
//import java.lang.*;

public class BlockingQueue {
	private List queue;
	private Integer limit;
      
        
	public BlockingQueue(Integer limit) {
		this.limit = limit;
		queue = new LinkedList();
	}
        
	/*public synchronized Boolean check(thread1 th) {
		return th.isAlive() ;
	}*/
        
	public synchronized Boolean Empty() {
		return this.queue.isEmpty();
	}
	
	public synchronized void add2Queue(Object o) throws InterruptedException {
		while(this.queue.size() == this.limit) {
			wait();
		}
		if(this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(o);
	}
	public synchronized Object RmQueue() throws InterruptedException {
		while(this.queue.size() == 0){
			wait();
		}
		if(this.queue.size() == this.limit){
			notifyAll();
		}

		return this.queue.remove(0);
	}
}

       
