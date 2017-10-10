package com.telusinternational.global.WuaUnit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WuaUnitService {
	
	@Autowired
	private WuaUnitRepository wuaUnitRepository;
	
	public List<WuaUnit> getAllWuaUnits(){
		List<WuaUnit> wuaUnits = new ArrayList<>();
		wuaUnitRepository.findAll()
		.forEach(wuaUnits::add);
		
		return wuaUnits;
	}
	
	public List<WuaUnit> getGlobalAlignmentToLegacy(String country, String gaSubunitName) {
		return wuaUnitRepository.findByUniCountryAndUniWdName(country, gaSubunitName);
	}
	
	public List<WuaUnit> getLegacyToGlobalAlignment(String country, String gaSubunitName) {
		return wuaUnitRepository.findByUniCountryAndUniLegacyName(country, gaSubunitName);
	}
	
	/*
	public WuaUnit getLegacyToGlobalAlignment(String country, String legacyUnitName, String legacySubunitName) {
		return wuaUnitRepository.
	}*/
	
	/*
	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id, Topic topic) {
		topicRepository.delete(id);
	}*/
	
}
