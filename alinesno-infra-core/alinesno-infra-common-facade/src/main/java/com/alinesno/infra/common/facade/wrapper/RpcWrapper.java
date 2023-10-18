package com.alinesno.infra.common.facade.wrapper;

import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlInjectionUtils;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 用于rpc的条件封装，传输参数封装，便于后期自定义和兼容扩展，兼容dubbo和http的请示参数，同时方便前后端集成
 *
 * @author luoxiaodong
 * @since 2018年1月6日 上午5:44:30
 */
public class RpcWrapper<T> extends Wrapper {

	private static final Logger log = LoggerFactory.getLogger(RpcWrapper.class);

	private boolean isHasOrder = false;
	private boolean removeApplication = false;

	private List<Condition> condition = new ArrayList<Condition>();

	public RpcWrapper<T> eq(String column, Object params) {
		condition.add(new Condition(column, params));
		return this;
	}

	public boolean isHasOrder() {
		for (Condition d : condition) {
			if (ORDER_BY.equals(d.getCondition())) {
				isHasOrder = true;
				break;
			}
		}
		return isHasOrder;
	}

	public void setHasOrder(boolean isHasOrder) {
		this.isHasOrder = isHasOrder;
	}

	public List<Condition> getCondition() {
		return condition;
	}

	public RpcWrapper<T> setCondition(List<Condition> condition) {
		this.condition = condition;
		return this;
	}

	public RpcWrapper<T> where(String sqlWhere, Object... params) {

		return null;
	}

	public RpcWrapper<T> ne(String column, Object params) {
		condition.add(new Condition(NE, column, params));
		return this;
	}

	public RpcWrapper<T> allEq(Map<String, Object> params) {
		if (params != null) {
			for (String k : params.keySet()) {
				condition.add(new Condition(k, params.get(k)));
			}
		}
		return this;
	}

	public RpcWrapper<T> gt(String column, Object params) {
		condition.add(new Condition(GT, column, params));
		return this;
	}

	public RpcWrapper<T> ge(String column, Object params) {
		condition.add(new Condition(GE, column, params));
		return this;
	}

	public RpcWrapper<T> lt(String column, Object params) {
		condition.add(new Condition(LT, column, params));
		return this;
	}

	public RpcWrapper<T> le(String column, Object params) {
		condition.add(new Condition(LE, column, params));
		return this;
	}

	public RpcWrapper<T> and(String sqlAnd, Object... params) {

		return null;
	}

	public RpcWrapper<T> andNew() {

		return null;
	}

	public RpcWrapper<T> andNew(String sqlAnd, Object... params) {

		return null;
	}

	public RpcWrapper<T> and(String column, String params) {

		return null;
	}

	public RpcWrapper<T> or(String column, String params) {
		condition.add(new Condition(OR, column, params));
		return this;
	}

	public RpcWrapper<T> or(boolean condition, String sqlOr, Object... params) {

		return null;
	}

	public RpcWrapper<T> or(String sqlOr, Object... params) {

		return null;
	}

	public RpcWrapper<T> orNew() {

		return null;
	}

	public RpcWrapper<T> orNew(String sqlOr, Object... params) {

		return null;
	}

	public RpcWrapper<T> groupBy(String columns) {

		return null;
	}

	public RpcWrapper<T> having(String sqlHaving, Object... params) {

		return null;
	}

	public RpcWrapper<T> orderBy(String columns) {

		return null;
	}

	public RpcWrapper<T> orderBy(String columns, boolean isAsc) {
		condition.add(new Condition(Wrapper.ORDER_BY, columns, isAsc));
		this.setHasOrder(true);
		return this;
	}

	public RpcWrapper<T> like(String column, String value) {
		condition.add(new Condition(LIKE, column, value));
		return this;
	}

	public RpcWrapper<T> notLike(String column, String value) {
		condition.add(new Condition(NOT_LIKE, column, value));
		return this;
	}

	public RpcWrapper<T> like(String column, String value, String type) {
		condition.add(new Condition(LIKE, column, value));
		return this;
	}

	public RpcWrapper<T> notLike(String column, String value, String type) {
		condition.add(new Condition(NOT_LIKE, column, value));
		return this;
	}

	public RpcWrapper<T> isNotNull(String columns) {

		return null;
	}

	public RpcWrapper<T> isNull(String columns) {

		return null;
	}

	public RpcWrapper<T> exists(String value) {

		return null;
	}

	public RpcWrapper<T> notExists(String value) {

		return null;
	}

	public RpcWrapper<T> in(String column, String value) {
		condition.add(new Condition(Wrapper.IN, column, value));
		return this;
	}

	public RpcWrapper<T> notIn(String column, String value) {
		condition.add(new Condition(Wrapper.NOT_IN, column, value));
		return this;
	}

	public RpcWrapper<T> in(String column, Collection<?> value) {
		condition.add(new Condition(Wrapper.IN, column, value));
		return this;
	}

	public RpcWrapper<T> notIn(String column, Collection<?> value) {
		condition.add(new Condition(Wrapper.NOT_IN, column, Arrays.asList(value)));
		return this;
	}

	public RpcWrapper<T> in(String column, Object[] value) {
		condition.add(new Condition(Wrapper.IN, column, Arrays.asList(value)));
		return this;
	}

	public RpcWrapper<T> notIn(String column, Object... value) {
		condition.add(new Condition(Wrapper.NOT_IN, column, Arrays.asList(value)));
		return this;
	}

	public RpcWrapper<T> between(String column, Object val1, Object val2) {
//		condition.add(new Condition(Wrapper.BETWEEN, column, Arrays.asList(value)));
		return this;
	}

	public boolean isRemoveApplication() {
		return removeApplication;
	}

	public void setRemoveApplication(boolean removeApplication) {
		this.removeApplication = removeApplication;
	}

	public RpcWrapper<T> notBetween(String column, Object val1, Object val2) {

		return null;
	}
 
	/**
	 * 条件转换
	 *
	 * @param c 前端传递参数
	 */
	public void builderCondition(Map<String, Object> c) {
		if (c != null) {
			if (condition != null) {
                for (Map.Entry<String, Object> me : c.entrySet()) {
                    String[] keys = me.getKey().trim().split("\\|");
                    Object value = me.getValue();

                    if (StringUtils.isBlank(keys[0]) || value == null || StringUtils.isBlank("" + value)) {
                        continue;
                    }
					Condition condition = getCondition(me, keys);
					this.condition.add(condition);
                }
			}
		}
	}

	private static Condition getCondition(Map.Entry<String, Object> me, String[] keys) {
		Condition condition = new Condition();
		if (keys.length == 1) { // 条件
			condition.setCondition("eq");
			condition.setColumn(keys[0]);
			condition.setParams(String.valueOf(me.getValue()));
		} else if (keys.length >= 2) { // 条件
			condition.setCondition(keys[1]);
			condition.setColumn(keys[0]);
			condition.setParams(String.valueOf(me.getValue()));
		}
		return condition;
	}

	public static <T> RpcWrapper<T> build() {
		return new RpcWrapper<T>();
	}

	@Override
	public String toString() {
		return "RestWrapper [isHasOrder=" + isHasOrder + ", removeApplication=" + removeApplication + ", condition="
				+ condition + "]";
	}

	/**
	 * 转换成mybatis-plus对象
	 *
	 * @return
	 */
	public QueryWrapper<T> toQueryWrapper() {
		QueryWrapper<T> wrapper = WrapperGenerator.build();
		return this.toQueryWrapper(wrapper);
	}

	public QueryWrapper<T> toQueryWrapper(QueryWrapper<T> wrapper) {

		if (condition != null && !condition.isEmpty()) {
			for (Condition c : condition) {

				String conditionKey = c.getCondition();
				String column = c.getColumn();
				Object params = c.getParams();

				// 判断是否包含特殊的字符
				validateXssValue(column, params);

				// 在SQL语句中发现不符合下划线风格的列
				column = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, column);
				if (StringUtils.isNotBlank(params + "")) {
					switch (conditionKey) {
					case IN:
						List<Object> in = new ArrayList<Object>();
						if (params instanceof Collection<?> psList) {
							in.addAll(psList);
						} else {
							in.add(params);
						}
						wrapper.in(column, in);
						break;
					case EQ:
						wrapper.eq(column, params);
						break;
					case NE:
						wrapper.ne(column, params);
					case OR:
						wrapper.or().eq(column, params);
						break;
					case LIKE:
						wrapper.like(column, params);
						break;
					case NOT_LIKE:
						wrapper.notLike(column, params);
						break;
					case LIKE_LEFT:
						wrapper.likeLeft(column, params);
						break;
					case LIKE_RIGHT:
						wrapper.likeRight(column, params);
						break;
					case LE:
						wrapper.le(column, params);
						break;
					case LT:
						wrapper.lt(column, params);
						break;

					case LETIME:
						String lesql = String.format("UNIX_TIMESTAMP(%s) <= UNIX_TIMESTAMP('%s')", column, params);
						wrapper.apply(true, lesql);
						break;
					case LTTIME:
						String ltsql = String.format("UNIX_TIMESTAMP(%s) < UNIX_TIMESTAMP('%s')", column, params);
						wrapper.apply(true, ltsql);
						break;
					case GE:
						wrapper.ge(column, params);
						break;
					case GT:
						wrapper.gt(column, params);
						break;
					case GETIME:
						String gesql = String.format("UNIX_TIMESTAMP(%s) >= UNIX_TIMESTAMP('%s')", column, params);
						wrapper.apply(true, gesql);
						break;
					case GTTIME:
						String gtsql = String.format("UNIX_TIMESTAMP(%s) > UNIX_TIMESTAMP('%s')", column, params);
						wrapper.apply(true, gtsql);
						break;
					case ORDER_BY:
						wrapper.orderBy(true, Boolean.parseBoolean(params + ""), column);
						break;
					default:
						wrapper.eq(column, params);
						break;
					}
				}
			}
		}
		log.info("execute sql:\t{}", wrapper.getTargetSql());

		return wrapper;
	}

	/**
	 * 初步判断xss和不安全字符
	 * 
	 * @param column
	 * @param params
	 */
	private void validateXssValue(String column, Object params) {
		// 手动校验方式
		SqlInjectionUtils.check(column) ;
		SqlInjectionUtils.check(params.toString()) ;
	}

}
