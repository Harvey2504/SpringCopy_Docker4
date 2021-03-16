package CodingSpring1.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CodingSpring1.exception.serviceException.MindtreeServiceException;
import CodingSpring1.model.Minds;
import CodingSpring1.model.Track;
import CodingSpring1.service.serviceImpl.MindtreeServiceImpl;

@RestController
@RequestMapping(path = "/mindtree")
public class MindtreeController {
	static String msg = "";

	@Autowired
	public MindtreeServiceImpl service;

	@PostMapping("/add/track")
	public ResponseEntity<?> addTrack(@RequestBody Track track) throws MindtreeServiceException {
		try {
			boolean flag = service.addTrack(track);
			if (flag) {
				return new ResponseEntity<>("Track Created Successfully", HttpStatus.CREATED);
			}

		} catch (ServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/add/minds/{trackId}")
	public ResponseEntity<?> addMinds(@RequestBody Minds minds, @PathVariable Integer trackId) {
		try {
			boolean flag = service.addMinds(minds, trackId);
			if (flag) {
				return new ResponseEntity<>("Minds Created Successfully", HttpStatus.CREATED);
			}

		} catch (MindtreeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/minds/{id}")
	public ResponseEntity<?> getMindsDetails(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(service.getMindsById(id), HttpStatus.OK);
		} catch (MindtreeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/track/{trackId}")
	public ResponseEntity<?> getTrackDetails(@PathVariable Integer trackId) {
		try {
			return new ResponseEntity<>(service.getTrackById(trackId), HttpStatus.OK);
		} catch (MindtreeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/minds/{id}")
	public ResponseEntity<?> deleteMinds(@PathVariable Integer id) {
		try {
			boolean flag = service.deleteMindsById(id);
			if (flag) {
				return new ResponseEntity<>("Deleted Minds Successfully", HttpStatus.NO_CONTENT);
			}

		} catch (MindtreeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/track/{id}")
	public ResponseEntity<?> deleteTrack(@PathVariable Integer trackId) {
		try {
			boolean flag = service.deleteMindsById(trackId);
			if (flag) {
				return new ResponseEntity<>("Deleted Track Successfully", HttpStatus.NO_CONTENT);
			}

		} catch (MindtreeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update/minds/{id}")
	public ResponseEntity<?> updateMindsById(@RequestBody Minds minds, @PathVariable Integer id) {
		try {
			boolean flag = service.updateMindsById(id, minds);
			if (flag) {
				return new ResponseEntity<>("Minds Updated Successfully", HttpStatus.OK);
			}

		} catch (MindtreeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update/track/{trackId}")
	public ResponseEntity<?> updateTrackById(@RequestBody Track track, @PathVariable Integer trackId) {
		try {
			boolean flag = service.updateTrackById(trackId, track);
			if (flag) {
				return new ResponseEntity<>("Minds Updated Successfully", HttpStatus.OK);
			}

		} catch (MindtreeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/all/{trackName}")
	public ResponseEntity<?> getMindsDetailsByTrack(@PathVariable String trackName) {
		try {
			return new ResponseEntity<>(service.getAllMindsByTrack(trackName), HttpStatus.OK);
		} catch (MindtreeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}
}
