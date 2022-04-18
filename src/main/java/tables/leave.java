package tables;

import java.io.*;

@SuppressWarnings("Serial")
public class leave implements Serializable {
	
	private String id;
	private String datefrom;
	private String dateto;
	private String bckoffice;
	private String reason;
	private String offleave;	
	private String remark;
	private String day;

	
	

	public leave() {

		id= "";
		datefrom= "";
		dateto= "";
		bckoffice= "";
		reason= "";
		offleave= "";
		remark= "";


		
	}
	
	public leave(String datefrom, String dateto, String bckoffice, String reason, String remark, String id, String offleave) {
		
		this.id = id;
		this.datefrom = datefrom;
		this.dateto = dateto;
		this.bckoffice = bckoffice;
		this.reason = reason;
		this.remark = remark;
		this.offleave = offleave;

		
		
	}
	
	
	public String getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(String datefrom) {
		this.datefrom = datefrom;
	}

	public String getDateto() {
		return dateto;
	}

	public void setDateto(String dateto) {
		this.dateto = dateto;
	}

	public String getBckoffice() {
		return bckoffice;
	}

	public void setBckoffice(String bckoffice) {
		this.bckoffice = bckoffice;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getOffleave() {
		return offleave;
	}

	public void setOffleave(String offleave) {
		this.offleave = offleave;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}



}
