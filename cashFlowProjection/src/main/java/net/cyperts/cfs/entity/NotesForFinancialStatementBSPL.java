package net.cyperts.cfs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotesForFinancialStatementBSPL {

	@Id
	private int Id;
	
	private String lineItem;
	
	private String NotesForFinancialstatementBSPL;
	
}
