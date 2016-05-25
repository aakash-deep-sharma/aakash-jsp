package com.customer;

public class RealCustomer extends Customer {

	public RealCustomer(String name)
	{
		this.name = name;
	}
		
	@ Override
	public String getName()
	{
		return name;
	}
		
	@ Override
	public boolean isNil() 
	{
		return false;
	}
}
