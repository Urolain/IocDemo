package chap7;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import utils.MapUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Aspect
@Component
public class MethodMeasureAspect {

    private Map<String, Integer> methodCount = new ConcurrentHashMap();

    private Map<String, List<Integer>> methodCost = new ConcurrentHashMap();

    @SuppressWarnings(value = "unchecked")
    @Around("@annotation(chap7.MethodMeasureAnnotation)")
    public Object process(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = className + "_" + getMethodName(joinPoint);
        long startTime = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed();
        } catch (Throwable t) {
//            logger.error(t.getMessage(), t);
            System.out.println(t.getMessage());
        } finally {
            long costTime = System.currentTimeMillis() - startTime;
//            logger.info("method={}, cost_time={}", methodName, costTime);
            System.out.println("method={"+methodName+"}, cost_time={"+costTime+"}");
            methodCount.put(methodName, methodCount.getOrDefault(methodName, 0) + 1);
            List<Integer> costList = methodCost.getOrDefault(methodName, new ArrayList<>());
            costList.add((int)costTime);
            methodCost.put(methodName, costList);
        }
        return obj;
    }

    public String getMethodName(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        return method.getName();
    }

    public String toString() {

        StringBuilder sb = new StringBuilder("MethodCount:\n");
        Map<String,Integer> sorted =  MapUtil.sortByValue(methodCount);
        sorted.forEach(
                (method, count) -> {
                    sb.append("method=" + method + ", " + "count=" + count+'\n');
                }
        );
        sb.append('\n');
        sb.append("MethodCosts:\n");
        methodCost.forEach(
                (method, costList) -> {
                    IntSummaryStatistics stat = costList.stream().collect(Collectors.summarizingInt(x->x));
                    String info = String.format("method=%s, sum=%d, avg=%d, max=%d, min=%d, count=%d", method,
                            (int)stat.getSum(), (int)stat.getAverage(), stat.getMax(), stat.getMin(), (int)stat.getCount());
                    sb.append(info+'\n');
                }
        );

        sb.append('\n');
        sb.append("DetailOfMethodCosts:\n");
        methodCost.forEach(
                (method, costList) -> {
                    String info = String.format("method=%s, cost=%s", method, costList);
                    sb.append(info+'\n');
                }
        );
        return sb.toString();
    }
}
