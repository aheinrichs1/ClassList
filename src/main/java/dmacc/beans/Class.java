package dmacc.beans;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Oct 29, 2022
 */
@Data
@Entity
public class Class {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String subject;
	private String student;
}