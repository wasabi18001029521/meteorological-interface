package cn.webyun.meteorologicalinterface.entity;

import java.util.ArrayList;
import java.util.List;

public class UserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCriteria() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like '%" + value + "%'");//userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like '%" + value + "%'");//userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameIsNull() {
            addCriterion("user_full_name is null");
            return (Criteria) this;
        }

        public Criteria andUserFullNameIsNotNull() {
            addCriterion("user_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserFullNameEqualTo(String value) {
            addCriterion("user_full_name =", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameNotEqualTo(String value) {
            addCriterion("user_full_name <>", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameGreaterThan(String value) {
            addCriterion("user_full_name >", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_full_name >=", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameLessThan(String value) {
            addCriterion("user_full_name <", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameLessThanOrEqualTo(String value) {
            addCriterion("user_full_name <=", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameLike(String value) {
            addCriterion("user_full_name like '%" + value + "%'");//userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameNotLike(String value) {
            addCriterion("user_full_name not like '%" + value + "%'");//userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameIn(List<String> values) {
            addCriterion("user_full_name in", values, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameNotIn(List<String> values) {
            addCriterion("user_full_name not in", values, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameBetween(String value1, String value2) {
            addCriterion("user_full_name between", value1, value2, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameNotBetween(String value1, String value2) {
            addCriterion("user_full_name not between", value1, value2, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like '%" + value + "%'");//userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like '%" + value + "%'");//userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNull() {
            addCriterion("unit_id is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(Integer value) {
            addCriterion("unit_id =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(Integer value) {
            addCriterion("unit_id <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(Integer value) {
            addCriterion("unit_id >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_id >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(Integer value) {
            addCriterion("unit_id <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(Integer value) {
            addCriterion("unit_id <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(List<Integer> values) {
            addCriterion("unit_id in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(List<Integer> values) {
            addCriterion("unit_id not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(Integer value1, Integer value2) {
            addCriterion("unit_id between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_id not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like '%" + value + "%'");//unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like '%" + value + "%'");//unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameIsNull() {
            addCriterion("unit_full_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameIsNotNull() {
            addCriterion("unit_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameEqualTo(String value) {
            addCriterion("unit_full_name =", value, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameNotEqualTo(String value) {
            addCriterion("unit_full_name <>", value, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameGreaterThan(String value) {
            addCriterion("unit_full_name >", value, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_full_name >=", value, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameLessThan(String value) {
            addCriterion("unit_full_name <", value, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameLessThanOrEqualTo(String value) {
            addCriterion("unit_full_name <=", value, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameLike(String value) {
            addCriterion("unit_full_name like '%" + value + "%'");//unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameNotLike(String value) {
            addCriterion("unit_full_name not like '%" + value + "%'");//unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameIn(List<String> values) {
            addCriterion("unit_full_name in", values, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameNotIn(List<String> values) {
            addCriterion("unit_full_name not in", values, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameBetween(String value1, String value2) {
            addCriterion("unit_full_name between", value1, value2, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andUnitFullNameNotBetween(String value1, String value2) {
            addCriterion("unit_full_name not between", value1, value2, "unitFullName");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredIsNull() {
            addCriterion("account_expired is null");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredIsNotNull() {
            addCriterion("account_expired is not null");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredEqualTo(Boolean value) {
            addCriterion("account_expired =", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredNotEqualTo(Boolean value) {
            addCriterion("account_expired <>", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredGreaterThan(Boolean value) {
            addCriterion("account_expired >", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("account_expired >=", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredLessThan(Boolean value) {
            addCriterion("account_expired <", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("account_expired <=", value, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredIn(List<Boolean> values) {
            addCriterion("account_expired in", values, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredNotIn(List<Boolean> values) {
            addCriterion("account_expired not in", values, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("account_expired between", value1, value2, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountExpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("account_expired not between", value1, value2, "accountExpired");
            return (Criteria) this;
        }

        public Criteria andAccountLockedIsNull() {
            addCriterion("account_locked is null");
            return (Criteria) this;
        }

        public Criteria andAccountLockedIsNotNull() {
            addCriterion("account_locked is not null");
            return (Criteria) this;
        }

        public Criteria andAccountLockedEqualTo(Boolean value) {
            addCriterion("account_locked =", value, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedNotEqualTo(Boolean value) {
            addCriterion("account_locked <>", value, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedGreaterThan(Boolean value) {
            addCriterion("account_locked >", value, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("account_locked >=", value, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedLessThan(Boolean value) {
            addCriterion("account_locked <", value, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedLessThanOrEqualTo(Boolean value) {
            addCriterion("account_locked <=", value, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedIn(List<Boolean> values) {
            addCriterion("account_locked in", values, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedNotIn(List<Boolean> values) {
            addCriterion("account_locked not in", values, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedBetween(Boolean value1, Boolean value2) {
            addCriterion("account_locked between", value1, value2, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andAccountLockedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("account_locked not between", value1, value2, "accountLocked");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredIsNull() {
            addCriterion("password_expired is null");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredIsNotNull() {
            addCriterion("password_expired is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredEqualTo(Boolean value) {
            addCriterion("password_expired =", value, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredNotEqualTo(Boolean value) {
            addCriterion("password_expired <>", value, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredGreaterThan(Boolean value) {
            addCriterion("password_expired >", value, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("password_expired >=", value, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredLessThan(Boolean value) {
            addCriterion("password_expired <", value, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("password_expired <=", value, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredIn(List<Boolean> values) {
            addCriterion("password_expired in", values, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredNotIn(List<Boolean> values) {
            addCriterion("password_expired not in", values, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("password_expired between", value1, value2, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andPasswordExpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("password_expired not between", value1, value2, "passwordExpired");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledIsNull() {
            addCriterion("account_enabled is null");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledIsNotNull() {
            addCriterion("account_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledEqualTo(Boolean value) {
            addCriterion("account_enabled =", value, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledNotEqualTo(Boolean value) {
            addCriterion("account_enabled <>", value, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledGreaterThan(Boolean value) {
            addCriterion("account_enabled >", value, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("account_enabled >=", value, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledLessThan(Boolean value) {
            addCriterion("account_enabled <", value, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("account_enabled <=", value, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledIn(List<Boolean> values) {
            addCriterion("account_enabled in", values, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledNotIn(List<Boolean> values) {
            addCriterion("account_enabled not in", values, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("account_enabled between", value1, value2, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andAccountEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("account_enabled not between", value1, value2, "accountEnabled");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like '%" + value + "%'");//email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like '%" + value + "%'");//email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like '%" + value + "%'");//address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like '%" + value + "%'");//address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like '%" + value + "%'");//phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like '%" + value + "%'");//phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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
