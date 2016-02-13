package res.sogou.com.controler;

import org.apache.log4j.Logger;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import res.sogou.com.exception.AuthorizationException;
import res.sogou.com.models.User;
import res.sogou.com.validator.UserValidator;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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

    @InitBinder
    public void initBinder(DataBinder binder) {
       // binder.setValidator(new UserValidator());
    }


    public VrController(){

        }

        @RequestMapping(value="user")
        public ModelAndView user(User user){
            log.debug("user:"+user.getUsername());
            ModelAndView mv = new ModelAndView();
            mv.setViewName("user");
            mv.addObject("name", user.getUsername());
            return mv;
        }

        @RequestMapping(value="save")
        public ModelAndView saveUser(@Valid User user, BindingResult bindingResult){
            //UserValidator userValidator = new UserValidator();
            //userValidator.validate(user, bindingResult);

            ModelAndView mv = new ModelAndView("user");
            if (bindingResult.hasErrors()){
                mv.addObject("errors", bindingResult.getFieldError());
            }else{
                mv.addObject("errors", "ok");
            }
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

        @RequestMapping(value="list")
        @ResponseBody
        public Map<String, Object> getUser(){
            Map<String, Object>items = new HashMap<String, Object>();
            items.put("name", "tulianghui");
            return items;
        }

    @RequestMapping(value="json")
    @ResponseBody
    public User getJsonUser(){
        User user = new User();
        user.setUsername("xxx");
        return user;
    }


}
