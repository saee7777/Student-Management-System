package com.SpringBootAPIProject.Entity;

import java.util.List;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Branch {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int branchId;
	
	@Column(name="branch_name")
	private String branchName;
	
	@ManyToOne
    @JoinColumn(name = "cid") // This column will reference the College table
    private College college;

	 @OneToMany(mappedBy = "branch")
	 private List<Student> student;

}
