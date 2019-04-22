
package session3_homework1;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
    
    private List queue;
    private Integer limit;
    public BlockingQueue(Integer limit) {
		this.limit = limit;
		queue = new LinkedList();
               
	}
	
	public void add2Queue (String inf) throws InterruptedException {
             try {
            int size= this.queue.size();
            while(size == this.limit) {
			wait();
		}
		if(size<this.limit) {
			notifyAll();
		} queue.add(inf);
        }catch (InterruptedException e) {
		e.printStackTrace();
	}
        }
	public synchronized String readQueue (int i) throws InterruptedException {
          
                 String target= " ";
         	
            while(this.queue.size() == 0) {
			wait();
		}
                if(this.queue.size() > 0){
		notifyAll();
		target =(String) this.queue.get(i) ;
                }
                return target;
        }
}

