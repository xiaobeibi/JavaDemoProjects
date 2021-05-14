package com.bjpowernode.pan.dao;

import com.bjpowernode.pan.dao.model.LinkSecret;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

/**
 */
public interface LinkSecretRepository extends JpaRepository<LinkSecret, Integer> {
    LinkSecret findLinkSecretByLocalLink(String localLink);

    LinkSecret findLinkSecretBySecretLink(String secretLink);

    LinkSecret findLinkSecretByLocalLinkAndUserName(String localLink, String userName);

    List<LinkSecret> findLinkSecretsByFileName(String fileName);

    @Override
    LinkSecret save(LinkSecret linkSecret);

    @Override
    void delete(LinkSecret linkSecret);

    @Modifying
    @Transactional
    @Query("update LinkSecret linksecret set linksecret.downloadNum=?1 where linksecret.localLink=?2")
    int setDownloadNum(int downloadNum, String localLink);

    //更新过期时间
    @Modifying
    @Transactional
    @Query("update LinkSecret linksecret set linksecret.expireDate=?1 where linksecret.localLink=?2")
    int setExpireDay(Date date, String localLink);

    List<LinkSecret> findLinkSecretsByUserName(String userName);

    //更新分享时间
    @Modifying
    @Transactional
    @Query("update LinkSecret linksecret set linksecret.shareDate=?1 where linksecret.localLink=?2")
    int setShareDate(Date date, String localLink);

}
