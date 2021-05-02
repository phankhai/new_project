package com.example.demo.common.specification;

import com.example.demo.builder.FilterCriteria;
import com.example.demo.constants.enums.ConditionType;
import com.example.demo.constants.enums.CriteriaOperation;
import com.example.demo.constants.enums.RelationType;

public class ComparableFilterCriteria <T extends Comparable<? super T>> extends FilterCriteria<T> {
    ComparableFilterCriteria(String key, T value, CriteriaOperation operation, Class<T> clazz, ConditionType conditionType) {
        super(key, value, operation, clazz, conditionType);
    }

    public ComparableFilterCriteria(String key, T value, CriteriaOperation operation, Class<T> clazz, RelationType relationType, ConditionType conditionType) {
        super(key, value, operation, clazz, relationType, conditionType);
    }
}
