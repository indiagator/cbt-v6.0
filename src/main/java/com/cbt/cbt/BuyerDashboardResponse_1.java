package com.cbt.cbt;

import pojo.Human;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet(name = "BuyerDashboardResponse_1", value = "/BuyerDashboardResponse_1")
public class BuyerDashboardResponse_1 extends HttpServlet {

    private Path fileUserDataPath;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"username\":\"Prateek\"}");
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        Human user = new Human();

        Set<Human> userProfileDataSet = new LinkedHashSet<>();

        Jsonb jsonB = JsonbBuilder.create();


        Path p1 = Paths.get("C:\\Users\\Prateek\\Dropbox\\Training Projects and Files\\Demos\\Edureka\\cbt\\src\\main\\resources\\data\\userprofile.csv");
        //String pathString = p1.toString();
        this.fileUserDataPath = p1.toAbsolutePath();
        BufferedReader in_user_data;

        in_user_data = Files.newBufferedReader(this.fileUserDataPath);

        String line;

        while((line = in_user_data.readLine())!=null)
        {
            Human h = jsonB.fromJson(line,Human.class);
            userProfileDataSet.add(h);
        }

        user = null;

        for (Human h : userProfileDataSet)
        {
            if(h.getUsername().equals(username))
            {
                user = h;
                break;
            }
        }

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if ( user != null )
        {
            String userJsonString = jsonB.toJson(user);
            out.print(userJsonString);
        }
        else
        {
            out.print("{\"res\":\"dne\" }");
        }

        //out.print("{\"username\":\""+name+"\"}");
        out.flush();
        out.close();



    }
}
