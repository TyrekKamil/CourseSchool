package com.pracownia.spring.services;

import com.pracownia.spring.entities.Address;
import com.pracownia.spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository AddressRepository;

    @Override
    public Iterable<Address> listAllAddresss() {
        return AddressRepository.findAll();
    }

    @Override
    public Address getAddressById(Integer id) {
        return AddressRepository.findOne(id);
    }

    @Override
    public Address saveAddress(Address Address) {
        return AddressRepository.save(Address);
    }

    @Override
    public void deleteAddress(Integer id) {
        AddressRepository.delete(id);
    }

    @Override
    public int howManyPosen()
    {
        return AddressRepository.howManyPosen();
    }

}
