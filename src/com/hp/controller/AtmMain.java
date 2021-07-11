package com.hp.controller;
// 自动导包

import com.hp.service.CustomerService;
import com.hp.util.TestUtil;

import java.util.Scanner;
public class AtmMain {
    private static String cardid;
    private static String cardPwd;
    private static CustomerService customerService;
         //atm取款机入口
        public static void main(String[] args) {
            customerService =new CustomerService();
            //测试客户类的 数据  // 作业1: 对 manager管理类 做出  单例模式. 并测试 是否数据初始了
            //CustomerData customerData=CustomerData.getInstance();
            //List<Customer> customerList=customerData.getCustomerList();
            //是一个阶段
            TestUtil.welcome();
            int i=0;
            while(i<6){
                //输入账户密码一个阶段
                doWritePassword();
                doCheckPassword(cardid,cardPwd);
                i++;
            }
            //其他操作--1）校验角色，2）判断账户密码的正确性

        }

    private static void doCheckPassword(String cardid, String cardPwd) {
        // 1. 先校验角色,  判断 cardid 的长度.
        if (cardid.length()==8) { // 客户
            // 校验密码
            customerService.checkpwd(cardid,cardPwd);
        }
    }

    // 判断角色 和 判断密码
    private static void doWritePassword() {
        System. out. println("请输入卡号");
        Scanner scanner = new Scanner(System. in) ;
        cardid = scanner . nextLine( );
        System. out. println("cardid = " + cardid);
        System. out. println( "请输入密码" );
        cardPwd = scanner.nextLine( );
        System. out. println("cardPwd =" + cardPwd);
    }
}
