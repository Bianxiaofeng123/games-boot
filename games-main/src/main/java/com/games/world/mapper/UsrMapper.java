package com.games.world.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsrMapper {
	public Map<String, Object> login (Map<String, Object> params);
	public List<Map<String, Object>> getUsrs ();
	public Map<String, Object> getLocation(Map<String, Object> params);
}
