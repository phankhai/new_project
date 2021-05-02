package com.example.demo.builder;

import com.example.demo.common.specification.ComparableFilterCriteria;
import com.example.demo.constants.enums.ConditionType;
import com.example.demo.constants.enums.CriteriaOperation;
import com.example.demo.constants.enums.JoinType;
import com.example.demo.constants.enums.RelationType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.*;

public class GenericSpecificationBuilder<E> {

    private final List<FilterCriteria<?>> filterCriteriaList = new ArrayList();
    private final List<Specification<E>> specifications = new ArrayList();
    private final Map<Specification<E>, ConditionType> customSpecifications;
    private final List<Map<String, String>> parameters = new ArrayList();
    private ConditionType activeConditionType;

    private GenericSpecificationBuilder() {
        this.activeConditionType = ConditionType.AND;
        this.customSpecifications = new HashMap();
    }

        public static <E> GenericSpecificationBuilder<E> of(Class<E> clazz) {
        if (Number.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Only entities allowed.");
        } else {
            return new GenericSpecificationBuilder();
        }
    }

        private GenericSpecificationBuilder<E> addCriteria(CriteriaOperation operation, String... keys) {
        this.filterCriteriaList.add(new FilterCriteria(operation, (JoinType)null, Void.class, this.activeConditionType, keys));
        return this;
    }

        private GenericSpecificationBuilder<E> addCriteria(String key, CriteriaOperation operation) {
        this.filterCriteriaList.add(new FilterCriteria(key, operation, (JoinType)null, Void.class, this.activeConditionType));
        return this;
    }

        private GenericSpecificationBuilder<E> addCriteria(String key, CriteriaOperation operation, JoinType joinType) {
        this.filterCriteriaList.add(new FilterCriteria(key, operation, joinType, Void.class, this.activeConditionType));
        return this;
    }

        private <C> GenericSpecificationBuilder<E> addCriteria(String key, C value, CriteriaOperation operation, RelationType relationType) {
        if (value != null) {
            this.filterCriteriaList.add(new FilterCriteria(key, value, operation, value.getClass(), relationType, this.activeConditionType));
        }

        return this;
    }

        private <C extends Comparable<? super C>> GenericSpecificationBuilder<E> addComparableCriteria(String key, C value, CriteriaOperation operation, RelationType relationType) {
        if (value != null) {
            this.filterCriteriaList.add(new ComparableFilterCriteria(key, value, operation, value.getClass(), relationType, this.activeConditionType));
        }
        return this;
    }

        public GenericSpecificationBuilder<E> or() {
        this.activeConditionType = ConditionType.OR;
        return this;
    }

        public GenericSpecificationBuilder<E> and() {
        this.activeConditionType = ConditionType.AND;
        return this;
    }

        public GenericSpecificationBuilder<E> groupBy(String... groupKeys) {
        return this.addCriteria(CriteriaOperation.GROUP_BY, groupKeys);
    }

        public GenericSpecificationBuilder<E> select(String... selectKey) {
        return this.addCriteria(CriteriaOperation.SELECT, selectKey);
    }

        public GenericSpecificationBuilder<E> join(String key) {
        return this.addCriteria(key, CriteriaOperation.JOIN, JoinType.INNER);
    }

        public GenericSpecificationBuilder<E> join(String key, JoinType joinType) {
        return this.addCriteria(key, CriteriaOperation.JOIN, joinType);
    }

        public GenericSpecificationBuilder<E> joinFetch(String key) {
        return this.addCriteria(key, CriteriaOperation.JOIN_FETCH, JoinType.INNER);
    }

        public GenericSpecificationBuilder<E> joinFetch(String key, JoinType joinType) {
        return this.addCriteria(key, CriteriaOperation.JOIN_FETCH, joinType);
    }

        public GenericSpecificationBuilder<E> equals(String key, Object value) {
        return this.addCriteria(key, value, CriteriaOperation.EQUAL, RelationType.NO_RELATION);
    }

        public GenericSpecificationBuilder<E> equals(String key, Object value, RelationType relationType) {
        return this.addCriteria(key, value, CriteriaOperation.EQUAL, relationType);
    }

        public GenericSpecificationBuilder<E> like(String key, Object value) {
        return this.addCriteria(key, value, CriteriaOperation.LIKE, RelationType.NO_RELATION);
    }

        public GenericSpecificationBuilder<E> like(String key, Object value, RelationType relationType) {
        return this.addCriteria(key, value, CriteriaOperation.LIKE, relationType);
    }

        public GenericSpecificationBuilder<E> isNull(String key) {
        return this.addCriteria(key, CriteriaOperation.IS_NULL);
    }

        public GenericSpecificationBuilder<E> isNotNull(String key) {
        return this.addCriteria(key, CriteriaOperation.IS_NOT_NULL);
    }

        public GenericSpecificationBuilder<E> in(String key, Object value) {
        return this.addCriteria(key, value, CriteriaOperation.IN, RelationType.NO_RELATION);
    }

        public GenericSpecificationBuilder<E> in(String key, Object value, RelationType relationType) {
        return this.addCriteria(key, value, CriteriaOperation.IN, relationType);
    }

        public <C extends Comparable<? super C>> GenericSpecificationBuilder<E> lessThan(String key, C value) {
        return this.addComparableCriteria(key, value, CriteriaOperation.LESS_THAN, RelationType.NO_RELATION);
    }

        public <C extends Comparable<? super C>> GenericSpecificationBuilder<E> lessThan(String key, C value, RelationType relationType) {
        return this.addComparableCriteria(key, value, CriteriaOperation.LESS_THAN, relationType);
    }

        public <C extends Comparable<? super C>> GenericSpecificationBuilder<E> lessThanOrEqualTo(String key, C value) {
        return this.addComparableCriteria(key, value, CriteriaOperation.LESS_THAN_OR_EQUAL_TO, RelationType.NO_RELATION);
    }

        public <C extends Comparable<? super C>> GenericSpecificationBuilder<E> lessThanOrEqualTo(String key, C value, RelationType relationType) {
        return this.addComparableCriteria(key, value, CriteriaOperation.LESS_THAN_OR_EQUAL_TO, relationType);
    }

        public <C extends Comparable<? super C>> GenericSpecificationBuilder<E> greaterThan(String key, C value) {
        return this.addComparableCriteria(key, value, CriteriaOperation.GREATER_THAN, RelationType.NO_RELATION);
    }

        public <C extends Comparable<? super C>> GenericSpecificationBuilder<E> greaterThan(String key, C value, RelationType relationType) {
        return this.addComparableCriteria(key, value, CriteriaOperation.GREATER_THAN, relationType);
    }

        public <C extends Comparable<? super C>> GenericSpecificationBuilder<E> greaterThanOrEqualTo(String key, C value) {
        return this.addComparableCriteria(key, value, CriteriaOperation.GREATER_THAN_OR_EQUAL_TO, RelationType.NO_RELATION);
    }

        public <C extends Comparable<? super C>> GenericSpecificationBuilder<E> greaterThanOrEqualTo(String key, C value, RelationType relationType) {
        return this.addComparableCriteria(key, value, CriteriaOperation.GREATER_THAN_OR_EQUAL_TO, relationType);
    }

        public GenericSpecificationBuilder<E> custom(Specification<E> specification) {
        this.customSpecifications.put(specification, this.activeConditionType);
        return this;
    }

    /*
        public GenericSpecificationBuilder<E> customFunction(String functionName, String[] fieldNames, String... params) {
        int functionIndex = this.parameters.size();
        HashMap<String, String> parameterMap = new HashMap();
        this.parameters.add(parameterMap);
        List<Specification<E>> specifications = new ArrayList();
        String[] var7 = fieldNames;
        int i = fieldNames.length;

        for(int var9 = 0; var9 < i; ++var9) {
            String fieldName = var7[var9];
            Specification<E> fieldSpecification = (root, query, criteriaBuilder) -> {
                int parameterIndex = 0;
                List<Expression<String>> parameterExpressions = new ArrayList();
                String[] columns;
                if (fieldName.contains(".")) {
                    columns = fieldName.split("\\.");
                    Join<E, ?> joinedTable = root.join(columns[0], JoinType.LEFT);
                    Path<String> path = joinedTable.get(columns[1]);

                    for(int i = 2; i < columns.length; ++i) {
                        path = path.get(columns[i]);
                    }

                    parameterExpressions.add(path);
                } else {
                    parameterExpressions.add(root.get(fieldName));
                }

                columns = params;
                int var17 = params.length;

                for(int var19 = 0; var19 < var17; ++var19) {
                    String param = columns[var19];
                    String paramsName = "function" + functionIndex + "_param" + parameterIndex + "_" + StringUtils.deleteAny(UUID.randomUUID().toString(), "-");
                    parameterMap.put(paramsName, param);
                    ParameterExpression<String> parameterExpression = criteriaBuilder.parameter(String.class, paramsName);
                    ++parameterIndex;
                    parameterExpressions.add(parameterExpression);
                }

                Expression<?>[] parameters = (Expression[])parameterExpressions.toArray(new Expression[0]);
                Expression<Boolean> sqlFunction = criteriaBuilder.function(functionName, Boolean.class, parameters);
                return criteriaBuilder.equal(sqlFunction, "");
            };
            specifications.add(fieldSpecification);
        }

        Specification<E> specificationResult = (Specification)specifications.get(0);

        for(i = 1; i < specifications.size(); ++i) {
            specificationResult = Specification.where(specificationResult).or((Specification)specifications.get(i));
        }

        this.custom(specificationResult);
        return this;
    }

    public Specification<E> build() {
        if (this.filterCriteriaList.size() == 0 && this.customSpecifications.isEmpty()) {
            return null;
        } else {
            Specification<E> andSpecs = null;
            Specification<E> orSpecs = null;
            Iterator var3 = this.filterCriteriaList.iterator();

            while(var3.hasNext()) {
                FilterCriteria<?> filterCriteria = (FilterCriteria)var3.next();
                Specification<E> specification = new GenericSpecification(filterCriteria);
                if (filterCriteria.getConditionType().equals(ConditionType.AND)) {
                    andSpecs = Specification.where(andSpecs).and(specification);
                } else {
                    orSpecs = Specification.where(orSpecs).or(specification);
                }
            }

            var3 = this.customSpecifications.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<Specification<E>, ConditionType> specificationConditionTypeEntry = (Map.Entry)var3.next();
                if (((ConditionType)specificationConditionTypeEntry.getValue()).equals(ConditionType.AND)) {
                    andSpecs = Specification.where(andSpecs).and((Specification)specificationConditionTypeEntry.getKey());
                } else {
                    orSpecs = Specification.where(orSpecs).or((Specification)specificationConditionTypeEntry.getKey());
                }
            }

            Specification<E> specificationResult = Specification.where(andSpecs).and(orSpecs);
            return new GenericSpecificationContainer(specificationResult, this.parameters);
        }
    }
 */
}
