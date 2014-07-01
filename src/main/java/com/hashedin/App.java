package com.hashedin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.portable.InputStream;

public class App
{
	public static void main(String[] args) {
			
		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("movie.data");
		File file = new File("movie.data");
		String path = file.getAbsolutePath();
		System.out.println("Pth "+ path);	
		getMovieList();
		}

    		
    		
   	}
   	 
    
}