package com.games.world.machine.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;

import com.games.world.mapper.UsrMapper;

public class startService {
	@Autowired
	UsrMapper usrMapper;
	
	public static void main(String[] args) {
		System.out.println("游戏开始");
        tomain();
	}
	
	public static void tomain() {
		try {  
            BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));  
            System.out.println();
            String str = strin.readLine();
            manage(str);
        } catch (IOException e) {  
            e.printStackTrace();  
        }  finally {
        	tomain();
		}
	}
	
	public static void manage(String str) {
		
	}
}
