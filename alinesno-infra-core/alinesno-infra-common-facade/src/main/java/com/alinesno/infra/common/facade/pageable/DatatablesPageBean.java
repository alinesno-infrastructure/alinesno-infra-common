package com.alinesno.infra.common.facade.pageable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alinesno.infra.common.facade.wrapper.RpcWrapper;

/**
 * 分页数据
 * 
 * @author WeiXiaoJin
 * @since 2018年8月16日 上午8:59:44
 */
@SuppressWarnings("serial")
public class DatatablesPageBean implements Serializable {

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// -------------------------- 兼容新版本bootstrap table_start --------------
	private int pageSize; // 每页显示
	private int pageNum; // 开始条数
	private int total; // 总条数
	private int code = 200; // HttpStatus.OK.value() ; // 状态码
	private Object rows; // 返回的数据

	@SuppressWarnings("unused")
	private boolean isBootstrapTable = true; // 判断是否为bootstrap
	// -------------------------- 兼容新版本bootstrap table_end --------------

	private int start; // 开始条数
	private int length; // 每页显示
	private int recordsFiltered;
	private Object data;
	private int draw;
	private int recordsTotal;
	private Map<String, Object> condition = new ConcurrentHashMap<String, Object>();
	private List<ConditionDto> conditionList = new ArrayList<ConditionDto>();

	public boolean isBootstrapTable() {
		if (this.pageSize != 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<ConditionDto> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<ConditionDto> conditionList) {
		this.conditionList = conditionList;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

//	/**
//	 * 从request中获得参数Map，并返回可读的Map
//	 * 
//	 * @param request
//	 * @return
//	 */
//	@SuppressWarnings({ "rawtypes"})
//	public <T> Specification buildFilter(T t, HttpServletRequest request) {
//		return restWrapper.toSpecification() ; 
//	}

	public <T> RpcWrapper<T> buildWrapper(DatatablesPageBean page, RpcWrapper<T> wrapper) {
		// ----------------------- 兼容bootstrap table_start ---------------
		if (page.isBootstrapTable()) {
			page.setStart(page.getPageNum() - 1);
			page.setLength(page.getPageSize());
		}
		// ----------------------- 兼容bootstrap table_end ---------------

		RpcWrapper<T> restWrapper = wrapper == null ? RpcWrapper.build() : wrapper; // new RestWrapper() ;
		restWrapper.setPageNumber(page.getStart());
		restWrapper.setPageSize(page.getLength());

		// 处理前端传输过来的json对象
		handleBuildConditionList();

		restWrapper.builderCondition(page.getCondition());
		if (!restWrapper.isHasOrder()) {
			restWrapper.orderBy("add_time", false);
		}

		return restWrapper;
	}

	/**
	 * 将conditionDto 对象转成 conditionStr，与旧的工程代码进行适配处理
	 */
	private void handleBuildConditionList() {

		if (this.getConditionList() != null && this.getConditionList().size() > 0) {
			for (ConditionDto dto : this.getConditionList()) {

				String column = dto.getColumn();
				String type = dto.getType();
				String value = dto.getValue();

				// 拼装起来，形成旧平台搜索适配
				// TODO 待适配多个参数情况
				// applicationName|like
				String conditionStr = column + "|" + type;

				if (StringUtils.hasLength(value)) {
					condition.put(conditionStr, value);
				}
			}
		}

	}

	/**
	 * 返回创建条件
	 * 
	 * @return
	 */
	public <T> RpcWrapper<T> buildWrapper() {
		RpcWrapper<T> wrapper = RpcWrapper.build(); // .builderCondition(this.getCondition()) ;
		return buildWrapper(this, wrapper);
	}

}
