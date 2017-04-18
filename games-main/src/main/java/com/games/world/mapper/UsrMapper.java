package com.games.world.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsrMapper {
	boolean login (Map<String, Object> params);
}
