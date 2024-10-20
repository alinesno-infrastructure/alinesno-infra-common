package com.alinesno.infra.common.web.adapter.base.consumer;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.base.dto.*;

import java.util.List;

/**
 * 平台认证服务
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IBaseAuthorityConsumer {

    ManagerResourceDto findMenusByProjectCode(String projectCode, long accountId);

    ManagerAccountDto getById(long userId);

//    /**
//     * 获取应用登陆主题信息
//     * @param springApplication Spring应用名称
//     * @return 登陆主题信息
//     */
//    EnterpriseThemeDto getLoginTheme(String springApplication);
//
//    /**
//     * 通过用户信息获取企业信息，比如标题，主题色等
//     * @param userId 用户ID
//     * @param springApplication Spring应用名称
//     * @return 企业信息
//     */
//    EnterpriseDto getEnterpriseByUserId(String userId, String springApplication);
//
//    /**
//     * 查询账户
//     * @param ids 账户ID列表
//     * @return 账户列表
//     */
//    List<ManagerAccountDto> findAccountEntityByIds(List<String> ids);
//
//    /**
//     * 查询租户
//     * @param ids 租户ID列表
//     * @return 租户列表
//     */
//    List<ManagerTenantDto> findTenantEntityByIds(List<String> ids);
//
//    /**
//     * 通过ids查询应用
//     * @param ids 应用ID列表
//     * @return 应用列表
//     */
//    List<ManagerApplicationDto> findApplicationEntityByIds(List<String> ids);
//
//    /**
//     * 通过用户实体查询用户信息
//     * @param springApplication Spring应用名称
//     * @return 用户实体
//     */
//    ManagerApplicationDto findEntityByApplicationCode(String springApplication);
//
//    /**
//     * 查询用户菜单
//     * @param resourceParent 资源父节点
//     * @param applicationId 应用ID
//     * @param userId 用户ID
//     * @return 菜单资源实体
//     */
//    ManagerResourceDto findMenusByApplicationAndAccount(String resourceParent, String applicationId, String userId);
//
//    /**
//     * 查询应用部门
//     * @param applicationId 应用ID
//     * @param parentDeptId 父部门ID
//     * @return 部门列表
//     */
//    List<DeptDto> findOrg(String applicationId, String parentDeptId);
//
//    /**
//     * 通过id查询用户
//     * @param id 用户ID
//     * @return 用户实体
//     */
//    ManagerAccountDto findById(String id);
//
//    /**
//     * 通过用户名查询用户
//     * @param loginName 用户名
//     * @return 用户实体
//     */
//    ManagerAccountDto findByLoginName(String loginName);
//
//    /**
//     * 部门代码查询
//     * @param ids 部门ID列表
//     * @return 部门列表
//     */
//    List<ManagerDepartmentDto> findDepartmentByIds(List<String> ids);
//
//    /**
//     * 更新用户信息
//     * @param user 用户DTO
//     * @return 更新结果
//     */
//    AjaxResult updateManagerAccount(ManagerAccountDto user);
//
//    /**
//     * 更新用户密码
//     * @param pwdDto 密码DTO
//     * @return 更新结果
//     */
//    AjaxResult updatePwd(UpdatePasswordDto pwdDto);
//
//    /**
//     * 更新用户头像
//     * @param avatorId 头像ID
//     * @param accountId 用户ID
//     * @return 更新结果
//     */
//    AjaxResult updateAvator(String avatorId, String accountId);
}
