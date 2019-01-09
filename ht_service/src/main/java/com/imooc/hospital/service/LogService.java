package com.imooc.hospital.service;

import com.imooc.hospital.entity.Log;

import java.util.List;

public interface LogService {
    void addOperationLog(Log log);

    List<Log> getOperationLog();
}
