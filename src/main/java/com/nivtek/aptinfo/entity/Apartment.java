/**
 * This is the apartment model which contains all the basic information about the apartment.
 * Some of the properties are apartment address, Number of Rooms, Rented On, Number of Residents, etc.
 */
package com.nivtek.aptinfo.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author AsimSubedi
 *
 */

@Entity
@Table(name = "tbl_appartment")
public class Apartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int numOfRooms;
	private int numOfResidents;
	private Date rentedOn;

	@OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", unique = true, nullable = false, updatable = false)
	private Address address;

	public Apartment() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the numOfRooms
	 */
	public int getNumOfRooms() {
		return numOfRooms;
	}

	/**
	 * @param numOfRooms the numOfRooms to set
	 */
	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}

	/**
	 * @return the numOfResidents
	 */
	public int getNumOfResidents() {
		return numOfResidents;
	}

	/**
	 * @param numOfResidents the numOfResidents to set
	 */
	public void setNumOfResidents(int numOfResidents) {
		this.numOfResidents = numOfResidents;
	}

	/**
	 * @return the rentedOn
	 */
	public Date getRentedOn() {
		return rentedOn;
	}

	/**
	 * @param rentedOn the rentedOn to set
	 */
	public void setRentedOn(Date rentedOn) {
		this.rentedOn = rentedOn;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Appartment [id=" + id + ", numOfRooms=" + numOfRooms + ", numOfResidents=" + numOfResidents
				+ ", rentedOn=" + rentedOn + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + numOfResidents;
		result = prime * result + numOfRooms;
		result = prime * result + ((rentedOn == null) ? 0 : rentedOn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apartment other = (Apartment) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (numOfResidents != other.numOfResidents)
			return false;
		if (numOfRooms != other.numOfRooms)
			return false;
		if (rentedOn == null) {
			if (other.rentedOn != null)
				return false;
		} else if (!rentedOn.equals(other.rentedOn))
			return false;
		return true;
	}

}
