package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {


}
