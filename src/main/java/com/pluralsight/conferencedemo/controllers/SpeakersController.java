package com.pluralsight.conferencedemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakersController {

  @Autowired
  private SpeakerRepository speakerRepository;

  @GetMapping
  public List<Speaker> list() {
    return speakerRepository.findAll();
  }

  @GetMapping
  @RequestMapping({ "id" })
  public Speaker get(@PathVariable Long id) {
    return speakerRepository.getReferenceById(id);
  }

  @PostMapping
  public Speaker create(@RequestBody final Speaker speaker) {
    return speakerRepository.saveAndFlush(speaker);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    speakerRepository.deleteById(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
    // becuase it is a PUT, we expect that all attributes be available and passed
    // in. In Patch
    // would only need what it will update.
    // TODO: Add validation that all attributes are passed in, otherwise return 400
    // bad payload

    Speaker existingSpeaker = speakerRepository.getReferenceById(id);
    BeanUtils.copyProperties(speaker, existingSpeaker);

    return speakerRepository.saveAndFlush(existingSpeaker);
  }

}
