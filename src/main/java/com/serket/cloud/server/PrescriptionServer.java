package com.serket.cloud.server;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2015/5/10.
 */
@RequestMapping("/")
public interface PrescriptionServer {

    /**
     * �̼���������
     * @param appid ��Ȩid
     * @param content ����
     * @param accessToken �������� (���������Ƿŵ�����ͷ���� ��)
     * @return Json
     */
    @RequestMapping(value = "/prescription/{appid}/{content}", method = RequestMethod.GET)
    public Map<String, String> businessLogin(@PathVariable("appid") String appid,@PathVariable("content") String content,@RequestHeader("accessToken")String accessToken);

}