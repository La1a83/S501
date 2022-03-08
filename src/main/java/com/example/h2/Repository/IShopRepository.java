package com.example.h2.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.h2.dto.ShopResponseDto;


public interface IShopRepository extends CrudRepository<ShopResponseDto, Integer>{

}
