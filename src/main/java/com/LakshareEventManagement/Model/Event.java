package com.LakshareEventManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Event {

    @Id
    private Long id;
	private String name;
    
    public Event() {
    }
    public Event(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + "]";
    }
    
    
}
