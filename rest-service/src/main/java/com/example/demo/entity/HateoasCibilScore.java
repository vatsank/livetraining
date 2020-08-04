package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cibilscore_august")
@Setter
@Getter
@ToString
public class HateoasCibilScore extends RepresentationModel<HateoasCibilScore>  {
	


		 @Id
		 int  id;
		 String panNumber;
		 String firstName;
		 double score;

}
