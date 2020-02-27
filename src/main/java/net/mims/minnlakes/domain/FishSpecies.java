package net.mims.minnlakes.domain;

import javax.annotation.Generated;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * = Fishtype
 *
 * TODO Auto-generated class documentation
 *
 */
@Entity
@Table(name = "FishType")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FishSpecies {

    /**
	 * 
	 */
	public FishSpecies() {
		
	}
	
	

	/**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @Access(value=AccessType.FIELD)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    private Integer version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private String fishTypeName;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the fishTypeName
	 */
	public String getFishTypeName() {
		return fishTypeName;
	}

	/**
	 * @param fishTypeName the fishTypeName to set
	 */
	public void setFishTypeName(String fishTypeName) {
		this.fishTypeName = fishTypeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fishTypeName == null) ? 0 : fishTypeName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FishSpecies other = (FishSpecies) obj;
		if (fishTypeName == null) {
			if (other.fishTypeName != null)
				return false;
		} else if (!fishTypeName.equals(other.fishTypeName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fishtype [id=" + id + ", fishTypeName=" + fishTypeName + "]";
	}
	
	
}
