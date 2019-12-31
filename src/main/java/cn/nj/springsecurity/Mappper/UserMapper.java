package cn.nj.springsecurity.Mappper;

import cn.nj.springsecurity.POJO.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * Package: cn.nj.springsecurity.Mappper
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/15
 */
@Mapper
public interface UserMapper {
    List<user> getall();
}
