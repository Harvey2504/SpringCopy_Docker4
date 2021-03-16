package CodingSpring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CodingSpring1.model.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

	public Track getTrackByTrackName(String trackName);

}
