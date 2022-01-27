package net.mims.minnlakes.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 *
 * TODO Auto-generated class documentation
 *
 */
@Entity(name = "FishSpecies")
@Table(name= "fishspecies"
, uniqueConstraints=@UniqueConstraint(columnNames={"fishtypename"})
)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FishSpecies {

	

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "fishspecies_id")
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
	@Column(length = 48, unique = true)
    @Size(min = 2, max = 48)
    @NotNull
	private String fishTypeName;
	
	
	@Column(length = 48)
    @Size(min = 2, max = 48)
    @NotNull
	private String imagePath;
	

	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER, mappedBy = "fishSpecies")
	private Set<Waterbody> waterbodies = new HashSet<>();
	
	/**
	 * 
	 */
	public FishSpecies() {
		this.imagePath = "/images/default.jpg";
	}

	/**
	 * 
	 */
	public FishSpecies(String name) {
		this.imagePath = "/images/default.jpg";
		this.fishTypeName=name;
	}
	
	/**
	 * 
	 */
	public FishSpecies(String name, String imagePath) {
		this.imagePath = "/images/default.jpg";
		this.fishTypeName=name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setFishspeciesId(Long id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
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
	 * @param fishTypeName
	 *            the fishTypeName to set
	 */
	public void setFishTypeName(String fishTypeName) {
		this.fishTypeName = fishTypeName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Set<Waterbody> getWaterbodies() {
		return this.waterbodies;
	}

	public void setWaterbodies(Set<Waterbody> waterbodies) {
		this.waterbodies = waterbodies;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fishTypeName == null) ? 0 : fishTypeName.hashCode());
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fishtype [id=" + id + ", fishTypeName=" + fishTypeName + "]";
	}

}
