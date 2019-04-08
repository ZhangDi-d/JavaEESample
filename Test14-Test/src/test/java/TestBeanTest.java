import com.ryze.TestBean;
import com.ryze.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xueLai on 2019/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class   })
@ActiveProfiles("prod")
public class TestBeanTest {
    @Autowired
    private TestBean testBean;

    @Test
    public void  testProfile(){
        String content = testBean.getContent();
        System.out.println("content :"+content);

    }
}
