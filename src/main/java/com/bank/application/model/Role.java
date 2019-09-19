package com.bank.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role extends BaseEntity {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
@Column(name="id")
private Integer id;

@Column(name="name")
private String name;

@Column(name="status")
private Integer status;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}


}