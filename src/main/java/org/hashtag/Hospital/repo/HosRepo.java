package org.hashtag.Hospital.repo;

import org.hashtag.Hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HosRepo extends JpaRepository<Hospital, Integer>{

	

}
