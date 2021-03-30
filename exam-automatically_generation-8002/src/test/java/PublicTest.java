import com.huade.ExamAutomaticallyGeneration;
import com.huade.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest(classes = ExamAutomaticallyGeneration.class)
public class PublicTest {

    @Test
    void name() {
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String Date=temp.format(date);
        System.out.println(Date);
        System.out.println(DateUtils.getNow_String());
    }
}
