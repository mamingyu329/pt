package com.xxx.web.controller;

import com.xxx.web.service.BillService;
import com.xxx.web.utils.Result;
import com.xxx.web.vo.BillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("bill")
@Controller
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("buildBill/{activeId}")
    @ResponseBody
    public Result buildBill(@PathVariable Integer activeId, HttpServletResponse response) throws IOException {
       BillVO billVO =  billService.buildBill(activeId);
       return Result.ok(billVO);
    }
}
