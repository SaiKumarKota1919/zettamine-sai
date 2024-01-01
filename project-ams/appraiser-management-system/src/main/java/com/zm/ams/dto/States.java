package com.zm.ams.dto;



public enum States{

	AP("Andhra Pradesh"),
	AR("Arunachal Pradesh"),
	AS("Assam"),
	BR("Bihar"),
	CG("Chhattisgarh"),
	GA("Goa"),
	GJ("Gujarat"),
	HR("Haryana"),
	HP("Himachal Pradesh"),
	JH("Jharkhand"),
	KA("Karnataka"),
	KL("Kerala"),
	MP("Madhya Pradesh"),
	MH("Maharashtra"),
	MN("Manipur"),
	ML("Meghalaya"),
	MZ("Mizoram"),
	NL("Nagaland"),
	OR("Odisha"),
	PB("Punjab"),
	RJ("Rajasthan"),
	SK("Sikkim"),
	TN("Tamil Nadu"),
	TS("Telangana"),
	TR("Tripura"),
	UP("Uttar Pradesh"),
	UK("Uttarakhand"),
	WB("West Bengal"),
	DL("Delhi"),
	JK("Jammu and Kashmir"),
	LD("Lakshadweep"),
	PY("Puducherry");



private final String stateName;


States(String stateName) {
    this.stateName = stateName;
}

public String getStateName() {
    return stateName;
}
}