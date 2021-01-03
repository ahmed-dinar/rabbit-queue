package com.bs23.rabbit.controller;

import com.bs23.rabbit.messaging.RabbitPublisher;
import com.bs23.rabbit.model.FundTransfer;
import com.bs23.rabbit.repository.FundTrasnferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author Ahmed Dinar
 * Created 1/3/2021
 */

@Slf4j
@Controller
public class HomeController {

  final private RabbitPublisher publisher;
  final private FundTrasnferRepository ftRepo;

  public HomeController(RabbitPublisher publisher, FundTrasnferRepository ftRepo) {
    this.publisher = publisher;
    this.ftRepo = ftRepo;
  }

  @GetMapping("/ft")
  public String fundTransfer() {
    return "ft";
  }

  @GetMapping("/ft/create")
  public String createFundTransfer() {
    return "ft_create";
  }

  @PostMapping("/ft/create")
  public String fundTransfer(@Valid FundTransfer fundTransfer, BindingResult result) {
    log.info("fundTransfer --> " + fundTransfer);
    if (result.hasErrors()) {
      return "redirect:/ft/create";
    }

    fundTransfer = ftRepo.save(fundTransfer);
    publisher.publish(fundTransfer);

    return "redirect:/ft/create";
  }
}
