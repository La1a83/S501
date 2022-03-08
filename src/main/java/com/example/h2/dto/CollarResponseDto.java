package com.example.h2.dto;





import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Collar")
public class CollarResponseDto extends ResponseDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String autor;
    private String name;
    private Double price = 10000.00;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @PrePersist
    public void prePerssist() {
    	this.createdAt = new Date();
    }
   
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="shop_id")
	private ShopResponseDto shop;
    
   
    //Getters and Setters
   
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public ShopResponseDto getShop() {
		return shop;
	}


	public void setShop(ShopResponseDto shop) {
		this.shop = shop;
	}


	@Override
	public String toString() {
		return "CollarResponseDto [id=" + id + ", autor=" + autor + ", name=" + name + ", price=" + price + "]";
	}


	
	
    
	
	

}
