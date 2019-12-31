package cn.nj.springsecurity.config.FiiterConfig;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * Package: cn.nj.springsecurity.config
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/18
 */
public class Myfilter  implements Filter {
    private final static Logger logger= LoggerFactory.getLogger(Myfilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("=============开始进入过滤器===========");
        Map<String, String[]> map = servletRequest.getParameterMap();
        logger.info("=========request中获取参数MAP："+map);
        TreeMap<String, Object> treeMap = new TreeMap<>();
        Iterator<Map.Entry<String, String[]>> aa = map.entrySet().iterator();
        while(aa.hasNext()){
            Map.Entry<String, String[]> next = aa.next();
            String key = next.getKey();
            String[] value = next.getValue();
            treeMap.put(key,value[0]);
        }
        logger.info("========整理之后的treemap："+treeMap);
        if(treeMap.size()<=0){
            setFailed(servletResponse,"认证请求失败了");
          return ;
        }
        logger.info("========过滤器通过=======");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }


    private void setFailed(ServletResponse response,String msg) throws IOException{
        OutputStreamWriter ops = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
        PrintWriter writer = new PrintWriter(ops, true);
        writer.write(msg);
        writer.flush();
        writer.close();
        ops.close();
    }
}
