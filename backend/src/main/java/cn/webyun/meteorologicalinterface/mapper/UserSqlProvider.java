package cn.webyun.meteorologicalinterface.mapper;

import cn.webyun.meteorologicalinterface.entity.User;
import cn.webyun.meteorologicalinterface.entity.UserCriteria;
import cn.webyun.meteorologicalinterface.entity.UserCriteria.Criteria;
import cn.webyun.meteorologicalinterface.entity.UserCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class UserSqlProvider {

    public String countByExample(UserCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_users");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_users");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_users");

        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }

        if (record.getUserFullName() != null) {
            sql.VALUES("user_full_name", "#{userFullName,jdbcType=VARCHAR}");
        }

        if (record.getUserPassword() != null) {
            sql.VALUES("user_password", "#{userPassword,jdbcType=VARCHAR}");
        }

        if (record.getUnitId() != null) {
            sql.VALUES("unit_id", "#{unitId,jdbcType=INTEGER}");
        }

        if (record.getUnitName() != null) {
            sql.VALUES("unit_name", "#{unitName,jdbcType=VARCHAR}");
        }

        if (record.getUnitFullName() != null) {
            sql.VALUES("unit_full_name", "#{unitFullName,jdbcType=VARCHAR}");
        }

        if (record.getAccountExpired() != null) {
            sql.VALUES("account_expired", "#{accountExpired,jdbcType=INTEGER}");
        }

        if (record.getAccountLocked() != null) {
            sql.VALUES("account_locked", "#{accountLocked,jdbcType=INTEGER}");
        }

        if (record.getPasswordExpired() != null) {
            sql.VALUES("password_expired", "#{passwordExpired,jdbcType=INTEGER}");
        }

        if (record.getAccountEnabled() != null) {
            sql.VALUES("account_enabled", "#{accountEnabled,jdbcType=INTEGER}");
        }

        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String selectByExample(UserCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_name");
        sql.SELECT("user_full_name");
        sql.SELECT("user_password");
        sql.SELECT("unit_id");
        sql.SELECT("unit_name");
        sql.SELECT("unit_full_name");
        sql.SELECT("account_expired");
        sql.SELECT("account_locked");
        sql.SELECT("password_expired");
        sql.SELECT("account_enabled");
        sql.SELECT("email");
        sql.SELECT("address");
        sql.SELECT("phone");
        sql.FROM("sys_users");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserCriteria example = (UserCriteria) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("sys_users");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }

        if (record.getUserFullName() != null) {
            sql.SET("user_full_name = #{record.userFullName,jdbcType=VARCHAR}");
        }

        if (record.getUserPassword() != null) {
            sql.SET("user_password = #{record.userPassword,jdbcType=VARCHAR}");
        }

        if (record.getUnitId() != null) {
            sql.SET("unit_id = #{record.unitId,jdbcType=INTEGER}");
        }

        if (record.getUnitName() != null) {
            sql.SET("unit_name = #{record.unitName,jdbcType=VARCHAR}");
        }

        if (record.getUnitFullName() != null) {
            sql.SET("unit_full_name = #{record.unitFullName,jdbcType=VARCHAR}");
        }

        if (record.getAccountExpired() != null) {
            sql.SET("account_expired = #{record.accountExpired,jdbcType=INTEGER}");
        }

        if (record.getAccountLocked() != null) {
            sql.SET("account_locked = #{record.accountLocked,jdbcType=INTEGER}");
        }

        if (record.getPasswordExpired() != null) {
            sql.SET("password_expired = #{record.passwordExpired,jdbcType=INTEGER}");
        }

        if (record.getAccountEnabled() != null) {
            sql.SET("account_enabled = #{record.accountEnabled,jdbcType=INTEGER}");
        }

        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_users");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("user_full_name = #{record.userFullName,jdbcType=VARCHAR}");
        sql.SET("user_password = #{record.userPassword,jdbcType=VARCHAR}");
        sql.SET("unit_id = #{record.unitId,jdbcType=INTEGER}");
        sql.SET("unit_name = #{record.unitName,jdbcType=VARCHAR}");
        sql.SET("unit_full_name = #{record.unitFullName,jdbcType=VARCHAR}");
        sql.SET("account_expired = #{record.accountExpired,jdbcType=INTEGER}");
        sql.SET("account_locked = #{record.accountLocked,jdbcType=INTEGER}");
        sql.SET("password_expired = #{record.passwordExpired,jdbcType=INTEGER}");
        sql.SET("account_enabled = #{record.accountEnabled,jdbcType=INTEGER}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");

        UserCriteria example = (UserCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_users");

        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }

        if (record.getUserFullName() != null) {
            sql.SET("user_full_name = #{userFullName,jdbcType=VARCHAR}");
        }

        if (record.getUserPassword() != null) {
            sql.SET("user_password = #{userPassword,jdbcType=VARCHAR}");
        }

        if (record.getUnitId() != null) {
            sql.SET("unit_id = #{unitId,jdbcType=INTEGER}");
        }

        if (record.getUnitName() != null) {
            sql.SET("unit_name = #{unitName,jdbcType=VARCHAR}");
        }

        if (record.getUnitFullName() != null) {
            sql.SET("unit_full_name = #{unitFullName,jdbcType=VARCHAR}");
        }

        if (record.getAccountExpired() != null) {
            sql.SET("account_expired = #{accountExpired,jdbcType=INTEGER}");
        }

        if (record.getAccountLocked() != null) {
            sql.SET("account_locked = #{accountLocked,jdbcType=INTEGER}");
        }

        if (record.getPasswordExpired() != null) {
            sql.SET("password_expired = #{passwordExpired,jdbcType=INTEGER}");
        }

        if (record.getAccountEnabled() != null) {
            sql.SET("account_enabled = #{accountEnabled,jdbcType=INTEGER}");
        }

        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}
