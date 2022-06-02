package com.cbt.cbt;

import pojo.Human;
import pojo.TestClass;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "hello-servlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    private String message;
    private Path fileUsernamePath;
    private Path fileUserProfilePath;
    //private String username;

    private Map<String,String> userPassMap;

    //private HttpSession session;

    public void init()
    {
        message = "Hello World!";
        //session = null;
        Path p1 = Paths.get("C:\\Users\\Prateek\\Dropbox\\Training Projects and Files\\Demos\\Edureka\\cbt\\src\\main\\resources\\data\\usernames.csv");
        Path p2 = Paths.get("C:\\Users\\Prateek\\Dropbox\\Training Projects and Files\\Demos\\Edureka\\cbt\\src\\main\\resources\\data\\userprofile.csv");
        //String pathString = p1.toString();

        this.fileUsernamePath = p1.toAbsolutePath();
        this.fileUserProfilePath = p2.toAbsolutePath();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.setContentType("text/html");
        // Hello
        //PrintWriter out = response.getWriter();
        //out.println("<html><body>");
        //out.println("<h1>" + message + "</h1>");
        //out.println("</body></html>");

        String username = (String) request.getSession(false).getAttribute("username");

        TestClass tc = new TestClass(username,"9718654234");
        request.setAttribute("obj",tc);
        RequestDispatcher view = request.getRequestDispatcher("buyer_dashboard.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //super.doPost(req, resp);

        userPassMap = new HashMap<>();

        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        BufferedReader in_usernames;
        HttpSession session = null;

        in_usernames = Files.newBufferedReader(this.fileUsernamePath);

        String firstLine = in_usernames.readLine(); // first Line is already read!

        String line;

        //parsing data from the second line
        while((line = in_usernames.readLine())!=null)
        {
            String[] tempUserdataLine = line.split(",");
            userPassMap.put(tempUserdataLine[0],tempUserdataLine[1]);
        }

        String userLoginStatus;

        if(userPassMap.containsKey(username))
        {
            //userStatus = "user exists already";
            if(userPassMap.get(username).equals((String)password))
            {
                userLoginStatus = "authenticated";

                session = req.getSession(true); //creating a new Session object
                session.setMaxInactiveInterval(60); //seconds
                session.setAttribute("username",username); // storing the username as a session variable

                Human user = new Human();
                user.setUsername(username);
                user.setPassword(password);

                Set<Human> userProfileDataSet = new LinkedHashSet<>();
                Jsonb jsonB = JsonbBuilder.create();

                BufferedReader in_user_data;
                in_user_data = Files.newBufferedReader(this.fileUserProfilePath);

                String line_profile_data;

                while((line_profile_data = in_user_data.readLine())!=null)
                {
                    Human h = jsonB.fromJson(line_profile_data,Human.class);
                    userProfileDataSet.add(h);
                }

                for(Human temp_user : userProfileDataSet)
                {
                    if(temp_user.getUsername().equals(username))
                    {
                        user.setUsertype(temp_user.getUsertype());
                    }
                }

                if(user.getUsertype().equals("seller"))
                {
                    RequestDispatcher view_authenticated = req.getRequestDispatcher("seller_dashboard.jsp");
                    view_authenticated.forward(req,resp);
                }
                else
                {
                    RequestDispatcher view_authenticated = req.getRequestDispatcher("buyer_dashboard.jsp");
                    view_authenticated.forward(req,resp);
                }


            }
            else
            {
                userLoginStatus = "incorrect_password";
                req.setAttribute("userLoginStatus",userLoginStatus);
                RequestDispatcher view_not_authenticated = req.getRequestDispatcher("index.jsp");
                view_not_authenticated.forward(req,resp);
            }
        }
        else
        {
            //usernameSet.add(username);
            userLoginStatus = "username_dn_exist";
            req.setAttribute("userLoginStatus",userLoginStatus);
            RequestDispatcher view_not_authenticated = req.getRequestDispatcher("index.jsp");
            view_not_authenticated.forward(req,resp);
        }




        //TestClass tc = new TestClass(username,"9718654234");
        //req.setAttribute("obj",tc);


    }

    public void destroy()
    {
    }
}