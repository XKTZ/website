package xktz.website.global.token.dao;

import org.apache.ibatis.annotations.Mapper;
import xktz.website.global.token.Token;

@Mapper
public interface TokenMapper {
    Token selectByToken(String token);

    int deleteByToken(String token);

    int deleteExpired();

    int insert(Token record);

    int insertSelective(Token record);

    int updateByToken(Token record);

    int updateByTokenSelective(Token record);

    int updateByUser(Token record);

    int updateByUserSelective(Token record);
}