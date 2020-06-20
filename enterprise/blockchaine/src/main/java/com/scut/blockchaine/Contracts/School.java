package com.scut.blockchaine.Contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class School extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b5060405162000f6738038062000f67833981018060405262000037919081019062000171565b60008090505b8151811015620000c457600160008084848151811015156200005b57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555080806001019150506200003d565b50506200022d565b6000620000da82516200020d565b905092915050565b600082601f8301121515620000f657600080fd5b81516200010d6200010782620001e4565b620001b6565b915081818352602084019350602081019050838560208402820111156200013357600080fd5b60005b838110156200016757816200014c8882620000cc565b84526020840193506020830192505060018101905062000136565b5050505092915050565b6000602082840312156200018457600080fd5b600082015167ffffffffffffffff8111156200019f57600080fd5b620001ad84828501620000e2565b91505092915050565b6000604051905081810181811067ffffffffffffffff82111715620001da57600080fd5b8060405250919050565b600067ffffffffffffffff821115620001fc57600080fd5b602082029050602081019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b610d2a806200023d6000396000f30060806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063d029661214610051578063fb987c9d14610091575b600080fd5b34801561005d57600080fd5b506100786004803603610073919081019061090f565b6100ba565b6040516100889493929190610b3a565b60405180910390f35b34801561009d57600080fd5b506100b860048036036100b39190810190610950565b61052f565b005b6060806060806000806060806060806000809650600095505b6001805490508610156101bd576101a26001878154811015156100f257fe5b90600052602060002090600402016000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156101975780601f1061016c57610100808354040283529160200191610197565b820191906000526020600020905b81548152906001019060200180831161017a57829003601f168201915b50505050508d610695565b156101b05786806001019750505b85806001019650506100d3565b866040519080825280602002602001820160405280156101f157816020015b60608152602001906001900390816101dc5790505b509450866040519080825280602002602001820160405280156102235781602001602082028038833980820191505090505b509350866040519080825280602002602001820160405280156102555781602001602082028038833980820191505090505b509250866040519080825280602002602001820160405280156102875781602001602082028038833980820191505090505b50915060009050600095505b600180549050861015610515576103626001878154811015156102b257fe5b90600052602060002090600402016000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103575780601f1061032c57610100808354040283529160200191610357565b820191906000526020600020905b81548152906001019060200180831161033a57829003601f168201915b50505050508d610695565b156105085760018681548110151561037657fe5b90600052602060002090600402016000018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561041b5780601f106103f05761010080835404028352916020019161041b565b820191906000526020600020905b8154815290600101906020018083116103fe57829003601f168201915b5050505050858281518110151561042e57fe5b9060200190602002018190525060018681548110151561044a57fe5b906000526020600020906004020160010154848281518110151561046a57fe5b906020019060200201818152505060018681548110151561048757fe5b90600052602060002090600402016002015483828151811015156104a757fe5b90602001906020020181815250506001868154811015156104c457fe5b90600052602060002090600402016003015482828151811015156104e457fe5b906020019060200201818152505080806001019150508681141561050757610515565b5b8580600101965050610293565b848484849a509a509a509a50505050505050509193509193565b6105376107d7565b6000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1615156105c4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105bb90610b9b565b60405180910390fd5b848160000181905250838160200181815250508281604001818152505081816060018181525050600181908060018154018082558091505090600182039060005260206000209060040201600090919290919091506000820151816000019080519060200190610635929190610800565b506020820151816001015560408201518160020155606082015181600301555050507fd9343e82e57c3d9a6906cf2abd0839fb229cdc1976570f8b129808bde17f6178336040516106869190610b1f565b60405180910390a15050505050565b600080825184511415156106ac57600091506107d0565b600090505b83518110156107cb5782818151811015156106c857fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916848281518110151561074357fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415156107c057600091506107d0565b8060010190506106b1565b600191505b5092915050565b608060405190810160405280606081526020016000815260200160008152602001600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061084157805160ff191683800117855561086f565b8280016001018555821561086f579182015b8281111561086e578251825591602001919060010190610853565b5b50905061087c9190610880565b5090565b6108a291905b8082111561089e576000816000905550600101610886565b5090565b90565b600082601f83011215156108b857600080fd5b81356108cb6108c682610be8565b610bbb565b915080825260208301602083018583830111156108e757600080fd5b6108f2838284610c9d565b50505092915050565b60006109078235610c93565b905092915050565b60006020828403121561092157600080fd5b600082013567ffffffffffffffff81111561093b57600080fd5b610947848285016108a5565b91505092915050565b6000806000806080858703121561096657600080fd5b600085013567ffffffffffffffff81111561098057600080fd5b61098c878288016108a5565b945050602061099d878288016108fb565b93505060406109ae878288016108fb565b92505060606109bf878288016108fb565b91505092959194509250565b6109d481610c69565b82525050565b60006109e582610c2e565b808452602084019350836020820285016109fe85610c14565b60005b84811015610a37578383038852610a19838351610aa3565b9250610a2482610c4f565b9150602088019750600181019050610a01565b508196508694505050505092915050565b6000610a5382610c39565b808452602084019350610a6583610c21565b60005b82811015610a9757610a7b868351610b10565b610a8482610c5c565b9150602086019550600181019050610a68565b50849250505092915050565b6000610aae82610c44565b808452610ac2816020860160208601610cac565b610acb81610cdf565b602085010191505092915050565b6000601582527f596f7520617265206e6f742061207465616368657200000000000000000000006020830152604082019050919050565b610b1981610c89565b82525050565b6000602082019050610b3460008301846109cb565b92915050565b60006080820190508181036000830152610b5481876109da565b90508181036020830152610b688186610a48565b90508181036040830152610b7c8185610a48565b90508181036060830152610b908184610a48565b905095945050505050565b60006020820190508181036000830152610bb481610ad9565b9050919050565b6000604051905081810181811067ffffffffffffffff82111715610bde57600080fd5b8060405250919050565b600067ffffffffffffffff821115610bff57600080fd5b601f19601f8301169050602081019050919050565b6000602082019050919050565b6000602082019050919050565b600081519050919050565b600081519050919050565b600081519050919050565b6000602082019050919050565b6000602082019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b6000819050919050565b82818337600083830152505050565b60005b83811015610cca578082015181840152602081019050610caf565b83811115610cd9576000848401525b50505050565b6000601f19601f83011690509190505600a265627a7a723058208d1780fad873b50f74f1f7a352d439552644cd7941fe5e020ea511d3d8a734db6c6578706572696d656e74616cf50037"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[{\"name\":\"_name\",\"type\":\"string\"}],\"name\":\"getStudent\",\"outputs\":[{\"name\":\"\",\"type\":\"string[]\"},{\"name\":\"\",\"type\":\"uint256[]\"},{\"name\":\"\",\"type\":\"uint256[]\"},{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_age\",\"type\":\"uint256\"},{\"name\":\"_grade\",\"type\":\"uint256\"},{\"name\":\"_class\",\"type\":\"uint256\"}],\"name\":\"setStudent\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"t\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"add\",\"type\":\"address\"}],\"name\":\"SetStudent\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GETSTUDENT = "getStudent";

    public static final String FUNC_SETSTUDENT = "setStudent";

    public static final Event SETSTUDENT_EVENT = new Event("SetStudent",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }));
    ;

    @Deprecated
    protected School(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected School(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected School(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected School(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<Tuple4<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>>> getStudent(String _name) {
        final Function function = new Function(FUNC_GETSTUDENT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {
                }, new TypeReference<DynamicArray<Uint256>>() {
                }, new TypeReference<DynamicArray<Uint256>>() {
                }, new TypeReference<DynamicArray<Uint256>>() {
                }));
        return new RemoteCall<Tuple4<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>>>(
                new Callable<Tuple4<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>>>() {
                    @Override
                    public Tuple4<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<List<String>, List<BigInteger>, List<BigInteger>, List<BigInteger>>(
                                convertToNative((List<Utf8String>) results.get(0).getValue()),
                                convertToNative((List<Uint256>) results.get(1).getValue()),
                                convertToNative((List<Uint256>) results.get(2).getValue()),
                                convertToNative((List<Uint256>) results.get(3).getValue()));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setStudent(String _name, BigInteger _age, BigInteger _grade, BigInteger _class) {
        final Function function = new Function(
                FUNC_SETSTUDENT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_age),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_grade),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_class)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setStudent(String _name, BigInteger _age, BigInteger _grade, BigInteger _class, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETSTUDENT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_age),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_grade),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_class)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setStudentSeq(String _name, BigInteger _age, BigInteger _grade, BigInteger _class) {
        final Function function = new Function(
                FUNC_SETSTUDENT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_age),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_grade),
                        new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_class)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple4<String, BigInteger, BigInteger, BigInteger> getSetStudentInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETSTUDENT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Uint256>() {
                }, new TypeReference<Uint256>() {
                }, new TypeReference<Uint256>() {
                }));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        ;
        return new Tuple4<String, BigInteger, BigInteger, BigInteger>(

                (String) results.get(0).getValue(),
                (BigInteger) results.get(1).getValue(),
                (BigInteger) results.get(2).getValue(),
                (BigInteger) results.get(3).getValue()
        );
    }

    public List<SetStudentEventResponse> getSetStudentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETSTUDENT_EVENT, transactionReceipt);
        ArrayList<SetStudentEventResponse> responses = new ArrayList<SetStudentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetStudentEventResponse typedResponse = new SetStudentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.add = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerSetStudentEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETSTUDENT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, fromBlock, toBlock, otherTopcs, callback);
    }

    public void registerSetStudentEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETSTUDENT_EVENT);
        registerEventLogPushFilter(ABI, BINARY, topic0, callback);
    }

    @Deprecated
    public static School load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new School(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static School load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new School(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static School load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new School(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static School load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new School(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<School> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<String> t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(t.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                org.fisco.bcos.web3j.abi.Utils.typeMap(t, org.fisco.bcos.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(School.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<School> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<String> t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(t.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                org.fisco.bcos.web3j.abi.Utils.typeMap(t, org.fisco.bcos.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(School.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<School> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(t.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                org.fisco.bcos.web3j.abi.Utils.typeMap(t, org.fisco.bcos.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(School.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<School> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(t.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                org.fisco.bcos.web3j.abi.Utils.typeMap(t, org.fisco.bcos.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(School.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class SetStudentEventResponse {
        public Log log;

        public String add;
    }
}
