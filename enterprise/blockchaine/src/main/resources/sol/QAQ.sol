pragma solidity ^0.4.24;

import "./Table.sol";

contract QAQ {
    event CreateResult(string a);
    event newAccountResult(string a);
    event UpdateResult(string a);
    event InsertResult(string a);
    event shouxinResult(string a);
    event chengduiResult(string a);
    event transactionResult(string a);
    
    constructor() public{
        create();
    }
    // 创建表
    function create() public {
        TableFactory tf = TableFactory(0x1001);  
        tf.createTable("chainTable", "name", "sum");
        tf.createTable("historyTable", "name", "event,number");
        emit CreateResult("create_OK");
    }

    // 查询数据
    function findChainTable(string name) public constant returns(bytes32, int){
        TableFactory tf = TableFactory(0x1001);
        Table table = tf.openTable("chainTable");


        return ([table.select(name, table.newCondition()).get(0).getBytes32("name")][0], [table.select(name, table.newCondition()).get(0).getInt("sum")][0]);
    }
    
    function findHistoryTable(string name) public constant returns(bytes32[], bytes32[], int[]){
        TableFactory tf = TableFactory(0x1001);
        Table table = tf.openTable("historyTable");

        // 条件为空表示不筛选 也可以根据需要使用条件筛选
        Condition condition = table.newCondition();

        Entries entries = table.select(name, condition);
        bytes32[] memory user_name_bytes_list = new bytes32[](uint256(entries.size())); 
        bytes32[] memory item_event_bytes_list = new bytes32[](uint256(entries.size()));
        int[] memory item_number_list = new int[](uint256(entries.size()));
       

        for(int i=0; i<entries.size(); ++i) {
            Entry entry = entries.get(i);

            user_name_bytes_list[uint256(i)] = entry.getBytes32("name");
            item_event_bytes_list[uint256(i)] = entry.getBytes32("event");
            item_number_list[uint256(i)] = entry.getInt("number");
        }

        return (user_name_bytes_list, item_event_bytes_list, item_number_list);
    }
    
    // 插入数据
    function newAccount(string name) public {
        TableFactory tf = TableFactory(0x1001);
        Table table = tf.openTable("chainTable");
        
        int ze=0;
        Entry entry = table.newEntry();
        entry.set("name", name);
        entry.set("sum", ze);
        
        table.insert(name, entry);
        emit newAccountResult("newAccount_OK");

    }
    
    function insertHistory(string name, string what, int number) public {
        TableFactory tf = TableFactory(0x1001);
        Table table = tf.openTable("historyTable");

        Entry entry = table.newEntry();
        entry.set("name", name);
        entry.set("event", what);
        entry.set("number", number);

        table.insert(name, entry);
        emit InsertResult("InsertHistory_OK");

    }
    
    // 更新数据
    function update(string name, int sum) public {
        TableFactory tf = TableFactory(0x1001);
        Table table = tf.openTable("chainTable");

        Entry entry = table.newEntry();
        entry.set("sum", sum);

        Condition condition = table.newCondition();
        condition.EQ("name", name);

        table.update(name, entry, condition);
        emit UpdateResult("Update_OK");

    }
    // ************************************************银行***********************************
    function shouxin(string qiye, int number) public {
        
        bytes32 A1; 
        int A2;
        (A1, A2) = findChainTable(qiye);
            
        update(qiye, A2+number);
        insertHistory(qiye, "授信完成", number);

        emit shouxinResult("授信完成");
    }
    
    function chengdui(string qiye, int number) public{
        
        bytes32 A1; 
        int A2;
        (A1, A2) = findChainTable(qiye);
        
        if(A2>=number)
        {
            update(qiye, A2-number);
            insertHistory(qiye, "承兑通过", (-1)*number);
            emit chengduiResult("承兑成功");
            
        }
        else
        {
            emit chengduiResult("承兑失败");
        }

    }
    //*********************************************************************************************
    function makeTransaction(string nameA, string nameB, string what, int number) public{
        
        bytes32 A1; 
        int A2;
        (A1, A2) = findChainTable(nameA);
        
        bytes32 B1; 
        int B2;
        (B1, B2) = findChainTable(nameB);
        
        if(A2>=number)
        {
            
            update(nameA, A2-number);
            update(nameB, B2+number);
            
            insertHistory(nameA, what, (-1)*number);
            insertHistory(nameB, what, number);
            
            emit transactionResult("transaction_OK");
        }
        else
        {
            emit transactionResult("transaction_false");
        }

    }
    
}
