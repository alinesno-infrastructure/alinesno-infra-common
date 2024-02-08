package com.alinesno.infra.common.facade.enable;

import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseCRUDManagerImpl;
import com.gitee.sunchenbin.mybatis.actable.manager.handler.StartUpHandlerImpl;
import com.gitee.sunchenbin.mybatis.actable.manager.system.SysMysqlCreateTableManagerImpl;
import com.gitee.sunchenbin.mybatis.actable.manager.system.SysOracleCreateTableManagerImpl;
import com.gitee.sunchenbin.mybatis.actable.manager.util.ConfigurationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 引入自动类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
public class ActableConfigurationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        List<String> importBean = new ArrayList<>();

        // 引入dao层
        importBean.add(BaseCRUDManagerImpl.class.getName()) ;
        importBean.add(ConfigRegisterBean.class.getName()) ;

        // 引入manager
        importBean.add(BaseCRUDManagerImpl.class.getName()) ;
        importBean.add(StartUpHandlerImpl.class.getName()) ;
        importBean.add(SysMysqlCreateTableManagerImpl.class.getName()) ;
        importBean.add(SysOracleCreateTableManagerImpl.class.getName()) ;
        importBean.add(ConfigurationUtil.class.getName()) ;

        return importBean.toArray(new String[] {});
    }

}
