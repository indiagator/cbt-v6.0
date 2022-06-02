package com.cbt.cbt;

import pojo.Human;
import pojo.Product;

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
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "send-product-list", value = "/send-product-list")
public class SendProductList extends HttpServlet {

    private Path fileProductListPath;

    @Override
    public void init() throws ServletException {
        super.init();

        Path p1 = Paths.get("C:\\Users\\Prateek\\Dropbox\\Training Projects and Files\\Demos\\Edureka\\cbt\\src\\main\\resources\\data\\hscodes.csv");
        this.fileProductListPath = p1.toAbsolutePath();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        List<Product> productList = new LinkedList<>();
        Jsonb jsonB = JsonbBuilder.create();
        BufferedReader in_product_data;
        in_product_data = Files.newBufferedReader(this.fileProductListPath);

        String line;
        while((line = in_product_data.readLine())!=null)
        {
            Product product = jsonB.fromJson(line,Product.class);
            productList.add(product);
        }

        String productListJson = jsonB.toJson(productList);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        out.print(productListJson);

        out.flush();
        out.close();




    }


}
