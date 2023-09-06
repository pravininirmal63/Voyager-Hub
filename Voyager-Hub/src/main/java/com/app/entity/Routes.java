package com.app.entity;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@ToString
@Entity
public class Routes extends BaseEntity
{
	@Column(name="Start_Location",length=40)
	private String startLoc;
	@Column(name="End_Location",length=40)
	private String endLoc;
	@Column(name="Start_Date" )
	private Date startDate;
	@Column(name="End_Date" )
	private Date endDate;
	@OneToMany(mappedBy = "route",cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<Customer> customerList=new ArrayList<Customer>();
	@ManyToMany
	@JoinTable(name ="Travel_Route",joinColumns = @JoinColumn(name="route_id"),inverseJoinColumns = @JoinColumn(name="travel_id"))
    private Set<Travels> travels=new HashSet<>();
	
	
	public void addTravels(Travels travel)
	{
		travels.add(travel);
	}
	public void removeTravels(Travels travel)
	{
		travels.remove(travel);
	}
	public void addCustomer(Customer customer)
	{
		customerList.add(customer);
	}
	public void removeCustomer(Customer customer)
	{
		customerList.remove(customer);
	}
}
