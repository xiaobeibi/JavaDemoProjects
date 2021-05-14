package com.bjpowernode.finance;

import com.bjpowernode.finance.entity.UserChangeMoney;
import com.bjpowernode.finance.mapper.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinanceApplicationTests {

	@Autowired(required = false)
	AdminMapper adminMapper;
	@Autowired(required = false)
    NewsMapper newsMapper;
	@Autowired
    LoanMapper loanMapper;
	@Autowired
    BankMapper bankMapper;
	@Autowired
    ChangeMoneyMapper changeMoneyMapper;
	@Autowired
    UserChangeMoneyMapper userChangeMoneyMapper;

	@Test
	public void contextLoads() {
//		Admin ad = adminMapper.selectByPrimaryKey(1);
//		System.out.println(ad);

//		List<News> list = newsMapper.selectByExample(null);
//		for (News news:list){
//			System.out.println(news.getCreatetime());
//		}
//		News news = newsMapper.selectByPrimaryKey(1);
//		System.out.println(news);
//		Loan loan = loanMapper.selectByPrimaryKey(1);
//		System.out.println(loan.getLoantime());

//		Bank bank = bankMapper.selectByPrimaryKey(1);
//		System.out.println(bank.getAssets());

//		ChangeMoney changeMoney = changeMoneyMapper.selectByPrimaryKey(1);
//		System.out.println(changeMoney.getAnnualincome());

		UserChangeMoney ucm = userChangeMoneyMapper.selectByPrimaryKeyWithUserAndChangeMoney(1);
		System.out.println(ucm.getUser().getUsername());
	}

}
