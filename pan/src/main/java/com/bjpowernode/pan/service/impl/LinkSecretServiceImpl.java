package com.bjpowernode.pan.service.impl;

import com.bjpowernode.pan.dao.LinkSecretRepository;
import com.bjpowernode.pan.dao.model.LinkSecret;
import com.bjpowernode.pan.service.LinkSecretService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LinkSecretServiceImpl implements LinkSecretService {
    @Autowired
    private LinkSecretRepository linkSecretRepository;

    @Override
    public LinkSecret findLinkSecretByLink(String link) {
        return linkSecretRepository.findLinkSecretByLocalLink(link);
    }

    @Override
    public LinkSecret findLinkSecretBysecretLink(String secretLink) {
        return linkSecretRepository.findLinkSecretBySecretLink(secretLink);
    }

    @Override
    public List<LinkSecret> findLinkSecretsByFileName(String fileName) {
        return linkSecretRepository.findLinkSecretsByFileName(fileName);
    }

    @Override
    public LinkSecret findLinkSecretByLocalLinkAndUserName(String localLink, String userName) {
        return linkSecretRepository.findLinkSecretByLocalLinkAndUserName(localLink, userName);
    }

    @Override
    public LinkSecret save(LinkSecret linkSecret) {
        return linkSecretRepository.save(linkSecret);
    }

    @Override
    public LinkSecret deleteLinkSecretByLink(String link) {
        LinkSecret linkSecret = linkSecretRepository.findLinkSecretByLocalLink(link);
        linkSecretRepository.delete(linkSecret);
        return linkSecret;
    }

    @Override
    public int addOneToDownloadNum(LinkSecret linkSecret) {
        int downloadNum = linkSecret.getDownloadNum() + 1;
        linkSecretRepository.setDownloadNum(downloadNum, linkSecret.getLocalLink());
        return downloadNum;
    }

    @Override
    public Date updateExpireDay(LinkSecret linkSecret, Date date) {
        linkSecretRepository.setExpireDay(date, linkSecret.getLocalLink());
        return date;
    }

    @Override
    public List<LinkSecret> findLinkSecretsByUserName(String userName) {
        List<LinkSecret> linkSecretList = linkSecretRepository.findLinkSecretsByUserName(userName);
        return linkSecretList;
    }

    @Override
    public Date updateShareDate(LinkSecret linkSecret, Date date) {
        linkSecretRepository.setShareDate(date, linkSecret.getLocalLink());
        return date;
    }

}
