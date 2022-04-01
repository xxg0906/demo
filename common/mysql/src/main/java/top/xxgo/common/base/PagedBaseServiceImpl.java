package top.xxgo.common.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author xxg
 * @date 2022/4/1 10:03
 */
public class PagedBaseServiceImpl<M extends PageMapper<T>, T>  extends ServiceImpl<M,T> implements PagedBaseService<T> {



}
