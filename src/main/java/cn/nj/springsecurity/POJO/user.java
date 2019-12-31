package cn.nj.springsecurity.POJO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 * Package: cn.nj.springsecurity.POJO
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/15
 */
@Data
public class user {

    @Id
    private int id;

    @Column(name = "a_name")
    private String aName;

    @Column(name="a_age")
    private  int aAge;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name="start_time")
    private Date startTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name="end_time")
    private Date endTime;

}
