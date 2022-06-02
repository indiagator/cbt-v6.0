package com.cbt.cbt;

import org.json.simple.JSONObject;
import pojo.Human;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet(name = "userprofile-update", value = "/userprofile-update")
public class UserProfileUpdate extends HttpServlet {

    private Path fileUserDataPath;


    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Set<Human> userProfileDataSetOld = new LinkedHashSet<>();
        Set<Human> userProfileDataSetNew = new LinkedHashSet<>();

        Jsonb jsonB = JsonbBuilder.create();

        Path p1 = Paths.get("C:\\Users\\Prateek\\Dropbox\\Training Projects and Files\\Demos\\Edureka\\cbt\\src\\main\\resources\\data\\userprofile.csv");
        //String pathString = p1.toString();
        this.fileUserDataPath = p1.toAbsolutePath();
        BufferedReader in_user_data;
        in_user_data = Files.newBufferedReader(this.fileUserDataPath);

        //String firstLine = in_user_data.readLine();
        String line;

        while((line = in_user_data.readLine())!=null)
        {
            Human h = jsonB.fromJson(line,Human.class);
            userProfileDataSetOld.add(h);
        }

        String username = "";
        String password = "";
        String name = "";
        String emailid = "";
        String phonenumber = "";
        String company = "";
        String country = "";
        String city = "";
        String usertype ="";

        username = request.getParameter("edit_username"); //crumbs
        password = request.getParameter("edit_password"); //crumbs
        name = request.getParameter("edit_name"); //crumbs
        emailid = request.getParameter("edit_emailid"); //crumbs
        phonenumber = request.getParameter("edit_phonenumber"); //crumbs
        company = request.getParameter("edit_company"); //crumbs
        country = request.getParameter("edit_country"); //crumbs
        city = request.getParameter("edit_city"); //crumbs
        usertype = request.getParameter("usertype");

        Human human = new Human(username,password);
        human.setEmailid(emailid);
        human.setPhonenumber(phonenumber);
        human.setName(name);
        human.setCompany(company);
        human.setCountry(country);
        human.setCity(city);
        human.setUsertype(usertype);

        //userProfileDataSetOld.add(human);

        BufferedWriter out_user_data = Files.newBufferedWriter(this.fileUserDataPath);

        for (Human h : userProfileDataSetOld)
        {
            if(!(h.getUsername().equals(human.getUsername())))
            {
                userProfileDataSetNew.add(h);
            }
        }

        userProfileDataSetNew.add(human); // add/update the new entry into the New Set of User Profile Data
        
        for (Human h : userProfileDataSetNew)
        {
            String humanJsonString = jsonB.toJson(h);
            out_user_data.write(humanJsonString+"\n"); //sending stuff back to the BAKERY
        }

        out_user_data.flush();
        out_user_data.close();

        RequestDispatcher view = request.getRequestDispatcher("buyer_dashboard.jsp");
        view.forward(request,response);


        //Iterator<Human> iterator = userProfileDataSet.iterator();

        /*

        do {
            Human temp_human=human;
            String humanJsonString = null;

            if(iterator.hasNext())
            {
                temp_human = iterator.next();
                if((temp_human.getUsername()).equals(human.getUsername()))
                {
                    userProfileDataSet.remove(temp_human); // userProfileDataSet is for USE by the Application Context
                    //userProfileDataSet.add(human); //crumbs
                    //humanJsonString = jsonB.toJson(human);
                    //out_user_data.write(humanJsonString+"\n");
                    temp_human = human;
                }
                else
                {
                    //humanJsonString = jsonB.toJson(temp_human);
                    //out_user_data.write(humanJsonString+"\n");
                }
            }
            humanJsonString = jsonB.toJson(temp_human);
            out_user_data.write(humanJsonString+"\n"); //sending stuff back to the BAKERY
        }while(iterator.hasNext());


        JSONObject json_human = new JSONObject();
        json_human.put("username",human.getUsername());
        json_human.put("password",human.getPassword());
        json_human.put("emailid",human.getEmailid());
        json_human.put("phonenumber",human.getPhonenumber());
        json_human.put("name",human.getName());
        json_human.put("company",human.getCompany());
        json_human.put("country",human.getCountry());
        json_human.put("city",human.getCity());

        //json_human.toJSONString();


        */





    }
}
