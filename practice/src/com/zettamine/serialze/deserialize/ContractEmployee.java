package com.zettamine.serialze.deserialize;

import java.util.Objects;

public class ContractEmployee extends Employee{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contractorRegId;
	
	public ContractEmployee(int contractRegId,int empId, String empName, int deptNo)
	{
	
		super(empId, empName, deptNo);
		
		this.contractorRegId=contractRegId;
	}

	public int getContractorRegId() {
		return contractorRegId;
	}

	public void setContractorRegId(int contractorRegId) {
		this.contractorRegId = contractorRegId;
	}

	@Override
	public String toString() {
		return "ContractEmployee [contractorRegId=" + contractorRegId + ", EmpId=" + getEmpId() + ",EmpName="
				+ getEmpName() + ", DeptNo=" + getDeptNo() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(contractorRegId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractEmployee other = (ContractEmployee) obj;
		return contractorRegId == other.contractorRegId;
	}
	

}
