package org.seept.framework.modules.persistance;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.seept.framework.core.util.QueryUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author : lihaoquan
 *
 * Spring Data Sprcification管理器
 */
public class SpecificationManager {


    public static<T> Specification<T> buildSpecification(final Collection<ParametersFilter> parametersFilters,
        final Class<T> clazz) {

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> tRoot, CriteriaQuery<?> criteriaQuery,
                CriteriaBuilder criteriaBuilder) {

                if(QueryUtil.isNotEmpty(parametersFilters)) {

                    List<Predicate> predicates = Lists.newArrayList();
                    for(ParametersFilter filter : parametersFilters) {

                        String[] nameArray = StringUtils.split(filter.fieldName,".");
                        Path expression = tRoot.get(nameArray[0]);

                        for(int i = 1; i< nameArray.length;i++) {
                            expression = expression.get(nameArray[i]);
                        }

                        //predicates.add(criteriaBuilder.equal(expression,filter.value));

                        /**
                         * 处理逻辑操作
                         */
                        switch (filter.operator) {
                            case EQ:
                                predicates.add(criteriaBuilder.equal(expression,filter.value));
                                break;
                            case LIKE:
                                predicates.add(criteriaBuilder.like(expression,"%"+filter.value+"%"));
                                break;
                            case GT:
                                predicates.add(criteriaBuilder.greaterThan(expression, (Comparable) filter.value));
                                break;
                            case LT:
                                predicates.add(criteriaBuilder.lessThan(expression, (Comparable) filter.value));
                                break;
                            case GTE:
                                predicates.add(criteriaBuilder.greaterThanOrEqualTo(expression, (Comparable) filter.value));
                                break;
                            case LTE:
                                predicates.add(criteriaBuilder.lessThanOrEqualTo(expression, (Comparable) filter.value));
                                break;
                        }
                    }
                    if (predicates.size() > 0) {
                        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                    }
                }
                return criteriaBuilder.conjunction();
            }
        };
    }


}
