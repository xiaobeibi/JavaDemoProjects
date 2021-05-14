package com.bjpowernode.finance.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FundProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundProductExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andFunddescIsNull() {
            addCriterion("fundDesc is null");
            return (Criteria) this;
        }

        public Criteria andFunddescIsNotNull() {
            addCriterion("fundDesc is not null");
            return (Criteria) this;
        }

        public Criteria andFunddescEqualTo(String value) {
            addCriterion("fundDesc =", value, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescNotEqualTo(String value) {
            addCriterion("fundDesc <>", value, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescGreaterThan(String value) {
            addCriterion("fundDesc >", value, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescGreaterThanOrEqualTo(String value) {
            addCriterion("fundDesc >=", value, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescLessThan(String value) {
            addCriterion("fundDesc <", value, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescLessThanOrEqualTo(String value) {
            addCriterion("fundDesc <=", value, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescLike(String value) {
            addCriterion("fundDesc like", value, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescNotLike(String value) {
            addCriterion("fundDesc not like", value, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescIn(List<String> values) {
            addCriterion("fundDesc in", values, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescNotIn(List<String> values) {
            addCriterion("fundDesc not in", values, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescBetween(String value1, String value2) {
            addCriterion("fundDesc between", value1, value2, "funddesc");
            return (Criteria) this;
        }

        public Criteria andFunddescNotBetween(String value1, String value2) {
            addCriterion("fundDesc not between", value1, value2, "funddesc");
            return (Criteria) this;
        }

        public Criteria andDailygrowthIsNull() {
            addCriterion("dailyGrowth is null");
            return (Criteria) this;
        }

        public Criteria andDailygrowthIsNotNull() {
            addCriterion("dailyGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andDailygrowthEqualTo(BigDecimal value) {
            addCriterion("dailyGrowth =", value, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthNotEqualTo(BigDecimal value) {
            addCriterion("dailyGrowth <>", value, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthGreaterThan(BigDecimal value) {
            addCriterion("dailyGrowth >", value, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dailyGrowth >=", value, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthLessThan(BigDecimal value) {
            addCriterion("dailyGrowth <", value, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dailyGrowth <=", value, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthIn(List<BigDecimal> values) {
            addCriterion("dailyGrowth in", values, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthNotIn(List<BigDecimal> values) {
            addCriterion("dailyGrowth not in", values, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dailyGrowth between", value1, value2, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andDailygrowthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dailyGrowth not between", value1, value2, "dailygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthIsNull() {
            addCriterion("monthlyGrowth is null");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthIsNotNull() {
            addCriterion("monthlyGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthEqualTo(BigDecimal value) {
            addCriterion("monthlyGrowth =", value, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthNotEqualTo(BigDecimal value) {
            addCriterion("monthlyGrowth <>", value, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthGreaterThan(BigDecimal value) {
            addCriterion("monthlyGrowth >", value, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthlyGrowth >=", value, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthLessThan(BigDecimal value) {
            addCriterion("monthlyGrowth <", value, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthlyGrowth <=", value, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthIn(List<BigDecimal> values) {
            addCriterion("monthlyGrowth in", values, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthNotIn(List<BigDecimal> values) {
            addCriterion("monthlyGrowth not in", values, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthlyGrowth between", value1, value2, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andMonthlygrowthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthlyGrowth not between", value1, value2, "monthlygrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthIsNull() {
            addCriterion("annualGrowth is null");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthIsNotNull() {
            addCriterion("annualGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthEqualTo(BigDecimal value) {
            addCriterion("annualGrowth =", value, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthNotEqualTo(BigDecimal value) {
            addCriterion("annualGrowth <>", value, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthGreaterThan(BigDecimal value) {
            addCriterion("annualGrowth >", value, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("annualGrowth >=", value, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthLessThan(BigDecimal value) {
            addCriterion("annualGrowth <", value, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("annualGrowth <=", value, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthIn(List<BigDecimal> values) {
            addCriterion("annualGrowth in", values, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthNotIn(List<BigDecimal> values) {
            addCriterion("annualGrowth not in", values, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annualGrowth between", value1, value2, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andAnnualgrowthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annualGrowth not between", value1, value2, "annualgrowth");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyIsNull() {
            addCriterion("leastMoney is null");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyIsNotNull() {
            addCriterion("leastMoney is not null");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyEqualTo(BigDecimal value) {
            addCriterion("leastMoney =", value, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyNotEqualTo(BigDecimal value) {
            addCriterion("leastMoney <>", value, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyGreaterThan(BigDecimal value) {
            addCriterion("leastMoney >", value, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("leastMoney >=", value, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyLessThan(BigDecimal value) {
            addCriterion("leastMoney <", value, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("leastMoney <=", value, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyIn(List<BigDecimal> values) {
            addCriterion("leastMoney in", values, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyNotIn(List<BigDecimal> values) {
            addCriterion("leastMoney not in", values, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("leastMoney between", value1, value2, "leastmoney");
            return (Criteria) this;
        }

        public Criteria andLeastmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("leastMoney not between", value1, value2, "leastmoney");
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