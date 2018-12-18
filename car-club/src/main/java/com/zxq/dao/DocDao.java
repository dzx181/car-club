package com.zxq.dao;

import com.zxq.entity.Doc;
import com.zxq.entity.vo.DocVO;

import java.util.List;

public interface DocDao {
    /**
     * 上传文件
     * @param docVO
     * @return
     */
    int fileUpload(DocVO docVO);

    /**
     * 查找文件
     * @param doc
     * @return
     */
    List<Doc> selectFile(Doc doc);

    /**
     * 删除文件
     * @param caption
     * @return
     */
    int deleteFile(List<Integer> caption);
}
