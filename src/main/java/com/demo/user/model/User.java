package com.demo.user.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * User model object used for interacting with API consumers
 * @JsonProperty helps jackson to serealize decorated fields 
 * and omit them in case they are null
 * @author Iqbaldeep_Singh
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "firstName",
    "lastName",
    "dob"
})

public class User {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("dob")
	private String dob;
	
	/**
	 * used to initialize a user object
	 * @param id
	 * @param firstName
	 * @param lastname
	 * @param dob
	 */
	public User(Long id, String firstName, String lastname, String dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastname;
		this.dob = dob;
	}
	
	/**
	 * default constructor
	 */
	protected User() {
		
	}
	
	/**
	 * @return the id
	 */
	@JsonProperty("id")
	public Long getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the firstName
	 */
	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return the firstName
	 */
	public User withFirstName(String firstName) {
		this.firstName = firstName;
		
		return this;
	}
	
	
	/**
	 * @param firstName the firstName to set
	 */
	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @return the lastName
	 */
	public User withLastName(String lastName) {
		this.lastName = lastName;
		
		return this;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
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
	    User user = (User) o;
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
	   * gets builder for this object
	   * @return
	   */
	  public static Builder getBuilder(){
		  
		  return new Builder();
	  }
	  
	  /**
	   * builder class used to build User object using builder pattern
	   * @author Iqbaldeep_Singh
	   *
	   */
	  public static class Builder{
			
			Long id;
			
			String firstName;
			
			String lastName;
			
			String dob;
			
			public Builder withId(Long id) {
				this.id = id;
				
				return this;
			}
			
			public Builder withFirstName(String firstName) {
				this.firstName = firstName;
				
				return this;
			}
			
			
			public Builder withLastName(String lastName) {
				this.lastName = lastName;
				
				return this;
			}
			
			public Builder withDob(String dob) {
				this.dob = dob;
				
				return this;
			}
			
			public User build(){
				
				User user = new User();
				user.setId(this.id);
				user.setFirstName(this.firstName);
				user.setLastName(this.lastName);
				user.setDob(this.dob);
				
				return user;
			}



		  
	  }

}
