package com.bjpowernode.finance.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LoanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoanExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andLoanidIsNull() {
            addCriterion("loanId is null");
            return (Criteria) this;
        }

        public Criteria andLoanidIsNotNull() {
            addCriterion("loanId is not null");
            return (Criteria) this;
        }

        public Criteria andLoanidEqualTo(Integer value) {
            addCriterion("loanId =", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotEqualTo(Integer value) {
            addCriterion("loanId <>", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidGreaterThan(Integer value) {
            addCriterion("loanId >", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("loanId >=", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidLessThan(Integer value) {
            addCriterion("loanId <", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidLessThanOrEqualTo(Integer value) {
            addCriterion("loanId <=", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidIn(List<Integer> values) {
            addCriterion("loanId in", values, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotIn(List<Integer> values) {
            addCriterion("loanId not in", values, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidBetween(Integer value1, Integer value2) {
            addCriterion("loanId between", value1, value2, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotBetween(Integer value1, Integer value2) {
            addCriterion("loanId not between", value1, value2, "loanid");
            return (Criteria) this;
        }

        public Criteria andExamineidIsNull() {
            addCriterion("examineId is null");
            return (Criteria) this;
        }

        public Criteria andExamineidIsNotNull() {
            addCriterion("examineId is not null");
            return (Criteria) this;
        }

        public Criteria andExamineidEqualTo(Integer value) {
            addCriterion("examineId =", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidNotEqualTo(Integer value) {
            addCriterion("examineId <>", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidGreaterThan(Integer value) {
            addCriterion("examineId >", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("examineId >=", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidLessThan(Integer value) {
            addCriterion("examineId <", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidLessThanOrEqualTo(Integer value) {
            addCriterion("examineId <=", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidIn(List<Integer> values) {
            addCriterion("examineId in", values, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidNotIn(List<Integer> values) {
            addCriterion("examineId not in", values, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidBetween(Integer value1, Integer value2) {
            addCriterion("examineId between", value1, value2, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidNotBetween(Integer value1, Integer value2) {
            addCriterion("examineId not between", value1, value2, "examineid");
            return (Criteria) this;
        }

        public Criteria andLoantimeIsNull() {
            addCriterion("loanTime is null");
            return (Criteria) this;
        }

        public Criteria andLoantimeIsNotNull() {
            addCriterion("loanTime is not null");
            return (Criteria) this;
        }

        public Criteria andLoantimeEqualTo(Date value) {
            addCriterionForJDBCDate("loanTime =", value, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("loanTime <>", value, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeGreaterThan(Date value) {
            addCriterionForJDBCDate("loanTime >", value, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("loanTime >=", value, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeLessThan(Date value) {
            addCriterionForJDBCDate("loanTime <", value, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("loanTime <=", value, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeIn(List<Date> values) {
            addCriterionForJDBCDate("loanTime in", values, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("loanTime not in", values, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("loanTime between", value1, value2, "loantime");
            return (Criteria) this;
        }

        public Criteria andLoantimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("loanTime not between", value1, value2, "loantime");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(Integer value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(Integer value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(Integer value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(Integer value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(Integer value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<Integer> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<Integer> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(Integer value1, Integer value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(Integer value1, Integer value2) {
            addCriterion("term not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andApplystatusIsNull() {
            addCriterion("applyStatus is null");
            return (Criteria) this;
        }

        public Criteria andApplystatusIsNotNull() {
            addCriterion("applyStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApplystatusEqualTo(Integer value) {
            addCriterion("applyStatus =", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusNotEqualTo(Integer value) {
            addCriterion("applyStatus <>", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusGreaterThan(Integer value) {
            addCriterion("applyStatus >", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyStatus >=", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusLessThan(Integer value) {
            addCriterion("applyStatus <", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusLessThanOrEqualTo(Integer value) {
            addCriterion("applyStatus <=", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusIn(List<Integer> values) {
            addCriterion("applyStatus in", values, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusNotIn(List<Integer> values) {
            addCriterion("applyStatus not in", values, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusBetween(Integer value1, Integer value2) {
            addCriterion("applyStatus between", value1, value2, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusNotBetween(Integer value1, Integer value2) {
            addCriterion("applyStatus not between", value1, value2, "applystatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusIsNull() {
            addCriterion("loanStatus is null");
            return (Criteria) this;
        }

        public Criteria andLoanstatusIsNotNull() {
            addCriterion("loanStatus is not null");
            return (Criteria) this;
        }

        public Criteria andLoanstatusEqualTo(Integer value) {
            addCriterion("loanStatus =", value, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusNotEqualTo(Integer value) {
            addCriterion("loanStatus <>", value, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusGreaterThan(Integer value) {
            addCriterion("loanStatus >", value, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("loanStatus >=", value, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusLessThan(Integer value) {
            addCriterion("loanStatus <", value, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusLessThanOrEqualTo(Integer value) {
            addCriterion("loanStatus <=", value, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusIn(List<Integer> values) {
            addCriterion("loanStatus in", values, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusNotIn(List<Integer> values) {
            addCriterion("loanStatus not in", values, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusBetween(Integer value1, Integer value2) {
            addCriterion("loanStatus between", value1, value2, "loanstatus");
            return (Criteria) this;
        }

        public Criteria andLoanstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("loanStatus not between", value1, value2, "loanstatus");
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