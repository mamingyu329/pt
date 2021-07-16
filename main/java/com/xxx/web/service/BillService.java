package com.xxx.web.service;

import com.xxx.web.domain.Bill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.web.vo.BillVO;

/**
 *
 */
public interface BillService extends IService<Bill> {

    BillVO buildBill(Integer activeId);
}
