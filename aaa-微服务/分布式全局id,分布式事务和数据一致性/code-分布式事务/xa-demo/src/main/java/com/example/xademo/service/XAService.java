package com.example.xademo.service;

import com.example.xademo.db118.dao.XA118Mapper;
import com.example.xademo.db118.model.XA118;
import com.example.xademo.dblocalhost.dao.XALocalhostMapper;
import com.example.xademo.dblocalhost.model.XALocalhost;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class XAService {

    @Resource
    private XA118Mapper xa118Mapper;
    @Resource
    private XALocalhostMapper xaLocalhostMapper;

    @Transactional(transactionManager = "xaTransaction")
    public void testXA() {
        XA118 xa118 = new XA118();
        xa118.setId(1);
        xa118.setName("xa_131");
        xa118Mapper.insert(xa118);

        XALocalhost xaLocalhost = new XALocalhost();
        xaLocalhost.setId(1);
        xaLocalhost.setName("xa_132");
        xaLocalhostMapper.insert(xaLocalhost);

    }
}
