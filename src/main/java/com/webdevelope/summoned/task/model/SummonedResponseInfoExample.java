package com.webdevelope.summoned.task.model;

import java.util.ArrayList;
import java.util.List;

public class SummonedResponseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SummonedResponseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNull() {
            addCriterion("request_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNotNull() {
            addCriterion("request_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIdEqualTo(Long value) {
            addCriterion("request_id =", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotEqualTo(Long value) {
            addCriterion("request_id <>", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThan(Long value) {
            addCriterion("request_id >", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThanOrEqualTo(Long value) {
            addCriterion("request_id >=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThan(Long value) {
            addCriterion("request_id <", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThanOrEqualTo(Long value) {
            addCriterion("request_id <=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdIn(List<Long> values) {
            addCriterion("request_id in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotIn(List<Long> values) {
            addCriterion("request_id not in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdBetween(Long value1, Long value2) {
            addCriterion("request_id between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotBetween(Long value1, Long value2) {
            addCriterion("request_id not between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdIsNull() {
            addCriterion("owned_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdIsNotNull() {
            addCriterion("owned_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdEqualTo(Long value) {
            addCriterion("owned_user_id =", value, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdNotEqualTo(Long value) {
            addCriterion("owned_user_id <>", value, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdGreaterThan(Long value) {
            addCriterion("owned_user_id >", value, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("owned_user_id >=", value, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdLessThan(Long value) {
            addCriterion("owned_user_id <", value, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdLessThanOrEqualTo(Long value) {
            addCriterion("owned_user_id <=", value, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdIn(List<Long> values) {
            addCriterion("owned_user_id in", values, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdNotIn(List<Long> values) {
            addCriterion("owned_user_id not in", values, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdBetween(Long value1, Long value2) {
            addCriterion("owned_user_id between", value1, value2, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andOwnedUserIdNotBetween(Long value1, Long value2) {
            addCriterion("owned_user_id not between", value1, value2, "ownedUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdIsNull() {
            addCriterion("response_user_id is null");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdIsNotNull() {
            addCriterion("response_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdEqualTo(Long value) {
            addCriterion("response_user_id =", value, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdNotEqualTo(Long value) {
            addCriterion("response_user_id <>", value, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdGreaterThan(Long value) {
            addCriterion("response_user_id >", value, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("response_user_id >=", value, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdLessThan(Long value) {
            addCriterion("response_user_id <", value, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdLessThanOrEqualTo(Long value) {
            addCriterion("response_user_id <=", value, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdIn(List<Long> values) {
            addCriterion("response_user_id in", values, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdNotIn(List<Long> values) {
            addCriterion("response_user_id not in", values, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdBetween(Long value1, Long value2) {
            addCriterion("response_user_id between", value1, value2, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andResponseUserIdNotBetween(Long value1, Long value2) {
            addCriterion("response_user_id not between", value1, value2, "responseUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOwnerPayIsNull() {
            addCriterion("owner_pay is null");
            return (Criteria) this;
        }

        public Criteria andOwnerPayIsNotNull() {
            addCriterion("owner_pay is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerPayEqualTo(Integer value) {
            addCriterion("owner_pay =", value, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayNotEqualTo(Integer value) {
            addCriterion("owner_pay <>", value, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayGreaterThan(Integer value) {
            addCriterion("owner_pay >", value, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_pay >=", value, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayLessThan(Integer value) {
            addCriterion("owner_pay <", value, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayLessThanOrEqualTo(Integer value) {
            addCriterion("owner_pay <=", value, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayIn(List<Integer> values) {
            addCriterion("owner_pay in", values, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayNotIn(List<Integer> values) {
            addCriterion("owner_pay not in", values, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayBetween(Integer value1, Integer value2) {
            addCriterion("owner_pay between", value1, value2, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andOwnerPayNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_pay not between", value1, value2, "ownerPay");
            return (Criteria) this;
        }

        public Criteria andResponsePayIsNull() {
            addCriterion("response_pay is null");
            return (Criteria) this;
        }

        public Criteria andResponsePayIsNotNull() {
            addCriterion("response_pay is not null");
            return (Criteria) this;
        }

        public Criteria andResponsePayEqualTo(Integer value) {
            addCriterion("response_pay =", value, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayNotEqualTo(Integer value) {
            addCriterion("response_pay <>", value, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayGreaterThan(Integer value) {
            addCriterion("response_pay >", value, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayGreaterThanOrEqualTo(Integer value) {
            addCriterion("response_pay >=", value, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayLessThan(Integer value) {
            addCriterion("response_pay <", value, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayLessThanOrEqualTo(Integer value) {
            addCriterion("response_pay <=", value, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayIn(List<Integer> values) {
            addCriterion("response_pay in", values, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayNotIn(List<Integer> values) {
            addCriterion("response_pay not in", values, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayBetween(Integer value1, Integer value2) {
            addCriterion("response_pay between", value1, value2, "responsePay");
            return (Criteria) this;
        }

        public Criteria andResponsePayNotBetween(Integer value1, Integer value2) {
            addCriterion("response_pay not between", value1, value2, "responsePay");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}