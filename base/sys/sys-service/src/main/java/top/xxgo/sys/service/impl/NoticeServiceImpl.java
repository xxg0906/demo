package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.Notice;
import top.xxgo.sys.mapper.NoticeMapper;
import top.xxgo.sys.service.INoticeService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class NoticeServiceImpl extends PagedBaseServiceImpl<NoticeMapper, Notice> implements INoticeService {

}
