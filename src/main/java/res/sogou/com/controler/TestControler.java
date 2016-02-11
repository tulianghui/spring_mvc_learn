package res.sogou.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wefit on 16/2/11.
 */
@Controller
@RequestMapping(value="test")
public class TestControler {
    @RequestMapping(value="ex")
    public void  exTest()throws  Exception{
        throw new Exception("test exTest");
    }
}
