package com.telusinternational.global.WuaUnit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WuaUnitController {
	
	@Autowired
	private WuaUnitService wuaUnitService;
	
	@RequestMapping("/units")
	public List<WuaUnit> getAllWuaUnits() {
		return wuaUnitService.getAllWuaUnits();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/test")
	public String test() {
		return "fortuna";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/globalAlignmentToLegacy")
	public String getGlobalAlignmentToLegacy(@RequestBody Params params) {
		
	//public List<WuaUnit> getGlobalAlignmentToLegacy(@RequestBody Params params) {
		List<WuaUnit> subunitsAux = wuaUnitService.getGlobalAlignmentToLegacy(params.getCountry(), params.getGaSubunitName());
		//List<WuaUnit> subunits = new ArrayList<WuaUnit>();
		
		System.out.println(subunitsAux.size());
		JSONObject mainObj = new JSONObject();
		try {
			for (Iterator<WuaUnit> iterator = subunitsAux.iterator(); iterator.hasNext();) {
				WuaUnit subunit = iterator.next();
				if(subunit.getUniUnitUniId() != null) {
					System.out.println(subunit.getUniUnitUniId().getUniWdName());
					System.out.println(params.getGaUnitName());
					if(subunit.getUniUnitUniId().getUniWdName().equals(params.getGaUnitName())) {
						//subunits.add(subunit);
						JSONArray array = new JSONArray();
						JSONObject json = new JSONObject();
						json.put("country", subunit.getUniCountry());
						json.put("Unit", subunit.getUniUnitUniId().getUniLegacyName());
						json.put("Subunit", subunit.getUniLegacyName());
						array.put(json);
						mainObj.put("Unit_"+subunit.getUniId().toString(), array);
					}
				}else {
					//subunits.add(subunit);
					JSONArray array = new JSONArray();
					JSONObject json = new JSONObject();
					json.put("country", subunit.getUniCountry());
					json.put("Unit", "");
					json.put("Subunit", subunit.getUniLegacyName());
					array.put(json);
					mainObj.put("Unit_"+subunit.getUniId().toString(), array);
				}
			
			}
		}catch(JSONException e) {
			e.printStackTrace();
		}
		
		///return subunits;
		return mainObj.toString();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/legacyToGlobalAlignment")
	public String getLegacyToGlobalAlignment(@RequestBody Params params) {
	//public List<WuaUnit> getGlobalAlignmentToLegacy(@RequestBody Params params) {
		List<WuaUnit> subunitsAux = wuaUnitService.getLegacyToGlobalAlignment(params.getCountry(), params.getGaSubunitName());
		//List<WuaUnit> subunits = new ArrayList<WuaUnit>();
		
		System.out.println(subunitsAux.size());
		JSONObject mainObj = new JSONObject();
		
		for (Iterator<WuaUnit> iterator = subunitsAux.iterator(); iterator.hasNext();) {
			WuaUnit subunit = iterator.next();
			if(subunit.getUniUnitUniId() != null) {
				System.out.println(subunit.getUniUnitUniId().getUniWdName());
				System.out.println(params.getGaUnitName());
				if(subunit.getUniUnitUniId().getUniLegacyName().equals(params.getGaUnitName())) {
					//subunits.add(subunit);
					JSONArray array = new JSONArray();
					JSONObject json = new JSONObject();
					json.put("country", subunit.getUniCountry());
					json.put("Unit", subunit.getUniUnitUniId().getUniWdName());
					json.put("Subunit", subunit.getUniWdName());
					array.put(json);
					mainObj.put("Unit", array);
				}
			}else {
				//subunits.add(subunit);
				JSONArray array = new JSONArray();
				JSONObject json = new JSONObject();
				json.put("country", subunit.getUniCountry());
				json.put("Unit", "");
				json.put("Subunit", subunit.getUniWdName());
				array.put(json);
				mainObj.put("Unit", array);
				
			}
		}
		
		///return subunits;
		return mainObj.toString();
	}
	
	/*
	@RequestMapping(method=RequestMethod.POST, value="/legacyToGlobalAlignment")
	public List<WuaUnit> getLegacyToGlobalAlignment(@RequestBody String country, 
													@RequestBody String legacyUnitName,
													@RequestBody String legacySubunitName) {
		return wuaUnitService.getLegacyToGlobalAlignment(country, legacyUnitName, legacySubunitName);
	}*/
	
	/*
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.deleteTopic(id, topic);
	}*/
}