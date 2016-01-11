package com.hzfh.api.employee.model;

import com.hzframework.contract.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/5/20.
 */
public class EmployeeInformation  extends BaseEntity implements Serializable {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private int deptNo;
    public int getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
    private int empNo;
    public int getEmpNo() {
        return empNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    private String deptName;
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    private int positionNo;
    public int getPositionNo() {
        return positionNo;
    }
    public void setPositionNo(int positionNo) {
        this.positionNo = positionNo;
    }
    private byte sex;
    public byte getSex() {
        return sex;
    }
    public void setSex(byte sex) {
        this.sex = sex;
    }
    private String nation;
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    private byte marry;
    public byte getMarry() {
        return marry;
    }
    public void setMarry(byte marry) {
        this.marry = marry;
    }
    private String childrenSitiatio;
    public String getChildrenSitiatio() {
        return childrenSitiatio;
    }
    public void setChildrenSitiatio(String childrenSitiatio) {
        this.childrenSitiatio = childrenSitiatio;
    }
    private Date protocolStartTime;
    public Date getProtocolStartTime() {
        return protocolStartTime;
    }
    public void setProtocolStartTime(Date protocolStartTime) {
        this.protocolStartTime = protocolStartTime;
    }
    private Date protocolEndTime;
    public Date getProtocolEndTime() {
        return protocolEndTime;
    }
    public void setProtocolEndTime(Date protocolEndTime) {
        this.protocolEndTime = protocolEndTime;
    }
    private Date officalTime;
    public Date getOfficalTime() {
        return officalTime;
    }
    public void setOfficalTime(Date officalTime) {
        this.officalTime = officalTime;
    }
    private Date contractStartTime;
    public Date getContractStartTime() {
        return contractStartTime;
    }
    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }
    private Date contractEndTime;
    public Date getContractEndTime() {
        return contractEndTime;
    }
    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }
    private Date birthday;
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    private int birthdayYear;
    public int getBirthdayYear() {
        return birthdayYear;
    }
    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }
    private String idCard;
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    private String homeAddress;
    public String getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    private byte degree1;
    public byte getDegree1() {
        return degree1;
    }
    public void setDegree1(byte degree1) {
        this.degree1 = degree1;
    }
    private String graduationSchool1;
    public String getGraduationSchool1() {
        return graduationSchool1;
    }
    public void setGraduationSchool1(String graduationSchool1) {
        this.graduationSchool1 = graduationSchool1;
    }
    private String major1;
    public String getMajor1() {
        return major1;
    }
    public void setMajor1(String major1) {
        this.major1 = major1;
    }
    private byte degree2;
    public byte getDegree2() {
        return degree2;
    }
    public void setDegree2(byte degree2) {
        this.degree2 = degree2;
    }
    private String graduationSchool2;
    public String getGraduationSchool2() {
        return graduationSchool2;
    }
    public void setGraduationSchool2(String graduationSchool2) {
        this.graduationSchool2 = graduationSchool2;
    }
    private String major2;
    public String getMajor2() {
        return major2;
    }
    public void setMajor2(String major2) {
        this.major2 = major2;
    }
    private String permanentPlace;
    public String getPermanentPlace() {
        return permanentPlace;
    }
    public void setPermanentPlace(String permanentPlace) {
        this.permanentPlace = permanentPlace;
    }
    private String birthPlace;
    public String getBirthPlace() {
        return birthPlace;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    private String certificate1;
    public String getCertificate1() {
        return certificate1;
    }
    public void setCertificate1(String certificate1) {
        this.certificate1 = certificate1;
    }
    private Date certificateDate1;
    public Date getCertificateDate1() {
        return certificateDate1;
    }
    public void setCertificateDate1(Date certificateDate1) {
        this.certificateDate1 = certificateDate1;
    }
    private String certificate2;
    public String getCertificate2() {
        return certificate2;
    }
    public void setCertificate2(String certificate2) {
        this.certificate2 = certificate2;
    }
    private Date certificateDate2;
    public Date getCertificateDate2() {
        return certificateDate2;
    }
    public void setCertificateDate2(Date certificateDate2) {
        this.certificateDate2 = certificateDate2;
    }
    private byte politicalStatus;
    public byte getPoliticalStatus() {
        return politicalStatus;
    }
    public void setPoliticalStatus(byte politicalStatus) {
        this.politicalStatus = politicalStatus;
    }
    private Date startTime;
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    private Date endTime;
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    private String comment;
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    private int status;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
