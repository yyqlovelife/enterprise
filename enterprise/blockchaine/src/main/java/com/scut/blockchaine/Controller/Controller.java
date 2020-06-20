package com.scut.blockchaine.Controller;

import com.google.common.collect.Lists;
import com.scut.blockchaine.AutoConfig.Web3jConfig;
import com.scut.blockchaine.Constants.GasConstants;
import com.scut.blockchaine.Contracts.*;
import com.scut.blockchaine.Mapper.EnterpriseMapper;
import com.scut.blockchaine.Mapper.TransMapper;
import com.scut.blockchaine.Mapper.UserMapper;
import com.scut.blockchain.Pojo.Trans;
import com.scut.blockchain.Pojo.User;
import com.scut.blockchaine.Result;
import com.scut.blockchaine.Utils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class Controller {
    @Autowired
    Credentials credentials;
    @Autowired
    Web3j web3j;
    @Autowired
    QAQ contra;
    @Autowired
    UserMapper userMapper;
    @Autowired
    EnterpriseMapper enterpriseMapper;
    @Autowired
    TransMapper transMapper;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH:mm");
    Logger logger = Logger.getLogger(Controller.class);
    //AllContracts allContracts = AllContracts.getContracts();


    //    @RequestMapping(value = "api/hello")
//    public String Hello() throws Exception{
//        Web3j web3j= Web3jConfig.getWeb3j(service);
//        //通过Web3j对象调用API接口getBlockNumber
//        BigInteger blockNumber = web3j.getBlockNumber().send().getBlockNumber();
//        return blockNumber.toString();
//    }
//    @RequestMapping(value = "api/deploySchool")
//    public String deploySchool() throws Exception {
//        Web3j web3j= Web3jConfig.getWeb3j(service);
//        allContracts.setSchool(School.deploy(web3j,credentials,new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), Lists.newArrayList("0xf6d30257e43ac97d10de2bb009195bd7b11413d2")).send());
//        School school=allContracts.getSchool();
//        return "部署School成功,合约地址为："+school.getContractAddress();
//    }
//    @RequestMapping(value = "api/addStudent")
//    public String addStudent(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("grade") int grade,@RequestParam("class") int classes) throws Exception {
//        School school=allContracts.getSchool();
//        TransactionReceipt transactionReceipt=school.setStudent(name,BigInteger.valueOf(age),BigInteger.valueOf(grade),BigInteger.valueOf(classes)).send();
//        if(!transactionReceipt.getStatus().equals("0x0")){
//            return "你不是老师，无法添加学生，添加失败";
//        }
//        return "成功添加学生"+name+"交易哈希为："+transactionReceipt.getTransactionHash();
//    }
//    @RequestMapping(value = "api/getStudent")
//    public String addStudent(@RequestParam String name) throws Exception {
//        School school=allContracts.getSchool();
//        Tuple4 res;
//        res=school.getStudent(name).send();
//        List<String> names= (List<String>) res.getValue1();
//        List<BigInteger> age= (List<BigInteger>) res.getValue2();
//        List<BigInteger> grade= (List<BigInteger>) res.getValue3();
//        List<BigInteger> classes= (List<BigInteger>) res.getValue4();
//        if(names.isEmpty()){
//            return "没有查找到该学生";
//        }
//        String result="成功查找到"+names.size()+"名为"+names.get(0)+"的学生\n";
//        for(int i=0;i<names.size();i++){
//            result+="学生"+(i+1)+"\n";
//            result+="年龄："+age.get(i)+"\n";
//            result+="班级："+grade.get(i)+"年级"+classes.get(i)+"班\n";
//        }
//        return "<pre>"+result+"</pre>";
//    }
//    @RequestMapping(value = "api/deploySchool_crud")
//    public String deploySchool_crud() throws Exception {
//        Web3j web3j= Web3jConfig.getWeb3j(service);
//        allContracts.setSchool_crud(School_crud.deploy(web3j,credentials,new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), Lists.newArrayList("0xf6d30257e43ac97d10de2bb009195bd7b11413d1")).send());
//        School_crud school_crud=allContracts.getSchool_crud();
//        return "部署School_crud成功,合约地址为："+school_crud.getContractAddress();
//    }
//    @RequestMapping(value = "api/addStudent_crud")
//    public String addStudent_crud(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("grade") int grade,@RequestParam("class") int classes) throws Exception {
//        School_crud school_crud=allContracts.getSchool_crud();
//        TransactionReceipt transactionReceipt=school_crud.setStudent(name,BigInteger.valueOf(age),BigInteger.valueOf(grade),BigInteger.valueOf(classes)).send();
//        if(!transactionReceipt.getStatus().equals("0x0")){
//            return "添加失败";
//        }
//        return "成功添加学生"+name+"交易哈希为："+transactionReceipt.getTransactionHash();
//    }
//    @RequestMapping(value = "api/getStudent_crud")
//    public String addStudent_crud(@RequestParam String name) throws Exception {
//        School_crud school_crud=allContracts.getSchool_crud();
//        Tuple4 res;
//        res=school_crud.getStudent(name).send();
//        List<String> names= (List<String>) res.getValue1();
//        List<BigInteger> age= (List<BigInteger>) res.getValue2();
//        List<BigInteger> grade= (List<BigInteger>) res.getValue3();
//        List<BigInteger> classes= (List<BigInteger>) res.getValue4();
//        if(names.isEmpty()){
//            return "没有查找到该学生";
//        }
//        String result="成功查找到"+names.size()+"名为"+names.get(0)+"的学生\n";
//            for(int i=0;i<names.size();i++){
//                result+="学生"+(i+1)+"\n";
//                result+="年龄："+age.get(i)+"\n";
//                result+="班级："+grade.get(i)+"年级"+classes.get(i)+"班\n";
//        }
//        return "<pre>"+result+"</pre>";
//    }

    public boolean loginE(String id, String password) throws Exception {
        String res = enterpriseMapper.getPassword(id);
        return password.equals(res);
    }

    //企业积分查询
    @RequestMapping(value = "/showscoreE", method = RequestMethod.GET)
    public Result showscoreE(@RequestParam("id") String id, @RequestParam("password") String password) throws Exception {
        System.out.println(id);
        if(!loginE(id,password)){
            return new Result(1);
        }
        Tuple2<byte[], BigInteger> rest_score=contra.findChainTable(id).send();
        Result res=new Result(3);
        res.setScore_number(rest_score.getValue2().toString());
        return res;
    }

    //企业申请积分授信
    @RequestMapping(value = "/applyscore", method = RequestMethod.POST)
    public Result applyscore(@RequestBody Map<String, String> info) throws Exception {
        String id = info.get("id1");
        String password = info.get("password1");
        String cardNumber = info.get("card_number1");
        String scoreNumber = info.get("score_number1");
        if(!loginE(id,password)){
            return new Result(1);
        }
        contra.shouxin(id,BigInteger.valueOf(Long.parseLong(scoreNumber))).send();
        return new Result(3);
    }

    //企业进行积分承兑
    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public Result convert(@RequestBody Map<String, String> info) throws Exception {
        String id = info.get("id2");
        String password = info.get("password2");
        String cardNumber = info.get("card_number2");
        String scoreNumber = info.get("score_number2");
        if(!loginE(id,password)){
            return new Result(1);
        }
        Tuple2<byte[], BigInteger> rest_score=contra.findChainTable(id).send();
        if(Integer.valueOf(String.valueOf(rest_score.getValue2()))<Integer.valueOf(scoreNumber)){
            return new Result(2);
        }
        System.out.println(id);
        contra.chengdui(id,BigInteger.valueOf(Long.parseLong(scoreNumber))).send();
        return new Result(3);
    }
}
