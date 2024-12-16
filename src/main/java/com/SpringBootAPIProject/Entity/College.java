package com.SpringBootAPIProject.Entity;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CId;
	
	 @Column(name = "CName")
	    @JsonProperty("CName")
	private String CName;
	
	 @Column(name = "Location")
	    @JsonProperty("Location")   // it specified non-empty value
	private String Location;
	
	 @OneToMany(mappedBy = "college",cascade = CascadeType.ALL)
	 private List<Branch> branch;

}
