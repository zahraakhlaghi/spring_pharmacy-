package com.mkyong;

import com.mkyong.model.Product;
import com.mkyong.model.User;
import com.mkyong.repository.ProductRepository;
import com.mkyong.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class StartWebApplication implements ApplicationRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartWebApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User("zahra","zahra_akhlaghi","123456","jey street","zahra@email.com","09140069739"));
        userRepository.save(new User("fatemeh","fatemeh_sheybani","123456","123 street","fatemeh@email.com","091000000"));
        userRepository.save(new User("mehrzad","mehrzad_mozafari","123456","456 street","mehrzad@email.com","092000000"));
        productRepository.save(new Product("قرص ویتامین ب12 1000 میکروگرم هلث اید","تقویت حافظه و تمرکز ","https://daroo.com/media/product/28230/fab83504-4aa1-4a9e-9f92-8373cd38e20c/600/600",229000,30,"داروباکس"));
        productRepository.save(new Product("کپسول سلدرین هلث اید","تقویت حافظه و تمرکز ","https://darookhaneonline.com/image/Brands/Mokammel/Health%20Aid/Celadrin%20/health%20aid%20celadrin.jpg",86700,34,"داروباکس"));
        productRepository.save(new Product("قرص یونی زینک ابیان دارو 60 عددی","تقویت حافظه و تمرکز ","https://daroo.com/media/product/28154/9da88c3d-22aa-4b0d-9bd0-ab76c6ed0397/600/600",101900,30,"داروباکس"));
        productRepository.save(new Product("شربت مولتی ویتامین سانستول فارمد 200 میلی لیتر","تقویت حافظه و تمرکز ","https://daroo.com/media/product/28179/b2b49fb6-4ba6-47d9-a0a8-a1396cc87f19/600/600",63800,60,"داروباکس"));
        productRepository.save(new Product("قرص کلسی پاور هولیستیکا 90 عدد","تقویت حافظه و تمرکز ","https://daroo.com/media/product/28422/d0d581ac-98a1-4e65-b296-937f4b02f091/600/600",76700,70,"داروباکس"));
        productRepository.save(new Product("کرم لایه بردار هیدرودرم حاوی 10% اسید گلیکولیک","تقویت حافظه و تمرکز ","https://www.darobox.ir/wp-content/uploads/2020/06/11-300x300.jpeg",27400,30,"داروباکس"));


    }
}
