package schultz.dustin.io;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uzoka.frank.io.JustGifItApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JustGifItApplication.class)
@WebAppConfiguration
public class JustGifItTests {

	@Test
	public void contextLoads() {
	}

}
