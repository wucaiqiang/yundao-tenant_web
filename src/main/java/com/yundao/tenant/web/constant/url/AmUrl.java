package com.yundao.tenant.web.constant.url;

import com.yundao.core.utils.ConfigUtils;
import com.yundao.tenant.web.enums.url.UrlEnum;

/**
 * Created by gjl on 2017/11/17.
 */
public interface AmUrl {
    /**
     * HOST地址
     */
    String BASE_URL = ConfigUtils.getValue(UrlEnum.AM_URL.getKey());

    /**##########################gjl start###############*/
    /**
     * 分页查询项目文件
     */
    String PROJECT_FILE_GETS = BASE_URL + "/assets/project/file/get_page";
    /**
     * 新增项目文件
     */
    String PROJECT_FILE_ADD = BASE_URL + "/assets/project/file/add";
    /**
     * 删除项目文件
     */
    String PROJECT_FILE_DELETE = BASE_URL + "/assets/project/file/delete";
    /**
     * 查询公司项目
     */
    String PROJECT_COMPANY_GET = BASE_URL + "/assets/project/company/get";
    /**
     * 查询公司项目
     */
    String PROJECT_COMPANY_GET_ID = BASE_URL + "/assets/project/company/get_id";
    /**
     * 查询公司项目
     */
    String PROJECT_COMPANY_UPDATE_ONLY = BASE_URL + "/assets/project/company/update_only";
    /**
     * 项目单项编辑
     */
    String PROJECT_UPDATE_ONLY = BASE_URL + "/assets/project/update_only";
    /**
     * 查询公司项目
     */
    String PROJECT_CREW_UPDATE = BASE_URL + "/assets/project/crew/update";
    /**
     * 分页查询项目融资信息
     */
    String PROJECT_FINANCING_ROUND_GETS = BASE_URL + "/assets/project/financing/round/get_page";
    /**
     * 新增项目融资信息
     */
    String PROJECT_FINANCING_ROUND_ADD = BASE_URL + "/assets/project/financing/round/add";
    /**
     * 新增项目融资信息
     */
    String PROJECT_FINANCING_ROUND_UPDATE = BASE_URL + "/assets/project/financing/round/update";
    /**
     * 删除项目融资信息
     */
    String PROJECT_FINANCING_ROUND_DELETE = BASE_URL + "/assets/project/financing/round/delete";
    /**
     * 新增投资方
     */
    String PROJECT_FINANCING_ADD = BASE_URL + "/assets/project/financing/add";
    /**
     * 编辑投资方
     */
    String PROJECT_FINANCING_UPDATE = BASE_URL + "/assets/project/financing/update";
    /**
     * 删除投资方
     */
    String PROJECT_FINANCING_DELETE = BASE_URL + "/assets/project/financing/delete";
    /**
     * 获取项目历史投资信息
     */
    String DECISION_GET_PAGE_OVER = BASE_URL + "/assets/project/decision/get_page_over";
    /**
     * 获取需要导入成立的项目管理
     */
    String FOUND_GET_LIST = BASE_URL + "/assets/project/found/get_list";
    /**
     * 关闭项目导入
     */
    String FOUND_CLEAR = BASE_URL + "/assets/project/found/clear";
    /**
     * 项目导入
     */
    String FOUND_IMPORT = BASE_URL + "/assets/project/found/import";
    /**
     * 分页查询投资管理
     */
    String INVESTMENT_GET_PAGE_PERSONAL = BASE_URL + "/assets/investment/get_page_personal";
    /**
     * 分页查询投资管理
     */
    String INVESTMENT_GET_PAGE_DEPARTMENT = BASE_URL + "/assets/investment/get_page_department";
    /**
     * 分页查询投资管理
     */
    String INVESTMENT_GET_PAGE_PUBLIC = BASE_URL + "/assets/investment/get_page";
    /**
     * 基金中分页查询投资管理
     */
    String INVESTMENT_GET_FUND_PAGE = BASE_URL + "/assets/investment/get_fund_page";
    /**
     * 新增投资管理
     */
    String INVESTMENT_ADD = BASE_URL + "/assets/investment/add";
    /**
     * 修改投资管理
     */
    String INVESTMENT_UPDATE = BASE_URL + "/assets/investment/update";
    /**
     * 删除投资管理
     */
    String INVESTMENT_DELETE = BASE_URL + "/assets/investment/delete";

    /**
     * 分页查询投资管理 - 个人
     */
    String WITHDRAWAL_GET_PAGE_PERSONAL = BASE_URL + "/assets/withdrawal/get_page_personal";

    /**
     * 分页查询投资管理 - 部门
     */
    String WITHDRAWAL_GET_PAGE_DEPARTMENT = BASE_URL + "/assets/withdrawal/get_page_department";

    /**
     * 分页查询投资管理 - 所有
     */
    String WITHDRAWAL_GET_PAGE_PUBLIC = BASE_URL + "/assets/withdrawal/get_page_public";


    /**
     * 基金中分页查询投资管理
     */
    String WITHDRAWAL_GET_FUND_PAGE = BASE_URL + "/assets/withdrawal/get_fund_page";
    /**
     * 新增投资管理
     */
    String WITHDRAWAL_ADD = BASE_URL + "/assets/withdrawal/add";
    /**
     * 修改投资管理
     */
    String WITHDRAWAL_UPDATE = BASE_URL + "/assets/withdrawal/update";
    /**
     * 删除投资管理
     */
    String WITHDRAWAL_DELETE = BASE_URL + "/assets/withdrawal/delete";
    /**
     * 获取已投资的项目
     */
    String GET_PROJECT_INVESTMENT_SELECT = BASE_URL + "/assets/project/get_select_investment";
    /**
     * 获取已投资的项目
     */
    String GET_FUND_PROJECT = BASE_URL + "/assets/fund/get_raise_project";

    /**##########################gjl end###############*/

    /**
     * 添加项目
     */
    String ADD_PROJECT = BASE_URL + "/assets/project/add";

    /**
     * 获取项目详情
     */
    String GET_PROJECT = BASE_URL + "/assets/project/get";

    /**
     * 关注项目
     */
    String FOCUS_PROJECT = BASE_URL + "/assets/project/focus/do";

    /**
     * 取消关注项目
     */
    String UNFOCUS_PROJECT = BASE_URL + "/assets/project/focus/undo";

    /**
     * 获取项目分页列表 - 个人
     */
    String GET_PROJECT_PAGE_PERSONAL = BASE_URL + "/assets/project/get_page_personal";

    /**
     * 获取项目分页列表 - 部门
     */
    String GET_PROJECT_PAGE_DEPARTMENT = BASE_URL + "/assets/project/get_page_department";

    /**
     * 根据项目id获取项目负责人和组员信息
     */
    String GET_PROJECT_OWNER_BY_ID = BASE_URL + "/assets/project/get_owner_by_id";

    /**
     * 根据立项id获取项目负责人和组员信息
     */
    String GET_PROJECT_OWNER_BY_DECISION_ID = BASE_URL + "/assets/project/get_owner_by_decision_id";

    /**
     * 根据立项流程id获取项目负责人和组员信息
     */
    String GET_PROJECT_OWNER_BY_FLOW_ID = BASE_URL + "/assets/project/get_owner_by_flow_id";

    /**
     * 获取项目分页列表 - 所有
     */
    String GET_PROJECT_PAGE_PUBLIC = BASE_URL + "/assets/project/get_page_public";


    /**
     * 获取所有范围
     */
    String GET_PROJECT_SCOPE = BASE_URL + "/assets/project/get_search_scope";

    /**
     * 获取项目的负责人及组员
     */
    String GET_PROJECT_OWNER_IDS = BASE_URL + "/assets/project/get_owner_ids";

    /**
     * 删除项目
     */
    String DELETE_PROJECT = BASE_URL + "/assets/project/delete";

    /**
     * 添加立项
     */
    String ADD_DECISION = BASE_URL + "/assets/project/decision/add";

    /**
     * 获取
     */
    String GET_DECISION = BASE_URL + "/assets/project/decision/get";

    /**
     * 检查项目下是否存在未结束的立项
     */
    String EXIST_NOT_OVER_DECISION = BASE_URL + "/assets/project/decision/exist_not_over";


    /**
     * 发起人 提交操作
     */
    String SUBMIT_DECISION = BASE_URL + "/assets/project/decision/submit";

    /**
     * 立项审批
     */
    String DECISION_AUDIT_DECISIONING = BASE_URL + "/assets/project/decision/audit_decisioning";

    /**
     * 尽职调查审批
     */
    String DECISION_AUDIT_DUE_DILIGENCE = BASE_URL + "/assets/project/decision/audit_due_diligence";

    /**
     * 初审审批
     */
    String DECISION_AUDIT_FIRST_TRIAL = BASE_URL + "/assets/project/decision/audit_first_trial";

    /**
     * 投委会审批
     */
    String DECISION_AUDIT_INVESTMENT_COMMISSION = BASE_URL + "/assets/project/decision/audit_investment_commission";

    /**
     * 出资审批
     */
    String DECISION_AUDIT_INVEST = BASE_URL + "/assets/project/decision/audit_invest";

    /**
     * 编辑立项最终决定
     */
    String UPDATE_DECISION_INVEST = BASE_URL + "/assets/project/decision/invest/update";

    String GETS_PROJECT_INDUSTRY = BASE_URL + "/assets/project/industry/gets";
    String ADD_PROJECT_INDUSTRY = BASE_URL + "/assets/project/industry/add";
    String UPDATE_PROJECT_INDUSTRY = BASE_URL + "/assets/project/industry/update";
    String DELETE_PROJECT_INDUSTRY = BASE_URL + "/assets/project/industry/delete";

    /**
     * 获取意见列表
     */
    String GETS_DECISION_SUGGESTION = BASE_URL + "/assets/project/decision/suggestion/gets";

    /**
     * 添加意见
     */
    String ADD_DECISION_SUGGESTION = BASE_URL + "/assets/project/decision/suggestion/add";

    /**
     * 编辑意见
     */
    String UPDATE_DECISION_SUGGESTION = BASE_URL + "/assets/project/decision/suggestion/update";

    /**
     * 删除意见
     */
    String DELETE_DECISION_SUGGESTION = BASE_URL + "/assets/project/decision/suggestion/delete";

    /**
     * 添加流程文件
     */
    String ADD_DECISION_FLOW_FILE = BASE_URL + "/assets/project/decision/flow/add_file";

    /**
     * 删除流程文件
     */
    String DELETE_DECISION_FLOW_FILE = BASE_URL + "/assets/project/decision/flow/delete_file";

    /**
     * 获取文件权限
     */
    String GET_FLOW_FILE_OWNER = BASE_URL + "/assets/project/decision/flow/get_file_owner";

    /**
     * 编辑流程备注
     */
    String UPDATE_DECISION_FLOW_REMARK = BASE_URL + "/assets/project/decision/flow/update_remark";

    /**
     * 获取项目记录分页数据
     */
    String GET_PROJECT_RECORD_PAGE = BASE_URL + "/assets/project/record/get_page";

    /**
     * 文件下载上报
     */
    String REPORT_PROJECT_RECORD_FOR_DOWNLOAD = BASE_URL + "/assets/project/record/download";


    String GET_INDEX_AUDIT_PAGE = BASE_URL + "/assets/index/audit/todo";

    String GET_INDEX_REPORT_PROJECT = BASE_URL + "/assets/index/report/project_count";

    String GET_INDEX_REPORT_INVEST_LAYOUT = BASE_URL + "/assets/index/report/invest_layout";

    String GET_INDEX_AUDIT_HISTORY_GET_PAGE = BASE_URL + "/assets/index/audit_history/get_page";
    String GET_INDEX_AUDIT_HISTORY_GET_PROJECT_DETAIL = BASE_URL + "/assets/index/audit_history/get_project_detail";
    String GET_INDEX_AUDIT_HISTORY_GET_DECISION_DETAIL = BASE_URL + "/assets/index/audit_history/get_decision_detail";

    /**
     * 获取基金分页数据
     */
    String GET_FUND_PAGE_PERSONAL = BASE_URL + "/assets/fund/get_page_personal";
    String GET_FUND_PAGE_DEPARTMENT = BASE_URL + "/assets/fund/get_page_department";
    String GET_FUND_PAGE_PUBLIC = BASE_URL + "/assets/fund/get_page_public";

    String UPDATE_FUND_INCOME = BASE_URL + "/assets/fund/income/update";

    String ADD_FUND_ATTACH = BASE_URL + "/assets/fund/attach/add";
    String DELETE_FUND_ATTACH = BASE_URL + "/assets/fund/attach/delete";
    String GETS_FUND_ATTACH = BASE_URL + "/assets/fund/attach/gets";
    String GET_ALL_FUND_ATTACH = BASE_URL + "/assets/fund/attach/get_all";


    String GET_FIELDS_FUND = BASE_URL + "/assets/fund/get_fields";
    String ADD_FUND = BASE_URL + "/assets/fund/add";
    String UPDATE_FUND_BASE_INFO = BASE_URL + "/assets/fund/base/update";
    String UPDATE_FUND_RAISE = BASE_URL + "/assets/fund/raise/update";
    
    String UPDATE_FUND_ISSUED_STATUS = BASE_URL + "/assets/fund/update/issued_status";
    
    String GET_DETAIL = BASE_URL + "/assets/fund/get_detail_by_id";


    String DELETE_FUND_TEAM = BASE_URL + "/assets/fund/team/delete";
    String GETS_FUND_TEAM = BASE_URL + "/assets/fund/team/get_page";
    String ADD_FUND_TEAM = BASE_URL + "/assets/fund/team/add";
    String UPDATE_FUND_TEAM = BASE_URL + "/assets/fund/team/update";

    String GET_FUND_BASE =BASE_URL +  "/assets/fund/get_base";

    /**
     * 获取基金下拉 - 个人的数据
     */
    String GET_FUND_SELECTION_PERSONAL = BASE_URL + "/assets/fund/get_selection_personal";

    /**
     * 获取基金下拉 - 部门的数据
     */
    String GET_FUND_SELECTION_DEPARTMENT = BASE_URL + "/assets/fund/get_selection_department";

    /**
     * 获取基金下拉 - 所有的数据
     */
    String GET_FUND_SELECTION_PUBLIC = BASE_URL + "/assets/fund/get_selection_public";

    /**
     * 导入到产品
     */
    String IMPORT_FUND_TO_PRODUCT = BASE_URL + "/assets/fund/import_product";

    /**
     * 关注基金
     */
    String FOCUS_FUND = BASE_URL + "/assets/fund/focus/do";

    /**
     * 取消关注基金
     */
    String UNFOCUS_FUND = BASE_URL + "/assets/fund/focus/undo";

    /**
     * 删除基金
     */
    String DELETE_FUND = BASE_URL + "/assets/fund/delete";

    /**
     * 获取基金负责人
     */
    String GET_FUND_OWNER_IDS = BASE_URL + "/assets/fund/get_owner_ids";

    /**
     * 获取投资管理分页数据
     */
    String GET_INVESTMENT_PAGE = BASE_URL + "/assets/investment/get_page";

}
