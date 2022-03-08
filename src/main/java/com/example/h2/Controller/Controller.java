package com.example.h2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.Errors.MyClassException;
import com.example.h2.Service.ShopService;
import com.example.h2.dto.CollarResponseDto;
import com.example.h2.dto.ShopResponseDto;




@RestController
@RequestMapping("/shops")
public class Controller {
	
	
	    private final ShopService shopService;
	    
	    

	    @Autowired
	    public Controller(ShopService shopService){
	        this.shopService = shopService;
	    }
	    
	    
	    //Petició Get per testejar que funciona la conexió amb el servidor.
	    @GetMapping(path="/test")
	    public String helloMaven() {
	        return "Hello Maven!";
	    }
	    
	    //Petició Get que mostra totes les botigues.
	    @GetMapping(path="/")
	    public List<ShopResponseDto> getAll() {
	    	return shopService.getAllShops();
	    }
	    
	    
	    //Petició Post per afegir una botiga:
	    @PostMapping(path="/")
	    public ShopResponseDto add(@RequestBody ShopResponseDto shop) {
	    	shopService.SaveorUpdate(shop);
	    	return shop;
	    	
	    }
	    
	    
	    
	    //Petició Get que retorna llistat "collarets" de la botiga amb l'id demanat.
	    @GetMapping(path="/{id}/pictures")
	    public List <CollarResponseDto> find(@PathVariable String id) {
	    	return shopService.getAllCollarsByShop(Integer.parseInt(id));
	    	 	
	    }
	    
	    //Petició Post per afegir un "collaret" a la botiga amb id especificat.
	    @PostMapping(path="/{id}/pictures")
	    public CollarResponseDto addCollar(@RequestBody CollarResponseDto collar, @PathVariable String id) throws MyClassException {
	    	shopService.AddCollar(collar, Integer.parseInt(id));
	    	return collar;
	    }
	    
	    
	    //Peticio Delete per eliminar els collarets d'una botiga.
	    @DeleteMapping(path="/{id}/pictures")
	    public void deleteCollars(@PathVariable String id) {
	    	shopService.deleteCollarsByShop(Integer.parseInt(id));
	    	
	     }
	    
	    

	

}
