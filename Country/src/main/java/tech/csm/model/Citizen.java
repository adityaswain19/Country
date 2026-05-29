package tech.csm.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "citizen")
public class Citizen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="citizen_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="village_id",referencedColumnName = "village_id")
	private Village village;
	
	@Column(name="citizen_name")
	private String name;
	
	@Column(name="citizen_gender")
	private String gender;
	
	@Column(name="citizen_phone")
	private String phone;
	
	@Column(name="citizen_email")
	private String email;
}
