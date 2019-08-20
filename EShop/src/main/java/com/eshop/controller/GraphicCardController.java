package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.GraphicCard;
import com.eshop.service.GraphicaCardService;

@RestController
@RequestMapping(value = "/cards")
public class GraphicCardController {
	@Autowired
	private GraphicaCardService gCardService;

	@GetMapping(value = "/getCards")
	public List<GraphicCard> getCards() {
		return gCardService.getCards();
	}
	
	@PostMapping(value = "/create-card")
	public GraphicCard createCard(@RequestBody GraphicCard graphicCard) {
		gCardService.save(graphicCard);
		return graphicCard;
	}
}
