package res.sogou.com.controler;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import res.sogou.com.exception.AuthorizationException;
import res.sogou.com.models.User;

/**
 * Created by wefit on 16/2/11.
 */
@Controller
@RequestMapping(value="/vr")
public class VrController extends BaseControler {
    /**
     * Created by tulianghui117968 on 2016/2/6.
     */

    private Logger log = Logger.getLogger(VrController.class);




        public VrController(){

        }

        @RequestMapping(value="user")
        public ModelAndView user(User user){
            log.debug("user:"+user.getName());
            ModelAndView mv = new ModelAndView();
            mv.setViewName("user");
            mv.addObject("name", user.getName());
            return mv;
        }

        @RequestMapping(value="", method = RequestMethod.GET)
        public ModelAndView index(ModelAndView mv, String name ){
            System.out.println("index"+name);
            mv.addObject("name", name);
            mv.setViewName("user");
            return mv;
        }

        @RequestMapping(value="ex")
        public void exTest()throws AuthorizationException {
            throw new AuthorizationException("msg:authorization exception");
        }

        @RequestMapping(value="dex")
        public void dexTest()throws Exception{
            throw new Exception("msg:default exception");
        }

        @ExceptionHandler
        public ModelAndView exception(Exception ex){
            ModelAndView mv = new ModelAndView();
            mv.addObject("ex", ex);
            mv.setViewName("/errors/annotationError");
            return mv;
        }

}
