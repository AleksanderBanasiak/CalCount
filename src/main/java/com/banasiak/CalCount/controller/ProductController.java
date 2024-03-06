package com.banasiak.CalCount.controller;

import com.banasiak.CalCount.dto.ProductDto;
import com.banasiak.CalCount.model.user.User;
import com.banasiak.CalCount.service.ProductService;
import com.banasiak.CalCount.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

import static com.banasiak.CalCount.mapper.ProductMapper.mapProductDtoToProduct;
import static com.banasiak.CalCount.validation.ProductValidation.checkIsProductValid;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/products/create")
    public String createProduct(Model model){
        model.addAttribute("product", new ProductDto());
        return "product_add";
    }
    @PostMapping("products/save")
    public String saveProduct(@ModelAttribute ProductDto productDto, Principal principal, Model model){
        if (!checkIsProductValid(productDto)) {
            model.addAttribute("product", new ProductDto());
            model.addAttribute("flag", true);
            return "product_add";
        }
        productDto.setUser(userService.findUserByName(principal.getName()));
        productService.saveProduct(mapProductDtoToProduct(productDto));
        return "redirect:/main";
    }


}
