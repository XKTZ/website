package xktz.website.global.activation.dao;

import org.apache.ibatis.annotations.Mapper;
import xktz.website.global.activation.model.ActivationCode;


@Mapper
public interface ActivationCodeMapper {

    int insert(ActivationCode record);

    ActivationCode selectByKey(String activationKey);

    int deleteByKey(String activationKey);
}