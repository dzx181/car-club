package com.zxq.dao;

import com.zxq.entity.Member;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Zeng XiaoQi
 * @since 2018-12-08
 */
public interface MemberDao {
    /**
     * 添加会员
     * @param member
     * @return
     */
    int insertMember(Member member);

    /**
     * 删除会员
     * @param memberIDs
     * @return
     */
    int deleteMember(List<Integer> memberIDs);

    /**
     * 修改会员
     * @param member
     * @return
     */
    int updateMember(Member member);

    /**
     * 查询会员
     * @param member
     * @return
     */
    List<Member> selectMember(Member member);



    /**
     * 查询全部会员
     *
     * @return
     */
    List<Member> selectAllMember();

    /**
     * 根据id查找会员
     * @return
     */
    Member selectMemberByID(Integer memberID);
}
