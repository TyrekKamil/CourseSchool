package com.pracownia.spring.services;
;
import com.pracownia.spring.entities.Address;

import java.util.List;

public interface AddressService {

    Iterable<Address> listAllAddresss();

    Address getAddressById(Integer id);

    Address saveAddress(Address Address);

    void deleteAddress(Integer id);

    public int howManyPosen();

    List<Address> listAll();

}
