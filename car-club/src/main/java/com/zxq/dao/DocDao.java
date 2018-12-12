package com.zxq.dao;

import com.zxq.entity.Doc;
import com.zxq.entity.vo.DocVO;

import java.util.List;

public interface DocDao {
    int fileUpload(DocVO docVO);

    List<Doc> selectFile(Doc doc);

    int deleteFile(List<Integer> caption);
}
