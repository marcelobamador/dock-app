package br.com.dock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "TERMINAL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TerminalEntity {

	@Id
	@NotNull
	private Integer logic;

	@NotNull
	private String serial;

	@NotNull
	private String model;

	@Min(value = 0)
	private Integer sam;

	private String ptid;
	private Integer plat;

	@NotNull
	private String version;

	private Integer mxr;
	private Integer mxf;

	@SerializedName(value = "PVERFM")
	@JsonProperty("PVERFM")
	private String pverfm;

	/**
	 * @return the logic
	 */
	public Integer getLogic() {
		return logic;
	}

	/**
	 * @param logic the logic to set
	 */
	public void setLogic(Integer logic) {
		this.logic = logic;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the sam
	 */
	public Integer getSam() {
		return sam;
	}

	/**
	 * @param sam the sam to set
	 */
	public void setSam(Integer sam) {
		this.sam = sam;
	}

	/**
	 * @return the ptid
	 */
	public String getPtid() {
		return ptid;
	}

	/**
	 * @param ptid the ptid to set
	 */
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	/**
	 * @return the plat
	 */
	public Integer getPlat() {
		return plat;
	}

	/**
	 * @param plat the plat to set
	 */
	public void setPlat(Integer plat) {
		this.plat = plat;
	}

	/**
	 * @return the mxr
	 */
	public Integer getMxr() {
		return mxr;
	}

	/**
	 * @param mxr the mxr to set
	 */
	public void setMxr(Integer mxr) {
		this.mxr = mxr;
	}

	/**
	 * @return the mxf
	 */
	public Integer getMxf() {
		return mxf;
	}

	/**
	 * @param mxf the mxf to set
	 */
	public void setMxf(Integer mxf) {
		this.mxf = mxf;
	}

	/**
	 * @return the pverfm
	 */
	public String getPverfm() {
		return pverfm;
	}

	/**
	 * @param pverfm the pverfm to set
	 */
	public void setPverfm(String pverfm) {
		this.pverfm = pverfm;
	}

}
