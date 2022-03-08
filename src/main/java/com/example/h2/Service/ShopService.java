package com.example.h2.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2.Errors.MyClassException;
import com.example.h2.Repository.ICollarRepository;
import com.example.h2.Repository.IShopRepository;
import com.example.h2.dto.CollarResponseDto;
import com.example.h2.dto.ShopResponseDto;


@Service
public class ShopService  {
	
	
	@Autowired
    IShopRepository shopRepository;
	
	@Autowired
	ICollarRepository collarRepository;
	
	
	public List<ShopResponseDto> getAllShops() {
		List<ShopResponseDto> shops = new ArrayList<>();
		shopRepository.findAll().forEach(shop -> shops.add(shop));
		return shops;
	}
	
	public ShopResponseDto getShopById(int id) {
		return shopRepository.findById(id).get();
		
	}
    
	public void SaveorUpdate(ShopResponseDto shop) {
		shopRepository.save(shop);
		
	}
	
	
	public List<CollarResponseDto> getAllCollarsByShop(int id) {
		List<CollarResponseDto> collars = new ArrayList<>();
		ShopResponseDto shop = shopRepository.findById(id).get();
		collars = shop.getCollars();
		return collars;
			
	}
	
	public CollarResponseDto AddCollar (CollarResponseDto collar, int id) throws MyClassException {
		ShopResponseDto shop = shopRepository.findById(id).get();
		if (shop.getCollars().size()<shop.getCapacitance()) {
			collar.setShop(shop);
			List<CollarResponseDto> collars = shop.getCollars();
			collars.add(collar);
			shop.setCollars(collars);
			collarRepository.save(collar);
			shopRepository.save(shop);
		} else {
			
				throw new MyClassException("Error, capacitance exceded");
			
		}
		
		return collar;
			
	}
	
	
	public List<CollarResponseDto> deleteCollarsByShop (int id) {
		ShopResponseDto shop = shopRepository.findById(id).get();
		List <CollarResponseDto> collars = shop.getCollars();
		collars.forEach(collar -> collarRepository.delete(collar));
		return collars;
		
		
	}
	
	
	
	

	


	
	

	
	
	
	

}
