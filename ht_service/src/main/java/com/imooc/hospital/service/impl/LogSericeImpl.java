package com.imooc.hospital.service.impl;

import com.imooc.hospital.dao.LogDao;
import com.imooc.hospital.entity.Log;
import com.imooc.hospital.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("logService")
public class LogSericeImpl implements LogService {

    @Autowired
    private LogDao logDao;




    public void addOperationLog(Log log) {
        log.setOprTime(new Date());
        log.setType("operation");
        System.out.println("log setOperation=" + log.getOperation() + "log operator=" + log.getOperator());
        logDao.insert(log);
    }

    public List<Log> getSystemLog() {
        return logDao.selectByType("system");
    }


    public List<Log> getOperationLog() {
        return logDao.selectByType("operation");
    }
}
