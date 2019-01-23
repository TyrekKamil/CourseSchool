package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Opinion;
import com.pracownia.spring.services.OpinionService;
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
public class OpinionController {

    @Autowired
    private OpinionService OpinionService;

    @RequestMapping(value = "/Opinions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Opinion> list(Model model) {
        return OpinionService.listAllOpinions();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/Opinions", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Opinion> redirect(Model model) {
        return OpinionService.listAllOpinions();
    }

    @RequestMapping(value = "/Opinion/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public Opinion getByPublicId(@PathVariable("id") Integer publicId) {
        return OpinionService.getOpinionById(publicId);
    }

    @RequestMapping(value = "/Opinion", method = RequestMethod.POST)
    public ResponseEntity<Opinion> create(@RequestBody @Valid @NotNull Opinion Opinion) {
        OpinionService.saveOpinion(Opinion);
        return ResponseEntity.ok().body(Opinion);
    }

    @RequestMapping(value = "/Opinion", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Opinion Opinion) {
        Opinion OpinionFromData = OpinionService.getOpinionById(Opinion.getId());
        if(Objects.nonNull(OpinionFromData)) {
            OpinionService.saveOpinion(Opinion);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/Opinion/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        OpinionService.deleteOpinion(id);
        return new RedirectView("/api/Opinions", true);
    }



}
