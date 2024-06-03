package com.alumini.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alumini.entity.StudentInfo;
import com.alumini.entity.Telephone;
import com.alumini.repository.StudentInfoRepository;

@Service
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	StudentInfoRepository studentInfoRepository;

	@Override
	public StudentInfo createStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub

		try {
			StudentInfo result = studentInfoRepository.save(studentInfo);
			return result;
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public StudentInfo updateStudentInfo(StudentInfo studentInfo, Integer id) {
		// TODO Auto-generated method stub
		try {
			StudentInfo result = studentInfoRepository.save(studentInfo);
			return result;
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Optional<StudentInfo> findById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Optional<StudentInfo> studentInfo = studentInfoRepository.findById(id);
			return studentInfo;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			studentInfoRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentInfo> saveImportedStudentInfo(List<Object> objects) {
		// TODO Auto-generated method stub

		List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
		List<StudentInfo> studentInfoResults = new ArrayList<StudentInfo>();
		
		if(!(CollectionUtils.isEmpty(objects))) {
			Iterator<Object> iterator = objects.iterator();
			while(iterator.hasNext()) {
				Object object = iterator.next();
				StudentInfo info = setStudentInfo(object);
				info.setStatus("A");
				studentInfoList.add(info);
			}
		}
		
		if(!(CollectionUtils.isEmpty(studentInfoList))) {
			Iterator<StudentInfo> itr = studentInfoList.iterator();
			while(itr.hasNext()) {
				StudentInfo studentInfo = itr.next();
				studentInfoResults.add(studentInfoRepository.save(studentInfo));
			}
		}
		return studentInfoResults;
	}

	public StudentInfo setStudentInfo(Object object) {
		StudentInfo studentInfo = new StudentInfo();
		Map<String, String> maps = new HashMap<String, String>();
		maps = (Map<String, String>) object;

		studentInfo.setFirstName(maps.get("FIRST_NAME"));
		studentInfo.setLastName(maps.get("LAST_NAME"));
		studentInfo.setMiddleName(maps.get("MIDDLE_NAME"));
		studentInfo.setGender(maps.get("GENDER"));
		studentInfo.setRollNo(maps.get("ROLL_NO"));
		studentInfo.setUhid(878584l);
		
		try {
			studentInfo.setBirthDate(this.getDate(maps.get("BIRTH_DATE")));
		} catch(Exception e) {
			e.printStackTrace();
		}

		studentInfo = prepareStudentInfo("P", studentInfo, maps.get("STUDENT_PHONE_NUMBER"));
		studentInfo = prepareStudentInfo("S", studentInfo, maps.get("PARENT_PHONE_NUMBER"));

		return studentInfo;
	}

	public Date getDate(String date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return simpleDateFormat.parse(date);
	}	

	public StudentInfo prepareStudentInfo(String type, StudentInfo studentInfo, String dialNumber) {

		List<Telephone> telephoneList = new ArrayList<Telephone>();

		if(!(CollectionUtils.isEmpty(studentInfo.getTelephone()))) {
			telephoneList = studentInfo.getTelephone();
		}

		Telephone telephone = new Telephone();
		telephone.setType(type);
		telephone.setDialNumber(dialNumber);
		telephone.setCountryDialing("+91");

		telephoneList.add(telephone);

		studentInfo.setTelephone(telephoneList);
		return studentInfo;
	}
}
