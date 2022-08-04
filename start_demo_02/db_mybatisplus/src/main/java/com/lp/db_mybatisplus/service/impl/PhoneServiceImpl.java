package com.lp.db_mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.db_mybatisplus.entity.Phone;
import com.lp.db_mybatisplus.mapper.PhoneMapper;
import com.lp.db_mybatisplus.service.PhoneService;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/8/4 11:13
 * @Version 1.0
 */
@Service
public class PhoneServiceImpl extends ServiceImpl<PhoneMapper, Phone> implements PhoneService {
}
