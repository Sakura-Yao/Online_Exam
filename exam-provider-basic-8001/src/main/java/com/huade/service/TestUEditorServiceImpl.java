package com.huade.service;

import com.huade.mapper.TestUEditorMapper;
import com.huade.pojo.Test_Ueditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestUEditorServiceImpl implements TestUEditorMapper {

    @Autowired
    private TestUEditorMapper testUEditorMapper;

    public void setTestUEditorMapper(TestUEditorMapper testUEditorMapper) {
        this.testUEditorMapper = testUEditorMapper;
    }

    @Override
    public int addTestInfo(Test_Ueditor test_ueditor) {
        return testUEditorMapper.addTestInfo(test_ueditor);
    }

    @Override
    public Test_Ueditor selectTestInfo(String Id) {
        return testUEditorMapper.selectTestInfo(Id);
    }

    @Override
    public int batchAddTestInfo(List<Map<String, Object>> infoList) throws Exception {
        return testUEditorMapper.batchAddTestInfo(infoList);
    }
}
