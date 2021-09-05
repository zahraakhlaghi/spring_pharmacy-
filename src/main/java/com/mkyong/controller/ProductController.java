package com.mkyong.controller;

import com.mkyong.model.Product;
import com.mkyong.repository.ProductRepository;
import com.mkyong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class ProductController {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static List<Product> sales = new ArrayList<>();


    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String showProduct(@RequestParam(name = "id", required = false, defaultValue = "") String id, Model model) throws Exception {

        Product product = productService.getbyId(Integer.valueOf(id));
        String value = String.valueOf(product.getPrice() % 1000);
        LOGGER.info(value);
        if (value.length() == 1)
            value = "00" + value;
        if (value.length() == 2)
            value = "0" + value;

        String price = String.valueOf(product.getPrice() / 1000) + ',' + value + " تومان ";

        model.addAttribute("name", product.getName());
        model.addAttribute("price", price);
        model.addAttribute("company", product.getCompany());
        model.addAttribute("image", product.getImage());
        model.addAttribute("id", product.getId());




        return "product-details";




    }

    @GetMapping("/sale")
    public String saleProduct(@RequestParam(name = "id", required = false, defaultValue = "") String id, Model model) throws Exception {

        if(!id.equals("")) {
            Product product = productService.getbyId(Integer.valueOf(id));
            sales.add(product);
        }
        Integer sum =0;
        for (Product p: sales) {
            sum =sum +  p.getPrice();
        }
        model.addAttribute("products", sales);
        model.addAttribute("sum", sum);
        model.addAttribute("total", sum+1900);

        return "cart";

    }

    @GetMapping("/complete_sale")
    public String saleCompleteProduct(@RequestParam(name = "id", required = false, defaultValue = "") String id, Model model) throws Exception {

        Integer sum =0;

        for (Product p: sales) {
            sum =sum +  p.getPrice();
        }

        model.addAttribute("products", sales);
        model.addAttribute("sum", sum);
        model.addAttribute("total", sum+1900);

        return "checkout";

    }
    @GetMapping("/end_sale")
    public String saleEndProduct(Model model) throws Exception {
        sales = new ArrayList<>();
        return "index";

    }

    @PostMapping("/search")
    public String srearch(
            @RequestParam(value = "search", required = false) String search
            ,Model model) {

        LOGGER.info(search);
        List<Product> productList = productService.search(search);
        model.addAttribute("products", productList);
        LOGGER.info(String.valueOf(productList));
        LOGGER.info(String.valueOf(model));

        return "search";
    }


}
