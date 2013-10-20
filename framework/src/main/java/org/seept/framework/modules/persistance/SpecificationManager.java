package org.seept.framework.modules.persistance;

import org.apache.commons.lang3.StringUtils;
import org.seept.framework.core.util.QueryUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Collection;
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

                    for(ParametersFilter filter : parametersFilters) {
                        //String[] names = StringUtils.split(filter.fieldName,".");
                        //Path expression =  tRoot.get(names[0]);
                    }
                }
                return criteriaBuilder.conjunction();
            }
        };
    }


}
