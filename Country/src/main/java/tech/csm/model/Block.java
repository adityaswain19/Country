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
@Table(name = "block")
public class Block implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="block_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "state_id",referencedColumnName = "state_id")
	private State state;
	
	@Column(name = "block_name")
	private String name;
}
