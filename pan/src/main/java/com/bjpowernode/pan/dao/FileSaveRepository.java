package com.bjpowernode.pan.dao;

import com.bjpowernode.pan.dao.model.FileSave;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileSaveRepository extends JpaRepository<FileSave, Integer> {
    FileSave findFileSaveByLocalLink(String localLink);

    List<FileSave> findFileSavesByUserName(String useName);

    FileSave findFileSaveByPanPath(String panPath);

    FileSave findFileSaveByUserNameAndFileName(String userName, String fileName);

    @Override
    FileSave save(FileSave fileSave);

    @Override
    void delete(FileSave fileSave);

}
