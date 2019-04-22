package session3_homework1;


public class Session3_homework1 {
 
    
    
    public static void main(String[] args)throws InterruptedException {
        
        // تعريف الرتل الأول والنيسب من النوع الأول
        BlockingQueue queue1=new BlockingQueue (100);
        thread1 first = new thread1(queue1);
        
        //تعريف الرتل الثاني ومصفوفة لتعريف ثمانية نياسب من النوع الثاني
        BlockingQueue queue2=new BlockingQueue (100);
        thread2 []second = new thread2[8];  
        for(int i = 0; i < 8; i++){
            second[i]=new thread2 (queue2);
         }
        
        //تعريف النيسب من النوع الثالث
        thread3 third = new thread3(queue2);
 
       //ارسال الثريدات للجدولة
        first.start();  
         for(int i = 0; i < 8; i++){
            second[i].start();
         }
        third.start();
        
        //الانتظار حتى تنفذ الثريدات عملها
        try {
            first.join();
            for(int i = 0; i < 8; i++){
            second[i].join();}
            third.join();
                        
        } catch (InterruptedException e) {
		e.printStackTrace();
			}
    }
    
}
