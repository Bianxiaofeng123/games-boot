package com.games.world.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.world.mapper.UsrMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsrService {
	@Autowired
	UsrMapper usrMapper;
	
	public Map<String, Object> login(Map<String, Object> params) {
		Map<String, Object>loginnm=usrMapper.login(params);
		if (loginnm!=null) {
			return loginnm;
		}
		return loginnm;
	}
	
	public void usrs() {
		List<Map<String, Object>> UsrsList =usrMapper.getUsrs();
		log.info("UsrsList--->>>"+UsrsList);
	}
}
