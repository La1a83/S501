package com.example.h2.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.h2.dto.CollarResponseDto;

public interface ICollarRepository extends CrudRepository<CollarResponseDto, Integer>{

}
