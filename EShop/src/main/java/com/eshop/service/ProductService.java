package com.eshop.service;

import com.eshop.entity.Cpu;
import com.eshop.entity.GraphicCard;
import com.eshop.entity.Ram;

public interface ProductService {

	void save(Cpu cpu);

	void save(Ram ram);

	void save(GraphicCard graphicCard);

}
