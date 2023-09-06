package com.app.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Drivers extends BaseEntity 
{
	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(length = 20, unique =true) 
	private String email;
	@Column(length = 20, nullable = false) 
	private String password;
	@ManyToMany
	@JoinTable(name ="Travel_Driver",joinColumns = @JoinColumn(name="driver_id"),inverseJoinColumns = @JoinColumn(name="travel_id"))
	private Set<Travels> travelSet = new HashSet<>();
	public void addTravelSet(Travels travel)
	{
		travelSet.add(travel);
	}
	public void removeTravleSet(Travels travel)
	{
		travelSet.remove(travel);
	}
	
	
}
