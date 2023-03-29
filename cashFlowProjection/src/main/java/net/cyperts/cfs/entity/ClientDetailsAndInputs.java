package net.cyperts.cfs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ClientDetailsAndInputs {
	
	@Id
	private String clientName;
	
	private String clientType;
	
	private String clientPrecisionCode;
	
	private String clientExpirationDate;
	
	private String pocName;
	
	private String pocEmail;
	
	private boolean pocTreatmentOfBankOverdraft;
	
	private String pocInsuranceClaimsReceived;
	
	private double pocDenominationInputAmount;
	
	private double pocDenominationOutputCashFlow;
	
	private String pocContingentConsideration;
	
	private boolean pocConsolidatedCFS;
	
	

}
