package com.org.employee.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class CreateDirectoryServiceImpl {
	@Value("${app.filedir}")
	private String filedir;
	
	
	@Value("${app.filename}")
	private String filename;

	public void createDir() {
		
		File dir = new File(filedir);
		if (!dir.exists()) {
			
				if (dir.mkdir()) {					
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}			
		}
		File file = new File(filedir+filename);
		if(!file.exists()) {
			try {
				if (file.createNewFile()) {	
					FileWriter filewriter = new FileWriter(file);
					filewriter.write("[]");
					filewriter.close();
					System.out.println("File is created!");
				} else {
					System.out.println("Failed to create File!");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
