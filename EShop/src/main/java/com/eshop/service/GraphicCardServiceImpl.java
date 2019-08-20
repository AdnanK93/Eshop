package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.GraphicCard;
import com.eshop.repository.GraphicCardRepository;

@Service
public class GraphicCardServiceImpl implements GraphicaCardService{
	@Autowired
	private GraphicCardRepository gCardDAO;
	@Autowired
	private ProductService productService;
	@Override
	public List<GraphicCard> getCards() {
		
		return gCardDAO.findAll();
	}
	@Override
	public void save(GraphicCard graphicCard) {
		gCardDAO.save(graphicCard);
		productService.save(graphicCard);
	}
	
}
