package com.example.h2.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Shop")
public class ShopResponseDto extends ResponseDto{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Integer capacitance;
    
    @OneToMany(mappedBy= "shop")
    private List<CollarResponseDto> collars= new ArrayList<CollarResponseDto>();
	
    
    //Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCapacitance() {
		return capacitance;
	}
	public void setCapacitance(Integer capacitance) {
		this.capacitance = capacitance;
	}
	public List<CollarResponseDto> getCollars() {
		return collars;
	}
	public void setCollars(List<CollarResponseDto> collars) {
		this.collars = collars;
	}
	
	//ToString method
	@Override
	public String toString() {
		return "ShopResponseDto [id=" + id + ", name=" + name + ", capacitance=" + capacitance +  "]";
	}
    
	
	
	

}
