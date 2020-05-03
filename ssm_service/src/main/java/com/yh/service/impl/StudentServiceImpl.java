package com.yh.service.impl;

import com.yh.dao.StudentDao;
import com.yh.pojo.Student;
import com.yh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.findAll();
        return studentList;
    }
}
