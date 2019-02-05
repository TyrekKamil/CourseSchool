package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer>
{
    @Query("select count(*) from Address a where a.miasto='Poznań' or a.miasto='Poznan' ")
    Integer howManyPosen();

    @Query("from Address a order by a.id")
    List<Address> last();



}
