package com.entitylogic.cards.controller;

import com.entitylogic.cards.controller.response.GetCardsResponse;
import com.entitylogic.cards.dto.CardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/v1/cards")
class CardsController {

    @GetMapping
    public GetCardsResponse getCardsResponse(@RequestParam long customerId) {
        log.info("Get cards for customerId = {}", customerId);
        List<CardDto> cardsList = List.of(new CardDto(1, "1234-5678-9012-3456", LocalDate.now().plusMonths(12), new BigDecimal(25000)));
        return GetCardsResponse.of(cardsList);
    }
}
