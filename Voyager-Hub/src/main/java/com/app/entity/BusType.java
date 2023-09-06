package com.app.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum BusType 
{
	Sleeper(60),Express(40),Volvo(20),Luxuxry(10);
	private int size;
	private BusType(int size)
	{
		this.size=size;
	}

}
