package com.webdevelope.summoned.task.model;

import java.util.ArrayList;
import java.util.List;

public class SummonedInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SummonedInfoExample() {
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

        public Criteria andOwnUserIdIsNull() {
            addCriterion("own_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdIsNotNull() {
            addCriterion("own_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdEqualTo(Long value) {
            addCriterion("own_user_id =", value, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdNotEqualTo(Long value) {
            addCriterion("own_user_id <>", value, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdGreaterThan(Long value) {
            addCriterion("own_user_id >", value, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("own_user_id >=", value, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdLessThan(Long value) {
            addCriterion("own_user_id <", value, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdLessThanOrEqualTo(Long value) {
            addCriterion("own_user_id <=", value, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdIn(List<Long> values) {
            addCriterion("own_user_id in", values, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdNotIn(List<Long> values) {
            addCriterion("own_user_id not in", values, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdBetween(Long value1, Long value2) {
            addCriterion("own_user_id between", value1, value2, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andOwnUserIdNotBetween(Long value1, Long value2) {
            addCriterion("own_user_id not between", value1, value2, "ownUserId");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeIsNull() {
            addCriterion("summoned_type is null");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeIsNotNull() {
            addCriterion("summoned_type is not null");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeEqualTo(Integer value) {
            addCriterion("summoned_type =", value, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeNotEqualTo(Integer value) {
            addCriterion("summoned_type <>", value, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeGreaterThan(Integer value) {
            addCriterion("summoned_type >", value, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("summoned_type >=", value, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeLessThan(Integer value) {
            addCriterion("summoned_type <", value, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeLessThanOrEqualTo(Integer value) {
            addCriterion("summoned_type <=", value, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeIn(List<Integer> values) {
            addCriterion("summoned_type in", values, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeNotIn(List<Integer> values) {
            addCriterion("summoned_type not in", values, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeBetween(Integer value1, Integer value2) {
            addCriterion("summoned_type between", value1, value2, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("summoned_type not between", value1, value2, "summonedType");
            return (Criteria) this;
        }

        public Criteria andSummonedNameIsNull() {
            addCriterion("summoned_name is null");
            return (Criteria) this;
        }

        public Criteria andSummonedNameIsNotNull() {
            addCriterion("summoned_name is not null");
            return (Criteria) this;
        }

        public Criteria andSummonedNameEqualTo(String value) {
            addCriterion("summoned_name =", value, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameNotEqualTo(String value) {
            addCriterion("summoned_name <>", value, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameGreaterThan(String value) {
            addCriterion("summoned_name >", value, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameGreaterThanOrEqualTo(String value) {
            addCriterion("summoned_name >=", value, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameLessThan(String value) {
            addCriterion("summoned_name <", value, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameLessThanOrEqualTo(String value) {
            addCriterion("summoned_name <=", value, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameLike(String value) {
            addCriterion("summoned_name like", value, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameNotLike(String value) {
            addCriterion("summoned_name not like", value, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameIn(List<String> values) {
            addCriterion("summoned_name in", values, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameNotIn(List<String> values) {
            addCriterion("summoned_name not in", values, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameBetween(String value1, String value2) {
            addCriterion("summoned_name between", value1, value2, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedNameNotBetween(String value1, String value2) {
            addCriterion("summoned_name not between", value1, value2, "summonedName");
            return (Criteria) this;
        }

        public Criteria andSummonedDescIsNull() {
            addCriterion("summoned_desc is null");
            return (Criteria) this;
        }

        public Criteria andSummonedDescIsNotNull() {
            addCriterion("summoned_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSummonedDescEqualTo(String value) {
            addCriterion("summoned_desc =", value, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescNotEqualTo(String value) {
            addCriterion("summoned_desc <>", value, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescGreaterThan(String value) {
            addCriterion("summoned_desc >", value, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescGreaterThanOrEqualTo(String value) {
            addCriterion("summoned_desc >=", value, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescLessThan(String value) {
            addCriterion("summoned_desc <", value, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescLessThanOrEqualTo(String value) {
            addCriterion("summoned_desc <=", value, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescLike(String value) {
            addCriterion("summoned_desc like", value, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescNotLike(String value) {
            addCriterion("summoned_desc not like", value, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescIn(List<String> values) {
            addCriterion("summoned_desc in", values, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescNotIn(List<String> values) {
            addCriterion("summoned_desc not in", values, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescBetween(String value1, String value2) {
            addCriterion("summoned_desc between", value1, value2, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andSummonedDescNotBetween(String value1, String value2) {
            addCriterion("summoned_desc not between", value1, value2, "summonedDesc");
            return (Criteria) this;
        }

        public Criteria andWantedNumberIsNull() {
            addCriterion("wanted_number is null");
            return (Criteria) this;
        }

        public Criteria andWantedNumberIsNotNull() {
            addCriterion("wanted_number is not null");
            return (Criteria) this;
        }

        public Criteria andWantedNumberEqualTo(Integer value) {
            addCriterion("wanted_number =", value, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberNotEqualTo(Integer value) {
            addCriterion("wanted_number <>", value, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberGreaterThan(Integer value) {
            addCriterion("wanted_number >", value, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("wanted_number >=", value, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberLessThan(Integer value) {
            addCriterion("wanted_number <", value, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("wanted_number <=", value, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberIn(List<Integer> values) {
            addCriterion("wanted_number in", values, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberNotIn(List<Integer> values) {
            addCriterion("wanted_number not in", values, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberBetween(Integer value1, Integer value2) {
            addCriterion("wanted_number between", value1, value2, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andWantedNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("wanted_number not between", value1, value2, "wantedNumber");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Long value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Long value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Long value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Long value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Long value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Long> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Long> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Long value1, Long value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Long value1, Long value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andDescPictureIsNull() {
            addCriterion("desc_picture is null");
            return (Criteria) this;
        }

        public Criteria andDescPictureIsNotNull() {
            addCriterion("desc_picture is not null");
            return (Criteria) this;
        }

        public Criteria andDescPictureEqualTo(String value) {
            addCriterion("desc_picture =", value, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureNotEqualTo(String value) {
            addCriterion("desc_picture <>", value, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureGreaterThan(String value) {
            addCriterion("desc_picture >", value, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureGreaterThanOrEqualTo(String value) {
            addCriterion("desc_picture >=", value, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureLessThan(String value) {
            addCriterion("desc_picture <", value, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureLessThanOrEqualTo(String value) {
            addCriterion("desc_picture <=", value, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureLike(String value) {
            addCriterion("desc_picture like", value, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureNotLike(String value) {
            addCriterion("desc_picture not like", value, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureIn(List<String> values) {
            addCriterion("desc_picture in", values, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureNotIn(List<String> values) {
            addCriterion("desc_picture not in", values, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureBetween(String value1, String value2) {
            addCriterion("desc_picture between", value1, value2, "descPicture");
            return (Criteria) this;
        }

        public Criteria andDescPictureNotBetween(String value1, String value2) {
            addCriterion("desc_picture not between", value1, value2, "descPicture");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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