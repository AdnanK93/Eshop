package com.eshop.service;

import java.util.List;

import com.eshop.entity.GraphicCard;

public interface GraphicaCardService {

	List<GraphicCard> getCards();

	void save(GraphicCard graphicCard);

}
