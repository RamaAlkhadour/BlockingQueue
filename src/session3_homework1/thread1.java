
package session3_homework1;

public class thread1 extends Thread {
    
        private BlockingQueue queue;
       
	public thread1(BlockingQueue q) {
		queue = q;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			try {
                        String inf = "data\\f"+i+".txt" ;
                        queue.add2Queue(inf);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                   
                }
        }
        
	
}

	



    
		

