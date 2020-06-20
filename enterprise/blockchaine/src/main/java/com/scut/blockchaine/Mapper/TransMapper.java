package com.scut.blockchaine.Mapper;

import com.scut.blockchain.Pojo.Trans;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransMapper {
    public void createTrans(Trans trans) throws Exception;

    public List<Trans> getTransByName(String id) throws Exception;
}
