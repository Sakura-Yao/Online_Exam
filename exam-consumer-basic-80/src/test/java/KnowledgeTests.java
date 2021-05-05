import com.huade.ConsumerBasic;
import com.huade.config.FilePathConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ConsumerBasic.class)
public class KnowledgeTests {

    @Autowired
    private FilePathConfiguration filePathConfiguration;
    @Test
    void test(){
        System.out.println(filePathConfiguration);
    }

}
