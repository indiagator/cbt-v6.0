package com.cbt.cbt;

import pojo.Human;
import pojo.Product;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@WebServlet(name = "add-product", value = "/add-product")
public class AddProduct extends HttpServlet {

    private Path fileProductPath;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



            Path p1 = Paths.get("C:\\Users\\Prateek\\Dropbox\\Training Projects and Files\\Demos\\Edureka\\cbt\\src\\main\\resources\\data\\hscodes.csv");
            //String pathString = p1.toString();
            this.fileProductPath = p1.toAbsolutePath();
            List<String> productParameters = new LinkedList<>();
            Jsonb jsonB = JsonbBuilder.create();
            Product newProduct = new Product();
            String productJsonString = null;

            Set<Product> productDataSet = new LinkedHashSet<>();

            BufferedReader in_product_data;
            in_product_data = Files.newBufferedReader(this.fileProductPath);

            String line;
            while((line = in_product_data.readLine())!=null)
            {
                Product product = jsonB.fromJson(line,Product.class);
                productDataSet.add(product);
            }

            productParameters.add(0,request.getParameter("chapter"));
            productParameters.add(1,request.getParameter("hscode"));
            productParameters.add(2,request.getParameter("description"));
            productParameters.add(3,request.getParameter("unit"));

            newProduct.setChapter(productParameters.get(0));
            newProduct.setHscode(productParameters.get(1));
            newProduct.setDescription(productParameters.get(2));
            newProduct.setUnit(productParameters.get(3));

            //check if the product with hscode already exists
        Boolean hscodeExists=false;

        for (Product product : productDataSet)
        {
            if((product.getHscode().equals(newProduct.getHscode())))
            {
                hscodeExists = true;
                break;
            }
        }


        if(!hscodeExists)
        {
            productDataSet.add(newProduct);
        }

        BufferedWriter out_product_data = Files.newBufferedWriter(this.fileProductPath);

        for(Product product : productDataSet)
        {
            String tempProductJsonString = jsonB.toJson(product);
            out_product_data.write(tempProductJsonString+"\n"); //sending stuff back to the BAKERY
        }

        out_product_data.flush();
        out_product_data.close();

        RequestDispatcher view = request.getRequestDispatcher("updateHsvCodes.jsp");
        view.forward(request,response);



        //productJsonString = jsonB.toJson(newProduct);

            //response.setContentType("text/html");
           // PrintWriter writer =  response.getWriter();

           // writer.println("Add Product Servlet is UP! \n");

       // writer.println(productJsonString);

           // writer.println("this is what we got ");

        //writer.println(productParameters.get(0));

        //writer.println(productParameters.get(1));

        //writer.println(productParameters.get(2));

       // writer.println(productParameters.get(3));


       // writer.flush();
           // writer.close();


    }
}
