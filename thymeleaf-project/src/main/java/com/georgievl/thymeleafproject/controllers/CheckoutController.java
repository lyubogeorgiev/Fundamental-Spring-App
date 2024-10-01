package com.georgievl.thymeleafproject.controllers;

import com.georgievl.thymeleafproject.commands.CheckoutCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CheckoutController{

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/checkoutcomlete").setViewName("checkoutcomplete");
//    }

    @RequestMapping("/checkout")
    public String checkoutForm(Model model) {

        model.addAttribute("checkoutCommand", new CheckoutCommand());

        return "checkoutform";
    }

    @RequestMapping(value = "/docheckout", method = RequestMethod.POST)
    public String doCheckout(@Valid CheckoutCommand checkoutCommand,
                             BindingResult bindingResult) {

        System.out.println(bindingResult);
        System.out.println("First name: " + checkoutCommand.getFirstName());
        System.out.println("First name size " + checkoutCommand.getFirstName().length());

        if (bindingResult.hasErrors()) {
            return "checkoutform";
        }

        return "checkoutcomplete";
    }
}
