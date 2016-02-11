package res.sogou.com.interceptor;

import org.apache.commons.logging.LogFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
/**
 * Created by wefit on 16/2/9.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private Logger log = Logger.getLogger(LoginInterceptor.class);
    private String name;
    private NamedThreadLocal<Long>startTime = new NamedThreadLocal<Long>("req_start");
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){
        log.debug("preHandle:"+this.getName());
        startTime.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView){
        if(log.isDebugEnabled()) {
            log.debug("postHandle");
        }
        log.error("postHandle");
        modelAndView.addObject("name", "xxx");
        System.out.println(".postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex){
        log.info("afterCompletion");
        long endtime = System.currentTimeMillis();
        long starttime = startTime.get();
        log.debug("cost:"+(endtime-starttime)+" ms");
    }
}
