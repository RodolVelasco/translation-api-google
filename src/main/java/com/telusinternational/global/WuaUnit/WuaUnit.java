package com.telusinternational.global.WuaUnit;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.ForeignKey;

@Entity
public class WuaUnit {

	@Id
	private Integer uniId;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="uni_unit_uni_id", foreignKey = @ForeignKey(name = "FK_uni_unit_uni_id"))
	private WuaUnit uniUnitUniId;

	private Integer uniWdId;
	private String uniWdName;
	private Integer uniLegacyId;
	private String uniLegacyName;
	private String uniCountry;
	private Integer uniStatus;
	private Integer uniIsActive;
	private String uniDescription;
	private Date uniCreatedAt;
	private String uniCreatedBy;
	private Date uniModifiedAt;
	private String uniModifiedBy;

	public WuaUnit() {
	}
	
	public WuaUnit(WuaUnit uniUnitUniId) {
		this.uniUnitUniId = uniUnitUniId;
	}

	public WuaUnit(Integer uniId, WuaUnit uniUnitUniId, Integer uniWdId, String uniWdName, Integer uniLegacyId,
			String uniLegacyName, String uniCountry, Integer uniStatus, Integer uniIsActive, String uniDescription,
			Date uniCreatedAt, String uniCreatedBy, Date uniModifiedAt, String uniModifiedBy) {
		super();
		this.uniId = uniId;
		this.uniUnitUniId = new WuaUnit(uniUnitUniId);
		this.uniWdId = uniWdId;
		this.uniWdName = uniWdName;
		this.uniLegacyId = uniLegacyId;
		this.uniLegacyName = uniLegacyName;
		this.uniCountry = uniCountry;
		this.uniStatus = uniStatus;
		this.uniIsActive = uniIsActive;
		this.uniDescription = uniDescription;
		this.uniCreatedAt = uniCreatedAt;
		this.uniCreatedBy = uniCreatedBy;
		this.uniModifiedAt = uniModifiedAt;
		this.uniModifiedBy = uniModifiedBy;
	}

	public Integer getUniId() {
		return uniId;
	}

	public void setUniId(Integer uniId) {
		this.uniId = uniId;
	}

	public Integer getUniWdId() {
		return uniWdId;
	}

	public void setUniWdId(Integer uniWdId) {
		this.uniWdId = uniWdId;
	}

	public String getUniWdName() {
		return uniWdName;
	}

	public void setUniWdName(String uniWdName) {
		this.uniWdName = uniWdName;
	}

	public Integer getUniLegacyId() {
		return uniLegacyId;
	}

	public void setUniLegacyId(Integer uniLegacyId) {
		this.uniLegacyId = uniLegacyId;
	}

	public String getUniLegacyName() {
		return uniLegacyName;
	}

	public void setUniLegacyName(String uniLegacyName) {
		this.uniLegacyName = uniLegacyName;
	}

	public String getUniCountry() {
		return uniCountry;
	}

	public void setUniCountry(String uniCountry) {
		this.uniCountry = uniCountry;
	}

	public Integer getUniStatus() {
		return uniStatus;
	}

	public void setUniStatus(Integer uniStatus) {
		this.uniStatus = uniStatus;
	}

	public Integer getUniIsActive() {
		return uniIsActive;
	}

	public void setUniIsActive(Integer uniIsActive) {
		this.uniIsActive = uniIsActive;
	}

	public String getUniDescription() {
		return uniDescription;
	}

	public void setUniDescription(String uniDescription) {
		this.uniDescription = uniDescription;
	}

	public Date getUniCreatedAt() {
		return uniCreatedAt;
	}

	public void setUniCreatedAt(Date uniCreatedAt) {
		this.uniCreatedAt = uniCreatedAt;
	}

	public String getUniCreatedBy() {
		return uniCreatedBy;
	}

	public void setUniCreatedBy(String uniCreatedBy) {
		this.uniCreatedBy = uniCreatedBy;
	}

	public Date getUniModifiedAt() {
		return uniModifiedAt;
	}

	public void setUniModifiedAt(Date uniModifiedAt) {
		this.uniModifiedAt = uniModifiedAt;
	}

	public String getUniModifiedBy() {
		return uniModifiedBy;
	}

	public void setUniModifiedBy(String uniModifiedBy) {
		this.uniModifiedBy = uniModifiedBy;
	}

	public WuaUnit getUniUnitUniId() {
		return uniUnitUniId;
	}

	public void setUniUnitUniId(WuaUnit uniUnitUniId) {
		this.uniUnitUniId = uniUnitUniId;
	}

}
