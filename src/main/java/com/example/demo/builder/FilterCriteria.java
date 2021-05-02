package com.example.demo.builder;

import com.example.demo.constants.enums.ConditionType;
import com.example.demo.constants.enums.CriteriaOperation;
import com.example.demo.constants.enums.JoinType;
import com.example.demo.constants.enums.RelationType;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterCriteria<T> {

    @NonNull
    private String key;
    private List<String> keys = new ArrayList();
    private final T value;
    @NonNull
    private final CriteriaOperation operation;
    private final JoinType joinType;
    private final Class<T> clazz;
    private final RelationType relationType;
    private final ConditionType conditionType;
    private final boolean caseSensitive = false;

    public FilterCriteria(CriteriaOperation operation, JoinType joinType, Class<T> clazz, ConditionType conditionType, String... keys) {
        this.keys = Arrays.asList(keys);
        this.operation = operation;
        this.joinType = joinType;
        this.clazz = clazz;
        this.value = null;
        this.relationType = RelationType.NO_RELATION;
        this.conditionType = conditionType;
    }

    public FilterCriteria(String key, T value, CriteriaOperation operation, Class<T> clazz, ConditionType conditionType) {
        this.key = key;
        this.value = value;
        this.operation = operation;
        this.joinType = null;
        this.clazz = clazz;
        this.relationType = RelationType.NO_RELATION;
        this.conditionType = conditionType;
    }

    public FilterCriteria(String key, T value, CriteriaOperation operation, Class<T> clazz, RelationType relationType, ConditionType conditionType) {
        this.key = key;
        this.value = value;
        this.operation = operation;
        this.joinType = null;
        this.clazz = clazz;
        this.relationType = relationType;
        this.conditionType = conditionType;
    }

    public FilterCriteria(String key, CriteriaOperation operation, JoinType joinType, Class<T> clazz, ConditionType conditionType) {
        this.key = key;
        this.operation = operation;
        this.joinType = joinType;
        this.clazz = clazz;
        this.value = null;
        this.relationType = RelationType.NO_RELATION;
        this.conditionType = conditionType;
    }

    @NonNull
    public String getKey() {
        return this.key;
    }

    public List<String> getKeys() {
        return this.keys;
    }

    public T getValue() {
        return this.value;
    }

    @NonNull
    public CriteriaOperation getOperation() {
        return this.operation;
    }

    public JoinType getJoinType() {
        return this.joinType;
    }

    public Class<T> getClazz() {
        return this.clazz;
    }

    public RelationType getRelationType() {
        return this.relationType;
    }

    public ConditionType getConditionType() {
        return this.conditionType;
    }

    public boolean isCaseSensitive() {
        this.getClass();
        return false;
    }

    public void setKey(@NonNull final String key) {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        } else {
            this.key = key;
        }
    }

    public void setKeys(final List<String> keys) {
        this.keys = keys;
    }

}
