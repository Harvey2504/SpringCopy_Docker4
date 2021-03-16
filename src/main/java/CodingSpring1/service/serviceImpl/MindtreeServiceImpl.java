package CodingSpring1.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CodingSpring1.exception.MindtreeCustomException;
import CodingSpring1.exception.serviceException.MindtreeServiceException;
import CodingSpring1.model.Minds;
import CodingSpring1.model.Track;
import CodingSpring1.repository.MindsRepository;
import CodingSpring1.repository.TrackRepository;
import CodingSpring1.service.MindtreeService;

@Service
public class MindtreeServiceImpl implements MindtreeService {

	@Autowired
	private MindsRepository mindsRepository;
	@Autowired
	private TrackRepository trackRepository;

	@Override
	public boolean addTrack(Track track) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {
			trackRepository.save(track);
			return true;
		} catch (Exception e) {
			throw new MindtreeServiceException(e);
		}
	}

	@Override
	public boolean addMinds(Minds minds, int trackId) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {
			Track track = trackRepository.findById(trackId).get();
			track.setNoOfMinds(track.getNoOfMinds() + 1);
			minds.setTrack(track);
			mindsRepository.save(minds);
			return true;
		} catch (Exception e) {
			throw new MindtreeServiceException(e);
		}
	}

	@Override
	public Minds getMindsById(int id) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {
			Minds temp = mindsRepository.findById(id).get();
			return temp;
		} catch (Exception e) {
			throw new MindtreeServiceException("Mind's Id Not Found");
		}
	}

	@Override
	public Track getTrackById(int trackId) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {
			Track temp = trackRepository.findById(trackId).get();
			return temp;
		} catch (Exception e) {
			throw new MindtreeServiceException("Track Id Not Found");
		}
	}

	@Override
	public boolean updateMindsById(int id, Minds minds) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {
			Minds temp = mindsRepository.findById(id).get();
			temp.setRole(minds.getRole());
			temp.setPhone(minds.getPhone());
			mindsRepository.save(temp);
			return true;

		} catch (Exception e) {
			throw new MindtreeServiceException("Mind's Id Not Found");
		}
	}

	@Override
	public boolean updateTrackById(int trackId, Track track) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {
			Track temp = trackRepository.findById(trackId).get();
			temp.setTrackName(track.getTrackName());
			temp.setNoOfMinds(track.getNoOfMinds());
			trackRepository.save(temp);
			return true;

		} catch (Exception e) {
			throw new MindtreeServiceException("Mind's Id Not Found");
		}
	}

	@Override
	public boolean deleteMindsById(int id) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {
			mindsRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new MindtreeServiceException(e);
		}
	}

	@Override
	public boolean deleteTrackById(int trackId) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {
			trackRepository.deleteById(trackId);
			return true;
		} catch (Exception e) {
			throw new MindtreeServiceException(e);
		}
	}

	@Override
	public List<Minds> getAllMindsByTrack(String trackName) throws MindtreeServiceException {
		// TODO Auto-generated method stub
		try {

			List<Minds> minds = mindsRepository.getMindsByTrack(trackRepository.getTrackByTrackName(trackName));
			if (minds.isEmpty()) {
				throw new MindtreeCustomException("No Such Track Found");
			}
			return minds;

		} catch (MindtreeCustomException e) {
			throw new MindtreeServiceException(e);
		}

	}

}
