package com.telusinternational.global.WuaUnit;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WuaUnitRepository extends CrudRepository<WuaUnit, Integer> {
	
	public List<WuaUnit> findByUniCountryAndUniWdName(String country, String gaSubunitName);
	
	public List<WuaUnit> findByUniCountryAndUniLegacyName(String country, String gaSubunitName);
}