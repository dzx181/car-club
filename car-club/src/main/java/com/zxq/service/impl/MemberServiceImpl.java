package com.zxq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.dao.MemberDao;
import com.zxq.entity.Member;

import com.zxq.service.MemberService;
import com.zxq.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertMember(Member member) {
        return memberDao.insertMember(member);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteMember(List<Integer> memberIDs) {
        return memberDao.deleteMember(memberIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMember(Member member) {
        return memberDao.updateMember(member);
    }

    @Override
    public String selectMember( Integer page,Member member, HttpServletRequest request) {
        //模糊查询保留值
        if (member != null) {
            request.setAttribute("blurMember", member);
        }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<Member> list = memberDao.selectMember(member);
        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("memberVOList", list);
        return "member/memberList";
    }


    @Override
    public Member selectMemberByID(Integer memberID) {
        return memberDao.selectMemberByID(memberID);
    }

    @Override
    public List<Member> selectAllMember() {
        return memberDao.selectAllMember();
    }
}
