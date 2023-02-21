package com.jpa.factory.common.util;

import com.jpa.factory.common.constants.PagingConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * packageName    : com.jpa.factory.common.util
 * fileName       : UiUtils
 * author         : 오주담
 * date           : 2022-12-29
 * description    : 공통 메시지 출력, 페이징
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-29        오주담       최초 생성
 */

@Controller
public class UiUtils {

    public static final String MESSAGE_CREATE = "등록되었습니다.";
    public static final String MESSAGE_UPDATE = "수정되었습니다.";
    public static final String MESSAGE_DELETE = "삭제되었습니다.";
    public static final String MESSAGE_SAVE = "저장되었습니다.";

    public String showMessageWithRedirect(@RequestParam(value = "message", required = false) String message,
                                          @RequestParam(value = "redirectUri", required = true) String redirectUri,
                                          Model model) {
        model.addAttribute("message", message)
                .addAttribute("redirectUri", redirectUri);

        return "utils/message-redirect";
    }

    public int getPageNum(HttpServletRequest request) {
        int pageNum = PagingConstants.DEFAULT_PAGE_NUM;
        if (!StringUtils.isNull(request.getParameter(PagingConstants.PAGE_NUM_PARAMETER_NAME))) {
            pageNum = Integer.parseInt(request.getParameter(PagingConstants.PAGE_NUM_PARAMETER_NAME));
        }
        if (pageNum < 0) {
            pageNum = 0;
        }
        return pageNum;
    }

    public int getPageSize(HttpServletRequest request) {
        int pageSize = PagingConstants.DEFAULT_PAGE_SIZE;
        if (!StringUtils.isNull(request.getParameter(PagingConstants.PAGE_SIZE_PARAMETER_NAME))) {
            pageSize = Integer.parseInt(request.getParameter(PagingConstants.PAGE_SIZE_PARAMETER_NAME));
        }

        return pageSize;
    }
}
