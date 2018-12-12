package com.zxq.service;

import com.zxq.entity.Doc;
import com.zxq.entity.Doc;
import com.zxq.entity.vo.DocVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DocService {
    public int addDoc(DocVO docVO);
    public int deleteDoc(List<Integer> caption);
    public String selectDoc(Integer page, Doc doc, HttpServletRequest request);


}
