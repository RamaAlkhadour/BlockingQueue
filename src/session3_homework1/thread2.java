
package session3_homework1;
import java.io.*;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;


public class thread2 extends Thread {
  
    private BlockingQueue queue;
    public thread2(BlockingQueue q) {
		queue = q;
	}
    public void run() {
		
        for(int i=0;i<100;i++) {
            String readfile="";
            try {
            readfile= queue.readQueue(i);
            String content=thread2.readFileAsString("C:\\Users\\Alexander\\Documents\\NetBeansProjects\\"+readfile);
            int numL=0;
            int numD=0;
            int rest=0;
            for(int j=0;j<content.length();j++) {
                if(Character.isLetter(content.charAt(j)))
                    numL++;
            else if(Character.isDigit(content.charAt(j)))
                    numD++;
            else
                    rest++;
			}
            String m =String.format(readfile+"Of %d Letters ,Of %d Digits ,and %d rest ", numL,numD,rest);
				queue.add2Queue(m);
				
            }catch(InterruptedException e) {
		System.out.println(e.getClass());
		}
		catch(IOException e) {
				
		}
			
	}
    }
                        
   public static String readFileAsString(String name) throws IOException {
		return new String(Files.readAllBytes(Paths.get(name)));
   }
   
                        
 }
       
       
       
    
