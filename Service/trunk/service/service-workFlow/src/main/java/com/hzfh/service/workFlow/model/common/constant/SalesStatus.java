package com.hzfh.service.workFlow.model.common.constant;

public class SalesStatus {
    public static final byte check = (byte) 1; //待审核
    public static final byte account = (byte) 2; //已到账
    public static final byte success = (byte) 3; //认购成功
    public static final byte refund = (byte) 4; //已退款
    public static final byte CANCEL = (byte) 5; // 已取消
    public static final byte CHECKING = (byte) 8; // 审核中
}
