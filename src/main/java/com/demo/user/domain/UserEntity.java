package com.demo.user.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * database entity decorated with DB specific annotations
 * this entity is persisted in DB
 * @author Iqbaldeep_Singh
 *
 */
@Entity
public class UserEntity {
	
	/* id is auto-generated and persisted in DB */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate dob;
	
	/**
	 * constructor used to initialize a UserEntity object
	 * @param firstName
	 * @param lastname
	 * @param dob
	 */
	public UserEntity(String firstName, String lastname, LocalDate dob) {
		this.firstName = firstName;
		this.lastName = lastname;
		this.dob = dob;
	}
	
	/**
	 * empty constructor required only for JPA
	 */
	protected UserEntity() {
		
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return the firstName
	 */
	public UserEntity withFirstName(String firstName) {
		this.firstName = firstName;
		
		return this;
	}
	
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @return the lastName
	 */
	public UserEntity withLastName(String lastName) {
		this.lastName = lastName;
		
		return this;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	 @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    UserEntity user = (UserEntity) o;
	    return Objects.equals(this.id, user.id) &&
	        Objects.equals(this.firstName, user.firstName) &&
	        Objects.equals(this.lastName, user.lastName);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id, firstName, lastName);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class UserEntity {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
	    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }
	  
	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
	  
	  /**
	   * get the builder object for this class
	   * @return
	   */
	  public static Builder getBuilder(){

		  return new Builder();
	  }
	  
	  /**
	   * used to build the object
	   * @author Iqbaldeep_Singh
	   *
	   */
	  public static class Builder{
			
			
			String firstName;
			
			String lastName;
			
			LocalDate dob;
			
			public Builder withFirstName(String firstName) {
				this.firstName = firstName;
				
				return this;
			}
			
			
			public Builder withLastName(String lastName) {
				this.lastName = lastName;
				
				return this;
			}
			
			public Builder withDob(LocalDate dob) {
				this.dob = dob;
				
				return this;
			}
			
			/**
			 * creates new UserEntity object and sets the values in builder to entity
			 * @return
			 */
			public UserEntity build(){
				
				UserEntity entity = new UserEntity();
				entity.setFirstName(this.firstName);
				entity.setLastName(this.lastName);
				entity.setDob(this.dob);
				
				return entity;
			}



		  
	  }

}
