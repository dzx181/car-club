package com.zxq.service;

import com.zxq.entity.Member;
import com.zxq.entity.Member;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
public interface MemberService {
    /**
     * 添加会员
     *
     * @param employ
     * @return
     */
    int insertMember(Member employ);

    /**
     * 删除会员
     *
     * @param memberIDs
     * @return
     */
    int deleteMember(List<Integer> memberIDs);

    /**
     * 修改会员
     *
     * @param employ
     * @return
     */
    int updateMember(Member employ);

    /**
     * 查询会员
     *
     * @param employ
     * @return
     */
    String selectMember(Integer page, Member employ, HttpServletRequest request);

    /**
     * 根据id查找会员
     * @return
     */
    Member selectMemberByID(Integer memberID);

    /**
     * 查询全部会员
     *
     * @return
     */
    List<Member> selectAllMember();
}
