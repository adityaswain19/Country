package tech.csm.model;

import java.io.Serializable;

import org.springframework.data.annotation.Reference;

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
@Table(name = "panchayat")
public class Panchayat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="panchayat_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "block_id",referencedColumnName = "block_id")
	private Block block;
	
	@Column(name = "panchayat_name")
	private String name;
}
