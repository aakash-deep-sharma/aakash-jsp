package com.customer;

public class NullCustomer extends Customer {
	
	@ Override
	public String getName()
	{
		return "Not Available in Custom er Database";
	}
		
	@ Override
	public boolean isNil() 
	{
		return true;
	}
}
