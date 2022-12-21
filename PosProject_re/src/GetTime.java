
import java.text.SimpleDateFormat;
import java.util.Date;


public class GetTime implements Runnable{

    @Override
    public void run() {
        try{
            while(true){
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
                String time = format.format(date);
                Thread.sleep(1000);
            }
        }catch(Exception e){e.printStackTrace();}
    }
    
}
