package com.pluralsight.conferencedemo.models;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity(name = "speakers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Speaker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long speaker_id;
  private String first_name;
  private String last_name;
  private String title;
  private String company;
  private String speaker_bio;
  private Byte[] speaker_photo;
  @ManyToMany(mappedBy = "speakers")
  @JsonIgnore
  private List<Session> session;

  @Lob
  @Type(type = "org.hibernate.type.BinaryType")
  public Byte[] getSpeaker_photo() {
    return speaker_photo;
  }

  public void setSpeaker_photo(Byte[] speaker_photo) {
    this.speaker_photo = speaker_photo;
  }

  public List<Session> getSession() {
    return session;
  }

  public void setSession(List<Session> session) {
    this.session = session;
  }

  public Speaker() {

  }

  public Long getSpeaker_id() {
    return speaker_id;
  }

  public void setSpeaker_id(Long speaker_id) {
    this.speaker_id = speaker_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getSpeaker_bio() {
    return speaker_bio;
  }

  public void setSpeaker_bio(String speaker_bio) {
    this.speaker_bio = speaker_bio;
  }

}
