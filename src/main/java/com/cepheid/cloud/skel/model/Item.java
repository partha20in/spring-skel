package com.cepheid.cloud.skel.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class Item extends AbstractEntity implements Serializable {

protected Long mId;
private String name;
private String state;


@OneToMany
private Set<Description> desc;


public Long getId() {
	return mId;
}

public void setId(Long id) {
	this.mId = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}


public Item() {
}

public Item(String name, String state) {
	super();
	this.name = name;
	this.state = state;
}


}
