package session3_homework1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class thread3 extends Thread {
        private BlockingQueue queue;
	public thread3(BlockingQueue q) {
		queue = q;
	}
       
    public void run() {
		for(int i = 0; i < 100; i++) {
			try {
                        String line = queue.readQueue(i) ;
                        thread3.appendStringToFile(line);
			} catch (InterruptedException e) {
				
			}
                        catch(IOException e) {	
		}
		}
	}

  public static void appendStringToFile(String line ) throws IOException {
		File file = new File("result.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write(line + "\n");
		fw.close();
	}
     
}
