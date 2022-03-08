package com.example.h2.Errors;

public class MyClassException extends Exception {
	
private String missatge="";
    
    public MyClassException (String missatge) {
        
        super();
        this.missatge = missatge;
    }

        
    public String getMessage () {
        return this.missatge;
    }      
    
    
	
	

}
