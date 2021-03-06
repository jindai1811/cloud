package com.serket.cloud.server;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2015/5/10.
 */
@RequestMapping("/")
public interface PrescriptionServer {

    /**
     * 商家请求数据
     * @param appid 授权id
     * @param content 内容
     * @param accessToken 访问令牌 (访问令牌是放到请求头里面 的)
     * @return Json
     */
    @RequestMapping(value = "/prescription/{appid}/{content}", method = RequestMethod.GET)
    public Map<String, String> businessLogin(@PathVariable("appid") String appid,@PathVariable("content") String content);


}
