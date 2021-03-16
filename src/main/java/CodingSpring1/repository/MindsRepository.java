package CodingSpring1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CodingSpring1.model.Minds;
import CodingSpring1.model.Track;

@Repository
public interface MindsRepository extends JpaRepository<Minds, Integer> {
	public List<Minds> getMindsByTrack(Track track);
}
