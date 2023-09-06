package com.app.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
@Entity
@Table
@ToString
public class Travels extends BaseEntity
{
	@Column(name = "Travel_Name", length = 20)
	private String travelName;
    @Column(name="Capacity", length=40)
    private long capacity;
    @Column(name="BusType",length=40)
    private BusType type;
    @ManyToMany(mappedBy="travelSet")
	private Set<Drivers> driverList=new HashSet<>();
    @ManyToMany(mappedBy = "travels")
	private Set<Routes> routesList=new HashSet<>();
    public void removeDirverSet(Routes route)
	{
		routesList.remove(route);
	}
    public void addDriver(Drivers driver)
	{
		driverList.add(driver);
	}
    public void removeRouteSet(Drivers driver)
	{
    	driverList.remove(driver);
	}
    public void addRoute(Routes route)
	{
    	routesList.add(route);
	}
}