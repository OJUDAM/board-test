package com.jpa.factory.common.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * packageName    : com.jpa.factory.common.component
 * fileName       : AjaxTools
 * author         : 오주담
 * date           : 2022-12-30
 * description    : Ajax
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-30        오주담       최초 생성
 */

@Component
public class AjaxTools {

    @Autowired
    private ObjectMapper objectMapper;

    public String require() throws JsonProcessingException {
        return fail("필수데이터가 존재하지않습니다.");
    }

    public String success() throws JsonProcessingException {
        ModelMap resp = new ModelMap();
        resp.put("status", "success");

        return objectMapper.writeValueAsString(resp);
    }

    public String sucess(Object object) throws JsonProcessingException {
        ModelMap resp = new ModelMap();
        resp.put("status", "success");
        resp.put("body", object);

        return objectMapper.writeValueAsString(resp);
    }

    public String render(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }


    public String fail(String msg) throws JsonProcessingException {
        ModelMap resp = new ModelMap();
        resp.put("status", "fail");
        resp.put("msg", msg);

        return objectMapper.writeValueAsString(resp);
    }

    public String fail(int errorCode) throws JsonProcessingException {
        ModelMap resp = new ModelMap();
        resp.put("status", "fail");
        resp.put("error_code", errorCode);

        return objectMapper.writeValueAsString(resp);
    }

}
