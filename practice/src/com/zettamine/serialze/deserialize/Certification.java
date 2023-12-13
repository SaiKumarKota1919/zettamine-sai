package com.zettamine.serialze.deserialize;

import java.io.Serializable;
import java.util.Objects;

public class Certification implements Serializable,Comparable<Certification> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	private int certfId;
	private String certfTitle;
	private int ranking;
	public Certification(int certfId, String certfTitle, int ranking) {
		super();
		this.certfId = certfId;
		this.certfTitle = certfTitle;
		this.ranking = ranking;
	}
	public int getCertfId() {
		return certfId;
	}
	public void setCertfId(int certfId) {
		this.certfId = certfId;
	}
	public String getCertfTitle() {
		return certfTitle;
	}
	public void setCertfTitle(String certfTitle) {
		this.certfTitle = certfTitle;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	@Override
	public int hashCode() {
		return this.certfId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certification other = (Certification) obj;
		return certfId == other.certfId && Objects.equals(certfTitle, other.certfTitle) && ranking == other.ranking;
	}
	@Override
	public String toString() {
		return "Certification [certfId=" + certfId + ", certfTitle=" + certfTitle + ", ranking=" + ranking + "]";
	}
	@Override
	public int compareTo(Certification o) {
		// TODO Auto-generated method stub
		if(ranking-o.ranking==0)
		{
			return this.certfId-o.certfId;
		}
		return  ranking-o.ranking;
		
	}
	
	
	
	
}
