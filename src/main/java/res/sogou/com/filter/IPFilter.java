package res.sogou.com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wefit on 16/2/8.
 */
public class IPFilter implements Filter {
   private String ip;

   public void init(FilterConfig filterConfig){
      ip = filterConfig.getInitParameter("ip");
      System.out.println(filterConfig.getFilterName()+":"+ip);
   }

   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
           throws IOException, ServletException{
      String clientIp = request.getRemoteAddr();
      HttpServletResponse httpServletResponse = (HttpServletResponse)response;
      HttpServletRequest httpServletRequest = (HttpServletRequest)request;
      httpServletResponse.setContentType("text/html;charset=UTF-8");
      String uri = httpServletRequest.getRequestURI();
      System.out.println("clientIp:"+clientIp+" uri:"+uri);

      if (clientIp.equals(ip) && uri.indexOf("login")<0) {
         /*
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/hello.vm");
         requestDispatcher.forward(request, response);
         */
         httpServletResponse.sendRedirect("./views/login.jsp");
         return;
      }
      filterChain.doFilter(request, response);
      //response.resetBuffer();
     // response.getWriter().print("<p>Filter:after doFilter</p>");

   }

   public void destroy(){
      System.out.println(this.getClass()+":destory");
   }
}
