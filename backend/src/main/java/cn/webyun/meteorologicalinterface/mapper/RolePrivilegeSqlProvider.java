package cn.webyun.meteorologicalinterface.mapper;

import cn.webyun.meteorologicalinterface.entity.RolePrivilege;
import cn.webyun.meteorologicalinterface.entity.RolePrivilegeCriteria;
import cn.webyun.meteorologicalinterface.entity.RolePrivilegeCriteria.Criteria;
import cn.webyun.meteorologicalinterface.entity.RolePrivilegeCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class RolePrivilegeSqlProvider {

    public String countByExample(RolePrivilegeCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_role_privilege");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RolePrivilegeCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_role_privilege");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RolePrivilege record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_role_privilege");

        if (record.getRoleId() != null) {
            sql.VALUES("role_id", "#{roleId,jdbcType=INTEGER}");
        }

        if (record.getRoleName() != null) {
            sql.VALUES("role_name", "#{roleName,jdbcType=VARCHAR}");
        }

        if (record.getRoleDesc() != null) {
            sql.VALUES("role_desc", "#{roleDesc,jdbcType=VARCHAR}");
        }

        if (record.getPrivId() != null) {
            sql.VALUES("priv_id", "#{privId,jdbcType=INTEGER}");
        }

        if (record.getPrivName() != null) {
            sql.VALUES("priv_name", "#{privName,jdbcType=VARCHAR}");
        }

        if (record.getPrivDesc() != null) {
            sql.VALUES("priv_desc", "#{privDesc,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String selectByExample(RolePrivilegeCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("role_id");
        sql.SELECT("role_name");
        sql.SELECT("role_desc");
        sql.SELECT("priv_id");
        sql.SELECT("priv_name");
        sql.SELECT("priv_desc");
        sql.FROM("sys_role_privilege");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RolePrivilege record = (RolePrivilege) parameter.get("record");
        RolePrivilegeCriteria example = (RolePrivilegeCriteria) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("sys_role_privilege");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getRoleId() != null) {
            sql.SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        }

        if (record.getRoleName() != null) {
            sql.SET("role_name = #{record.roleName,jdbcType=VARCHAR}");
        }

        if (record.getRoleDesc() != null) {
            sql.SET("role_desc = #{record.roleDesc,jdbcType=VARCHAR}");
        }

        if (record.getPrivId() != null) {
            sql.SET("priv_id = #{record.privId,jdbcType=INTEGER}");
        }

        if (record.getPrivName() != null) {
            sql.SET("priv_name = #{record.privName,jdbcType=VARCHAR}");
        }

        if (record.getPrivDesc() != null) {
            sql.SET("priv_desc = #{record.privDesc,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role_privilege");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        sql.SET("role_name = #{record.roleName,jdbcType=VARCHAR}");
        sql.SET("role_desc = #{record.roleDesc,jdbcType=VARCHAR}");
        sql.SET("priv_id = #{record.privId,jdbcType=INTEGER}");
        sql.SET("priv_name = #{record.privName,jdbcType=VARCHAR}");
        sql.SET("priv_desc = #{record.privDesc,jdbcType=VARCHAR}");

        RolePrivilegeCriteria example = (RolePrivilegeCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RolePrivilege record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role_privilege");

        if (record.getRoleId() != null) {
            sql.SET("role_id = #{roleId,jdbcType=INTEGER}");
        }

        if (record.getRoleName() != null) {
            sql.SET("role_name = #{roleName,jdbcType=VARCHAR}");
        }

        if (record.getRoleDesc() != null) {
            sql.SET("role_desc = #{roleDesc,jdbcType=VARCHAR}");
        }

        if (record.getPrivId() != null) {
            sql.SET("priv_id = #{privId,jdbcType=INTEGER}");
        }

        if (record.getPrivName() != null) {
            sql.SET("priv_name = #{privName,jdbcType=VARCHAR}");
        }

        if (record.getPrivDesc() != null) {
            sql.SET("priv_desc = #{privDesc,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, RolePrivilegeCriteria example, boolean includeExamplePhrase) {
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
