package cn.nj.springsecurity.Mappper;

import cn.nj.springsecurity.POJO.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * Package: cn.nj.springsecurity.Mappper
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/26
 */
@Mapper
public interface AddressMapper {

    /**
     * 保存
     */
    void save(Address address);

    /**
     * 查询
     * @param id
     * @return
     */
    Address get(Long id);
}
