package starter.springweb.web.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import starter.springweb.web.controller.PageRequest;
import starter.springweb.web.controller.PageSort;
import starter.springweb.web.controller.Sorts;

import java.util.StringTokenizer;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/08/10
 */

public class PageRequestArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(PageRequest.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        int count = getCount(webRequest);
        int startIndex = getStartIndex(webRequest);
        PageSort pageSort = getPageSort(webRequest);
        if (pageSort == null) {
            return PageRequest.of(count, startIndex);
        }
        return PageRequest.of(count, startIndex, pageSort);
    }

    private int getCount(NativeWebRequest webRequest) {
        String[] counts = webRequest.getParameterMap().get("count");
        return counts == null ? PageRequest.DEFAULT_COUNT : Integer.parseInt(counts[0]);
    }

    private int getStartIndex(NativeWebRequest webRequest) {
        String[] startIndices = webRequest.getParameterMap().get("start_index");
        return startIndices == null ? PageRequest.DEFAULT_START_INDEX : Integer.parseInt(startIndices[0]);
    }

    private PageSort getPageSort(NativeWebRequest webRequest) {
        String[] sortBies = webRequest.getParameterMap().get("sort_by");
        if (sortBies == null) {
            return PageSort.noSort();
        }

        StringTokenizer tokenizer = new StringTokenizer(sortBies[0], ",");
        String sortKey = tokenizer.nextToken();
        String sortValue = tokenizer.nextToken();

        return PageSort.of(sortKey, Sorts.getMatchingSorts(sortValue));
    }
}
