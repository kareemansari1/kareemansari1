package net.cyperts.cfs.entity;


import jakarta.persistence.Column;
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
public class Eps {
	@Id
	private Integer Id;
	@Column(nullable = true)
	private String Particulars;
	@Column(nullable = true)
	private double Year_ended;
	@Column(nullable = true)
	private double Year_ended1;
	
}
