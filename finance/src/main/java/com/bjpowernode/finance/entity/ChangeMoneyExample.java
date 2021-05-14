package com.bjpowernode.finance.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChangeMoneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChangeMoneyExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeIsNull() {
            addCriterion("annualIncome is null");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeIsNotNull() {
            addCriterion("annualIncome is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeEqualTo(BigDecimal value) {
            addCriterion("annualIncome =", value, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeNotEqualTo(BigDecimal value) {
            addCriterion("annualIncome <>", value, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeGreaterThan(BigDecimal value) {
            addCriterion("annualIncome >", value, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("annualIncome >=", value, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeLessThan(BigDecimal value) {
            addCriterion("annualIncome <", value, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("annualIncome <=", value, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeIn(List<BigDecimal> values) {
            addCriterion("annualIncome in", values, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeNotIn(List<BigDecimal> values) {
            addCriterion("annualIncome not in", values, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annualIncome between", value1, value2, "annualincome");
            return (Criteria) this;
        }

        public Criteria andAnnualincomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annualIncome not between", value1, value2, "annualincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeIsNull() {
            addCriterion("peiIncome is null");
            return (Criteria) this;
        }

        public Criteria andPeiincomeIsNotNull() {
            addCriterion("peiIncome is not null");
            return (Criteria) this;
        }

        public Criteria andPeiincomeEqualTo(BigDecimal value) {
            addCriterion("peiIncome =", value, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeNotEqualTo(BigDecimal value) {
            addCriterion("peiIncome <>", value, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeGreaterThan(BigDecimal value) {
            addCriterion("peiIncome >", value, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("peiIncome >=", value, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeLessThan(BigDecimal value) {
            addCriterion("peiIncome <", value, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("peiIncome <=", value, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeIn(List<BigDecimal> values) {
            addCriterion("peiIncome in", values, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeNotIn(List<BigDecimal> values) {
            addCriterion("peiIncome not in", values, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("peiIncome between", value1, value2, "peiincome");
            return (Criteria) this;
        }

        public Criteria andPeiincomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("peiIncome not between", value1, value2, "peiincome");
            return (Criteria) this;
        }

        public Criteria andInvestermIsNull() {
            addCriterion("invesTerm is null");
            return (Criteria) this;
        }

        public Criteria andInvestermIsNotNull() {
            addCriterion("invesTerm is not null");
            return (Criteria) this;
        }

        public Criteria andInvestermEqualTo(String value) {
            addCriterion("invesTerm =", value, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermNotEqualTo(String value) {
            addCriterion("invesTerm <>", value, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermGreaterThan(String value) {
            addCriterion("invesTerm >", value, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermGreaterThanOrEqualTo(String value) {
            addCriterion("invesTerm >=", value, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermLessThan(String value) {
            addCriterion("invesTerm <", value, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermLessThanOrEqualTo(String value) {
            addCriterion("invesTerm <=", value, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermLike(String value) {
            addCriterion("invesTerm like", value, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermNotLike(String value) {
            addCriterion("invesTerm not like", value, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermIn(List<String> values) {
            addCriterion("invesTerm in", values, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermNotIn(List<String> values) {
            addCriterion("invesTerm not in", values, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermBetween(String value1, String value2) {
            addCriterion("invesTerm between", value1, value2, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvestermNotBetween(String value1, String value2) {
            addCriterion("invesTerm not between", value1, value2, "investerm");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyIsNull() {
            addCriterion("invesMoney is null");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyIsNotNull() {
            addCriterion("invesMoney is not null");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyEqualTo(BigDecimal value) {
            addCriterion("invesMoney =", value, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyNotEqualTo(BigDecimal value) {
            addCriterion("invesMoney <>", value, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyGreaterThan(BigDecimal value) {
            addCriterion("invesMoney >", value, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("invesMoney >=", value, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyLessThan(BigDecimal value) {
            addCriterion("invesMoney <", value, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("invesMoney <=", value, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyIn(List<BigDecimal> values) {
            addCriterion("invesMoney in", values, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyNotIn(List<BigDecimal> values) {
            addCriterion("invesMoney not in", values, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("invesMoney between", value1, value2, "invesmoney");
            return (Criteria) this;
        }

        public Criteria andInvesmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("invesMoney not between", value1, value2, "invesmoney");
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