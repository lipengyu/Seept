package org.seept.framework.modules.persistance;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author : lihaoquan
 *
 * Http参数过滤器
 */
public class ParametersFilter {

    public enum Operator {
        EQ, LIKE, GT, LT, GTE, LTE
    }

    public String fieldName;
    public Object value;
    public Operator operator;


    public ParametersFilter(String fieldName, Operator operator, Object value) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }

    /**
     * 参数解析
     * @param paramsMap
     * @return
     */
    public static List<ParametersFilter> parse(Map<String,Object> paramsMap) {
        List<ParametersFilter> searchInfos = Lists.newArrayList();
        for(Map.Entry<String,Object> entry : paramsMap.entrySet()) {
            // 过滤掉空值
            String key = entry.getKey();
            Object value = entry.getValue();
            if (StringUtils.isBlank((String) value)) {
                continue;
            }
            // 拆分operator与filedAttribute
            String[] names = StringUtils.split(key, "_");
            if (names.length != 2) {
                throw new IllegalArgumentException(key + " is not a valid search filter name");
            }
            String filedName = names[1];
            Operator operator = Operator.valueOf(names[0]);

            // 创建searchFilter
            ParametersFilter filter = new ParametersFilter(filedName, operator, value);

            searchInfos.add(filter);
        }
        return searchInfos;
    }
}
