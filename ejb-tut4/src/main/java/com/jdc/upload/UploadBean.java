package com.jdc.upload;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@RequestScoped
public class UploadBean {

	private Part part;
	
	@Inject
	private UploadService service;

	public String upload() {
		
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(part.getInputStream()))) {
			
			List<String> list = new ArrayList<>();
			String line = null;
			
			while(null != (line = br.readLine())) {
				list.add(line);
			}
			
			service.upload(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

}
