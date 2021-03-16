package CodingSpring1.model;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

@Entity
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trackId;

	private String trackName;
	private int noOfMinds;

	// @OneToMany
	// private List<Minds> mindsList;

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public int getNoOfMinds() {
		return noOfMinds;
	}

	public void setNoOfMinds(int noOfMinds) {
		this.noOfMinds = noOfMinds;
	}

	// public List<Minds> getMindsList() {
	// return mindsList;
	// }

	// public void setMindsList(List<Minds> mindsList) {
	// this.mindsList = mindsList;
	// }
//, List<Minds> mindsList
	public Track(int trackId, String trackName, int noOfMinds) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
		this.noOfMinds = noOfMinds;
		// this.mindsList = mindsList;
	}

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

}
