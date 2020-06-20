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
public class School_crud extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b50604051620021ae380380620021ae833981018060405262000037919081019062000322565b600062000043620001c2565b600091505b8251821015620000cf57600160008085858151811015156200006657fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550818060010192505062000048565b611001816020019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050806020015173ffffffffffffffffffffffffffffffffffffffff166356004b6a6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401620001629062000438565b602060405180830381600087803b1580156200017d57600080fd5b505af115801562000192573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250620001b8919081019062000367565b5050505062000505565b60c06040519081016040528060008152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff1681525090565b6000620002758251620004db565b905092915050565b600082601f83011215156200029157600080fd5b8151620002a8620002a282620004b2565b62000484565b91508181835260208401935060208101905083856020840282011115620002ce57600080fd5b60005b83811015620003025781620002e7888262000267565b845260208401935060208301925050600181019050620002d1565b5050505092915050565b60006200031a8251620004fb565b905092915050565b6000602082840312156200033557600080fd5b600082015167ffffffffffffffff8111156200035057600080fd5b6200035e848285016200027d565b91505092915050565b6000602082840312156200037a57600080fd5b60006200038a848285016200030c565b91505092915050565b6000600882527f73747564656e74730000000000000000000000000000000000000000000000006020830152604082019050919050565b6000600482527f6e616d65000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000600f82527f6167652c67726164652c636c61737300000000000000000000000000000000006020830152604082019050919050565b60006060820190508181036000830152620004538162000393565b905081810360208301526200046881620003ca565b905081810360408301526200047d8162000401565b9050919050565b6000604051905081810181811067ffffffffffffffff82111715620004a857600080fd5b8060405250919050565b600067ffffffffffffffff821115620004ca57600080fd5b602082029050602081019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b611c9980620005156000396000f30060806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063d029661214610051578063fb987c9d14610091575b600080fd5b34801561005d57600080fd5b5061007860048036036100739190810190611462565b6100ba565b6040516100889493929190611844565b60405180910390f35b34801561009d57600080fd5b506100b860048036036100b391908101906114e4565b610c8c565b005b6060806060806100c86111a3565b6100d0611248565b6000611001836020019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050826020015173ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016101639061196e565b602060405180830381600087803b15801561017d57600080fd5b505af1158015610191573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506101b59190810190611410565b836040019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050826040015173ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561025457600080fd5b505af1158015610268573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525061028c9190810190611395565b836060019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050826060015173ffffffffffffffffffffffffffffffffffffffff1663cd30a1d1896040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161031c91906119ae565b600060405180830381600087803b15801561033657600080fd5b505af115801561034a573d6000803e3d6000fd5b50505050826040015173ffffffffffffffffffffffffffffffffffffffff1663e8434e398985606001516040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016103ad9291906118c0565b602060405180830381600087803b1580156103c757600080fd5b505af11580156103db573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506103ff91908101906113be565b8360a0019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508260a0015173ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561049e57600080fd5b505af11580156104b2573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506104d69190810190611439565b60405190808252806020026020018201604052801561050957816020015b60608152602001906001900390816104f45790505b5082600001819052508260a0015173ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561057a57600080fd5b505af115801561058e573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506105b29190810190611439565b6040519080825280602002602001820160405280156105e05781602001602082028038833980820191505090505b5082602001819052508260a0015173ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561065157600080fd5b505af1158015610665573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506106899190810190611439565b6040519080825280602002602001820160405280156106b75781602001602082028038833980820191505090505b5082604001819052508260a0015173ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561072857600080fd5b505af115801561073c573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506107609190810190611439565b60405190808252806020026020018201604052801561078e5781602001602082028038833980820191505090505b508260600181905250600090505b8260a0015173ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561080457600080fd5b505af1158015610818573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525061083c9190810190611439565b811015610c5a578260a0015173ffffffffffffffffffffffffffffffffffffffff1663846719e0826040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161089c91906118a5565b602060405180830381600087803b1580156108b657600080fd5b505af11580156108ca573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506108ee91908101906113e7565b836080019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050826080015173ffffffffffffffffffffffffffffffffffffffff16639c981fcb6040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040161097c9061198e565b600060405180830381600087803b15801561099657600080fd5b505af11580156109aa573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f820116820180604052506109d391908101906114a3565b8260000151828151811015156109e557fe5b90602001906020020181905250826080015173ffffffffffffffffffffffffffffffffffffffff1663fda69fae6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610a4990611a03565b602060405180830381600087803b158015610a6357600080fd5b505af1158015610a77573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610a9b9190810190611439565b826020015182815181101515610aad57fe5b9060200190602002018181525050826080015173ffffffffffffffffffffffffffffffffffffffff1663fda69fae6040518163ffffffff167c01000000", "00000000000000000000000000000000000000000000000000028152600401610b1290611920565b602060405180830381600087803b158015610b2c57600080fd5b505af1158015610b40573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610b649190810190611439565b826040015182815181101515610b7657fe5b9060200190602002018181525050826080015173ffffffffffffffffffffffffffffffffffffffff1663fda69fae6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610bdb90611a51565b602060405180830381600087803b158015610bf557600080fd5b505af1158015610c09573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610c2d9190810190611439565b826060015182815181101515610c3f57fe5b9060200190602002018181525050808060010191505061079c565b816000015182602001518360400151846060015183935082925081915080905096509650965096505050509193509193565b610c946111a3565b6000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515610d21576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610d18906119e3565b60405180910390fd5b611001816020019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050806020015173ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610db29061196e565b602060405180830381600087803b158015610dcc57600080fd5b505af1158015610de0573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610e049190810190611410565b816040019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050806040015173ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610ea357600080fd5b505af1158015610eb7573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250610edb91908101906113e7565b816080019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050806080015173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74856040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610f6b9190611a23565b600060405180830381600087803b158015610f8557600080fd5b505af1158015610f99573d6000803e3d6000fd5b50505050806080015173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74846040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401610ff69190611940565b600060405180830381600087803b15801561101057600080fd5b505af1158015611024573d6000803e3d6000fd5b50505050806080015173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74836040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016110819190611a71565b600060405180830381600087803b15801561109b57600080fd5b505af11580156110af573d6000803e3d6000fd5b50505050806040015173ffffffffffffffffffffffffffffffffffffffff166331afac368683608001516040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016111129291906118f0565b602060405180830381600087803b15801561112c57600080fd5b505af1158015611140573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052506111649190810190611439565b507fd9343e82e57c3d9a6906cf2abd0839fb229cdc1976570f8b129808bde17f6178336040516111949190611829565b60405180910390a15050505050565b60c06040519081016040528060008152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff1681525090565b608060405190810160405280606081526020016060815260200160608152602001606081525090565b600061127d8251611b8c565b905092915050565b60006112918251611b9e565b905092915050565b60006112a58251611bb0565b905092915050565b60006112b98251611bc2565b905092915050565b60006112cd8251611bd4565b905092915050565b600082601f83011215156112e857600080fd5b81356112fb6112f682611acc565b611a9f565b9150808252602083016020830185838301111561131757600080fd5b611322838284611c0c565b50505092915050565b600082601f830112151561133e57600080fd5b815161135161134c82611acc565b611a9f565b9150808252602083016020830185838301111561136d57600080fd5b611378838284611c1b565b50505092915050565b600061138d8235611bde565b905092915050565b6000602082840312156113a757600080fd5b60006113b584828501611271565b91505092915050565b6000602082840312156113d057600080fd5b60006113de84828501611285565b91505092915050565b6000602082840312156113f957600080fd5b600061140784828501611299565b91505092915050565b60006020828403121561142257600080fd5b6000611430848285016112ad565b91505092915050565b60006020828403121561144b57600080fd5b6000611459848285016112c1565b91505092915050565b60006020828403121561147457600080fd5b600082013567ffffffffffffffff81111561148e57600080fd5b61149a848285016112d5565b91505092915050565b6000602082840312156114b557600080fd5b600082015167ffffffffffffffff8111156114cf57600080fd5b6114db8482850161132b565b91505092915050565b600080600080608085870312156114fa57600080fd5b600085013567ffffffffffffffff81111561151457600080fd5b611520878288016112d5565b945050602061153187828801611381565b935050604061154287828801611381565b925050606061155387828801611381565b91505092959194509250565b61156881611b58565b82525050565b600061157982611b12565b8084526020840193508360208202850161159285611af8565b60005b848110156115cb5783830388526115ad83835161169a565b92506115b882611b3e565b9150602088019750600181019050611595565b508196508694505050505092915050565b60006115e782611b1d565b8084526020840193506115f983611b05565b60005b8281101561162b5761160f86835161181a565b61161882611b4b565b91506020860195506001810190506115fc565b50849250505092915050565b61164081611be8565b82525050565b61164f81611bfa565b82525050565b61165e81611b78565b82525050565b600061166f82611b33565b808452611683816020860160208601611c1b565b61168c81611c4e565b602085010191505092915050565b60006116a582611b28565b8084526116b9816020860160208601611c1b565b6116c281611c4e565b602085010191505092915050565b6000600582527f67726164650000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000600882527f73747564656e74730000000000000000000000000000000000000000000000006020830152604082019050919050565b6000600482527f6e616d65000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000601582527f596f7520617265206e6f742061207465616368657200000000000000000000006020830152604082019050919050565b6000600382527f61676500000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000600582527f636c6173730000000000000000000000000000000000000000000000000000006020830152604082019050919050565b61182381611b82565b82525050565b600060208201905061183e600083018461155f565b92915050565b6000608082019050818103600083015261185e818761156e565b9050818103602083015261187281866115dc565b9050818103604083015261188681856115dc565b9050818103606083015261189a81846115dc565b905095945050505050565b60006020820190506118ba6000830184611655565b92915050565b600060408201905081810360008301526118da8185611664565b90506118e96020830184611637565b9392505050565b6000604082019050818103600083015261190a8185611664565b90506119196020830184611646565b9392505050565b60006020820190508181036000830152611939816116d0565b9050919050565b60006040820190508181036000830152611959816116d0565b90506119686020830184611655565b92915050565b6000602082019050818103600083015261198781611707565b9050919050565b600060208201905081810360008301526119a78161173e565b9050919050565b600060408201905081810360008301526119c78161173e565b905081810360208301526119db8184611664565b905092915050565b600060208201905081810360008301526119fc81611775565b9050919050565b60006020820190508181036000830152611a1c816117ac565b9050919050565b60006040820190508181036000830152611a3c816117ac565b9050611a4b6020830184611655565b92915050565b60006020820190508181036000830152611a6a816117e3565b9050919050565b60006040820190508181036000830152611a8a816117e3565b9050611a996020830184611655565b92915050565b6000604051905081810181811067ffffffffffffffff82111715611ac257600080fd5b8060405250919050565b600067ffffffffffffffff821115611ae357600080fd5b601f19601f8301", "169050602081019050919050565b6000602082019050919050565b6000602082019050919050565b600081519050919050565b600081519050919050565b600081519050919050565b600081519050919050565b6000602082019050919050565b6000602082019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b6000819050919050565b6000611b9782611b58565b9050919050565b6000611ba982611b58565b9050919050565b6000611bbb82611b58565b9050919050565b6000611bcd82611b58565b9050919050565b6000819050919050565b6000819050919050565b6000611bf382611b58565b9050919050565b6000611c0582611b58565b9050919050565b82818337600083830152505050565b60005b83811015611c39578082015181840152602081019050611c1e565b83811115611c48576000848401525b50505050565b6000601f19601f83011690509190505600a265627a7a7230582005ffd108cfbbf12945bae1ad7926a3e150b5e311bdb9a79eac9d0cdbb2da87916c6578706572696d656e74616cf50037"};

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
    protected School_crud(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected School_crud(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected School_crud(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected School_crud(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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
    public static School_crud load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new School_crud(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static School_crud load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new School_crud(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static School_crud load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new School_crud(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static School_crud load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new School_crud(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<School_crud> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<String> t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(t.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                org.fisco.bcos.web3j.abi.Utils.typeMap(t, org.fisco.bcos.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(School_crud.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<School_crud> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<String> t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(t.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                org.fisco.bcos.web3j.abi.Utils.typeMap(t, org.fisco.bcos.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(School_crud.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<School_crud> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(t.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                org.fisco.bcos.web3j.abi.Utils.typeMap(t, org.fisco.bcos.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(School_crud.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<School_crud> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(t.isEmpty() ? org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]") : new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                org.fisco.bcos.web3j.abi.Utils.typeMap(t, org.fisco.bcos.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(School_crud.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class SetStudentEventResponse {
        public Log log;

        public String add;
    }
}
