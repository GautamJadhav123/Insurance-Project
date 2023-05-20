package com.insuranceApp.model;


import java.time.LocalDate;
import java.util.List;

import com.insuranceApp.utils.datesandemi.ModesOfPaying;

public class DueDatesAndEmiPremium {
	
	
	private LocalDate purchaseDate;
	
	private LocalDate commencementDate;
	
	private LocalDate maturityDate;
	
	private List<ModesOfPaying> modesOfPaying;

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public LocalDate getCommencementDate() {
		return commencementDate;
	}

	public void setCommencementDate(LocalDate commencementDate) {
		this.commencementDate = commencementDate;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public List<ModesOfPaying> getModesOfPaying() {
		return modesOfPaying;
	}

	public void setModesOfPaying(List<ModesOfPaying> modesOfPaying) {
		this.modesOfPaying = modesOfPaying;
	}

	@Override
	public String toString() {
		return "DueDatesAndEmiPremium [purchaseDate=" + purchaseDate + ", commencementDate=" + commencementDate
				+ ", maturityDate=" + maturityDate + ", modesOfPaying=" + modesOfPaying + "]";
	}

	public DueDatesAndEmiPremium(LocalDate purchaseDate, LocalDate commencementDate, LocalDate maturityDate,
			List<ModesOfPaying> modesOfPaying) {
		super();
		this.purchaseDate = purchaseDate;
		this.commencementDate = commencementDate;
		this.maturityDate = maturityDate;
		this.modesOfPaying = modesOfPaying;
	}
	
	

}
