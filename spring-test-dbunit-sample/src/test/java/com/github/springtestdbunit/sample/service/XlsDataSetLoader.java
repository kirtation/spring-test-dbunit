package com.github.springtestdbunit.sample.service;

import java.io.InputStream;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.springframework.core.io.Resource;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;

public class XlsDataSetLoader extends AbstractDataSetLoader {

	@Override
	protected IDataSet createDataSet(Resource resource) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		try(InputStream inputStream = resource.getInputStream()) {
            return new XlsDataSet(inputStream);
        }	
	}

}
