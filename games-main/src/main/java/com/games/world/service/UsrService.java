package com.games.world.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.world.mapper.UsrMapper;

@Service
public class UsrService {
	@Autowired
	UsrMapper usrMapper;
	public Map<String, Object> login(Map<String, Object> params) {
		return null;
	}
}
