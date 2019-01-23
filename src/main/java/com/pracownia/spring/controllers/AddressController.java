package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Address;
import com.pracownia.spring.repositories.AddressRepository;
import com.pracownia.spring.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService AddressService;

    @RequestMapping(value = "/Addresss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Address> list(Model model) {
        return AddressService.listAllAddresss();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/Addresss", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Address> redirect(Model model) {
        return AddressService.listAllAddresss();
    }

    @RequestMapping(value = "/Address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public Address getByPublicId(@PathVariable("id") Integer publicId) {
        return AddressService.getAddressById(publicId);
    }

    @RequestMapping(value = "/Address", method = RequestMethod.POST)
    public ResponseEntity<Address> create(@RequestBody @Valid @NotNull Address Address) {
        AddressService.saveAddress(Address);
        return ResponseEntity.ok().body(Address);
    }

    @RequestMapping(value = "/Address", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Address Address) {
            Address AddressFromData = AddressService.getAddressById(Address.getId());
            if(Objects.nonNull(AddressFromData)) {
                AddressService.saveAddress(Address);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/Address/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        AddressService.deleteAddress(id);
        return new RedirectView("/api/Addresss", true);
    }
    @RequestMapping(value = "/Addresss/howMany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int howMany()
    {
        return AddressService.howManyPosen();
    }


}
