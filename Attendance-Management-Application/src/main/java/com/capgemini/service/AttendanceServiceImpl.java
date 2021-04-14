package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	List<AttendanceEntity> le;
	
	@Autowired
	AttendanceRepository arepo;

	@Override
	public AttendanceEntity addAttendance(AttendanceEntity entity)
	{
		return arepo.save(entity);	
	}

	@Override
	public AttendanceEntity updateAttendance(AttendanceEntity entity) {
		int id = entity.getAttendanceId();
		AttendanceEntity ae = (AttendanceEntity) arepo.findById(id).orElse(null);
		//ae.setDate(entity.getDate());
		ae.setSemester(entity.getSemester());
		ae.setStatus(entity.getStatus());
		arepo.save(ae);
	    return ae;
	}

	@Override
	public String deleteAttendance(AttendanceEntity entity) {
		arepo.delete(entity);
	
		return "Deleted";
	}

	@Override
	public List<AttendanceEntity> getAttendance() {
		le = new ArrayList<>();
		le = arepo.findAll();
		return le;
	}

	@Override
	public AttendanceEntity getAttendanceById(int attendanceId) {
		
		//AttendanceEntity e = arepo.findByAttendanceId(attendanceId);
		AttendanceEntity e = arepo.findById(attendanceId).orElse(null);
		 return e;
	}


}
