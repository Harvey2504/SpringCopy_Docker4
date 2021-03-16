package CodingSpring1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import CodingSpring1.exception.serviceException.MindtreeServiceException;
import CodingSpring1.model.Minds;
import CodingSpring1.model.Track;

@Service
public interface MindtreeService {

	boolean addTrack(Track track) throws MindtreeServiceException;

	boolean addMinds(Minds minds, int trackId) throws MindtreeServiceException;

	Minds getMindsById(int id) throws MindtreeServiceException;

	Track getTrackById(int trackId) throws MindtreeServiceException;

	boolean updateMindsById(int id, Minds mind) throws MindtreeServiceException;

	boolean updateTrackById(int trackId, Track track) throws MindtreeServiceException;

	boolean deleteMindsById(int id) throws MindtreeServiceException;

	boolean deleteTrackById(int trackId) throws MindtreeServiceException;

	List<Minds> getAllMindsByTrack(String trackName) throws MindtreeServiceException;

}
