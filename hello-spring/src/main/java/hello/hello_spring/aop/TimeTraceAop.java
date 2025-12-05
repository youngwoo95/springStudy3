package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // AOP 적용
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hello_spring..*(..))") // 패키지 명
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString()); // 호출한 메서드 이름

        try {
            return joinPoint.proceed(); // 다음 메서드로 진행
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
