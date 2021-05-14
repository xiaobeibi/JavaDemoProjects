package com.bjpowernode.pan.service.impl;

import com.bjpowernode.pan.dao.FileSaveRepository;
import com.bjpowernode.pan.dao.model.FileSave;
import com.bjpowernode.pan.service.ISaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveServiceImpl implements ISaveService {

    @Autowired
    FileSaveRepository fileSaveRepository;

    @Override
    public FileSave save(FileSave fileSave) {
        return fileSaveRepository.save(fileSave);
    }

    @Override
    public List<FileSave> findFileSavesByUserName(String useName) {
        return fileSaveRepository.findFileSavesByUserName(useName);
    }

    @Override
    public FileSave findFileSaveByLocalLink(String localLink) {
        return fileSaveRepository.findFileSaveByLocalLink(localLink);
    }

    @Override
    public FileSave findFileSaveByUserNameAndFileName(String userName, String fileName) {
        return fileSaveRepository.findFileSaveByUserNameAndFileName(userName, fileName);
    }

    @Override
    public void delete(FileSave fileSave) {
        fileSaveRepository.delete(fileSave);
    }
}
