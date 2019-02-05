package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Course;
import com.pracownia.spring.entities.Speaker;
import com.pracownia.spring.services.SpeakerService;
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
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SpeakerController {

    @Autowired
    private SpeakerService SpeakerService;

    @RequestMapping(value = "/Speakers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Speaker> list(Model model) {
        return SpeakerService.listAllSpeakers();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/Speakers", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Speaker> redirect(Model model) {
        return SpeakerService.listAllSpeakers();
    }

    @RequestMapping(value = "/Speaker/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public Speaker getByPublicId(@PathVariable("id") Integer publicId) {
        return SpeakerService.getSpeakerById(publicId);
    }

    @RequestMapping(value = "/Speaker", method = RequestMethod.POST)
    public ResponseEntity<Speaker> create(@RequestBody @Valid @NotNull Speaker Speaker) {
        SpeakerService.saveSpeaker(Speaker);
        return ResponseEntity.ok().body(Speaker);
    }

    @RequestMapping(value = "/Speaker", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Speaker Speaker) {
        Speaker SpeakerFromData = SpeakerService.getSpeakerById(Speaker.getId());
        if(Objects.nonNull(SpeakerFromData)) {
            SpeakerService.saveSpeaker(Speaker);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/Speaker/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        SpeakerService.deleteSpeaker(id);
        return new RedirectView("/api/Speakers", true);
    }


    @RequestMapping(value="/Speaker/course/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getCourses(@PathVariable("id") Integer publicId) {
        return SpeakerService.courses(publicId);
    }


}
