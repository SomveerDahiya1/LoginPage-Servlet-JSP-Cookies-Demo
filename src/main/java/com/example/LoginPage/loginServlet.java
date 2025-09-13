package com.example.LoginPage;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


public class loginServlet extends HttpServlet {
     public String name ;
     public String  password ;
     
     @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException , IllegalArgumentException {
        name = request.getParameter("username");
        password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         Cookie[] cookies = request.getCookies();
         boolean userVisit=false ;
         if(cookies!=null)
         {
             for(int i=0 ; i<cookies.length;i++)
             {   Cookie cookie = cookies[i];
                 String name1 = cookie.getName();
                 String value1 = cookie.getValue();
                 if(name1.equals("Name") && value1.equals(name))
                 {
                     out.println("<h1>Welcome Back "+name+"!</h1><h2>How it's going ?</h2>");
                     userVisit=true;
                     break;
                 }
             }
         }
         if(userVisit==false || cookies==null)
         {
          Cookie  userName=  new Cookie("Name",name); //For first visit of User
          response.addCookie(userName);
          out.println("<h1>Welcome " +name+"!</h1>");
         }
    }
}