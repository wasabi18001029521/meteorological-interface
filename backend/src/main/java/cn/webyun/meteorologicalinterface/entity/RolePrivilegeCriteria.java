package cn.webyun.meteorologicalinterface.entity;

import java.util.ArrayList;
import java.util.List;

public class RolePrivilegeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RolePrivilegeCriteria() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like '%" + value + "%'");//roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like '%" + value + "%'");//roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNull() {
            addCriterion("role_desc is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNotNull() {
            addCriterion("role_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescEqualTo(String value) {
            addCriterion("role_desc =", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotEqualTo(String value) {
            addCriterion("role_desc <>", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThan(String value) {
            addCriterion("role_desc >", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThanOrEqualTo(String value) {
            addCriterion("role_desc >=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThan(String value) {
            addCriterion("role_desc <", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThanOrEqualTo(String value) {
            addCriterion("role_desc <=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLike(String value) {
            addCriterion("role_desc like '%" + value + "%'");//roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotLike(String value) {
            addCriterion("role_desc not like '%" + value + "%'");//roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescIn(List<String> values) {
            addCriterion("role_desc in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotIn(List<String> values) {
            addCriterion("role_desc not in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescBetween(String value1, String value2) {
            addCriterion("role_desc between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotBetween(String value1, String value2) {
            addCriterion("role_desc not between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andPrivIdIsNull() {
            addCriterion("priv_id is null");
            return (Criteria) this;
        }

        public Criteria andPrivIdIsNotNull() {
            addCriterion("priv_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrivIdEqualTo(Integer value) {
            addCriterion("priv_id =", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdNotEqualTo(Integer value) {
            addCriterion("priv_id <>", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdGreaterThan(Integer value) {
            addCriterion("priv_id >", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("priv_id >=", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdLessThan(Integer value) {
            addCriterion("priv_id <", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdLessThanOrEqualTo(Integer value) {
            addCriterion("priv_id <=", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdIn(List<Integer> values) {
            addCriterion("priv_id in", values, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdNotIn(List<Integer> values) {
            addCriterion("priv_id not in", values, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdBetween(Integer value1, Integer value2) {
            addCriterion("priv_id between", value1, value2, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdNotBetween(Integer value1, Integer value2) {
            addCriterion("priv_id not between", value1, value2, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivNameIsNull() {
            addCriterion("priv_name is null");
            return (Criteria) this;
        }

        public Criteria andPrivNameIsNotNull() {
            addCriterion("priv_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrivNameEqualTo(String value) {
            addCriterion("priv_name =", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameNotEqualTo(String value) {
            addCriterion("priv_name <>", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameGreaterThan(String value) {
            addCriterion("priv_name >", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameGreaterThanOrEqualTo(String value) {
            addCriterion("priv_name >=", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameLessThan(String value) {
            addCriterion("priv_name <", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameLessThanOrEqualTo(String value) {
            addCriterion("priv_name <=", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameLike(String value) {
            addCriterion("priv_name like '%" + value + "%'");//privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameNotLike(String value) {
            addCriterion("priv_name not like '%" + value + "%'");//privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameIn(List<String> values) {
            addCriterion("priv_name in", values, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameNotIn(List<String> values) {
            addCriterion("priv_name not in", values, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameBetween(String value1, String value2) {
            addCriterion("priv_name between", value1, value2, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameNotBetween(String value1, String value2) {
            addCriterion("priv_name not between", value1, value2, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivDescIsNull() {
            addCriterion("priv_desc is null");
            return (Criteria) this;
        }

        public Criteria andPrivDescIsNotNull() {
            addCriterion("priv_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPrivDescEqualTo(String value) {
            addCriterion("priv_desc =", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescNotEqualTo(String value) {
            addCriterion("priv_desc <>", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescGreaterThan(String value) {
            addCriterion("priv_desc >", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescGreaterThanOrEqualTo(String value) {
            addCriterion("priv_desc >=", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescLessThan(String value) {
            addCriterion("priv_desc <", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescLessThanOrEqualTo(String value) {
            addCriterion("priv_desc <=", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescLike(String value) {
            addCriterion("priv_desc like '%" + value + "%'");//privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescNotLike(String value) {
            addCriterion("priv_desc not like '%" + value + "%'");//privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescIn(List<String> values) {
            addCriterion("priv_desc in", values, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescNotIn(List<String> values) {
            addCriterion("priv_desc not in", values, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescBetween(String value1, String value2) {
            addCriterion("priv_desc between", value1, value2, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescNotBetween(String value1, String value2) {
            addCriterion("priv_desc not between", value1, value2, "privDesc");
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
