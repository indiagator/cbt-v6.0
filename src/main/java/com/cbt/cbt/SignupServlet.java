package com.cbt.cbt;

import pojo.Human;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@WebServlet(name = "signup-servlet", value = "/signup-servlet")
public class SignupServlet extends HttpServlet {

    private Map<String,String> userSet;
    private Path fileUsernamePath;

    @Override
    public void init() throws ServletException {
        super.init();
        userSet = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        BufferedReader in_usernames;
        BufferedWriter out_usernames;

        Human human = null;

        String username = request.getParameter("username_signup");
        String password = request.getParameter("password_signup");

        human = new Human(username,password);

        Path p1 = Paths.get("C:\\Users\\Prateek\\Dropbox\\Training Projects and Files\\Demos\\Edureka\\cbt\\src\\main\\resources\\data\\usernames.csv");
        String pathString = p1.toString();

        this.fileUsernamePath = p1.toAbsolutePath();

        in_usernames = Files.newBufferedReader(this.fileUsernamePath);

        String firstLine = in_usernames.readLine(); // first Line is already read!

        String line;

        //parsing data from the second line
        while((line = in_usernames.readLine())!=null)
        {
            String[] tempUserdataLine = line.split(",");
            //userSet.add(new Human(tempUserdataLine[0],tempUserdataLine[1]));
            userSet.put(tempUserdataLine[0],tempUserdataLine[1]); // [0] username, [1] password
        }

        in_usernames.close();

        String userStatus;

        if(userSet.containsKey((String)username))
        {
            userStatus = "ue"; // user exists
        }
        else
        {
            out_usernames = Files.newBufferedWriter(this.fileUsernamePath);

            //userSet.add(human);
            userSet.put(username,password);
            userStatus = "uc"; // user created

            out_usernames.write("USERNAME,PASSWORD\n");

            for(Map.Entry<String,String> h : userSet.entrySet())
            {
                out_usernames.write(h.getKey()+","+h.getValue()+"\n");
            }

            out_usernames.flush();
            out_usernames.close();
        }


        request.setAttribute("path",pathString);
        request.setAttribute("firstLine",firstLine);
        request.setAttribute("userStatus",userStatus);

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request,response);


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
