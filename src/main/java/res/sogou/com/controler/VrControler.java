package res.sogou.com.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import res.sogou.com.exception.AuthorizationException;

import javax.naming.AuthenticationException;

/**
 * Created by tulianghui117968 on 2016/2/6.
 */

@Controller
@RequestMapping(value="/vr", method = RequestMethod.GET)
public class VrControler extends BaseControler {

    public VrControler(){

    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv,String name ){
        System.out.println("index"+name);
        mv.addObject("name", name);
        mv.setViewName("user");
        return mv;
    }

    @RequestMapping(value="ex")
    public void exTest()throws AuthorizationException{
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

