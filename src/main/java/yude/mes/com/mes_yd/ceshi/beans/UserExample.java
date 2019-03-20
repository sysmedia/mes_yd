package yude.mes.com.mes_yd.ceshi.beans;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsercodeIsNull() {
            addCriterion("USERCODE is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("USERCODE is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(String value) {
            addCriterion("USERCODE =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(String value) {
            addCriterion("USERCODE <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(String value) {
            addCriterion("USERCODE >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(String value) {
            addCriterion("USERCODE >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(String value) {
            addCriterion("USERCODE <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(String value) {
            addCriterion("USERCODE <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLike(String value) {
            addCriterion("USERCODE like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotLike(String value) {
            addCriterion("USERCODE not like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<String> values) {
            addCriterion("USERCODE in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<String> values) {
            addCriterion("USERCODE not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(String value1, String value2) {
            addCriterion("USERCODE between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(String value1, String value2) {
            addCriterion("USERCODE not between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUserpwdIsNull() {
            addCriterion("USERPWD is null");
            return (Criteria) this;
        }

        public Criteria andUserpwdIsNotNull() {
            addCriterion("USERPWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserpwdEqualTo(String value) {
            addCriterion("USERPWD =", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotEqualTo(String value) {
            addCriterion("USERPWD <>", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdGreaterThan(String value) {
            addCriterion("USERPWD >", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdGreaterThanOrEqualTo(String value) {
            addCriterion("USERPWD >=", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLessThan(String value) {
            addCriterion("USERPWD <", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLessThanOrEqualTo(String value) {
            addCriterion("USERPWD <=", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLike(String value) {
            addCriterion("USERPWD like", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotLike(String value) {
            addCriterion("USERPWD not like", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdIn(List<String> values) {
            addCriterion("USERPWD in", values, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotIn(List<String> values) {
            addCriterion("USERPWD not in", values, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdBetween(String value1, String value2) {
            addCriterion("USERPWD between", value1, value2, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotBetween(String value1, String value2) {
            addCriterion("USERPWD not between", value1, value2, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsertelIsNull() {
            addCriterion("USERTEL is null");
            return (Criteria) this;
        }

        public Criteria andUsertelIsNotNull() {
            addCriterion("USERTEL is not null");
            return (Criteria) this;
        }

        public Criteria andUsertelEqualTo(String value) {
            addCriterion("USERTEL =", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelNotEqualTo(String value) {
            addCriterion("USERTEL <>", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelGreaterThan(String value) {
            addCriterion("USERTEL >", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelGreaterThanOrEqualTo(String value) {
            addCriterion("USERTEL >=", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelLessThan(String value) {
            addCriterion("USERTEL <", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelLessThanOrEqualTo(String value) {
            addCriterion("USERTEL <=", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelLike(String value) {
            addCriterion("USERTEL like", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelNotLike(String value) {
            addCriterion("USERTEL not like", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelIn(List<String> values) {
            addCriterion("USERTEL in", values, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelNotIn(List<String> values) {
            addCriterion("USERTEL not in", values, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelBetween(String value1, String value2) {
            addCriterion("USERTEL between", value1, value2, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelNotBetween(String value1, String value2) {
            addCriterion("USERTEL not between", value1, value2, "usertel");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNull() {
            addCriterion("USEREMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNotNull() {
            addCriterion("USEREMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUseremailEqualTo(String value) {
            addCriterion("USEREMAIL =", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotEqualTo(String value) {
            addCriterion("USEREMAIL <>", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThan(String value) {
            addCriterion("USEREMAIL >", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThanOrEqualTo(String value) {
            addCriterion("USEREMAIL >=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThan(String value) {
            addCriterion("USEREMAIL <", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThanOrEqualTo(String value) {
            addCriterion("USEREMAIL <=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLike(String value) {
            addCriterion("USEREMAIL like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotLike(String value) {
            addCriterion("USEREMAIL not like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailIn(List<String> values) {
            addCriterion("USEREMAIL in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotIn(List<String> values) {
            addCriterion("USEREMAIL not in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailBetween(String value1, String value2) {
            addCriterion("USEREMAIL between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotBetween(String value1, String value2) {
            addCriterion("USEREMAIL not between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUserdepartIsNull() {
            addCriterion("USERDEPART is null");
            return (Criteria) this;
        }

        public Criteria andUserdepartIsNotNull() {
            addCriterion("USERDEPART is not null");
            return (Criteria) this;
        }

        public Criteria andUserdepartEqualTo(String value) {
            addCriterion("USERDEPART =", value, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartNotEqualTo(String value) {
            addCriterion("USERDEPART <>", value, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartGreaterThan(String value) {
            addCriterion("USERDEPART >", value, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartGreaterThanOrEqualTo(String value) {
            addCriterion("USERDEPART >=", value, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartLessThan(String value) {
            addCriterion("USERDEPART <", value, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartLessThanOrEqualTo(String value) {
            addCriterion("USERDEPART <=", value, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartLike(String value) {
            addCriterion("USERDEPART like", value, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartNotLike(String value) {
            addCriterion("USERDEPART not like", value, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartIn(List<String> values) {
            addCriterion("USERDEPART in", values, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartNotIn(List<String> values) {
            addCriterion("USERDEPART not in", values, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartBetween(String value1, String value2) {
            addCriterion("USERDEPART between", value1, value2, "userdepart");
            return (Criteria) this;
        }

        public Criteria andUserdepartNotBetween(String value1, String value2) {
            addCriterion("USERDEPART not between", value1, value2, "userdepart");
            return (Criteria) this;
        }

        public Criteria andMuserIsNull() {
            addCriterion("MUSER is null");
            return (Criteria) this;
        }

        public Criteria andMuserIsNotNull() {
            addCriterion("MUSER is not null");
            return (Criteria) this;
        }

        public Criteria andMuserEqualTo(String value) {
            addCriterion("MUSER =", value, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserNotEqualTo(String value) {
            addCriterion("MUSER <>", value, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserGreaterThan(String value) {
            addCriterion("MUSER >", value, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserGreaterThanOrEqualTo(String value) {
            addCriterion("MUSER >=", value, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserLessThan(String value) {
            addCriterion("MUSER <", value, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserLessThanOrEqualTo(String value) {
            addCriterion("MUSER <=", value, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserLike(String value) {
            addCriterion("MUSER like", value, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserNotLike(String value) {
            addCriterion("MUSER not like", value, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserIn(List<String> values) {
            addCriterion("MUSER in", values, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserNotIn(List<String> values) {
            addCriterion("MUSER not in", values, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserBetween(String value1, String value2) {
            addCriterion("MUSER between", value1, value2, "muser");
            return (Criteria) this;
        }

        public Criteria andMuserNotBetween(String value1, String value2) {
            addCriterion("MUSER not between", value1, value2, "muser");
            return (Criteria) this;
        }

        public Criteria andMdateIsNull() {
            addCriterion("MDATE is null");
            return (Criteria) this;
        }

        public Criteria andMdateIsNotNull() {
            addCriterion("MDATE is not null");
            return (Criteria) this;
        }

        public Criteria andMdateEqualTo(Integer value) {
            addCriterion("MDATE =", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotEqualTo(Integer value) {
            addCriterion("MDATE <>", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateGreaterThan(Integer value) {
            addCriterion("MDATE >", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("MDATE >=", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateLessThan(Integer value) {
            addCriterion("MDATE <", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateLessThanOrEqualTo(Integer value) {
            addCriterion("MDATE <=", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateIn(List<Integer> values) {
            addCriterion("MDATE in", values, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotIn(List<Integer> values) {
            addCriterion("MDATE not in", values, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateBetween(Integer value1, Integer value2) {
            addCriterion("MDATE between", value1, value2, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotBetween(Integer value1, Integer value2) {
            addCriterion("MDATE not between", value1, value2, "mdate");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNull() {
            addCriterion("MTIME is null");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNotNull() {
            addCriterion("MTIME is not null");
            return (Criteria) this;
        }

        public Criteria andMtimeEqualTo(Integer value) {
            addCriterion("MTIME =", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotEqualTo(Integer value) {
            addCriterion("MTIME <>", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThan(Integer value) {
            addCriterion("MTIME >", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MTIME >=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThan(Integer value) {
            addCriterion("MTIME <", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThanOrEqualTo(Integer value) {
            addCriterion("MTIME <=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeIn(List<Integer> values) {
            addCriterion("MTIME in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotIn(List<Integer> values) {
            addCriterion("MTIME not in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeBetween(Integer value1, Integer value2) {
            addCriterion("MTIME between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("MTIME not between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andEattribute1IsNull() {
            addCriterion("EATTRIBUTE1 is null");
            return (Criteria) this;
        }

        public Criteria andEattribute1IsNotNull() {
            addCriterion("EATTRIBUTE1 is not null");
            return (Criteria) this;
        }

        public Criteria andEattribute1EqualTo(String value) {
            addCriterion("EATTRIBUTE1 =", value, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1NotEqualTo(String value) {
            addCriterion("EATTRIBUTE1 <>", value, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1GreaterThan(String value) {
            addCriterion("EATTRIBUTE1 >", value, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1GreaterThanOrEqualTo(String value) {
            addCriterion("EATTRIBUTE1 >=", value, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1LessThan(String value) {
            addCriterion("EATTRIBUTE1 <", value, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1LessThanOrEqualTo(String value) {
            addCriterion("EATTRIBUTE1 <=", value, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1Like(String value) {
            addCriterion("EATTRIBUTE1 like", value, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1NotLike(String value) {
            addCriterion("EATTRIBUTE1 not like", value, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1In(List<String> values) {
            addCriterion("EATTRIBUTE1 in", values, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1NotIn(List<String> values) {
            addCriterion("EATTRIBUTE1 not in", values, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1Between(String value1, String value2) {
            addCriterion("EATTRIBUTE1 between", value1, value2, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andEattribute1NotBetween(String value1, String value2) {
            addCriterion("EATTRIBUTE1 not between", value1, value2, "eattribute1");
            return (Criteria) this;
        }

        public Criteria andUserstatIsNull() {
            addCriterion("USERSTAT is null");
            return (Criteria) this;
        }

        public Criteria andUserstatIsNotNull() {
            addCriterion("USERSTAT is not null");
            return (Criteria) this;
        }

        public Criteria andUserstatEqualTo(String value) {
            addCriterion("USERSTAT =", value, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatNotEqualTo(String value) {
            addCriterion("USERSTAT <>", value, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatGreaterThan(String value) {
            addCriterion("USERSTAT >", value, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatGreaterThanOrEqualTo(String value) {
            addCriterion("USERSTAT >=", value, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatLessThan(String value) {
            addCriterion("USERSTAT <", value, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatLessThanOrEqualTo(String value) {
            addCriterion("USERSTAT <=", value, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatLike(String value) {
            addCriterion("USERSTAT like", value, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatNotLike(String value) {
            addCriterion("USERSTAT not like", value, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatIn(List<String> values) {
            addCriterion("USERSTAT in", values, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatNotIn(List<String> values) {
            addCriterion("USERSTAT not in", values, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatBetween(String value1, String value2) {
            addCriterion("USERSTAT between", value1, value2, "userstat");
            return (Criteria) this;
        }

        public Criteria andUserstatNotBetween(String value1, String value2) {
            addCriterion("USERSTAT not between", value1, value2, "userstat");
            return (Criteria) this;
        }

        public Criteria andLoginresIsNull() {
            addCriterion("LOGINRES is null");
            return (Criteria) this;
        }

        public Criteria andLoginresIsNotNull() {
            addCriterion("LOGINRES is not null");
            return (Criteria) this;
        }

        public Criteria andLoginresEqualTo(String value) {
            addCriterion("LOGINRES =", value, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresNotEqualTo(String value) {
            addCriterion("LOGINRES <>", value, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresGreaterThan(String value) {
            addCriterion("LOGINRES >", value, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresGreaterThanOrEqualTo(String value) {
            addCriterion("LOGINRES >=", value, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresLessThan(String value) {
            addCriterion("LOGINRES <", value, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresLessThanOrEqualTo(String value) {
            addCriterion("LOGINRES <=", value, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresLike(String value) {
            addCriterion("LOGINRES like", value, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresNotLike(String value) {
            addCriterion("LOGINRES not like", value, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresIn(List<String> values) {
            addCriterion("LOGINRES in", values, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresNotIn(List<String> values) {
            addCriterion("LOGINRES not in", values, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresBetween(String value1, String value2) {
            addCriterion("LOGINRES between", value1, value2, "loginres");
            return (Criteria) this;
        }

        public Criteria andLoginresNotBetween(String value1, String value2) {
            addCriterion("LOGINRES not between", value1, value2, "loginres");
            return (Criteria) this;
        }

        public Criteria andLogindateIsNull() {
            addCriterion("LOGINDATE is null");
            return (Criteria) this;
        }

        public Criteria andLogindateIsNotNull() {
            addCriterion("LOGINDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLogindateEqualTo(Integer value) {
            addCriterion("LOGINDATE =", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateNotEqualTo(Integer value) {
            addCriterion("LOGINDATE <>", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateGreaterThan(Integer value) {
            addCriterion("LOGINDATE >", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOGINDATE >=", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateLessThan(Integer value) {
            addCriterion("LOGINDATE <", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateLessThanOrEqualTo(Integer value) {
            addCriterion("LOGINDATE <=", value, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateIn(List<Integer> values) {
            addCriterion("LOGINDATE in", values, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateNotIn(List<Integer> values) {
            addCriterion("LOGINDATE not in", values, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateBetween(Integer value1, Integer value2) {
            addCriterion("LOGINDATE between", value1, value2, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogindateNotBetween(Integer value1, Integer value2) {
            addCriterion("LOGINDATE not between", value1, value2, "logindate");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNull() {
            addCriterion("LOGINTIME is null");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNotNull() {
            addCriterion("LOGINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimeEqualTo(Integer value) {
            addCriterion("LOGINTIME =", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotEqualTo(Integer value) {
            addCriterion("LOGINTIME <>", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThan(Integer value) {
            addCriterion("LOGINTIME >", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOGINTIME >=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThan(Integer value) {
            addCriterion("LOGINTIME <", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThanOrEqualTo(Integer value) {
            addCriterion("LOGINTIME <=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeIn(List<Integer> values) {
            addCriterion("LOGINTIME in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotIn(List<Integer> values) {
            addCriterion("LOGINTIME not in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeBetween(Integer value1, Integer value2) {
            addCriterion("LOGINTIME between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOGINTIME not between", value1, value2, "logintime");
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