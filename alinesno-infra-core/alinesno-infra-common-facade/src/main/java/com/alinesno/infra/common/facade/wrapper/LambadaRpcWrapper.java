package com.alinesno.infra.common.facade.wrapper;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.CaseFormat;

/**
 * 用于rpc的条件封装，传输参数封装，便于后期自定义和兼容扩展，兼容dubbo和http的请示参数，同时方便前后端集成
 * 支持强类型的条件字段设置，具有更高的安全性
 *
 * @author WeiXiaoJin
 * @since 2021年2月11日 凌晨01:11:00
 */
@SuppressWarnings("serial")
public class LambadaRpcWrapper<T> extends Wrapper {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(LambadaRpcWrapper.class);
	private boolean isHasOrder = false;
	private boolean removeApplication = false;

	private List<Condition> condition = new ArrayList<Condition>();

	public LambadaRpcWrapper<T> eq(SFunction<T, ?> function, Object params) {
		condition.add(new Condition(resolveColumn(function), params));
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

	public LambadaRpcWrapper<T> setCondition(List<Condition> condition) {
		this.condition = condition;
		return this;
	}

	public LambadaRpcWrapper<T> where(String sqlWhere, Object... params) {

		return null;
	}

	public LambadaRpcWrapper<T> ne(SFunction<T, ?> column, Object params) {
		condition.add(new Condition(NE, resolveColumn(column), params));
		return this;
	}

	public LambadaRpcWrapper<T> allEq(Map<SFunction<T, ?>, Object> params) {
		if (params != null) {
			for (SFunction<T, ?> k : params.keySet()) {
				condition.add(new Condition(resolveColumn(k), params.get(k)));
			}
		}
		return this;
	}

	public LambadaRpcWrapper<T> gt(SFunction<T, ?> column, Object params) {
		condition.add(new Condition(GT, resolveColumn(column), params));
		return this;
	}

	public LambadaRpcWrapper<T> ge(SFunction<T, ?> column, Object params) {
		condition.add(new Condition(GE, resolveColumn(column), params));
		return this;
	}

	public LambadaRpcWrapper<T> lt(SFunction<T, ?> column, Object params) {
		condition.add(new Condition(LT, resolveColumn(column), params));
		return this;
	}

	public LambadaRpcWrapper<T> le(SFunction<T, ?> column, Object params) {
		condition.add(new Condition(LE, resolveColumn(column), params));
		return this;
	}

	public LambadaRpcWrapper<T> and(String sqlAnd, Object... params) {

		return null;
	}

	public LambadaRpcWrapper<T> andNew() {

		return null;
	}

	public LambadaRpcWrapper<T> andNew(String sqlAnd, Object... params) {

		return null;
	}

	public LambadaRpcWrapper<T> and(SFunction<T, ?> column, String params) {

		return null;
	}

	public LambadaRpcWrapper<T> or(SFunction<T, ?> column, String params) {
		condition.add(new Condition(OR, resolveColumn(column), params));
		return this;
	}

	public LambadaRpcWrapper<T> or(boolean condition, String sqlOr, Object... params) {

		return null;
	}

	public LambadaRpcWrapper<T> or(String sqlOr, Object... params) {

		return null;
	}

	public LambadaRpcWrapper<T> orNew() {

		return null;
	}

	public LambadaRpcWrapper<T> orNew(String sqlOr, Object... params) {

		return null;
	}

	public LambadaRpcWrapper<T> groupBy(SFunction<T, ?> columns) {

		return null;
	}

	public LambadaRpcWrapper<T> having(String sqlHaving, Object... params) {

		return null;
	}

	public LambadaRpcWrapper<T> orderBy(SFunction<T, ?> columns) {

		return null;
	}

	public LambadaRpcWrapper<T> orderBy(SFunction<T, ?> columns, boolean isAsc) {
		condition.add(new Condition(Wrapper.ORDER_BY, resolveColumn(columns), isAsc));
		this.setHasOrder(true);
		return this;
	}

	public LambadaRpcWrapper<T> like(SFunction<T, ?> column, String value) {
		condition.add(new Condition(LIKE, resolveColumn(column), value));
		return this;
	}

	public LambadaRpcWrapper<T> notLike(SFunction<T, ?> column, String value) {
		condition.add(new Condition(NOT_LIKE, resolveColumn(column), value));
		return this;
	}

	public LambadaRpcWrapper<T> like(SFunction<T, ?> column, String value, String type) {
		condition.add(new Condition(LIKE, resolveColumn(column), value));
		return this;
	}

	public LambadaRpcWrapper<T> notLike(SFunction<T, ?> column, String value, String type) {
		condition.add(new Condition(NOT_LIKE, resolveColumn(column), value));
		return this;
	}

	public LambadaRpcWrapper<T> isNotNull(SFunction<T, ?> columns) {

		return null;
	}

	public LambadaRpcWrapper<T> isNull(SFunction<T, ?> columns) {

		return null;
	}

	public LambadaRpcWrapper<T> exists(String value) {

		return null;
	}

	public LambadaRpcWrapper<T> notExists(String value) {

		return null;
	}

	public LambadaRpcWrapper<T> in(SFunction<T, ?> column, String value) {
		condition.add(new Condition(Wrapper.IN, resolveColumn(column), value));
		return this;
	}

	public LambadaRpcWrapper<T> notIn(SFunction<T, ?> column, String value) {
		condition.add(new Condition(Wrapper.NOT_IN, resolveColumn(column), value));
		return this;
	}

	public LambadaRpcWrapper<T> in(SFunction<T, ?> column, Collection<?> value) {
		condition.add(new Condition(Wrapper.IN, resolveColumn(column), value));
		return this;
	}

	public LambadaRpcWrapper<T> notIn(SFunction<T, ?> column, Collection<?> value) {
		condition.add(new Condition(Wrapper.NOT_IN, resolveColumn(column), Arrays.asList(value)));
		return this;
	}

	public LambadaRpcWrapper<T> in(SFunction<T, ?> column, Object[] value) {
		condition.add(new Condition(Wrapper.IN, resolveColumn(column), Arrays.asList(value)));
		return this;
	}

	public LambadaRpcWrapper<T> notIn(SFunction<T, ?> column, Object... value) {
		condition.add(new Condition(Wrapper.NOT_IN, resolveColumn(column), Arrays.asList(value)));
		return this;
	}

	public LambadaRpcWrapper<T> between(SFunction<T, ?> column, Object val1, Object val2) {
//		condition.add(new Condition(Wrapper.BETWEEN, column, Arrays.asList(value)));
		return this;
	}

	public boolean isRemoveApplication() {
		return removeApplication;
	}

	public void setRemoveApplication(boolean removeApplication) {
		this.removeApplication = removeApplication;
	}

	public LambadaRpcWrapper<T> notBetween(SFunction<T, ?> column, Object val1, Object val2) {

		return null;
	}

//	public <T> Predicate toSelfPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//
//		List<Predicate> predicates = new ArrayList<Predicate>();
//
//		if (condition != null && condition.size() > 0) {
//			for (Condition c : condition) {
//
//				String conditionKey = c.getCondition();
//				String column = c.getColumn();
//				Object params = c.getParams();
//
//				switch (conditionKey) {
//				case IN : 
//					CriteriaBuilder.In<Object> in = criteriaBuilder.in(root.get(column)) ; 
//					if(params instanceof Collection) {
//						Collection<?> psList = (Collection<?>) params ;
//						Iterator<?> it = psList.iterator() ; 
//						while(it.hasNext()) {
//							in.value(it.next()) ;
//						}
//					}else {
//						in.value(params) ;
//					}
//					predicates.add(in); 
//					break;
//				case EQ : predicates.add(criteriaBuilder.equal(root.get(column), params)); break;
//				case NE : predicates.add(criteriaBuilder.notEqual(root.get(column), params)); break;
//				case LIKE : predicates.add(criteriaBuilder.like(root.get(column), "%" + params + "%")); break;
//				case NOT_LIKE : predicates.add(criteriaBuilder.notLike(root.get(column), "%" + params + "%")); break;
//				case LIKE_LEFT : predicates.add(criteriaBuilder.like(root.get(column), "%" + params)); break;
//				case LIKE_RIGHT : predicates.add(criteriaBuilder.like(root.get(column), params + "%")); break;
//				case LE : predicates.add(criteriaBuilder.le(root.get(column), Double.parseDouble(params + ""))); break;
//				case LT : predicates.add(criteriaBuilder.lt(root.get(column), Double.parseDouble(params + ""))); break;
//				case LETIME : predicates.add(criteriaBuilder.greaterThan(root.<Date>get(column), parseDate(params + ""))); break;
//				case LTTIME : predicates.add(criteriaBuilder.lessThan(root.<Date>get(column), parseDate(params + ""))); break;
//				case GE : predicates.add(criteriaBuilder.ge(root.get(column), Double.parseDouble(params + ""))); break;
//				case GT : predicates.add(criteriaBuilder.gt(root.get(column), Double.parseDouble(params + ""))); break;
//				case GETIME : predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<Date>get(column), parseDate(params + ""))); break;
//				case GTTIME : predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<Date>get(column), parseDate(params + ""))); break;
//				case ORDER_BY : query.orderBy(Boolean.parseBoolean(params + "") ? criteriaBuilder.asc(root.get(column)): criteriaBuilder.desc(root.get(column))); break;
//				default: predicates.add(criteriaBuilder.equal(root.<Object>get(column), params)); break;
//				}
//			}
//		}
//
//		return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
//	}

//	public <T> Specification<T> toSpecification() {
//
//		Specification<T> spec = new Specification<T>() {
//			@Override
//			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				return toSelfPredicate(root, query, criteriaBuilder);
//			}
//
//		};
//
//		return spec;
//	}

	/**
	 * 网页时间格式化
	 * 
	 * @param inputDate
	 * @return
	 */
//	private static Date parseDate(String inputDate) {
//        Date outputDate = null;
//        String[] possibleDateFormats =
//                {
//                        "yyyy-MM-dd",
//                        "yyyyMMdd",
//                        "yyyy/MM/dd",
//                        "yyyy年MM月dd日",
//                        "yyyy MM dd"
//                };
// 
//        try {
//            outputDate = DateUtils.parseDate(inputDate, possibleDateFormats);
//        } catch (ParseException e) {
//        	log.error("时间【"+inputDate+"】格式化错误:" + e);
//        }
//        return outputDate;
//    }

	/**
	 * 条件转换
	 *
	 * @param c 前端传递参数
	 */
	public void builderCondition(Map<String, Object> c) {
		if (c != null) {
			if (condition != null) {
				Iterator<Map.Entry<String, Object>> iterator = c.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry<String, Object> me = iterator.next();
					String[] keys = me.getKey().trim().split("\\|");
					Object value = me.getValue();

					if (StringUtils.isBlank(keys[0]) || value == null || StringUtils.isBlank("" + value)) {
						continue;
					}
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
					this.condition.add(condition);
				}
			}
		}
	}

	public void builderLambdaCondition(Map<SFunction<T, ?>, Object> c) {
		Map<String, Object> realCondition = new HashMap<>();
		c.forEach((k, v) -> realCondition.put(resolveColumn(k), v));
		builderCondition(realCondition);
	}

	public static <T> LambadaRpcWrapper<T> build() {
		return new LambadaRpcWrapper<T>();
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

		if (condition != null && condition.size() > 0) {
			for (Condition c : condition) {

				String conditionKey = c.getCondition();
				String column = c.getColumn();
				Object params = c.getParams();
				// 在SQL语句中发现不符合下划线风格的列
				column = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, column);
				if (params != null && StringUtils.isNotBlank(params + "")) {
					switch (conditionKey) {
					case IN:
						List<Object> in = new ArrayList<Object>();
						if (params instanceof Collection) {
							Collection<?> psList = (Collection<?>) params;
							Iterator<?> it = psList.iterator();
							while (it.hasNext()) {
								in.add(it.next());
							}
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

		return wrapper;
	}

	// 从类属性的 get 方法解析出数据库字段
	private String resolveColumn(SFunction<T, ?> func) {
		Method writeReplace = null;
		try {
			writeReplace = func.getClass().getDeclaredMethod("writeReplace");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		assert writeReplace != null;
		writeReplace.setAccessible(true);
		try {
			java.lang.invoke.SerializedLambda serializedLambda = (SerializedLambda) writeReplace.invoke(func);
			// 这里取到的是大驼峰的命名方式
			String targetFieldName = serializedLambda.getImplMethodName().substring(3);
			// 转成小驼峰才是类属性
			targetFieldName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, targetFieldName);
			String entityName = serializedLambda.getImplClass().replace("/", ".");
			Field entityDeclaredField = Class.forName(entityName).getDeclaredField(targetFieldName);
			// 定义了 @TableField 注解,从注解中取出数据库字段
			TableField tableField = entityDeclaredField.getAnnotation(TableField.class);
			if (tableField != null) {
				if ("".equals(tableField.value())) {
					// 没有设置数据库字段时，表示字段名和数据库名一致，直接返回
					return entityDeclaredField.getName();
				} else {
					return tableField.value();
				}
			} else {
				// 没有定义 @TableField 注解的情况下直接解析类字段
				return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityDeclaredField.getName());
			}
		} catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchFieldException e) {
			log.error("resolveColumn ERROR", e);
		}
		// 这一步应该不会执行到，有极小的概率会在异常时执行,字段不存在时会执行
		return null;
	}
}
