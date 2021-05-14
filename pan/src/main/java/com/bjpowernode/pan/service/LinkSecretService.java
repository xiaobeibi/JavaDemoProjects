package com.bjpowernode.pan.service;

import com.bjpowernode.pan.dao.model.LinkSecret;

import java.util.Date;
import java.util.List;

/**
 */
public interface LinkSecretService {
    LinkSecret findLinkSecretByLink(String link);

    LinkSecret findLinkSecretBysecretLink(String secretLink);

    List<LinkSecret> findLinkSecretsByFileName(String fileName);

    LinkSecret findLinkSecretByLocalLinkAndUserName(String localLink, String userName);

    LinkSecret save(LinkSecret linkSecret);

    LinkSecret deleteLinkSecretByLink(String link);

    int addOneToDownloadNum(LinkSecret linkSecret);

    Date updateExpireDay(LinkSecret linkSecret, Date date);

    List<LinkSecret> findLinkSecretsByUserName(String userName);

    Date updateShareDate(LinkSecret linkSecret, Date date);
}
