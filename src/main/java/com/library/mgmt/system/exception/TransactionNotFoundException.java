package com.library.mgmt.system.exception;
@SuppressWarnings("serial")
//Indicates that the compiler should suppress the warning related to the absence of serialVersionUID

public class TransactionNotFoundException extends Exception{

	public TransactionNotFoundException(String message)
	{
		super(message);
	}

}
