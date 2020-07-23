package com.cepheid.cloud.skel.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Descriptions")
public class Description extends AbstractEntity implements Serializable{

protected Long mId;	
private String type;
private Long price;

@ManyToOne
public Item item;


public Description() {
	
}

public Description(long mId, String type, Long price, Item item) {
	super();
	this.type = type;
	this.price = price;
	this.item = item;
}

public Long getId() {
	return mId;
}

public void setId(Long id) {
	this.mId = id;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Long getPrice() {
	return price;
}
public void setPrice(Long price) {
	this.price = price;
}


}
