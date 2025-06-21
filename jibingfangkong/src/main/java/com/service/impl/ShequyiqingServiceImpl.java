package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.ShequyiqingDao;
import com.entity.ShequyiqingEntity;
import com.service.ShequyiqingService;
import com.entity.view.ShequyiqingView;

/**
 * 社区疫情情况 服务实现类
 */
@Service("shequyiqingService")
@Transactional
public class ShequyiqingServiceImpl extends ServiceImpl<ShequyiqingDao, ShequyiqingEntity> implements ShequyiqingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShequyiqingView> page =new Query<ShequyiqingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
