package com.hzfh.service.workFlow.model.baseInfo;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.service.workFlow.facade.baseInfo.LetterFacade;

/**
 * Created by Administrator on 2015/11/17.
 */
public class LetterModel {
    public static int addReminds(String subject,String content,int recipient) {
        Letter letter = new Letter();
        letter.setSubject(subject);
        letter.setContent(content);
        letter.setRecipient(recipient);
        letter.setIsRead((byte)0);
        letter.setType((byte)3);
        letter.setInUserNo(10000);
        letter.setImportantDegree((byte)2);//重要程度 默认一般
        return LetterFacade.add(letter);
    }
    public static int addNotice(String subject,String content) {
        Letter letter = new Letter();
        letter.setSubject(subject);
        letter.setContent(content);
        letter.setRecipient(0);
        letter.setType((byte)2);
        letter.setInUserNo(10000);
        letter.setImportantDegree((byte)2);//重要程度 默认一般
        return LetterFacade.add(letter);
    }
}
