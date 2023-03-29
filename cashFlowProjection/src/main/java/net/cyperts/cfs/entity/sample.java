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
public class sample {
	@Id
	private int id;
	@Column(nullable = true)
	private String particulars;
	@Column(nullable = true)
	private String note;
	@Column(nullable = true)
	private double As_at_31_March_2022_IGAAP;
	@Column(nullable = true)
	private double indasentries1;
	@Column(nullable = true)
	private double As_at_31_March_2022_Ind_AS;
	@Column(nullable = true)
	private double As_at_31_March_2022;
	@Column(nullable = true)
	private double Yearended31march2022;
	@Column(nullable = true)
	private double As_at_31_March_2021_IGAAP;
	@Column(nullable = true)
	private double indasentries2;
	@Column(nullable = true)
	private double indasregroup2;
	@Column(nullable = true)
	private double As_at_31_March_2021_Ind_AS;
	@Column(nullable = true)
	private double As_at_31_March_2021_Ind_AS2;	
	@Column(nullable = true)
	private double As_at_31_March_2020_IGAAP;
	@Column(nullable = true)
	private double indasentries3;
	@Column(nullable = true)
	private double indasregroup3;
	@Column(nullable = true)
	private double As_at_31_March_2020_Ind_AS;
	@Column(nullable = true)
	private double As_at_01_April_2020;
}
