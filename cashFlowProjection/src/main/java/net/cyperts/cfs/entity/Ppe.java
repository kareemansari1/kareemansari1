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

public class Ppe {

@Id
private Integer Id;
@Column(nullable = true)
private String Particulars;
@Column(nullable = true)
private double Computer_HardwareandSoftware;
@Column(nullable = true)
private double Office_Equipment;
@Column(nullable = true)
private double Leasehold_Improvements;
@Column(nullable = true)
private double Furniture_and_Fixtures;
@Column(nullable = true)
private double Total;
}
