package com.advantage.datastructures.OCAutomation;

/**
 * Data Structure to hold variables for Create New SAR
 */
public class CreateNewSARDetails {
	public String sBusiness, sSARType, sSegment, sPricingAnalyst, 
	sChannel, sEffDate, sTermDate, sDistributor, sState,
	sPayer, sCompSituation, sCompetitor, sCompConfMethod, 
	sCompEffDate, sCompTermDate, sCompLearnedDate, sLearnedFrmName,
	sLearnedCompany, sProdName, sType, sUnitOfMeasure, sCurrentPrice,
	sRequestedPrice, sVolume, sTerm, sLevel1Approver;
	

	/**
	 * Constructor for Create Incident 
	 * 	
	 */
	public CreateNewSARDetails(String sBusiness, String sSARType, String sSegment, String sPricingAnalyst, 
			String sChannel, String sEffDate, String sTermDate, String sDistributor, String sState,
			String sPayer, String sCompSituation, String sCompetitor, String sCompConfMethod, 
			String sCompEffDate, String sCompTermDate, String sCompLearnedDate, String sLearnedFrmName,
			String sLearnedCompany, String sProdName, String sType, String sUnitOfMeasure, String sCurrentPrice,
			String sRequestedPrice, String sVolume, String sTerm, String sLevel1Approver)
	{
		
		set(sBusiness, sSARType, sSegment, sPricingAnalyst, 
				sChannel, sEffDate, sTermDate, sDistributor, sState,
				sPayer, sCompSituation, sCompetitor, sCompConfMethod, 
				sCompEffDate, sCompTermDate, sCompLearnedDate, sLearnedFrmName,
				sLearnedCompany, sProdName, sType, sUnitOfMeasure, sCurrentPrice,
				sRequestedPrice, sVolume, sTerm, sLevel1Approver);
	}

	

	/**
	 * Sets all the variables.	
	 */
	private void set(String sBusiness, String sSARType, String sSegment, String sPricingAnalyst, 
			String sChannel, String sEffDate, String sTermDate, String sDistributor, String sState,
			String sPayer, String sCompSituation, String sCompetitor, String sCompConfMethod, 
			String sCompEffDate, String sCompTermDate, String sCompLearnedDate, String sLearnedFrmName,
			String sLearnedCompany, String sProdName, String sType, String sUnitOfMeasure, String sCurrentPrice,
			String sRequestedPrice, String sVolume, String sTerm, String sLevel1Approver)
	{
		this.sBusiness = sBusiness;
		this.sSARType = sSARType;	
		this.sSegment = sSegment;	
		this.sPricingAnalyst = sPricingAnalyst;	
		this.sChannel = sChannel;
		this.sEffDate = sEffDate;	
		this.sTermDate = sTermDate;	
		this.sDistributor = sDistributor;	
		this.sState = sState;
		this.sPayer = sPayer;	
		this.sCompSituation = sCompSituation;	
		this.sCompetitor = sCompetitor;	
		this.sCompConfMethod = sCompConfMethod;
		this.sCompEffDate = sCompEffDate;	
		this.sCompTermDate = sCompTermDate;	
		this.sCompLearnedDate = sCompLearnedDate;	
		this.sLearnedFrmName = sLearnedFrmName;
		this.sLearnedCompany = sLearnedCompany;	
		this.sProdName = sProdName;	
		this.sType = sType;	
		this.sUnitOfMeasure = sUnitOfMeasure;
		this.sCurrentPrice = sCurrentPrice;	
		this.sRequestedPrice = sRequestedPrice;	
		this.sVolume = sVolume;
		this.sTerm = sTerm;
		this.sLevel1Approver=sLevel1Approver;
	}



	@Override
	public String toString() {
		return "CreateNewSARDetails [sBusiness=" + sBusiness + ", sSARType="
				+ sSARType + ", sSegment=" + sSegment + ", sPricingAnalyst="
				+ sPricingAnalyst + ", sChannel=" + sChannel + ", sEffDate="
				+ sEffDate + ", sTermDate=" + sTermDate + ", sDistributor="
				+ sDistributor + ", sState=" + sState + ", sPayer=" + sPayer
				+ ", sCompSituation=" + sCompSituation + ", sCompetitor="
				+ sCompetitor + ", sCompConfMethod=" + sCompConfMethod
				+ ", sCompEffDate=" + sCompEffDate + ", sCompTermDate="
				+ sCompTermDate + ", sCompLearnedDate=" + sCompLearnedDate
				+ ", sLearnedFrmName=" + sLearnedFrmName + ", sLearnedCompany="
				+ sLearnedCompany + ", sProdName=" + sProdName + ", sType="
				+ sType + ", sUnitOfMeasure=" + sUnitOfMeasure
				+ ", sCurrentPrice=" + sCurrentPrice + ", sRequestedPrice="
				+ sRequestedPrice + ", sVolume=" + sVolume + ", sTerm=" + sTerm
				+ ", sLevel1Approver=" + sLevel1Approver + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sBusiness == null) ? 0 : sBusiness.hashCode());
		result = prime * result
				+ ((sChannel == null) ? 0 : sChannel.hashCode());
		result = prime * result
				+ ((sCompConfMethod == null) ? 0 : sCompConfMethod.hashCode());
		result = prime * result
				+ ((sCompEffDate == null) ? 0 : sCompEffDate.hashCode());
		result = prime
				* result
				+ ((sCompLearnedDate == null) ? 0 : sCompLearnedDate.hashCode());
		result = prime * result
				+ ((sCompSituation == null) ? 0 : sCompSituation.hashCode());
		result = prime * result
				+ ((sCompTermDate == null) ? 0 : sCompTermDate.hashCode());
		result = prime * result
				+ ((sCompetitor == null) ? 0 : sCompetitor.hashCode());
		result = prime * result
				+ ((sCurrentPrice == null) ? 0 : sCurrentPrice.hashCode());
		result = prime * result
				+ ((sDistributor == null) ? 0 : sDistributor.hashCode());
		result = prime * result
				+ ((sEffDate == null) ? 0 : sEffDate.hashCode());
		result = prime * result
				+ ((sLearnedCompany == null) ? 0 : sLearnedCompany.hashCode());
		result = prime * result
				+ ((sLearnedFrmName == null) ? 0 : sLearnedFrmName.hashCode());
		result = prime * result
				+ ((sLevel1Approver == null) ? 0 : sLevel1Approver.hashCode());
		result = prime * result + ((sPayer == null) ? 0 : sPayer.hashCode());
		result = prime * result
				+ ((sPricingAnalyst == null) ? 0 : sPricingAnalyst.hashCode());
		result = prime * result
				+ ((sProdName == null) ? 0 : sProdName.hashCode());
		result = prime * result
				+ ((sRequestedPrice == null) ? 0 : sRequestedPrice.hashCode());
		result = prime * result
				+ ((sSARType == null) ? 0 : sSARType.hashCode());
		result = prime * result
				+ ((sSegment == null) ? 0 : sSegment.hashCode());
		result = prime * result + ((sState == null) ? 0 : sState.hashCode());
		result = prime * result + ((sTerm == null) ? 0 : sTerm.hashCode());
		result = prime * result
				+ ((sTermDate == null) ? 0 : sTermDate.hashCode());
		result = prime * result + ((sType == null) ? 0 : sType.hashCode());
		result = prime * result
				+ ((sUnitOfMeasure == null) ? 0 : sUnitOfMeasure.hashCode());
		result = prime * result + ((sVolume == null) ? 0 : sVolume.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateNewSARDetails other = (CreateNewSARDetails) obj;
		if (sBusiness == null) {
			if (other.sBusiness != null)
				return false;
		} else if (!sBusiness.equals(other.sBusiness))
			return false;
		if (sChannel == null) {
			if (other.sChannel != null)
				return false;
		} else if (!sChannel.equals(other.sChannel))
			return false;
		if (sCompConfMethod == null) {
			if (other.sCompConfMethod != null)
				return false;
		} else if (!sCompConfMethod.equals(other.sCompConfMethod))
			return false;
		if (sCompEffDate == null) {
			if (other.sCompEffDate != null)
				return false;
		} else if (!sCompEffDate.equals(other.sCompEffDate))
			return false;
		if (sCompLearnedDate == null) {
			if (other.sCompLearnedDate != null)
				return false;
		} else if (!sCompLearnedDate.equals(other.sCompLearnedDate))
			return false;
		if (sCompSituation == null) {
			if (other.sCompSituation != null)
				return false;
		} else if (!sCompSituation.equals(other.sCompSituation))
			return false;
		if (sCompTermDate == null) {
			if (other.sCompTermDate != null)
				return false;
		} else if (!sCompTermDate.equals(other.sCompTermDate))
			return false;
		if (sCompetitor == null) {
			if (other.sCompetitor != null)
				return false;
		} else if (!sCompetitor.equals(other.sCompetitor))
			return false;
		if (sCurrentPrice == null) {
			if (other.sCurrentPrice != null)
				return false;
		} else if (!sCurrentPrice.equals(other.sCurrentPrice))
			return false;
		if (sDistributor == null) {
			if (other.sDistributor != null)
				return false;
		} else if (!sDistributor.equals(other.sDistributor))
			return false;
		if (sEffDate == null) {
			if (other.sEffDate != null)
				return false;
		} else if (!sEffDate.equals(other.sEffDate))
			return false;
		if (sLearnedCompany == null) {
			if (other.sLearnedCompany != null)
				return false;
		} else if (!sLearnedCompany.equals(other.sLearnedCompany))
			return false;
		if (sLearnedFrmName == null) {
			if (other.sLearnedFrmName != null)
				return false;
		} else if (!sLearnedFrmName.equals(other.sLearnedFrmName))
			return false;
		if (sLevel1Approver == null) {
			if (other.sLevel1Approver != null)
				return false;
		} else if (!sLevel1Approver.equals(other.sLevel1Approver))
			return false;
		if (sPayer == null) {
			if (other.sPayer != null)
				return false;
		} else if (!sPayer.equals(other.sPayer))
			return false;
		if (sPricingAnalyst == null) {
			if (other.sPricingAnalyst != null)
				return false;
		} else if (!sPricingAnalyst.equals(other.sPricingAnalyst))
			return false;
		if (sProdName == null) {
			if (other.sProdName != null)
				return false;
		} else if (!sProdName.equals(other.sProdName))
			return false;
		if (sRequestedPrice == null) {
			if (other.sRequestedPrice != null)
				return false;
		} else if (!sRequestedPrice.equals(other.sRequestedPrice))
			return false;
		if (sSARType == null) {
			if (other.sSARType != null)
				return false;
		} else if (!sSARType.equals(other.sSARType))
			return false;
		if (sSegment == null) {
			if (other.sSegment != null)
				return false;
		} else if (!sSegment.equals(other.sSegment))
			return false;
		if (sState == null) {
			if (other.sState != null)
				return false;
		} else if (!sState.equals(other.sState))
			return false;
		if (sTerm == null) {
			if (other.sTerm != null)
				return false;
		} else if (!sTerm.equals(other.sTerm))
			return false;
		if (sTermDate == null) {
			if (other.sTermDate != null)
				return false;
		} else if (!sTermDate.equals(other.sTermDate))
			return false;
		if (sType == null) {
			if (other.sType != null)
				return false;
		} else if (!sType.equals(other.sType))
			return false;
		if (sUnitOfMeasure == null) {
			if (other.sUnitOfMeasure != null)
				return false;
		} else if (!sUnitOfMeasure.equals(other.sUnitOfMeasure))
			return false;
		if (sVolume == null) {
			if (other.sVolume != null)
				return false;
		} else if (!sVolume.equals(other.sVolume))
			return false;
		return true;
	}	

}