package com.satyawadi.ws.service;
import org.springframework.stereotype.Service;

@Service
public class WSServiceImpl implements WSService {


	@Override
	public String hello(String name) {
		return "Hello "+name;
		//return "Hello Utkarsh";
		
	}

}
