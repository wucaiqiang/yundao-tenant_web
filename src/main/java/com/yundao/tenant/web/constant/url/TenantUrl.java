package com.yundao.tenant.web.constant.url;

import com.yundao.core.utils.ConfigUtils;
import com.yundao.tenant.web.enums.url.UrlEnum;

/**
 * 租户后置系统url
 *
 * @author jan
 * @create 2017-06-30 PM4:11
 **/
public interface TenantUrl {

    /**
     * HOST地址
     */
    String BASE_URL = ConfigUtils.getValue(UrlEnum.TENANT_URL.getKey());

    /** data object **/

    /** dictionary **/

    /**
     * 获取数据字典列表
     */
    String GET_Dictionaries = BASE_URL + "/dictionary/gets";

    /** dictionary **/

    /** 产品审核 **/

    /**
     * 获取产品审核分页
     **/
    String GET_PRODUCT_EXAMINES = BASE_URL + "/product/examine/get_page";

    /**
     * 产品审核 审核操作
     */
    String AUDIT_PRODUCT_EXAMINE = BASE_URL + "/product/examine/audit";

    /**
     * 获取产品审核历史记录
     */
    String GET_PRODUCT_AUDIT_HISTORY = BASE_URL + "/product/examine/get_history_audit_detail";
    /** 产品审核 **/

    /**
     * 重新加载缓存数据
     */
    String REMOVE_DATA_OBJECT_CACHE = BASE_URL + "/data/object/permission/reload";

    /**
     * =======回款计划========
     **/

    /** =======回款记录======== **/

    /**
     * 新增业务对象分组
     */
    String FIELD_GROUP_ADD = BASE_URL + "/fieldgroup/add";
    /**
     * 删除业务对象分组
     */
    String FIELD_GROUP_DELETE = BASE_URL + "/fieldgroup/delete";
    /**
     * 新增业务对象分组
     */
    String FIELD_GROUP_UPDASTE = BASE_URL + "/fieldgroup/update";
    /**
     * 新增业务对象分组
     */
    String FIELD_GROUP_UPDASTE_INFO = BASE_URL + "/fieldgroup/update_info";
    /**
     * 编辑业务对象分组关联关系
     */
    String FIELD_GROUP_UPDASTE_REL = BASE_URL + "/fieldgroup/update_rel";
    /**
     * 新增业务对象分组
     */
    String FIELD_GROUP_GETS = BASE_URL + "/fieldgroup/get_page";
    /**
     * 新增业务对象分组
     */
    String FIELD_GROUP_GET = BASE_URL + "/fieldgroup/get";
    /**
     * 新增业务对象分组
     */
    String FIELDGROUPREL_GET = BASE_URL + "/fieldgrouprel/get_groupid";
    /**
     * 删除产品公告类型
     */
    String PRODUCT_NOTICE_TYPE_DELETE = BASE_URL + "/productnoticetype/delete";

    /**
     * 新增产品公告类型
     */
    String PRODUCT_NOTICE_TYPE_ADD = BASE_URL + "/productnoticetype/add";

    /**
     * 获取所有产品公告类型
     */
    String PRODUCT_NOTICE_TYPE_GET_ALL = BASE_URL + "/productnoticetype/get_all";

    /**
     * 新增产品公告
     */
    String PRODUCT_NOTICE_ADD = BASE_URL + "/productnotice/add";

    /**
     * 批量删除产品公告
     */
    String PRODUCT_NOTICE_DELETE = BASE_URL + "/productnotice/delete";

    /**
     * 通过产品公告id获取对应的产品公告
     */
    String PRODUCT_NOTICE_GET_IDS = BASE_URL + "/productnotice/get_ids";

    /**
     * 编辑产品公告
     */
    String PRODUCT_NOTICE_UPDATE = BASE_URL + "/productnotice/update";

    /**
     * 审核公告
     */
    String PRODUCT_NOTICE_FLOW = BASE_URL + "/productnotice/flow";

    /**
     * 产品公告列表
     */
    String PRODUCT_NOTICE_GETS = BASE_URL + "/productnotice/get_page";
    /**
     * 产品公告详情
     */
    String PRODUCT_NOTICE_GET = BASE_URL + "/productnotice/get";

    /**
     * 产品公告审核列表
     */
    String PRODUCT_NOTICE_EXAMINE_GETS = BASE_URL + "/productnoticeexamine/get_page";

    /**
     * 产品公告审批历史
     */
    String PRODUCT_NOTICE_AUDIT_HISTORY = BASE_URL + "/productnotice/get_history_audit_detail";

    /**
     * 标签获取排名靠前的。
     */
    String TAG_GET_TOP = BASE_URL + "/tag/get_top";

    /**
     * 获取客户标签
     */
    String TAG_GET_CUSTOMER = BASE_URL + "/tag/get_customer_tag";

    /**
     * 新增客户
     */
    String CUSTOMER_ADD = BASE_URL + "/customer/add";

    /**
     * 新增客户V2
     */
    String CUSTOMER_ADD_V2 = BASE_URL + "/customer/v2/add";

    String GET_CUSTOMER = BASE_URL + "/customer/get";

    /**
     * 更新客户状态
     */
    String UPDATE_CUSTOMER_STATUS = BASE_URL + "/customer/update_status";

    /**
     * 客户详情--> 销售信息--> 获取预约信息
     */
    String CUSTOMER_SALE_GETS_RESERVATION = BASE_URL + "/customer/sale/gets_reservation";

    /**
     * 客户详情--> 销售信息--> 获取报单信息
     */
    String CUSTOMER_SALE_GETS_DECLARATION = BASE_URL + "/customer/sale/gets_declaration";

    /**
     * 客户详情--> 销售信息--> 获取个数
     */
    String CUSTOMER_SALE_GET_COUNT = BASE_URL + "/customer/sale/get_count";

    /**
     * 获取客户报单个数
     */
    String GET_CUSTOMER_DECLARATION_COUNT = BASE_URL + "/declaration/get_customer_count";

    /**
     * 获取我的客户选项
     */
    String CUSTOMER_GET_MY_SELECTIONS = BASE_URL + "/customer/get_my_selections";

    /**
     * 新增客户跟进
     */
    String CUSTOMER_FOLLOW_ADD = BASE_URL + "/customer/follow/up/add";

    /**
     * 获取客户详情页面线索机会条数-个人
     */
    String GET_CUSTOMER_LEADS_CHANCE_COUNT_PERSONAL = BASE_URL + "/customer/detail/get_leads_chance_count_personal";

    /**
     * 获取客户详情页面线索机会条数-部门
     */
    String GET_CUSTOMER_LEADS_CHANCE_COUNT_DEPARTMENT = BASE_URL + "/customer/detail/get_leads_chance_count_department";

    /**
     * 获取客户详情页面线索机会条数-所有
     */
    String GET_CUSTOMER_LEADS_CHANCE_COUNT_PUBLIC = BASE_URL + "/customer/detail/get_leads_chance_count_public";

    /**
     * 获取客户的分析测评结果
     */
    String GET_CUSTOMER_RISK_EVALUATION = BASE_URL + "/question/get/customer/risk_evaluation_result";

    /**
     * 修改客户资产证明
     */
    String CUSTOMER_UPDATE_ASSETS = BASE_URL + "/customer/update_assets";

    /**
     * 修改客户证件
     */
    String CUSTOMER_UPDATE_CREDENTIALS = BASE_URL + "/customer/update_credentials";

    /**
     * 客户跟进列表 - 只获取自己的客户
     */
    String CUSTOMER_FOLLOW_GETS_PERSONAL = BASE_URL + "/customer/follow/up/get_page_personal";

    /**
     * 客户跟进列表 - 获取部门客户数据
     */
    String CUSTOMER_FOLLOW_GETS_DEPARTMENT = BASE_URL + "/customer/follow/up/get_page_department";

    /**
     * 客户跟进列表 - 获取所有客户数据
     */
    String CUSTOMER_FOLLOW_GETS_PUBLIC = BASE_URL + "/customer/follow/up/get_page_public";

    /**
     * 新增客户
     */
    String CUSTOMER_VALIDATE_MOBILE = BASE_URL + "/customer/validate_mobile";

    /**
     * 获取客户动态
     */
    String GET_CUSTOMER_FEED = BASE_URL + "/msg/feed/get_customer_page";

    /**
     * 获取未读数
     */
    String MESSAGE_UNREAD_COUNT = BASE_URL + "/msg/message/get_unread_count";

    /**
     * 已读
     */
    String MESSAGE_READ = BASE_URL + "/msg/message/read";
    /**
     * 已读
     */
    String MESSAGE_READ_ALL = BASE_URL + "/msg/message/readAll";
    /**
     * 已读
     */
    String MESSAGE_GET_MY = BASE_URL + "/msg/message/get_my_page";

    /**
     * 报单列表
     */
    String DECLARATION_GET_PAGE = BASE_URL + "/declaration/get_page";

    /**
     * 报单详情
     */
    String DECLARATION_GET = BASE_URL + "/declaration/get";

    /**
     * 报单新增
     */
    String DECLARATION_ADD = BASE_URL + "/declaration/add";
    /**
     * 申请报单
     */
    String DECLARATION_SUBMIT = BASE_URL + "/declaration/submit";
    /**
     * 申请报单
     */
    String DECLARATION_VALIDATE = BASE_URL + "/declaration/validate";

    /**
     * 补入报单
     */
    String DECLARATION_PATCH = BASE_URL + "/declaration/patch";

    /**
     * 提交报单
     */
    String SUBMIT_DECLARATION = BASE_URL + "/reservation/submit_declaration";

    /**
     * 重新提交
     */
    String DECLARATION_RESUBMIT = BASE_URL + "/declaration/resubmit";

    /**
     * 取消
     */
    String DECLARATION_CANCEL = BASE_URL + "/declaration/cancel";

    /**
     * 申请退款
     */
    String DECLARATION_APPLY_REFUND = BASE_URL + "/declaration/apply_refund";

    /**
     * 修改身份资料
     */
    String DECLARATION_UPDATE_CREDENTIALS = BASE_URL + "/declaration/update_credentials";
    /**
     * 修改银行卡
     */
    String DECLARATION_UPDATE_BANK = BASE_URL + "/declaration/update_bank";
    /**
     * 修改认购信息
     */
    String DECLARATION_SUBSCRIBE = BASE_URL + "/declaration/update_subscribe";

    /**
     * 修改合规文件
     */
    String DECLARATION_COMPLIANCE = BASE_URL + "/declaration/update_compliance";

    /**
     * 获取产品详情页面分页数据
     */
    String GET_DECLARATION_PAGE_FOR_PRO_DETAIL = BASE_URL + "/declaration/get_page_for_pro_detail";

    /**
     * 获取报单审核分页数据
     */
    String DECLARATION_AUDIT_GET_PAGE = BASE_URL + "/declaration/audit/get_page";

    /**
     * 审核
     */
    String DECLARATION_AUDIT_DO = BASE_URL + "/declaration/audit/do";

    /**
     * 作废报单
     */
    String DECLARATION_DISCARD = BASE_URL + "/declaration/discard";

    /**
     * 查询报单的审核记录
     */
    String GETS_DECLARATION_AUDIT_RECORD = BASE_URL + "/declaration/gets_audit_record";

    /**
     * 作废预约
     */
    String RESERVATION_DISCARD = BASE_URL + "/reservation/discard";

    /**
     * 获取预约的审核记录
     */
    String GETS_RESERVATION_AUDIT_RECORD = BASE_URL + "/reservation/gets_audit_record";

    /**
     * 发送找回密码短信
     */
    String SEND_RETRIEVE_CAPTCHA = BASE_URL + "/user/send_retrieve_captcha";

    /**
     * 找回密码
     */
    String RETRIEVE_PASSWORD = BASE_URL + "/user/retrieve_password";

    /**
     * 结佣列表
     */
    String KNOTCOMMISSION_GET_PAGE = BASE_URL + "/knot/commission/get_page";

    /**
     * 结佣列表
     */
    String KNOTCOMMISSION_GET_DECLARATION_PAGE = BASE_URL + "/knot/commission/get_declaration_page";

    /**
     * 新增结佣
     */
    String KNOTCOMMISSION_ADD = BASE_URL + "/knot/commission/add";
    /**
     * 通过报单ID获取结佣详情
     */
    String KNOTCOMMISSION_GET = BASE_URL + "/knot/commission/get";

    /**
     * 审核列表
     */
    String KNOTCOMMISSION_GETS_AUDIT = BASE_URL + "/knot/commission/gets_audit";

    /**
     * 审核
     */
    String KNOTCOMMISSION_AUDIT = BASE_URL + "/knot/commission/audit";

    /**
     * 文章栏目新增
     */
    String ARTICLE_COLUMN_ADD = BASE_URL + "/cms/article/column/add";
    /**
     * 文章栏目新增
     */
    String ARTICLE_COLUMN_UPDATE = BASE_URL + "/cms/article/column/update";
    /**
     * 文章栏目新增
     */
    String ARTICLE_COLUMN_DELETE = BASE_URL + "/cms/article/column/delete";
    /**
     * 文章栏目分页查询
     */
    String ARTICLE_COLUMN_PAGE = BASE_URL + "/cms/article/column/get_page";

    /**
     * 获取平台下栏目数据
     */
    String GET_ARTICLE_COLUMN_SELECT_OPTION = BASE_URL + "/cms/article/column/get_select_option";

    /**
     * 新增日志
     */
    String LOGIN_LOG_ADD = BASE_URL + "/login/log/add";


    // ###################################gjl end########################

    /**
     * 删除产品
     */
    String DELETE_PRODUCT = BASE_URL + "/product/delete";

    /**
     * 根据多个id获取数据
     */
    String PRODUCT_GET_BY_IDS = BASE_URL + "/product/get_by_ids";

    /**
     * 获取产品字段集合
     */
    String PRODUCT_GET_FIELD = BASE_URL + "/product/get_fields";

    /**
     * 添加产品
     */
    String PRODUCT_ADD = BASE_URL + "/product/add";

    /**
     * 获取产品管理列表的下拉选项值
     */
    String PRODUCT_GET_MANAGER_LIST_SELECT_VALUE = BASE_URL + "/product/get_manager_List_select_value";

    /**
     * 获取产品详情
     */
    String GET_PRODUCT_DETAIL_BY_ID = BASE_URL + "/product/get_detail_by_id";

    /**
     * 获取产品管理列表的下拉选项值
     */
    String PRODUCT_GET_MANAGER_LIST = BASE_URL + "/product/get_manager_List";

    /**
     * 修改产品基本信息
     */
    String UPDATE_PRODUCT_BASE = BASE_URL + "/product/base/update";

    /**
     * 通过产品名称，获取产的下拉列表
     */
    String PRODUCT_GET_SELECT_OPTION_LIST = BASE_URL + "/product/get_select_option_list";

    /**
     * 添加回款计划，产品下拉选项(默认显示20条)
     */
    String PRODUCT_GET_SELECT_OPTION_FOR_RECEIPT_PLAN = BASE_URL + "/product/get_select_option_for_receipt";

    /**
     * 添加报单，产品下拉选项(默认显示20条)
     */
    String PRODUCT_GET_SELECT_OPTION_FOR_DECLARATION = BASE_URL + "/product/get_select_option_for_declaration";

    /**
     * 通过产品名称，获取正在销售的下拉列表
     */
    String PRODUCT_GET_SELECT_OPTION_SELLING_LIST = BASE_URL + "/product/get_select_option_selling";

    /**
     * 通过产品类型id，获取产的下拉列表
     */
    String PRODUCT_GET_SELECT_OPTION_LIST_BY_TYPEID = BASE_URL + "/product/get_select_option_list_by_typeId";

    /**
     * 修改产品基本信息
     */
    String UPDATE_PRODUCT_SALE = BASE_URL + "/product/sale/update";

    String GET_PRODUCT_BASE_INFO = BASE_URL + "/product/get_base_by_id";

    /**
     * 获取所有产品要素
     */
    String OBJECT_FIELD_GETS = BASE_URL + "/object/field/gets";
    /**
     * 获取菜单
     */
    String GET_MENU = BASE_URL + "/resource/get_menu";

    /**
     * 添加产品附件
     */
    String ADD_PRODUCT_ATTACH = BASE_URL + "/product/attach/add";
    String UPDATE_PRODUCT_ATTACH = BASE_URL + "/product/attach/update";

    /**
     * 修改产品状态
     */
    String UPDATE_PRODUCT_STATUS = BASE_URL + "/product/update_status";

    /**
     * 关注产品
     */
    String PRODUCT_FOCUS = BASE_URL + "/product/focus";

    /**
     * 取消关注产品
     */
    String PRODUCT_CANCEL_FOCUS = BASE_URL + "/product/cancel_focus";

    /**
     * 分页查询产品中心列表
     */
    String GETS_PRODUCT_CENTER = BASE_URL + "/product/center/gets";

    /**
     * 删除产品附件
     */
    String DELETE_PRODUCT_ATTACH = BASE_URL + "/product/attach/delete";

    /**
     * 分页查询产品附件
     */
    String GETS_PRODUCT_ATTACH = BASE_URL + "/product/attach/gets";
    /**
     * 修改产品佣金
     */
    String UPDATE_PRODUCT_COMMISSION = BASE_URL + "/product/commission/update";
    /**
     * 修改产品收益
     */
    String UPDATE_PRODUCT_INCOME = BASE_URL + "/product/income/update";
    /**
     * 修改产品供应商报价
     */
    String UPDATE_PRODUCT_SUPPLIER_QUOTATION = BASE_URL + "/product/supplier_quotation/update";

    /**
     * 根据产品id，获取供应商报价信息
     */
    String GET_PRODUCT_SUPPLIER_QUOTATION_BY_PRODUCT_ID = BASE_URL + "/product/supplier_quotation/get_by_product_id";

    /** role **/

    /**
     * 添加角色
     */
    String ADD_ROLE = BASE_URL + "/role/add";

    /**
     * 修改角色
     */
    String UPDATE_ROLE = BASE_URL + "/role/update";

    /**
     * 获取角色信息
     */
    String GET_ROLE = BASE_URL + "/role/get";

    /**
     * 获取角色列表
     */
    String GET_ROLES = BASE_URL + "/role/gets";

    /**
     * 删除角色
     */
    String DELETE_ROLE = BASE_URL + "/role/delete";

    /** role **/

    /** resource **/

    /**
     * 获取当前用户的功能资源
     */
    String GET_CURRENT_USER_RESOURCES = BASE_URL + "/resource/get_current_user_auths";

    /**
     * 获取所有资源
     */
    String GET_REOUSRCES = BASE_URL + "/resource/gets";

    /**
     * 获取角色资源
     */
    String GET_RESOURCE_BY_ROLE_ID = BASE_URL + "/resource/get_by_role_id";

    /**
     * 修改角色资源
     */
    String UPDATE_RESOURCE_BY_ROLE_ID = BASE_URL + "/resource/update_by_role_id";

    /**
     * 鉴权
     */
    String RESOURCE_INTERCEPT_AUTHENTICATE = BASE_URL + "/resource/intercept/authenticate";

    /** resource **/

    /** department **/
    /**
     * 添加部门
     */
    String ADD_DEPARTMENT = BASE_URL + "/department/add";

    /**
     * 获取部门
     */
    String GET_DEPARTMENT = BASE_URL + "/department/get";

    /**
     * 获取部门列表
     */
    String GET_DEPARTMENTS = BASE_URL + "/department/gets";

    /**
     * 修改部门
     */
    String UPDATE_DEPARTMENT = BASE_URL + "/department/update";

    /**
     * 删除部门
     */
    String DELETE_DEPARTMENT = BASE_URL + "/department/delete";
    /** department **/

    /**
     * 添加用户
     */
    String ADD_USER = BASE_URL + "/user/add";

    /**
     * 获取当前用户部门的所有用户id集合
     */
    String GET_CURRENT_USER_DEPARTMENT_USERIDS = BASE_URL + "/user/get_current_user_department_user";

    /**
     * 检查用户工号是否存在
     */
    String CHECK_USER_JOB_NUMBER_EXIST = BASE_URL + "/user/check_job_number_exist";

    /**
     * 检查手机号码是否存在
     */
    String CHECK_USER_MOBILE_EXIST = BASE_URL + "/user/check_mobile_exist";

    /**
     * 检查用户名是否已经存在
     */
    String CHECK_USER_USERNAME_EXIST = BASE_URL + "/user/check_username_exist";

    /**
     * 用户离职
     */
    String USER_DIMISSION = BASE_URL + "/user/dimission";
    /**
     * 用户停用
     */
    String USER_CEASE = BASE_URL + "/user/cease";
    /**
     * 用户启用
     */
    String USER_ENABLED = BASE_URL + "/user/enabled";

    /**
     * 通过用户id查询用户详情
     */
    String GET_USER_BY_ID = BASE_URL + "/user/get_by_id";

    /**
     * 通过用户id查询用户详情
     */
    String GETS_USER_BY_ROLE = BASE_URL + "/user/get_by_role";

    /**
     * 获取用户离职列
     */
    String GETS_USER_DIMISSION = BASE_URL + "/user/get_dimission_users";
    /**
     * 获取用户停用列表
     */
    String GETS_USER_CEASE = BASE_URL + "/user/get_cease_users";

    /**
     * 获取非离职用户列表
     */
    String GETS_USER_NOT_DIMISSION = BASE_URL + "/user/get_not_dimission_users";
    /**
     * 获取非离职用户列表
     */
    String GETS_USER_ENABLED = BASE_URL + "/user/get_enabled_users";

    /**
     * 通过用户名称查找在职用户
     */
    String GETS_USER_BY_REALNAME = BASE_URL + "/user/get_users_by_realName";

    /**
     * 组织架构用户详情
     */
    String GETS_USER_FOR_ORG = BASE_URL + "/user/get_for_org";

    /**
     * 检查是否能够添加员工
     */
    String CHECK_CAN_ADD = BASE_URL + "/user/check_can_add";

    /**
     * 修改用户信息
     */
    String MODIFY_USER = BASE_URL + "/user/modify";

    /**
     * 用户登录
     */
    String LOGIN = BASE_URL + "/user/login";

    /**
     * 用户退出
     */
    String LOGOUT = BASE_URL + "/user/logout";
    String GET_KEY_PUBLIC = BASE_URL + "/user/get_key_public";

    /**
     * 修改用户密码
     */
    String UPDATE_USER_PASSWORD = BASE_URL + "/user/update_password";

    /**
     * 获取角色下的所有用户id
     */
    String GET_USER_ID_BY_ROLE = BASE_URL + "/user/get_id_by_role";

    /** product **/
    /**
     * 获取产品要素分页数据
     */
    String GET_ELEMENT_PAGE = BASE_URL + "/object/field/get_page";

    /**
     * 获取产品要素列表
     */
    String GET_ELEMENT_LIST = BASE_URL + "/object/field/get_list";

    /**
     * 获取产品要素
     */
    String GET_ELEMENT = BASE_URL + "/object/field/get";

    /**
     * 更新产品要素
     */
    String ADD_ELEMENT = BASE_URL + "/object/field/add";

    /**
     * 更新产品要素
     */
    String UPDATE_ELEMENT = BASE_URL + "/object/field/update";

    /**
     * 删除产品要素
     */
    String DELETE_ELEMENT = BASE_URL + "/object/field/delete";

    /** product **/

    /** data object **/

    /**
     * 获取所有数据对象权限
     */
    String GET_DATA_OBJECTS = BASE_URL + "/data/object/gets";

    /**
     * 更新角色数据权限
     */
    String UPDATE_DATA_OBJECT = BASE_URL + "/data/object/update";

    /**
     * 根据编码获取数据对象字段
     */
    String GET_DATA_OBJECT_FIELDS_BY_CODES = BASE_URL + "/data/object/field/get_by_codes";

    /**
     * 获取读取权限
     */
    String GET_DATA_OBJECT_PERMISSION_READ = BASE_URL + "/data/object/permission/get_read";

    /**
     * 获取编辑权限
     */
    String GET_DATA_OBJECT_PERMISSION_UPDATE = BASE_URL + "/data/object/permission/get_update";

    /**
     * 获取删除权限
     */
    String GET_DATA_OBJECT_PERMISSION_DELETE = BASE_URL + "/data/object/permission/get_delete";

    /**
     * 校验读取权限
     */
    String GHECK_DATA_OBJECT_PERMISSION_READ = BASE_URL + "/data/object/permission/check_read";

    /**
     * 校验编辑权限
     */
    String GHECK_DATA_OBJECT_PERMISSION_UPDATE = BASE_URL + "/data/object/permission/check_update";

    /**
     * 校验删除权限
     */
    String CHECK_DATA_OBJECT_PERMISSION_DELETE = BASE_URL + "/data/object/permission/check_delete";

    /**
     * 校验多条删除权限
     */
    String CHECK_DATA_OBJECT_PERMISSION_DELETE_LIST = BASE_URL + "/data/object/permission/check_delete_list";

    /**
     * 校验多条修改权限
     */
    String CHECK_DATA_OBJECT_PERMISSION_UPDATE_LIST = BASE_URL + "/data/object/permission/check_update_list";

    /**
     * 校验多条读取权限
     */
    String CHECK_DATA_OBJECT_PERMISSION_RED_LIST = BASE_URL + "/data/object/permission/check_read_list";

    /**
     * 校验多个数据对象权限
     */
    String CHECK_DATA_OBJECT_PERMISSION_MULTI_CODE = BASE_URL + "/data/object/permission/check_multi_code";

    /**
     * 校验单个数据对象权限
     */
    String CHECK_DATA_OBJECT_PERMISSION_ONLY_CODE = BASE_URL + "/data/object/permission/check_only_code";

    /** ======数据权限====== **/

    /** ======客户相关====== **/

    /**
     * 获取客户页面 所有分页数据
     */
    String GET_CUSTOMER_V2_PAGE_PUBLIC = BASE_URL + "/customer/v2/get_page_public";

    /**
     * 获取客户页面 部门数据
     */
    String GET_CUSTOMER_V2_PAGE_DEPARTMENT = BASE_URL + "/customer/v2/get_page_department";

    /**
     * 获取客户页面 私有数据
     */
    String GET_CUSTOMER_V2_PAGE_PERSONAL = BASE_URL + "/customer/v2/get_page_personal";

    /**
     * 取“我的客户”数据 - 只获取自己的客户数据
     */
    String GET_CUSTOMER_MY_PAGE = BASE_URL + "/customer/get_my_page";

    /**
     * 获取客户详情
     */
    String GET_CUSTOMER_DETAIL = BASE_URL + "/customer/get_detail";

    /**
     * 获取客户所属信息
     */
    String GET_USER_CUSTOMER = BASE_URL + "/customer/get_user_customer";

    /**
     * 修改联系信息
     */
    String UPDATE_CONTACT = BASE_URL + "/customer/update_contact";
    /**
     * 修改除了联系信息之外的其它信息
     */
    String UPDATE_INFO = BASE_URL + "/customer/update_info";

    /**
     * 获取客户的理财师id
     */
    String GET_USERID_BY_CUSTOMERID = BASE_URL + "/customer/get_userid_by_customerid";

    /**
     * 关注客户
     */
    String FOCUS_CUSTOMER = BASE_URL + "/user/customer/focus";

    /**
     * 关注客户V2
     */
    String FOCUS_CUSTOMER_V2 = BASE_URL + "/user/customer/v2/focus";

    /**
     * 取消关注
     */
    String UNFOCUS_CUSTOMER = BASE_URL + "/user/customer/unfocus";

    /**
     * 申请回退客户
     */
    String BACK_CUSTOMER_APPLY = BASE_URL + "/customer/back/apply";

    /**
     * 申请回退客户V2
     */
    String BACK_CUSTOMER_APPLY_V2 = BASE_URL + "/customer/v2/back/apply";

    /**
     * 分页查询回退审核列表
     */
    String BACK_CUSTOMER_GETS = BASE_URL + "/customer/back/gets";

    /**
     * 客户回退审核通过
     */
    String BACK_CUSTOMER_PASS = BASE_URL + "/customer/back/pass";

    /**
     * 客户回退审核驳回
     */
    String BACK_CUSTOMER_REJECT = BASE_URL + "/customer/back/reject";

    /**
     * 获取客户池分页数据数据 - 只获取自己的客户
     */
    String GET_CUSTOMER_POOL_PERSONAL = BASE_URL + "/customer/pool/get_page_personal";

    /**
     * 获取客户池分页数据数据 - 获取部门客户数据
     */
    String GET_CUSTOMER_POOL_DEPARTMENT = BASE_URL + "/customer/pool/get_page_department";

    /**
     * 获取客户池分页数据数据 - 获取所有客户数据
     */
    String GET_CUSTOMER_POOL_PUBLIC = BASE_URL + "/customer/pool/get_page_public";

    /**
     * 获取公海分页数据数据 - 只获取自己的客户
     */
    String GET_CUSTOMER_OPENSEA_PERSONAL = BASE_URL + "/customer/opensea/get_page_personal";

    /**
     * 获取公海分页数据数据 - 获取部门客户数据
     */
    String GET_CUSTOMER_OPENSEA_DEPARTMENT = BASE_URL + "/customer/opensea/get_page_department";

    /**
     * 获取公海分页数据数据 - 获取所有客户数据
     */
    String GET_CUSTOMER_OPENSEA_PUBLIC = BASE_URL + "/customer/opensea/get_page_public";

    /**
     * 领取公海客户
     */
    String RECEIVE_CUSTOMER_OPENSEA = BASE_URL + "/customer/opensea/receive_customer";

    /**
     * 分配客户给理财师
     */
    String CUSTOMER_DISTRIBUTION_ALLOT_TO_FP = BASE_URL + "/customer/distribution/allot_to_fp";

    /**
     * 分配客户给理财师 V2
     */
    String CUSTOMER_DISTRIBUTION_ALLOT_TO_FP_V2 = BASE_URL + "/customer/v2/distribution/allot_to_fp";

    /**
     * 分配客户给客服
     */
    String CUSTOMER_DISTRIBUTION_ALLOT_TO_CS = BASE_URL + "/customer/distribution/allot_to_cs";

    /**
     * 分配客户给客服 V2
     */
    String CUSTOMER_DISTRIBUTION_ALLOT_TO_CS_V2 = BASE_URL + "/customer/v2/distribution/allot_to_cs";

    /**
     * 回收客户
     */
    String CUSTOMER_DISTRIBUTION_RECYCLE = BASE_URL + "/customer/distribution/recycle";

    /**
     * 回收客户 V2
     */
    String CUSTOMER_DISTRIBUTION_RECYCLE_V2 = BASE_URL + "/customer/v2/distribution/recycle";

    /** ======客户相关====== **/

    /** ======客户回访====== **/

    /**
     * 获取客户详情页面的回访数据 - 只获取自己的数据
     */
    String GET_USER_VISIT_PAGE_FOR_CUSTOMER_DETAIL_PERSONAL = BASE_URL
            + "/user/visit/get_page_for_customer_detail_personal";

    /**
     * 获取客户详情页面的回访数据 - 获取部门的数据
     */
    String GET_USER_VISIT_PAGE_FOR_CUSTOMER_DETAIL_DEPARTMENT = BASE_URL
            + "/user/visit/get_page_for_customer_detail_department";

    /**
     * 获取客户详情页面的回访数据 - 获取所有数据
     */
    String GET_USER_VISIT_PAGE_FOR_CUSTOMER_DETAIL_PUBLIC = BASE_URL
            + "/user/visit/get_page_for_customer_detail_public";

    /**
     * 获取分页 - 我的
     */
    String GET_USER_VISIT_PAGE_FOR_PERSONAL = BASE_URL + "/user/visit/get_page_personal";

    /**
     * 获取分页 - 部门的
     */
    String GET_USER_VISIT_PAGE_FOR_DEPARTMENT = BASE_URL + "/user/visit/get_page_department";

    /**
     * 获取分页 - 所有
     */
    String GET_USER_VISIT_PAGE_FOR_PUBLIC = BASE_URL + "/user/visit/get_page_public";

    /**
     * 回访
     */
    String ADD_USER_VISIT = BASE_URL + "/user/visit/do";

    /**
     * 获取销售线索页面回访详情
     */
    String GET_USER_VISIT_FOR_LEADS = BASE_URL + "/user/visit/get_detail_for_leads";

    /** ======客户回访====== **/

    /** ======预约====== **/

    /**
     * 添加预约
     */
    String ADD_RESERVATION = BASE_URL + "/reservation/add";

    /**
     * 我的预约列表
     */
    String GETS_MY_RESERVATION = BASE_URL + "/reservation/gets/my";

    /**
     * 查询预约详情
     */
    String GET_RESERVATION = BASE_URL + "/reservation/get";

    /**
     * 重新提交预约
     */
    String AGAIN_COMMIT_RESERVATION = BASE_URL + "/reservation/again_commit";

    /**
     * 取消预约
     */
    String CANCEL_RESERVATION = BASE_URL + "/reservation/cancel";

    /**
     * 修改预约
     */
    String UPDATE_RESERVATION = BASE_URL + "/reservation/update";

    /**
     * 获取预约审批分页数据
     */
    String GET_RESERVATION_AUDIT_PAGE = BASE_URL + "/reservation/audit/get_page";

    /**
     * 预约审核操作
     */
    String RESERVATION_AUDIT_DO = BASE_URL + "/reservation/audit/do";

    /** ======预约====== **/

    /** =====客户导入====== **/

    /**
     * 获取已存在客户列表
     */
    String CUSTOMER_IMPORT_GET_EXIST = BASE_URL + "/customer/import/get_check_exist";

    /**
     * 从我的客户批量导入客户
     */
    String CUSTOMER_IMPORT_MULTI_IMPORT = BASE_URL + "/customer/import/multi";

    /**
     * 从公海批量导入客户
     */
    String CUSTOMER_IMPORT_MULTI_IMPORT_FROM_OPENSEA = BASE_URL + "/customer/import/multi_from_opensea";

    /**
     * 批量导入客户V2
     */
    String CUSTOMER_IMPORT_MULTI_IMPORT_V2 = BASE_URL + "/customer/v2/import/multi";

    /** =====客户导入====== **/

    /** =======销售线索======== **/

    /**
     * 获取销售线索分页数据-个人
     */
    String GET_LEADS_PAGE_PERSONAL = BASE_URL + "/leads/get_page_personal";

    /**
     * 获取销售线索分页数据-部门
     */
    String GET_LEADS_PAGE_DEPARTMENT = BASE_URL + "/leads/get_page_department";

    /**
     * 获取销售线索分页数据-所有
     */
    String GET_LEADS_PAGE_PUBLIC = BASE_URL + "/leads/get_page_public";

    /**
     * 获取客户详情页面分页数据-个人
     */
    String GET_LEADS_FOR_CUSTOMER_DETAIL_PERSONAL = BASE_URL + "/leads/customer/detail/get_page_personal";

    /**
     * 获取客户详情页面分页数据-部门
     */
    String GET_LEADS_FOR_CUSTOMER_DETAIL_DEPARTMENT = BASE_URL + "/leads/customer/detail/get_page_department";

    /**
     * 获取客户详情页面分页数据-所有
     */
    String GET_LEADS_FOR_CUSTOMER_DETAIL_PUBLIC = BASE_URL + "/leads/customer/detail/get_page_public";

    /**
     * 获取客户的未分配线索
     */
    String GET_LEADS_UN_ALLOT = BASE_URL + "/leads/get_unallot";

    /**
     * 分配线索
     */
    String ALLOT_LEADS = BASE_URL + "/leads/allot";

    /**
     * 分配给理财师
     */
    String ALLOT_LEADS_TO_FP = BASE_URL + "/leads/allot_to_fp";

    /**
     * 尝试分配线索
     */
    String ALLOT_TRY_LEADS = BASE_URL + "/leads/try_allot";

    /**
     * 处理销售线索
     */
    String PROCESS_LEADS = BASE_URL + "/leads/process";

    String VIDEO_GET_UPLOAD_SIGNATURE = BASE_URL + "/video/get_upload_signature";
    String VIDEO_GET_PAGE = BASE_URL + "/video/get_page";
    String VIDEO_GET = BASE_URL + "/video/get";
    String VIDEO_GET_BY_NAME = BASE_URL + "/video/gets_by_name";
    String VIDEO_CONVERT = BASE_URL + "/video/convert";
    String VIDEO_DELETE = BASE_URL + "/video/delete";
    String VIDEO_ADD = BASE_URL + "/video/add";
    String VIDEO_UPDATE = BASE_URL + "/video/update";
    String ROADSHOW_COLUMN_ADD = BASE_URL + "/roadshow/column/add";
    String ROADSHOW_COLUMN_UPDATE = BASE_URL + "/roadshow/column/update";
    String ROADSHOW_COLUMN_GET_PAGE = BASE_URL + "/roadshow/column/get_page";
    String ROADSHOW_COLUMN_GET = BASE_URL + "/roadshow/column/get";
    String ROADSHOW_COLUMN_GET_BY_PLATFORM_ID = BASE_URL + "/roadshow/column/get_by_platform_id";
    String ROADSHOW_COLUMN_DELETE = BASE_URL + "/roadshow/column/delete";

    String ROADSHOW_ADD = BASE_URL + "/roadshow/add";
    String ROADSHOW_UPDATE = BASE_URL + "/roadshow/update";
    String ROADSHOW_GET_PAGE = BASE_URL + "/roadshow/get_page";
    String ROADSHOW_GET = BASE_URL + "/roadshow/get";
    String ROADSHOW_DELETE = BASE_URL + "/roadshow/delete";

    /** =======销售线索======== **/

    /** =======C端客户预约======== **/

    /**
     * 预约产品
     */
    String CONSULT_PRODUCT = BASE_URL + "/consult/product";

    /** =======C端客户预约======== **/

    /** =======回款计划======== **/

    /**
     * 添加回款计划
     */
    String ADD_RECEIPT_PLAN = BASE_URL + "/receipt/plan/add";

    /**
     * 修改回款计划
     */
    String UPDATE_RECEIPT_PLAN = BASE_URL + "/receipt/plan/update";

    /**
     * 获取回款计划详情
     */
    String GET_RECEIPT_PLAN = BASE_URL + "/receipt/plan/get";

    /**
     * 删除回款计划
     */
    String DELETE_RECEIPT_PLAN = BASE_URL + "/receipt/plan/delete";

    /**
     * 获取产品供应商
     */
    String GET_RECEIPT_PLAN_SUPPLIER = BASE_URL + "/receipt/plan/detail/get_supplier";

    /**
     * 获取分页数据
     */
    String RECEIPT_PLAN_GET_PAGE = BASE_URL + "/receipt/plan/get_page";

    /**
     * 获取回款记录列表
     */
    String GET_RECEIPT_PLAN_DETAIL_RECEIPTS = BASE_URL + "/receipt/plan/detail/get_receipts";

    /**
     * 添加关联报单
     */
    String ADD_RECEIPT_PLAN_DECLARATION_REL = BASE_URL + "/receipt/plan/add_declaration_rel";

    /**
     * 移除关联报单
     */
    String DELETE_RECEIPT_PLAN_DECLARATION_REL = BASE_URL + "/receipt/plan/delete_declaration_rel";

    /**
     * 获取回款记录列表
     */
    String GET_RECEIPT_PLAN_DETAIL_DECLARATIONS = BASE_URL + "/receipt/plan/detail/get_declarations";

    /**
     * 检查回款计划名称是否存在
     */
    String RECEIPT_PLAN_CHECK_NAME_EXIST = BASE_URL + "/receipt/plan/check_name_exist";

    /**
     * 检查回款计划名称是否存在（更新操作使用）
     */
    String RECEIPT_PLAN_CHECK_NAME_EXIST_FOR_UPDATE = BASE_URL + "/receipt/plan/check_name_exist_for_update";

    /**
     * =======回款计划========
     **/

    /**
     * =======回款记录========
     **/

    String ADD_RECEIPT_RECORD = BASE_URL + "/receipt/record/add";

    String DELETE_RECEIPT_RECORD = BASE_URL + "/receipt/record/delete";

    /**
     * 获取可以回款的报单数据
     */
    String GET_RECEIPT_RECORD_CAN_RECEIPT_DECLARATIONS = BASE_URL + "/receipt/record/get_can_receipt_declarations";

    /** =======回款记录======== **/


    /** =======文章管理======== **/

    /**
     * 获取文章分页数据
     */
    String GET_ARTICLE_PAGE = BASE_URL + "/cms/article/get_page";

    /**
     * 删除文章
     */
    String DELETE_ARTICLE = BASE_URL + "/cms/article/delete";

    /**
     * 新增文章
     */
    String ADD_ARTICLE = BASE_URL + "/cms/article/add";
    /**
     * 新增文章
     */
    String UPDATE_ARTICLE = BASE_URL + "/cms/article/update";
    /**
     * 获取文章详情
     */
    String GET_ARTICLE = BASE_URL + "/cms/article/get";

    /**
     * 获取销售管理配置
     */
    String GET_SYS_CONF_SALE = BASE_URL + "/sys/conf/sale/get";

    /**
     * 更新销售管理配置
     */
    String UPDATE_SYS_CONF_SALE = BASE_URL + "/sys/conf/sale/update";

    /**
     * =======文章管理========
     **/

    String WORKFLOW_GET_AUDIT_RECORD = BASE_URL + "/workflow/get_audit_record";

    String REFUND_RESUBMIT = BASE_URL + "/refund/resubmit";

    String REFUND_CANCEL = BASE_URL + "/refund/cancel";

    String REFUND_GET_MY_PAGE = BASE_URL + "/refund/get_my_refund_page";

    String GET_LEADS = BASE_URL + "/leads/get";

    /**
     * 退款审核
     */
    String REFUND_AUDIT_DO = BASE_URL + "/refund/audit/do";

    String REFUND_AUDIT_LIST_PAGE = BASE_URL + "/refund/audit/get_audit_page";

    String SCM_PRODUCT_RECOMMEND_ADD = BASE_URL + "/cms/product/recommend/add";
    String SCM_PRODUCT_RECOMMEND_GET_PAGE = BASE_URL + "/cms/product/recommend/get_page";
    String SCM_PRODUCT_RECOMMEND_DELETE = BASE_URL + "/cms/product/recommend/delete";
    String SCM_PRODUCT_RECOMMEND_UPDATE = BASE_URL + "/cms/product/recommend/update";
    String SCM_PRODUCT_RECOMMEND_GET = BASE_URL + "/cms/product/recommend/get";

    String PLATFORM_GET_ALL = BASE_URL + "/plafrom/get_all";

    String PLATFORM_GET_POSTION_BY_PLATFORM = BASE_URL + "/plafrom/get_position_by_platform";
}
