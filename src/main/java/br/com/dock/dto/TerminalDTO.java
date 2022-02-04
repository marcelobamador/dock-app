package br.com.dock.dto;

import java.io.Serializable;

public class TerminalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8972095381382409563L;

	private Integer logic;
	private String serial;
	private String model;
	private Integer sam;
	private String ptid;
	private Integer plat;
	private String version;
	private Integer mxr;
	private Integer mxf;
	private String PVERFM;

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
	 * @return the pVERFM
	 */
	public String getPVERFM() {
		return PVERFM;
	}

	/**
	 * @param pVERFM the pVERFM to set
	 */
	public void setPVERFM(String pVERFM) {
		PVERFM = pVERFM;
	}

}
