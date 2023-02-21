package com.jpa.factory.controller.admin;

import com.jpa.factory.common.component.AjaxTools;
import com.jpa.factory.common.util.UiUtils;
import com.jpa.factory.model.dto.admin.AuthorMngDTO;
import com.jpa.factory.model.entity.primary.AuthorMng;
import com.jpa.factory.service.admin.AuthorMngService;
import com.jpa.factory.service.login.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * packageName    : com.jpa.factory.controller.admin
 * fileName       : AuthorMngController
 * author         : 오주담
 * date           : 2022-12-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-29        오주담       최초 생성
 */

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/author-mng")
public class AuthorMngController extends UiUtils {

    private final AuthorMngService authorMngService;
    private final CustomUserDetailService customUserDetailService;
    private final AjaxTools ajaxRender;

    @GetMapping
    public String index(@ModelAttribute AuthorMng authorMng, HttpServletRequest request, Model model) {

        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);

        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.by("createdAt").descending());
        //PageHelper.startPage(pageNum, pageSize);

//        Page<AuthorMng> mngs = authorMngService.findAll(pageRequest, authorMngDTO);
        Page<AuthorMng> mngs = authorMngService.findAllWithBoardAndMenuPageable(pageRequest);
        model.addAttribute("list", mngs);
        model.addAttribute("authorMng", authorMng);

        return "admin/author-mng/index";
    }
}
