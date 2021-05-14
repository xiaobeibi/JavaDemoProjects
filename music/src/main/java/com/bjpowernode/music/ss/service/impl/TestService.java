/** 
* 
*
*
*/

package com.bjpowernode.music.ss.service.impl;

import javax.annotation.Resource;

import com.bjpowernode.music.common.AbstractService;
import com.bjpowernode.music.common.IOperations;
import com.bjpowernode.music.ss.domain.Test;
import com.bjpowernode.music.ss.mapper.ITestMapper;
import com.bjpowernode.music.ss.service.ITestService;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestService extends AbstractService<Test, Test> implements ITestService {

	public TestService() {
		this.setTableName("test");
	}

	@Resource   
	private ITestMapper testMapper;

	@Override
	protected IOperations<Test, Test> getMapper() {
		return testMapper;
	}

	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
		;
	}

}
